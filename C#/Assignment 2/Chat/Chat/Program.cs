using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using Server;
using Client;

namespace ChatProgram
{
    class Program
    {       
        public static void Main(string[] args)
        {
            // Run as server vs. client 
            if (args.Contains("-server"))
            {
                TCPServer server = new TCPServer();
                server.ServerConnect("127.0.0.1");
            }
            else
            {
                TCPClient client = new TCPClient();
                client.ClientConnect("127.0.0.1");              
            }
        }
    }
}