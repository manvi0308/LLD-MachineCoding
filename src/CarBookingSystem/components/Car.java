package CarBookingSystem.components;

import CarBookingSystem.enums.CarBrand;
import CarBookingSystem.enums.CarFuel;

import java.time.Year;

public class Car {
    private final String model;
    private final CarBrand brand;
    private final Year yearOfManufacturing;
    private final int numberOfSeats;
    private final CarFuel fuel;
    private final String licensePlate; // PRIMARY KEY
    private  double pricePerHour;
    public String getLicensePlate() {
        return licensePlate;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Car(String model, CarBrand brand, Year yearOfManufacturing, int numberOfSeats, CarFuel fuel, String licensePlate, double pricePerHour) {
        this.model = model;
        this.brand = brand;
        this.yearOfManufacturing = yearOfManufacturing;
        this.numberOfSeats = numberOfSeats;
        this.fuel = fuel;
        this.licensePlate = licensePlate;

    }

    public String getModel() {
        return model;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public Year getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public CarFuel getFuel() {
        return fuel;
    }
}
