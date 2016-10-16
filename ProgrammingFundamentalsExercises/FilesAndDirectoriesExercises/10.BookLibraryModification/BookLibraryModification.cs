using System;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;

class BookLibraryModification
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        List<Book> books = new List<Book>();

        for (int i = 1; i <= n; i++)
        {
            Book book = GetBook();
            books.Add(book);
        }

        DateTime date = DateTime.ParseExact(Console.ReadLine(), "dd.MM.yyyy", CultureInfo.InvariantCulture);

        books = books
            .Where(x => x.Date >= date)
            .OrderBy(x => x.Date)
            .ThenBy(x => x.Title)
            .ToList();

        foreach (Book book in books)
        {
            Console.WriteLine($"{book.Title} -> {book.Date.ToString("dd.MM.yyyy")}");
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