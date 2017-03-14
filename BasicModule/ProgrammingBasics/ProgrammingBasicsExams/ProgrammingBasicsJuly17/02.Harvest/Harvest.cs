using System;

class Harvest
{
    static void Main(string[] args)
    {
        int vineyardArea = int.Parse(Console.ReadLine());
        double grapesPerArea = double.Parse(Console.ReadLine());
        int neededLiters = int.Parse(Console.ReadLine());
        int workers = int.Parse(Console.ReadLine());

        double totalGrapes = vineyardArea * grapesPerArea;
        double grapesForWine = totalGrapes * 40 / 100;
        double litersWine = grapesForWine / 2.5;

        if (litersWine >= neededLiters)
        {
            Console.WriteLine("Good harvest this year! Total wine: {0} liters.", Math.Floor(litersWine));
            Console.WriteLine("{0} liters left -> {1} liters per person.", Math.Ceiling(litersWine - neededLiters), Math.Ceiling((litersWine - neededLiters) / workers));
        }
        else
        {
            Console.WriteLine("It will be a tough winter! More {0} liters wine needed.", Math.Floor(neededLiters - litersWine));
        }
    }
}