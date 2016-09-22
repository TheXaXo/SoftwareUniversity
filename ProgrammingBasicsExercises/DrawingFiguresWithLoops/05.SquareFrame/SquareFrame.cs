using System;

class SquareFrame
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.Write("+ ");
        for (int i = 1; i <= n - 2; i++)
        {
            Console.Write("- ");
        }
        Console.WriteLine("+");

        //Second Part
        for (int i = 1; i <= n - 2; i++)
        {
            Console.Write("| ");
            for (int j = 1; j <= n - 2; j++)
            {
                Console.Write("- ");
            }
            Console.WriteLine("|");
        }

        //Third Part
        Console.Write("+ ");
        for (int i = 1; i <= n - 2; i++)
        {
            Console.Write("- ");
        }
        Console.WriteLine("+");
    }
}