using System;
using System.Collections.Generic;

class AppendLists
{
    static void Main(string[] args)
    {
        string[] split = Console.ReadLine().Split('|');
        List<int> result = new List<int>();

        for (int i = split.Length - 1; i >= 0; i--)
        {
            string[] element = split[i].Split(' ');
            for (int j = 0; j < element.Length; j++)
            {
                if (element[j] != "")
                {
                    result.Add(int.Parse(element[j]));
                }
            }
        }

        foreach (int element in result)
        {
            Console.WriteLine(element);
        }
    }
}