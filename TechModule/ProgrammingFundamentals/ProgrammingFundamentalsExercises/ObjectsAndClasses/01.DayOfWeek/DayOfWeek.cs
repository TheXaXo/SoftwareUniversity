using System;

class DayOfWeek
{
    static void Main(string[] args)
    {
        string[] split = Console.ReadLine().Split('-');

        int day = int.Parse(split[0]);
        int month = int.Parse(split[1]);
        int year = int.Parse(split[2]);

        DateTime date = new DateTime(year, month, day);
        Console.WriteLine(date.DayOfWeek);
    }
}