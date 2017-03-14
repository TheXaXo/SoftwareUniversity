using System;

class CompoundInterest
{
    static void Main(string[] args)
    {
        decimal priceOfTV = decimal.Parse(Console.ReadLine());
        int term = int.Parse(Console.ReadLine());
        decimal bankInterest = decimal.Parse(Console.ReadLine());
        decimal friendInterest = decimal.Parse(Console.ReadLine());

        decimal bankFutureValue = priceOfTV * (decimal)(Math.Pow(1 + (double)bankInterest, term));
        decimal friendFutureValue = priceOfTV * friendInterest + priceOfTV;

        if (friendFutureValue <= bankFutureValue)
        {
            Console.WriteLine("{0:f2} Friend", friendFutureValue);
        }
        else
        {
            Console.WriteLine("{0:f2} Bank", bankFutureValue);
        }
    }
}