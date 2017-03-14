using System;

class StringsAndObjects
{
    static void Main(string[] args)
    {
        string first = "Hello";
        string second = "World";
        object resultObject = first + " " + second;
        string resultString = (string)resultObject;
        Console.WriteLine(resultString);
    }
}