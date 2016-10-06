using System;

class MaxSequenceOfIncreasingElement
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        int streak = 1;
        int bestStreak = 0;
        int endNumber = 0;
        int bestEnd = 0;

        for (int i = 1; i < array.Length; i++)
        {
            if (array[i] > array[i - 1])
            {
                streak++;
                endNumber = i;

                if (streak > bestStreak)
                {
                    bestStreak = streak;
                    bestEnd = endNumber;
                }
            }
            else
            {
                streak = 1;
            }
        }

        for (int i = bestEnd - bestStreak + 1; i <= bestEnd; i++)
        {
            Console.Write($"{array[i]} ");
        }
        Console.WriteLine();
    }

    static int[] GetIntArray(string input)
    {
        string[] split = input.Split(' ');
        int[] intArray = new int[split.Length];

        for (int i = 0; i < split.Length; i++)
        {
            intArray[i] = int.Parse(split[i]);
        }

        return intArray;
    }
}