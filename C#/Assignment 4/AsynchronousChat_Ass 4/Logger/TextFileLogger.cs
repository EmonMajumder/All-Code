using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Logger
{
    /// <summary>
    /// Logger class to log messages in a text file
    /// </summary>
    public class TextFileLogger:ILoggingService
    {
        public static string Filename;
        
        //Methof implementation from interface ILoggingService
        public void Log(string message)
        {
            Filename = "log.txt";
            while (true)
            {
                try
                {
                    //Open file to write and close after
                    using (StreamWriter w = File.AppendText(Filename))
                    {
                        if (message != "")
                        {
                            //Log current date and time
                            w.Write($"{DateTime.Now.ToLongTimeString()} {DateTime.Now.ToLongDateString()}");
                            w.Write("  :");
                            w.Write($"  :");

                            //Log messages
                            w.Write(message);
                            w.Write(Environment.NewLine);
                        }
                    }
                    break;
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.ToString());
                }
            }
        }
    }
}
