using System;

class FibonacciNumbers
{
    static void Main(string[] args)
    {
        int nFibonacciNumber = int.Parse(Console.ReadLine());

        Fib(nFibonacciNumber);
    }
    static void Fib (int n)
    {
        int first = 1;
        int second = 1;
 
        for (int i = 0; i <= n; i++)
        {
            if (i == 0)
            {
                if (n == 0)
                {
                    Console.WriteLine(first);
                }
                continue;
            }
            int oldFirst = first;
            first = second;
            second = oldFirst + second;
            
            if (i == n)
            {
                Console.WriteLine(first);
            }
        }
    }
}