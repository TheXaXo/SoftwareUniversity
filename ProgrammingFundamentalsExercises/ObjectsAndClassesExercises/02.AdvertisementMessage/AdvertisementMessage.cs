using System;
using System.Collections.Generic;
using System.Linq;

class AdvertisementMessage
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        List<string> phrases = GetPhrases();
        List<string> events = GetEvents();
        List<string> author = GetAuthor();
        List<string> city = GetCity();

        Random random = new Random();

        for (int i = 1; i <= n; i++)
        {
            Console.WriteLine(phrases[random.Next(phrases.Count)] + " " + events[random.Next(events.Count)] + " " +
                                      author[random.Next(author.Count)] + " - " + city[random.Next(city.Count)]);
        }
    }

    static List<string> GetPhrases()
    {
        List<string> phrases = new List<string>();
        phrases.Add("Excellent product.");
        phrases.Add("Such a great product.");
        phrases.Add("I always use that product.");
        phrases.Add("Best product of its category.");
        phrases.Add("Exceptional product.");
        phrases.Add("I can’t live without this product.");

        return phrases;
    }

    static List<string> GetEvents()
    {
        List<string> events = new List<string>();
        events.Add("Now I feel good.");
        events.Add("I have succeeded with this product.");
        events.Add("Makes miracles. I am happy of the results!");
        events.Add("I cannot believe but now I feel awesome.");
        events.Add("Try it yourself, I am very satisfied.");
        events.Add("I feel great!");

        return events;
    }

    static List<string> GetAuthor()
    {
        List<string> author = new List<string>();
        author.Add("Diana");
        author.Add("Petya");
        author.Add("Stella");
        author.Add("Elena");
        author.Add("Katya");
        author.Add("Iva");
        author.Add("Annie");
        author.Add("Eva");

        return author;
    }

    static List<string> GetCity()
    {
        List<string> city = new List<string>();
        city.Add("Burgas");
        city.Add("Sofia");
        city.Add("Plovdiv");
        city.Add("Varna");
        city.Add("Ruse");

        return city;
    }
}