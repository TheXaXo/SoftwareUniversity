using System;
using System.Linq;

class RectanglePosition
{
    static void Main(string[] args)
    {
        Rectangle rectangleOne = ReadRectangle();
        Rectangle rectangleTwo = ReadRectangle();

        bool rectangleOneIsInside = rectangleOne.IsInside(rectangleTwo);

        if (rectangleOneIsInside)
        {
            Console.WriteLine("Inside");
        }
        else
        {
            Console.WriteLine("Not inside");
        }
    }

    static Rectangle ReadRectangle()
    {
        Rectangle rectangle = new Rectangle();
        int[] split = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        rectangle.Left = split[0];
        rectangle.Top = split[1];
        rectangle.Width = split[2];
        rectangle.Height = split[3];

        return rectangle;
    }
}

class Rectangle
{
    public int Left { get; set; }
    public int Top { get; set; }
    public int Width { get; set; }
    public int Height { get; set; }

    public int Right
    {
        get
        {
            return Left + Width;
        }
    }

    public int Bottom
    {
        get
        {
            return Top + Height;
        }
    }

    public bool IsInside(Rectangle rectangleTwo)
    {
        if (rectangleTwo.Left <= Left && rectangleTwo.Right >= Right
            && rectangleTwo.Top <= Top && rectangleTwo.Bottom >= Bottom)
        {
            return true;
        }
        return false;
    }
}