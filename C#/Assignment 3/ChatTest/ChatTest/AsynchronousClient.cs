using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace ChatTest
{
    public class AsynchronousClient : ChatMasterClass
    {
        public Socket client;

        public AsynchronousClient(string address, int port) :base(address,port)
        {

        }

        public Socket StartClient()
        { 
            try
            {
                // Establish the remote endpoint for the socket.
                IPAddress ipAddress = IPAddress.Parse(address);
                IPEndPoint remoteEP = new IPEndPoint(ipAddress, port);

                // Create a TCP/IP socket.
                client = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
                
                // Connect to the remote endpoint.
                client.BeginConnect(remoteEP, new AsyncCallback(ConnectCallback), client);
                connectDone.WaitOne();
                Console.WriteLine("Socket connected to {0}", client.RemoteEndPoint.ToString());           
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
            return client;
        }

        private void ConnectCallback(IAsyncResult ar)
        {
            try
            {
                // Retrieve the socket from the state object.  
                Socket client = (Socket)ar.AsyncState;

                // Complete the connection.  
                client.EndConnect(ar);                

                // Signal that the connection has been made.  
                connectDone.Set();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
        }        
    }
}

