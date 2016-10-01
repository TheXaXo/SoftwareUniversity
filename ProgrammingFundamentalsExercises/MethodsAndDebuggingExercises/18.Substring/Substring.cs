using System;

class Substring
{
    static void Main(string[] args)
    {
        string text = Console.ReadLine();
        int jump = int.Parse(Console.ReadLine());
        bool hasMatch = false;

        for (int i = 0; i < text.Length; i++)
        {
            if (text[i] == 'p' && jump != 0)
            {
                hasMatch = true;
                int endIndex = jump;

                while (endIndex + i > text.Length - 1)
                {
                    endIndex--;
                }

                string matchedString = text.Substring(i, endIndex + 1);
                Console.WriteLine(matchedString);
                i += jump - 1;
            }
        }

        if (!hasMatch)
        {
            Console.WriteLine("no");
        }
    }
}