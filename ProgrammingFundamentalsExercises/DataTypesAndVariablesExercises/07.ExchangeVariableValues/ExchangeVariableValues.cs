using System;

class ExchangeVariableValues
{
    static void Main(string[] args)
    {
        int a = 5;
        int b = 10;

        int aNew = b;
        int bNew = a;

        Console.WriteLine("Before: ");
        Console.WriteLine("a = {0}", a);
        Console.WriteLine("b = {0}", b);

        Console.WriteLine("After: ");
        Console.WriteLine("a = {0}", aNew);
        Console.WriteLine("b = {0}", bNew);
    }
}