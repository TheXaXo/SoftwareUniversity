using System;

class Volleyball
{
    static void Main(string[] args)
    {
        string year = Console.ReadLine();
        double holidays = int.Parse(Console.ReadLine());
        double weekendsInHometown = int.Parse(Console.ReadLine());
        double weekendsInSofia = 48 - weekendsInHometown;
        double gamesInSofia = weekendsInSofia * 3 / 4;
        double games = weekendsInHometown + gamesInSofia + holidays * 2 / 3;

        if (year == "leap")
        {
            games = games + games * 0.15;
        }

        Console.WriteLine(Math.Floor(games));
    }
}