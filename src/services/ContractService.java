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

        for (int i = 1; i <= months; i++) {
            double fees = service.interest(installmentValue, i);
            double invoiceValue = service.paymentFee(installmentValue+fees);

            LocalDate data = contract.getDate().plusMonths(i);
            contract.getInstallments().add(new Installment(data, invoiceValue));
        }
;        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
    }
}
