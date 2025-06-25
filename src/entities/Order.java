package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    public List<Product> productList;
    public LocalDate orderDate;
    public Customer customer;
    private long id;
    private String status;
    private LocalDate deliveryDate;

    public Order(Customer c, String status) {
        this.customer = c;
        Random random = new Random();
        this.id = random.nextLong();
        this.status = status;
        this.orderDate = LocalDate.now();
        this.deliveryDate = LocalDate.now().plusDays(3);
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product p) {
        this.productList.add(p);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", productList=" + productList +
                ", customer=" + customer +
                '}';
    }
}
