using System;
using Logger;

namespace TaskExecutors
{
    public class WaterDrinker
    {
        private ILoggable logger;// = new ConsoleLogger();
        
        public WaterDrinker(ILoggable loggable)
        {
            logger = loggable;
        }

    public void TakeDrink()
        {
            logger.Log("Took a drink of water at " + DateTime.Now);
        }
    }
}