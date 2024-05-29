package esercizio4;

import esercizio0.Order;
import esercizio0.Product;
import esercizio0.Customer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Order> orderList = getOrdersFromData();


        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);


        List<Order> filteredOrders = orderList.stream()
                .filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
                .filter(order -> order.getCustomer() != null && order.getCustomer().getTier() == 2)
                .collect(Collectors.toList());


        List<Product> productList = filteredOrders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());


        productList.forEach(System.out::println);
    }


    private static List<Order> getOrdersFromData() {

        List<Order> orderList = new ArrayList<>();
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product(1L, "Maglietta", "Clothing", 20.0));
        products1.add(new Product(2L, "Pantaloni", "Clothing", 30.0));
        orderList.add(new Order(1L, "Pending", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20), products1, new Customer(1L, "baldo", 2)));

        List<Product> products2 = new ArrayList<>();
        products2.add(new Product(3L, "Scarpe", "Shoes", 40.0));
        products2.add(new Product(4L, "Cappello", "Accessories", 15.0));
        orderList.add(new Order(2L, "Delivered", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), products2, new Customer(2L, "Alice", 3)));

        return orderList;
    }
}
