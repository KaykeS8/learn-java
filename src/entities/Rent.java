package entities;

import java.time.LocalDateTime;

public class Rent {
    private Double dailyValue;
    private Double hourlyRate;
    private LocalDateTime start;
    private LocalDateTime finish;
    private final Double fixedTime = 12.0;

    public Rent(double dailyValue, double hourlyRate, LocalDateTime start, LocalDateTime finish) {
        this.dailyValue = dailyValue;
        this.hourlyRate = hourlyRate;
        this.start = start;
        this.finish = finish;
    }

    public Double getDailyValue() {
        return dailyValue;
    }

    public Double getHourlyRate() {
        return  hourlyRate;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public  LocalDateTime getFinish() {
        return finish;
    }

    public Double getFixedTime() {
        return fixedTime;
    }
}
