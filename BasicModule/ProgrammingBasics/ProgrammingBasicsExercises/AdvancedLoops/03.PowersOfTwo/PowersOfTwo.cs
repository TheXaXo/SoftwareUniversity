using System;

class PowersOfTwo
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int result = 1;

        for (int i = 0; i <= n; i++)
        {
            Console.WriteLine(result);
            result *= 2;
        }
    }
}