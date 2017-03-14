using System;

class Diamond
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        if (n % 2 == 0)
        {
            //First Part
            Console.WriteLine(new string('-', n / 2 - 1) + "**" + new string('-', n / 2 - 1));

            //Second Part
            for (int i = 1; i <= n / 2 - 1; i++)
            {
                Console.WriteLine(new string('-', n / 2 - i - 1) + "*" + new string('-', 2 * i) + "*" + new string('-', n / 2 - i - 1));
            }

            //Third Part
            for (int i = 1; i <= n / 2 - 2; i++)
            {
                Console.WriteLine(new string('-', i) + "*" + new string('-', n - 4 - 2 * i + 2) + "*" + new string('-', i));
            }

            if (n > 2)
            {
                //Fourt Part
                Console.WriteLine(new string('-', n / 2 - 1) + "**" + new string('-', n / 2 - 1));
            }
        }
        else
        {
            //First Part
            Console.WriteLine(new string('-', n / 2) + "*" + new string('-', n / 2));

            //Second Part
            for (int i = 1; i <= n / 2; i++)
            {
                Console.WriteLine(new string('-', n / 2 - i) + "*" + new string('-', 2 * i - 1) + "*" + new string('-', n / 2 - i));
            }

            //Third Part
            for (int i = 1; i <= n / 2 - 1; i++)
            {
                Console.WriteLine(new string('-', i) + "*" + new string('-', n - 4 - 2 * i + 2) + "*" + new string('-', i));
            }

            if (n > 2)
            {
                //Fourth Part
                Console.WriteLine(new string('-', n / 2) + "*" + new string('-', n / 2));
            }
        }
    }
}