using System;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;

class BookLibraryModification
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

        DateTime date = DateTime.ParseExact(Console.ReadLine(), "dd.MM.yyyy", CultureInfo.InvariantCulture);
        library = library.Where(x => x.Date > date)
            .OrderBy(x => x.Date)
            .ThenBy(x => x.Title)
            .ToList();

        foreach (Book book in library)
        {
            Console.WriteLine($"{book.Title} -> {book.Date.Day:d2}.{book.Date.Month:d2}.{book.Date.Year}");
        }
    }

    static Book GetBook()
    {
        Book book = new Book();
        string[] split = Console.ReadLine().Split(' ');
        book.Title = split[0];
        book.Author = split[1];
        book.Publisher = split[2];

        int[] date = split[3].Split('.').Select(int.Parse).ToArray();
        book.Date = new DateTime(date[2], date[1], date[0]);
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