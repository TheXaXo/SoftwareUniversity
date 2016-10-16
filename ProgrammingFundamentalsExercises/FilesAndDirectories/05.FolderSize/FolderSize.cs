using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;

class FolderSize
{
    static void Main(string[] args)
    {
        string[] files = Directory.GetFiles("TestFolder");
        double sum = 0;

        foreach (string file in files)
        {
            FileInfo info = new FileInfo(file);
            sum += info.Length;
        }

        File.WriteAllText("output.txt", $"{sum / 1024 / 1024}");
    }
}