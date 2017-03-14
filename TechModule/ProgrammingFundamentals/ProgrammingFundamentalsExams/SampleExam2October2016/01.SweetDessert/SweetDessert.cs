using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class SweetDessert
{
    static void Main(string[] args)
    {
        decimal cash = decimal.Parse(Console.ReadLine());
        int guestsNumber = int.Parse(Console.ReadLine());
        decimal bananasPrice = decimal.Parse(Console.ReadLine());
        decimal eggsPrice = decimal.Parse(Console.ReadLine());
        decimal berriesPrice = decimal.Parse(Console.ReadLine());

        int sets = (int)Math.Ceiling(guestsNumber / 6M);
        decimal totalSum = 2 * sets * bananasPrice + 4 * sets * eggsPrice + 0.2M * sets * berriesPrice;

        if (cash >= totalSum)
        {
            Console.WriteLine($"Ivancho has enough money - it would cost {totalSum:f2}lv.");
        }
        else
        {
            Console.WriteLine($"Ivancho will have to withdraw money - he will need {(totalSum - cash):f2}lv more.");
        }
    }
}