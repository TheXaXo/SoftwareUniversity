using System;

class CurrencyCheck
{
    static void Main(string[] args)
    {
        decimal russianSite = decimal.Parse(Console.ReadLine()) * 0.035m;
        decimal americanSite = decimal.Parse(Console.ReadLine()) * 1.5m;
        decimal officialSite = decimal.Parse(Console.ReadLine()) * 1.95m;
        decimal bulgarianWithOffer = decimal.Parse(Console.ReadLine()) / 2;
        decimal bulgarianNormal = decimal.Parse(Console.ReadLine());

        decimal cheapest = decimal.MaxValue;
        if (russianSite < cheapest)
        {
            cheapest = russianSite;
        }
        if (americanSite < cheapest)
        {
            cheapest = americanSite;
        }
        if(officialSite < cheapest)
        {
            cheapest = officialSite;
        }
        if (bulgarianWithOffer < cheapest)
        {
            cheapest = bulgarianWithOffer;
        }
        if (bulgarianNormal < cheapest)
        {
            cheapest = bulgarianNormal;
        }

        Console.WriteLine("{0:f2}", cheapest);
    }
}