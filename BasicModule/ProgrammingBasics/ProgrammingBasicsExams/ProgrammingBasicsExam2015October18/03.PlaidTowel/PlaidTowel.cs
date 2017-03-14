using System;

class PlaidTowel
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        char background = char.Parse(Console.ReadLine());
        char rhombus = char.Parse(Console.ReadLine());

        //First Part
        Console.WriteLine(new string(background, n) + rhombus + new string(background, n * 2 - 1) + rhombus + new string(background, n));

        //Second Part
        for (int i = 1; i <= n; i++)
        {
            if (i == n)
            {
                Console.WriteLine(rhombus + new string(background, n * 2 - 1) + rhombus + new string(background, n * 2 - 1) + rhombus);
                break;
            }
            Console.WriteLine(new string(background, n - i) + rhombus + new string(background, 2 * i - 1) + rhombus + new string(background, 2 * n - 1 - 2 * i) + rhombus + new string(background, 2 * i - 1) + rhombus + new string(background, n - i));
        }

        //Third Part
        for (int i = 1; i <= n - 1; i++)
        {
            Console.WriteLine(new string(background, i) + rhombus + new string(background, 2 * n - 1 - 2 * i) + rhombus + new string(background, 2 * i - 1) + rhombus + new string(background, 2 * n - 1 - 2 * i) + rhombus + new string(background, i));
        }

        //Fourth Part
        Console.WriteLine(new string(background, n) + rhombus + new string(background, n * 2 - 1) + rhombus + new string(background, n));

        //Fifth Part
        for (int i = 1; i <= n; i++)
        {
            if (i == n)
            {
                Console.WriteLine(rhombus + new string(background, n * 2 - 1) + rhombus + new string(background, n * 2 - 1) + rhombus);
                break;
            }
            Console.WriteLine(new string(background, n - i) + rhombus + new string(background, 2 * i - 1) + rhombus + new string(background, 2 * n - 1 - 2 * i) + rhombus + new string(background, 2 * i - 1) + rhombus + new string(background, n - i));
        }

        //Sixth Part
        for (int i = 1; i <= n - 1; i++)
        {
            Console.WriteLine(new string(background, i) + rhombus + new string(background, 2 * n - 1 - 2 * i) + rhombus + new string(background, 2 * i - 1) + rhombus + new string(background, 2 * n - 1 - 2 * i) + rhombus + new string(background, i));
        }

        //Seventh Part
        Console.WriteLine(new string(background, n) + rhombus + new string(background, n * 2 - 1) + rhombus + new string(background, n));
    }
}