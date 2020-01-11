using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ChatTest
{
    class Program
    {
        public static ManualResetEvent threadDone = new ManualResetEvent(false);
        public static void Main(string[] args)
        {
            // Run as server vs. client 
            if (args.Contains("c"))
            {
                AsynchronousClient clientpc = new AsynchronousClient("127.0.0.1",11000);
                Socket clientt = clientpc.StartClient();
                Thread.Sleep(100);
                Thread t = new Thread(clientpc.ProcessServerfromClient);
                t.Start(clientt);
            }
            else
            {
                AsynchronousSocketListener server = new AsynchronousSocketListener("127.0.0.1", 11000);
                while(true)
                {
                    threadDone.Reset();
                    server.StartListening();
                    Thread t = new Thread(server.ProcessClientfromServer);
                    t.Start();
                    t.Join();
                    server.listener.Close();
                    Console.WriteLine("Do you want to shut off Server?(Y/N): ");
                    if(Console.ReadKey == 'N' || Console.ReadKey == 'n')
                    {
                        break;
                    }
                }                                                 
            }
        }

        public static void donothing()
        {

        }
    }
}