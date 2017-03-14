using System;
using System.Collections.Generic;

class FoldAndSum
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        int[] foldPartOne = new int[array.Length / 4];
        int[] foldPartTwo = new int[array.Length / 2];
        int[] foldPartThree = new int[array.Length / 4]; 

        for (int i = 0; i < array.Length / 4; i++)
        {
            foldPartOne[i] = array[i];
        }

        int count = 0;

        for (int i = array.Length / 4; i < array.Length / 4 + array.Length / 2; i++)
        {
            foldPartTwo[count] = array[i];
            count++;
        }

        count = 0;

        for (int i = array.Length / 4 + array.Length / 2; i < array.Length; i++)
        {
            foldPartThree[count] = array[i];
            count++;
        }

        foldPartOne = ReverseArray(foldPartOne);
        foldPartThree = ReverseArray(foldPartThree);

        int[] summedArray = GetSumOfFoldedArray(foldPartOne, foldPartTwo, foldPartThree);
        Console.WriteLine(string.Join(" ", summedArray));
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

    static int[] ReverseArray(int[] array)
    {
        int[] arrayReversed = new int[array.Length];
        int count = 0;

        for (int i = array.Length - 1; i >= 0; i--)
        {
            arrayReversed[count] = array[i];
            count++;
        }

        return arrayReversed;
    }

    static int[] GetSumOfFoldedArray(int[] foldPartOne, int[] foldPartTwo, int[] foldPartThree)
    {
        int[] summedArray = new int[foldPartTwo.Length];

        for (int i = 0; i <= foldPartTwo.Length / 2 - 1; i++)
        {
            summedArray[i] = foldPartOne[i] + foldPartTwo[i];
        }

        int count = 0;

        for (int i = foldPartTwo.Length / 2; i < foldPartTwo.Length; i++)
        {
            summedArray[i] = foldPartThree[count] + foldPartTwo[i];
            count++;
        }

        return summedArray;
    }
}