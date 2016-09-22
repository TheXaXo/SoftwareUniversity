using System;

class TransportPrice
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        string timeOfDay = Console.ReadLine();

        if (n < 20)
        {
            if (timeOfDay == "day")
            {
                Console.WriteLine(0.70 + 0.79 * n);
            }
            else
            {
                Console.WriteLine(0.70 + 0.90 * n);
            }
        }
        else if (n < 100)
        {
            Console.WriteLine(0.09 * n);
        }
        else
        {
            Console.WriteLine(0.06 * n);
        }
    }
}