using System;

class SmartLilly
{
    static void Main(string[] args)
    {
        int age = int.Parse(Console.ReadLine());
        double washerPrice = double.Parse(Console.ReadLine());
        int toyPrice = int.Parse(Console.ReadLine());
        int sum = 0;
        int toys = 0;
        int moneyGift = 10;

        for (int i = 1; i <= age; i++)
        {
            if (i % 2 == 0)
            {
                sum += moneyGift;
                sum -= 1;
                moneyGift += 10;
            }
            else
            {
                toys++;
            }
        }

        if (washerPrice > (toys * toyPrice + sum))
        {
            Console.WriteLine("No! {0:f2}", washerPrice - (toys * toyPrice + sum));
        }
        else
        {
            Console.WriteLine("Yes! {0:f2}", (toys * toyPrice + sum) - washerPrice);
        }
    }
}