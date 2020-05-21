using System;

namespace Delegates
{
    public delegate void MessageSentEventHandler(string s);
    public delegate void MessageReceivedEventHandler(string s);
    public delegate void SafeCallDelegate(string text);
    public delegate void ConnectionDoneEventHandler(string s);
}
