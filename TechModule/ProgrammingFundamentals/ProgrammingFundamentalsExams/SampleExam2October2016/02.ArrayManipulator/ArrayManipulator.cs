using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

class ArrayManipulator
{
    static void Main(string[] args)
    {
        int[] array = Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToArray();
        string command = Console.ReadLine();

        while (command != "end")
        {
            string[] split = command.Split();

            if (split[0] == "exchange")
            {
                int index = int.Parse(split[1]);

                if (index > array.Length - 1 || index < 0)
                {
                    Console.WriteLine("Invalid index");
                    command = Console.ReadLine();
                    continue;
                }
                array = Exchange(array, index);
            }
            else if (split[0] == "max")
            {
                if (split[1] == "even")
                {
                    bool containsEven = ContainsEven(array);

                    if (containsEven)
                    {
                        Console.WriteLine(MaxEven(array));
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                }
                else
                {
                    bool containsOdd = ContainsOdd(array);

                    if (containsOdd)
                    {
                        Console.WriteLine(MaxOdd(array));
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                }
            }
            else if (split[0] == "min")
            {
                if (split[1] == "even")
                {
                    bool containsEven = ContainsEven(array);

                    if (containsEven)
                    {
                        Console.WriteLine(MinEven(array));
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                }
                else
                {
                    bool containsOdd = ContainsOdd(array);

                    if (containsOdd)
                    {
                        Console.WriteLine(MinOdd(array));
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                }
            }
            else if (split[0] == "first")
            {
                int count = int.Parse(split[1]);
                if (count > array.Length)
                {
                    Console.WriteLine("Invalid count");
                    command = Console.ReadLine();
                    continue;
                }

                if (split[2] == "even")
                {
                    int[] firstEven = FirstEven(array, count);
                    if (firstEven.Length > 0)
                    {
                        Console.WriteLine($"[{string.Join(", ", firstEven)}]");
                    }
                    else
                    {
                        Console.WriteLine("[]");
                    }
                }
                else
                {
                    int[] firstOdd = FirstOdd(array, count);
                    if (firstOdd.Length > 0)
                    {
                        Console.WriteLine($"[{string.Join(", ", firstOdd)}]");
                    }
                    else
                    {
                        Console.WriteLine("[]");
                    }
                }
            }
            else if (split[0] == "last")
            {
                int count = int.Parse(split[1]);
                if (count > array.Length)
                {
                    Console.WriteLine("Invalid count");
                    command = Console.ReadLine();
                    continue;
                }

                if (split[2] == "even")
                {
                    int[] lastEven = LastEven(array, count);
                    if (lastEven.Length > 0)
                    {
                        Console.WriteLine($"[{string.Join(", ", lastEven)}]");
                    }
                    else
                    {
                        Console.WriteLine("[]");
                    }
                }
                else
                {
                    int[] lastOdd = LastOdd(array, count);
                    if (lastOdd.Length > 0)
                    {
                        Console.WriteLine($"[{string.Join(", ", lastOdd)}]");
                    }
                    else
                    {
                        Console.WriteLine("[]");
                    }
                }
            }

            command = Console.ReadLine();
        }

        Console.WriteLine($"[{string.Join(", ", array)}]");
    }

    static bool ContainsEven(int[] array)
    {
        bool containsEven = false;

        for (int i = 0; i < array.Length; i++)
        {
            if (array[i] % 2 == 0)
            {
                containsEven = true;
                break;
            }
        }

        return containsEven;
    }

    static bool ContainsOdd(int[] array)
    {
        bool containsOdd = false;

        for (int i = 0; i < array.Length; i++)
        {
            if (array[i] % 2 != 0)
            {
                containsOdd = true;
                break;
            }
        }

        return containsOdd;
    }

    static int[] Exchange(int[] array, int index)
    {
        int[] firstPart = array.Take(index + 1).ToArray();
        int[] secondPart = array.Skip(index + 1).ToArray();

        array = secondPart.Concat(firstPart).ToArray();

        return array;
    }

    static int MaxEven(int[] array)
    {
        int maxEven = array
            .Where(x => x % 2 == 0)
            .OrderByDescending(x => x)
            .First();

        int index = Array.LastIndexOf(array, maxEven);
        return index;
    }

    static int MaxOdd(int[] array)
    {
        int maxOdd = array
            .Where(x => x % 2 != 0)
            .OrderByDescending(x => x)
            .First();

        int index = Array.LastIndexOf(array, maxOdd);
        return index;
    }

    static int MinEven(int[] array)
    {
        int minEven = array
            .Where(x => x % 2 == 0)
            .OrderBy(x => x)
            .First();

        int index = Array.LastIndexOf(array, minEven);
        return index;
    }

    static int MinOdd(int[] array)
    {
        int minOdd = array
            .Where(x => x % 2 != 0)
            .OrderBy(x => x)
            .First();

        int index = Array.LastIndexOf(array, minOdd);
        return index;
    }

    static int[] FirstEven(int[] array, int count)
    {
        int[] result = array
            .Where(x => x % 2 == 0)
            .Take(count)
            .ToArray();

        return result;
    }

    static int[] FirstOdd(int[] array, int count)
    {
        int[] result = array
            .Where(x => x % 2 != 0)
            .Take(count)
            .ToArray();

        return result;
    }

    static int[] LastEven(int[] array, int count)
    {
        int[] result = array
            .Where(x => x % 2 == 0)
            .Reverse()
            .Take(count)
            .Reverse()
            .ToArray();

        return result;
    }

    static int[] LastOdd(int[] array, int count)
    {
        int[] result = array
            .Where(x => x % 2 != 0)
            .Reverse()
            .Take(count)
            .Reverse()
            .ToArray();

        return result;
    }
}