using System;

class Axe
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int rows = n / 2 - 1;

        //First Part
        for (int i = 1; i <= n; i++)
        {
            Console.WriteLine(new string('-', 3 * n) + "*" + new string('-', i - 1) + "*" + new string('-', (2 * n - 2) - i + 1));
        }

        //Second Part
        for (int i = 1; i <= n / 2; i++)
        {
            Console.WriteLine(new string('*', 3 * n + 1) + new string('-', n - 1) + "*" + new string('-', n - 1));
        }

        //Third Part
        for (int i = 1; i <= n / 2 - 1; i++)
        {
            Console.WriteLine(new string('-', 3 * n - i + 1) + "*" + new string('-', n - 1 + 2 * i - 2) + "*" + new string('-', n - i));
        }

        //Fourth Part
        Console.WriteLine(new string('-', 3 * n - rows) + new string('*', n - 1 + 2 * rows + 2) + new string('-', (5 * n - ((3 * n - rows) + (n - 1 + 2 * rows + 2)))));
    }
}