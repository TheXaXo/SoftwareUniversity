using System;

class EncodedAnswers
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        string answer = null;
        string result = null;

        for (int i = 1; i <= n; i++)
        {
            uint number = uint.Parse(Console.ReadLine());
            if (number % 4 == 0)
            {
                answer = "a";
                a++;
            }
            else if (number % 4 == 1)
            {
                answer = "b";
                b++;
            }
            else if (number % 4 == 2)
            {
                answer = "c";
                c++;
            }
            else if (number % 4 == 3)
            {
                answer = "d";
                d++;
            }
            result += answer + " ";
        }
        Console.WriteLine(result);
        Console.WriteLine("Answer A: {0}", a);
        Console.WriteLine("Answer B: {0}", b);
        Console.WriteLine("Answer C: {0}", c);
        Console.WriteLine("Answer D: {0}", d);
    }
}