using System;

class RecrangleOf10x10Stars
{
    static void Main(string[] args)
    {
        for (int i = 1; i <= 10; i++)
        {
            Console.WriteLine(new string('*', 10));
        }
    }
}