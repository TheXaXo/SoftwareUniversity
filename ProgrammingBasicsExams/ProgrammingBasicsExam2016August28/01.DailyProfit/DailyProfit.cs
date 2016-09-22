using System;

class Program
{
    static void Main(string[] args)
    {
        int workDays = int.Parse(Console.ReadLine());
        double moneyPerDay = double.Parse(Console.ReadLine());
        double rate = double.Parse(Console.ReadLine());

        double monthlyProfit = moneyPerDay * workDays;
        double yearlyProfit = 12 * monthlyProfit + 2.5 * monthlyProfit;
        double moneyAfterTax = yearlyProfit * 0.75;
        double moneyAfterTaxInBGN = moneyAfterTax * rate;
        double profitPerDayBGN = moneyAfterTaxInBGN / 365;

        Console.WriteLine("{0:f2}", profitPerDayBGN);
    }
}