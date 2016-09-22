using System;

class PetarsGame
{
    static void Main(string[] args)
    {
        ulong startNumber = ulong.Parse(Console.ReadLine());
        ulong endNumber = ulong.Parse(Console.ReadLine());
        string replacement = Console.ReadLine();

        decimal sum = 0;
        int lastDigit = 0;
        int firstDigit = 0;
        string answerSum = null;

        for (ulong i = startNumber; i < endNumber; i++)
        {
            if (i % 5 == 0)
            {
                sum += i;
            }
            else
            {
                sum += i % 5;
            }
        }

        answerSum = sum.ToString();
        if (sum % 2 != 0)
        {
            lastDigit = int.Parse(answerSum[answerSum.Length - 1].ToString());
            answerSum = answerSum.Replace(lastDigit.ToString(), replacement);
        }
        else
        {
            firstDigit = int.Parse(answerSum[0].ToString());
            answerSum = answerSum.Replace(firstDigit.ToString(), replacement);
        }
        Console.WriteLine(answerSum);
    }
}