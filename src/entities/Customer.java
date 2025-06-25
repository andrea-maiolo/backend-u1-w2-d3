package entities;

import java.util.Random;

public class Customer {
    private String name;
    private long id;
    private int tier;

    public Customer(String name, int tier) {
        this.name = name;
        Random random = new Random();
        this.id = random.nextLong();
        this.tier = tier;
    }
}
