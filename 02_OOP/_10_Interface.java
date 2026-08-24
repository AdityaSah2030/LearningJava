// Program to demonstrate Abstraction using Interface

// ---------------------------------------------------------
// INTERFACE
// ---------------------------------------------------------

interface Bird {

    // By default: public static final
    int LEGS = 2;

    // By default: public abstract
    void fly();

    void eat();

    // Default method has a body
    default void sleep() {
        System.out.println("Bird sleeping");
    }

    // Static method belongs to the interface
    static void birdInfo() {
        System.out.println("Birds are living creatures.");
    }
}


// ---------------------------------------------------------
// SECOND INTERFACE
// ---------------------------------------------------------

interface Walk {

    // By default: public static final
    int LEGS = 2;

    // By default: public abstract
    void walking();

    // Default method
    default void stopWalking() {
        System.out.println("Bird stopped walking");
    }
}


// ---------------------------------------------------------
// SPARROW IMPLEMENTS MULTIPLE INTERFACES
// ---------------------------------------------------------

class Sparrow implements Bird, Walk {

    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }

    @Override
    public void walking() {
        System.out.println("Sparrow walking");
    }
}


// ---------------------------------------------------------
// CROW IMPLEMENTS MULTIPLE INTERFACES
// ---------------------------------------------------------

class Crow implements Bird, Walk {

    @Override
    public void fly() {
        System.out.println("Crow flying");
    }

    @Override
    public void eat() {
        System.out.println("Crow eating");
    }

    @Override
    public void walking() {
        System.out.println("Crow walking");
    }
}


// ---------------------------------------------------------
// MAIN CLASS
// ---------------------------------------------------------

public class _10_Interface {

    // Interface reference can accept objects of implementing classes
    public static void doBirdStuff(Bird bird) {

        bird.eat();
        bird.fly();
        bird.sleep();

        System.out.println("Legs: " + Bird.LEGS);
    }

    public static void main(String[] args) {

        // -----------------------------------------------------
        // INTERFACE CANNOT BE INSTANTIATED
        //
        // Bird bird = new Bird();   // ERROR
        // -----------------------------------------------------


        // -----------------------------------------------------
        // INTERFACE REFERENCE
        // -----------------------------------------------------

        Bird bird = new Sparrow();

        bird.eat();
        bird.fly();
        bird.sleep();


        // -----------------------------------------------------
        // REFERENCE CAN POINT TO ANOTHER IMPLEMENTING CLASS
        // -----------------------------------------------------

        bird = new Crow();

        bird.eat();
        bird.fly();


        // -----------------------------------------------------
        // DEFAULT METHOD
        // -----------------------------------------------------

        System.out.println("\n---- Default Method ----");

        bird.sleep();


        // -----------------------------------------------------
        // INTERFACE CONSTANT
        // -----------------------------------------------------

        System.out.println("\n---- Interface Constant ----");

        System.out.println("Number of Legs: " + Bird.LEGS);


        // -----------------------------------------------------
        // STATIC METHOD
        // -----------------------------------------------------
        
        System.out.println("\n---- Static Method ----");

        Bird.birdInfo();


        // -----------------------------------------------------
        // MULTIPLE INTERFACES
        // -----------------------------------------------------

        System.out.println("\n---- Multiple Interfaces ----");

        Walk walkingBird = new Sparrow();

        walkingBird.walking();
        walkingBird.stopWalking();


        // -----------------------------------------------------
        // RUNTIME POLYMORPHISM
        // -----------------------------------------------------

        System.out.println("\n---- Runtime Polymorphism ----");

        doBirdStuff(new Sparrow());

        System.out.println();

        doBirdStuff(new Crow());
    }
}