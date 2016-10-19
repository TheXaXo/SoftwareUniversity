using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class QueryMess
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        string pattern = @"([^?=&]+)=([^?=&]+)";
        string toReplace = @"%20|\+";

        Dictionary<string, string[]> dictionary = new Dictionary<string, string[]>();

        while (command != "END")
        {
            Regex regex = new Regex(pattern);
            command = Regex.Replace(command, toReplace, " ");
            MatchCollection keyValue = Regex.Matches(command, pattern);

            foreach (Match match in keyValue)
            {
                string key = match.Groups[1].ToString().Trim();
                string value = string.Join(" ", match.Groups[2].ToString()
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries));

                if (dictionary.ContainsKey(key))
                {
                    dictionary[key] = dictionary[key].Concat(new string[] { value }).ToArray();
                }
                else
                {
                    dictionary[key] = new string[] { value };
                }
            }

            foreach (KeyValuePair<string, string[]> pair in dictionary)
            {
                Console.Write($"{pair.Key}=[{string.Join(", ", pair.Value)}]");
            }
            Console.WriteLine();

            dictionary = new Dictionary<string, string[]>();
            command = Console.ReadLine();
        }
    }
}