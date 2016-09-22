using System;

class ChristmasTree
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        for (int i = 1; i <= n + 1; i++)
        {
            Console.WriteLine(new string(' ', n - i + 1) + new string('*', i - 1) + " | " + new string('*', i - 1));
        }
    }
}