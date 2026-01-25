package app;

import entities.Contract;
import services.ContractService;
import services.OnlinePaymentService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");

        System.out.print("Numero: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Valor do contrato: ");
        double valueOfContract = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int numberOfInstallments = sc.nextInt();

        Contract contract = new Contract(number, data, valueOfContract);
        ContractService contractService = new ContractService(new PaypalService());

        System.out.println("PARCELAS: ");
        contractService.processContract(contract, numberOfInstallments);

        sc.close();
    }
}
