using System;

namespace Survey_OOP
{   
    enum Month
    {
        January = 1,
        February,
        March,
        April,
        May,
        June,
        July,
        August,
        September,
        October,
        November,
        December
    }

    class Program
    {
        static void Main(string[] args)
        {
            Student user = new Student();

            Console.WriteLine("What is your name?");
            user.Name = Tryinput();

            Console.WriteLine("What is your age?");
            user.Age = Tryint();

            Console.WriteLine("What month were you born in?(Input month number)");
            user.Birthmonth = Validatemonth();

            Console.WriteLine("What date were you born in?");
            user.Birthdate = Validatedate(user.Birthmonth);

            user.Show();

            switch (user.Birthmonth)
            {
                case (int)Month.January:
                    if (user.Birthdate <= 19)
                        Console.WriteLine("you are a Capricorn.");
                    else
                        Console.WriteLine("you are a Aquarious.");
                    break;

                case (int)Month.February:
                    if (user.Birthdate <= 18)
                        Console.WriteLine("you are a Aquarious.");
                    else
                        Console.WriteLine("you are a pisces.");
                    break;

                case (int)Month.March:
                    if (user.Birthdate <= 19)
                        Console.WriteLine("you are a pisces.");
                    else
                        Console.WriteLine("you are a Aries.");
                    break;

                case (int)Month.April:
                    if (user.Birthdate <= 18)
                        Console.WriteLine("you are a Aries.");
                    else
                        Console.WriteLine("you are a Taurus.");
                    break;

                case (int)Month.May:
                    if (user.Birthdate <= 20)
                        Console.WriteLine("you are a Taurus.");
                    else
                        Console.WriteLine("you are a Gemini.");
                    break;

                case (int)Month.June:
                    if (user.Birthdate <= 20)
                        Console.WriteLine("you are a Gemini.");
                    else
                        Console.WriteLine("you are a Cancer.");
                    break;
                    
                case (int)Month.July:
                    if (user.Birthdate <= 22)
                        Console.WriteLine("you are a Cancer.");
                    else
                        Console.WriteLine("you are a Leo.");
                    break;

                case (int)Month.August:
                    if (user.Birthdate <= 22)
                        Console.WriteLine("you are a Leo.");
                    else
                        Console.WriteLine("you are a Virgo.");
                    break;

                case (int)Month.September:
                    if (user.Birthdate <= 22)
                        Console.WriteLine("you are a Virgo.");
                    else
                        Console.WriteLine("you are a Libra.");
                    break;

                case (int)Month.October:
                    if (user.Birthdate <= 22)
                        Console.WriteLine("you are a Libra.");
                    else
                        Console.WriteLine("you are a Scorpio.");
                    break;

                case (int)Month.November:
                    if (user.Birthdate <= 21)
                        Console.WriteLine("you are a Scorpio.");
                    else
                        Console.WriteLine("you are a Sagittarius.");
                    break;

                case (int)Month.December:
                    if (user.Birthdate <= 21)
                        Console.WriteLine("you are a Sagittarius.");
                    else
                        Console.WriteLine("you are a Capricorn.");
                    break;
            }
        }

        static string Tryinput()
        {
            var question = Console.ReadLine();

            while (question == "")
            {
                Console.WriteLine("You didn't type anything, please try again:");
                question = Console.ReadLine();
            }
            return question;
        }

        static int Tryint()
        {
            var intornot = true;
            int userint = 0;

            while (intornot)
            {
                try
                {
                    userint = int.Parse(Tryinput());
                    intornot = false;
                }
                catch
                {
                    Console.WriteLine("You didn't type an integer. Please try again:");
                }
            }
            return userint;
        }

        static int Validatemonth()
        {
            var month = 0;
            bool monthvalidation = true;
            while (monthvalidation)
            {
                month = Tryint();
                if (month >= 1 && month <= 12)
                {
                    monthvalidation = false;
                }
                else
                    Console.WriteLine("Error!!! Value out of range.");
            }
            return month;
        }

        static int Validatedate(int month)
        {
            var date = 0;
            bool Datevalidation = true;
            while (Datevalidation)
            {
                date = Tryint();
                switch (month)
                {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        if (date <= 31 && date >= 1)
                        {
                            Datevalidation = false;
                            return date;
                        }
                        else
                            Console.WriteLine("Error!!!Value out of range.");
                        break;

                    case 2:
                        if (date <= 29 && date >= 1)
                        {
                            Datevalidation = false;
                            return date;
                        }
                        else
                            Console.WriteLine("Error!!!Value out of range.");
                        break;

                    case 4: case 6: case 9: case 11:
                        if (date <= 30 && date >= 1)
                        {
                            Datevalidation = false;
                            return date;
                        }
                        else
                            Console.WriteLine("Error!!!Value out of range.");
                        break;
                }
            }
            return 0;
        }
    }

    class Student
    {
        public string Name { get; set; }
        public int Age { get; set; }
        public int Birthmonth { get; set; }
        public int Birthdate { get; set; }

        public void Show()
        {
            Console.WriteLine("Your name is: {0}", Name);
            Console.WriteLine("Your age is: {0}", Age);
            Console.WriteLine("Your birth month is: {0}", Birthmonth);
            Console.WriteLine("Your birth date is: {0}", Birthdate);
        }
    }
}
