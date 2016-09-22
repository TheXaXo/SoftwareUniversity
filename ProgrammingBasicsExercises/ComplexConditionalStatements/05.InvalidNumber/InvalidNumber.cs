using System;

class InvalidNumber
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        if (!(n >= 100 && n <= 200 || n == 0))
        {
            Console.WriteLine("invalid");
        }
    }
}