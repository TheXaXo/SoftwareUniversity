using System;
using System.Collections.Generic;

class SortNumbers
{
    static void Main(string[] args)
    {
        List<decimal> listFromInput = GetDecimalListFromString(Console.ReadLine());
        listFromInput.Sort();

        Console.WriteLine(string.Join(" <= ", listFromInput));
    }

    static List<decimal> GetDecimalListFromString(string input)
    {
        string[] split = input.Split(' ');
        List<decimal> listFormInput = new List<decimal>();

        for (int i = 0; i < split.Length; i++)
        {
            listFormInput.Add(decimal.Parse(split[i].ToString()));
        }

        return listFormInput;
    }
}