using System;

class MagicWand
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string('.', (3 * n + 1) / 2) + "*" + new string('.', (3 * n + 1) / 2));

        //Second Part
        for (int i = 1; i <= n / 2 + 1; i++)
        {
            Console.WriteLine(new string('.', (3 * n + 1) / 2 - i) + "*" + new string('.', 2 * i - 1) + "*" + new string('.', (3 * n + 1) / 2 - i));
        }

        //Third Part
        Console.WriteLine(new string('*', n) + new string('.', n + 2) + new string('*', n));

        //Fourth Part
        for (int i = 1; i <= n / 2; i++)
        {
            Console.WriteLine(new string('.', i) + "*" + new string('.', 3 * n - 2 - 2 * i + 2) + "*" + new string('.', i));
        }

        //Fifth Part
        for (int i = 1; i <= n / 2; i++)
        {
            Console.WriteLine(new string('.', n / 2 - i) + "*" + new string('.', n / 2) + "*" + new string('.', i - 1) + "*" + new string('.', n) + "*" + new string('.', i - 1) + "*" + new string('.', n / 2) + "*" + new string('.', n / 2 - i));
        }

        //Sixth Part
        Console.WriteLine(new string('*', n / 2 + 1) + new string('.', n / 2) + "*" + new string('.', n) + "*" + new string('.', n / 2) + new string('*', n / 2 + 1));

        //Seventh Part
        for (int i = 1; i <= n; i++)
        {
            Console.WriteLine(new string('.', n) + "*" + new string('.', n) + "*" + new string('.', n));
        }

        //Eight Part
        Console.WriteLine(new string('.', n) + new string('*', n + 2) + new string('.', n));
    }
}