using System;
using System.Collections.Generic;

class SumAdjacentEqualNumbers
{
    static void Main(string[] args)
    {
        List<decimal> inputList = GetDecimalList(Console.ReadLine());
        List<decimal> list = new List<decimal>();
        bool hasBeenAdded = false;

        while (ContainsSummableElements(inputList))
        {
            for (int i = 0; i < inputList.Count; i++)
            {
                if (i != inputList.Count - 1 && inputList[i] == inputList[i + 1] && !hasBeenAdded)
                {
                    list.Add(inputList[i] + inputList[i + 1]);
                    i++;
                    hasBeenAdded = true;
                    continue;
                }
                list.Add(inputList[i]);
            }
            inputList = list;
            list = new List<decimal>();
            hasBeenAdded = false;
        }

        Console.WriteLine(string.Join(" ", inputList));
    }

    static List<decimal> GetDecimalList(string input)
    {
        string[] arrayAsString = input.Split(' ');
        List<decimal> decimalList = new List<decimal>();

        for (int i = 0; i < arrayAsString.Length; i++)
        {
            decimalList.Add(decimal.Parse(arrayAsString[i]));
        }
        return decimalList;
    }

    static bool ContainsSummableElements(List<decimal> list)
    {
        for (int i = 0; i < list.Count - 1; i++)
        {
            if (list[i] == list[i + 1])
            {
                return true;
            }
        }
        return false;
    }
}