using System;

class Butterfly
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        for (int i = 1; i <= n - 2; i++)
        {
            if (i % 2 == 0)
            {
                Console.WriteLine(new string('-', n - 2) + "\\" + " " + "/" + new string('-', n - 2));
            }
            else
            {
                Console.WriteLine(new string('*', n - 2) + "\\" + " " + "/" + new string('*', n - 2));
            }
        }

        //Second Part
        Console.WriteLine(new string(' ', n - 1) + "@");

        //Third Part
        for (int i = 1; i <= n - 2; i++)
        {
            if (i % 2 == 0)
            {
                Console.WriteLine(new string('-', n - 2) + "/" + " " + "\\" + new string('-', n - 2));
            }
            else
            {
                Console.WriteLine(new string('*', n - 2) + "/" + " " + "\\" + new string('*', n - 2));
            }           
        }
    }
}