using System;

class MetricConverter
{
    static void Main(string[] args)
    {
        decimal n = decimal.Parse(Console.ReadLine());
        string input = Console.ReadLine();
        string output = Console.ReadLine();
        decimal inputRate = 0.0m;
        decimal outputRate = 0.0m;

        //Input
        if (input == "mm")
        {
            inputRate = 1000;
        }
        else if (input == "cm")
        {
            inputRate = 100;
        }
        else if (input == "mi")
        {
            inputRate = 0.000621371192m;
        }
        else if (input == "in")
        {
            inputRate = 39.3700787m;
        }
        else if (input == "km")
        {
            inputRate = 0.001m;
        }
        else if (input == "ft")
        {
            inputRate = 3.2808399m;
        }
        else if (input == "yd")
        {
            inputRate = 1.0936133m;
        }
        else if (input == "m")
        {
            inputRate = 1;
        }

        //Output
        if (output == "mm")
        {
            outputRate = 1000;
        }
        else if (output == "cm")
        {
            outputRate = 100;
        }
        else if (output == "mi")
        {
            outputRate = 0.000621371192m;
        }
        else if (output == "in")
        {
            outputRate = 39.3700787m;
        }
        else if (output == "km")
        {
            outputRate = 0.001m;
        }
        else if (output == "ft")
        {
            outputRate = 3.2808399m;
        }
        else if (output == "yd")
        {
            outputRate = 1.0936133m;
        }
        else if (output == "m")
        {
            outputRate = 1;
        }

        decimal result = n / inputRate * outputRate;
        Console.WriteLine("{0} {1}", result, output);
    }
}