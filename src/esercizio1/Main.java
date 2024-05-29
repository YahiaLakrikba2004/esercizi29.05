package esercizio1;

import esercizio0.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = getProduct();

        List<Product> filteredProducts = productList.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());


        filteredProducts.forEach(System.out::println);
    }


    private static List<Product> getProduct() {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product( 1L, "Book1", "Books", 120.0));
        productList.add(new Product(2L, "Book2", "Books", 90.0));
        productList.add(new Product(3L, "Book3", "Books", 150.0));
        productList.add(new Product(4L, "Book4", "Electronics", 200.0));
        return productList;
    }
}
