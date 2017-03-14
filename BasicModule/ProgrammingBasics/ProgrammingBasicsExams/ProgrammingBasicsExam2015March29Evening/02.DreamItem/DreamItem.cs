using System;

class DreamItem
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        string[] split = command.Split('\\');
        string month = split[0];
        decimal moneyPerHour = decimal.Parse(split[1]);
        int hoursPerDay = int.Parse(split[2]);
        decimal priceOfItem = decimal.Parse(split[3]);

        int daysInMonth = 0;
        if (month == "Jan")
        {
            daysInMonth = 31;
        }
        else if (month == "Feb")
        {
            daysInMonth = 28;
        }
        else if (month == "March")
        {
            daysInMonth = 31;
        }
        else if (month == "Apr")
        {
            daysInMonth = 30;
        }
        else if (month == "May")
        {
            daysInMonth = 31;
        }
        else if (month == "June")
        {
            daysInMonth = 30;
        }
        else if (month == "July")
        {
            daysInMonth = 31;
        }
        else if (month == "Aug")
        {
            daysInMonth = 31;
        }
        else if (month == "Sept")
        {
            daysInMonth = 30;
        }
        else if (month == "Oct")
        {
            daysInMonth = 31;
        }
        else if (month == "Nov")
        {
            daysInMonth = 30;
        }
        else if (month == "Dec")
        {
            daysInMonth = 31;
        }

        int workdays = daysInMonth - 10;
        decimal moneyMade = workdays * moneyPerHour * hoursPerDay;
        if (moneyMade > 700)
        {
            moneyMade *= 1.1m;
        }

        if (moneyMade >= priceOfItem)
        {
            Console.WriteLine("Money left = {0:f2} leva.", moneyMade - priceOfItem);
        }
        else
        {
            Console.WriteLine("Not enough money. {0:f2} leva needed.", priceOfItem - moneyMade);
        }
    }
}