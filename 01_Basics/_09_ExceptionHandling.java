// Program to demonstrate Exception Handling in Java
// Covers: try-catch, multiple catch, finally, throw, throws, custom exceptions

import java.util.Scanner;

// ---------- CUSTOM EXCEPTION CLASS ----------
// Extend RuntimeException (unchecked) or Exception (checked)
class InsufficientBalanceException extends Exception {
    // Constructor that passes a message to the parent Exception class
    InsufficientBalanceException(String message) {
        super(message);     // calls Exception(String message) constructor
    }
}

// Another custom exception
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class _09_ExceptionHandling {

    // -------------------------------------------------------
    // EXCEPTION HIERARCHY (simplified)
    //
    // Throwable
    // ├── Error             → JVM errors (OutOfMemoryError) — don't catch these
    // └── Exception
    //     ├── RuntimeException (Unchecked — no forced handling required)
    //     │   ├── NullPointerException
    //     │   ├── ArrayIndexOutOfBoundsException
    //     │   ├── NumberFormatException
    //     │   ├── ArithmeticException
    //     │   └── ClassCastException
    //     └── Checked Exceptions (must be handled or declared with throws)
    //         ├── IOException
    //         ├── FileNotFoundException
    //         └── our custom: InsufficientBalanceException
    // -------------------------------------------------------

    // ---------- METHOD USING throws (declares checked exception) ----------
    // Declaring throws means: "this method might throw this exception — caller must handle it"
    static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(   // throw creates and throws the exception
                "Cannot withdraw " + amount + ". Balance is only " + balance
            );
        }
        System.out.println("Withdrawal of " + amount + " successful. Remaining: " + (balance - amount));
    }

    // ---------- METHOD USING throw with unchecked exception ----------
    static void validateAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age);  // unchecked — no throws declaration needed
        }
        System.out.println("Valid age: " + age);
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------------------------------------------------------
        // 1. BASIC try-catch
        //    try   → code that might throw an exception
        //    catch → handles the exception if one occurs
        // -------------------------------------------------------
        System.out.println("---- Basic try-catch ----");
        try {
            int result = 10 / 0;        // ArithmeticException: / by zero
            System.out.println("Result: " + result);    // this line is SKIPPED
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());   // "/ by zero"
        }
        System.out.println("Program continues after catch block.\n");

        // -------------------------------------------------------
        // 2. MULTIPLE catch BLOCKS
        //    Java checks each catch in order, top to bottom
        //    Put specific exceptions BEFORE general ones
        // -------------------------------------------------------
        System.out.println("---- Multiple catch blocks ----");
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[5]);         // ArrayIndexOutOfBoundsException
            String s = null;
            s.length();                         // NullPointerException (never reached)
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null error: " + e.getMessage());
        } catch (Exception e) {
            // Catches any OTHER exception — always put this last (most general)
            System.out.println("General error: " + e.getMessage());
        }

        // -------------------------------------------------------
        // 3. MULTI-CATCH (single catch handles multiple exceptions)
        //    Use | (pipe) to list multiple exceptions (Java 7+)
        // -------------------------------------------------------
        System.out.println("\n---- Multi-catch ----");
        try {
            String input = "abc";
            int num = Integer.parseInt(input);  // NumberFormatException
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Number or Arithmetic error: " + e.getMessage());
        }

        // -------------------------------------------------------
        // 4. finally BLOCK
        //    Always runs — whether exception occurred or not
        //    Typically used to close resources (files, connections)
        // -------------------------------------------------------
        System.out.println("\n---- finally block ----");
        try {
            System.out.println("Inside try.");
            int x = 5 / 1;          // no exception here
            System.out.println("x = " + x);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("finally always runs — cleanup code goes here.");
        }

        // finally even runs when exception IS thrown:
        try {
            System.out.println("\nTrying division by zero:");
            int y = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("finally ran after exception too.");
        }

        // -------------------------------------------------------
        // 5. throw — manually throw an exception
        // -------------------------------------------------------
        System.out.println("\n---- throw (manual exception) ----");
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        try {
            validateAge(age);       // may throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }

        // -------------------------------------------------------
        // 6. throws — checked exception with custom class
        // -------------------------------------------------------
        System.out.println("\n---- throws with checked custom exception ----");
        double balance = 1000.0;
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        try {
            withdraw(balance, amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        // -------------------------------------------------------
        // 7. NESTED try-catch
        // -------------------------------------------------------
        System.out.println("\n---- Nested try-catch ----");
        try {
            System.out.println("Outer try");
            try {
                int[] a = new int[3];
                a[10] = 5;          // inner exception
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: " + e.getMessage());
                throw new ArithmeticException("Re-thrown from inner catch"); // re-throw
            }
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }

        // -------------------------------------------------------
        // 8. try-with-resources (Java 7+)
        //    Automatically closes resources (like Scanner, FileReader) that implement AutoCloseable
        //    No need for explicit finally block to close
        // -------------------------------------------------------
        System.out.println("\n---- try-with-resources (concept) ----");
        // Example pattern — actual FileReader shown in FileHandling file
        try (Scanner tempScanner = new Scanner(System.in)) {
            System.out.print("Enter a number to parse: ");
            String line = tempScanner.nextLine();
            int parsed = Integer.parseInt(line); // may throw NumberFormatException
            System.out.println("Parsed: " + parsed);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number: " + e.getMessage());
        }
        // tempScanner is automatically closed after the try block

        // -------------------------------------------------------
        // 9. COMMON EXCEPTION EXAMPLES
        // -------------------------------------------------------
        System.out.println("\n---- Common Exception Examples ----");

        // NullPointerException
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
        }

        // NumberFormatException
        try {
            int n = Integer.parseInt("hello");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }

        // StackOverflowError (from infinite recursion — Error, not Exception)
        // Shown as comment to avoid program crash:
        // badRecursion(); // would throw StackOverflowError

        sc.close();
    }
}


/*
=============================================
CHECKED vs UNCHECKED EXCEPTIONS
=============================================

CHECKED (must handle or declare):
→ Extends Exception (not RuntimeException)
→ Compiler forces you to handle these
→ Examples: IOException, SQLException, our InsufficientBalanceException
→ Use throws in method signature OR wrap in try-catch

UNCHECKED (optional handling):
→ Extends RuntimeException
→ Compiler does NOT force handling
→ Examples: NullPointerException, ArithmeticException, our InvalidAgeException
→ Usually indicates programming bugs

ERRORS (don't catch):
→ Extends Error
→ JVM-level problems — unrecoverable
→ Examples: OutOfMemoryError, StackOverflowError

=============================================
EXCEPTION METHODS
=============================================

e.getMessage()        → the error message string
e.toString()          → class name + message
e.printStackTrace()   → prints full stack trace to stderr
e.getClass().getName()→ exception class name

=============================================
throw vs throws
=============================================

throw  → used INSIDE a method to CREATE and throw an exception
        throw new SomeException("message");

throws → used in METHOD SIGNATURE to DECLARE it might throw
        void myMethod() throws IOException, SomeException { }

=============================================
*/