using System;
using System.Linq;

public class SequenceOfCommands
{
    const char ArgumentsDelimiter = ' ';

    static void Main()
    {
        int sizeOfArray = int.Parse(Console.ReadLine());

        long[] array = Console.ReadLine()
            .Split(ArgumentsDelimiter)
            .Select(long.Parse)
            .ToArray();

        string command = Console.ReadLine();

        while (!command.Equals("stop"))
        {
            string line = command;
            int[] args = new int[2];
            string[] stringParams = line.Split(ArgumentsDelimiter);
            string action = stringParams[0];

            if (action.Equals("add") ||
                action.Equals("subtract") ||
                action.Equals("multiply"))
            {
                args[0] = int.Parse(stringParams[1]);
                args[1] = int.Parse(stringParams[2]);

                PerformAction(array, action, args);
            }
            else
            {
                PerformAction(array, action, args);
            }

            PrintArray(array);
            command = Console.ReadLine();
        }
    }

    static void PerformAction(long[] array, string action, int[] args)
    {
        int pos = args[0] - 1;
        int value = args[1];

        switch (action)
        {
            case "multiply":
                array[pos] *= value;
                break;
            case "add":
                array[pos] += value;
                break;
            case "subtract":
                array[pos] -= value;
                break;
            case "lshift":
                ArrayShiftLeft(array);
                break;
            case "rshift":
                ArrayShiftRight(array);
                break;
        }
    }

    static void ArrayShiftRight(long[] array)
    {
        long lastNumber = array[array.Count() - 1];
        for (int i = array.Count() - 1; i > 0; i--)
        {
            array[i] = array[i - 1];
        }
        array[0] = lastNumber;
    }

    static void ArrayShiftLeft(long[] array)
    {
        long firstNumber = array[0];
        for (int i = 0; i < array.Count() - 1; i++)
        {
            array[i] = array[i + 1];
        }
        array[array.Count() - 1] = firstNumber;
    }

    static void PrintArray(long[] array)
    {
        for (int i = 0; i < array.Length; i++)
        {
            Console.Write(array[i] + " ");
        }
        Console.WriteLine();
    }
}
