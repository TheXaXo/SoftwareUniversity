using System;
using System.Collections.Generic;

class RotateAndSum
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        int k = int.Parse(Console.ReadLine());
        int[] arraySummed = new int[array.Length];

        for (int i = 1; i <= k; i++)
        {
            array = RotateArrayRight(array);
            arraySummed = GetSumFromArray(array, arraySummed);
        }

        Console.WriteLine(string.Join(" ", arraySummed));
    }

    static int[] GetIntArray(string input)
    {
        string[] inputArray = input.Split(' ');
        int[] array = new int[inputArray.Length];

        for (int i = 0; i < inputArray.Length; i++)
        {
            array[i] = int.Parse(inputArray[i]);
        }

        return array;
    }

    static int[] RotateArrayRight(int[] array)
    {
        int[] rotated = new int[array.Length];
        rotated[0] = array[array.Length - 1];

        for (int i = 1; i < array.Length; i++)
        {
            rotated[i] = array[i - 1];
        }

        return rotated;
    }

    static int[] GetSumFromArray(int[] array, int[] arraySummed)
    {
        
        for (int i = 0; i < array.Length; i++)
        {
            arraySummed[i] += array[i];
        }

        return arraySummed;
    }
}