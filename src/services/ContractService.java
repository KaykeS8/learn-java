package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContractService {

    private final OnlinePaymentService service;

    public ContractService(OnlinePaymentService service){
        this.service = service;
    }

    public void processContract(Contract contract, int months) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        double installmentValue = contract.getTotalValue() / months;

        for (int i = 0; i < months; i++) {
            double fees = service.interest(installmentValue, i+1);
            double invoiceValue = service.paymentFee(installmentValue+fees);

            LocalDate data = contract.getDate().plusMonths(i + 1);
            contract.getInstallments().add(new Installment(data, invoiceValue));
        }

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
    }
}
