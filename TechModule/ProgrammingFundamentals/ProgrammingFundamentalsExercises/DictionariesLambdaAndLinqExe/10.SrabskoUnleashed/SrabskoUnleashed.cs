using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

class SrabskoUnleashed
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        string pattern = @"([A-Za-z]+\s(?:[A-Za-z]+\s){0,2})@([A-Za-z]+\s(?:[A-Za-z]+\s){0,2})(\d+)\s(\d+)";

        Dictionary<string, Dictionary<string, int>> venueAndSingers = new Dictionary<string, Dictionary<string, int>>();

        while (command != "End")
        {
            Match match = Regex.Match(command, pattern);
            if (!match.Success)
            {
                command = Console.ReadLine();
                continue;
            }

            string singer = match.Groups[1].ToString();
            string venue = match.Groups[2].ToString();
            int ticketPrice = int.Parse(match.Groups[3].ToString());
            int ticketsSold = int.Parse(match.Groups[4].ToString());

            Dictionary<string, int> singerAndMoney = new Dictionary<string, int>();
            singerAndMoney[singer] = ticketPrice * ticketsSold;

            if (venueAndSingers.ContainsKey(venue))
            {
                if (venueAndSingers[venue].ContainsKey(singer))
                {
                    venueAndSingers[venue][singer] = venueAndSingers[venue][singer] += singerAndMoney[singer];
                }
                else
                {
                    venueAndSingers[venue] = venueAndSingers[venue].Concat(singerAndMoney).ToDictionary(x => x.Key, y => y.Value);
                }
            }
            else
            {
                venueAndSingers[venue] = singerAndMoney;
            }

            command = Console.ReadLine();
        }

        foreach (KeyValuePair<string, Dictionary<string, int>> pair in venueAndSingers)
        {
            Console.WriteLine(pair.Key);
            Dictionary<string, int> singers = pair.Value
                .OrderByDescending(x => x.Value)
                .ToDictionary(x => x.Key, y => y.Value);

            foreach (KeyValuePair<string, int> signersPair in singers)
            {
                Console.WriteLine($"#  {signersPair.Key.Trim()} -> {signersPair.Value}");
            }
        }
    }
}