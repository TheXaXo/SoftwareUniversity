using System;
using System.Collections.Generic;
using System.Linq;

class LargestThreeNumbers
{
    static void Main(string[] args)
    {
        List<double> numbers = Console.ReadLine()
            .Split(' ')
            .Select(double.Parse)
            .OrderByDescending(n => n)
            .Take(3)
            .ToList();

        Console.WriteLine(string.Join(" ", numbers));
    }
}