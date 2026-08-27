// Program to demonstrate Methods and Recursion in Java

public class _08_MethodsRecursion {


    // -------------------------------------------------------
    // METHOD WITHOUT PARAMETERS AND RETURN VALUE
    // -------------------------------------------------------

    static void greet() {
        System.out.println("Hello Java!");
    }


    // -------------------------------------------------------
    // METHOD WITH PARAMETERS
    // -------------------------------------------------------

    static void greetUser(String name) {
        System.out.println("Hello " + name);
    }


    // -------------------------------------------------------
    // METHOD WITH RETURN VALUE
    // -------------------------------------------------------

    static int add(int a, int b) {
        return a + b;
    }


    // -------------------------------------------------------
    // METHOD WITH DIFFERENT RETURN TYPE
    // -------------------------------------------------------

    static double calculateAverage(int a, int b) {
        return (double) (a + b) / 2;
    }


    // -------------------------------------------------------
    // METHOD OVERLOADING
    //
    // Same method name but different parameters.
    // -------------------------------------------------------

    static int multiply(int a, int b) {
        return a * b;
    }

    static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    static double multiply(double a, double b) {
        return a * b;
    }


    // -------------------------------------------------------
    // VARARGS
    //
    // Allows a method to accept variable number of arguments.
    // Internally, values are treated as an array.
    // -------------------------------------------------------

    static int sum(int... numbers) {

        int total = 0;

        for (int number : numbers) {
            total += number;
        }

        return total;
    }


    // -------------------------------------------------------
    // RECURSION
    //
    // A method calling itself.
    //
    // Every recursive method needs:
    // 1. Base case
    // 2. Recursive case
    // -------------------------------------------------------

    static int factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;                         // Base case
        }

        return n * factorial(n - 1);          // Recursive case
    }


    public static void main(String[] args) {


        // -------------------------------------------------------
        // CALLING METHODS
        // -------------------------------------------------------

        System.out.println("---- Methods ----");

        greet();

        greetUser("Aditya");


        // -------------------------------------------------------
        // RETURN VALUES
        // -------------------------------------------------------

        int result = add(10, 20);

        System.out.println("Addition: " + result);              // 30

        System.out.println(
            "Average: " + calculateAverage(10, 20)
        );                                                      // 15.0


        // -------------------------------------------------------
        // METHOD OVERLOADING
        // -------------------------------------------------------

        System.out.println("\n---- Method Overloading ----");

        System.out.println(multiply(2, 3));                     // 6
        System.out.println(multiply(2, 3, 4));                  // 24
        System.out.println(multiply(2.5, 4.0));                // 10.0


        // -------------------------------------------------------
        // VARARGS
        // -------------------------------------------------------

        System.out.println("\n---- Varargs ----");

        System.out.println(sum(10, 20));                        // 30
        System.out.println(sum(10, 20, 30, 40));                // 100


        // -------------------------------------------------------
        // RECURSION
        // -------------------------------------------------------

        System.out.println("\n---- Recursion ----");

        System.out.println("Factorial of 5: " + factorial(5));  // 120
    }
}