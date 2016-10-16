using System;
using System.Collections.Generic;
using System.Linq;

class MaxSequenceOfEqualElements
{
    static void Main(string[] args)
    {
        int[] input = Console.ReadLine()
            .Split(' ')
            .Select(int.Parse)
            .ToArray();

        int streakCount = 0;
        int bestStreak = 0;
        int number = 0;

        for (int i = 0; i < input.Length; i++)
        {
            for (int j = i; j < input.Length; j++)
            {
                if (input[i] == input[j])
                {
                    streakCount++;
                    if (streakCount > bestStreak)
                    {
                        bestStreak = streakCount;
                        number = input[i];
                    }
                }
            }
            streakCount = 0;
        }

        for (int i = 0; i < bestStreak; i++)
        {
            Console.Write(number + " ");
        }
        Console.WriteLine();
    }
}