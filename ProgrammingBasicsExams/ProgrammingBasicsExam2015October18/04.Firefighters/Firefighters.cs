using System;

class Firefighters
{
    static void Main(string[] args)
    {
        int firefighters = int.Parse(Console.ReadLine());
        int oldFirefighters = firefighters;
        string command = Console.ReadLine();
        int kids = 0;
        int adults = 0;
        int seniors = 0;
        int kidsSaved = 0;
        int adultsSaved = 0;
        int seniorsSaved = 0;

        while (command != "rain")
        {
            for (int i = 0; i < command.Length; i++)
            {
                if (command[i] == 'K')
                {
                    kids++;
                }
                else if (command[i] == 'A')
                {
                    adults++;
                }
                else if (command[i] == 'S')
                {
                    seniors++;
                }
            }
            for (int i = 1; i <= firefighters; i++)
            {
                if (kids > 0)
                {
                    kids--;
                    kidsSaved++;
                }
                else if (kids == 0 && adults > 0)
                {
                    adults--;
                    adultsSaved++;
                }
                else if (kids == 0 && adults == 0 && seniors > 0)
                {
                    seniors--;
                    seniorsSaved++;
                }
            }
            kids = 0;
            adults = 0;
            seniors = 0;
            command = Console.ReadLine();
        }

        Console.WriteLine("Kids: {0}", kidsSaved);
        Console.WriteLine("Adults: {0}", adultsSaved);
        Console.WriteLine("Seniors: {0}", seniorsSaved);
    }
}