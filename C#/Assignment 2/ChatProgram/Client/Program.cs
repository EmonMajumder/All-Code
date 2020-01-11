using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace Client
{
    class Program
    {
        //static Socket sck;
        //static byte[] Buffer { get; set; }

        //static void Main(string[] args)
        //{
        //    sck = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        //    IPEndPoint localEndPoint = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 1234);
        //    try
        //    {
        //        sck.Connect(localEndPoint);
        //    }
        //    catch
        //    {
        //        Console.WriteLine("Unable to connect to remote end point!\r\n");
        //        Main(args);
        //    }
        //    string text = "";
        //    Socket accepted;

        //    do
        //    {
        //        Console.Write("Client:>>");
        //        text = Console.ReadLine();
        //        byte[] data = Encoding.ASCII.GetBytes(text);
        //        sck.Send(data);

        //        sck.Listen(100);
        //        accepted = sck.Accept();
        //        Buffer = new byte[accepted.SendBufferSize];
        //        int bytesRead = accepted.Receive(Buffer);
        //        byte[] formatted = new byte[bytesRead];
        //        for (int i = 0; i < bytesRead; i++)
        //        {
        //            formatted[i] = Buffer[i];
        //        }
        //        string strData = Encoding.ASCII.GetString(formatted);
        //        Console.Write(strData + "\r\n");

        //    } while (text != "Quit" && text != "quit");

        //    accepted.Close();
        //    sck.Close();

        public static void Main(string[] args)
        {
            clientConnect("127.0.0.1");
        }
        /// <summary>
        /// Connect to a remote server.
        /// </summary>
        /// <param name="server"></param>
        /// <param name="message"></param>
        static void clientConnect(String server)
        {
            //TcpClient client = null;
            //NetworkStream stream = null;
            // Create a TcpClient.
            // Note, for this client to work you need to have a TcpServer 
            // connected to the same address as specified by the server, port
            // combination.
            Int32 port = 1234;
            try
            {
                NetworkStream stream;
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
            //finally
            //{
            //    // Clean up code for external resources.
            //    if (stream != null)
            //    {
            //        stream.Close();
            //    }
            //}

            Console.WriteLine("\n Press Enter to continue...");
            Console.Read();
        }
    }
}
