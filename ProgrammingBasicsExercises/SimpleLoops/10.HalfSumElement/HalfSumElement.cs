using System;

class HalfSumElement
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int maxNumber = 0;
        int sum = 0;

        for (int i = 1; i <= n; i++)
        {
            int number = int.Parse(Console.ReadLine());
            sum += number;
            if (i == 1)
            {
                maxNumber = number;
                continue;
            }
            if (number > maxNumber)
            {
                maxNumber = number;
            }
        }
        if (sum - maxNumber == maxNumber)
        {
            Console.WriteLine("Yes, sum = {0}", maxNumber);
        }
        else
        {
            Console.WriteLine("No, diff = {0}", Math.Abs(maxNumber - (sum - maxNumber)));
        }
    }
}