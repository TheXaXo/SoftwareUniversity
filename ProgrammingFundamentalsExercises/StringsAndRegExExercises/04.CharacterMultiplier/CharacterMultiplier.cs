using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class CharacterMultiplier
{
    static void Main(string[] args)
    {
        string[] split = Console.ReadLine().Split();
        string stringOne = split[0];
        string stringTwo = split[1];
        int result = 0;

        for (int i = 0; i < (Math.Min(stringOne.Length, stringTwo.Length)); i++)
        {
            result += stringOne[i] * stringTwo[i];
        }

        if (stringOne.Length > stringTwo.Length)
        {
            for (int i = stringTwo.Length; i < stringOne.Length; i++)
            {
                result += stringOne[i];
            }
        }
        else
        {
            for (int i = stringOne.Length; i < stringTwo.Length; i++)
            {
                result += stringTwo[i];
            }
        }

        Console.WriteLine(result);
    }
}