using System;

namespace Student_Manager
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("How many students in your class?");
            var studentCount = int.Parse(Console.ReadLine());

            var studentInfo = new string[studentCount, 2];

            for (int i = 0; i < studentCount; i++)
            {
                Console.Write("Student Name: ");
                studentInfo[i,0] = Console.ReadLine();

                Console.Write("Student Grade: ");
                studentInfo[i,1] = Console.ReadLine();
            }

            for (int i = 0; i < studentCount; i++)
            {
                Console.WriteLine("Name: {0}, Grade: {1}", studentInfo[i, 0], studentInfo[i, 1]);
            }
        }
    }
}
