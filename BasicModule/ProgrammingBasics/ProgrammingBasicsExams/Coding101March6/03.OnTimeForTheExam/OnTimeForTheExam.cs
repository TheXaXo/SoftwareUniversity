using System;

class OnTimeForTheExam
{
    static void Main(string[] args)
    {
        int examHour = int.Parse(Console.ReadLine());
        int examMinute = int.Parse(Console.ReadLine());
        int arrivalHour = int.Parse(Console.ReadLine());
        int arrivalMinute = int.Parse(Console.ReadLine());

        int examTime = examHour * 60 + examMinute;
        int arrivalTime = arrivalHour * 60 + arrivalMinute;

        if (examTime - arrivalTime <= 30 && examTime - arrivalTime >= 0)
        {
            Console.WriteLine("On time");
            if (examTime - arrivalTime != 0)
            {
                Console.WriteLine("{0} minutes before the start", examTime - arrivalTime);
            }
        }
        else if (examTime - arrivalTime < 0)
        {
            Console.WriteLine("Late");
            if (arrivalTime - examTime < 60)
            {
                Console.WriteLine("{0} minutes after the start", arrivalTime - examTime);
            }       
            else
            {
                Console.WriteLine("{0}:{1} hours after the start", (arrivalTime - examTime) / 60, ((arrivalTime - examTime) % 60).ToString("00"));
            }
        }
        else if (examTime - arrivalTime > 30)
        {
            Console.WriteLine("Early");
            if (examTime - arrivalTime < 60)
            {
                Console.WriteLine("{0} minutes before the start", examTime - arrivalTime);
            }
            else
            {
                Console.WriteLine("{0}:{1} hours before the start", (examTime - arrivalTime) / 60, ((examTime - arrivalTime) % 60).ToString("00"));
            }
        }
    }
}