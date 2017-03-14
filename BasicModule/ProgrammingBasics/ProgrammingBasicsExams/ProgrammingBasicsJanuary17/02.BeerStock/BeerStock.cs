using System;

class BeerStock
{
    static void Main(string[] args)
    {
        long reservedBeers = long.Parse(Console.ReadLine());
        long totalBeers = 0;
        string command = Console.ReadLine();

        while (command != "Exam Over")
        {
            string[] split = command.Split(' ');
            long numberOfType = long.Parse(split[0]);
            string type = split[1];
            if (type == "beers")
            {
                totalBeers += numberOfType;
            }
            else if (type == "sixpacks")
            {
                totalBeers += numberOfType * 6;
            }
            else if (type == "cases")
            {
                totalBeers += numberOfType * 24;
            }
            command = Console.ReadLine();
        }

        if (totalBeers >= 100)
        {
            totalBeers -= totalBeers / 100;
        }

        if (reservedBeers <= totalBeers)
        {
            Console.WriteLine("Cheers! Beer left: {0} cases, {1} sixpacks and {2} beers.", (totalBeers - reservedBeers) / 24, (totalBeers - reservedBeers) % 24 / 6, (totalBeers - reservedBeers) % 24 % 6);
        }
        else
        {
            Console.WriteLine("Not enough beer. Beer needed: {0} cases, {1} sixpacks and {2} beers.", (reservedBeers - totalBeers) / 24, (reservedBeers - totalBeers) % 24 / 6, (reservedBeers - totalBeers) % 24 % 6);
        }
    }
}