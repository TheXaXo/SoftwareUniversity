using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Globalization;

class SoftUniCoffeeOrders
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        decimal totalPrice = 0;

        for (int i = 0; i < n; i++)
        {
            Order order = GetOrder();
            decimal price = (DateTime.DaysInMonth(order.OrderDate.Year, order.OrderDate.Month) * order.Capsules) * order.CapsulePrice;
            totalPrice += price;

            Console.WriteLine($"The price for the coffee is: ${price:f2}");
        }

        Console.WriteLine($"Total: ${totalPrice:f2}");
    }

    static Order GetOrder()
    {
        Order order = new Order();
        order.CapsulePrice = decimal.Parse(Console.ReadLine());
        order.OrderDate = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
        order.Capsules = long.Parse(Console.ReadLine());

        return order;
    }
}

class Order
{
    public decimal CapsulePrice { get; set; }
    public DateTime OrderDate = new DateTime();
    public long Capsules { get; set; }
}