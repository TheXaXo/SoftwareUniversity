using System;

class EnglishNameOfLastDigit
{
    static void Main(string[] args)
    {
        decimal number = decimal.Parse(Console.ReadLine());
        string textFromLastDigit = GetNameOfLastDigit(number);
        Console.WriteLine(textFromLastDigit);
    }
    static string GetNameOfLastDigit (decimal number)
    {
        number = Math.Abs(number);
        string textFromLastDigit = null;
        int lastDigit = (int)(number % 10);

        if (lastDigit == 1)
            textFromLastDigit = "one";
        else if (lastDigit == 2)
            textFromLastDigit = "two";
        else if (lastDigit == 3)
            textFromLastDigit = "three";
        else if (lastDigit == 4)
            textFromLastDigit = "four";
        else if (lastDigit == 5)
            textFromLastDigit = "five";
        else if (lastDigit == 6)
            textFromLastDigit = "six";
        else if (lastDigit == 7)
            textFromLastDigit = "seven";
        else if (lastDigit == 8)
            textFromLastDigit = "eight";
        else if (lastDigit == 9)
            textFromLastDigit = "nine";
        else if (lastDigit == 0)
            textFromLastDigit = "zero";

        return textFromLastDigit;
    }
}