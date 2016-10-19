using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class LettersChangeNumbers
{
    static void Main(string[] args)
    {
        string[] split = Console.ReadLine()
            .Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(x => x.Trim())
            .ToArray();

        decimal result = 0.0M;

        foreach (string word in split)
        {
            char firstLetter = word[0];
            decimal number = decimal.Parse(string.Join("", word.Where(x => x >= 48 && x <= 57)));
            char lastLetter = word[word.Length - 1];

            if (firstLetter >= 65 && firstLetter <= 90)
            {
                int positionInTheAlphabet = firstLetter - 64;
                number /= positionInTheAlphabet;
            }
            else
            {
                int positionInTheAlphabet = firstLetter - 96;
                number *= positionInTheAlphabet;
            }

            if (lastLetter >= 65 && lastLetter <= 90)
            {
                int positionInTheAlphabet = lastLetter - 64;
                number -= positionInTheAlphabet;
            }
            else
            {
                int positionInTheAlphabet = lastLetter - 96;
                number += positionInTheAlphabet;
            }

            result += number;
        }

        Console.WriteLine($"{result:f2}");
    }
}