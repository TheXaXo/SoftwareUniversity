using System;

class Program
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());

        Console.WriteLine("{ " + string.Join(", ", GetMiddleElements(array)) + " }");
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

    static int[] GetMiddleElements(int[] array)
    {
        int length = 0;

        if (array.Length == 1)
        {
            length = 1;
        }
        else if (array.Length % 2 == 0)
        {
            length = 2;
        }
        else if (array.Length % 2 != 0)
        {
            length = 3;
        }

        int[] middleElements = new int[length];

        if (array.Length == 1)
        {
            middleElements[0] = array[0];
        }
        else if (array.Length % 2 == 0)
        {
            int count = 0;
            for (int i = (array.Length - 2) / 2; i <= array.Length / 2; i++)
            {
                middleElements[count] = array[i];
                count++;
            }
        }
        else if (array.Length % 2 != 0)
        {
            int count = 0;
            for (int i = array.Length / 2 - 1; i <= array.Length / 2 + 1; i++)
            {
                middleElements[count] = array[i];
                count++;
            }
        }
        
        return middleElements;
    }
}