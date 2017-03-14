using System;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;

class BookLibrary
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        Dictionary<string, decimal> authorAndPrice = new Dictionary<string, decimal>();

        for (int i = 1; i <= n; i++)
        {
            Book book = GetBook();

            if (authorAndPrice.ContainsKey(book.Author))
            {
                authorAndPrice[book.Author] += book.Price;
            }
            else
            {
                authorAndPrice[book.Author] = book.Price;
            }
        }
           
        authorAndPrice = authorAndPrice
            .OrderByDescending(x => x.Value)
            .ThenBy(x => x.Key)
            .ToDictionary(x => x.Key, y => y.Value);

        foreach (KeyValuePair<string, decimal> pair in authorAndPrice)
        {
            Console.WriteLine($"{pair.Key} -> {pair.Value:f2}");
        }
    }

    static Book GetBook()
    {
        string[] split = Console.ReadLine().Split();

        Book book = new Book();
        book.Title = split[0];
        book.Author = split[1];
        book.Publisher = split[2];
        book.Date = DateTime.ParseExact(split[3], "dd.MM.yyyy", CultureInfo.InvariantCulture);
        book.ISBN = long.Parse(split[4]);
        book.Price = decimal.Parse(split[5]);

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
    public decimal Price { get; set; }
}