using System;

class EqualPairs
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int previousSum = 0;
        int sum = 0;
        int count = 0;
        int maxDifference = 0;
        bool isDifferent = false;

        for (int i = 1; i <= 2 * n; i++)
        {
            int number = int.Parse(Console.ReadLine());
            sum += number;
            count++;
            if (count == 2)
            {
                if (i == 2)
                {
                    count = 0;
                    previousSum = sum;
                    sum = 0;
                }
                else
                {
                    if (sum != previousSum)
                    {
                        if (Math.Abs(sum - previousSum) > maxDifference)
                        {
                            maxDifference = Math.Abs(sum - previousSum);
                        }
                        isDifferent = true;
                    }
                    count = 0;
                    previousSum = sum;
                    sum = 0;
                }
            }
        }
        if (isDifferent == false)
        {
            Console.WriteLine("Yes, value={0}", previousSum);
        }
        else
        {
            Console.WriteLine("No, maxdiff={0}", maxDifference);
        }
    }
}