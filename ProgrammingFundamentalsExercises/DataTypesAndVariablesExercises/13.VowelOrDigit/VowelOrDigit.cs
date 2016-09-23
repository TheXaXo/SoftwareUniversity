using System;

class VowelOrDigit
{
    static void Main(string[] args)
    {
        char input = char.Parse(Console.ReadLine());
        string type = null;

        if ((int)(input) >= 48 && (int)(input) <= 57)
        {
            type = "digit";
        }
        else if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u')
        {
            type = "vowel";
        }
        else
        {
            type = "other";
        }

        Console.WriteLine(type);
    }
}