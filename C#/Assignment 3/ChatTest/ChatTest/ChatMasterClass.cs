using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.Text;

namespace ChatTest
{
    public class ChatMasterClass
    {
        // Thread signal.  
        public static ManualResetEvent connectDone;
        public static ManualResetEvent sendDone;
        public static ManualResetEvent receiveDone;
        public int port;
        public string address;
        public Socket Handler;
        public bool isconnected;
        public string messagesent;
        public string messagereceived;

        public void ProcessClientfromServer(object argument)
        {      
            messagereceived = "";
            messagesent = "";
            Thread msgsnd;
            Thread msgrcv;
            while (true)
            {
                Receive(Handler);

                if (messagereceived != "Quit" && messagereceived != "quit" || messagereceived != "")
                {
                    Console.WriteLine("Client: {0}", messagereceived);

                    Send(Handler);                    

                    if (messagesent == "Quit" || messagesent == "quit")
                    {
                        msgrcv.Suspend();
                        msgsnd.Suspend();
                        break;
                    }
                }
                else
                {
                    msgrcv.Suspend();
                    msgsnd.Suspend();
                    break;
                }
            }
            Handler.Shutdown(SocketShutdown.Both);
            Handler.Close();
        }

        public void ProcessServerfromClient(object argument)
        {
            Socket handlert = (Socket)argument;
            messagesent = "";
            while (messagesent != "Quit" && messagesent != "quit")
            {
                // Send test data to the remote device.  
                Send(handlert);
                Thread.Sleep(100);

                if(messagesent != "Quit" && messagesent != "quit")
                {
                    // Receive the response from the remote device.
                    Console.Write("Server: ");
                    Console.WriteLine(Receive(handlert));
                    Thread.Sleep(100);
                }                                  
            }
            closeSocket(handlert);
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
            this.port = port;
            this.address = address;
            isconnected = false;
            messagesent = "";
            messagereceived = "";
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
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
        }

        private void ReceiveCallback(IAsyncResult ar)
        {
            try
            {
                messagereceived = String.Empty;
                // Retrieve the state object and the client socket   
                // from the asynchronous state object.  
                StateObject state = (StateObject)ar.AsyncState;
                Socket handler = state.workSocket;

                //handler.BeginReceive(state.buffer, 0, StateObject.BufferSize, 0, new AsyncCallback(ReceiveCallback), state);

                // Read data from the remote device.  
                int bytesRead = handler.EndReceive(ar);

                if (bytesRead > 0)
                {
                    state.sb.Append(Encoding.ASCII.GetString(state.buffer, 0, bytesRead));
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
                    messagereceived = "Client connection unavailable";
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
            // Signal that all bytes have been received.  
            receiveDone.Set();
        }

        public void Send(Socket handler)
        {
            sendDone.Reset();
            Console.Write(">>");
            messagesent = Console.ReadLine();
            // Convert the string data to byte data using ASCII encoding.  
            byte[] byteData = Encoding.ASCII.GetBytes(messagesent);

            // Begin sending the data to the remote device.  
            handler.BeginSend(byteData, 0, byteData.Length, 0, new AsyncCallback(SendCallback), handler);
            sendDone.WaitOne();
        }

        public void SendCallback(IAsyncResult ar)
        {
            try
            {
                // Retrieve the socket from the state object.  
                Socket handler = (Socket)ar.AsyncState;

                // Complete sending the data to the remote device.  
                int bytesSent = handler.EndSend(ar);
                //Console.WriteLine("Sent {0} bytes to server.", bytesSent);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
            // Signal that all bytes have been sent. 
            sendDone.Set();
        }
    }
}
