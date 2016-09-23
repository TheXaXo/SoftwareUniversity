using System;

class ReversedChars
{
    static void Main(string[] args)
    {
        char first = char.Parse(Console.ReadLine());
        char second = char.Parse(Console.ReadLine());
        char third = char.Parse(Console.ReadLine());

        Console.WriteLine("{0}{1}{2}", third, second,first);
    }
}