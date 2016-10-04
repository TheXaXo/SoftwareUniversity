using System;
using System.Collections.Generic;

class SplitByWordCasting
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        char[] separators = { ',', ';', ':', '.', '!', '(', ')', '"', '\'', '\\', '/', '[', ']', ' ' };

        string[] inputSplit = input.Split(separators);
        List<string> lowerCase = new List<string>();
        List<string> upperCase = new List<string>();
        List<string> mixedCase = new List<string>();
        string currentElement = null;

        bool containsLowerCase = false;
        bool containsUpperCase = false;

        for (int i = 0; i < inputSplit.Length; i++)
        {
            currentElement = inputSplit[i];

            for (int j = 0; j < currentElement.Length; j++)
            {
                if (currentElement[j] >= 65 && currentElement[j] <= 90)
                {
                    containsUpperCase = true;
                }
                else if (currentElement[j] >= 97 && currentElement[j] <= 122)
                {
                    containsLowerCase = true;
                }
                else
                {
                    containsUpperCase = true;
                    containsLowerCase = true;
                }

                if (j == currentElement.Length - 1)
                {
                    if (containsLowerCase && !containsUpperCase)
                    {
                        lowerCase.Add(currentElement);
                    }
                    else if (containsUpperCase && !containsLowerCase)
                    {
                        upperCase.Add(currentElement);
                    }
                    else
                    {
                        mixedCase.Add(currentElement);
                    }
                }
            }

            containsLowerCase = false;
            containsUpperCase = false;
        }

        Console.WriteLine("Lower-case: " + string.Join(", ", lowerCase));
        Console.WriteLine("Mixed-case: " + string.Join(", ", mixedCase));
        Console.WriteLine("Upper-case: " + string.Join(", ", upperCase));
    }
}