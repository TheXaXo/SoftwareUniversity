using System;

class PointInFigure
{
    static void Main(string[] args)
    {
        int x = int.Parse(Console.ReadLine());
        int y = int.Parse(Console.ReadLine());

        //Figure 1
        int x1Figure1 = 4;
        int x2Figure1 = 10;
        int y1Figure1 = 3;
        int y2Figure1 = -5;

        //Figure 2
        int x1Figure2 = 2;
        int x2Figure2 = 12;
        int y1Figure2 = 1;
        int y2Figure2 = -3;

        if ((x >= x1Figure1 && x <= x2Figure1 && y <= y1Figure1 && y >= y2Figure1) || (x >= x1Figure2 && x <= x2Figure2 && y <= y1Figure2 && y >= y2Figure2))
        {
            Console.WriteLine("in");
        }
        else
        {
            Console.WriteLine("out");
        }
    }
}