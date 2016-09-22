using System;

class TeleportPoints
{
    static void Main(string[] args)
    {
        string[] splitA = (Console.ReadLine()).Split(' ');
        string[] splitB = (Console.ReadLine()).Split(' ');
        string[] splitC = (Console.ReadLine()).Split(' ');
        string[] splitD = (Console.ReadLine()).Split(' ');
        double radius = double.Parse(Console.ReadLine());
        double step = double.Parse(Console.ReadLine());

        double aX = double.Parse(splitA[0]);
        double aY = double.Parse(splitA[1]);
        double bX = double.Parse(splitB[0]);
        double bY = double.Parse(splitB[1]);
        double cX = double.Parse(splitC[0]);
        double cY = double.Parse(splitC[1]);
        double dX = double.Parse(splitD[0]);
        double dY = double.Parse(splitD[1]);

        int pointsCount = 0;

        for (double pointY = aY; pointY <= dY; pointY += step)
        {
            for (double pointX = aX; pointX <= bX; pointX += step)
            {
                if (Math.Pow(pointX, 2) + Math.Pow(pointY, 2) <= Math.Pow(radius, 2) && pointX > aX && pointX < bX && pointY > aY && pointY < dY)
                {
                    pointsCount++;
                }
            }
        }
        Console.WriteLine(pointsCount);
    }
}