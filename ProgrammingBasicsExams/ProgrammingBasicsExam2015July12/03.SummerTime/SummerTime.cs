using System;

class SummerTime
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string(' ', n / 2) + new string('*', n + 1));

        //Second Part
        for (int i = 1; i <= n / 2 + 1; i++)
        {
            Console.WriteLine(new string(' ', n / 2) + "*" + new string(' ', n - 1) + "*");
        }

        //Third Part
        for (int i = 1; i <= n / 2 - 1; i++)
        {
            Console.WriteLine(new string(' ', n / 2 - i) + "*" + new string(' ', n - 1 + 2 * i) + "*");
        }

        //Fourth Part
        for (int i = 1; i <= n * 2; i++)
        {
            if (i <= n * 2 / 2)
            {
                Console.WriteLine("*" + new string('.', n * 2 - 2) + "*");
            }
            else
            {
                Console.WriteLine("*" + new string('@', n * 2 - 2) + "*");
            }
        }

        //Fifth Part
        Console.WriteLine(new string('*', 2 * n));
    }
}