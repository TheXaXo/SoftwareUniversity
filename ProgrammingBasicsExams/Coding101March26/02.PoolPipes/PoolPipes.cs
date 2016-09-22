using System;

class PoolPipes
{
    static void Main(string[] args)
    {
        int v = int.Parse(Console.ReadLine());
        int p1 = int.Parse(Console.ReadLine());
        int p2 = int.Parse(Console.ReadLine());
        double h = double.Parse(Console.ReadLine());

        if (p1 * h + p2 * h <= v)
        {
            Console.WriteLine("The pool is {0}% full. Pipe 1: {1}%. Pipe 2: {2}%.", Math.Floor((p1 * h + p2 * h) / v * 100), Math.Floor((p1 * h) / (p1 * h + p2 * h) * 100), Math.Floor((p2 * h) / (p1 * h + p2 * h) * 100));
        }
        else
        {
            Console.WriteLine("For {0} hours the pool overflows with {1} liters.", h, (p1 * h + p2 * h) - v);
        }
    }
}