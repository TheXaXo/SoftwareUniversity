using System;
using System.Collections.Generic;

class CompareCharArrays
{
    static void Main(string[] args)
    {
        char[] arrayOne = GetCharArray(Console.ReadLine());
        char[] arrayTwo = GetCharArray(Console.ReadLine());

        char[] greaterArray = GetGreaterArray(arrayOne, arrayTwo);
        char[] lesserArray = GetLesserArray(arrayOne, arrayTwo);

        Console.WriteLine(string.Join("", lesserArray));
        Console.WriteLine(string.Join("", greaterArray));
    }

    static char[] GetCharArray(string input)
    {
        string[] inputArray = input.Split(' ');
        char[] array = new char[inputArray.Length];

        for (int i = 0; i < array.Length; i++)
        {
            array[i] = char.Parse(inputArray[i]);
        }

        return array;
    }

    static char[] GetGreaterArray(char[] arrayOne, char[] arrayTwo)
    {
        for (int i = 0; i < Math.Min(arrayOne.Length, arrayTwo.Length); i++)
        {
            if (arrayOne[i] > arrayTwo[i])
            {
                return arrayOne;
            }
            else if (arrayTwo[i] > arrayOne[i])
            {
                return arrayTwo;
            }
        }
        if (arrayOne.Length < arrayTwo.Length)
        {
            return arrayTwo;
        }
        else
        {
            return arrayOne;
        }
    }

    static char[] GetLesserArray(char[] arrayOne, char[] arrayTwo)
    {
        char[] greaterArray = GetGreaterArray(arrayOne, arrayTwo);
        if (greaterArray == arrayOne)
        {
            return arrayTwo;
        }
        else
        {
            return arrayOne;
        }
    }
}