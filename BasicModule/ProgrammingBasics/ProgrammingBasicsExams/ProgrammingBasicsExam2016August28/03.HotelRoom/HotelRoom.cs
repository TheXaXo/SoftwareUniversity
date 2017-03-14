using System;

class HotelRoom
{
    static void Main(string[] args)
    {
        string month = Console.ReadLine();
        int nights = int.Parse(Console.ReadLine());
        double studioPrice = 0;
        double apartmentPrice = 0;

        if (month == "May" || month == "October")
        {
            studioPrice = 50 * nights;
            apartmentPrice = 65 * nights;
            if (nights > 7 && nights <= 14)
            {
                studioPrice = studioPrice * 0.95;
            }
            else if (nights > 14)
            {
                studioPrice = studioPrice * 0.7;
                apartmentPrice = apartmentPrice * 0.9;
            }
        }
        else if (month == "June" || month == "September")
        {
            studioPrice = 75.20 * nights;
            apartmentPrice = 68.70 * nights;
            if (nights > 14)
            {
                studioPrice = studioPrice * 0.8;
                apartmentPrice = apartmentPrice * 0.9;
            }
        }
        else if (month == "July" || month == "August")
        {
            studioPrice = 76 * nights;
            apartmentPrice = 77 * nights;
            if (nights > 14)
            {
                apartmentPrice = apartmentPrice * 0.9;
            }
        }

        Console.WriteLine("Apartment: {0:f2} lv.", apartmentPrice);
        Console.WriteLine("Studio: {0:f2} lv.", studioPrice);
    }
}