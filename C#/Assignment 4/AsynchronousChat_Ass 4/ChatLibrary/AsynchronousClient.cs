using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using Delegates;
//using Logger;
using NewLogger;

namespace ChatLibrary
{
    /// <summary>
    /// Client connection.
    /// </summary>
    /// 
    /// <returns>
    /// Create a client socket for connection.
    /// </returns>
    public class AsynchronousClient : ChatMasterClass
    {
        public Socket client;
        public IPEndPoint remoteEP;
        IPAddress ipAddress;
        public string ConnectionStatus;

        //Default constructor
        public AsynchronousClient(string address, int port, ILoggingService loggable) : base(address, port, loggable)
        {
        }
        
        //Start a socket connection if server port is open.
        public string StartClient()
        {
            connectDone.Reset();
            try
            {
                // Establish the remote endpoint for the socket.
                ipAddress = IPAddress.Parse(address);
                remoteEP = new IPEndPoint(ipAddress, port);

                // Create a TCP/IP socket.
                client = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);

                // Connect to the remote endpoint.
                client.BeginConnect(remoteEP, new AsyncCallback(ConnectCallback), client);
                connectDone.WaitOne();                
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
            return ConnectionStatus;
        }

        //Async callback function
        private void ConnectCallback(IAsyncResult ar)
        {
            try
            {
                // Retrieve the socket from the state object.  
                client = (Socket)ar.AsyncState;

                ConnectionStatus = "Connected";

                // Complete the connection.  
                client.EndConnect(ar);                
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
                ConnectionStatus = "Server is not available for connection";
            }

            // Signal that the connection has been made.  
            connectDone.Set();
        }
    }
}

