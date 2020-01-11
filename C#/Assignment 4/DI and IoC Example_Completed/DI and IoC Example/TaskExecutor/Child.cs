using Logger;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskExecutors
{
    public class Child: INoisy
    {
        private ILoggable logger;// = new ConsoleLogger();
        public Child(ILoggable loggable)
        {
            logger = loggable;
        }

        public void MakeNoise()
        {
            logger.Log("WAAAAA!!!!! at " + DateTime.Now);
        }
    }
}
