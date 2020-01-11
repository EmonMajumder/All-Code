using System;
using System.Collections.Generic;
using System.Text;

namespace Survey
{
    class Marketing
    {
        public void Thanknote()
        {
            Program.Posted += itPosted;
        }

        void itPosted()
        {
            Console.WriteLine("Thank you for completing the survey. You are now subscribed to ten of our newsletters.");
        }
    }
}
