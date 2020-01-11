using Logger;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskExecutors
{
    public class BeerDrinker : IDrink, INoisy
    {
        private ILoggable logger;
        private int count = 0;
        public BeerDrinker(ILoggable logger)
        {
            this.logger = logger;
        }

        public void MakeNoise()
        {
            count++;
            logger.Log(count + " Sing Karaoke " + DateTime.Now);
        }

        public void TakeADrink()
        {
            count++;
            logger.Log(count + " Had a beer at " + DateTime.Now);
        }
    }
}
