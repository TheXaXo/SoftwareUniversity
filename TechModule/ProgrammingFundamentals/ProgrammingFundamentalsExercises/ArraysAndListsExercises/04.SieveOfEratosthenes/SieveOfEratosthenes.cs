using System;
using System.Collections.Generic;

class SieveOfEratosthenes
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        bool[] checkNumbers = new bool[n + 1];
        int[] allNumbers = new int[n + 1];
        List<int> onlyPrimeNumbers = new List<int>();

        for (int i = 0; i < checkNumbers.Length; i++)
        {
            checkNumbers[i] = true;
            allNumbers[i] = i;
        }

        for (int i = 2; i < allNumbers.Length; i++)
        {
            if(checkNumbers[i])
            {
                onlyPrimeNumbers.Add(allNumbers[i]);

                for (int j = i + 1; j < allNumbers.Length; j++)
                {
                    if (allNumbers[j] % allNumbers[i] == 0)
                    {
                        checkNumbers[j] = false;
                    }
                }
            }
        }

        Console.WriteLine(string.Join(" ", onlyPrimeNumbers));
    }
}