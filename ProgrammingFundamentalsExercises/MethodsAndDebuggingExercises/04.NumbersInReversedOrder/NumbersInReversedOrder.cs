using System;

class NumbersInReversedOrder
{
    static void Main(string[] args)
    {
        double number = double.Parse(Console.ReadLine());
        PrintNumberInReversed(number);
    }
    static void PrintNumberInReversed (double number)
    {
        string reversedNumber = null;
        for (int i = number.ToString().Length - 1; i >= 0; i--)
        {
            reversedNumber += number.ToString()[i];
        }
        Console.WriteLine(reversedNumber);
    }
}