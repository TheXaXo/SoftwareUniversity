using System;

class StopSign
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string('.', n + 1) + new string('_', 2 * n + 1) + new string('.', n + 1));

        //Second Part
        for (int i = 1; i <= n; i++)
        {
            Console.WriteLine(new string('.', n + 1 - i) + "//" + new string('_', 2 * n - 1 + i * 2 - 2) + "\\\\" + new string('.', n + 1 - i));
        }

        //Third Part
        Console.WriteLine("//" + new string('_', n * 2 - 3) + "STOP!" + new string('_', n * 2 - 3) + "\\\\");

        //Fourth Part
        for (int i = 1; i <= n; i++)
        {
            Console.WriteLine(new string('.', i - 1) + "\\\\" + new string('_', n * 4 - 1 - 2 * i + 2) + "//" + new string('.', i - 1));
        }
    }
}