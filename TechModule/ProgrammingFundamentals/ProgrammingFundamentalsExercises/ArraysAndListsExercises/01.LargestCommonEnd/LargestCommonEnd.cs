using System;
using System.Collections.Generic;

class LargestCommonEnd
{
    static void Main(string[] args)
    {
        string[] inputOne = Console.ReadLine().Split(' ');
        string[] inputTwo = Console.ReadLine().Split(' ');
        string[] longerArray = new string[Math.Max(inputOne.Length, inputTwo.Length)];
        string[] shorterArray = new string[Math.Min(inputOne.Length, inputTwo.Length)];

        if (inputOne.Length >= inputTwo.Length)
        {
            longerArray = inputOne;
            shorterArray = inputTwo;
        }
        else 
        {
            longerArray = inputTwo;
            shorterArray = inputOne;
        }

        int countLeft = 0;

        for (int i = 0; i < shorterArray.Length; i++)
        {
            if (shorterArray[i] == longerArray[i])
            {
                countLeft++;
            }
            else
            {
                break;
            }
        }

        int longerArrayPosition = longerArray.Length - 1;
        int countRight = 0;

        for (int i = shorterArray.Length - 1; i >= 0; i--)
        {
            if (shorterArray[i] == longerArray[longerArrayPosition])
            {
                countRight++;
                longerArrayPosition--;
            }
        }

        Console.WriteLine(Math.Max(countRight, countLeft));
    }
}