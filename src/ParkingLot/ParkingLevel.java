package ParkingLot;

import java.util.ArrayList;
import java.util.List;
import ParkingLot.vehicletype.*;
public class ParkingLevel {
    private final  int floor;
    private final List<ParkingSpot> parkingSpots;

    public ParkingLevel(int floor, int numSpots){
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);
        /*
            For each level, there may be x type of spots reserved for cars, y number of spots
            reserved for bikes, z number of spots reserved for big vehicles
         */

        double spotsForBikes = 0.50;
        double spotsForCars = 0.40;
        double spotsForTrucks = 0.10;

        int numBikes = (int) (spotsForBikes * numSpots);
        int numCars = (int) (spotsForCars * numSpots);

        for(int i = 1; i <= numBikes; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYLE));
        }

        for(int i = numBikes + 1; i <= numBikes + numCars; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for (int i = numCars + numBikes + 1; i <= numSpots; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.BUS));
        }
    }


    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isAvailable() && parkingSpot.getVehicleType() ==vehicle.getVehicleType() ){
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }

        return false;
    }
    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }
}
