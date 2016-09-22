using System;

class VariableInHexFormat
{
    static void Main(string[] args)
    {
        string hexInString = Console.ReadLine();
        int numberFromHex = Convert.ToInt32(hexInString, 16);

        Console.WriteLine(numberFromHex);
    }
}