using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace AsynchronousChat
{
    
    public class Logfile
    {
        public static string Filename;
        public static int num;

        public string createFile()
        {
            Filename = "log";
            while(File.Exists(Filename+".txt"))
            {
                num++;
                Filename = "log" + num.ToString();
            }
            Filename = Filename + num.ToString() + ".txt";
            FileStream fs = File.Create(Filename);
            return Filename;
        }

        public void AddLog(string msg)
        {
            while(true)
            {
                try
                {
                    using (StreamWriter w = File.AppendText(Filename))
                    {
                        log(msg, w);
                    }
                    break;
                }
                catch(Exception e)
                {

                }
            }
        }

        public void AddLogerror(string msg)
        {
            while (true)
            {
                try
                {
                    using (StreamWriter w = File.AppendText(Filename))
                    {
                        log(msg, w);
                    }
                    break;
                }
                catch (Exception e)
                {

                }
            }
        }

        public void log(String msg, TextWriter SW)
        {
            if(msg!="")
            {
                SW.Write($"{DateTime.Now.ToLongTimeString()} {DateTime.Now.ToLongDateString()}");
                SW.Write("  :");
                SW.Write($"  :");
                SW.Write(msg);
                SW.Write(Environment.NewLine);
            }                                                             
        }
    }
}
