using System;

class Firm
{
    static void Main(string[] args)
    {
        int hours = int.Parse(Console.ReadLine());
        int remainingDays = int.Parse(Console.ReadLine());
        int workers = int.Parse(Console.ReadLine());

        double availableHours = remainingDays * 8 * 0.9;
        double hoursFromWorkers = workers * (2 * remainingDays);
        double hoursCombined = Math.Floor(availableHours + hoursFromWorkers);

        if (hoursCombined >= hours)
        {
            Console.WriteLine("Yes!{0} hours left.", Math.Floor(Math.Abs(hours - hoursCombined)));
        }
        else
        {
            Console.WriteLine("Not enough time!{0} hours needed.", Math.Floor(Math.Abs(hoursCombined - hours)));
        }
    }
}