using System;

class FruitShop
{
    static void Main(string[] args)
    {
        string fruit = Console.ReadLine();
        string dayOfWeek = Console.ReadLine();
        double quantity = double.Parse(Console.ReadLine());
        double sum = 0;

        if (dayOfWeek == "Monday" || dayOfWeek == "Tuesday" || dayOfWeek == "Wednesday" || dayOfWeek == "Thursday" || dayOfWeek == "Friday")
        {
            if (fruit == "banana")
            {
                sum = quantity * 2.5;
            }
            else if (fruit == "apple")
            {
                sum = quantity * 1.2;
            }
            else if (fruit == "orange")
            {
                sum = quantity * 0.85;
            }
            else if (fruit == "grapefruit")
            {
                sum = quantity * 1.45;
            }
            else if (fruit == "kiwi")
            {
                sum = quantity * 2.7;
            }
            else if (fruit == "pineapple")
            {
                sum = quantity * 5.5;
            }
            else if (fruit == "grapes")
            {
                sum = quantity * 3.85;
            }
            else
            {
                Console.WriteLine("error");
            }
        }
        else if (dayOfWeek == "Saturday" || dayOfWeek == "Sunday")
        {
            if (fruit == "banana")
            {
                sum = quantity * 2.7;
            }
            else if (fruit == "apple")
            {
                sum = quantity * 1.25;
            }
            else if (fruit == "orange")
            {
                sum = quantity * 0.90;
            }
            else if (fruit == "grapefruit")
            {
                sum = quantity * 1.6;
            }
            else if (fruit == "kiwi")
            {
                sum = quantity * 3;
            }
            else if (fruit == "pineapple")
            {
                sum = quantity * 5.6;
            }
            else if (fruit == "grapes")
            {
                sum = quantity * 4.2;
            }
            else
            {
                Console.WriteLine("error");
            }
        }
        else
        {
            Console.WriteLine("error");
        }

        Console.WriteLine("{0:f2}", sum);
    }
}