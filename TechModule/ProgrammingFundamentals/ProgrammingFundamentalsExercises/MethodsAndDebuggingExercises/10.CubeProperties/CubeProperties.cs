using System;

class CubeProperties
{
    static void Main(string[] args)
    {
        double sideOfCube = double.Parse(Console.ReadLine());
        string parameter = Console.ReadLine();

        if (parameter == "face")
        {
            CalculateLengthOfFaceDiagonals(sideOfCube);
        }
        else if (parameter == "space")
        {
            CalculateLengthOfSpaceDiagonals(sideOfCube);
        }
        else if (parameter == "volume")
        {
            CalculateVolume(sideOfCube);
        }
        else if (parameter == "area")
        {
            CalculateArea(sideOfCube);
        }
    }
    static void CalculateLengthOfFaceDiagonals(double sideOfCube)
    {
        double lengthOfFaceDiagonals = sideOfCube * Math.Sqrt(2);
        Console.WriteLine($"{lengthOfFaceDiagonals:f2}");
    }
    static void CalculateLengthOfSpaceDiagonals(double sideOfCube)
    {
        double lengthOfSpaceDiagonals = sideOfCube * Math.Sqrt(3);
        Console.WriteLine($"{lengthOfSpaceDiagonals:f2}");
    }
    static void CalculateVolume(double sideOfCube)
    {
        double volume = Math.Pow(sideOfCube, 3);
        Console.WriteLine($"{volume:f2}");
    }
    static void CalculateArea(double sideOfCube)
    {
        double area = 6 * Math.Pow(sideOfCube, 2);
        Console.WriteLine($"{area:f2}");
    }
}