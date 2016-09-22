using System;

class ProspectInHospitality
{
    static void Main(string[] args)
    {
        uint builders = uint.Parse(Console.ReadLine());
        uint receptionists = uint.Parse(Console.ReadLine());
        uint chambermaids = uint.Parse(Console.ReadLine());
        uint technicians = uint.Parse(Console.ReadLine());
        uint others = uint.Parse(Console.ReadLine());
        decimal lawyerSalary = decimal.Parse(Console.ReadLine());
        decimal rate = decimal.Parse(Console.ReadLine());
        decimal mySalary = decimal.Parse(Console.ReadLine());
        decimal budget = decimal.Parse(Console.ReadLine());
        decimal lawyerSalaryInBGN = lawyerSalary * rate;

        decimal moneyNeeded = builders * 1500.04m + receptionists * 2102.10m + chambermaids * 1465.46m + technicians * 2053.33m + others * 3010.98m + lawyerSalaryInBGN + mySalary;

        Console.WriteLine("The amount is: {0:f2} lv.", moneyNeeded);
        if (budget >= moneyNeeded)
        {
            Console.WriteLine("YES \\ Left: {0:f2} lv.", budget - moneyNeeded);
        }
        else
        {
            Console.WriteLine("NO \\ Need more: {0:f2} lv.", moneyNeeded - budget);
        }
    }
}