using System;

class CenturiesToNanoseconds
{
    static void Main(string[] args)
    {
        int centuries = int.Parse(Console.ReadLine());
        int years = centuries * 100;
        uint days = (uint)(years * 365.2422);
        ulong hours = days * 24;
        ulong minutes = hours * 60;
        ulong seconds = minutes * 60;
        ulong milliseconds = seconds * 1000;
        decimal microseconds = milliseconds * 1000;
        decimal nanoseconds = microseconds * 1000;

        Console.WriteLine($"{centuries} centuries = {years} years = {days} days = {hours} hours = {minutes} minutes = {seconds} seconds = {milliseconds} milliseconds = {microseconds} microseconds = {nanoseconds} nanoseconds");
    }
}