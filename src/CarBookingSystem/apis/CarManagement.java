package CarBookingSystem.apis;

import CarBookingSystem.components.BookingTime;
import CarBookingSystem.components.Car;
import CarBookingSystem.enums.CarBrand;
import CarBookingSystem.enums.CarFuel;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CarManagement {
    private final Set<Car> allCars = new HashSet<>();
    private final Map<String, List<BookingTime>> carBookingMap = new HashMap<>();
    private static volatile CarManagement carManagement; // Thread-safe Singleton

    private CarManagement() { } // Private constructor

    public static CarManagement getInstance() {
        if (carManagement == null) {
            synchronized (CarManagement.class) {
                if (carManagement == null) {
                    carManagement = new CarManagement();
                }
            }
        }
        return carManagement;
    }

    public void addCar(Car car) {
        allCars.add(car);
    }

    public void removeCar(Car car) {
        allCars.remove(car);
        carBookingMap.remove(car.getLicensePlate()); // Remove bookings when a car is removed
    }

    public Set<Car> getAllCars() {
        return allCars;
    }

    public Map<String, List<BookingTime>> getCarBookingMap() {
        return carBookingMap;
    }

    public List<Car> getCarByCriterion(int seatCount, CarFuel fuel, CarBrand brand, double price) {
        return allCars.stream()
                .filter(car -> car.getNumberOfSeats() >= seatCount)
                .filter(car -> car.getFuel().equals(fuel))
                .filter(car -> car.getBrand().equals(brand))
                .filter(car -> car.getPricePerHour() <= price)
                .collect(Collectors.toList());
    }

    public boolean checkIfAvailable(Car car, LocalDateTime stDate, LocalDateTime enDate) {
        if (!carBookingMap.containsKey(car.getLicensePlate())) {
            return true; // Car has no bookings, so it's available
        }

        for (BookingTime bt : carBookingMap.get(car.getLicensePlate())) {
            // Check if booking overlaps with an existing one
            if (!(enDate.isBefore(bt.getStTime()) || stDate.isAfter(bt.getEnTime()))) {
                return false; // Overlapping booking found, car is NOT available
            }
        }

        return true; // No overlap found, car is available
    }



    public void removeBooking(Car car, BookingTime bookingTime) {
        if (carBookingMap.containsKey(car.getLicensePlate())) {
            List<BookingTime> bookings = carBookingMap.get(car.getLicensePlate());
            bookings.remove(bookingTime);

            if (bookings.isEmpty()) {
                carBookingMap.remove(car.getLicensePlate()); // Remove the key if no more bookings
            }
        }
    }
}
