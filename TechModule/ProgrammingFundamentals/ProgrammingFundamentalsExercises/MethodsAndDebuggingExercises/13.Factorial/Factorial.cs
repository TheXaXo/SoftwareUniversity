using System;
using System.Numerics;

class Factorial
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        PrintFactorial(n);
    }
    static void PrintFactorial(int n)
    {
        BigInteger factorialOfN = 1;

        for (int i = 1; i <= n; i++)
        {
            factorialOfN *= i;
        }
        Console.WriteLine(factorialOfN);
    }
}