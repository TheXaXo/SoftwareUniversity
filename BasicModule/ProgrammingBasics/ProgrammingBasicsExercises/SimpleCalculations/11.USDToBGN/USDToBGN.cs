using System;

class USDToBGN
{
    static void Main(string[] args)
    {
        double usd = double.Parse(Console.ReadLine());
        double bgn = usd * 1.79549;
        Console.WriteLine("{0} BGN", Math.Round(bgn, 2));
    }
}