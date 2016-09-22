using System;

class RhombusOfStars
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        for (int i = 1; i <= n; i++)
        {
            Console.Write(new string(' ', n - i));
            for (int j = 1; j <= i; j++)
            {
                Console.Write("* ");
            }
            Console.WriteLine();
        }

        //Second Part
        for (int i = 1; i <= n - 1; i++)
        {
            Console.Write(new string(' ', i));
            for (int j = 1; j <= n - i; j++)
            {
                Console.Write("* ");
            }
            Console.WriteLine();
        }
    }
}