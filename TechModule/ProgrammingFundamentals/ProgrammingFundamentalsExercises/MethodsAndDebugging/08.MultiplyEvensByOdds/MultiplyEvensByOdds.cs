using System;

class MultiplyEvensByOdds
{
    static void Main(string[] args)
    {
        int n = Math.Abs(int.Parse(Console.ReadLine()));
        int sumOfEvenDigits = GetSumOfEvenDigits(n);
        int sumOfOddDigits = GetSumOfOddDigits(n);

        int result = sumOfEvenDigits * sumOfOddDigits;
        Console.WriteLine(result);
    }
    static int GetSumOfEvenDigits(int number)
    {
        int evenSum = 0;
        int lastDigit = 0;
        while (number > 0)
        {
            lastDigit = number % 10;
            if (lastDigit % 2 == 0)
            {
                evenSum += lastDigit;
            }
            number /= 10;
        }       
        return evenSum;
    }
    static int GetSumOfOddDigits(int number)
    {
        int oddSum = 0;
        int lastDigit = 0;
        while (number > 0)
        {
            lastDigit = number % 10;
            if (lastDigit % 2 != 0)
            {
                oddSum += lastDigit;
            }
            number /= 10;
        }
        return oddSum;
    }
}