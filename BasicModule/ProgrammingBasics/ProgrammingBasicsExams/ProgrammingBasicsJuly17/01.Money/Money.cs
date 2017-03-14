using System;

class Money
{
    static void Main(string[] args)
    {
        int bitcoin = int.Parse(Console.ReadLine());
        double chinease = double.Parse(Console.ReadLine());
        double percent = double.Parse(Console.ReadLine());

        Console.WriteLine(((bitcoin * 1168) + (chinease * 0.15 * 1.76)) / 1.95 * ((100 - percent) / 100));
    }
}