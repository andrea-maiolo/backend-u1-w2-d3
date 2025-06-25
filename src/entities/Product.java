package entities;

import java.util.Random;

public class Product {
    public String category;
    public double price;
    private long id;
    private String name;

    public Product(String name, String category, double price) {
        Random random = new Random();
        this.id = random.nextLong();
        this.category = category;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
