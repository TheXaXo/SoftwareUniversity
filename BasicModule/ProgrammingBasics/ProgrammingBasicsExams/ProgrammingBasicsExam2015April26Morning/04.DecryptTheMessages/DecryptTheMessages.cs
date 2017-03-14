using System;

class DecryptTheMessages
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        string messageReversed = null;
        int count = 0;
        string allMessages = null;

        while (command != "START" && command != "start")
        {
            command = Console.ReadLine();
        }

        command = Console.ReadLine();
        while (command != "END" && command != "end")
        {
            messageReversed = null;
            if (command.Length > 0)
            {
                //Reverse
                for (int i = command.Length - 1; i >= 0; i--)
                {
                    messageReversed += command[i];
                }

                //Check
                for (int i = 0; i < messageReversed.Length; i++)
                {
                    if (messageReversed[i] >= 65 && messageReversed[i] <= 77)
                    {
                        messageReversed = messageReversed.Remove(i, 1).Insert(i, ((char)((messageReversed[i] - 65) + 78)).ToString());
                    }
                    else if (messageReversed[i] >= 78 && messageReversed[i] <= 90)
                    {
                        messageReversed = messageReversed.Remove(i, 1).Insert(i, ((char)((messageReversed[i] - 78) + 65)).ToString());
                    }
                    else if (messageReversed[i] >= 97 && messageReversed[i] <= 109)
                    {
                        messageReversed = messageReversed.Remove(i, 1).Insert(i, ((char)((messageReversed[i] - 97) + 110)).ToString());
                    }
                    else if (messageReversed[i] >= 110 && messageReversed[i] <= 122)
                    {
                        messageReversed = messageReversed.Remove(i, 1).Insert(i, ((char)((messageReversed[i] - 110) + 97)).ToString());
                    }
                }
                messageReversed = messageReversed.Replace('+', ' ').Replace('%', ',').Replace('&', '.').Replace('#', '?').Replace('$', '!');
                allMessages += messageReversed + "ü";
                count++;
            }
            command = Console.ReadLine();
        }
   
        if (count > 0)
        {
            Console.WriteLine("Total number of messages: {0}", count);
            string[] split = allMessages.Split('ü');
            for (int i = 0; i < count; i++)
            {
                Console.WriteLine(split[i]);
            }
        }
        else
        {
            Console.WriteLine("No message received.");
        }
    }
}