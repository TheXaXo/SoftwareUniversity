using System;

class StripedTowel
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        for (int i = 1; i <= n * 1.5; i++)
        {
            for (int j = 1; j <= n; j++)
            {               
                if ((j + i - 2) % 3 == 0)
                {
                    Console.Write("#");
                }
                else
                    Console.Write(".");
            }
            Console.WriteLine();
        }
    }
}