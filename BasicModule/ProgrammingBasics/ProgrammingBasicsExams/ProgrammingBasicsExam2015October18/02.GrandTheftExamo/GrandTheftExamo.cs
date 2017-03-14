using System;

class GrandTheftExamo
{
    static void Main(string[] args)
    {
        int escapeAttempts = int.Parse(Console.ReadLine());
        long thievesSlapped = 0;
        long thievesEscaped = 0;
        long totalBeers = 0;

        for (int i = 1; i <= escapeAttempts; i++)
        {
            int escapingThieves = int.Parse(Console.ReadLine());
            int beerDrank = int.Parse(Console.ReadLine());
            if (escapingThieves <= 5)
            {
                thievesSlapped += escapingThieves;
            }
            else
            {
                thievesSlapped += 5;
                thievesEscaped += escapingThieves - 5;
            }
            totalBeers += beerDrank;
        }
        Console.WriteLine("{0} thieves slapped.", thievesSlapped);
        Console.WriteLine("{0} thieves escaped.", thievesEscaped);
        Console.WriteLine("{0} packs, {1} bottles.", totalBeers / 6, totalBeers % 6);
    }
}