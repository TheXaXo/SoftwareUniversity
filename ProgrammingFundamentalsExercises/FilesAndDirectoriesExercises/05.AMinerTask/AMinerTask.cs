using System;
using System.Collections.Generic;
using System.Linq;

class AMinerTask
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        Dictionary<string, long> resources = new Dictionary<string, long>();

        while (command != "stop")
        {
            string resource = command;
            int quantity = int.Parse(Console.ReadLine());

            if (resources.ContainsKey(resource))
            {
                resources[resource] += quantity;
            }
            else
            {
                resources[resource] = quantity;
            }

            command = Console.ReadLine();
        }

        foreach (KeyValuePair<string, long> pair in resources)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value}");
        }
    }
}