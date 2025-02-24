package CarBookingSystem.apis;

import CarBookingSystem.components.BookingTime;
import CarBookingSystem.components.Car;
import CarBookingSystem.components.Customer;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReservationManagement {
    /*
    C
    R
    U
    D
   of Reservations
     */

    CarManagement carManagement = CarManagement.getInstance();
    public synchronized void makeReservation(Car car, BookingTime bookingTime, Customer customer) {
        if (!carManagement.checkIfAvailable(car, bookingTime.getStTime(), bookingTime.getEnTime())) {
            System.out.println("Oops, cannot make reservation");
        } else {
            // Get existing bookings if any
            Map<String, List<BookingTime>> carBookingMap = carManagement.getCarBookingMap();

            carBookingMap.putIfAbsent(car.getLicensePlate(), new ArrayList<>());
            carBookingMap.get(car.getLicensePlate()).add(bookingTime);
            System.out.println("Reservation successful!");
        }
    }

    public List<BookingTime> getAllBookings(Car car){
        if(!carManagement.getCarBookingMap().containsKey(car.getLicensePlate())){
            System.out.println("No bookings for this user");
        }
        return carManagement.getCarBookingMap().get(car.getLicensePlate());
    }

    public void deleteBooking(Car car, BookingTime bookingTime){
        List<BookingTime> bookingTimes = carManagement.getCarBookingMap().get(car.getLicensePlate());
        bookingTimes.remove(bookingTime);

        if(bookingTimes.isEmpty()){
            carManagement.getCarBookingMap().remove(car.getLicensePlate());
        }
    }

}
