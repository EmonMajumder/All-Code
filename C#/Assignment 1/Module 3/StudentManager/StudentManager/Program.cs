using System;

namespace Student_Manager
{
    class Program
    {
        static void Main(string[] args)
        {   
            var studentCount = 0;
            bool correct = true;
            while (correct)
            {
                correct = false;
                try
                {
                    studentCount = StudentManager.Error.Tryint("How many students in your class?: ");
                }
                catch (FormatException msg)
                {
                    Console.WriteLine(msg.Message);
                    correct = true;
                }
                catch (Exception msg)
                {
                    Console.WriteLine(msg.Message);
                    correct = true;
                }
            }

            var studentInfo = new object[studentCount, 2];

            for (int i = 0; i < studentCount; i++)
            {
                
                Console.Write("Student Name: ");
                studentInfo[i, 0] = Console.ReadLine();

                correct = true;
                while (correct)
                {
                    correct = false;
                    try
                    {
                        studentInfo[i, 1] = StudentManager.Error.Tryint("Student Grade: ");
                    }
                    catch (FormatException msg)
                    {
                        Console.WriteLine(msg.Message);
                        correct = true;
                    }
                    catch (Exception msg)
                    {
                        Console.WriteLine(msg.Message);
                        correct = true;
                    }
                }
            }

            for (int i = 0; i < studentCount; i++)
            {
                Console.WriteLine("Name: {0}, Grade: {1}", studentInfo[i, 0], studentInfo[i, 1]);
            }
        }

        
    }
}
