package ParkingLot;

import ParkingLot.vehicletype.Bus;
import ParkingLot.vehicletype.Car;
import ParkingLot.vehicletype.Motorcycle;
import ParkingLot.vehicletype.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new ParkingLevel(1, 5));
        parkingLot.addLevel(new ParkingLevel(2, 6));

        Vehicle car = new Car("CAR12345");
        Vehicle bus = new Bus("BUS12345");
        Vehicle motorcycle = new Motorcycle("MOTOR12345");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bus);
        parkingLot.parkVehicle(motorcycle);

        parkingLot.displayAvailability();

        parkingLot.unparkVehicle(car);

        parkingLot.displayAvailability();


    }
}
