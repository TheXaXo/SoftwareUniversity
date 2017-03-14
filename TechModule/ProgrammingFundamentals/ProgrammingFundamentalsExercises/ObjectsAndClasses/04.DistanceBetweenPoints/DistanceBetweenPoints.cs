using System;

class DistanceBetweenPoints
{
    static void Main(string[] args)
    {
        Point pointOne = GetPoint();
        Point pointTwo = GetPoint();

        double distance = CalculateDistance(pointOne, pointTwo);

        Console.WriteLine($"{distance:f3}");
    }

    static Point GetPoint()
    {
        string input = Console.ReadLine();
        string[] split = input.Split(' ');
        int x = int.Parse(split[0]);
        int y = int.Parse(split[1]);

        Point point = new Point();
        point.X = x;
        point.Y = y;

        return point;
    }

    static double CalculateDistance(Point p1, Point p2)
    {
        int a = p1.X - p2.X;
        int b = p1.Y - p2.Y;

        return Math.Sqrt(a * a + b * b);
    }
}

class Point
{
    public int X { get; set; }
    public int Y { get; set; }
}