using System;

class MathPower
{
    static void Main(string[] args)
    {
        double number = double.Parse(Console.ReadLine());
        int power = int.Parse(Console.ReadLine());

        double raisedNumber = GetPowerOfNumber(number, power);
        Console.WriteLine(raisedNumber);
    }
    static double GetPowerOfNumber(double number, int power)
    {
        double raised = 1;
        for (int i = 1; i <= power; i++)
        {
            raised *= number;
        }
        return raised;
    }       
}