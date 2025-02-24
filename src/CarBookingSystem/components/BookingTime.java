package CarBookingSystem.components;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingTime {
    private LocalDateTime stTime;
    private LocalDateTime enTime;
    public BookingTime(LocalDateTime stTime, LocalDateTime enTime){
        this.stTime = stTime;
        this.enTime = enTime;
    }

    public LocalDateTime getStTime() {
        return stTime;
    }

    public LocalDateTime getEnTime() {
        return enTime;
    }
}

