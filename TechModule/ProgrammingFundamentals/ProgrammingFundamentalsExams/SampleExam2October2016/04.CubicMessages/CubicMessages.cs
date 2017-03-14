using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class CubicMessages
{
    static void Main(string[] args)
    {
        string pattern = @"(^\d+)([A-Za-z]+)([^A-Za-z]*)$";
        string command = Console.ReadLine();

        while (command != "Over!")
        {
            Match match = Regex.Match(command, pattern);
            int count = int.Parse(Console.ReadLine());
            string message = match.Groups[2].ToString();
            StringBuilder sb = new StringBuilder();

            if (match.Success && count == message.Length)
            {
                char[] firstIndexes = match.Groups[1].ToString().ToCharArray();
                foreach (char c in firstIndexes)
                {
                    if (int.Parse(c.ToString()) <= message.Length - 1)
                    {
                        sb.Append(message[int.Parse(c.ToString())]);
                    }
                    else
                    {
                        sb.Append(" ");
                    }
                }

                char[] lastIndexes = match.Groups[3].ToString().ToCharArray();
                if (lastIndexes.Length > 0)
                {
                    foreach (char c in lastIndexes)
                    {
                        if (c >= 48 && c <= 57 && int.Parse(c.ToString()) <= message.Length - 1)
                        {
                            sb.Append(message[int.Parse(c.ToString())]);
                        }
                        else
                        {
                            sb.Append(" ");
                        }
                    }
                }
                Console.WriteLine($"{message} == {sb}");
            }            
            command = Console.ReadLine();
        }
    }
}