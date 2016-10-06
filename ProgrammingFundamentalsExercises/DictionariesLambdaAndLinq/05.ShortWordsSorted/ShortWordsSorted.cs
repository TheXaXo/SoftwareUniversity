using System;
using System.Collections.Generic;
using System.Linq;

class ShortWordsSorted
{
    static void Main(string[] args)
    {
        char[] separators = { '.', ',', ':', ';', '(', ')', '[', ']', '\"', '\'', '\\', '/', '!', '?', ' ' };
        string[] inputConverted = Console.ReadLine().Split(separators)
            .Where(word => word.Length < 5 && word.Length > 0)
            .OrderBy(word => word)
            .Select(word => word.ToLower())
            .Distinct()
            .ToArray();

        Console.WriteLine(string.Join(", ", inputConverted));
    }
}