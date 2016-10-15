using System;
using System.Collections.Generic;
using System.Linq;

class CountWorkingDays
{
    static void Main(string[] args)
    {
        DateTime startDate = GetDate();
        DateTime endDate = GetDate();

        List<Dates> dates = GetHolidays();
        int counter = 0;
        bool isHoliday = false;

        for (DateTime currentDate = startDate; currentDate <= endDate; currentDate = currentDate.AddDays(1))
        {
            for (int i = 0; i < dates.Count; i++)
            {
                Dates dateForCheck = dates[i];
                if (dateForCheck.Day == currentDate.Day && dateForCheck.Month == currentDate.Month)
                {
                    isHoliday = true;
                }
            }

            if (isHoliday || currentDate.DayOfWeek.ToString() == "Saturday" || currentDate.DayOfWeek.ToString() == "Sunday")
            {
                isHoliday = false;
                continue; 
            }
            counter++;
            isHoliday = false;
        }

        Console.WriteLine(counter);
    }

    static DateTime GetDate()
    {
        int[] split = Console.ReadLine().Split('-').Select(int.Parse).ToArray();
        int day = split[0];
        int month = split[1];
        int year = split[2];

        DateTime date = new DateTime(year, month, day);
       
        return date;
    }

    static List<Dates> GetHolidays()
    {
        List<Dates> list = new List<Dates>();
        list.Add(new Dates(1, 1));
        list.Add(new Dates(3, 3));
        list.Add(new Dates(1, 5));
        list.Add(new Dates(6, 5));
        list.Add(new Dates(24, 5));
        list.Add(new Dates(6, 9));
        list.Add(new Dates(22, 9));
        list.Add(new Dates(1, 11));
        list.Add(new Dates(24, 12));
        list.Add(new Dates(25, 12));
        list.Add(new Dates(26, 12));

        return list;
    }
}

class Dates
{
    public int Day { get; set; }
    public int Month { get; set; }

    public Dates(int day, int month)
    {
        Day = day;
        Month = month;
    }
}