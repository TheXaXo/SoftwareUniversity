using System;

class GreatestCommonDivisor
{
    static void Main(string[] args)
    {
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());       
        int residue = a % b;

        while (residue != 0)
        {            
            a = b;
            b = residue;
            residue = a % b;
        }

        Console.WriteLine(b);
    }
}