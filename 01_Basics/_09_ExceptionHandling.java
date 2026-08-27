// Program to demonstrate Exception Handling in Java

import java.io.BufferedReader;
import java.io.StringReader;

public class _09_ExceptionHandling {


    // -------------------------------------------------------
    // METHOD USING throws
    //
    // throws declares that a method may produce an exception.
    // -------------------------------------------------------

    static void checkNumber(int number) throws Exception {

        if (number < 0) {
            throw new Exception("Number cannot be negative");
        }

        System.out.println("Number: " + number);
    }


    // -------------------------------------------------------
    // CUSTOM EXCEPTION
    // -------------------------------------------------------

    static class AgeException extends Exception {

        AgeException(String message) {
            super(message);
        }
    }


    static void checkAge(int age) throws AgeException {

        if (age < 18) {
            throw new AgeException("Age must be 18 or above");
        }

        System.out.println("Eligible.");
    }


    public static void main(String[] args) {


        // -------------------------------------------------------
        // 1. try-catch
        // -------------------------------------------------------

        System.out.println("---- try-catch ----");

        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }


        // -------------------------------------------------------
        // 2. MULTIPLE catch
        // -------------------------------------------------------

        System.out.println("\n---- Multiple catch ----");

        try {
            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index.");
        } catch (Exception e) {
            System.out.println("Some other exception occurred.");
        }


        // -------------------------------------------------------
        // 3. finally
        //
        // finally normally executes whether an exception occurs
        // or not.
        // -------------------------------------------------------

        System.out.println("\n---- finally ----");

        try {
            System.out.println("Inside try.");
        } catch (Exception e) {
            System.out.println("Exception occurred.");
        } finally {
            System.out.println("Finally always executes.");
        }


        // -------------------------------------------------------
        // 4. throw
        //
        // Used to explicitly throw an exception.
        // -------------------------------------------------------

        System.out.println("\n---- throw ----");

        try {
            checkNumber(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // -------------------------------------------------------
        // 5. throws
        //
        // The method declares the exception using throws.
        // The caller handles it using try-catch.
        // -------------------------------------------------------

        System.out.println("\n---- throws ----");

        try {
            checkNumber(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // -------------------------------------------------------
        // 6. CUSTOM EXCEPTION
        // -------------------------------------------------------

        System.out.println("\n---- Custom Exception ----");

        try {
            checkAge(16);
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }


        // -------------------------------------------------------
        // 7. TRY-WITH-RESOURCES
        //
        // Automatically closes resources such as streams.
        // -------------------------------------------------------

        System.out.println("\n---- Try-With-Resources ----");

        try (BufferedReader br =
                new BufferedReader(new StringReader("Hello Java"))) {

            System.out.println(br.readLine());

        } catch (Exception e) {
            System.out.println("Error reading data.");
        }
    }
}