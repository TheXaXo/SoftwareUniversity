using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class Files
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        string pattern = @"(.+?)\\(?:.+\\)*(.+.\w+);(\d+)";
        Dictionary<string, Dictionary<string, long>> dictionary = new Dictionary<string, Dictionary<string, long>>();

        for (int i = 1; i <= n; i++)
        {
            string input = Console.ReadLine();
            Match match = Regex.Match(input, pattern);

            if (match.Success)
            {
                string root = match.Groups[1].ToString();
                string fileName = match.Groups[2].ToString();
                long fileSize = long.Parse(match.Groups[3].ToString());

                if (dictionary.ContainsKey(root))
                {
                    if (dictionary[root].ContainsKey(fileName))
                    {
                        dictionary[root][fileName] = fileSize;
                    }
                    else
                    {
                        dictionary[root].Add(fileName, fileSize);
                    }
                }
                else
                {
                    Dictionary<string, long> fileAndSize = new Dictionary<string, long>();
                    fileAndSize[fileName] = fileSize;
                    dictionary[root] = fileAndSize;
                }
            }
        }

        string[] split = Console.ReadLine().Split();
        string desiredExtension = split[0];
        string desiredRoot = split[2];
        bool containsDesired = false;

        dictionary = dictionary
            .Where(x => x.Key == desiredRoot)
            .ToDictionary(x => x.Key, x => x.Value);

        foreach (KeyValuePair<string, Dictionary<string, long>> pair in dictionary)
        {
            Dictionary<string, long> fileAndSize = pair.Value;
            fileAndSize = fileAndSize
                .OrderByDescending(x => x.Value)
                .ThenBy(x => x.Key)
                .ToDictionary(x => x.Key, y => y.Value);

            foreach (KeyValuePair<string, long> pairInDesiredRoot in fileAndSize)
            {
                string currentItemExtension = pairInDesiredRoot.Key.Split('.').Last();

                if (currentItemExtension == desiredExtension)
                {
                    Console.WriteLine($"{pairInDesiredRoot.Key} - {pairInDesiredRoot.Value} KB");
                    containsDesired = true;
                }
            }
        }

        if (!containsDesired)
        {
            Console.WriteLine("No");
        }
    }
}