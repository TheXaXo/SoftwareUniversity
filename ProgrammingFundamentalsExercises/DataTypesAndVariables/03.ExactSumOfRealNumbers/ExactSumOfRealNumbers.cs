using System;

class ExactSumOfRealNumbers
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        decimal sum = 0;

        for (int i = 1; i <= n; i++)
        {
            decimal number = decimal.Parse(Console.ReadLine());
            sum += number;
        }

        Console.WriteLine(sum);
    }
}