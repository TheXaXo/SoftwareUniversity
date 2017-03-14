using System;

class PerfectGirlfriend
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        decimal sum = 0;
        string day = null;
        string phoneNumber = null;
        string braSize = null;
        string name = null;
        int perfectGirls = 0;

        while (command != "Enough dates!")
        {
            string[] split = command.Split('\\');
            day = split[0];
            phoneNumber = split[1];
            braSize = split[2];
            name = split[3];

            //Day Of Week
            if (day == "Monday")
            {
                sum += 1;
            }
            else if (day == "Tuesday")
            {
                sum += 2;
            }
            else if (day == "Wednesday")
            {
                sum += 3;
            }
            else if (day == "Thursay")
            {
                sum += 4;
            }
            else if (day == "Friday")
            {
                sum += 5;
            }
            else if (day == "Saturday")
            {
                sum += 6;
            }
            else if (day == "Sunday")
            {
                sum += 7;
            }

            //Phone Number
            for (int i = 0; i < phoneNumber.Length; i++)
            {
                sum += int.Parse(phoneNumber[i].ToString());
            }

            //Bra Size
            string braSizeNumbers = null;
            char braSizeChar = 'a';
            for (int i = 0; i < braSize.Length; i++)
            {
                if (i < braSize.Length - 1)
                {
                    braSizeNumbers += braSize[i];
                }
                else
                {
                    braSizeChar = braSize[i];
                }
            }
            sum += int.Parse(braSizeNumbers) * braSizeChar;

            //Name
            sum -= name[0] * name.Length;
            
            if (sum < 6000)
            {
                Console.WriteLine("Keep searching, {0} is not for you.", name);
            }
            else
            {
                Console.WriteLine("{0} is perfect for you.", name);
                perfectGirls++;
            }
            command = Console.ReadLine();
            sum = 0;
        }
        Console.WriteLine(perfectGirls);
    }
}