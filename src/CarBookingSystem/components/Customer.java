package CarBookingSystem.components;

public class Customer {
    private String name;
    private String address;
    private String city;

    public Customer(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}
