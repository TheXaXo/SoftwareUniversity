using System;

class CircleAreaAndPerimeter
{
    static void Main(string[] args)
    {
        double r = double.Parse(Console.ReadLine());
        double area = Math.PI * Math.Pow(r, 2);
        double perimeter = 2 * Math.PI * r;
        Console.WriteLine("Area = {0}", area);
        Console.WriteLine("Perimeter = {0}", perimeter);
    }
}