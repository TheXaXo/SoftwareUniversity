using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;

class LineNumbers
{
    static void Main(string[] args)
    {
        string[] text = File.ReadAllLines("Input.txt");
        File.WriteAllText("Output.txt", "");

        for (int i = 0; i < text.Length; i++)
        {
            File.AppendAllText("Output.txt", $"{i + 1}. {text[i]} \r\n");
        }
    }
}