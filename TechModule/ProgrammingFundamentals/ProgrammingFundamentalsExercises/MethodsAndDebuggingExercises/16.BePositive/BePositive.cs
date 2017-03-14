using System;
using System.Collections.Generic;

class BePositive
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        for (int i = 1; i <= n; i++)
        {
            string[] input = Console.ReadLine().Trim().Split(' ');
            List<int> numberList = new List<int>();

            for (int j = 0; j < input.Length; j++)
            {
                if (!(input[j] == string.Empty))
                {
                    numberList.Add(int.Parse(input[j]));
                }
            }

            int currentNumber = 0;
            bool hasBeenFound = false;

            for (int j = 0; j < numberList.Count; j++)
            {
                currentNumber = numberList[j];

                if (currentNumber >= 0)
                {
                    Console.Write(currentNumber + " ");
                    hasBeenFound = true;
                }
                else
                {
                    if (numberList.Count > j + 1 && currentNumber + numberList[j + 1] >= 0)
                    {
                        Console.Write(currentNumber + numberList[j + 1] + " ");
                        hasBeenFound = true;
                    }
                    j++;
                }
            }

            if (!hasBeenFound)
            {
                Console.WriteLine("(empty)");
            }
            else
            {
                Console.WriteLine();
            }
            hasBeenFound = false;
        }
    }
}