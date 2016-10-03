using System;

class ReverseArrayOfStrings
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        string[] array = input.Split(' ');
        string[] arrayReversed = new string[array.Length];

        int count = 0;

        for (int i = array.Length - 1; i >= 0; i--)
        {
            arrayReversed[count] = array[i];
            count++;
        }

        Console.WriteLine(string.Join(" ", arrayReversed));
    }
}