using System;
using Logger;

namespace TaskExecutors
{
    public class CarHorn
    {
        private ILoggable logger;// = new ConsoleLogger();
        public CarHorn(ILoggable loggable)
        {
            logger = loggable;
        }

    public void MakeNoise()
        {
            logger.Log("Honked car horn at " + DateTime.Now);
        }
    }
}