using System;

class RoundingNumbers
{
    static void Main(string[] args)
    {
        string[] numbersAsString = Console.ReadLine().Split(' ');
        double[] numbers = new double[numbersAsString.Length];

        for (int i = 0; i < numbersAsString.Length; i++)
        {
            numbers[i] = double.Parse(numbersAsString[i]);
        }

        double[] roundedNumbers = new double[numbers.Length];

        for (int i = 0; i < numbers.Length; i++)
        {
            roundedNumbers[i] = Math.Round(numbers[i], MidpointRounding.AwayFromZero);
        }

        for (int i = 0; i < roundedNumbers.Length; i++)
        {
            Console.WriteLine("{0} => {1}", numbers[i], roundedNumbers[i]);
        }
    }
}