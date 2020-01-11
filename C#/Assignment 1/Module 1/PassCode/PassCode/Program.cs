using System;

namespace PassCode
{
    class Program
    {
        static void Main(string[] args)
        {
            var Password = "secret";
            bool log = true;

            while (log)
            {
                Console.WriteLine("What is the pass code?");
                var code = Console.ReadLine();

                if (code == Password)
                {
                    Console.WriteLine("Authenticated");
                    Console.Write("Do you want to change passcode?(Y/N): ");

                    var changepass = Console.ReadLine();
                    if (changepass == "Y" || changepass == "y")
                    {
                        Console.Write("New passcode: ");
                        Password = Console.ReadLine();
                    }

                    Console.Write("Logout?(Y/N): ");

                    var logout = Console.ReadLine();
                    if (logout != "Y" && logout != "y")
                    {
                        Console.WriteLine("Enjoy your stay.");
                        log = false;
                    }
                    else
                        Console.WriteLine("you Logged out.");
                }
                else
                    Console.WriteLine("Authentication Failed. Try again.");

            }
        }
    }
}
