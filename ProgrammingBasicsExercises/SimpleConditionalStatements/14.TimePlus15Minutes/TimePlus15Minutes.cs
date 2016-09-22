using System;

class TimePlus15Minutes
{
    static void Main(string[] args)
    {
        int hour = int.Parse(Console.ReadLine());
        int minute = int.Parse(Console.ReadLine());

        int time = hour * 60 + minute;
        int timePlus15Minutes = time + 15;

        int hour2 = timePlus15Minutes / 60;
        int minute2 = timePlus15Minutes % 60;

        if(hour2 > 23)
        {
            hour2 = 0;
        }

        Console.WriteLine("{0}:{1}", hour2, minute2.ToString().PadLeft(2, '0'));
    }
}