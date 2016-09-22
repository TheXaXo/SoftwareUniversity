using System;

class Bricks
{
    static void Main(string[] args)
    {
        int bricks = int.Parse(Console.ReadLine());
        int workers = int.Parse(Console.ReadLine());
        int volume = int.Parse(Console.ReadLine());

        int bricksPerCourse = workers * volume;
        int courses = bricks / bricksPerCourse;
        int leftover = bricks % bricksPerCourse;

        if (leftover > 0)
        {
            courses++;
        }

        Console.WriteLine(courses);
    }
}