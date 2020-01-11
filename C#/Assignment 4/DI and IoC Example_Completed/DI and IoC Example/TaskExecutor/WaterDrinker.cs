using System;
using Logger;

namespace TaskExecutors
{
    public class WaterDrinker: IDrink
    {
        private ILoggable logger;
        
        public WaterDrinker(ILoggable loggable)
        {
            logger = loggable;
        }

    public void TakeADrink()
        {
            logger.Log("Took a drink of water at " + DateTime.Now);
        }
    }
}