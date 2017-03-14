using System;
using System.Collections.Generic;
using System.Linq;

class UserLogs
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        SortedDictionary<string, string[]> dictioanry = new SortedDictionary<string, string[]>();

        while (input != "end")
        {
            string[] split = input.Split(' ');
            string ip = split[0].Split('=')[1];
            string message = split[1].Split('=')[1];
            string user = split[2].Split('=')[1];
            string[] ipAddresses = { ip };

            if (dictioanry.ContainsKey(user))
            {
                dictioanry[user] = dictioanry[user].Concat(ipAddresses).ToArray();
            }
            else
            {
                dictioanry[user] = ipAddresses;
            }

            input = Console.ReadLine();
        }

        foreach(KeyValuePair<string, string[]> pair in dictioanry)
        {
            Dictionary<string, int> count = new Dictionary<string, int>();

            foreach(string ip in pair.Value)
            {
                if (count.ContainsKey(ip))
                {
                    count[ip]++;
                }
                else
                {
                    count[ip] = 1;
                }
            }

            Console.WriteLine($"{pair.Key}: ");
            string lastIp = count.Last().Key;

            foreach(KeyValuePair<string, int> countPair in count)
            {
                if (countPair.Key == lastIp)
                {
                    Console.WriteLine($"{countPair.Key} => {countPair.Value}.");
                }
                else
                {
                    Console.Write($"{countPair.Key} => {countPair.Value}, ");
                }
            }
        }
    }
}