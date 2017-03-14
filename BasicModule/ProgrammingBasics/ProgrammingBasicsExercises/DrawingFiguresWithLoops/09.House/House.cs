using System;

class House
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());


        if (n % 2 == 0)
        {
           //First Part
           for (int i = 1; i <= n / 2; i++)
            {
                Console.WriteLine(new string('-', n / 2 - i) + new string('*', 2 * i) + new string('-', n / 2 - i));
            }           
        }
        else
        {
            //First Part
            for (int i = 1; i <= n / 2 + 1; i++)
            {
                Console.WriteLine(new string('-', n / 2 - i + 1) + new string('*', 2 * i - 1) + new string('-', n / 2 - i + 1));
            }
        }

        //Second Part
        for (int i = 1; i <= n / 2; i++)
        {
            Console.WriteLine("|" + new string('*', n - 2) + "|");
        }
    }
}