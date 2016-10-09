using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        string[] command = Console.ReadLine().Split(' ');
        string action = command[0];
        string name = null;
        string number = null;

        if (action != "END")
        {
            name = command[1];
        }

        if (action == "A")
        {
            number = command[2];
        }

        Dictionary<string, string> dictionary = new Dictionary<string, string>();

        while (action != "END")
        {
            if (action == "A")
            {
                dictionary[name] = number;
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

            if (action != "END")
            {
                name = command[1];
            }
            if (action == "A")
            {
                number = command[2];
            }
        }
    }
}