using System;

class PairsByDifference
{
    static void Main(string[] args)
    {
        int[] array = GetIntArray(Console.ReadLine());
        int differece = int.Parse(Console.ReadLine());
        int count = 0;

        for (int i = 0; i < array.Length; i++)
        {
            for (int j = i + 1; j < array.Length; j++)
            {
                if (Math.Abs(array[i] - array[j]) == differece)
                {
                    count++;
                }
            }
        }

        Console.WriteLine(count);
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