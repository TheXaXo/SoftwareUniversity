using System;

class CircleArea
{
    static void Main(string[] args)
    {
        double r = double.Parse(Console.ReadLine());
        double circleArea = Math.PI * Math.Pow(r, 2);
        Console.WriteLine("{0:f12}", circleArea);       
    }
}