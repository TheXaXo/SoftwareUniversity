using System;

class MaxSequenceOfEqualElements
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        int length = 1;
        int endPoint = 0;
        int bestLength = 1;
        int bestEndPoint = 0;

        for (int i = 1; i < array.Length; i++)
        {
            if (array[i] == array[i - 1])
            {
                length++;
                endPoint = i;

                if (length > bestLength)
                {
                    bestLength = length;
                    bestEndPoint = endPoint;
                }
            }
            else
            {
                length = 1;
            }
        }

        for (int i = bestEndPoint - bestLength + 1; i <= bestEndPoint; i++)
        {
            Console.Write($"{array[i]} ");
        }
        Console.WriteLine();
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
}