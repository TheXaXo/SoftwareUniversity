using System;
using System.Collections.Generic;

class SquareNumbers
{
    static void Main(string[] args)
    {
        int[] array = GetIntArrayFromInput(Console.ReadLine());
        List<int> squareNumbersList = new List<int>();

        bool isSquare = false;

        for (int i = 0; i < array.Length; i++)
        {
            int currentElement = array[i];
            if (Math.Sqrt(currentElement) % 1 == 0)
            {
                isSquare = true;
            }

            if (isSquare)
            {
                squareNumbersList.Add(currentElement);
            }
            isSquare = false;
        }

        squareNumbersList.Sort((a, b) => b.CompareTo(a));
        Console.WriteLine(string.Join(" ", squareNumbersList));
    }

    static int[] GetIntArrayFromInput(string input)
    {
        string[] split = input.Split(' ');
        int[] array = new int[split.Length];

        for (int i = 0; i < split.Length; i++)
        {
            array[i] = int.Parse(split[i]);
        }

        return array;
    }
}