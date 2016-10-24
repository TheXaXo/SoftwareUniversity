using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Numerics;

class Program
{
    static void Main(string[] args)
    {
        int dayCount = int.Parse(Console.ReadLine());
        int runnersCount = int.Parse(Console.ReadLine());
        int averageNumberOfLaps = int.Parse(Console.ReadLine());
        int lapLength = int.Parse(Console.ReadLine());
        int runnersCapacity = int.Parse(Console.ReadLine());
        decimal moneyPerKilometer = decimal.Parse(Console.ReadLine());

        if (runnersCount > runnersCapacity * dayCount)
        {
            runnersCount = runnersCapacity * dayCount;
        }

        ulong totalKilometers = (ulong)runnersCount * (ulong)averageNumberOfLaps * (ulong)lapLength / 1000;
        decimal moneyRaised = totalKilometers * moneyPerKilometer;

        Console.WriteLine($"Money raised: {moneyRaised:f2}");
    }
}