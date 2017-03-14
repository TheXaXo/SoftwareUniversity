using System;

class LightTheTorches
{
    static void Main(string[] args)
    {
        int rooms = int.Parse(Console.ReadLine());
        string lights = Console.ReadLine();
        string command = Console.ReadLine();
        string basement = null;
        int currentPosition = 0;
        int darkRooms = 0;
        int lastPosition = 0;

        while (lights.Length < rooms)
        {
            lights += lights;
        }

        basement += lights;
        if (basement.Length > rooms)
        {
            basement = basement.Remove(rooms);
        }

        currentPosition = basement.Length / 2;

        while (command != "END")
        {
            string[] split = command.Split(' ');
            string direction = split[0];
            int passedRooms = int.Parse(split[1]);
            lastPosition = currentPosition;

            if (direction == "LEFT")
            {
                if (currentPosition - passedRooms - 1 >= 0)
                {
                    currentPosition = currentPosition - passedRooms - 1;
                }
                else
                {
                    currentPosition = 0;
                }

                if (basement[currentPosition] == 'L' && currentPosition != lastPosition)
                {
                    basement = basement.Remove(currentPosition, 1).Insert(currentPosition, "D");
                }
                else if (basement[currentPosition] == 'D' && currentPosition != lastPosition)
                {
                    basement = basement.Remove(currentPosition, 1).Insert(currentPosition, "L");
                }
            }
            else
            {
                if (currentPosition + passedRooms + 1 <= basement.Length - 1)
                {
                    currentPosition = currentPosition + passedRooms + 1;
                }
                else
                {
                    currentPosition = basement.Length - 1;
                }

                if (basement[currentPosition] == 'L' && currentPosition != lastPosition)
                {
                    basement = basement.Remove(currentPosition, 1).Insert(currentPosition, "D");
                }
                else if (basement[currentPosition] == 'D' && currentPosition != lastPosition)
                {
                    basement = basement.Remove(currentPosition, 1).Insert(currentPosition, "L");
                }
            }
            command = Console.ReadLine();
        }
        for (int i = 0; i < basement.Length; i++)
        {
            if (basement[i] == 'D')
            {
                darkRooms++;
            }
        }
        Console.WriteLine('D' * darkRooms);
    }
}