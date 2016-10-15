using System;
using System.Collections.Generic;
using System.Linq;

class AndreiAndBilliard
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        Dictionary<string, decimal> products = new Dictionary<string, decimal>();

        for (int i = 1; i <= n; i++)
        {
            string[] split = Console.ReadLine().Split('-');
            string productName = split[0];
            decimal productPrice = decimal.Parse(split[1]);

            products[productName] = productPrice;
        }

        List<Order> allOrders = new List<Order>();
        string command = Console.ReadLine();

        while (command != "end of clients")
        {
            Order order = GetOrder(command);
            string orderProduct = order.ShoppingList.Last().Key;
            int orderQuantity = order.ShoppingList.Last().Value;

            if (!products.ContainsKey(orderProduct))
            {
                command = Console.ReadLine();
                continue;
            }

            if (allOrders.Exists(x => x.Customer == order.Customer))
            {
                Order currentCustomer = allOrders.First(x => x.Customer == order.Customer);

                if (currentCustomer.ShoppingList.ContainsKey(orderProduct))
                {
                    currentCustomer.ShoppingList[orderProduct] += orderQuantity;
                }
                else
                {
                    currentCustomer.ShoppingList[orderProduct] = orderQuantity;
                }
            }
            else
            {
                allOrders.Add(order);
            }

            command = Console.ReadLine();
        }

        allOrders = allOrders.OrderBy(x => x.Customer).ToList();
        decimal totalBill = 0;

        foreach (Order order in allOrders)
        {
            decimal currentBill = 0;

            Console.WriteLine(order.Customer);

            foreach (KeyValuePair<string, int> currentCustomerOrders in order.ShoppingList)
            {
                Console.WriteLine($"-- {currentCustomerOrders.Key} - {currentCustomerOrders.Value}");
                currentBill += currentCustomerOrders.Value * products[currentCustomerOrders.Key];
            }

            totalBill += currentBill;
            Console.WriteLine($"Bill: {currentBill:f2}");
        }

        Console.WriteLine($"Total bill: {totalBill:f2}");
    }

    static Order GetOrder(string input)
    {
        char[] separators = { '-', ',' };
        string[] split = input.Split(separators);
        string customer = split[0];
        string product = split[1];
        int quantity = int.Parse(split[2]);

        Order order = new Order();
        order.Customer = customer;
        order.ShoppingList[product] = quantity;

        return order;
    }
}

class Order
{
    public string Customer { get; set; }
    public Dictionary<string, int> ShoppingList = new Dictionary<string, int>();
}