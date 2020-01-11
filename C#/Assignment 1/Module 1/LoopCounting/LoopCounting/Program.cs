using System;

namespace LoopCounting
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int x = 1; x <= 5; x++)
            {
                int i;
                for (i = 1; i <= 10; i++)
                {
                    Console.WriteLine(i);
                }

                i--;
                while (i >= 1)
                {
                    Console.WriteLine(i);
                    i--;
                }
            }
        }
    }
}
