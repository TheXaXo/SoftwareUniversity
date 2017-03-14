using System;

class MostFrequentNumber
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        int streak = 1;
        int indexOfMostFrequent = 0;
        int bestStreak = 0;

        for (int i = 0; i < array.Length; i++)
        {
            for (int j = 0; j < array.Length; j++)
            {
                if (array[i] == array[j])
                {
                    streak++;
                }
            }

            if (streak > bestStreak)
            {
                indexOfMostFrequent = i;
                bestStreak = streak;
            }
            streak = 1;
        }

        Console.WriteLine(array[indexOfMostFrequent]);
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