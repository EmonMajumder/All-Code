using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace Client
{
    public class TCPClient
    {
        public TCPClient()
        {

        }
        /// <summary>
        /// The function in TCPClient class to start the Client and bring client online.
        /// </summary>
        /// <param name="server"></param>
        public void ClientConnect(String server)
        {

            try
            {
                Int32 port = 1234;
                NetworkStream stream=null;
                String msg = "";

                using (TcpClient client = new TcpClient(server, port))
                {
                    Console.WriteLine("Client is connected to server...");
                    do
                    {
                        while (true)
                        {
                            if (Console.KeyAvailable)
                            {
                                ConsoleKeyInfo userkey = Console.ReadKey();
                                if (userkey.Key == ConsoleKey.I)
                                {
                                    msg = null;
                                    Console.Write(">> ");
                                    msg = Console.ReadLine();
                                    break;
                                }
                            }
                        }

                        if (msg != "Quit" && msg != "quit")
                        {
                            // Translate the passed message into ASCII and store it as a Byte array.
                            Byte[] data = System.Text.Encoding.ASCII.GetBytes(msg);
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
                            if (responseData == "Quit" || responseData == "Quit")
                            {
                                break;
                            }
                            else
                                Console.WriteLine("Server: {0}", responseData);
                        }
                        else
                        {
                            Byte[] data = System.Text.Encoding.ASCII.GetBytes("Quit");
                            stream = client.GetStream();
                            stream.Write(data, 0, data.Length);
                            break;
                        }
                    } while (true);
                stream.Close();
                }
            }
            catch (ArgumentNullException e)
            {
                Console.WriteLine("ArgumentNullException: {0}", e);
            }
            catch (SocketException e)
            {
                Console.WriteLine("");
            }
        }
    }
}