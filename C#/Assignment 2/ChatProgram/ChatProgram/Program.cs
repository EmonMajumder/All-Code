using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace ChatProgram
{
    class Program
    {
        public static void ServerConnect()
        {
            TcpListener server = null;
            try
            {
                // Set the TcpListener on port 13000.
                Int32 port = 1234;
                IPAddress localAddr = IPAddress.Parse("127.0.0.1");

                // TcpListener server = new TcpListener(port);
                server = new TcpListener(localAddr, port);

                // Start listening for client requests.
                server.Start();

                // Buffer for reading data
                Byte[] bytes = new Byte[256];
                String data = null;

                Console.Write("Waiting for a connection... ");

                // Perform a blocking call to accept requests.
                // You could also user server.AcceptSocket() here.
                TcpClient client = server.AcceptTcpClient();
                Console.WriteLine("Connected!");

                // Enter the listening loop.
                while (true)
                {
                    data = null;

                    // Get a stream object for reading and writing
                    NetworkStream stream = client.GetStream();

                    int i;

                    // Loop to receive all the data sent by the client.
                    while ((i = stream.Read(bytes, 0, bytes.Length)) != 0)
                    {
                        // Translate data bytes to a ASCII string.
                        data = System.Text.Encoding.ASCII.GetString(bytes, 0, i);
                        Console.WriteLine("Client: {0}", data);

                        // Process the data sent by the client.
                        Console.Write("Server: ");
                        data = Console.ReadLine();

                        byte[] msg = System.Text.Encoding.ASCII.GetBytes(data);

                        // Send back a response.
                        stream.Write(msg, 0, msg.Length);
                    }
                    // Shutdown and end connection
                    client.Close();
                }
            }
            catch (SocketException e)
            {
                Console.WriteLine("SocketException: {0}", e);
            }
            finally
            {
                // Stop listening for new clients.
                server.Stop();
            }
            Console.WriteLine("\nHit enter to continue...");
            Console.Read();
        }

        public static void ClientConnect(String server)
        {
            //TcpClient client = null;
            //NetworkStream stream = null;
            // Create a TcpClient.
            // Note, for this client to work you need to have a TcpServer 
            // connected to the same address as specified by the server, port
            // combination.
            Int32 port = 1234;
            NetworkStream stream;
            try
            {                
                using (TcpClient client = new TcpClient(server, port))
                {
                    do
                    {
                        //client = new TcpClient(server, port);

                        // Translate the passed message into ASCII and store it as a Byte array.
                        Console.Write("Client: ");
                        String message = Console.ReadLine();
                        if (message != "Quit" && message != "quit")
                        {
                            Byte[] data = System.Text.Encoding.ASCII.GetBytes(message);

                            // Get a client stream for reading and writing.
                            //  Stream stream = client.GetStream();
                            //throw new ArgumentNullException();
                            //stream = client.GetStream();

                            stream = client.GetStream();

                            // Send the message to the connected TcpServer. 
                            stream.Write(data, 0, data.Length);



                            // Receive the TcpServer.response.

                            // Buffer to store the response bytes.
                            data = new Byte[256];

                            // String to store the response ASCII representation.
                            String responseData = String.Empty;

                            // Read the first batch of the TcpServer response bytes.
                            Int32 bytes = stream.Read(data, 0, data.Length);
                            responseData = System.Text.Encoding.ASCII.GetString(data, 0, bytes);
                            Console.WriteLine("Server: {0}", responseData);

                        }
                        else
                            break;
                    } while (true);
                }
            }
            catch (ArgumentNullException e)
            {
                Console.WriteLine("ArgumentNullException: {0}", e);
            }
            catch (SocketException e)
            {
                Console.WriteLine("SocketException: {0}", e);
            }

            Console.WriteLine("\n Press Enter to continue...");
            Console.Read();
        }

        static void Main(string[] args)
        {
            // Run as server vs. client 
            if (args.Contains("-server"))
            {
                ServerConnect();
            }
            else
            {
                ClientConnect("127.0.0.1");
            }
        }
    }        
}
