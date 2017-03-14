using System;

class Program
{
    static void Main(string[] args)
    {
        byte centuries = byte.Parse(Console.ReadLine());
        ushort years = (ushort)(centuries * 100);
        uint days = (uint)(years * 365.2422);
        ulong hours = days * 24;
        ulong minutes = hours * 60;

        Console.WriteLine("{0} centuries = {1} years = {2} days = {3} hours = {4} minutes", centuries, years, days, hours, minutes);
    }
}