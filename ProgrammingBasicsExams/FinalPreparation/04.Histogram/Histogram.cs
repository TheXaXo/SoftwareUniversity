﻿using System;

class Histogram
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;

        for (int i = 1; i <= n; i++)
        {
            int number = int.Parse(Console.ReadLine());

            if (number < 200)
            {
                p1++;
            }
            else if (number <= 399)
            {
                p2++;
            }
            else if (number <= 599)
            {
                p3++;
            }
            else if (number <= 799)
            {
                p4++;
            }
            else
            {
                p5++;
            }
        }

        Console.WriteLine("{0:f2}%", (double)p1 / n * 100);
        Console.WriteLine("{0:f2}%", (double)p2 / n * 100);
        Console.WriteLine("{0:f2}%", (double)p3 / n * 100);
        Console.WriteLine("{0:f2}%", (double)p4 / n * 100);
        Console.WriteLine("{0:f2}%", (double)p5 / n * 100);
    }
}