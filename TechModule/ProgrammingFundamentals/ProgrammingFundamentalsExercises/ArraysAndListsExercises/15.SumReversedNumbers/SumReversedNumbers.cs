using System;
using System.Collections.Generic;

class SumReversedNumbers
{
    static void Main(string[] args)
    {
        List<int> input = GetListFromInput(Console.ReadLine());
        List<int> inputElementsReversed = ReverseElements(input);
        int sumOfElements = GetSumOfElements(inputElementsReversed);

        Console.WriteLine(sumOfElements);
    }

    static List<int> GetListFromInput(string input)
    {
        string[] inputArray = input.Split(' ');
        List<int> listFromInput = new List<int>();

        for (int i = 0; i < inputArray.Length; i++)
        {
            listFromInput.Add(int.Parse(inputArray[i]));
        }

        return listFromInput;
    }

    static List<int> ReverseElements(List<int> input)
    {
        List<int> reversed = new List<int>();
        int currentElement = 0;
        string elementReversed = null;

        for (int i = 0; i < input.Count; i++)
        {
            currentElement = input[i];
            for (int j = currentElement.ToString().Length - 1; j >= 0; j--)
            {
                elementReversed += currentElement.ToString()[j];
            }

            reversed.Add(int.Parse(elementReversed));
            elementReversed = null;
        }

        return reversed;
    }

    static int GetSumOfElements(List<int> list)
    {
        int sum = 0;

        for (int i = 0; i < list.Count; i++)
        {
            sum += list[i];
        }

        return sum;
    }
}