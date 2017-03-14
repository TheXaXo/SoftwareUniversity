using System;

class GreaterNumber
{
    static void Main(string[] args)
    {
        int n1 = int.Parse(Console.ReadLine());
        int n2 = int.Parse(Console.ReadLine());
        Console.WriteLine(Math.Max(n1, n2));
    }
}