using System;
using System.Collections.Generic;
using System.Linq;

class EqualSums
{
    static void Main(string[] args)
    {
        int[] input = Console.ReadLine()
            .Split(' ')
            .Select(int.Parse)
            .ToArray();

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < input.Length; i++)
        {
            for (int left = 0; left <= i; left++)
            {
                leftSum += input[left];
            }

            for (int right = i; right < input.Length; right++)
            {
                rightSum += input[right];
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
}