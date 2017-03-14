using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class CommandInterpreter
{
    static void Main(string[] args)
    {
        string[] array = Console.ReadLine()
        .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

        string command = Console.ReadLine();

        while (command != "end")
        {
            string[] split = command.Split();

            if (split[0] == "reverse")
            {
                int index = int.Parse(split[2]);
                int count = int.Parse(split[4]);

                if (index >= 0 && count >= 0 && index < array.Length && index + count <= array.Length)
                {
                    Array.Reverse(array, index, count);
                }
                else
                {
                    Console.WriteLine("Invalid input parameters.");
                    command = Console.ReadLine();
                    continue;
                }
            }
            else if (split[0] == "sort")
            {
                int index = int.Parse(split[2]);
                int count = int.Parse(split[4]);

                if (index >= 0 && count >= 0 && index < array.Length && index + count <= array.Length)
                {
                    Array.Sort(array, index, count);
                }
                else
                {
                    Console.WriteLine("Invalid input parameters.");
                    command = Console.ReadLine();
                    continue;
                }
                
            }
            else if (split[0] == "rollLeft")
            {
                int count = int.Parse(split[1]) % array.Length;

                if (count < 0)
                {
                    Console.WriteLine("Invalid input parameters.");
                    command = Console.ReadLine();
                    continue;
                }

                for (int i = 1; i <= count; i++)
                {
                    string oldFirst = array[0];
                    Array.Copy(array, 1, array, 0, array.Length - 1);
                    array[array.Length - 1] = oldFirst;
                }
            }
            else if (split[0] == "rollRight")
            {
                int count = int.Parse(split[1]) % array.Length;

                if (count < 0)
                {
                    Console.WriteLine("Invalid input parameters.");
                    command = Console.ReadLine();
                    continue;
                }

                for (int i = 1; i <= count; i++)
                {
                    string oldLast = array[array.Length - 1];
                    Array.Copy(array, 0, array, 1, array.Length - 1);
                    array[0] = oldLast;
                }
            }

            command = Console.ReadLine();
        }

        Console.WriteLine($"[{string.Join(", ", array)}]");
    }
}