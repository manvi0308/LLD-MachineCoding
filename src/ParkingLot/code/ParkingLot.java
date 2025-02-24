package ParkingLot.code;

import ParkingLot.code.vehicletype.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // Singleton Pattern to ensure one instance of parking lot being created
    private static ParkingLot parkingLotInstance;
    private final List<ParkingLevel> levelList;

    private ParkingLot(){
        levelList = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot();
        }

        return parkingLotInstance;
    }

    public void addLevel(ParkingLevel level){
        levelList.add(level);
    }


    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : levelList) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked successfully.");
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : levelList) {
            if (level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (ParkingLevel level : levelList) {
            level.displayAvailability();
        }
    }
}
