using System;
using System.Collections.Generic;
using System.Linq;

class BookLibrary
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        List<Book> library = new List<Book>();

        for (int i = 1; i <= n; i++)
        {
            Book book = GetBook();
            library.Add(book);
        }

        Dictionary<string, double> authorAndPrice = new Dictionary<string, double>();

        for (int i = 0; i < library.Count; i++)
        {
            if (authorAndPrice.ContainsKey(library[i].Author))
            {
                authorAndPrice[library[i].Author] += library[i].Price;
            }
            else
            {
                authorAndPrice[library[i].Author] = library[i].Price;
            }
        }

        authorAndPrice = authorAndPrice.OrderByDescending(x => x.Value)
            .ThenBy(x => x.Key)
            .ToDictionary(x => x.Key, y => y.Value);

        foreach (KeyValuePair<string, double> pair in authorAndPrice)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value:f2}");
        }
    }

    static Book GetBook()
    {
        Book book = new Book();
        string[] split = Console.ReadLine().Split(' ');
        book.Title = split[0];
        book.Author = split[1];
        book.Publisher = split[2];
        int[] dateSplit = split[3].Split('.').Select(int.Parse).ToArray();
        book.Date = new DateTime(dateSplit[2], dateSplit[1], dateSplit[0]);
        book.ISBN = long.Parse(split[4]);
        book.Price = double.Parse(split[5]);

        return book;
    }
}

class Book
{
    public string Title { get; set; }
    public string Author { get; set; }
    public string Publisher { get; set; }
    public DateTime Date = new DateTime();
    public long ISBN { get; set; }
    public double Price { get; set; }
}