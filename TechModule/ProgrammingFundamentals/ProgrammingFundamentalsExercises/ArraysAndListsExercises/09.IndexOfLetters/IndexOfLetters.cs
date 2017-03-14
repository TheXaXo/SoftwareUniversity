using System;

class IndexOfLetters
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        char[] allLetters = new char['z' - 'a' + 1];
        char current = 'a';

        for (int i = 0; i < allLetters.Length; i++)
        {
            allLetters[i] = current;
            current++;
        }

        for (int i = 0; i < input.Length; i++)
        {
            for (int j = 0; j < allLetters.Length; j++)
            {
                if (input[i] == allLetters[j])
                {
                    Console.WriteLine($"{input[i]} -> {j}");
                    break;
                }
            }
        }
    }
}