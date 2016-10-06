using System;
using System.Collections.Generic;

class BombNumbers
{
    static void Main(string[] args)
    {
        List<int> input = GetListFromInput(Console.ReadLine());
        string[] command = Console.ReadLine().Split(' ');
        int bombNumber = int.Parse(command[0]);
        int power = int.Parse(command[1]);

        for (int i = 0; i < input.Count; i++)
        {
            if (input[i] == bombNumber)
            {
                int rangeStart = i - power;

                if (rangeStart < 0)
                {
                    rangeStart = 0;
                }

                int rangeEnd = i + power;

                if (rangeEnd > input.Count - 1)
                {
                    rangeEnd = input.Count - 1;
                }

                int count = rangeEnd - rangeStart + 1;
                input.RemoveRange(rangeStart, count);
                i = 0;
            }
        }

        int sumOfElements = GetSumOfElements(input);
        Console.WriteLine(sumOfElements);
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

    static int GetSumOfElements(List<int> list)
    {
        int sum = 0;

        for (int i = 0; i < list.Count; i++)
        {
            sum += list[i];
        }

        return sum;
    }
}