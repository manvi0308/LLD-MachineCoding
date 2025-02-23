package ParkingLot.vehicletype;

import AIBasedGameEngine.gamestate.Cell;

public class Car extends Vehicle{
    public Car(String licensePlate){
        super(licensePlate, VehicleType.CAR);
    }
}
