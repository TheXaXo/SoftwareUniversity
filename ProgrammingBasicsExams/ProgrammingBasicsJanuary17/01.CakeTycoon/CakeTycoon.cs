using System;

class CakeTycoon
{
    static void Main(string[] args)
    {
        decimal numberOfCakesWanted = decimal.Parse(Console.ReadLine());
        decimal flourNeededPerCake = decimal.Parse(Console.ReadLine());
        decimal flourAvailable = decimal.Parse(Console.ReadLine());
        decimal trufflesAvailable = decimal.Parse(Console.ReadLine());
        decimal priceOfTruffle = decimal.Parse(Console.ReadLine());

        decimal cakesMade = Math.Floor(flourAvailable / flourNeededPerCake);
        decimal trufflesCost = trufflesAvailable * priceOfTruffle;
        decimal priceOfCake = 0;

        if (numberOfCakesWanted <= cakesMade)
        {
            priceOfCake = trufflesCost / numberOfCakesWanted * 1.25m;
            Console.WriteLine("All products available, price of a cake: {0:f2}", priceOfCake);
        }
        else
        {
            Console.WriteLine("Can make only {0} cakes, need {1:f2} kg more flour", cakesMade, flourNeededPerCake * numberOfCakesWanted - flourAvailable);
        }
    }
}