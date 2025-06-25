import entities.Customer;
import entities.Order;
import entities.Product;
import functionalInterface.Discount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Customer paperino = new Customer("paperino", 2);
        Customer topolino = new Customer("topolino", 2);
        Customer pluto = new Customer("pluto", 4);
        Customer pippo = new Customer("pippo", 1);

        Product book1 = new Product("book one", "books", 100.50);
        Product book2 = new Product("book two", "books", 200.45);
        Product book3 = new Product("book three", "books", 70.25);
        Product book4 = new Product("book four", "books", 99.67);

        Product baby1 = new Product("baby 1", "baby", 500.78);
        Product baby2 = new Product("baby 2", "baby", 234.65);
        Product baby3 = new Product("baby 3", "baby", 21.09);
        Product baby4 = new Product("baby 4", "baby", 67.49);

        Product boys1 = new Product("boys 1", "boys", 578.54);
        Product boys2 = new Product("boys 2", "boys", 23.65);
        Product boys3 = new Product("boys 3", "boys", 215.09);
        Product boys4 = new Product("boys 4", "boys", 6.49);

        Order order1 = new Order(paperino, "pending");
        Order order2 = new Order(topolino, "pending");
        Order order3 = new Order(pippo, "pending");

        List<Product> allProductsList = new ArrayList<>();
        allProductsList.add(book1);
        allProductsList.add(book2);
        allProductsList.add(book3);
        allProductsList.add(book4);
        allProductsList.add(baby1);
        allProductsList.add(baby2);
        allProductsList.add(baby3);
        allProductsList.add(baby4);
        allProductsList.add(boys1);
        allProductsList.add(boys2);
        allProductsList.add(boys3);
        allProductsList.add(boys4);

        //esercizio 1
        //lista di prodotti books con prezzo superiore a 100
        List<Product> bookOver100List = allProductsList.stream()
                .filter(product -> product.category.equals("books"))
                .filter(book -> book.price > 100).toList();

        System.out.println(bookOver100List.toString());

        order1.addToCart(book1);
        order1.addToCart(boys3);
        order1.addToCart(baby2);

        order2.addToCart(baby1);
        order2.addToCart(book3);

        order3.addToCart(boys1);
        order3.addToCart(book1);
        order3.addToCart(book4);

        System.out.println(order1.toString());

        //esercizio 2
        List<Order> allOrders = new ArrayList<>();
        allOrders.add(order1);
        allOrders.add(order2);
        allOrders.add(order3);


//        List<Order> listaOrdiniConBaby = order => look in productlist => is there a prod form category baby?
        System.out.println("--------------------HERE-------------------------------");
        allOrders.stream()
                .map(order -> order.productList)
                .map(productList -> productList.stream().filter(prod -> prod.category.equals("baby")).toList())
                .forEach(res -> System.out.println(res));
        System.out.println("--------------------HERE-------------------------------");

        //esercizio 3
        Discount tenPercent = n -> {
            double discountValue = (n * 10) / 100;
            return n - discountValue;
        };

        List<Product> discountedStuff = allProductsList.stream()
                .filter(prod -> prod.category.equals("boys"))
                .map(prod -> {
                    prod.price = tenPercent.sconto(prod.price);
                    return prod;
                })
                .toList();
        System.out.println("--------------------HERE for ex 3-------------------------------");
        System.out.println(discountedStuff);
        System.out.println("--------------------HERE for ex3-------------------------------");


        //esercizio 4
        LocalDate dataRiferimentoInizio = LocalDate.of(2025, 6, 23);
        LocalDate dataRiferimentoFine = LocalDate.of(2025, 6, 27);

        List<Order> ordiniInData = allOrders.stream()
                .filter(order -> order.customer.tier == 2)
                .filter(orderFrmTier2Customer ->
                        orderFrmTier2Customer.orderDate.isAfter(dataRiferimentoInizio) &&
                                orderFrmTier2Customer.orderDate.isBefore(dataRiferimentoFine))
                .toList();
        System.out.println(ordiniInData);

    }
}