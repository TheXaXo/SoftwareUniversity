using System;

class DetectiveBoev
{
    static void Main(string[] args)
    {
        string word = Console.ReadLine();
        string message = Console.ReadLine();
        int wordSum = 0;
        int mask = 0;
        int oldMask = 0;
        string answer = null;
        char answerChar;

        for (int i = 0; i < word.Length; i++)
        {
            wordSum += word[i];
        }

        for (int i = 0; i < wordSum.ToString().Length; i++)
        {
            mask += int.Parse((wordSum.ToString()[i]).ToString());
        }
        while (mask > 9)
        {
            oldMask = mask;
            mask = 0;
            for (int i = 0; i < oldMask.ToString().Length; i++)
            {
                mask += int.Parse(oldMask.ToString()[i].ToString());
            }
        }

        for (int i = message.Length - 1; i >= 0; i--)
        {
            if (message[i] % mask == 0)
            {
                answerChar = (char)(mask + (int)message[i]);
                answer += answerChar;
            }
            else
            {
                answerChar = (char)((int)message[i] - mask);
                answer += answerChar;
            }
        }
        Console.WriteLine(answer);
    }
}