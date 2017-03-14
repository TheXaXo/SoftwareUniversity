using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class UseYourChainsBuddy
{
    static void Main(string[] args)
    {
        string pattern = @"<p>(.+?)<\/p>";
        string input = Console.ReadLine();

        MatchCollection matches = Regex.Matches(input, pattern);
        StringBuilder sb = new StringBuilder();

        foreach (Match match in matches)
        {
            sb.Append(match.Groups[1].ToString());
        }

        for (int i = 0; i < sb.Length; i++)
        {
            if (!((sb[i] >= 97 && sb[i] <= 122) || (sb[i] >= 48 && sb[i] <= 57)))
            {
                sb[i] = ' ';
            }
        }

        for (int i = 0; i < sb.Length; i++)
        {
            if (sb[i] >= 97 && sb[i] <= 109)
            {
                sb[i] = (char)(sb[i] - 97 + 110);
            }
            else if (sb[i] >= 110 && sb[i] <= 122)
            {
                sb[i] = (char)(sb[i] - 110 + 97);
            }
        }

        string result = Regex.Replace(sb.ToString(), @"\s+", " ");
            
        Console.WriteLine(result);
    }
}