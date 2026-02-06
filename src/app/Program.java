package app;

import entities.Client;

public class Program {
    public static void main(String[] args) {
        Client client1 = new Client("ana", "ana.simao@gmail.com");
        Client client2 = new Client("ana", "ana.simao@gmail.com");
//        Client client2 = new Client("joao", "joao.simao@gmail.com");


        System.out.println(client1.hashCode());
        System.out.println(client2.hashCode());
        System.out.println("----------------");
        System.out.println(client1.equals(client2));

    }
}