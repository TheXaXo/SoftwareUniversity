using System;

class Trip
{
    static void Main(string[] args)
    {
        double budget = double.Parse(Console.ReadLine());
        string season = Console.ReadLine();

        if (budget <= 100)
        {
            if (season == "summer")
            {
                Console.WriteLine("Somewhere in Bulgaria");
                Console.WriteLine("Camp - {0:f2}", budget * 0.30);
            }
            else
            {
                Console.WriteLine("Somewhere in Bulgaria");
                Console.WriteLine("Hotel - {0:f2}", budget * 0.70);
            }
        }
        else if (budget <= 1000)
        {
            if (season == "summer")
            {
                Console.WriteLine("Somewhere in Balkans");
                Console.WriteLine("Camp - {0:f2}", budget * 0.40);
            }
            else
            {
                Console.WriteLine("Somewhere in Balkans");
                Console.WriteLine("Hotel - {0:f2}", budget * 0.80);
            }
        }
        else
        {
            Console.WriteLine("Somewhere in Europe");
            Console.WriteLine("Hotel - {0:f2}", budget * 0.90);
        }
    }
}