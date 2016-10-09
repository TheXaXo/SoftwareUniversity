using System;
using System.Collections.Generic;
using System.Linq;

class LegendaryFarming
{
    static void Main(string[] args)
    {
        string[] command = Console.ReadLine().Split(' ');

        Dictionary<string, int> keyItems = new Dictionary<string, int>();
        SortedDictionary<string, int> junk = new SortedDictionary<string, int>();
        keyItems["shards"] = 0;
        keyItems["fragments"] = 0;
        keyItems["motes"] = 0;

        bool hasBeenObtained = false;
        string obtainedItem = null;

        while (!hasBeenObtained)
        {
            for (int i = 0; i < command.Length - 1; i += 2)
            {
                int quantity = int.Parse(command[i]);
                string item = command[i + 1].ToLower();

                if (item == "shards" || item == "fragments" || item == "motes")
                {
                    keyItems[item] += quantity;
                }
                
                else if (junk.ContainsKey(item))
                {
                    junk[item] += quantity;
                }
                else
                {
                    junk[item] = quantity;
                }

                if (keyItems.ContainsKey("shards") && keyItems["shards"] >= 250)
                {
                    hasBeenObtained = true;
                    obtainedItem = "Shadowmourne";
                    keyItems["shards"] -= 250;
                    break;
                }
                else if (keyItems.ContainsKey("fragments") && keyItems["fragments"] >= 250)
                {
                    hasBeenObtained = true;
                    obtainedItem = "Valanyr";
                    keyItems["fragments"] -= 250;
                    break;
                }
                else if (keyItems.ContainsKey("motes") && keyItems["motes"] >= 250)
                {
                    hasBeenObtained = true;
                    obtainedItem = "Dragonwrath";
                    keyItems["motes"] -= 250;
                    break;
                }
            }
            if (!hasBeenObtained)
            {
                command = Console.ReadLine().Split(' ');
            }          
        }

        keyItems = keyItems.OrderByDescending(item => item.Value).ThenBy(item => item.Key).ToDictionary(item => item.Key, item => item.Value);

        Console.WriteLine($"{obtainedItem} obtained!");

        foreach(KeyValuePair<string, int> pair in keyItems)
        {
            Console.WriteLine($"{pair.Key}: {pair.Value}");
        }
        foreach(KeyValuePair<string, int> pair in junk)
        {
            Console.WriteLine($"{pair.Key}: {pair.Value}");
        }
    }
}