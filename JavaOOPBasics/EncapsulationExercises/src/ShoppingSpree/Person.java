package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.setProducts(new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalStateException("Name cannot be empty");
        }

        this.name = name;
    }

    private double getMoney() {
        return this.money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalStateException("Money cannot be negative");
        }

        this.money = money;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    private void reduceMoney(double money) {
        this.setMoney(this.getMoney() - money);
    }

    public void addProduct(Product product) {
        if (product.getCost() > this.getMoney()) {
            throw new IllegalStateException(String.format("%s can't afford %s",
                    this.getName(), product.getName()));
        }

        this.products.add(product);
        this.reduceMoney(product.getCost());
    }

    @Override
    public String toString() {
        if (this.getProducts().isEmpty()) {
            return this.getName() + " - Nothing bought";
        } else {
            StringBuilder productsToString = new StringBuilder();

            for (Product product : this.getProducts()) {
                productsToString.append(product.getName()).append(", ");
            }

            return this.getName() + " - " + productsToString.substring(0, productsToString.length() - 2);
        }
    }
}