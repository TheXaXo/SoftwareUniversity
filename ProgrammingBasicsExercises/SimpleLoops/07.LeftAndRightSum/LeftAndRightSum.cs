using System;

class LeftAndRightSum
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 1; i <= 2 * n; i++)
        {
            int number = int.Parse(Console.ReadLine());
            if (i <= n)
            {
                leftSum += number;
            }
            else
            {
                rightSum += number;
            }
        }

        if (leftSum == rightSum)
        {
            Console.WriteLine("Yes, sum = {0}", leftSum);
        }
        else
        {
            Console.WriteLine("No, diff = {0}", Math.Abs(leftSum - rightSum));
        }
    }
}