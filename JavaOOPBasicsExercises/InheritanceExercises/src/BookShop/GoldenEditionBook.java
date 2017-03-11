package BookShop;

public class GoldenEditionBook extends Book {
    public GoldenEditionBook(String author, String title, Double price) {
        super(author, title, price + price * 0.3);
    }
}