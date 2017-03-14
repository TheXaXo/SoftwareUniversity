using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        int[] input = Console.ReadLine()
            .Split(' ')
            .Select(int.Parse)
            .ToArray();

        int count = 0;
        int longestCount = 0;
        int mostFrequentNumber = 0;

        for (int i = 0; i < input.Length; i++)
        {
            for (int j = i; j < input.Length; j++)
            {
                if (input[i] == input[j])
                {
                    count++;
                    if (count > longestCount)
                    {
                        mostFrequentNumber = input[i];
                        longestCount = count;
                    }
                }
            }
            count = 0;
        }

        Console.WriteLine(mostFrequentNumber);
    }
}