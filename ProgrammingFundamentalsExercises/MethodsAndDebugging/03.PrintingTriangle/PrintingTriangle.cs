using System;

class Program
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        PrintTriangle(n);
    }
    static void PrintTriangle(int number)
    {
        int numberForPrinting = 1; 
        for (int i = 1; i <= number; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                Console.Write("{0} ", j);
            }
            Console.WriteLine();
        }
        for (int i = 1; i <= number - 1; i++)
        {
            numberForPrinting = 1;
            for (int j = number - i; j >= 1; j--)
            {
                Console.Write("{0} ", numberForPrinting);
                numberForPrinting++;
            }
            Console.WriteLine();
        }
    }
}