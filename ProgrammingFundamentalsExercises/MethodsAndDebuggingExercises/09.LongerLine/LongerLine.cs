using System;
using System.Linq;

class LongerLine
{
    static void Main(string[] args)
    {
        int[] array = { 2, 3, 4 };
        SubstractOneFromArray(array);
        Console.WriteLine(array[0]);
    }
    static void SubstractOneFromArray(int[] array)
    {

        int[] arrayShiftRight = array;
        arrayShiftRight[0] = array[array.Count() - 1];
        for (int i = 1; i < array.Count(); i++)
        {
            arrayShiftRight[i] = array[i];
        }
        array = arrayShiftRight;

    }
}