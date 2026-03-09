import java.util.Scanner;

public class Address {

    private String address;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String name, String street, String city, String state, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        address = this.name + "\n" + this.street + "\n" + this.city + ", " + this.state + " " + this.zipCode;

    }

    public String formatAddress() {
        return this.name + "\n" + this.street + "\n" + this.city + ", " + this.state + " " + this.zipCode;
    }
}