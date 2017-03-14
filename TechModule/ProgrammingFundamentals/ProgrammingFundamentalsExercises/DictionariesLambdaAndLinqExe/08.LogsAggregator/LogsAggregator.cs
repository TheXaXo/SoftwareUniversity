using System;
using System.Collections.Generic;
using System.Linq;

class LogsAggregator
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        SortedDictionary<string, List<string>> userIp = new SortedDictionary<string, List<string>>();
        SortedDictionary<string, int> userDuration = new SortedDictionary<string, int>();

        for (int i = 1; i <= n; i++)
        {
            string[] split = Console.ReadLine().Split(' ');
            string ip = split[0];
            string user = split[1];
            int duration = int.Parse(split[2]);
            List<string> ipAsList = new List<string> { ip };

            if (userIp.ContainsKey(user))
            {
                userIp[user] = userIp[user].Concat(ipAsList).ToList();
            }
            else
            {
                userIp[user] = ipAsList;
            }

            if (userDuration.ContainsKey(user))
            {
                userDuration[user] += duration;
            }
            else
            {
                userDuration[user] = duration;
            }
        }

        foreach (KeyValuePair<string, List<string>> pair in userIp)
        {
            List<string> userIpSorted = new List<string>();
            userIpSorted = pair.Value.Distinct().OrderBy(a => a).ToList();

            Console.WriteLine($"{pair.Key}: {userDuration[pair.Key]} [{string.Join(", ", userIpSorted)}]");
        }
    }
}