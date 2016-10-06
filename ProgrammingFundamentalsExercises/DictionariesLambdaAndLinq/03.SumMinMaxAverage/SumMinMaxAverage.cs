using System;
using System.Collections.Generic;
using System.Linq;

class SumMinMaxAverage
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        List<int> list = new List<int>();

        for (int i = 0; i < n; i++)
        {
            int number = int.Parse(Console.ReadLine());
            list.Add(number);
        }

        int sum = list.Sum();
        int min = list.Min();
        int max = list.Max();
        double average = list.Average();

        Console.WriteLine($"Sum = {sum}");
        Console.WriteLine($"Min = {min}");
        Console.WriteLine($"Max = {max}");
        Console.WriteLine($"Average = {average}");
    }
}