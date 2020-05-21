using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.Text;
using System.IO;
using Delegates;
//using Logger;
using NewLogger;

namespace ChatLibrary
{
    /// <summary>
    /// Main ChatLibrary Class for all the functionality
    /// </summary>
    public class ChatMasterClass
    {
        // Thread signals.
        protected static ManualResetEvent connectDone;
        private static ManualResetEvent sendDone;
        private static ManualResetEvent receiveDone;

        public int port;
        public string address;
        public Socket Handler;
        public string messagesent;
        public string messagereceived;
        public ILoggingService logger;

        //Delegates and event handler
        public delegate void MessageSentEventHandler(EventArgs args);
        public event MessageSentEventHandler Sent;
        public event MessageReceivedEventHandler Received;

        //Default constructor for Chat class
        public ChatMasterClass(string address, int port, ILoggingService loggable)
        {
            connectDone = new ManualResetEvent(false);
            sendDone = new ManualResetEvent(false);
            receiveDone = new ManualResetEvent(false);
            this.address = address;
            this.port = port;
            messagesent = "";
            messagereceived = "";
            logger = loggable;
        }

        //Event handlers for message sent
        public void OnMessageSent(EventArgs args)
        {
            if (Sent != null)
            {
                Sent(EventArgs.Empty);
            }
        }

        //Event handlers for message received
        public void OnMessageReceived(EventArgs args)
        {
            if (Received != null)
            {
                Received(EventArgs.Empty);
            }
        }
        //-------------------------------------------------------------------------------------Log message -------------------------------------------------------------------------
        //public void namenewlogfile()
        //{
        //    TextFileLogger.Filename = createFile();
        //}


        //public void createFile()
        //{
        //    int num = 0;
        //    string Filename = "log";
        //    while (File.Exists(Filename + ".txt"))
        //    {
        //        num++;
        //        Filename = "log" + num.ToString();
        //    }
        //    Filename = Filename + ".txt";
        //    FileStream fs = File.Create(Filename);
        //    //TextFileLogger.Filename = Filename;
        //}

        //Method to log error messages
        public void AddLogerror(string message)
        {
            while (true)
            {
                try
                {
                    using (StreamWriter w = File.AppendText("logerror.txt"))
                    {
                        if (message != "")
                        {
                            w.Write($"{DateTime.Now.ToLongTimeString()} {DateTime.Now.ToLongDateString()}");
                            w.Write("  :");
                            w.Write($"  :");
                            w.Write(message);
                            w.Write(Environment.NewLine);
                        }
                    }
                    break;
                }
                catch (Exception e)
                {
                    Console.WriteLine("Error logging Error messages");
                }
            }
        }

        //Create a new thread to write sent messages in a log file
        public void writesentmessage(EventArgs args)
        {
            Thread Loggingsent = new Thread(new ThreadStart(Logthemessagesent));
            Loggingsent.Start();
        }

        //Log sent messages
        public void Logthemessagesent()
        {
            if(messagesent!="")
            {
                logger.Log(">> " + messagesent);
            }            
        }

        //Create a new thread to write received messages in a log file
        public void writereceivedmessage(EventArgs args)
        {
            Thread Loggingreceived = new Thread(new ThreadStart(Logthemessagereceived));
            Loggingreceived.Start();
        }

        //Log received messages
        public void Logthemessagereceived()
        {
            logger.Log("Server: " + messagereceived);
        }

//-------------------------------------------------------------------------------------Log message -------------------------------------------------------------------------

        public void Receive(Socket handler)
        {
            receiveDone.Reset();
            try
            {
                // Create the state object.  
                StateObject state = new StateObject();
                state.workSocket = handler;

                // Begin receiving the data from the remote device.  
                handler.BeginReceive(state.buffer, 0, StateObject.BufferSize, 0, new AsyncCallback(ReceiveCallback), state);

                receiveDone.WaitOne();

                //Broadcast the message sent event
                OnMessageReceived(EventArgs.Empty);
            }
            catch (Exception e)
            {
                AddLogerror(e.ToString());
            }
        }

        private void ReceiveCallback(IAsyncResult ar)
        {
            try
            {
                messagereceived = String.Empty;
                // Retrieve the state object and the client socket from the asynchronous state object.  
                StateObject state = (StateObject)ar.AsyncState;
                Socket handler = state.workSocket;

                // Read data from the remote device.
                int bytesRead = handler.EndReceive(ar);

                if (bytesRead > 0)
                {
                    state.sb.Append(Encoding.ASCII.GetString(state.buffer, 0, bytesRead));
                    //handler.BeginReceive(state.buffer, 0, StateObject.BufferSize, 0, new AsyncCallback(ReceiveCallback), state);
                    if (state.sb.Length > 0)
                    {
                        messagereceived = state.sb.ToString();
                    }
                    else
                    {
                        messagereceived = "No data Received";
                    }
                }
                else
                {
                    messagereceived = "Server connection unavailable";
                }
            }
            catch (Exception e)
            {
                AddLogerror(e.ToString());
                messagereceived = "Server connection unavailable";
            }

            // Signal that all bytes have been received.
            receiveDone.Set();
        }

        public void Send(Socket handler)
        {
            sendDone.Reset();
            try
            {
                // Convert the string data to byte data using ASCII encoding.  
                byte[] byteData = Encoding.ASCII.GetBytes(messagesent);

                // Begin sending the data to the remote device.  
                handler.BeginSend(byteData, 0, byteData.Length, 0, new AsyncCallback(SendCallback), handler);

                //Thread wait until connection is set
                sendDone.WaitOne();

                //Broadcast the message sent event
                OnMessageSent(EventArgs.Empty);
            }
            catch (Exception e)
            {
                AddLogerror(e.ToString());
            }
        }

        public void SendCallback(IAsyncResult ar)
        {
            try
            {
                // Retrieve the socket from the state object.  
                Socket handler = (Socket)ar.AsyncState;

                // Complete sending the data to the remote device.  
                int bytesSent = handler.EndSend(ar);
            }
            catch (Exception e)
            {
                AddLogerror(e.ToString());
            }
            sendDone.Set();
        }
    }
}
