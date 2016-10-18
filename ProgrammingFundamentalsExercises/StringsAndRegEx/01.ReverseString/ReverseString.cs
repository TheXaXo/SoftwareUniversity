using System;
using System.Collections.Generic;
using System.Linq;

class ReverseString
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        Console.WriteLine(string.Join("", input.Reverse()));
    }
}