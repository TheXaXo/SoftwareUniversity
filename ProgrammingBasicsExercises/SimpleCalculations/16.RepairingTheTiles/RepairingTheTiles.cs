using System;

class RepairingTheTiles
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        double tileW = double.Parse(Console.ReadLine());
        double tileL = double.Parse(Console.ReadLine());
        int benchW = int.Parse(Console.ReadLine());
        int benchH = int.Parse(Console.ReadLine());

        int playgroundArea = n * n;
        double tileArea = tileL * tileW;
        int benchArea = benchH * benchW;
        double tiles = (playgroundArea - benchArea) / tileArea;
        double time = tiles * 0.2;

        Console.WriteLine(tiles);
        Console.WriteLine(time);
    }
}