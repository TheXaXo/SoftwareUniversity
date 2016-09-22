using System;

class Cinema
{
    static void Main(string[] args)
    {
        string type = Console.ReadLine();
        int r = int.Parse(Console.ReadLine());
        int c = int.Parse(Console.ReadLine());
        int seatsOccupied = r * c;
        double sum = 0;

        if (type == "Premiere")
        {
            sum = seatsOccupied * 12;
        }
        else if (type == "Normal")
        {
            sum = seatsOccupied * 7.5;
        }
        else if (type == "Discount")
        {
            sum = seatsOccupied * 5;
        }

        Console.WriteLine("{0:f2} leva", sum);
    }
}