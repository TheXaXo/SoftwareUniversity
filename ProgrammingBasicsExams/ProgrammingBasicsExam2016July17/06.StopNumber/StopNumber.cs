using System;

class StopNumber
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int m = int.Parse(Console.ReadLine());
        int stopNumber = int.Parse(Console.ReadLine());

        for (int i = m; i >= n; i--)
        {
            if (i % 2 == 0 && i % 3 == 0)
            {
                if (i == stopNumber)
                {
                    return;
                }
                else
                {
                    Console.Write(i + " ");
                }
            }
        }
    }
}