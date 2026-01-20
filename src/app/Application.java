package app;

import entities.Car;
import entities.PaymentNote;
import entities.Rent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");

        System.out.print("Modelo do carro: ");
        String model = sc.nextLine();

        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime startDate = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finishDate = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();

        Car car = new Car(model);
        Rent rent = new Rent(pricePerDay,pricePerHour, startDate, finishDate);
        PaymentNote paymentNote = new PaymentNote(rent);
        System.out.println(paymentNote.showValues());
    }
}