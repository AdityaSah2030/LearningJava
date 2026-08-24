// Program to demonstrate Multilevel Inheritance in Java

class Vehicle {

    protected String name;
    protected String model;

    Vehicle(String name, String model) {
        this.name = name;
        this.model = model;

        System.out.println("Vehicle constructor called");
    }

    void startEngine() {
        System.out.println("Vehicle engine started.");
    }

    void displayVehicle() {
        System.out.println("Name  : " + name);
        System.out.println("Model : " + model);
    }
}


class Car extends Vehicle {

    protected int noOfDoors;

    Car(String name, String model, int noOfDoors) {

        super(name, model);

        this.noOfDoors = noOfDoors;

        System.out.println("Car constructor called");
    }

    @Override
    void startEngine() {
        super.startEngine();
        System.out.println("Car engine started.");
    }

    void startAC() {
        System.out.println("Car AC started.");
    }
}


class SportsCar extends Car {

    private int topSpeed;

    SportsCar(String name, String model, int noOfDoors, int topSpeed) {

        super(name, model, noOfDoors);

        this.topSpeed = topSpeed;

        System.out.println("SportsCar constructor called");
    }

    @Override
    void startEngine() {

        super.startEngine();

        System.out.println("Sports car engine started with launch control.");
    }

    void displaySportsCar() {

        System.out.println("\n---- Sports Car Details ----");

        // Accessing inherited protected variables
        System.out.println("Name       : " + name);
        System.out.println("Model      : " + model);
        System.out.println("No. Doors  : " + noOfDoors);

        // SportsCar's own variable
        System.out.println("Top Speed  : " + topSpeed);
    }

    void showParentData() {

        System.out.println("\n---- Using super.variable ----");

        System.out.println("Vehicle Name  : " + super.name);
        System.out.println("Vehicle Model : " + super.model);
        System.out.println("No. of Doors  : " + super.noOfDoors);
    }

    void testParentMethod() {

        System.out.println("\n---- Using super.method() ----");

        super.startEngine();
    }
}


public class _05_MultilevelInheritance {

    public static void main(String[] args) {

        System.out.println("========== Creating SportsCar ==========");

        SportsCar car = new SportsCar(
            "Porsche",
            "911 GT3",
            2,
            320
        );

        System.out.println("\n---- Inherited Methods ----");

        car.startAC();

        System.out.println("\n---- Method Overriding ----");

        car.startEngine();

        car.displaySportsCar();

        car.showParentData();

        car.testParentMethod();
    }
}