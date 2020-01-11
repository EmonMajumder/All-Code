using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.Text;
using System.IO;
namespace AsynchronousChat
{
    public class ChatMasterClass
    {
        // Thread signal.
        protected static ManualResetEvent connectDone;
        private static ManualResetEvent sendDone;
        private static ManualResetEvent receiveDone;
        public int port;
        public string address;
        public Socket Handler;
        public bool isconnected;
        public string messagesent;
        public string messagereceived;
        public Logfile logging ;


        public delegate void MessageSentEventHandler(string s);
        public event MessageSentEventHandler Sent;
        public event MessageReceivedEventHandler Received;

        public void OnMessageSent(string msgsent)
        {
            if (Sent != null)
            {
                Sent(msgsent);
            }
        }
        
        public void OnMessageReceived(string msgrcv)
        {
            if (Received != null)
            {
                Received(msgrcv);
            }
        }
        public void namenewlogfile()
        {
            Logfile.Filename = logging.createFile();
        }

        public void writesentmessage(string msg)
        {
            logging.AddLog(">> "+ msg);          
        }

        public void writereceivedmessage(string msg)
        {

            logging.AddLog("Server: " + msg);                            
        }

        public void closeSocket(Socket sck)
        {
            // Release the socket.
            sck.Shutdown(SocketShutdown.Both);
            sck.Close();
        }

        public ChatMasterClass(string address, int port)
        {
            connectDone = new ManualResetEvent(false);
            sendDone = new ManualResetEvent(false);
            receiveDone = new ManualResetEvent(false);
            this.address = address;
            this.port = port;
            isconnected = false;
            messagesent = "";
            messagereceived = "";
            logging = new Logfile();
        }

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
                OnMessageReceived(messagereceived);
            }
            catch (Exception e)
            {
                logging.AddLogerror(e.ToString());               
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
                int bytesRead = handler.EndReceive(ar);
                

                // Read data from the remote device.  
                
                if (bytesRead > 0)
                {
                    state.sb.Append(Encoding.ASCII.GetString(state.buffer, 0, bytesRead));
                    handler.BeginReceive(state.buffer, 0, StateObject.BufferSize, 0, new AsyncCallback(ReceiveCallback), state);
                    messagereceived = state.sb.ToString();
                }
                else
                {
                    if (state.sb.Length > 1)
                    {
                        messagereceived = state.sb.ToString();
                    }
                }
            }
            catch (Exception e)
            {

                 logging.AddLogerror(e.ToString());
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

                sendDone.WaitOne();
                OnMessageSent(messagesent);
            }
            catch (Exception e)
            {
                logging.AddLogerror(e.ToString());
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
                logging.AddLogerror(e.ToString());
            }
            sendDone.Set();
        }
    }
}
