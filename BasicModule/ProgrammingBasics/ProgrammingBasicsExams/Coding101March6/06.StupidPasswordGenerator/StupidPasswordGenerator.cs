using System;

class StupidPasswordGenerator
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int l = int.Parse(Console.ReadLine());

        for (int first = 1; first < n; first++)
        {
            for (int second = 1; second < n; second++)
            {
                for (char third = 'a'; third <= (char)96 + l; third++)
                {
                    for (char fourth = 'a'; fourth <= (char) 96 + l; fourth++)
                    {
                        for (int fifth = Math.Max(first, second) + 1; fifth <= n; fifth++)
                        {
                            Console.Write("{0}{1}{2}{3}{4} ", first, second, third, fourth, fifth);
                        }
                    }
                }
            }
        }
    }
}