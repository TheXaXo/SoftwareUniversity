using System;

class PrimesInGivenRange
{
    static void Main(string[] args)
    {
        int startNumber = int.Parse(Console.ReadLine());
        int endNumber = int.Parse(Console.ReadLine());

        PrintPrimeNumbersInRange(startNumber, endNumber);
    }
    static void PrintPrimeNumbersInRange(int startNumber, int endNumber)
    {
        string list = null;
        bool hasBrokenFromTheLoop = false;

        for (int currentNumber = startNumber; currentNumber <= endNumber; currentNumber++)
        {
            for (int i = 2; i <= Math.Sqrt(currentNumber); i++)
            {
                hasBrokenFromTheLoop = false;
                if (currentNumber % i == 0)
                {
                    hasBrokenFromTheLoop = true;
                    break;
                }
            }
            if (!hasBrokenFromTheLoop && currentNumber > 1)
            {
                list += currentNumber + ", ";
            }
        }
        list = list.Remove(list.Length - 2);
        Console.WriteLine(list);
    }
}