using System;

class MasterNumbers
{
    static void Main(string[] args)
    {
        int number = int.Parse(Console.ReadLine());
        PrintsMasterNumbers(number);
    }

    static void PrintsMasterNumbers(int number)
    {
        for (int i = 1; i <= number; i++)
        {
            if (IsPalindrome(i) && ItsSumOfDigitsIsDivisibleBySeven(i) && HasAtleastOneEvenDigit(i))
            {
                Console.WriteLine(i);
            }
        }
    }

    static bool IsPalindrome(int number)
    {
        int numberTemp = number;
        int numberReversed = 0;
        int lastDigit = 0;
        while (number > 0)
        {
            lastDigit = number % 10;
            numberReversed = numberReversed * 10 + lastDigit;
            number /= 10;
        }

        if (numberTemp == numberReversed)
        {
            return true;
        }
        return false;
    }

    static bool ItsSumOfDigitsIsDivisibleBySeven(int number)
    {
        int sumOfDigits = 0;
        while (number > 0)
        {
            sumOfDigits += number % 10;
            number /= 10;
        }
        if (sumOfDigits % 7 == 0)
        {
            return true;
        }
        return false;
    }

    static bool HasAtleastOneEvenDigit(int number)
    {
        int lastDigit = 0;
        while (number > 0)
        {
            lastDigit = number % 10;
            if (lastDigit % 2 == 0)
            {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}