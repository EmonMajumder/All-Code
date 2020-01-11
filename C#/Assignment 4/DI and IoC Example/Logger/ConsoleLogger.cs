using System.Diagnostics;

namespace Logger
{
    public class ConsoleLogger: ILoggable
    {
        public void Log(string message)
        {
            Debug.WriteLine(message);
        }
    }
}