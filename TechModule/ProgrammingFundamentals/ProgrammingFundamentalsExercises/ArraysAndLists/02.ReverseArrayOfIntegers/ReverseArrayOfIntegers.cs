using System;

class ReverseArrayOfIntegers
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int[] arrayOfIntegers = new int[n];

        for (int i = 1; i <= n; i++)
        {
            int number = int.Parse(Console.ReadLine());
            arrayOfIntegers[i - 1] = number;
        }

        int[] arrayOfIntegersReversed = new int[n];
        int position = 0;

        for (int i = arrayOfIntegers.Length - 1; i >= 0; i--)
        {
            arrayOfIntegersReversed[position] = arrayOfIntegers[i];
            position++;
        }

        Console.WriteLine(string.Join(" ", arrayOfIntegersReversed));
    }
}