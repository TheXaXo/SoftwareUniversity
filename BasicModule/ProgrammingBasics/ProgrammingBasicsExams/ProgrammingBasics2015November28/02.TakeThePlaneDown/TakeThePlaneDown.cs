using System;

class Program
{
    static void Main(string[] args)
    {
        int headquartersX = int.Parse(Console.ReadLine());
        int headquartersY = int.Parse(Console.ReadLine());
        int distanceToBorders = int.Parse(Console.ReadLine());
        int planesApproaching = int.Parse(Console.ReadLine());

        for (int i = 1; i <= planesApproaching; i++)
        {
            int x = int.Parse(Console.ReadLine());
            int y = int.Parse(Console.ReadLine());

            if (x >= headquartersX - distanceToBorders && x <= headquartersX + distanceToBorders && y >= headquartersY - distanceToBorders && y <= headquartersY + distanceToBorders)
            {
                Console.WriteLine("You destroyed a plane at [{0},{1}]", x, y);
            }            
        }
    }
}