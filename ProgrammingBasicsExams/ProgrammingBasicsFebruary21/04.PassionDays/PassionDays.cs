using System;

class PassionDays
{
    static void Main(string[] args)
    {
        decimal money = decimal.Parse(Console.ReadLine());
        string command = Console.ReadLine();
        int purchases = 0;

        while (command != "mall.Enter")
        {
            command = Console.ReadLine();
        }

        command = Console.ReadLine();

        while (command != "mall.Exit")
        {
            for (int i = 0; i < command.Length; i++)
            {
                if (command[i] >= 65 && command[i] <= 90)
                {
                    if (money < command[i] * 0.5m)
                    {
                        continue;
                    }
                    else
                    {
                        money -= command[i] * 0.5m;
                        purchases++;
                    }
                }
                else if (command[i] >= 97 && command[i] <= 122)
                {
                    if (money < command[i] * 0.3m)
                    {
                        continue;
                    }
                    else
                    {
                        money -= command[i] * 0.3m;
                        purchases++;
                    }
                }
                else if (command[i] == '%')
                {
                    if (money == 0)
                    {
                        continue;
                    }
                    else
                    {
                        money /= 2;
                        purchases++;
                    }
                }
                else if (command[i] == '*')
                {
                    money += 10;
                }
                else
                {
                    if (money < command[i])
                    {
                        continue;
                    }
                    else
                    {
                        money -= command[i];
                        purchases++;
                    }
                }
            }
            command = Console.ReadLine();
        }

        if (purchases == 0)
        {
            Console.WriteLine("No purchases. Money left: {0:f2} lv.", money);
        }
        else
        {
            Console.WriteLine("{0} purchases. Money left: {1:f2} lv.", purchases, money);
        }
    }
}