using System;

class EvenOddSum
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 1; i <= n; i++)
        {
            int number = int.Parse(Console.ReadLine());
            if (i % 2 == 0)
            {
                evenSum += number;
            }
            else
            {
                oddSum += number;
            }
        }

        if (evenSum == oddSum)
        {
            Console.WriteLine("Yes, sum = {0}", evenSum);
        }
        else
        {
            Console.WriteLine("No, diff = {0}", Math.Abs(evenSum - oddSum));
        }
    }
}