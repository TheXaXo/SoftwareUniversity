using System;

class RepairingTheTiles
{
    static void Main(string[] args)
    {
        int fieldLength = int.Parse(Console.ReadLine());
        double tileWidth = double.Parse(Console.ReadLine());
        double tileLength = double.Parse(Console.ReadLine());
        int benchWidth = int.Parse(Console.ReadLine());
        int benchLength = int.Parse(Console.ReadLine());

        int fieldArea = fieldLength * fieldLength;
        int benchArea = benchLength * benchWidth;
        double tileArea = tileLength * tileWidth;

        Console.WriteLine((fieldArea - benchArea) / tileArea);
        Console.WriteLine((fieldArea - benchArea) / tileArea * 0.2);
    }
}