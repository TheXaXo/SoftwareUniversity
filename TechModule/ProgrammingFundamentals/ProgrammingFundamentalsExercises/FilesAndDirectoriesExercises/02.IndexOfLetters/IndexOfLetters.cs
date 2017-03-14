using System;
using System.Collections.Generic;
using System.Linq;

class IndexOfLetters
{
    static void Main(string[] args)
    {
        char[] alphabet = new char[26];

        int index = 0;
        for (char a = 'a'; a <= 'z'; a++)
        {
            alphabet[index] = a;
            index++;
        }

        string input = Console.ReadLine().ToLower();

        for (int i = 0; i < input.Length; i++)
        {
            for (int j = 0; j < alphabet.Length; j++)
            {
                if (alphabet[j] == input[i])
                {
                    Console.WriteLine($"{input[i]} -> {j}");
                    break;
                }
            }
        }
    }
}