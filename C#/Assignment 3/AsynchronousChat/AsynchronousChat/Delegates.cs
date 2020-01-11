using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Sockets;

namespace AsynchronousChat
{
    public delegate void MessageSentEventHandler(string s);
    public delegate void MessageReceivedEventHandler(string s);
    public delegate void SafeCallDelegate(string text);
}
