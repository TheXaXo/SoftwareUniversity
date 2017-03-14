using System;

class AceOfDiamonds
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string('*', n));

        //Second Part
        for (int i = 1; i <= n / 2; i++)
        {
            Console.WriteLine("*" + new string('-', n / 2 - i) + new string('@', 2 * i - 1) + new string('-', n / 2 - i) + "*");
        }

        //Third Part
        for (int i = 1; i <= n / 2 - 1; i++)
        {
            Console.WriteLine("*" + new string('-', i) + new string('@', n - 2 - 2 * i) + new string('-', i) + "*");
        }

        //Fourt Part
        Console.WriteLine(new string('*', n));
    }
}