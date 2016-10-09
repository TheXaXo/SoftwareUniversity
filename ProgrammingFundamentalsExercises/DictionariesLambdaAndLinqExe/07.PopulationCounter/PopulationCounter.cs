using System;
using System.Collections.Generic;
using System.Linq;

class PopulationCounter
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        Dictionary<string, long> cities = new Dictionary<string, long>();

        Dictionary<string, Dictionary<string, long>> countries = new Dictionary<string, Dictionary<string, long>>();
        Dictionary<string, Dictionary<string, long>> countriesSorted = new Dictionary<string, Dictionary<string, long>>();

        Dictionary<string, long> countriesPopulation = new Dictionary<string, long>();
        Dictionary<string, long> countriesPopulationSorted = new Dictionary<string, long>();

        while (command != "report")
        {
            string[] inputSplit = command.Split('|');
            string city = inputSplit[0];
            string country = inputSplit[1];
            long population = long.Parse(inputSplit[2]);
            cities[city] = population;

            if (countries.ContainsKey(country))
            {
                countries[country] = countries[country].Concat(cities).ToDictionary(pair => pair.Key, pair => pair.Value);
            }
            else
            {
                countries[country] = cities;
            }

            cities = new Dictionary<string, long>();
            command = Console.ReadLine();
        }

        foreach (KeyValuePair<string, Dictionary<string, long>> pair in countries)
        {
            cities = pair.Value;
            cities = cities.OrderByDescending(value => value.Key).ToDictionary(citiesPair => citiesPair.Key, citiesPair => citiesPair.Value);
            countriesSorted[pair.Key] = cities;
            long population = 0;

            foreach (KeyValuePair<string, long> citiesPair in cities)
            {
                population += citiesPair.Value;
            }

            countriesPopulation[pair.Key] = population;
            population = 0;
        }

        countriesPopulationSorted = countriesPopulation.OrderByDescending(n => n.Value).ToDictionary(n => n.Key, n => n.Value);

        foreach (KeyValuePair<string, long> pair in countriesPopulationSorted)
        {
            string country = pair.Key;
            long totalPopulation = pair.Value;
            cities = countriesSorted[country];

            Console.WriteLine($"{country} (total population: {totalPopulation})");
            
            foreach(KeyValuePair<string, long> citiesPair in cities)
            {
                Console.WriteLine($"=>{citiesPair.Key}: {citiesPair.Value}");
            }
        }
    }
}