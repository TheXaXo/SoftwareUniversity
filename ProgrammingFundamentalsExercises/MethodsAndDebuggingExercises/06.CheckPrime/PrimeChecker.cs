using System;

class PrimeChecker
{
    static void Main(string[] args)
    {
        long number = long.Parse(Console.ReadLine());
        bool isPrime = IsPrime(number);
        Console.WriteLine(isPrime);
    }
    static bool IsPrime(long number)
    {
        if (number < 2)
        {
            return false;
        }
        for (long i = 2; i <= Math.Sqrt(number); i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}