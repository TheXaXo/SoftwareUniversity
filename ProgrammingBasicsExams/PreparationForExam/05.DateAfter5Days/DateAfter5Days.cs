using System;

class Program
{
    static void Main(string[] args)
    {
        int d = int.Parse(Console.ReadLine());
        int m = int.Parse(Console.ReadLine());
        int days;
        int d2 = 0;
        int m2 = m;

        if (m == 04 || m == 4 || m == 06 || m == 6 || m == 09 || m == 9 || m == 11)
        {
            days = 30;
        }
        else if (m == 02 || m == 2)
        {
            days = 28;
        }
        else
        {
            days = 31;
        }

        if (days - d < 5)
        {
            m2++;
            d2 = 5 - (days - d);
        }
        else if (days - d >= 5)
        {
            d2 = d + 5;
        }
        if (m == 12 && d > 26)
        {
            m2 = 1;
            d2 = 5 - (31 - d);
        }

        //Output
        if (m2 < 10)
        {
            Console.WriteLine("{0}.0{1}", d2, m2);
        }
        else
        {
            Console.WriteLine("{0}.{1}", d2, m2);
        }
    }
}