using System;

class RefactorSpecialNumbers
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int sum = 0;
        int currentNumber = 0;
        bool isSpecial = false;
        for (int i = 1; i <= n; i++)
        {
            currentNumber = i;
            while (currentNumber > 0)
            {
                sum += currentNumber % 10;
                currentNumber /= 10;
            }
            if (sum == 5 || sum == 7 || sum == 11)
            {
                isSpecial = true;
            }

            if (isSpecial == true)
            {
                Console.WriteLine("{0} -> True", i);
            }
            else
            {
                Console.WriteLine("{0} -> False", i);
            }
            sum = 0;
            isSpecial = false;
        }
    }
}