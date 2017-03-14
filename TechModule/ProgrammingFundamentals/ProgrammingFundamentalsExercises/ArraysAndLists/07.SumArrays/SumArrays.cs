using System;

class SumArrays
{
    static void Main(string[] args)
    {
        int[] arrayOne = GetIntArray(Console.ReadLine());
        int[] arrayTwo = GetIntArray(Console.ReadLine());

        if (arrayOne.Length != arrayTwo.Length)
        {
            int maxLength = Math.Max(arrayOne.Length, arrayTwo.Length);

            int[] arrayOneFixed = new int[maxLength];
            int[] arrayTwoFixed = new int[maxLength];

            int count = 0;

            for (int i = 0; i < arrayOneFixed.Length; i++)
            {
                if (count >= arrayOne.Length)
                {
                    count = 0;
                }
                arrayOneFixed[i] = arrayOne[count];
                count++;
            }

            count = 0;

            for (int i = 0; i < arrayTwoFixed.Length; i++)
            {
                if (count >= arrayTwo.Length)
                {
                    count = 0;
                }
                arrayTwoFixed[i] = arrayTwo[count];
                count++;
            }

            PrintSumOfTwoArrays(arrayOneFixed, arrayTwoFixed);
        }
        else
        {
            PrintSumOfTwoArrays(arrayOne, arrayTwo);
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

    static void PrintSumOfTwoArrays(int[] arrayOne, int[] arrayTwo)
    {
        int[] resultArray = new int[arrayOne.Length];

        for (int i = 0; i < resultArray.Length; i++)
        {
            resultArray[i] = arrayOne[i] + arrayTwo[i];
        }

        Console.WriteLine(string.Join(" ", resultArray));
    }
}