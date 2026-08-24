// Program to demonstrate Hierarchical Inheritance in Java

class Vehicle {

    protected String name;
    protected String model;

    Vehicle(String name, String model) {
        this.name = name;
        this.model = model;
    }

    void startEngine() {
        System.out.println("Vehicle engine started.");
    }

    void stopEngine() {
        System.out.println("Vehicle engine stopped.");
    }
}


// ---------------------------------------------------------
// CAR CLASS
// ---------------------------------------------------------

class Car extends Vehicle {

    private int noOfDoors;

    Car(String name, String model, int noOfDoors) {

        super(name, model);

        this.noOfDoors = noOfDoors;
    }

    @Override
    void startEngine() {

        super.startEngine();

        System.out.println("Car engine started.");
    }

    void startAC() {
        System.out.println("Car AC started.");
    }

    void displayDetails() {

        System.out.println("\n---- Car Details ----");
        System.out.println("Name       : " + name);
        System.out.println("Model      : " + model);
        System.out.println("No. Doors  : " + noOfDoors);
    }
}


// ---------------------------------------------------------
// MOTORCYCLE CLASS
// ---------------------------------------------------------

class Motorcycle extends Vehicle {

    private String type;

    Motorcycle(String name, String model, String type) {

        super(name, model);

        this.type = type;
    }

    @Override
    void startEngine() {

        super.startEngine();

        System.out.println("Motorcycle engine started.");
    }

    void wheelie() {
        System.out.println("Motorcycle is performing a wheelie.");
    }

    void displayDetails() {

        System.out.println("\n---- Motorcycle Details ----");
        System.out.println("Name  : " + name);
        System.out.println("Model : " + model);
        System.out.println("Type  : " + type);
    }
}


// ---------------------------------------------------------
// MAIN CLASS
// ---------------------------------------------------------

public class _06_HierarchicalInheritance {

    public static void main(String[] args) {

        // -----------------------------------------------------
        // 1. CREATING CHILD OBJECTS
        // -----------------------------------------------------

        Car car = new Car(
            "Toyota",
            "Fortuner",
            4
        );

        Motorcycle motorcycle = new Motorcycle(
            "Yamaha",
            "R15",
            "Sports"
        );


        // -----------------------------------------------------
        // 2. CAR METHODS
        // -----------------------------------------------------

        System.out.println("---- Car ----");

        car.startEngine();
        car.startAC();
        car.stopEngine();

        car.displayDetails();


        // -----------------------------------------------------
        // 3. MOTORCYCLE METHODS
        // -----------------------------------------------------

        System.out.println("\n---- Motorcycle ----");

        motorcycle.startEngine();
        motorcycle.wheelie();
        motorcycle.stopEngine();

        motorcycle.displayDetails();


        // -----------------------------------------------------
        // 4. PARENT CLASS REFERENCE
        //
        // A parent reference can point to a child object.
        // -----------------------------------------------------

        System.out.println("\n---- Parent Reference ----");

        Vehicle vehicle1 = new Car(
            "Honda",
            "City",
            4
        );

        Vehicle vehicle2 = new Motorcycle(
            "Royal Enfield",
            "Classic 350",
            "Cruiser"
        );

        vehicle1.startEngine();
        vehicle2.startEngine();


        // -----------------------------------------------------
        // 5. instanceof OPERATOR
        //
        // Checks whether an object belongs to a particular
        // class or inheritance hierarchy.
        // -----------------------------------------------------

        System.out.println("\n---- instanceof ----");

        System.out.println(
            "vehicle1 instanceof Vehicle : "
            + (vehicle1 instanceof Vehicle)
        );

        System.out.println(
            "vehicle1 instanceof Car : "
            + (vehicle1 instanceof Car)
        );

        System.out.println(
            "vehicle1 instanceof Motorcycle : "
            + (vehicle1 instanceof Motorcycle)
        );
    }
}