// Program to demonstrate Compile-Time Polymorphism in Java

class Shape {

    // -------------------------------------------------------
    // METHOD OVERLOADING
    // Same method name with different parameters
    // -------------------------------------------------------

    void draw() {
        System.out.println("Drawing a shape.");
    }

    void draw(String color) {
        System.out.println("Drawing a shape in " + color + " color.");
    }

    void draw(String color, int size) {
        System.out.println(
            "Drawing a " + color + " shape of size " + size
        );
    }
}


class Rectangle extends Shape {

    void draw(int length, int breadth) {
        System.out.println(
            "Drawing Rectangle: " + length + " x " + breadth
        );
    }
}


class Circle extends Shape {

    void draw(double radius) {
        System.out.println(
            "Drawing Circle with radius: " + radius
        );
    }
}


class Square extends Shape {

    void draw(int side) {
        System.out.println(
            "Drawing Square with side: " + side
        );
    }
}


public class _07_CompileTimePolymorphism {

    public static void main(String[] args) {

        Shape shape = new Shape();

        // -------------------------------------------------------
        // METHOD OVERLOADING
        // Compiler decides which method to call based on
        // the number and type of arguments.
        // -------------------------------------------------------

        System.out.println("---- Method Overloading ----");

        shape.draw();
        shape.draw("Red");
        shape.draw("Blue", 10);


        // -------------------------------------------------------
        // OVERLOADED METHODS IN CHILD CLASSES
        // -------------------------------------------------------

        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();
        Square square = new Square();

        rectangle.draw(10, 5);
        circle.draw(7.5);
        square.draw(6);


        // -------------------------------------------------------
        // OPERATOR OVERLOADING
        //
        // Java does NOT support user-defined operator overloading.
        //
        // However, the + operator is overloaded by Java:
        // 1. Addition of numbers
        // 2. Concatenation of strings
        // -------------------------------------------------------

        System.out.println("\n---- Operator Overloading ----");

        System.out.println(10 + 20);

        System.out.println("Area: " + 100);

        // Java does not allow us to define our own meaning for
        // operators such as +, -, *, / for custom objects.
    }
}