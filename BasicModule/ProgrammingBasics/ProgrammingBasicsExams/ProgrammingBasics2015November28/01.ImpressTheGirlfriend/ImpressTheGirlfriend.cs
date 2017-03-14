using System;

class ImpressTheGirlfriend
{
    static void Main(string[] args)
    {
        decimal mostExpensive = 0;

        decimal russianStoreInBGN = decimal.Parse(Console.ReadLine()) * 0.035m;
        if (russianStoreInBGN > mostExpensive)
        {
            mostExpensive = russianStoreInBGN;
        }

        decimal americanStoreInBGN = decimal.Parse(Console.ReadLine()) * 1.5m;
        if (americanStoreInBGN > mostExpensive)
        {
            mostExpensive = americanStoreInBGN;
        }

        decimal officialStoreInBGN = decimal.Parse(Console.ReadLine()) * 1.95m;
        if (officialStoreInBGN > mostExpensive)
        {
            mostExpensive = officialStoreInBGN;
        }

        decimal specialStoreInBGN = decimal.Parse(Console.ReadLine()) / 2;        
        if (specialStoreInBGN > mostExpensive)
        {
            mostExpensive = specialStoreInBGN;
        }

        decimal bulgarianStoreInBGN = decimal.Parse(Console.ReadLine());
        if (bulgarianStoreInBGN > mostExpensive)
        {
            mostExpensive = bulgarianStoreInBGN;
        }

        Console.WriteLine("{0:f2}", Math.Ceiling(mostExpensive));
    }
}