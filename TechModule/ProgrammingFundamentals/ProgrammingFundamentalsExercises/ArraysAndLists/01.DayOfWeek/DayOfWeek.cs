using System;

class DayOfWeek
{
    static void Main(string[] args)
    {
        string[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        int dayN = int.Parse(Console.ReadLine());
        if (dayN < 1 || dayN > 7)
        {
            Console.WriteLine("Invalid Day!");
        }
        else
        {
            Console.WriteLine(daysOfWeek[dayN - 1]);
        }
    }
}