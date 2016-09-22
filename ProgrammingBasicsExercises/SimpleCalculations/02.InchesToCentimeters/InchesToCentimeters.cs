using System;

class InchesToCentimeters
{
    static void Main(string[] args)
    {
        decimal inches = decimal.Parse(Console.ReadLine());
        decimal centimeters = inches * 2.54m;
        Console.WriteLine(centimeters);
    }
}