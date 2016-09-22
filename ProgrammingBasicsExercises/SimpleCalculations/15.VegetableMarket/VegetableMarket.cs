using System;

class VegetableMarket
{
    static void Main(string[] args)
    {
        double vegetablesPerKiloBGN = double.Parse(Console.ReadLine());
        double fruitsPricePerKiloBGN = double.Parse(Console.ReadLine());
        int vegetablesKilos = int.Parse(Console.ReadLine());
        int fruitsKilos = int.Parse(Console.ReadLine());

        double priceEUR = (vegetablesKilos * vegetablesPerKiloBGN + fruitsKilos * fruitsPricePerKiloBGN) / 1.94;

        Console.WriteLine(priceEUR);
    }
}