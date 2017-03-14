using System;
using System.Collections.Generic;
using System.Linq;

class SalesReport
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        List<Sale> list = new List<Sale>();

        for (int i = 1; i <= n; i++)
        {
            Sale sale = ReadSale();
            list.Add(sale);
        }

        SortedDictionary<string, double> salesByTown = new SortedDictionary<string, double>();

        for (int i = 0; i < list.Count; i++)
        {
            Sale currentSale = list[i];
            if (salesByTown.ContainsKey(currentSale.Town))
            {
                salesByTown[currentSale.Town] += currentSale.Quantity * currentSale.Price;
            }
            else
            {
                salesByTown[currentSale.Town] = currentSale.Quantity * currentSale.Price;
            }
        }

        foreach(KeyValuePair<string, double> pair in salesByTown)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value:f2}");
        }
    }

    static Sale ReadSale()
    {
        Sale sale = new Sale();
        string[] split = Console.ReadLine().Split(' ');
        sale.Town = split[0];
        sale.Product = split[1];
        sale.Price = double.Parse(split[2]);
        sale.Quantity = double.Parse(split[3]);

        return sale;
    }
}

class Sale
{
    public string Town { get; set; }
    public string Product { get; set; }
    public double Price { get; set; }
    public double Quantity { get; set; }
}