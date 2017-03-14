using System;

class DifferentIntegersSize
{
    static void Main(string[] args)
    {
        bool inSbyte = true;
        bool inByte = true;
        bool inShort = true;
        bool inUshort = true;
        bool inInt = true;
        bool inUint = true;
        bool inLong = true;

        string inputInString = Console.ReadLine();
        try
        {
            long input = long.Parse(inputInString);
        }
        catch (Exception)
        {
            Console.WriteLine("{0} can't fit in any type", inputInString);
            return;
        }
        
        try
        {
            sbyte input = sbyte.Parse(inputInString);
        }
        catch(Exception)
        {
            inSbyte = false;
        }

        try
        {
            byte input = byte.Parse(inputInString);
        }
        catch(Exception)
        {
            inByte = false;
        }

        try
        {
            short input = short.Parse(inputInString);
        }
        catch(Exception)
        {
            inShort = false;
        }

        try
        {
            ushort input = ushort.Parse(inputInString);
        }
        catch(Exception)
        {
            inUshort = false;
        }

        try
        {
            int input = int.Parse(inputInString);
        }
        catch(Exception)
        {
            inInt = false;
        }

        try
        {
            uint input = uint.Parse(inputInString);
        }
        catch (Exception)
        {
            inUint = false;
        }

        Console.WriteLine("{0} can fit in: ", inputInString);
        if (inSbyte)
        {
            Console.WriteLine("* sbyte");
        }
        if (inByte)
        {
            Console.WriteLine("* byte");
        }
        if (inShort)
        {
            Console.WriteLine("* short");
        }
        if (inUshort)
        {
            Console.WriteLine("* ushort");
        }
        if (inInt)
        {
            Console.WriteLine("* int");
        }
        if (inUint)
        {
            Console.WriteLine("* uint");
        }
        Console.WriteLine("* long");
    }
}