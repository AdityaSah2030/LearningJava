/**
 * Program 6: Recursion
 *
 * This program demonstrates the use of recursion in Java with detailed examples:
 *
 * 1. Factorial Calculation:
 *    - Uses recursion to compute n! (n factorial).
 *    - Includes a base case (n==0 or n==1) and recursive case.
 *
 * 2. Fibonacci Series:
 *    - Computes the nth Fibonacci number recursively.
 *    - Demonstrates exponential time complexity and the importance of base cases.
 *
 * 3. Tower of Hanoi:
 *    - A classic recursion problem that involves moving disks between three rods.
 *    - Illustrates multiple recursive calls and state changes.
 *
 * 4. Tracing Recursion:
 *    - Print statements help trace the sequence of recursive calls and returns.
 *
 * To compile: javac 05_recursion.java
 * To run:     java 05_recursion
 */

public class RecursionDemo {
    public static void main(String[] args) {
        System.out.println("=== Recursion Demonstration ===\n");

        // 1. Factorial Calculation
        int number = 5;
        System.out.println("Calculating Factorial of " + number + ":");
        int factorialResult = factorial(number);
        System.out.println("Factorial of " + number + " is " + factorialResult + "\n");

        // 2. Fibonacci Calculation
        int fibIndex = 7;
        System.out.println("Calculating Fibonacci number at index " + fibIndex + ":");
        int fibonacciResult = fibonacci(fibIndex);
        System.out.println("Fibonacci number at index " + fibIndex + " is " + fibonacciResult + "\n");

        // 3. Tower of Hanoi Problem
        int disks = 3;
        System.out.println("Solving Tower of Hanoi for " + disks + " disks:");
        towerOfHanoi(disks, 'A', 'C', 'B'); // A=source, C=destination, B=auxiliary
    }
    
    /**
     * Recursive method to calculate the factorial of a number.
     * Base Case: factorial(0) = 1 and factorial(1) = 1.
     * Recursive Case: factorial(n) = n * factorial(n - 1)
     * @param n non-negative integer
     * @return factorial of n
     */
    public static int factorial(int n) {
        // Trace the recursive call
        System.out.println("Entering factorial(" + n + ")");
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            System.out.println("Base case reached: factorial(" + n + ") = 1");
            return 1;
        }
        int result = n * factorial(n - 1);
        System.out.println("Computed factorial(" + n + ") = " + result);
        return result;
    }
    
    /**
     * Recursive method to compute the nth Fibonacci number.
     * Base Cases: fibonacci(0) = 0, fibonacci(1) = 1.
     * Recursive Case: fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2)
     * @param n the index in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        // Trace the recursive call
        System.out.println("Entering fibonacci(" + n + ")");
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci is not defined for negative numbers.");
        }
        if (n == 0) {
            System.out.println("Base case reached: fibonacci(0) = 0");
            return 0;
        }
        if (n == 1) {
            System.out.println("Base case reached: fibonacci(1) = 1");
            return 1;
        }
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        System.out.println("Computed fibonacci(" + n + ") = " + result);
        return result;
    }
    
    /**
     * Recursive method to solve the Tower of Hanoi problem.
     * Moves disks from the source peg to the destination peg using an auxiliary peg.
     * @param n number of disks
     * @param source the source rod identifier
     * @param destination the destination rod identifier
     * @param auxiliary the auxiliary rod identifier
     */
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n <= 0) {
            System.out.println("Number of disks must be greater than 0.");
            return;
        }
        // Base Case: When only one disk is left, move it from source to destination.
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to "
