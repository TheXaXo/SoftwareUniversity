using System;

class CondenseArrayToNumber
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        
        while (array.Length > 1)
        {
            int[] condensed = new int[array.Length - 1];
            for (int i = 0; i < array.Length - 1; i++)
            {
                condensed[i] = array[i] + array[i + 1];
            }
            array = condensed;
        }
        Console.WriteLine(array[0]);
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