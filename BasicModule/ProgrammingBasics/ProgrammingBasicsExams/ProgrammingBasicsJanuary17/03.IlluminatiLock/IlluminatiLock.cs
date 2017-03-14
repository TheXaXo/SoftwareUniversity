using System;

class IlluminatiLock
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string('.', n) + new string('#', n) + new string('.', n));

        //Second Part
        Console.WriteLine(new string('.', n - 2) + "###" + new string('.', n - 2) + "###" + new string('.', n - 2));

        //Third Part
        for (int i = 1; i <= (n + 1 - 4) / 2; i++)
        {
            Console.WriteLine(new string('.', n - 4 - 2 * i + 2) + "##" + new string('.', 2 * i) + "#" + new string('.', n - 2) + "#" + new string('.', 2 * i) + "##" + new string('.', n - 4 - 2 * i + 2));
        }

        //Fourt Part
        for (int i = 1; i <= (n + 1 - 4) / 2; i++)
        {
            Console.WriteLine(new string('.', 2 * i - 1) + "##" + new string('.', n - 3 - 2 * i + 2) + "#" + new string('.', n - 2) + "#" + new string('.', n - 3 - 2 * i + 2) + "##" + new string('.', 2 * i - 1));
        }

        //Fifth Part
        Console.WriteLine(new string('.', n - 2) + "###" + new string('.', n - 2) + "###" + new string('.', n - 2));

        //Sixth Part
        Console.WriteLine(new string('.', n) + new string('#', n) + new string('.', n));
    }
}