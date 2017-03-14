using System;

class SumDigits
{
    static void Main(string[] args)
    {
        //Method 1
        int n = int.Parse(Console.ReadLine());
        int sum = 0;

        while (n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        Console.WriteLine(sum);

        //Method 2
        //int n = int.Parse(Console.ReadLine());
        //int sum = 0;
        //string nToString = n.ToString();
        //int number = 0;
        
        //for (int i = 0; i < nToString.Length; i++)
        //{
        //    number = (int)Char.GetNumericValue(nToString[i]);
        //    sum += number;
        //}
        //Console.WriteLine(sum);
    }
}