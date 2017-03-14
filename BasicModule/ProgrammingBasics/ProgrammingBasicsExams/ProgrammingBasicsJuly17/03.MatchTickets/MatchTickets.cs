using System;

class MatchTickets
{
    static void Main(string[] args)
    {
        double budget = double.Parse(Console.ReadLine());
        string category = Console.ReadLine();
        int people = int.Parse(Console.ReadLine());
        double moneyForTickets;
        double moneyForTransport;

        if (people >= 1 && people <= 4)
        {
            moneyForTransport = budget * 75 / 100;
        }
        else if (people >= 5 && people <= 9)
        {
            moneyForTransport = budget * 60 / 100;
        }
        else if (people >= 10 && people <= 24)
        {
            moneyForTransport = budget * 50 / 100;
        }
        else if (people >= 25 && people <= 49)
        {
            moneyForTransport = budget * 40 / 100;
        }
        else
        {
            moneyForTransport = budget * 25 / 100;
        }

        moneyForTickets = budget - moneyForTransport;

        if (category == "VIP")
        {
            if (moneyForTickets >= 499.99 * people)
            {
                Console.WriteLine("Yes! You have {0:f2} leva left.", moneyForTickets - 499.99 * people);
            }
            else
            {
                Console.WriteLine("Not enough money! You need {0:f2} leva.", 499.99 * people - moneyForTickets);
            }
        }
        else
        {
            if (moneyForTickets >= 249.99 * people)
            {
                Console.WriteLine("Yes! You have {0:f2} leva left.", moneyForTickets - 249.99 * people);
            }
            else
            {
                Console.WriteLine("Not enough money! You need {0:f2} leva", 249.99 - moneyForTickets);
            }
        }
    }
}