using System;

class Diamond
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string('.', n) + new string('*',3 * n) + new string('.', n));

        //Second Part
        for (int i = 1; i <= n - 1; i++)
        {
            Console.WriteLine(new string('.', n - i) + "*" + new string('.', 3 * n + 2 * i - 2) + "*" + new string('.', n - i));
        }

        //Third Part
        Console.WriteLine(new string('*', 5 * n));

        //Fourth Part
        for (int i = 1; i <= 2 * n; i++)
        {
            Console.WriteLine(new string('.', i) + "*" + new string('.', (5 * n - 4) - 2 * i + 2) + "*" + new string('.', i));
        }

        //Fifth Part
        Console.WriteLine(new string('.', 2 * n + 1) + new string('*', n - 2) + new string('.', 2 * n + 1));
    }
}