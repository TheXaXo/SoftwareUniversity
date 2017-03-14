using System;

class MinNumber
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int minNumber = 0;

        for (int i = 1; i <= n; i++)
        {
            int number = int.Parse(Console.ReadLine());
            if (i == 1)
            {
                minNumber = number;
                continue;
            }
            if (number < minNumber)
            {
                minNumber = number;
            }
        }
        Console.WriteLine(minNumber);
    }
}