using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;

class WordCount
{
    static void Main(string[] args)
    {
        File.WriteAllText("output.txt", "");
        char[] separators = { ',', ' ', '-', '?', '!', '.', '\r', '\n' };
        string[] text = File.ReadAllText("text.txt")
            .ToLower()
            .Split(separators, StringSplitOptions.RemoveEmptyEntries);

        string[] words = File.ReadAllText("words.txt").Split(' ');

        Dictionary<string, int> wordAndCount = new Dictionary<string, int>();

        foreach (string word in words)
        {
            wordAndCount[word] = 0;
        }

        foreach (string word in text)
        {
            if (wordAndCount.ContainsKey(word))
            {
                wordAndCount[word]++;
            }
        }

        wordAndCount = wordAndCount.OrderByDescending(x => x.Value).ToDictionary(x => x.Key, y => y.Value);

        foreach (KeyValuePair<string, int> pair in wordAndCount)
        {
            File.AppendAllText("output.txt", $"{pair.Key} - {pair.Value} \r\n");
        }
    }
}