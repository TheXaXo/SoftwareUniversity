using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class LadyBugs
{
    static void Main(string[] args)
    {
        int fieldSize = int.Parse(Console.ReadLine());
        int[] field = new int[fieldSize];
        int[] ladyBugIndexes = Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToArray();

        foreach (int index in ladyBugIndexes)
        {
            if (index >= 0 && index < field.Length)
            {
                field[index] = 1;
            }
        }

        string command = Console.ReadLine();

        while (command != "end")
        {
            string[] split = command.Split();
            int index = int.Parse(split[0]);
            string direction = split[1];
            int flyLength = int.Parse(split[2]);

            bool hasBeenCompleted = false;

            if (index >= 0 && index < field.Length &&
                field[index] == 1)
            {
                field[index] = 0;

                if (direction == "left")
                {
                    int currentIndex = index - flyLength;
                    while (!hasBeenCompleted)
                    {
                        if (currentIndex < 0 || currentIndex >= field.Length)
                        {
                            hasBeenCompleted = true;
                            continue;
                        }

                        if (field[currentIndex] == 1)
                        {
                            currentIndex-=flyLength;
                            continue;
                        }

                        field[currentIndex] = 1;
                        hasBeenCompleted = true;
                    }
                }
                else if (direction == "right")
                {
                    int currentIndex = index + flyLength;
                    while (!hasBeenCompleted)
                    {
                        if (currentIndex < 0 || currentIndex >= field.Length)
                        {
                            hasBeenCompleted = true;
                            continue;
                        }

                        if (field[currentIndex] == 1)
                        {
                            currentIndex+=flyLength;
                            continue;
                        }

                        field[currentIndex] = 1;
                        hasBeenCompleted = true;
                    }
                }
            }
            command = Console.ReadLine();
        }

        Console.WriteLine(string.Join(" ", field));
    }
}