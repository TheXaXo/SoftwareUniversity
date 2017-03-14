using System;

class PrintPartOfASCIITable
{
    static void Main(string[] args)
    {
        int firstCode = int.Parse(Console.ReadLine());
        int lastCode = int.Parse(Console.ReadLine());

        for (int i = firstCode; i <= lastCode; i++)
        {
            char symbol = (char)(i);
            Console.Write("{0} ", symbol);
        }
        Console.WriteLine();
    }
}