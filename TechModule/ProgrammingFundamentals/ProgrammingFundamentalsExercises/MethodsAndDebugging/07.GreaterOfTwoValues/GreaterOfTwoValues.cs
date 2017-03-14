using System;

class GreaterOfTwoValues
{
    static void Main(string[] args)
    {
        string type = Console.ReadLine();
        if (type == "int")
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            int greater = GetGreaterValue(a, b);
            Console.WriteLine(greater);
        }
        else if (type == "char")
        {
            char a = char.Parse(Console.ReadLine());
            char b = char.Parse(Console.ReadLine());

            char greater = GetGreaterValue(a, b);
            Console.WriteLine(greater);
        }
        else
        {
            string a = Console.ReadLine();
            string b = Console.ReadLine();

            string greater = GetGreaterValue(a, b);
            Console.WriteLine(greater);
        }
    }
    static int GetGreaterValue(int a, int b)
    {
        int greater = a;
        if (b > a)
        {
            greater = b;
        }
        return greater;
    }
    static char GetGreaterValue(char a, char b)
    {
        char greater = a;
        if (b > a)
        {
            greater = b;
        }
        return greater;
    }
    static string GetGreaterValue(string a, string b)
    {
        string greater = a;
        if (b.CompareTo(a) > 0)
        {
            greater = b;
        }
        return greater;
    }
}