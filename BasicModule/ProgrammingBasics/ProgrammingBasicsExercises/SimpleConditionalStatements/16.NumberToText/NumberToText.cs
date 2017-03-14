using System;

class NumberToText
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        string m = n.ToString();
        string first = null;
        string second = null;

        //20 - 99
        if (n >= 20 && n < 100)
        {
            if (m[0] == '2')
            {
                first = "twenty";
            }
            else if (m[0] == '3')
            {
                first = "thirty";
            }
            else if (m[0] == '4')
            {
                first = "fourty";
            }
            else if (m[0] == '5')
            {
                first = "fifty";
            }
            else if (m[0] == '6')
            {
                first = "sixty";
            }
            else if (m[0] == '7')
            {
                first = "seventy";
            }
            else if (m[0] == '8')
            {
                first = "eighty";
            }
            else if (m[0] == '9')
            {
                first = "ninety";
            }

            if (m[1] == 0)
            {
                second = null;
            }
            else if (m[1] == '1')
            {
                second = "one";
            }
            else if (m[1] == '2')
            {
                second = "two";
            }
            else if (m[1] == '3')
            {
                second = "three";
            }
            else if (m[1] == '4')
            {
                second = "four";
            }
            else if (m[1] == '5')
            {
                second = "five";
            }
            else if (m[1] == '6')
            {
                second = "six";
            }
            else if (m[1] == '7')
            {
                second = "seven";
            }
            else if (m[1] == '8')
            {
                second = "eight";
            }
            else if (m[1] == '9')
            {
                second = "nine";
            }
            if (second == null)
            {
                Console.WriteLine("{0}", first);
            }
            else
            {
                Console.WriteLine("{0} {1}", first, second);
            }
        }

        //100
        if (n == 100)
        {
            Console.WriteLine("one hundred");
        }

        //0 - 19
        if (n >= 0 && n <= 19)
        {
            if (n == 0)
            {
                Console.WriteLine("zero");
            }
            if (n == 1)
            {
                Console.WriteLine("one");
            }
            if (n == 2)
            {
                Console.WriteLine("two");
            }
            if (n == 3)
            {
                Console.WriteLine("three");
            }
            if (n == 4)
            {
                Console.WriteLine("four");
            }
            if (n == 5)
            {
                Console.WriteLine("five");
            }
            if (n == 6)
            {
                Console.WriteLine("six");
            }
            if (n == 7)
            {
                Console.WriteLine("seven");
            }
            if (n == 8)
            {
                Console.WriteLine("eight");
            }
            if (n == 9)
            {
                Console.WriteLine("nine");
            }
            if (n == 10)
            {
                Console.WriteLine("ten");
            }
            if (n == 11)
            {
                Console.WriteLine("eleven");
            }
            if (n == 12)
            {
                Console.WriteLine("twelve");
            }
            if (n == 13)
            {
                Console.WriteLine("thirteen");
            }
            if (n == 14)
            {
                Console.WriteLine("fourteen");
            }
            if (n == 15)
            {
                Console.WriteLine("fifteen");
            }
            if (n == 16)
            {
                Console.WriteLine("sixteen");
            }
            if (n == 17)
            {
                Console.WriteLine("seventeen");
            }
            if (n == 18)
            {
                Console.WriteLine("eighteen");
            }
            if (n == 19)
            {
                Console.WriteLine("nineteen");
            }
        }

        //Invalid Number
        if (n < 0 || n > 100)
        {
            Console.WriteLine("invalid number");
        }
    }
}