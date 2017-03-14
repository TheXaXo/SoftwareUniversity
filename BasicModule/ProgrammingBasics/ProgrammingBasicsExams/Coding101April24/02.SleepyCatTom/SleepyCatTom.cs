using System;

class SleepyCatTom
{
    static void Main(string[] args)
    {
        int freeDays = int.Parse(Console.ReadLine());
        int playTime = (freeDays * 127) + ((365 - freeDays) * 63);

        if (playTime > 30000)
        {
            Console.WriteLine("Tom will run away");
            Console.WriteLine("{0} hours and {1} minutes more for play", (playTime - 30000) / 60, (playTime - 30000) % 60);
        }
        else
        {
            Console.WriteLine("Tom sleeps well");
            Console.WriteLine("{0} hours and {1} minutes less for play", (30000 - playTime) / 60, (30000 - playTime) % 60);
        }
    }
}