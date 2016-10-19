using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class MelrahShake
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        string pattern = Console.ReadLine();

        while (input.IndexOf(pattern) != input.LastIndexOf(pattern) && pattern.Length > 0)
        {
            Console.WriteLine("Shaked it.");
            input = input.Remove(input.IndexOf(pattern), pattern.Length);
            input = input.Remove(input.LastIndexOf(pattern), pattern.Length);
            pattern = pattern.Remove(pattern.Length / 2, 1);
        }

        Console.WriteLine("No shake.");
        Console.WriteLine(input);
    }
}