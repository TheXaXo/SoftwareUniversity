using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class NetherRealms
{
    static void Main(string[] args)
    {
        string input = string.Join(" ", Console.ReadLine()
            .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries));

        SortedDictionary<string, List<decimal>> demons = new SortedDictionary<string, List<decimal>>();

        string[] allDemons = input.Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(x => x.Trim())
            .ToArray();

        char[] characters = new char[] 
        { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/', '.' };

        for (int i = 0; i < allDemons.Length; i++)
        {
            string currentDemon = allDemons[i];
            long currentDemonHealth = 0;
            decimal currentDemonDamage = 0.0M;

            for (int j = 0; j < currentDemon.Length; j++)
            {
                if (!characters.Contains(currentDemon[j]))
                {
                    currentDemonHealth += currentDemon[j];
                }
            }

            MatchCollection matches = Regex.Matches(currentDemon, @"([-]*)(\d+\.*\d*)");
            foreach (Match match in matches)
            {
                if (match.Groups[1].ToString() == "-")
                {
                    currentDemonDamage += -decimal.Parse(match.Groups[2].ToString());
                }
                else
                {
                    currentDemonDamage += decimal.Parse(match.Groups[2].ToString());
                }
            }

            char[] specialSymbols = currentDemon.Where(x => x == '*' || x == '/').ToArray();
            
            for (int j = 0; j < specialSymbols.Length; j++)
            {
                if (specialSymbols[j] == '*')
                {
                    currentDemonDamage *= 2;
                }
                else
                {
                    currentDemonDamage /= 2;
                }
            }

            demons[currentDemon] = new List<decimal>() { currentDemonHealth, currentDemonDamage };
        }

        foreach (KeyValuePair<string, List<decimal>> pair in demons)
        {
            Console.WriteLine($"{pair.Key} - {pair.Value[0]} health, {pair.Value[1]:f2} damage");
        }
    }
}