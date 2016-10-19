using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class UnicodeCharacters
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        StringBuilder sb = new StringBuilder();

        foreach (char c in input)
        {
            sb.Append("\\u");
            sb.Append(((int)c).ToString("x4"));
        }
        Console.WriteLine(sb);
    }
}