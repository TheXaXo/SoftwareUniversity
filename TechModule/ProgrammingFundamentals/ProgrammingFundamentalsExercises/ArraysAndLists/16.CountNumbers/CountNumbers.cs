using System;
using System.Collections.Generic;

class CountNumbers
{
    static void Main(string[] args)
    {
        List<int> list = GetIntListFromString(Console.ReadLine());
        list.Sort();
        int count = 0;
        List<int> alreadyPrintedNumbers = new List<int>();

        for (int i = 0; i < list.Count; i++)
        {
            if (alreadyPrintedNumbers.Contains(list[i]))
            {
                continue;
            }

            for (int j = 0; j < list.Count; j++)
            {
                if (list[i] == list[j])
                {
                    alreadyPrintedNumbers.Add(list[i]);
                    count++;
                }
            }

            Console.WriteLine($"{list[i]} -> {count}");
            count = 0;
        }
    }

    static List<int> GetIntListFromString(string input)
    {
        string[] split = input.Split(' ');
        List<int> listFormInput = new List<int>();

        for (int i = 0; i < split.Length; i++)
        {
            listFormInput.Add(int.Parse(split[i].ToString()));
        }

        return listFormInput;
    }
}