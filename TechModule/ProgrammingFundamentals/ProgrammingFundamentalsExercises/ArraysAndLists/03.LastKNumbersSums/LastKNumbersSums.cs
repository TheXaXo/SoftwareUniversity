using System;

class LastKNumbersSums
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int k = int.Parse(Console.ReadLine());

        long[] arrayOfIntegers = new long[n];

        for (int i = 0; i < n; i++)
        {
            if (i == 0)
            {
                arrayOfIntegers[i] = 1;
                continue;
            }
            
            if (k <= i)
            {
                for (int j = i; j >= i - k; j--)
                {
                    arrayOfIntegers[i] += arrayOfIntegers[j]; 
                }
            }
            else
            {
                for (int j = i; j >= 0; j--)
                {
                    arrayOfIntegers[i] += arrayOfIntegers[j];
                }
            }
        }

        Console.WriteLine(string.Join(" ", arrayOfIntegers));
    }
}