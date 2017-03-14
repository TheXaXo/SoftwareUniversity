using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class ValidUsername
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        string pattern = @"\b[A-Za-z][\w\d_]+\b";
        MatchCollection usernames = Regex.Matches(input, pattern);
        List<string> validUsernames = new List<string>();

        foreach (Match username in usernames)
        {
            if (username.Length > 2 && username.Length < 26)
            {
                validUsernames.Add(username.ToString());
            }
        }

        int biggestLength = 0;
        string userNameOneFromBiggest = null;
        string userNameTwoFromBiggest = null;

        for (int i = 0; i < validUsernames.Count - 1; i++)
        {
            string userNameOne = validUsernames[i];
            string userNameTwo = validUsernames[i + 1];
            int lengthSum = userNameOne.Length + userNameTwo.Length;

            if (lengthSum > biggestLength)
            {
                biggestLength = lengthSum;
                userNameOneFromBiggest = userNameOne;
                userNameTwoFromBiggest = userNameTwo;
            }
        }

        Console.WriteLine(userNameOneFromBiggest);
        Console.WriteLine(userNameTwoFromBiggest);
    }
}