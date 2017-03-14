using System;
using System.Collections.Generic;
using System.Linq;

class HandsOfCards
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        Dictionary<string, string[]> dictionary = new Dictionary<string, string[]>();
        Dictionary<string, int> result = new Dictionary<string, int>();

        while (command != "JOKER")
        {
            string name = command.Split(':')[0];
            string[] cards = command.Split(':')[1].Trim().Split(',');
            cards = cards.Select(n => n.Trim()).ToArray();

            if (dictionary.ContainsKey(name))
            {
                dictionary[name] = dictionary[name].Concat(cards).ToArray();
            }
            else
            {
                dictionary[name] = cards;
            }

            command = Console.ReadLine();
        }

        foreach (KeyValuePair<string, string[]> pair in dictionary)
        {
            string[] cards = pair.Value.Distinct().ToArray();

            foreach (string card in cards)
            {
                string cardPower = null;
                string cardType = null;
                if (card.Length == 3)
                {
                    cardPower = string.Join("", card.Take(2));
                    cardType = string.Join("", card.Skip(2));
                }
                else
                {
                    cardPower = card[0].ToString();
                    cardType = card[1].ToString();
                }

                int powerNum = GetPowerNum(cardPower);
                int typeMultiplier = GetTypeMultiplier(cardType);

                if (result.ContainsKey(pair.Key))
                {
                    result[pair.Key] = result[pair.Key] + powerNum * typeMultiplier;
                }
                else
                {
                    result[pair.Key] = powerNum * typeMultiplier;
                }
            }

            Console.WriteLine($"{pair.Key}: {result[pair.Key]}");
        }
    }

    static int GetPowerNum(string cardPower)
    {
        int power = 0;

        if (cardPower == "10")
        {
            power = 10;
        }
        else if (char.Parse(cardPower) >= 50 && char.Parse(cardPower) <= 57)
        {
            power = int.Parse(cardPower.ToString());
        }
        else if (cardPower == "J")
        {
            power = 11;
        }
        else if (cardPower == "Q")
        {
            power = 12;
        }
        else if (cardPower == "K")
        {
            power = 13;
        }
        else if (cardPower == "A")
        {
            power = 14;
        }

        return power;
    }

    static int GetTypeMultiplier(string type)
    {
        int multiplier = 0;

        if (type == "S")
        {
            multiplier = 4;
        }
        else if (type == "H")
        {
            multiplier = 3;
        }
        else if (type == "D")
        {
            multiplier = 2;
        }
        else if (type == "C")
        {
            multiplier = 1;
        }

        return multiplier;
    }
}