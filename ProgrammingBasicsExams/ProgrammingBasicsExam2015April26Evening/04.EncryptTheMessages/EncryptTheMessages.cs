using System;

class EncryptTheMessages
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        int count = 0;
        string allMessages = null;

        while (command != "START" && command != "start")
        {
            command = Console.ReadLine();
        }

        command = Console.ReadLine();

        while (command != "END" && command != "end")
        {
            string commandReversed = null;
            if (command.Length > 0)
            {
                //Reverse
                for (int i = command.Length - 1; i >= 0; i--)
                {
                    commandReversed += command[i];
                }

                //Check
                for (int i = 0; i < commandReversed.Length; i++)
                {
                    if (commandReversed[i] >= 65 && commandReversed[i] <= 77)
                    {
                        commandReversed = commandReversed.Remove(i, 1).Insert(i, ((char)((commandReversed[i] - 65) + 78)).ToString());
                    }
                    else if (commandReversed[i] >= 97 && commandReversed[i] <= 109)
                    {
                        commandReversed = commandReversed.Remove(i, 1).Insert(i, ((char)((commandReversed[i] - 97) + 110)).ToString());
                    }
                    else if (commandReversed[i] >= 78 && commandReversed[i] <= 90)
                    {
                        commandReversed = commandReversed.Remove(i, 1).Insert(i, ((char)((commandReversed[i] - 78) + 65)).ToString());
                    }
                    else if (commandReversed[i] >= 110 && commandReversed[i] <= 122)
                    {
                        commandReversed = commandReversed.Remove(i, 1).Insert(i, ((char)((commandReversed[i] - 110) + 97)).ToString());
                    }
                }
                commandReversed = commandReversed.Replace(' ', '+').Replace(',', '%').Replace('.', '&').Replace('?', '#').Replace('!', '$');
                count++;
                allMessages += commandReversed + " ";
            }
            command = Console.ReadLine();
        }
        if (count > 0)
        {
            Console.WriteLine("Total number of messages: {0}", count);
            string[] split = allMessages.Split(' ');
            for (int i = 0; i < count; i++)
            {
                Console.WriteLine(split[i]);
            }
        }
        else
        {
            Console.WriteLine("No messages sent.");
        }
    }
}