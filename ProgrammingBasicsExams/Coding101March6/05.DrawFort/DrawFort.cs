using System;

class DrawFort
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine("/" + new string('^', n / 2) + "\\" + new string('_', 2 * n - (4 + 2 * (n / 2))) + "/" + new string('^', n / 2) + "\\");

        //Second Part
        {
            for (int i = 1; i <= n - 2; i++)
            {               
                if (i == n - 2)
                {
                    Console.WriteLine("|" + new string(' ', n / 2 + 1) + new string('_', 2 * n - (4 + 2 * (n / 2))) + new string(' ', n / 2 + 1) + "|");
                    break;
                }
                Console.WriteLine("|" + new string(' ', 2 * n - 2) + "|");
            }
        }

        //Third Part
        Console.WriteLine("\\" + new string('_', n / 2) + "/" + new string(' ', 2 * n - (4 + 2 * (n / 2))) + "\\" + new string('_', n / 2) + "/");
    }
}