using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class MagicExchangeableWords
{
    static void Main(string[] args)
    {
        string[] split = Console.ReadLine().Split().OrderBy(x => x).ToArray();
        string shorterOrEqualWord = split[0];
        string longerOrEqualWord = split[1];

        Dictionary<char, char> dictionary = new Dictionary<char, char>();

        for (int i = 0; i < shorterOrEqualWord.Length; i++)
        {
            if (!dictionary.ContainsKey(shorterOrEqualWord[i]))
            {
                dictionary[shorterOrEqualWord[i]] = longerOrEqualWord[i];
            }
        }

        if (shorterOrEqualWord == longerOrEqualWord)
        {
            for (int i = 0; i < shorterOrEqualWord.Length; i++)
            {
                if (shorterOrEqualWord[i] != longerOrEqualWord[i])
                {
                    Console.WriteLine("false");
                    return;
                }
            }
            Console.WriteLine("true");
        }
        else
        {
            for (int i = 0; i < longerOrEqualWord.Length; i++)
            {
                if (!dictionary.ContainsValue(longerOrEqualWord[i]))
                {
                    Console.WriteLine("false");
                    return;
                }
            }
            Console.WriteLine("true");
        }
    }
}