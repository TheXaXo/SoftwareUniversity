using System;

class Program
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int lastSum = 0;
        int difference = 0;
        int maxDifference = 0;
        bool areDifferent = false;

        for (int i = 1; i <= n; i++)
        {
            int numberOne = int.Parse(Console.ReadLine());
            int numberTwo = int.Parse(Console.ReadLine());
            int sum = numberOne + numberTwo;
            if (i == 1)
            {
                lastSum = sum;
                continue;
            }
            if (lastSum == sum)
            {
                continue;
            }
            else
            {
                areDifferent = true;
                difference = Math.Abs(lastSum - sum);
                if (difference > maxDifference)
                {
                    maxDifference = difference;
                }
            }
            lastSum = sum;
        }

        if (areDifferent)
        {
            Console.WriteLine("No, maxdiff={0}", maxDifference);
        }
        else
        {
            Console.WriteLine("Yes, value={0}", lastSum);
        }
    }
}