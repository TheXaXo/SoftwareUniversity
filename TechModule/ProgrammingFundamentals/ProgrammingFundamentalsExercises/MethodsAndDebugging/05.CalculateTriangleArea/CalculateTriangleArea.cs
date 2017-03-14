using System;

class CalculateTriangleArea
{
    static void Main(string[] args)
    {
        double a = double.Parse(Console.ReadLine());
        double hA = double.Parse(Console.ReadLine());

        double area = GetTriangleArea(a, hA);
        Console.WriteLine(area);
    }
    static double GetTriangleArea(double a, double hA)
    {
        double area = a * hA / 2;
        return area;
    }
}