using System;
using System.Collections.Generic;
using System.Linq;

class ClosestTwoPoints
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        List<Point> list = new List<Point>();

        for (int i = 1; i <= n; i++)
        {
            Point point = GetPoint();
            list.Add(point);
        }

        List<Point> ClosestTwoPoints = GetClosestTwoPoints(list);
        double distanceOfClosest = GetDistance(ClosestTwoPoints[0], ClosestTwoPoints[1]);

        Console.WriteLine($"{distanceOfClosest:f3}");
        foreach (Point point in ClosestTwoPoints)
        {
            Console.WriteLine($"({point.X}, {point.Y})");
        }
    }

    static Point GetPoint()
    {
        int[] split = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        Point point = new Point();
        point.X = split[0];
        point.Y = split[1];

        return point;
    }

    static List<Point> GetClosestTwoPoints(List<Point> listOfPoints)
    {
        double distance = 0;
        double minDistance = double.MaxValue;
        List<Point> listOfClosest = new List<Point>();

        for (int i = 0; i < listOfPoints.Count; i++)
        {
            for (int j = i + 1; j < listOfPoints.Count; j++)
            {
                distance = GetDistance(listOfPoints[i], listOfPoints[j]);

                if (distance < minDistance)
                {
                    listOfClosest = new List<Point>();
                    minDistance = distance;
                    listOfClosest.Add(listOfPoints[i]);
                    listOfClosest.Add(listOfPoints[j]);
                }
            }
        }

        return listOfClosest;
    }

    static double GetDistance(Point p1, Point p2)
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