using System;
using System.Numerics;

class FactorialTrailingZeroes
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        BigInteger factorialOfN = GetFactorial(n);
        int trailingZeroes = GetTrailingZeroes(factorialOfN);
        Console.WriteLine(trailingZeroes);
    }
    static BigInteger GetFactorial(int n)
    {
        BigInteger factorial = 1;

        for (int i = 1; i <= n; i++)
        {
            factorial *= i;
        }
        return factorial;
    }
    static int GetTrailingZeroes(BigInteger factorial)
    {
        int count = 0;
        BigInteger remainder = 0;
        while (factorial > 0)
        {
            BigInteger.DivRem(factorial, 10, out remainder);
            if(remainder == 0)
            {
                count++;
            }
            else
            {
                return count;
            }
            factorial /= 10;
        }
        return count;
    }
}