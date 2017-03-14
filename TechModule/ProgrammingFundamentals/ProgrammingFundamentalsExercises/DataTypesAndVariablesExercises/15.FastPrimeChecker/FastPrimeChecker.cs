using System;

class FastPrimeChecker
{
    static void Main(string[] args)
    {
        int number = int.Parse(Console.ReadLine());
        bool isPrime = true;

        for (int i = 2; i <= number; i++)
        {
            int currentNumber = i;
            for (int j = 2; j < number; j++)
            {
                if (currentNumber % j == 0 && currentNumber != j)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                Console.WriteLine("{0} -> True", currentNumber);
            }
            else
            {
                Console.WriteLine("{0} -> False", currentNumber);
            }
            isPrime = true;
        }
    }
}