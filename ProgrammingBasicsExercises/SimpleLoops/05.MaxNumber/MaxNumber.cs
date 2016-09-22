using System;

class MaxNumber
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int maxNumber = 0;
        for (int i = 1; i <= n; i++)
        {
            int number = int.Parse(Console.ReadLine());
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
        Console.WriteLine(maxNumber);
    }
}