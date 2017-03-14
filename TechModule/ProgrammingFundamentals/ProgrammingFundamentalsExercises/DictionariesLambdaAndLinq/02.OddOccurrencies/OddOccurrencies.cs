using System;
using System.Collections.Generic;

class OddOccurrencies
{
    static void Main(string[] args)
    {
        string[] input = Console.ReadLine().ToLower().Split(' ');
        Dictionary<string, int> dictionary = new Dictionary<string, int>();

        foreach(string word in input)
        {
            if (!dictionary.ContainsKey(word))
            {
                dictionary[word] = 1;
            }
            else
            {
                dictionary[word]++;
            }
        }

        List<string> oddWords = new List<string>();

        foreach (KeyValuePair<string, int> pair in dictionary)
        {
            if (pair.Value % 2 != 0)
            {
                oddWords.Add(pair.Key);
            }
        }

        Console.WriteLine(string.Join(", ", oddWords));
    }
}