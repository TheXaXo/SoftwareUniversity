using System;

class OperationsBetweenNumbers
{
    static void Main(string[] args)
    {
        double n1 = int.Parse(Console.ReadLine());
        double n2 = int.Parse(Console.ReadLine());
        string op = Console.ReadLine();
        double result;

        if (op == "+")
        {
            result = n1 + n2;
            if (result % 2 == 0)
            {
                Console.WriteLine("{0} + {1} = {2} - even", n1, n2, result);
            }
            else
            {
                Console.WriteLine("{0} + {1} = {2} - odd", n1, n2, result);
            }
        }
        else if (op == "-")
        {
            result = n1 - n2;
            if (result % 2 == 0)
            {
                Console.WriteLine("{0} - {1} = {2} - even", n1, n2, result);
            }
            else
            {
                Console.WriteLine("{0} - {1} = {2} - odd", n1, n2, result);
            }
        }
        else if (op == "*")
        {
            result = n1 * n2;
            if (result % 2 == 0)
            {
                Console.WriteLine("{0} * {1} = {2} - even", n1, n2, result);
            }
            else
            {
                Console.WriteLine("{0} * {1} = {2} - odd", n1, n2, result);
            }
        }
        else if (op == "/")
        {
            if (n2 == 0)
            {
                Console.WriteLine("Cannot divide {0} by zero", n1);
            }
            else
            {
                result = n1 / n2;
                Console.WriteLine("{0} / {1} = {2:f2}", n1, n2, result);
            }
        }
        else if (op == "%")
        {
            if (n2 == 0)
            {
                Console.WriteLine("Cannot divide {0} by zero", n1);
            }
            else
            {
                result = n1 % n2;
                Console.WriteLine("{0} % {1} = {2}", n1, n2, result);
            }
        }
    }
}