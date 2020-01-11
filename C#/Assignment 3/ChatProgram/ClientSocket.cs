using System;
using System.Net;
using System.Net.Sockets;

namespace ChatProgram
{
    public class ClientSocket
    {
        public Socket _socket;
        public byte[] _buffer = new byte[1024];
        public NetworkStream stream;
        Chat chat = new Chat();

        public ClientSocket()
        {
            _socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        }

        public void Connect(string ipAddress, int port)
        {
            _socket.BeginConnect(new IPEndPoint(IPAddress.Parse(ipAddress), port), ConnectCallback, null);
        }

        private void ConnectCallback(IAsyncResult result)
        {
            if (_socket.Connected)
            {
                Console.WriteLine("Connected to the server!");              
                _buffer = new byte[1024];
                _socket.BeginReceive(_buffer, 0, _buffer.Length, SocketFlags.None, ReceivedCallback, null);
            }
            else
                Console.WriteLine("Could not Connect to server");
        }

        private void ReceivedCallback(IAsyncResult result)
        {
            int buffersize = _socket.EndReceive(result);
            byte[] packet = new byte[buffersize];

            Array.Copy(_buffer, packet, packet.Length);

            //Handle the packet

            _buffer = new byte[1024];
            _socket.BeginReceive(_buffer, 0, _buffer.Length, SocketFlags.None, ReceivedCallback, null);
        }

        public void Send()
        {
            String msg = "";
            msg = Console.ReadLine();
            Byte[] data = System.Text.Encoding.ASCII.GetBytes(msg);
            _socket.Send(data);
        }
    }
}
