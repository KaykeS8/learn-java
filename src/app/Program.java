package app;

import entities.Product;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        Map<Product, Integer> stock = new HashMap<>();

        Product p1 = new Product("TV", 1600.0);
        Product p2 = new Product("Tablet", 900.0);
        Product p3 = new Product("Smartphone", 3499.0);

        stock.put(p1, 20);
        stock.put(p2, 8);
        stock.put(p3, 14);

        System.out.println(stock);

        Product ps = new Product("TV", 1600.0);
        System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
        System.out.println(stock);


    }
}