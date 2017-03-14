using System;

class MatchTickets
{
    static void Main(string[] args)
    {
        double budget = double.Parse(Console.ReadLine());
        string type = Console.ReadLine();
        int numberOfPeople = int.Parse(Console.ReadLine());

        double moneyForTransport = 0;
        if (numberOfPeople <= 4)
        {
            moneyForTransport = budget * 0.75;
        }
        else if (numberOfPeople <= 9)
        {
            moneyForTransport = budget * 0.6;
        }
        else if (numberOfPeople <= 24)
        {
            moneyForTransport = budget * 0.5;
        }
        else if (numberOfPeople <= 49)
        {
            moneyForTransport = budget * 0.4;
        }
        else
        {
            moneyForTransport = budget * 0.25;
        }

        double moneyForTickets = budget - moneyForTransport;
        double ticketsCost = 0;
        if (type == "VIP")
        {
            ticketsCost = 499.99 * numberOfPeople;
        }
        else if (type == "Normal")
        {
            ticketsCost = 249.99 * numberOfPeople; ;
        }

        if (ticketsCost <= moneyForTickets)
        {
            Console.WriteLine("Yes! You have {0:f2} leva left.", moneyForTickets - ticketsCost);
        }
        else
        {
            Console.WriteLine("Not enough money! You need {0:f2} leva.", ticketsCost - moneyForTickets);
        }
    }
}