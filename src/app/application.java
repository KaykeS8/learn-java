package app;

import entities.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        Scanner sc = null;

        File file = new File("/home/kayke/Documentos/shop/products.csv");
        List<Product> products = new ArrayList<>();

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] info = sc.nextLine().split(",");
                Product product = new Product(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2]));
                products.add(product);
            }

            File out = new File("/home/kayke/Documentos/shop/out");

            if(!out.exists()) {
              out.mkdir();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(out.getPath() + "/summary.csv"));) {
                for (Product product : products) {
                    bw.write(product.toString());
                    bw.newLine();
                }
                System.out.println("Relatorio gerado com sucesso!");
                System.out.println("Path: " + out.getPath() + "/summary.csv");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
