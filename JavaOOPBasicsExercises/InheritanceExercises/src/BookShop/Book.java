package BookShop;

public class Book {
    private String title;
    private String author;
    private Double price;

    public Book(String author, String title, Double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public Book() {
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        String[] tokens = author.split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }

        this.author = author;
    }

    private Double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }

        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%nTitle: %s%nAuthor: %s%nPrice: %s%n",
                this.getClass().getSimpleName(),
                this.getTitle(),
                this.getAuthor(),
                this.getPrice());
    }
}