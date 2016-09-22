using System;

class VegetablesMarket
{
    static void Main(string[] args)
    {
        double vegetablePricePerKilo = double.Parse(Console.ReadLine());
        double fruitPricePerKilo = double.Parse(Console.ReadLine());
        double vegetablesKilos = double.Parse(Console.ReadLine());
        double fruitKilos = double.Parse(Console.ReadLine());

        Console.WriteLine((vegetablePricePerKilo * vegetablesKilos + fruitPricePerKilo * fruitKilos) / 1.94);
    }
}