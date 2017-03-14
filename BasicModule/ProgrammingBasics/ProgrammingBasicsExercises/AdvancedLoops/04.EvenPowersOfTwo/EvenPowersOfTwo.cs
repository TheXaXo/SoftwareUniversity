using System;

class EvenPowersOfTwo
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int result = 1;

        for (int i = 0; i <= n; i++)
        {
            if (i % 2 == 0)
            {
                Console.WriteLine(result);               
            }
            result *= 2;
        }
    }
}