using System;

class DailyCalorieIntake
{
    static void Main(string[] args)
    {
        decimal weightInKg = decimal.Parse(Console.ReadLine()) / 2.2m;
        decimal heightInCm = decimal.Parse(Console.ReadLine()) * 2.54m;
        int age = int.Parse(Console.ReadLine());
        char gender = char.Parse(Console.ReadLine());
        int workoutsPerWeek = int.Parse(Console.ReadLine());
        decimal BMR = 0.0m;
        decimal DCI = 0.0m;

        if (gender == 'm')
        {
            BMR = 66.5m + (13.75m * weightInKg) + (5.003m * heightInCm) - (6.755m * age);
        }
        else if (gender == 'f')
        {
            BMR = 655m + (9.563m * weightInKg) + (1.850m * heightInCm) - (4.676m * age);
        }

        if (workoutsPerWeek <= 0)
        {
            DCI = BMR * 1.2m;
        }
        else if (workoutsPerWeek <= 3)
        {
            DCI = BMR * 1.375m;
        }
        else if (workoutsPerWeek <= 6)
        {
            DCI = BMR * 1.55m;
        }
        else if (workoutsPerWeek <= 9)
        {
            DCI = BMR * 1.725m;
        }
        else if (workoutsPerWeek >= 10)
        {
            DCI = BMR * 1.9m;
        }

        Console.WriteLine(Math.Floor(DCI));
    }
}