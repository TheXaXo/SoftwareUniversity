using System;

class RandomizeWords
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        string[] split = input.Split(' ');
        Random random = new Random();

        for (int i = 0; i < split.Length; i++)
        {
            int position = random.Next(split.Length - 1);
            string oldStirng = split[i];
            split[i] = split[position];
            split[position] = oldStirng;
        }

        foreach (string str in split)
        {
            Console.WriteLine(str);
        }
    }
}