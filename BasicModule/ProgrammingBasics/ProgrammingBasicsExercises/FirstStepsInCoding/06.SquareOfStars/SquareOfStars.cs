using System;

class SquareOfStars
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string('*', n));

        //Second Part
        for (int i = 1; i <= n - 2; i++)
        {
            Console.WriteLine("*" + new string(' ', n - 2) + "*");
        }

        //Third Part
        Console.WriteLine(new string('*', n));
    }
}