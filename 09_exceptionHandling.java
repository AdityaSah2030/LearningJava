/**
 * Exception Handling
 *
 * This program demonstrates various aspects of exception handling in Java:
 *
 * 1. Basic try-catch block: Handling ArithmeticException.
 * 2. try-catch-finally: Demonstrating cleanup code with finally.
 * 3. Multiple catch blocks: Handling different exceptions in a single try block.
 * 4. Custom Exception: Creating and throwing a custom exception (CustomAgeException).
 * 5. Rethrowing Exceptions: Catching an exception and rethrowing it to be handled at a higher level.
 *
 * To compile: javac 09_exceptionHandling.java
 * To run:     java 09_exceptionHandling
 */

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        System.out.println("=== Exception Handling Demonstration ===\n");

        // 1. Basic try-catch block: Division by zero
        try {
            int a = 10, b = 0;
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException ae) {
            System.out.println("Caught ArithmeticException: " + ae.getMessage());
        }

        System.out.println();

        // 2. try-catch-finally: Parsing integer from a string
        String numberStr = "123a"; // This will cause NumberFormatException
        try {
            int number = Integer.parseInt(numberStr);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException nfe) {
            System.out.println("Caught NumberFormatException: " + nfe.getMessage());
        } finally {
            System.out.println("Finally block executed: Clean up resources if necessary.");
        }

        System.out.println();

        // 3. Multiple catch blocks: Handling multiple exceptions in one try block
        try {
            int[] numbers = {1, 2, 3};
            // Accessing an invalid index to trigger ArrayIndexOutOfBoundsException
            System.out.println("Accessing element at index 5: " + numbers[5]);
            // This line won't execute due to the exception above.
            int value = Integer.parseInt("abc");
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + aioobe.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println("Caught NumberFormatException: " + nfe.getMessage());
        }

        System.out.println();

        // 4. Custom Exception: Checking age requirement
        try {
            checkAge(15); // Throws CustomAgeException if age is less than 18
        } catch (CustomAgeException cae) {
            System.out.println("Caught CustomAgeException: " + cae.getMessage());
        }

        System.out.println();

        // 5. Rethrowing Exceptions: Demonstrate catching and rethrowing an exception
        try {
            methodThatRethrows();
        } catch (Exception e) {
            System.out.println("Caught exception rethrown: " + e.getMessage());
        }
    }

    /**
     * Checks if the provided age is valid (i.e., 18 or older).
     * If the age is less than 18, throws a CustomAgeException.
     *
     * @param age the age to check
     * @throws CustomAgeException if age is less than 18
     */
    public static void checkAge(int age) throws CustomAgeException {
        if (age < 18) {
            throw new CustomAgeException("Age must be 18 or older. Provided age: " + age);
        } else {
            System.out.println("Age is valid: " + age);
        }
    }

    /**
     * Demonstrates rethrowing an exception.
     * This method catches a NullPointerException and then rethrows a new Exception with additional context.
     *
     * @throws Exception the rethrown exception with added context
     */
    public static void methodThatRethrows() throws Exception {
        try {
            String s = null;
            // This will cause a NullPointerException.
            s.length();
        } catch (NullPointerException npe) {
            System.out.println("Caught NullPointerException inside methodThatRethrows.");
            // Rethrow as a new Exception with additional context.
            throw new Exception("Exception rethrown from methodThatRethrows.", npe);
        }
    }
}

/**
 * Custom exception class to handle age-related errors.
 */
class CustomAgeException extends Exception {
    public CustomAgeException(String message) {
        super(message);
    }
}
