using System;
using System.Collections.Generic;

class ArrayManipulator
{
    static void Main(string[] args)
    {
        List<int> input = GetListFromInput(Console.ReadLine());
        string[] command = Console.ReadLine().Split(' ');

        while(command[0] != "print")
        {
            if (command[0] == "add")
            {
                int index = int.Parse(command[1]);
                int element = int.Parse(command[2]);

                input.Insert(index, element);
            }
            else if (command[0] == "addMany")
            {
                int index = int.Parse(command[1]);

                for (int i = 2; i < command.Length; i++)
                {
                    int element = int.Parse(command[i]);
                    input.Insert(index, element);
                    index++;
                }
            }
            else if (command[0] == "contains")
            {
                int element = int.Parse(command[1]);
                bool hasBeenFound = false;

                for (int i = 0; i < input.Count; i++)
                {
                    if (input[i] == element)
                    {
                        Console.WriteLine(i);
                        hasBeenFound = true;
                        break;
                    }
                }

                if (!hasBeenFound)
                {
                    Console.WriteLine(-1);
                }
            }
            else if (command[0] == "remove")
            {
                int index = int.Parse(command[1]);
                input.RemoveAt(index);
            }
            else if (command[0] == "shift")
            {
                int positions = int.Parse(command[1]);
                List<int> shifted = new List<int>(input);

                for (int i = 0; i < input.Count; i++)
                {
                    int nextSpot = i - positions;
                    while (nextSpot < 0)
                    {
                        nextSpot = input.Count - Math.Abs(nextSpot);
                    }

                    shifted[nextSpot] = input[i];
                }

                input = shifted;
            }
            else if (command[0] == "sumPairs")
            {
                List<int> pairsSum = new List<int>();
                int sum = 0;

                for (int i = 0; i < input.Count; i++)
                {
                    if (i % 2 == 0 && i != 0)
                    {
                        pairsSum.Add(sum);
                        sum = 0;
                    }
                    sum += input[i];
                }

                pairsSum.Add(sum);
                input = pairsSum;
            }

            command = Console.ReadLine().Split(' ');
        }

        Console.WriteLine("[" + string.Join(", ", input) + "]");
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