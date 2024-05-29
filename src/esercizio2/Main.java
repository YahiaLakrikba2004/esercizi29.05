package esercizio2;

import esercizio0.Order;
import esercizio0.Product;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Order> orderList = getOrders();


        List<Order> filteredOrders = orderList.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Baby")))
                .collect(Collectors.toList());

        filteredOrders.forEach(System.out::println);
    }


    private static List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product(1L, "Pannolini", "Baby", 15.0));
        products1.add(new Product(2L, "Bavaglino", "Baby", 8.0));
        orderList.add(new Order(1L, "Pending", LocalDate.now(), LocalDate.now().plusDays(3), products1, null));

        List<Product> products2 = new ArrayList<>();
        products2.add(new Product(3L, "Biberon", "Food", 10.0));
        products2.add(new Product(4L, "Giocattolo", "Toys", 20.0));
        orderList.add(new Order(2L, "Delivered", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), products2, null));

        return orderList;
    }
}
