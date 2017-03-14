using System;

class TrainingLab
{
    static void Main(string[] args)
    {
        double h = double.Parse(Console.ReadLine());
        double w = double.Parse(Console.ReadLine());
        int rows = (int)(h * 100) / 120;
        int desksPerRow = (int)(w * 100 - 100) / 70;
        int desks = rows * desksPerRow - 3;
        Console.WriteLine(desks);
    }
}