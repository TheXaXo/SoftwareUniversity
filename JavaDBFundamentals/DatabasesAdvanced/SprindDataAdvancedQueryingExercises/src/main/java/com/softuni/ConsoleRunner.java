package com.softuni;

import com.softuni.entities.Author;
import com.softuni.entities.Book;
import com.softuni.entities.Category;
import com.softuni.enums.AgeRestriction;
import com.softuni.enums.EditionType;
import com.softuni.services.AuthorServiceImpl;
import com.softuni.services.BookServiceImpl;
import com.softuni.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {
    private AuthorServiceImpl authorService;
    private BookServiceImpl bookService;
    private CategoryServiceImpl categoryService;

    @Autowired
    public ConsoleRunner(AuthorServiceImpl authorService, BookServiceImpl bookService, CategoryServiceImpl categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        seedDatabase();
        this.bookService.deleteBooksWithCopiesLessThan(300);
    }

    private void seedDatabase() throws IOException, ParseException {
        List<Author> authors = new ArrayList<>();

        BufferedReader authorsReader = new BufferedReader(new FileReader("src/main/java/com/softuni/dataForSeeding/authors.txt"));
        String line = authorsReader.readLine();

        while ((line = authorsReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authors.add(author);

            authorService.save(author);
        }

        List<Category> categories = new ArrayList<>();
        BufferedReader categoriesReader = new BufferedReader(new FileReader("src/main/java/com/softuni/dataForSeeding/categories.txt"));

        while ((line = categoriesReader.readLine()) != null) {
            Category category = new Category();
            category.setName(line);
            categories.add(category);

            categoryService.save(category);
        }

        Random random = new Random();
        BufferedReader booksReader = new BufferedReader(new FileReader("src/main/java/com/softuni/dataForSeeding/books.txt"));
        line = booksReader.readLine();

        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            int authorIndex = random.nextInt(authors.size());

            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];

            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);

            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();

            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }

            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);

            Set<Category> bookCategories = new HashSet<>();

            for (int i = 0; i < random.nextInt(categories.size()); i++) {
                int categoryIndex = random.nextInt(categories.size());
                bookCategories.add(categories.get(categoryIndex));
            }

            book.setCategories(bookCategories);

            bookService.save(book);
        }
    }
}