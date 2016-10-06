using System;

class EqualSums
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < array.Length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                leftSum += array[j];
            }
            for (int j = i + 1; j < array.Length; j++)
            {
                rightSum += array[j];
            }

            if (leftSum == rightSum)
            {
                Console.WriteLine(i);
                return;
            }
            leftSum = 0;
            rightSum = 0;
        }

        Console.WriteLine("no");
    }

    static int[] GetIntArray(string input)
    {
        string[] split = input.Split(' ');
        int[] intArray = new int[split.Length];

        for (int i = 0; i < split.Length; i++)
        {
            intArray[i] = int.Parse(split[i]);
        }

        return intArray;
    }
}