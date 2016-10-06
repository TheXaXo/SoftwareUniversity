using System;
using System.Collections.Generic;
using System.Linq;

class FoldAndSum
{
    static void Main(string[] args)
    {
        int[] input = Console.ReadLine().Split(' ')
            .Select(int.Parse)
            .ToArray();

        int[] startPart = input.Take(input.Length / 4).Reverse().ToArray();
        int[] midPart = input.Skip(input.Length / 4).Take(input.Length / 2).ToArray();
        int[] endPart = input.Skip(input.Length / 2 + input.Length / 4).Reverse().ToArray();

        int[] topPart = startPart.Concat(endPart).ToArray();
        input = topPart.Zip(midPart, (x, y) => x + y).ToArray();

        Console.WriteLine(string.Join(" ", input));
    }
}