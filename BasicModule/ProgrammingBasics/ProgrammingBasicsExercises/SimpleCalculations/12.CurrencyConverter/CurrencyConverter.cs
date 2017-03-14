using System;

class CurrencyConverter
{
    static void Main(string[] args)
    {
        double money = double.Parse(Console.ReadLine());
        string input = Console.ReadLine();
        string output = Console.ReadLine();
        double inputRate = 0;
        double outputRate = 0;

        if (input == "USD")
        {
            inputRate = 1.79549;
        }
        else if (input == "EUR")
        {
            inputRate = 1.95583;
        }
        else if (input == "GBP")
        {
            inputRate = 2.53405;
        }
        else if (input == "BGN")
        {
            inputRate = 1;
        }

        if (output == "USD")
        {
            outputRate = 1.79549;
        }
        else if (output == "EUR")
        {
            outputRate = 1.95583;
        }
        else if (output == "GBP")
        {
            outputRate = 2.53405;
        }
        else if (output == "BGN")
        {
            outputRate = 1;
        }

        double result = money * inputRate / outputRate;
        Console.WriteLine("{0} EUR", Math.Round(result, 2));
    }
}