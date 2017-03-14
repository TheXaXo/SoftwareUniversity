using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

class Files
{
    static void Main(string[] args)
    {
        string pattern = @"([^\\]+)\\(?:[^\\]+\\)+(.+);(\d+)";
        int n = int.Parse(Console.ReadLine());
        List<Match> matches = new List<Match>();

        for (int i = 1; i <= n; i++)
        {
            string input = Console.ReadLine();
            Match match = Regex.Match(input, pattern);

            matches.Add(match);
        }

        string[] split = Console.ReadLine().Split();
        string desiredExtension = split[0];
        string desiredRoot = split[2];

        Dictionary<string, long> fileAndSize = new Dictionary<string, long>();

        foreach (Match match in matches)
        {
            string root = match.Groups[1].ToString();
            string fileName = match.Groups[2].ToString();
            string fileExtension = fileName.Split('.').Last();
            long fileSize = long.Parse(match.Groups[3].ToString());

            if (root == desiredRoot && fileExtension == desiredExtension)
            {
                fileAndSize[fileName] = fileSize;
            }
        }

        fileAndSize = fileAndSize
            .OrderByDescending(x => x.Value)
            .ThenBy(x => x.Key)
            .ToDictionary(x => x.Key, y => y.Value);

        if (fileAndSize.Count == 0)
        {
            Console.WriteLine("No");
            return;
        }

        foreach (KeyValuePair<string, long> pair in fileAndSize)
        {
            Console.WriteLine($"{pair.Key} - {pair.Value} KB");
        }
    }
}