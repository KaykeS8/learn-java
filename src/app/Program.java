package app;

import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Tv", 1800.0));
        products.add(new Product("Armadilha", 1800.0));
        products.add(new Product("Boneco", 1800.0));
        products.add(new Product("Notebook", 1200.0));
        products.add(new Product("Smartphone", 800.0));

        products.sort(Comparator.comparing(Product::getName));


        for (Product p : products) {
            System.out.println(p);
        }

    }
}