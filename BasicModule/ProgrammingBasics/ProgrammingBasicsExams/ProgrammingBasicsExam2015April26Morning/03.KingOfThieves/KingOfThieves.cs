using System;

class KingOfThieves
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        char symbol = char.Parse(Console.ReadLine());

        //First Part
        for (int i = 1; i <= n / 2 + 1; i++)
        {
            Console.WriteLine(new string('-', n / 2 - i + 1) + new string(symbol, 2 * i - 1) + new string('-', n / 2 - i + 1));
        }

        //Second Part
        for (int i = 1; i <= n / 2; i++)
        {
            Console.WriteLine(new string('-', i) + new string(symbol, n - 2 - 2 * i + 2) + new string('-', i));
        }
    }
}