using System;

class SpecialNumbers
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int numberSum = 0;

        for (int i = 1; i <= n; i++)
        {
            int numberLength = i.ToString().Length;
            for (int j = 0; j < numberLength; j++)
            {
                numberSum += int.Parse(i.ToString()[j].ToString());
            }
            if (numberSum == 5 || numberSum == 7 || numberSum == 11)
            {
                Console.WriteLine("{0} -> True", i);
            }
            else
            {
                Console.WriteLine("{0} -> False", i);
            }
            numberSum = 0;
        }
    }
}