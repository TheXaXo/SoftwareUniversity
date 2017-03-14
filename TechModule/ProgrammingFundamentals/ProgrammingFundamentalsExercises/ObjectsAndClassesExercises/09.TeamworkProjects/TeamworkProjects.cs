using System;
using System.Collections.Generic;
using System.Linq;

class TeamworkProjects
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        List<Team> teams = new List<Team>();

        for (int i = 1; i <= n; i++)
        {
            string[] split = Console.ReadLine().Split('-');
            Team team = new Team();
            team.Creator = split[0];
            team.Name = split[1];

            if (teams.Exists(x => x.Name == team.Name))
            {
                Console.WriteLine($"Team {team.Name} was already created!");
                continue;
            }

            if (teams.Exists(x => x.Creator == team.Creator))
            {
                Console.WriteLine($"{team.Creator} cannot create another team!");
                continue;
            }

            Console.WriteLine($"Team {team.Name} has been created by {team.Creator}!");
            teams.Add(team);
        }

        string command = Console.ReadLine();

        while (command != "end of assignment")
        {
            string[] split = command.Split(new string[] { "->" }, StringSplitOptions.None);
            string user = split[0];
            string team = split[1];
            
            if (!teams.Exists(x => x.Name == team))
            {
                Console.WriteLine($"Team {team} does not exist!");
                command = Console.ReadLine();
                continue;
            }

            if (teams.Exists(x => x.Members.Exists(y => y == user)) || teams.Exists(x => x.Creator == user))
            {
                Console.WriteLine($"Member {user} cannot join team {team}!");
                command = Console.ReadLine();
                continue;
            }

            Team currentTeam = teams.First(x => x.Name == team);
            currentTeam.Members.Add(user);

            command = Console.ReadLine();
        }

        List<Team> teamsToDisband = teams.Where(x => x.Members.Count == 0)
            .OrderBy(x => x.Name)
            .ToList();
        teams = teams.Where(x => x.Members.Count > 0)
            .OrderByDescending(x => x.Members.Count)
            .ThenBy(x => x.Name)
            .ToList();

        foreach (Team team in teams)
        {
            Console.WriteLine(team.Name);
            Console.WriteLine($"- {team.Creator}");
            team.Members = team.Members.OrderBy(x => x).ToList();

            foreach (string member in team.Members)
            {
                Console.WriteLine($"-- {member}");
            }
        }

        Console.WriteLine("Teams to disband:");
        foreach (Team team in teamsToDisband)
        {
            Console.WriteLine(team.Name);
        }
    }
}

class Team
{
    public string Name { get; set; }
    public string Creator { get; set; }
    public List<string> Members = new List<string>();
}