using System;

class BookProblem
{
    static void Main(string[] args)
    {
        int pages = int.Parse(Console.ReadLine());
        int campingDays = int.Parse(Console.ReadLine());
        int pagesPerNormalDay = int.Parse(Console.ReadLine());

        if (campingDays == 30)
        {
            Console.WriteLine("never");
            return;
        }

        int normalDays = 30 - campingDays;
        double monthsToReadTheBook = (double)pages / (normalDays * pagesPerNormalDay);
        int years = 0;

        while (monthsToReadTheBook >= 12)
        {
            years++;
            monthsToReadTheBook -= 12;
        }

        Console.WriteLine("{0} years {1} months", years, Math.Ceiling(monthsToReadTheBook));
    }
}