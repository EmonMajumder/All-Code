using Logger;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskExecutors
{
    public class RocketScientist : IComplicated
    {
        private ILoggable logger;// = new ConsoleLogger();
        public RocketScientist(ILoggable loggable)
        {
            logger = loggable;
        }

        public void PerformComplicatedTask()
        {
            logger.Log("Launched rockets at " + DateTime.Now);
        }
    }
}
