using System;
using System.Collections.Generic;
using System.Text;

namespace StudentManager
{
    class Error
    {
        static public int Tryint(string question)
        {
            var value = 0;

            try
                {
                    Console.Write(question);
                    value = int.Parse(Console.ReadLine());
                }
                catch (FormatException)
                {
                    throw new FormatException ("Please type an Integer.");
                }
                catch (Exception)
                {
                    throw new Exception ("Invalid input. Please try again.");
                }
            return value;
        }
    }
}
