using System;
using Logger;

namespace TaskExecutors
{
    public class MedicalResearcher: IComplicated
    {
        private ILoggable logger;// = new ConsoleLogger();
        public MedicalResearcher(ILoggable loggable)
        {
            logger = loggable;
        }

        public void PerformComplicatedTask()
        {
            logger.Log("Cured the Common Cold at " + DateTime.Now);
        }
    }
}