using Logger;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskExecutors
{
    public class BillGates: ICharitable
    {
        private ILoggable logger;// = new ConsoleLogger();

        public BillGates(ILoggable loggable)
        {
            logger = loggable;
        }
        public void DoSomethingGood()
        {
            logger.Log("Curing measles and other diseases at " + DateTime.Now);
        }
    }
}
