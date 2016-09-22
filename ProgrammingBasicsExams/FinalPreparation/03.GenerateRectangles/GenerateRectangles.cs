using System;

class GenerateRectangles
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int m = int.Parse(Console.ReadLine());
        int area = 0;
        int count = 0;

        for (int left = -n; left <= n; left++)
        {
            for (int right = left + 1; right <= n; right++)
            {
                for (int top = -n; top <= n; top++)
                {
                    for (int bottom = top + 1; bottom <= n; bottom++)
                    {
                        area = (right - left) * (bottom - top);
                        if (area >= m)
                        {
                            Console.WriteLine("({0}, {1}) ({2}, {3}) -> {4}", left, top, right, bottom, area);
                            count++;
                        }                       
                    }
                }
            }
        }
        if (count == 0)
        {
            Console.WriteLine("No");
        }
    }
}