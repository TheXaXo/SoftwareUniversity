using System;

class TrippleSum
{
    static void Main(string[] args)
    {
        string[] arrayAsString = Console.ReadLine().Split(' ');
        long[] array = new long[arrayAsString.Length];

        for (int i = 0; i < arrayAsString.Length; i++)
        {
            array[i] = long.Parse(arrayAsString[i]);
        }

        bool doesExist = false;
        bool hasBeenPrinted = false;

        for (int i = 0; i < array.Length; i++)
        {
            for (int j = i + 1; j < array.Length; j++)
            {
                for (int k = 0; k < array.Length; k++)
                {
                    if (array[i] + array[j] == array[k])
                    {
                        Console.WriteLine($"{array[i]} + {array[j]} == {array[k]}");
                        hasBeenPrinted = true;
                        doesExist = true;
                    }
                    if (hasBeenPrinted)
                    {
                        hasBeenPrinted = false;
                        break;
                    }
                }
            }
        }

        if (!doesExist)
        {
            Console.WriteLine("No");
        }
    }
}