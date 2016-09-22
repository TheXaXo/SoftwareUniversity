using System;

class Sunlight
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string('.', (3 * n - 1) / 2) + "*" + new string('.', (3 * n - 1) / 2));

        //Second Part
        for (int i = 1; i <= n - 1; i++)
        {
            Console.WriteLine(new string('.', i) + "*" + new string('.', (3 * n - 1) / 2 - 2 - i + 1) + "*" + new string('.', (3 * n - 1) / 2 - 2 - i + 1) + "*" + new string('.', i));
        }

        //Third Part
        for (int i = 1; i <= n / 2; i++)
        {
            Console.WriteLine(new string('.', n) + new string('*', n) + new string('.', n));
        }

        //Fourth Part
        {
            Console.WriteLine(new string('*', 3 * n));
        }

        //Fifth Part
        for (int i = 1; i <= n / 2; i++)
        {
            Console.WriteLine(new string('.', n) + new string('*', n) + new string('.', n));
        }

        //Sixth Part
        for (int i = 1; i <= n - 1; i++)
        {
            Console.WriteLine(new string('.',n - i) + "*" + new string('.', n / 2 + i - 1) + "*" + new string('.', n / 2 + i - 1) + "*" + new string('.',n - i));
        }
       
        //Seventh Part
        Console.WriteLine(new string('.', (3 * n - 1) / 2) + "*" + new string('.', (3 * n - 1) / 2));
    }
}