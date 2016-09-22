using System;

class Program
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        if (n % 2 == 0)
        {
            //First Part
            Console.WriteLine(new string('%', n * 2));

            //Second Part
            for (int i = 1; i <= n - 1; i++)
            {
                if (i == n / 2)
                {
                    Console.Write("%" + new string(' ', (2 * n - 4) / 2) + "**" + new string(' ', (2 * n - 4) / 2) + "%");
                }
                else
                {
                    Console.Write("%" + new string(' ', 2 * n - 2) + "%");
                }
                Console.WriteLine();
            }

            //Third Part
            Console.WriteLine(new string('%', 2 * n));
        }
        else
        {
            //First Part
            Console.WriteLine(new string('%', 2 * n));

            //Second part
            for (int i = 1; i <= n; i++)
            {
                if (i == n / 2 + 1)
                {
                    Console.Write("%" + new string(' ', (2 * n - 4) / 2) + "**" + new string(' ', (2 * n - 4) / 2) + "%");
                }
                else
                {
                    Console.Write("%" + new string(' ', 2 * n - 2) + "%");
                }
                Console.WriteLine();
            }

            //Third Part
            Console.WriteLine(new string('%', 2 * n));
        }
    }
}