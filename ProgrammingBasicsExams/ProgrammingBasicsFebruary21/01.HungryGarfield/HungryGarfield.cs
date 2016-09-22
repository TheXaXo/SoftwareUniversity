using System;

class HungryGarfield
{
    static void Main(string[] args)
    {
        decimal money = decimal.Parse(Console.ReadLine());
        decimal rate = decimal.Parse(Console.ReadLine());
        decimal pizzaPriceUSD = decimal.Parse(Console.ReadLine()) / rate;
        decimal lasagnaPriceUSD = decimal.Parse(Console.ReadLine()) / rate;
        decimal sandwichPriceUSD = decimal.Parse(Console.ReadLine()) / rate;
        uint pizzaQuantity = uint.Parse(Console.ReadLine());
        uint lasagnaQuantity = uint.Parse(Console.ReadLine());
        uint sandwichQuantity = uint.Parse(Console.ReadLine());

        decimal moneyNeeded = pizzaPriceUSD * pizzaQuantity + lasagnaPriceUSD * lasagnaQuantity + sandwichPriceUSD * sandwichQuantity;

        if (money >= moneyNeeded)
        {
            Console.WriteLine("Garfield is well fed, John is awesome. Money left: ${0:f2}.", money - moneyNeeded);
        }
        else
        {
            Console.WriteLine("Garfield is hungry. John is a badass. Money needed: ${0:f2}.", moneyNeeded - money);
        }
    }
}