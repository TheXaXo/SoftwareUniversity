﻿using System;

class SignOfIntegerNumber
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        PrintSign(n);
    }
    static void PrintSign(int number)
    {
        if (number > 0)
        {
            Console.WriteLine($"The number {number} is positive.");
        }
        else if (number == 0)
        {
            Console.WriteLine($"The number {number} is zero.");
        }
        else
        {
            Console.WriteLine($"The number {number} is negative.");
        }
    }
}