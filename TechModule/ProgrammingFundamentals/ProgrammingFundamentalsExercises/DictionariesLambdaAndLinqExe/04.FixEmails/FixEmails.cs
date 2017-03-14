using System;
using System.Collections.Generic;
using System.Linq;

class FixEmails
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        Dictionary<string, string> dictionary = new Dictionary<string, string>();

        while (command != "stop")
        {
            string name = command;
            string email = Console.ReadLine();
            string[] emailSplitPartOne = email.Split('@');
            string[] emailSplitPartTwo = emailSplitPartOne[1].Split('.');
            string domain = emailSplitPartTwo[emailSplitPartTwo.Length - 1].ToLower();

            if (domain != "us" && domain != "uk")
            {
                dictionary[name] = email;
            }

            command = Console.ReadLine();
        }

        foreach (KeyValuePair<string, string> pair in dictionary)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value}");
        }
    }
}