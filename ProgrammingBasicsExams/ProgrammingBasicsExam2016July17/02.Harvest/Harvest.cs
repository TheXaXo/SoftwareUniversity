using System;

class Harvest
{
    static void Main(string[] args)
    {
        int vineyardArea = int.Parse(Console.ReadLine());
        double grapesPerArea = double.Parse(Console.ReadLine());
        int neededWine = int.Parse(Console.ReadLine());
        int workers = int.Parse(Console.ReadLine());

        double grapesForWine = vineyardArea * grapesPerArea * 0.4;
        double litersWineMade = grapesForWine / 2.5;

        if (litersWineMade < neededWine)
        {
            Console.WriteLine("It will be a tough winter! More {0} liters wine needed.", Math.Floor(neededWine - litersWineMade));
        }
        else
        {
            Console.WriteLine("Good harvest this year! Total wine: {0} liters.", Math.Floor(litersWineMade));
            Console.WriteLine("{0} liters left -> {1} liters per person.", Math.Ceiling(litersWineMade - neededWine), Math.Ceiling((litersWineMade - neededWine) / workers));
        }
    }
}