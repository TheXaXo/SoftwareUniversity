using System;

class PoolPipes
{
    static void Main(string[] args)
    {
        int poolVolume = int.Parse(Console.ReadLine());
        int pipeOne = int.Parse(Console.ReadLine());
        int pipeTwo = int.Parse(Console.ReadLine());
        double hours = double.Parse(Console.ReadLine());

        double pipesCombined = (pipeOne + pipeTwo) * hours;

        if (pipesCombined > poolVolume)
        {
            Console.WriteLine("For {0} hours the pool overflows with {1} liters.", hours, pipesCombined - poolVolume);
        }
        else
        {
            Console.WriteLine("The pool is {0}% full. Pipe 1: {1}%. Pipe 2: {2}%.", Math.Floor(pipesCombined / poolVolume * 100), Math.Floor(pipeOne * hours / pipesCombined * 100), Math.Floor(pipeTwo * hours / pipesCombined * 100));
        }
    }
}