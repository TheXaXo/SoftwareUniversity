using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;

class OddLines
{
    static void Main(string[] args)
    {
        string[] text = File.ReadAllLines("Input.txt");
        File.WriteAllText("Output.txt", "");

        for (int i = 0; i < text.Length; i++)
        {
            if (i % 2 != 0)
            {
                File.AppendAllText("Output.txt", text[i] + "\r\n");
            }
        }
    }
}