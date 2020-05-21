using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;


namespace ChatLibrary
{

    public class AsynchronousSocketListener : ChatMasterClass
    {
        public Socket listener;

        public AsynchronousSocketListener(string address, int port) : base(address, port)
        {

        }

        public void StartListening()
        {
            // Establish the local endpoint for the socket.  
            // The DNS name of the computer  
            // running the listener is "host.contoso.com".  
            IPAddress ipAddress = IPAddress.Parse(address);
            IPEndPoint localEndPoint = new IPEndPoint(ipAddress, port);
        
            // Create a TCP/IP socket.  
            listener = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);

            try
            {
                // Bind the socket to the local endpoint and listen for incoming connections.
                listener.Bind(localEndPoint);
                listener.Listen(100);

                // Set the event to nonsignaled state.  
                connectDone.Reset();

                // Start an asynchronous socket to listen for connections.
                listener.BeginAccept(new AsyncCallback(AcceptCallback), listener);
                Console.WriteLine("Waiting for a connection...");
                // Wait until a connection is made before continuing.
                connectDone.WaitOne();
                //OnConnected("Connected");
                //Console.WriteLine("Connected");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
        }                

        public void AcceptCallback(IAsyncResult ar)
        {
            // Get the socket that handles the client request.  
            Socket listener = (Socket)ar.AsyncState;
            Handler = listener.EndAccept(ar);           

            // Signal the main thread to continue.  
            connectDone.Set();
            OnConnected("Connected");
        }

        public static bool IsSocketConnected(Socket s)
        {
            return !((s.Poll(1000, SelectMode.SelectRead) && (s.Available == 0)) || !s.Connected);
        }
    }
}