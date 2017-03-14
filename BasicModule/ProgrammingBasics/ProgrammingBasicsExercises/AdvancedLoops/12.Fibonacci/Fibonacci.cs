using System;

class Fibonacci
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int a = 1;
        int b = 1;
        int sum = 0;

        for (int i = 1; i <= n - 1; i++)
        {
            sum = a + b;
            a = b;
            b = sum;
        }

        Console.WriteLine(b);
    }
}