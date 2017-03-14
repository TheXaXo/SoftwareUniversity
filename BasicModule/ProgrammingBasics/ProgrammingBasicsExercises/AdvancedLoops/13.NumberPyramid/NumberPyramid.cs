using System;

class NumberPyramid
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int current = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                if (current > n)
                {
                    return;
                }
                Console.Write("{0} ", current);
                current++;                
            }
            Console.WriteLine();            
        }
    }
}