using System;

class Numbers
{
    static void Main(string[] args)
    {
        int number = int.Parse(Console.ReadLine());

        int firstDigit = int.Parse(number.ToString()[0].ToString());
        int secondDigit = int.Parse(number.ToString()[1].ToString());
        int lastDigit = int.Parse(number.ToString()[2].ToString());
        string answer = null;
        int count = 0;
        int printed = 0;

        int rows = firstDigit + secondDigit;
        int columns = firstDigit + lastDigit;

        while (count < rows * columns)
        {
            if (number % 5 == 0)
            {
                number -= firstDigit;
                answer += number + " ";
                count++;
            }
            else if (number % 3 == 0)
            {
                number -= secondDigit;
                answer += number + " ";
                count++;
            }
            else if (number % 5 != 0 && number % 3 != 0)
            {
                number += lastDigit;
                answer += number + " ";
                count++;
            }
        }
        string[] split = answer.Split(' ');
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {

                Console.Write(split[printed] + " ");
                printed++;
            }
            Console.WriteLine();
        }
    }
}