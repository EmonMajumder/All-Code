using System;
using Logger;

namespace TaskExecutors
{
    public class DoGooder
    {
        private ILoggable logger;// = new ConsoleLogger();

        public DoGooder(ILoggable loggable)
        {
            logger = loggable;
        }
        public void DoSomethingGood()
        {
            logger.Log("Donated time to good cause at " + DateTime.Now);
        }
    }
}