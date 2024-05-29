package esercizio3;

import esercizio0.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = getProduct();


        List<Product> discountedProducts = productList.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {
                    double discountedPrice = product.getPrice() *0.9;
                    return new Product(product.getId(), product.getName(), product.getCategory(), discountedPrice);
                })
                .collect(Collectors.toList());


        discountedProducts.forEach(System.out::println);
    }

    private static List<Product> getProduct() {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Maglietta", "Boys", 20.0));
        productList.add(new Product(2L, "Pantaloni", "Boys", 30.0));
        productList.add(new Product(3L, "Scarpe", "Girls", 40.0)); // Non è nella categoria "Boys", e quindi non compare!!
        productList.add(new Product(4L, "Felpa", "Boys", 25.0));
        return productList;
    }
}
