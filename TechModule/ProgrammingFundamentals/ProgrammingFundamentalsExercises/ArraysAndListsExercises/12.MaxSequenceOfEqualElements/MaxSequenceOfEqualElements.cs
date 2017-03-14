using System;
using System.Collections.Generic;

class MaxSequenceOfEqualElements
{
    static void Main(string[] args)
    {
        List<int> listFromInput = GetListFromInput(Console.ReadLine());
        int streak = 1;
        int bestStreak = 1;
        int endIndex = 0;
        int bestEndIndex = 0;

        for (int i = 1; i < listFromInput.Count; i++)
        {
            if (listFromInput[i] == listFromInput[i - 1])
            {
                streak++;
                endIndex = i;

                if (streak > bestStreak)
                {
                    bestStreak = streak;
                    bestEndIndex = endIndex;
                }
            }
            else
            {
                streak = 1;
            }
        }

        for (int i = bestEndIndex - bestStreak + 1; i <= bestEndIndex; i++)
        {
            Console.Write($"{listFromInput[i]} ");
        }
        Console.WriteLine();
    }

    static List<int> GetListFromInput(string input)
    {
        string[] inputArray = input.Split(' ');
        List<int> listFromInput = new List<int>();

        for (int i = 0; i < inputArray.Length; i++)
        {
            listFromInput.Add(int.Parse(inputArray[i]));
        }

        return listFromInput;
    }
}