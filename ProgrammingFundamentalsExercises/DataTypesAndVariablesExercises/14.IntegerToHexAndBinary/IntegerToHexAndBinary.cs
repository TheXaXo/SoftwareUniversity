using System;

class IntegerToHexAndBinary
{
    static void Main(string[] args)
    {
        int decimalNumber = int.Parse(Console.ReadLine());
        string hexademical = decimalNumber.ToString("X");
        string binary = Convert.ToString(decimalNumber, 2);

        Console.WriteLine(hexademical);
        Console.WriteLine(binary);
    }
}