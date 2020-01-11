using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace Server
{

    public class TCPServer
    {
        public TCPServer()
        {

        }
        /// <summary>
        /// The function in TCPServer class to start the server and bring server online.
        /// </summary>
        /// <param name="serverid"></param>
        public void ServerConnect(String serverid)
        {
            TcpListener server = null;

            try
            {
                // Set the TcpListener on port 1234
                Int32 port = 1234;
                IPAddress localAddr = IPAddress.Parse(serverid);

                server = new TcpListener(localAddr, port);

                // Start listening for client requests.
                server.Start();

                // Buffer for reading data
                Byte[] bytes = new Byte[256];
                String data = null;


                while (true)
                {
                    Console.Write("Waiting for client to connect... ");

                    // Perform a blocking call to accept requests.
                    TcpClient client = server.AcceptTcpClient();
                    Console.WriteLine("Connected!!!");

                    // Enter the listening and reply loop.
                    while (true)
                    {
                        data = null;
                        // Get a stream object for reading and writing
                        NetworkStream stream = client.GetStream();

                        int i;

                        i = stream.Read(bytes, 0, bytes.Length);

                        // Translate data bytes to a ASCII string.
                        data = System.Text.Encoding.ASCII.GetString(bytes, 0, i);
                        if (data == "Quit" || data == "quit")
                        {

                        }
                        else
                            Console.WriteLine("Client: {0}", data);

                        while (true)
                        {
                            if (Console.KeyAvailable)
                            {
                                ConsoleKeyInfo userkey = Console.ReadKey();
                                if (userkey.Key == ConsoleKey.I)
                                {
                                    data = null;
                                    Console.Write(">> ");
                                    data = Console.ReadLine();

                                    byte[] msg = System.Text.Encoding.ASCII.GetBytes(data);

                                    // Send back a response.
                                    stream.Write(msg, 0, msg.Length);
                                    break;
                                }                                
                            }
                        }
                        if (data == "Quit" || data == "quit")
                        {
                            break;
                        }
                    }

                    // Shutdown and end connection
                    if (client != null)
                    {
                        client.Close();
                    }                    
                    break;
                }
            }
            catch (SocketException e)
            {
                Console.WriteLine("");
            }
            finally
            {
                // Stop listening for new clients.
                server.Stop();
            }
        }
    }
}