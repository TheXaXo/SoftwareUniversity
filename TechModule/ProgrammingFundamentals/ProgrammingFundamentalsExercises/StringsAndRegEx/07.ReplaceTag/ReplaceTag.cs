using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class ReplaceTag
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();

        while (input != "end")
        {
            string pattern = @"<a\s*href=""(.+)"">(.+)<\/a>";
            string replacement = @"[URL href=""$1""]$2[/URL]";

            input = Regex.Replace(input, pattern, replacement);
            Console.WriteLine(input);

            input = Console.ReadLine();
        }
    }
}