using System;
using System.Collections.Generic;

namespace Outreference
{
    class Program
    {
        static void Main(string[] args)
        {
            var test = "3.5";
            var outDouble = 4.5;
            Console.WriteLine("Result: {0}", parseDouble(test, out outDouble));
            Console.WriteLine("Test type is {0} and outDouble = {1}", outDouble.GetType(), outDouble);

            test = "Emon";
            Console.WriteLine("Result: {0}", parseDouble(test, out outDouble));
            Console.WriteLine("Test value is {0}", outDouble);
        }

        static bool parseDouble(string number, out double Doublevalue)
        {
            //bool result = Double.TryParse(number, out Doublevalue);
            try
            {
                Doublevalue = Double.Parse(number);
                return true;
            }
            catch (FormatException)
            {
                Doublevalue = 123.456;
                return false;
            }            
        }
    }
}