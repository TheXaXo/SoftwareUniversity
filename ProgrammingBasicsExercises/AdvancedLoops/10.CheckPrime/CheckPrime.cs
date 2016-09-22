using System;

class CheckPrime
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        if (n < 2)
        {
            Console.WriteLine("Not Prime");
            return;
        }

        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
            {
                Console.WriteLine("Not Prime");
                return;
            }
        }
        Console.WriteLine("Prime");
    }
}