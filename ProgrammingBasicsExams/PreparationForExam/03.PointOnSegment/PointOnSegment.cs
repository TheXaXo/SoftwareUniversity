using System;

class PointOnSegment
{
    static void Main(string[] args)
    {
        int m = int.Parse(Console.ReadLine());
        int n = int.Parse(Console.ReadLine());

        int first = Math.Min(m, n);
        int second = Math.Max(m, n);
        int point = int.Parse(Console.ReadLine());

          if (point < first)
        {
            Console.WriteLine("out");
            Console.WriteLine(first - point);
        }
        else if (point > second)
        {
            Console.WriteLine("out");
            Console.WriteLine(point - second);
        }
        else
        {
            Console.WriteLine("in");
            Console.WriteLine(Math.Min(Math.Abs(point - first), Math.Abs(point - second)));
        }
    }
}