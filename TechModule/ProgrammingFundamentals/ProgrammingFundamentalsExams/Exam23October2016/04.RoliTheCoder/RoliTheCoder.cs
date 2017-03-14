using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class RoliTheCoder
{
    static void Main(string[] args)
    {
        string command = string.Join(" ", Console.ReadLine()
            .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries));

        Dictionary<int, string> idEvent = new Dictionary<int, string>();
        Dictionary<string, List<string>> eventParticipants = new Dictionary<string, List<string>>();

        while (command != "Time for Code")
        {
            Match match = Regex.Match(command, @"^(?:(\d+)\s\#([^\s\@]+)\s*((?:\@[^\s\@]+\s*)*))$");
            if (!match.Success)
            {
                command = Console.ReadLine();
                continue;
            }

            int id = int.Parse(match.Groups[1].ToString());
            string eventName = match.Groups[2].ToString();
            List<string> participants = match.Groups[3].ToString()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Distinct()
                .ToList();

            if (!idEvent.ContainsKey(id))
            {
                eventParticipants[eventName] = participants;
                idEvent[id] = eventName;
            }
            else if (idEvent[id] == eventName)
            {
                List<string> participantsAlreadyThere = eventParticipants[eventName];
                for (int i = 0; i < participants.Count; i++)
                {
                    if (!participantsAlreadyThere.Contains(participants[i]))
                    {
                        participantsAlreadyThere.Add(participants[i]);
                    }
                }
            }

            command = Console.ReadLine();
        }

        eventParticipants = eventParticipants
            .OrderByDescending(x => x.Value.Count())
            .ThenBy(x => x.Key)
            .ToDictionary(x => x.Key, y => y.Value);

        foreach (KeyValuePair<string, List<string>> pair in eventParticipants)
        {
            Console.WriteLine($"{pair.Key} - {pair.Value.Count}");

            List<string> participants = pair.Value.OrderBy(x => x).ToList();

            foreach (string participant in participants)
            {
                Console.WriteLine(participant);
            }
        }
    }
}