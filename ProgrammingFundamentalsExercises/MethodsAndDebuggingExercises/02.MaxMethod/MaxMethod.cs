using System;

class MaxMethod
{
    static void Main(string[] args)
    {
        int firstNumber = int.Parse(Console.ReadLine());
        int secondNumber = int.Parse(Console.ReadLine());
        int thirdNumber = int.Parse(Console.ReadLine());

        int maxNumber = GetMaxInt(firstNumber, secondNumber, thirdNumber);
        Console.WriteLine(maxNumber);
    }
    static int GetMaxInt(int a, int b, int c)
    {
        int maxNumber = a;
        if (b > maxNumber)
        {
            maxNumber = b;
        }
        if (c > maxNumber)
        {
            maxNumber = c;
        }
        return maxNumber;
    }
}