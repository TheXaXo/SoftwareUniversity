using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Diagnostics;

class Palindromes
{
    static void Main(string[] args)
    {
        char[] separators = { ',', '.', '!', '?', ' ' };
        string[] input = Console.ReadLine()
            .Split(separators, StringSplitOptions.RemoveEmptyEntries);
        List<string> palindromes = new List<string>();

        string partOne = null;
        string partTwo = null;

        foreach (string word in input)
        {
            partOne = string.Join("", word.Take(word.Length / 2));
            string wordReversed = string.Join("", word.Reverse());
            partTwo = string.Join("", wordReversed.Take(word.Length / 2));

            if (partOne.Equals(partTwo))
            {
                palindromes.Add(word);
            }
        }

        palindromes = palindromes.Distinct()
            .OrderBy(x => x)
            .ToList();

        Console.WriteLine(string.Join(", ", palindromes));       
    }
}