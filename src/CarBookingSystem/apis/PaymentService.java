package CarBookingSystem.apis;

import CarBookingSystem.components.Car;

public class PaymentService {
    public void pay(Car car, double amount, int numberOfDays){
        if(amount == (numberOfDays * car.getPricePerHour() * 12)){
            System.out.println("Payment Successful");
        }else{
            System.out.println("Payment not Successful");
        }
    }
}
