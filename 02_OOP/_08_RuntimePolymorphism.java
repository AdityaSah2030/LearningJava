// Program to demonstrate Runtime Polymorphism in Java

class Shape {

    void draw() {
        System.out.println("Drawing a Shape.");
    }
}


class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Rectangle.");
    }
}


class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Circle.");
    }
}


class Square extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a Square.");
    }
}


public class _08_RuntimePolymorphism {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // METHOD OVERRIDING
        // Each child class provides its own implementation
        // of the draw() method.
        // -------------------------------------------------------

        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();
        Square square = new Square();

        System.out.println("---- Method Overriding ----");

        rectangle.draw();
        circle.draw();
        square.draw();


        // -------------------------------------------------------
        // DYNAMIC METHOD DISPATCH
        //
        // Parent class reference can refer to different
        // child class objects.
        //
        // The method that executes is decided at runtime.
        // -------------------------------------------------------

        System.out.println("\n---- Dynamic Method Dispatch ----");

        Shape shape;

        shape = new Rectangle();
        shape.draw();

        shape = new Circle();
        shape.draw();

        shape = new Square();
        shape.draw();
    }
}