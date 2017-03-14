using System;

class InstructionSet
{
    static void Main()
    {
        string command = Console.ReadLine();

        while (command != "END")
        {
            string[] split = command.Split(' ');
            long result = 0;
            switch (split[0])
            {
                case "INC":
                    {
                        int operandOne = int.Parse(split[1]);
                        result = (long)operandOne + 1;
                        break;
                    }
                case "DEC":
                    {
                        int operandOne = int.Parse(split[1]);
                        result = (long)operandOne - 1;
                        break;
                    }
                case "ADD":
                    {
                        int operandOne = int.Parse(split[1]);
                        int operandTwo = int.Parse(split[2]);
                        result = (long)operandOne + operandTwo;
                        break;
                    }
                case "MLA":
                    {
                        int operandOne = int.Parse(split[1]);
                        int operandTwo = int.Parse(split[2]);
                        result = (long)operandOne * operandTwo;
                        break;
                    }
            }
            Console.WriteLine(result);
            command = Console.ReadLine();
        }
    }
}