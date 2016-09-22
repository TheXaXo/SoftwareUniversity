using System;

class FourFactors
{
    static void Main(string[] args)
    {
        uint FG = uint.Parse(Console.ReadLine());
        uint FGA = uint.Parse(Console.ReadLine());
        uint ThreeP = uint.Parse(Console.ReadLine());
        uint TOV = uint.Parse(Console.ReadLine());
        uint ORB = uint.Parse(Console.ReadLine());
        uint oppDRB = uint.Parse(Console.ReadLine());
        uint FT = uint.Parse(Console.ReadLine());
        uint FTA = uint.Parse(Console.ReadLine());

        decimal eFGPercent = (decimal)(FG + 0.5m * ThreeP) / FGA;
        decimal TOVPercent = (decimal)TOV / (FGA + 0.44m * FTA + TOV);
        decimal ORBPercent = (decimal)ORB / (ORB + oppDRB);
        decimal FTPercent = (decimal)FT / FGA;

        Console.WriteLine("eFG% {0:f3}", eFGPercent);
        Console.WriteLine("TOV% {0:f3}", TOVPercent);
        Console.WriteLine("ORB% {0:f3}", ORBPercent);
        Console.WriteLine("FT% {0:f3}", FTPercent);
    }
}