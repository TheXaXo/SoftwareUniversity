using System;

class DrawAFilledSquare
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        DrawFilledSquare(n);
    }
    static void DrawFirstOrLastPart(int number)
    {
        Console.WriteLine(new string('-', 2 * number));
    }
    static void DrawMiddlePart(int number)
    {
        for (int i = 1; i <= number - 2; i++)
        {
            Console.Write("-");
            for (int j = 1; j <= number - 1; j++)
            {
                Console.Write("\\/");
            }
            Console.WriteLine("-");
        }
    }
    static void DrawFilledSquare(int number)
    {
        DrawFirstOrLastPart(number);
        DrawMiddlePart(number);
        DrawFirstOrLastPart(number);
    }
}