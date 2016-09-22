using System;

class Program
{
    static void Main(string[] args)
    {
        double h = double.Parse(Console.ReadLine());
        double w = double.Parse(Console.ReadLine());

        double wCm = w * 100;
        double hCm = h * 100;

        double wMinusCorridor = wCm - 100;

        double desksPerRow = Math.Floor(wMinusCorridor / 70);
        double rows = Math.Floor(hCm / 120);

        Console.WriteLine(desksPerRow * rows - 3);
    }
}