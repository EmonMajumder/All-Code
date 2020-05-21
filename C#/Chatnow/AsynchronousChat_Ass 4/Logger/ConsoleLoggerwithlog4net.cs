using System;
using System.Collections.Generic;
using System.Text;

namespace Logger
{
    //Function to use C# library logger LOg4net
    public class ConsoleLoggerwithlog4net:ILoggingService
    {

        private static readonly log4net.ILog log = log4net.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);

        //Function log to log messages
        public void Log(string message)
        {
            //Write message as Info and Debug to the console 
            log.Info(message);
            log.Debug(message);            
        }
    }
}
