using System;
using System.Net;
using System.Net.Sockets;


namespace ChatProgram
{
    public static class PacketHandler
    {
        public static void Handle(byte[] packet, Socket clientSocket)
        {
            ushort packetLength = BitConverter.ToUInt16(packet, 0);
            ushort packetType = BitConverter.ToUInt16(packet, 2);

            Console.WriteLine("Received packet! Length {0} | Type: {1}", packetLength, packetType);

            switch(packetType)
            {
                case 2000:
                    Message msg = new Message(packet);
                    Console.WriteLine(msg.Text);
                    break;
            }
        }
    }
}
