using System;

class PrintingTriangleSecondWay
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        PrintWholeTriangle(n);
    }
    static void PrintLine(int start, int end)
    {
        for (int i = start; i<= end; i++)
        {
            Console.Write("{0} ", i);
        }
        Console.WriteLine();
    }
    static void PrintFirstPart(int number)
    {
        for (int i = 1; i <= number; i++)
        {
            PrintLine(1, i);
        }
    }
    static void PrintSecondPart(int number)
    {
        for (int i = 1; i <= number - 1; i++)
        {
            PrintLine(1, number - i);
        }
    }
    static void PrintWholeTriangle(int number)
    {
        PrintFirstPart(number);
        PrintSecondPart(number);
    }
}