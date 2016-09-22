using System;

class ChessBoardGame
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        string command = Console.ReadLine();
        string chessboard = null;
        int count = 0;
        int blackPoints = 0;
        int whitePoints = 0;
        string winningTeam = null;

        for (int i = 0; i < command.Length; i++)
        {
            if ((command[i] >= 65 && command[i] <= 90) || (command[i] >= 97 && command[i] <= 122) || (command[i] >= 48 && command[i] <= 57))
            {
                chessboard += (int)command[i] + " ";
                count++;
            }
            else
            {
                chessboard += 0 + " ";
                count++;
            }
        }

        while (n * n > count)
        {
            chessboard += "0" + " ";
            count++;
        }

        while (n * n < count)
        {
            count--;
        }

        string[] split = chessboard.Split(' ');

        for (int i = 0; i < count; i++)
        {
            if (i % 2 == 0)
            {
                if (int.Parse(split[i]) >= 65 && int.Parse(split[i]) <= 90)
                {
                    whitePoints += int.Parse(split[i]);
                }
                else
                {
                    blackPoints += int.Parse(split[i]);
                }
            }
            else
            {
                if (int.Parse(split[i]) >= 65 && int.Parse(split[i]) <= 90)
                {
                    blackPoints += int.Parse(split[i]);
                }
                else
                {
                    whitePoints += int.Parse(split[i]);
                }
            }
        }

        if (whitePoints > blackPoints)
        {
            winningTeam = "white";
        }
        else
        {
            winningTeam = "black";
        }

        if (whitePoints == blackPoints)
        {
            Console.WriteLine("Equal result: {0}", whitePoints);
        }
        else
        {
            Console.WriteLine("The winner is: {0} team", winningTeam);
            Console.WriteLine(Math.Abs(whitePoints - blackPoints));
        }
    }
}