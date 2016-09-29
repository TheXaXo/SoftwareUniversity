using System;

class MasterNumbers
{
    static void Main(string[] args)
    {
        int number = int.Parse(Console.ReadLine());
        PrintsMasterNumber(number);
    }

    static void PrintsMasterNumber(int number)
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
        if (number < 10)
        {
            return true;
        }

        string firstPart = null;
        string secondPartReversed = null;
        int numberLength = number.ToString().Length;

        if (numberLength % 2 == 0)
        {
            for (int i = 0; i <= numberLength / 2 - 1; i++)
            {
                firstPart += int.Parse(number.ToString()[i].ToString());
            }
            for (int i = numberLength - 1; i >= numberLength / 2; i--)
            {
                secondPartReversed += int.Parse(number.ToString()[i].ToString());
            }
        }
        else
        {
            for (int i = 0; i <= numberLength / 2 - 1; i++)
            {
                firstPart += int.Parse(number.ToString()[i].ToString());
            }
            for (int i = numberLength - 1; i >= numberLength / 2 + 1; i--)
            {
                secondPartReversed += int.Parse(number.ToString()[i].ToString());
            }
        }

        if (firstPart == secondPartReversed)
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
        for (int i = 0; i < number.ToString().Length; i++)
        {
            if (int.Parse(number.ToString()[i].ToString()) % 2 == 0)
            {
                return true;
            }
        }
        return false;
    }
}