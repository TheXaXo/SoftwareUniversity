using System;

class Program
{
    static void Main(string[] args)
    {
        int candidates = int.Parse(Console.ReadLine());
        int vote = int.Parse(Console.ReadLine());
        char symbol = char.Parse(Console.ReadLine());
        char symbolToUpper = char.ToUpper(symbol);

        for (int i = 1; i <= candidates; i++)
        {
            if (i == 1)
            {
                Console.WriteLine(new string('.', 13));
            }
            if (i == vote && symbolToUpper == 'X') 
            {             
                Console.WriteLine("...+-----+...");
                Console.WriteLine("...|.\\./.|...");
                Console.WriteLine("{0}.|..X..|...", i.ToString().PadLeft(2, '0'));
                Console.WriteLine("...|./.\\.|...");
                Console.WriteLine("...+-----+...");
            }
            else if (i == vote && symbolToUpper == 'V')
            {
                Console.WriteLine("...+-----+...");
                Console.WriteLine("...|\\.../|...");
                Console.WriteLine("{0}.|.\\./.|...", i.ToString().PadLeft(2, '0'));
                Console.WriteLine("...|..V..|...");
                Console.WriteLine("...+-----+...");
            }
            else 
            {
                Console.WriteLine("...+-----+...");
                Console.WriteLine("...|.....|...");
                Console.WriteLine("{0}.|.....|...", i.ToString().PadLeft(2, '0'));
                Console.WriteLine("...|.....|...");
                Console.WriteLine("...+-----+...");
            }
            Console.WriteLine(new string('.', 13));
        }
    }
}