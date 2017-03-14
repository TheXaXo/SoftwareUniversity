using System;
using System.Collections.Generic;
using System.Linq;

class TextFilter
{
    static void Main(string[] args)
    {
        char[] separators = { ',', ' ' };
        string[] listOfBannedWords = Console.ReadLine().Split(separators, StringSplitOptions.RemoveEmptyEntries);
        string input = Console.ReadLine();

        foreach (string banWord in listOfBannedWords)
        {
            input = input.Replace(banWord, new string('*', banWord.Length));
        }

        Console.WriteLine(input);
    }
}