using System;

class RefactorVolumeOfPyramid
{
    static void Main(string[] args)
    {
        decimal volume = 0;

        Console.Write("Length: ");
        double length = double.Parse(Console.ReadLine());

        Console.Write("Width: ");
        double width = double.Parse(Console.ReadLine());

        Console.Write("Height: ");
        double height = double.Parse(Console.ReadLine());

        volume = (decimal)(length * width * height) / 3;
        Console.WriteLine("Pyramid Volume: {0:F2}", volume);
    }
}