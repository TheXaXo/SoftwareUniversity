using System;
using System.Collections.Generic;

class Program
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        List<int> fixedArray = new List<int>();
        bool hasItems = false;

        for (int i = array.Length - 1; i >= 0; i--)
        {
            if (array[i] >= 0)
            {
                fixedArray.Add(array[i]);
                hasItems = true;
            }
        }

        if(!hasItems)
        {
            Console.WriteLine("empty");
        }
        else
        {
            Console.WriteLine(string.Join(" ", fixedArray));
        }
    }

    static int[] GetIntArray(string input)
    {
        string[] arrayAsString = input.Split(' ');
        int[] intArray = new int[arrayAsString.Length];

        for (int i = 0; i < arrayAsString.Length; i++)
        {
            intArray[i] = int.Parse(arrayAsString[i]);
        }
        return intArray;
    }
}