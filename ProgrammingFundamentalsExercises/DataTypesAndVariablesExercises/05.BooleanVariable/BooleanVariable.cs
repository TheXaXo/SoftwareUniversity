using System;

class BooleanVariable
{
    static void Main(string[] args)
    {
        string input = Console.ReadLine();
        bool status = Convert.ToBoolean(input);
        if (status)
        {
            Console.WriteLine("Yes");
        }
        else
        {
            Console.WriteLine("No");
        }
    }
}