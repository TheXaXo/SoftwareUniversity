using System;
using System.Collections.Generic;
using System.Linq;

class CirclesIntersection
{
    static void Main(string[] args)
    {
        Circle circleOne = GetCircle();
        Circle circleTwo = GetCircle();

        Console.WriteLine(circleOne.Intersect(circleTwo) ? "Yes" : "No");
    }

    static Circle GetCircle()
    {
        int[] split = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int x = split[0];
        int y = split[1];
        int radius = split[2];

        Circle circle = new Circle();
        circle.CenterX = x;
        circle.CenterY = y;
        circle.Radius = radius;

        return circle;
    }
}


class Circle
{
    public int CenterX { get; set; }
    public int CenterY { get; set; }
    public int Radius { get; set; }

    public bool Intersect(Circle two)
    {
        int a = CenterX - two.CenterX;
        int b = CenterY - two.CenterY;
        double distance = Math.Sqrt(a * a + b * b);

        if (distance <= Radius + two.Radius)
        {
            return true;
        }
        return false;
    }
}