using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;

class MergeFiles
{
    static void Main(string[] args)
    {
        string[] fileOne = File.ReadAllLines("FileOne.txt");
        string[] fileTwo = File.ReadAllLines("FileTwo.txt");

        File.WriteAllLines("output.txt", fileOne.Concat(fileTwo).OrderBy(x => x));
    }
}