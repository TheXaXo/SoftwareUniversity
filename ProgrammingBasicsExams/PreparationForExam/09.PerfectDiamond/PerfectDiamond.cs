using System;

class PerfectDiamond
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string(' ', n - 1) + "*");
       
        //Second Part
        for (int i = 1; i <= n - 1; i++)
        {
            Console.Write(new string(' ', n - i - 1));
            for (int j = 1; j <= i; j++)
            {
                Console.Write("*-");
            }
            Console.WriteLine("*");
        }

        //Third Part
        for (int i = 1; i <= n - 2; i++)
        {
            Console.Write(new string(' ', i));
            for (int j = 1; j <= n - 1 - i; j++)
            {
                Console.Write("*-");
            }
            Console.WriteLine("*");
        }

        //Fourt Part
        if (n > 1)
        {
            Console.WriteLine(new string(' ', n - 1) + "*");
        }
    }
}