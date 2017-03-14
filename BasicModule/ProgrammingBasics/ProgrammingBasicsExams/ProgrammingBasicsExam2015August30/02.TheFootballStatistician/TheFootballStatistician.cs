using System;

class TheFootballStatistician
{
    static void Main(string[] args)
    {
        decimal moneyPerMatch = decimal.Parse(Console.ReadLine());
        string command = Console.ReadLine();
        int arsenalPoints = 0;
        int chelseaPoints = 0;
        int evertonPoints = 0;
        int liverpoolPoints = 0;
        int manCityPoints = 0;
        int manUtdPoints = 0;
        int southamptonPoints = 0;
        int tottenhamPoints = 0;
        int matches = 0;

        while (command != "End of the league.")
        {
            string[] split = command.Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            string firstTeam = split[0];
            string outcome = split[1];
            string secondTeam = split[2];

            //First Team
            if (firstTeam == "Arsenal")
            {
                if (outcome == "1")
                {
                    arsenalPoints += 3;
                }
                else if (outcome == "X")
                {
                    arsenalPoints += 1;
                }
            }
            else if (firstTeam == "Chelsea")
            {
                if (outcome == "1")
                {
                    chelseaPoints += 3;
                }
                else if (outcome == "X")
                {
                    chelseaPoints += 1;
                }
            }
            else if (firstTeam == "Everton")
            {
                if (outcome == "1")
                {
                    evertonPoints += 3;
                }
                else if (outcome == "X")
                {
                    evertonPoints += 1;
                }
            }
            else if (firstTeam == "Liverpool")
            {
                if (outcome == "1")
                {
                    liverpoolPoints += 3;
                }
                else if (outcome == "X")
                {
                    liverpoolPoints += 1;
                }
            }
            else if (firstTeam == "ManchesterCity")
            {
                if (outcome == "1")
                {
                    manCityPoints += 3;
                }
                else if (outcome == "X")
                {
                    manCityPoints += 1;
                }
            }
            else if (firstTeam == "ManchesterUnited")
            {
                if (outcome == "1")
                {
                    manUtdPoints += 3;
                }
                else if (outcome == "X")
                {
                    manUtdPoints += 1;
                }
            }
            else if (firstTeam == "Southampton")
            {
                if (outcome == "1")
                {
                    southamptonPoints += 3;
                }
                else if (outcome == "X")
                {
                    southamptonPoints += 1;
                }
            }
            else if (firstTeam == "Tottenham")
            {
                if (outcome == "1")
                {
                    tottenhamPoints += 3;
                }
                else if (outcome == "X")
                {
                    tottenhamPoints += 1;
                }
            }

            //Second Team
            if (secondTeam == "Arsenal")
            {
                if (outcome == "2")
                {
                    arsenalPoints += 3;
                }
                else if (outcome == "X")
                {
                    arsenalPoints += 1;
                }
            }
            else if (secondTeam == "Chelsea")
            {
                if (outcome == "2")
                {
                    chelseaPoints += 3;
                }
                else if (outcome == "X")
                {
                    chelseaPoints += 1;
                }
            }
            else if (secondTeam == "Everton")
            {
                if (outcome == "2")
                {
                    evertonPoints += 3;
                }
                else if (outcome == "X")
                {
                    evertonPoints += 1;
                }
            }
            else if (secondTeam == "Liverpool")
            {
                if (outcome == "2")
                {
                    liverpoolPoints += 3;
                }
                else if (outcome == "X")
                {
                    liverpoolPoints += 1;
                }
            }
            else if (secondTeam == "ManchesterCity")
            {
                if (outcome == "2")
                {
                    manCityPoints += 3;
                }
                else if (outcome == "X")
                {
                    manCityPoints += 1;
                }
            }
            else if (secondTeam == "ManchesterUnited")
            {
                if (outcome == "2")
                {
                    manUtdPoints += 3;
                }
                else if (outcome == "X")
                {
                    manUtdPoints += 1;
                }
            }
            else if (secondTeam == "Southampton")
            {
                if (outcome == "2")
                {
                    southamptonPoints += 3;
                }
                else if (outcome == "X")
                {
                    southamptonPoints += 1;
                }
            }
            else if (secondTeam == "Tottenham")
            {
                if (outcome == "2")
                {
                    tottenhamPoints += 3;
                }
                else if (outcome == "X")
                {
                    tottenhamPoints += 1;
                }
            }
            matches++;
            command = Console.ReadLine();
        }
        Console.WriteLine("{0:f2}lv.", matches * moneyPerMatch * 1.94m);
        Console.WriteLine("Arsenal - {0} points.", arsenalPoints);
        Console.WriteLine("Chelsea - {0} points.", chelseaPoints);
        Console.WriteLine("Everton - {0} points.", evertonPoints);
        Console.WriteLine("Liverpool - {0} points.", liverpoolPoints);
        Console.WriteLine("Manchester City - {0} points.", manCityPoints);
        Console.WriteLine("Manchester United - {0} points.", manUtdPoints);
        Console.WriteLine("Southampton - {0} points.", southamptonPoints);
        Console.WriteLine("Tottenham - {0} points.", tottenhamPoints);
    }
}