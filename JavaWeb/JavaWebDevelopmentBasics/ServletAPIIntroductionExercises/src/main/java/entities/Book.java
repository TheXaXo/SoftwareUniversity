package entities;

import java.util.Date;

public class Book {
    private String id;
    private String title;
    private String author;
    private String pages;
    private Date creationDate;

    public Book(){}

    public Book(String id, String title, String author, String pages, Date creationDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.creationDate = creationDate;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPages() {
        return this.pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}