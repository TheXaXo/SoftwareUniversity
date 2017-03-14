using System;

class MasterHerbalist
{
    static void Main(string[] args)
    {
        int dailyExpenses = int.Parse(Console.ReadLine());
        string command = Console.ReadLine();
        int herbs = 0;
        decimal totalMoney = 0;
        decimal averageEarnings = 0;
        int days = 0;

        while (command != "Season Over")
        {
            string [] split = command.Split(' ');
            int hours = int.Parse(split[0]);
            string path = split[1];
            int price = int.Parse(split[2]);

            while (path.Length < hours)
            {
                path += path;
            }

            for (int i = 0; i < hours; i++)
            {
                if (path[i] == 'H')
                {
                    herbs++;
                }                               
            }

            totalMoney += price * herbs; 
            herbs = 0;
            days++;
            command = Console.ReadLine();
        }

        averageEarnings = totalMoney / days; 
        if (averageEarnings >= dailyExpenses)
        {
            Console.WriteLine("Times are good. Extra money per day: {0:f2}.", averageEarnings - dailyExpenses);
        }
        else
        {
            Console.WriteLine("We are in the red. Money needed: {0}.", Math.Round(dailyExpenses * days - totalMoney));
        }
    }
}