using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class ExtractSentencesByKeyword
{
    static void Main(string[] args)
    {
        string word = Console.ReadLine();
        char[] separators = { '!', '.', '?' };
        string[] input = Console.ReadLine().Split(separators)
            .Select(x => x.Trim())
            .ToArray();

        foreach (string sentance in input)
        {
            string pattern = @"[A-Za-z0-9]+";
            MatchCollection matches = Regex.Matches(sentance, pattern);
            foreach (Match match in matches)
            {
                if (match.ToString() == word)
                {
                    Console.WriteLine(sentance);
                    break;
                }
            }
        }
    }
}