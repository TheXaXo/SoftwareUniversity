using System;
using System.Collections.Generic;
using System.Linq;

class AMinerTask
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        Dictionary<string, int> dictionary = new Dictionary<string, int>();

        while (command != "stop")
        {
            string resource = command;
            int quantity = int.Parse(Console.ReadLine());

            if (dictionary.ContainsKey(resource))
            {
                dictionary[resource] = dictionary[resource] + quantity;
            }
            else
            {
                dictionary[resource] = quantity;
            }
            command = Console.ReadLine();
        }

        foreach (KeyValuePair<string, int> pair in dictionary)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value}");
        }
    }
}