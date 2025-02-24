package ParkingLot.code;

import ParkingLot.code.vehicletype.Bus;
import ParkingLot.code.vehicletype.Car;
import ParkingLot.code.vehicletype.Motorcycle;
import ParkingLot.code.vehicletype.Vehicle;

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
