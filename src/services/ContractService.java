package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContractService {

    public ContractService(){}

    public void processContract(Contract contract, int months) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Installment> installments = new ArrayList<>();

        OnlinePaymentService service = new PaypalService();
        double installmentValue = contract.getTotalValue() / months;

        for (int i = 0; i < months; i++) {
            double fees = service.interest(installmentValue, i+1);
            double invoiceValue = service.paymentFee(installmentValue+fees);

            LocalDate data = contract.getDate().plusMonths(i + 1);
            installments.add(new Installment(data, invoiceValue));
        }

        contract.setInstallments(installments);

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
    }
}
