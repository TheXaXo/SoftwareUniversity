using System;

class Program
{
    static void Main(string[] args)
    {
        string date = Console.ReadLine();
        DateTime time = DateTime.ParseExact(date, "dd-MM-yyyy", null);
        Console.WriteLine(time.AddDays(999).ToString("dd-MM-yyyy"));
    }
}