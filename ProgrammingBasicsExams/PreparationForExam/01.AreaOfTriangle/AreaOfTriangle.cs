using System;

class AreaOfTriangle
{
    static void Main(string[] args)
    {
        double x1 = double.Parse(Console.ReadLine());
        double y1 = double.Parse(Console.ReadLine());
        double x2 = double.Parse(Console.ReadLine());
        double y2 = double.Parse(Console.ReadLine());
        double x3 = double.Parse(Console.ReadLine());
        double y3 = double.Parse(Console.ReadLine());
        double a = Math.Abs(x3 - x2);
        double h = Math.Abs(y1 - y2);
        double area = a * h / 2;
        Console.WriteLine(area);
    }
}