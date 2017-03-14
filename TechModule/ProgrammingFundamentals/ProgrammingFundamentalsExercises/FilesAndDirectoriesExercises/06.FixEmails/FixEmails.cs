using System;
using System.Collections.Generic;
using System.Linq;

class FixEmails
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        Dictionary<string, string> personEmail = new Dictionary<string, string>();

        while (command != "stop")
        {
            string person = command;
            string email = Console.ReadLine();
            string domain = email.Split('.').Last().ToLower();

            if (domain != "us" && domain != "uk")
            {
                personEmail[person] = email;
            }

            command = Console.ReadLine();
        }

        foreach (KeyValuePair<string, string> pair in personEmail)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value}");
        }
    }
}