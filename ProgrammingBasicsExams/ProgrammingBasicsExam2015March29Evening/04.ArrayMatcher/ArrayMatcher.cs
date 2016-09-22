using System;

class ArrayMatcher
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        string[] split = command.Split('\\');
        string arrayOne = split[0];
        string arrayTwo = split[1];
        string action = split[2];
        string commonChars = null;
        string rightExclude = null;
        string leftExclude = null;

        if (action == "join")
        {
            for (int i = 0; i < arrayOne.Length; i++)
            {
                for (int j = 0; j < arrayTwo.Length; j++)
                {
                    if (arrayTwo[j] == arrayOne[i])
                    {
                        commonChars += arrayTwo[j];
                    }
                }
            }
            Console.WriteLine(commonChars);
        }
        else if (action == "right exclude")
        {
            for (int i = 0; i < arrayOne.Length; i++)
            {
                for (int j = 0; j < arrayTwo.Length; j++)
                {
                    if (arrayOne[i] != arrayTwo[j])
                    {
                        if (j > 0 && rightExclude.Contains(arrayOne[i].ToString()))
                        {
                            continue;
                        }
                        rightExclude += arrayOne[i];
                    }
                    else
                    {
                        rightExclude = rightExclude.Replace(arrayOne[i].ToString(), null);
                        break;
                    }
                }
            }
            Console.WriteLine(rightExclude);
        }
        else
        {
            for (int i = 0; i < arrayTwo.Length; i++)
            {
                for (int j = 0; j < arrayOne.Length; j++)
                {
                    if (arrayTwo[i] != arrayOne[j])
                    {
                        if (j > 0 && leftExclude.Contains(arrayTwo[i].ToString()))
                        {
                            continue;
                        }
                        leftExclude += arrayTwo[i];
                    }
                    else
                    {
                        leftExclude = leftExclude.Replace(arrayTwo[i].ToString(), null);
                        break;
                    }
                }
            }
            Console.WriteLine(leftExclude);
        }
    }
}