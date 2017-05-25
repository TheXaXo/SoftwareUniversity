package BookComparatorExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(this.authors);
    }

    private void setAuthors(String... authors) {
        List<String> authorsList = new ArrayList<>();

        for (String author : authors) {
            authorsList.add(author);
        }

        this.authors = authorsList;
    }

    @Override
    public int compareTo(Book o) {
        return this.getTitle().compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}