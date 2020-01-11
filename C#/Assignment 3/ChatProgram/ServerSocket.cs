using System;
using System.Net;
using System.Net.Sockets;

namespace ChatProgram
{
    public class ServerSocket

    {
        private Socket _socket;
        private byte[] _buffer = new byte[1024];

        public ServerSocket()
        {
            _socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        }

        public void Bind(int port)
        {
            _socket.Bind(new IPEndPoint(IPAddress.Any, port));
        }

        public void Listen(int backlog)
        {
            _socket.Listen(50);
        }

        public void Accept()
        {
            _socket.BeginAccept(AcceptedCallback, null);
        }

        private void AcceptedCallback(IAsyncResult result)
        {
            Socket clientSocket = _socket.EndAccept(result);
            SocketError error;
            if (clientSocket != null)
            {
                _buffer = new byte[1024];
                clientSocket.BeginReceive(_buffer, 0, _buffer.Length, SocketFlags.None, ReceivedCallback, clientSocket);
            }
        }

        private void ReceivedCallback(IAsyncResult result)
        {
            Socket clientSocket = result.AsyncState as Socket;
            if (clientSocket != null)
            {
                SocketError error;
                int buffersize = clientSocket.EndReceive(result, out error);
                byte[] packet = new byte[buffersize];
                Array.Copy(_buffer, packet, packet.Length);

                //Handle the packet
                PacketHandler.Handle(packet, clientSocket);

                _buffer = new byte[1024];
                clientSocket.BeginReceive(_buffer, 0, _buffer.Length, SocketFlags.None, ReceivedCallback, clientSocket);
            }
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
