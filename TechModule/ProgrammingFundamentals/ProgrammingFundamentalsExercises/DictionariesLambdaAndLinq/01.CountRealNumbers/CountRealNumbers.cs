using System;
using System.Collections.Generic;

class CountRealNumbers
{
    static void Main(string[] args)
    {
        List<double> input = GetListFromInput(Console.ReadLine());
        SortedDictionary<double, int> dictionary = new SortedDictionary<double, int>();

        foreach (double number in input)
        {
            if (!dictionary.ContainsKey(number))
            {
                dictionary[number] = 1;
            }
            else
            {
                dictionary[number]++;
            }
        }

        foreach (KeyValuePair<double, int> pair in dictionary)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value}");
        }
    }

    static List<double> GetListFromInput(string input)
    {
        string[] split = input.Split(' ');
        List<double> list = new List<double>();

        for (int i = 0; i < split.Length; i++)
        {
            list.Add(double.Parse(split[i]));
        }

        return list;
    }
}