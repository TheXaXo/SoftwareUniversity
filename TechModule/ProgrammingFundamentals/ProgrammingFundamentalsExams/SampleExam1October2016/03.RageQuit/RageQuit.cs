using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class RageQuit
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        string pattern = @"(.+?)(\d+)";

        MatchCollection matches = Regex.Matches(input, pattern);
        StringBuilder sb = new StringBuilder();
        
        foreach (Match match in matches)
        {
            int count = int.Parse(match.Groups[2].ToString());
            string word = match.Groups[1].ToString();

            for (int i = 1; i <= count; i++)
            {
                sb.Append(word.ToUpper());
            }
        }

        int distinctChars = sb.ToString().Distinct().Count();

        Console.WriteLine($"Unique symbols used: {distinctChars}");
        Console.WriteLine(sb);
    }
}