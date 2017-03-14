using System;

class SudokuResults
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        int minutes = 0;
        int seconds = 0;
        int timeInSeconds = 0;
        int gamesCount = 0;
        
        while (command != "Quit")
        {
            string[] split = command.Split(':');
            minutes += int.Parse(split[0]);
            seconds += int.Parse(split[1]);            
            gamesCount++;
            command = Console.ReadLine();
        }
        timeInSeconds += minutes * 60 + seconds;
        decimal averageTime = (decimal)timeInSeconds / gamesCount;

        if (averageTime < 720)
        {
            Console.WriteLine("Gold Star");
        }
        else if (averageTime >= 720 && averageTime <= 1440)
        {
            Console.WriteLine("Silver Star");
        }
        else
        {
            Console.WriteLine("Bronze Star");
        }

        Console.WriteLine("Games - {0} \\ Average seconds - {1}", gamesCount, Math.Ceiling(averageTime));
    }
}