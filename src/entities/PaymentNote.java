package entities;

import java.time.Duration;

public class PaymentNote {
    private Rent rentCar;

    public PaymentNote(Rent rentCar) {
        this.rentCar = rentCar;
    }

    public double quantityOfHours() {
        Duration duration = Duration.between(rentCar.getStart(), rentCar.getFinish());
        double minutes = duration.toMinutes();
        return Math.ceil(minutes / 60);
    }

    public double basicPayment() {
        double hours = quantityOfHours();
        if (hours > rentCar.getFixedTime()) {
            return rentCar.getDailyValue() * hours;
        }
        return rentCar.getHourlyRate() * hours;
    }

    public double taxPayment() {
        double basic = basicPayment();
        if(basic > 100) {
           return basic * 0.15;
        }
        return basic * 0.2;
    }

    public double getTotalPayment(){
        return basicPayment() + taxPayment();
    }

    public String showValues() {
        return String.format(
                "FATURA:%n" +
                        "Pagamento basico: %.2f%n" +
                        "Imposto: %.2f%n" +
                        "Pagamento total: %.2f",
                basicPayment(),
                taxPayment(),
                getTotalPayment()
        );
    }
}
