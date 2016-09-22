using System;

class Money
{
    static void Main(string[] args)
    {
        int bitcoins = int.Parse(Console.ReadLine()) * 1168;
        double chinease = double.Parse(Console.ReadLine()) * 0.15 * 1.76;
        double commission = double.Parse(Console.ReadLine());
        double sum = ((bitcoins + chinease) / 1.95) * (100 - commission) / 100;

        Console.WriteLine(sum);
    }
}