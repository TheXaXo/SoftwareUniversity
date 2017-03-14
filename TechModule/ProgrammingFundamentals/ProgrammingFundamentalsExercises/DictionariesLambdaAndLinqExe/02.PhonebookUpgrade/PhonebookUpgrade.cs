using System;
using System.Collections.Generic;
using System.Linq;

class PhonebookUpgrade
{
    static void Main(string[] args)
    {
        string[] command = Console.ReadLine().Split(' ');
        string action = command[0];
        string name = null;
        string number = null;

        if (action == "A")
        {
            name = command[1];
            number = command[2];
        }
        else if (action == "S")
        {
            name = command[1];
        }

        SortedDictionary<string, string> dictionary = new SortedDictionary<string, string>();

        while (action != "END")
        {
            if (action == "A")
            {
                dictionary[name] = number;
            }
            else if (action == "ListAll")
            {
                foreach (KeyValuePair<string, string> pair in dictionary)
                {
                    Console.WriteLine($"{pair.Key} -> {pair.Value}");
                }
            }
            else if (action == "S")
            {
                if (dictionary.ContainsKey(name))
                {
                    Console.WriteLine($"{name} -> {dictionary[name]}");
                }
                else
                {
                    Console.WriteLine($"Contact {name} does not exist.");
                }
            }

            command = Console.ReadLine().Split(' ');
            action = command[0];

            if (action == "A")
            {
                name = command[1];
                number = command[2];
            }
            else if (action == "S")
            {
                name = command[1];
            }
        }
    }
}