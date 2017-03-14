using System;
using System.Collections.Generic;
using System.Linq;

class PopulationCounter
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        Dictionary<string, Dictionary<string, long>> countries = new Dictionary<string, Dictionary<string, long>>();

        while (command != "report")
        {
            string[] split = command.Split('|');
            string city = split[0];
            string country = split[1];
            long population = int.Parse(split[2]);
            Dictionary<string, long> citiesPopulation = new Dictionary<string, long>();

            citiesPopulation[city] = population;

            if (countries.ContainsKey(country))
            {
                countries[country] = citiesPopulation.Concat(countries[country]).ToDictionary(x => x.Key, y => y.Value);
            }
            else
            {
                countries[country] = citiesPopulation;
            }

            command = Console.ReadLine();
        }

        countries = countries.OrderByDescending(x => x.Value.Sum(y => y.Value)).ToDictionary(x => x.Key, y => y.Value);

        foreach (KeyValuePair<string, Dictionary<string, long>> pair in countries)
        {
            Dictionary<string, long> citiesPopulation = pair.Value;
            citiesPopulation = citiesPopulation.OrderByDescending(x => x.Value).ToDictionary(x => x.Key, y => y.Value);
            long population = citiesPopulation.Values.Sum();

            Console.WriteLine($"{pair.Key} (total population: {population})");
            foreach (KeyValuePair<string, long> citiesPair in citiesPopulation)
            {
                Console.WriteLine($"=>{citiesPair.Key}: {citiesPair.Value}");
            }
        }
    }
}