using System;

class ConvertSpeedUnits
{
    static void Main(string[] args)
    {
        int distanceInMeters = int.Parse(Console.ReadLine());
        int hours = int.Parse(Console.ReadLine());
        int minutes = int.Parse(Console.ReadLine());
        int seconds = int.Parse(Console.ReadLine());

        float distanceInKilometers = distanceInMeters / 1000f;
        float distanceInMiles = distanceInMeters / 1609f;

        float timeInHours = hours + minutes / 60f + seconds / 60f / 60f;
        float timeInSeconds = hours * 60f * 60f + minutes * 60f + seconds;

        float metersPerSecond = distanceInMeters / timeInSeconds;
        float kilometersPerHour = distanceInKilometers / timeInHours;
        float milesPerHour = distanceInMiles / timeInHours;

        Console.WriteLine(metersPerSecond);
        Console.WriteLine(kilometersPerHour);
        Console.WriteLine(milesPerHour);
    }
}