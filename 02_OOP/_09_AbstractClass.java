// Program to demonstrate Abstraction using Abstract Class

// ---------------------------------------------------------
// ABSTRACT CLASS
// ---------------------------------------------------------

abstract class Bird {

    // Abstract methods do not have a body
    abstract void fly();

    abstract void eat();
}


// ---------------------------------------------------------
// CHILD CLASS : SPARROW
// ---------------------------------------------------------

class Sparrow extends Bird {

    @Override
    void fly() {
        System.out.println("Sparrow flying");
    }

    @Override
    void eat() {
        System.out.println("Sparrow eating");
    }
}


// ---------------------------------------------------------
// CHILD CLASS : CROW
// ---------------------------------------------------------

class Crow extends Bird {

    @Override
    void fly() {
        System.out.println("Crow flying");
    }

    @Override
    void eat() {
        System.out.println("Crow eating");
    }
}


// ---------------------------------------------------------
// MAIN CLASS
// ---------------------------------------------------------

public class _09_AbstractClass {

    // Bird reference can accept objects of any child class
    // that extends Bird.
    public static void doBirdStuff(Bird bird) {

        bird.eat();
        bird.fly();
    }

    public static void main(String[] args) {

        // -----------------------------------------------------
        // ABSTRACT CLASS CANNOT BE INSTANTIATED
        //
        // This is NOT allowed:
        //
        // Bird bird = new Bird();
        //
        // because Bird is an abstract class.
        // -----------------------------------------------------


        // -----------------------------------------------------
        // ABSTRACT CLASS REFERENCE
        //
        // A Bird reference can point to a Sparrow object.
        // -----------------------------------------------------

        Bird bird = new Sparrow();

        bird.eat();
        bird.fly();


        // -----------------------------------------------------
        // SAME REFERENCE CAN POINT TO ANOTHER CHILD OBJECT
        // -----------------------------------------------------

        bird = new Crow();

        bird.eat();
        bird.fly();


        // -----------------------------------------------------
        // RUNTIME POLYMORPHISM
        //
        // The actual object decides which implementation
        // of the abstract methods will execute.
        // -----------------------------------------------------

        System.out.println("\n---- Runtime Polymorphism ----");

        doBirdStuff(new Sparrow());

        System.out.println();

        doBirdStuff(new Crow());
    }
}