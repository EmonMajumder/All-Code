using System;

namespace Delegates
{
    /// <summary>
    /// All the delegates are in this project class
    /// </summary>
    /// <param name="args">null</param>
    public delegate void MessageSentEventHandler(EventArgs args);
    public delegate void MessageReceivedEventHandler(EventArgs args);
    public delegate void SafeCallDelegate(string text);
}
