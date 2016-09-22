using System;

class SumSeconds
{
    static void Main(string[] args)
    {
        int n1 = int.Parse(Console.ReadLine());
        int n2 = int.Parse(Console.ReadLine());
        int n3 = int.Parse(Console.ReadLine());
        int timesCombined = n1 + n2 + n3;

        if (timesCombined < 60)
        {
            Console.WriteLine("0:{0}", timesCombined.ToString().PadLeft(2, '0'));
        }
        else if (timesCombined < 120)
        {
            Console.WriteLine("1:{0}", (timesCombined - 60).ToString().PadLeft(2, '0'));
        }
        else
        {
            Console.WriteLine("2:{0}", (timesCombined - 120).ToString().PadLeft(2, '0'));
        }
    }
}