using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class Program
{
    static void Main(string[] args)
    {
        string pattern = @".*?KZL(\w+)?KZL.*?KZL?(\w+)?KZL?.*?(\d+):(\d+)";
        string key = Console.ReadLine();
        string keyFixed = null;

        Dictionary<string, int> teamPoints = new Dictionary<string, int>();
        Dictionary<string, long> teamGoals = new Dictionary<string, long>();

        char[] needToBeEscaped = { '.', '^', '$', '*', '+', '?', '(', ')', '[', '{', '\\', '|' };
        foreach(char c in key)
        {
            if (needToBeEscaped.Contains(c))
            {
                keyFixed += @"\" + c;
            }
            else
            {
                keyFixed += c;
            }
        }

        pattern = pattern.Replace("KZL", keyFixed);

        string command = Console.ReadLine();

        while (command != "final")
        {
            Match match = Regex.Match(command, pattern);

            string teamA = match.Groups[1].ToString();
            teamA = ReverseAndToUpper(teamA);
            string teamB = match.Groups[2].ToString();
            teamB = ReverseAndToUpper(teamB);

            long teamAScore = long.Parse(match.Groups[3].ToString());
            long teamBScore = long.Parse(match.Groups[4].ToString());

            if (teamAScore > teamBScore)
            {
                string winningTeam = teamA;
                string loosingTeam = teamB;

                if (teamPoints.ContainsKey(winningTeam))
                {
                    teamPoints[winningTeam] += 3;
                    teamGoals[winningTeam] += teamAScore;
                }
                else
                {
                    teamPoints[winningTeam] = 3;
                    teamGoals[winningTeam] = teamAScore;
                }

                if (teamPoints.ContainsKey(loosingTeam))
                {
                    teamPoints[loosingTeam] += 0;
                    teamGoals[loosingTeam] += teamBScore;
                }
                else
                {
                    teamPoints[loosingTeam] = 0;
                    teamGoals[loosingTeam] = teamBScore;
                }
            }
            else if (teamBScore > teamAScore)
            {
                string winningTeam = teamB;
                string loosingTeam = teamA;

                if (teamPoints.ContainsKey(winningTeam))
                {
                    teamPoints[winningTeam] += 3;
                    teamGoals[winningTeam] += teamBScore;
                }
                else
                {
                    teamPoints[winningTeam] = 3;
                    teamGoals[winningTeam] = teamBScore;
                }

                if (teamPoints.ContainsKey(loosingTeam))
                {
                    teamPoints[loosingTeam] += 0;
                    teamGoals[loosingTeam] += teamAScore;
                }
                else
                {
                    teamPoints[loosingTeam] = 0;
                    teamGoals[loosingTeam] = teamAScore;
                }
            }
            else
            {

                if (teamPoints.ContainsKey(teamA))
                {
                    teamPoints[teamA] += 1;
                    teamGoals[teamA] += teamAScore;
                }
                else
                {
                    teamPoints[teamA] = 1;
                    teamGoals[teamA] = teamAScore;
                }

                if (teamPoints.ContainsKey(teamB))
                {
                    teamPoints[teamB] += 1;
                    teamGoals[teamB] += teamBScore;
                }
                else
                {
                    teamPoints[teamB] = 1;
                    teamGoals[teamB] = teamBScore;
                }
            }

            command = Console.ReadLine();
        }

        teamPoints = teamPoints
            .OrderByDescending(x => x.Value)
            .ThenBy(x => x.Key)
            .ToDictionary(x => x.Key, y => y.Value);

        teamGoals = teamGoals
            .OrderByDescending(x => x.Value)
            .ThenBy(x => x.Key)
            .Take(3)
            .ToDictionary(x => x.Key, y => y.Value);

        Console.WriteLine("League standings:");
        int count = 1;
        foreach (KeyValuePair<string, int> pair in teamPoints)
        {
            Console.WriteLine($"{count}. {pair.Key} {pair.Value}");
            count++;
        }

        Console.WriteLine("Top 3 scored goals:");
        foreach (KeyValuePair<string, long> pair in teamGoals)
        {
            Console.WriteLine($"- {pair.Key} -> {pair.Value}");
        }
    }

    static string ReverseAndToUpper(string input)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = input.Length - 1; i >= 0; i--)
        {
            sb.Append(input[i]);
        }
        string output = sb.ToString().ToUpper();

        return output;
    }
}