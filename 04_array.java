/**
 * Program 4: Array
 *
 * This program demonstrates detailed usage of arrays in Java:
 *
 * 1. One-Dimensional Arrays:
 *    - Declaration and allocation.
 *    - Initialization using both index assignment and shorthand literal.
 *    - Iteration with for and enhanced for loops.
 *    - Basic operations: sum, average, min, and max.
 *
 * 2. Multi-Dimensional Arrays:
 *    - Declaration, initialization, and iteration of a 2D array.
 *
 * 3. Arrays Utility Methods (java.util.Arrays):
 *    - Sorting an array.
 *    - Binary searching within an array.
 *    - Copying an array.
 *    - Comparing arrays for equality.
 *
 * 4. Arrays of Objects:
 *    - Creating an array of custom objects (Person) and iterating over it.
 *
 * To compile: javac 04_array.java
 * To run:     java 04_array
 */

public class ArraysDemo {
    public static void main(String[] args) {
        System.out.println("=== Arrays Demonstration ===\n");
        
        // --- 1. One-Dimensional Arrays ---
        System.out.println("1. One-Dimensional Arrays:");
        
        // Declaration and allocation (array of 5 integers, default values are 0)
        int[] numbers = new int[5];
        // Initialization using index assignment
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        
        // Alternatively, declare and initialize in one line:
        int[] moreNumbers = {5, 15, 25, 35, 45};
        
        // Iterating using a for loop:
        System.out.println("Numbers using a for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }
        System.out.println();
        
        // Iterating using enhanced for loop:
        System.out.println("MoreNumbers using enhanced for loop:");
        for (int num : moreNumbers) {
            System.out.println(num);
        }
        System.out.println();
        
        // Performing operations: sum, average, min, and max.
        int sum = 0, min = numbers[0], max = numbers[0];
        for (int num : numbers) {
            sum += num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        double average = sum / (double) numbers.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println();
        
        // --- 2. Multi-Dimensional Arrays ---
        System.out.println("2. Multi-Dimensional Arrays (2D):");
        // Declaration and initialization of a 2D array (matrix)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Accessing and iterating over a 2D array with nested loops
        System.out.println("Matrix elements:");
        for (int i = 0; i < matrix.length; i++) {
            // Each matrix[i] is a 1D array representing a row.
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();  // Newline after each row
        }
        System.out.println();
        
        // --- 3. Arrays Utility Methods ---
        System.out.println("3. Arrays Utility Methods:");
        // Demonstrating usage of java.util.Arrays for various operations
        
        // Sorting an array
        int[] unsorted = {42, 23, 16, 15, 8, 4};
        System.out.print("Unsorted array: ");
        printArray(unsorted);
        
        java.util.Arrays.sort(unsorted);
        System.out.print("Sorted array: ");
        printArray(unsorted);
        
        // Binary search for element 15 in sorted array
        int index = java.util.Arrays.binarySearch(unsorted, 15);
        System.out.println("Binary search for 15: found at index " + index);
        
        // Copying an array
        int[] copyOfUnsorted = java.util.Arrays.copyOf(unsorted, unsorted.length);
        System.out.print("Copied array: ");
        printArray(copyOfUnsorted);
        
        // Checking equality of arrays
        boolean ar
