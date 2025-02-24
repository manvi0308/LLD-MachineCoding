package CarBookingSystem;

import CarBookingSystem.apis.CarManagement;
import CarBookingSystem.apis.ReservationManagement;
import CarBookingSystem.components.BookingTime;
import CarBookingSystem.enums.CarBrand;
import CarBookingSystem.enums.CarFuel;
import CarBookingSystem.components.Car;
import CarBookingSystem.components.Customer;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

public class CarBookingDemo {
    public static void main(String[] args) {
        // Create cars
        Car car1 = new Car("Verna", CarBrand.HONDA, Year.of(2022), 4, CarFuel.CNG, "ABCD123", 700);
        Car car2 = new Car("Creta", CarBrand.HONDA, Year.of(2020), 6, CarFuel.PETROL, "ABCD125", 800);
        Car car3 = new Car("Honda", CarBrand.KIA, Year.of(2024), 4, CarFuel.DIESEL, "ABCD126", 900);

        CarManagement carManagement = CarManagement.getInstance();
        carManagement.addCar(car1);
        carManagement.addCar(car2);
        carManagement.addCar(car3);

        Customer customer1 = new Customer("Manvi", "Mansarover", "Moradabad");

        // MAKE A BOOKING
        ReservationManagement reservationManagement = new ReservationManagement();

        // FILTER CARS
        List<Car> filteredCars = carManagement.getCarByCriterion(4, CarFuel.CNG, CarBrand.MARUTI, 500);
        System.out.println(filteredCars);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                reservationManagement.makeReservation(car1, new BookingTime(LocalDateTime.now(), LocalDateTime.now().plusHours(3)), customer1);
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                reservationManagement.makeReservation(car1, new BookingTime(LocalDateTime.now(), LocalDateTime.now().plusHours(3)), customer1);
            }
        };
        t2.start();
    }
}
