// Program to demonstrate Inheritance in Java

class Vehicle {

    private String registrationNumber;
    protected String name;
    protected String model;

    // Parent class constructor
    Vehicle(String name, String model, String registrationNumber) {
        this.name = name;
        this.model = model;
        this.registrationNumber = registrationNumber;

        System.out.println("Vehicle constructor called");
    }

    // Getter for private variable
    String getRegistrationNumber() {
        return registrationNumber;
    }

    void startEngine() {
        System.out.println("Vehicle engine started.");
    }

    void stopEngine() {
        System.out.println("Vehicle engine stopped.");
    }
}


class Car extends Vehicle {

    private int noOfDoors;

    // Child class constructor
    Car(String name, String model, String registrationNumber, int noOfDoors) {

        super(name, model, registrationNumber);

        this.noOfDoors = noOfDoors;

        System.out.println("Car constructor called");
    }

    // Protected variables can be directly accessed
    void showVehicleDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Model : " + model);
    }

    // Private variable cannot be directly accessed
    // so we use the getter
    void showRegistrationNumber() {
        System.out.println("Registration Number : " + getRegistrationNumber());
    }

    void startAC() {
        System.out.println("Car AC started.");
    }
}


public class _04_Inheritance {

    public static void main(String[] args) {

        Car car = new Car(
            "Toyota",
            "Fortuner",
            "WB01AB1234",
            4
        );

        System.out.println("\n---- Inherited Methods ----");
        car.startEngine();
        car.stopEngine();

        System.out.println("\n---- Protected Variables ----");
        car.showVehicleDetails();

        System.out.println("\n---- Private Variable ----");
        car.showRegistrationNumber();

        System.out.println("\n---- Car Method ----");
        car.startAC();
    }
}