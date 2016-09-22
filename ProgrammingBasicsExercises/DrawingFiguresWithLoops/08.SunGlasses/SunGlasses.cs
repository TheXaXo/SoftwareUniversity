using System;

class SunGlasses
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string('*', 2 * n) + new string(' ', n) + new string('*', 2 * n));

        //Second Part
        for (int i = 1; i <= n - 2; i++)
        {
            if (n % 2 == 0 && i == n / 2 - 1)
            {
                Console.WriteLine("*" + new string('/', 2 * n - 2) + "*" + new string('|', n) + "*" + new string('/', 2 * n - 2) + "*");
            }
            else if (n % 2 != 0 && i == n / 2)
            {
                Console.WriteLine("*" + new string('/', 2 * n - 2) + "*" + new string('|', n) + "*" + new string('/', 2 * n - 2) + "*");
            }
            else
            {
                Console.WriteLine("*" + new string('/', 2 * n - 2) + "*" + new string(' ', n) + "*" + new string('/', 2 * n - 2) + "*");
            }
        }

        //Third Part
        Console.WriteLine(new string('*', 2 * n) + new string(' ', n) + new string('*', 2 * n));
    }
}