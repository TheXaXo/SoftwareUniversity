using System;

class TriplesOfLetters
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        for (char first = 'a'; first <= (char)96 + n; first++)
        {
            for (char second = 'a'; second <= (char)96 + n; second++)
            {
                for (char third = 'a'; third <= (char)96 + n; third++)
                {
                    Console.WriteLine("{0}{1}{2}", first, second, third);
                }
            }
        }
    }
}