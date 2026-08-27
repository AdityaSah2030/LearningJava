// Program to demonstrate Arrays in Java

import java.util.Arrays;
import java.util.Scanner;

public class _07_Arrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // -------------------------------------------------------
        // 1. ARRAY DECLARATION AND INITIALIZATION
        // -------------------------------------------------------

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("---- Array ----");

        System.out.println("First element: " + numbers[0]);
        System.out.println("Third element: " + numbers[2]);

        // Array indexing starts from 0.
        // Last index = length - 1.


        // -------------------------------------------------------
        // 2. CREATING ARRAY USING new
        // -------------------------------------------------------

        int[] marks = new int[5];

        marks[0] = 85;
        marks[1] = 90;
        marks[2] = 78;
        marks[3] = 92;
        marks[4] = 88;

        System.out.println("\n---- Array using new ----");

        System.out.println(Arrays.toString(marks));


        // -------------------------------------------------------
        // 3. ARRAY LENGTH
        // -------------------------------------------------------

        System.out.println("\n---- Array Length ----");

        System.out.println("Length: " + numbers.length);       // 5


        // -------------------------------------------------------
        // 4. TRAVERSING ARRAY USING for LOOP
        // -------------------------------------------------------

        System.out.println("\n---- For Loop ----");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();


        // -------------------------------------------------------
        // 5. ENHANCED for / FOR-EACH LOOP
        // -------------------------------------------------------

        System.out.println("\n---- For-Each Loop ----");

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();


        // -------------------------------------------------------
        // 6. ARRAY INPUT
        // -------------------------------------------------------

        System.out.println("\n---- Array Input ----");

        int[] inputArray = new int[5];

        for (int i = 0; i < inputArray.length; i++) {

            System.out.print("Enter element " + i + ": ");
            inputArray[i] = sc.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(inputArray));


        // -------------------------------------------------------
        // 7. SUM AND AVERAGE OF ARRAY
        // -------------------------------------------------------

        int sum = 0;

        for (int number : inputArray) {
            sum += number;
        }

        double average = (double) sum / inputArray.length;

        System.out.println("\n---- Sum and Average ----");

        System.out.println("Sum     : " + sum);
        System.out.println("Average : " + average);


        // -------------------------------------------------------
        // 8. 2D ARRAY
        // -------------------------------------------------------

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("\n---- 2D Array ----");

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }


        // -------------------------------------------------------
        // 9. 2D ARRAY USING FOR-EACH
        // -------------------------------------------------------

        System.out.println("\n---- 2D Array using For-Each ----");

        for (int[] row : matrix) {

            for (int value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }


        // -------------------------------------------------------
        // 10. JAGGED ARRAY
        //
        // Rows can have different lengths.
        // -------------------------------------------------------

        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5},
            {6, 7, 8, 9}
        };

        System.out.println("\n---- Jagged Array ----");

        for (int[] row : jaggedArray) {

            for (int value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }


        // -------------------------------------------------------
        // 11. Arrays.toString()
        // -------------------------------------------------------

        System.out.println("\n---- Arrays.toString() ----");

        int[] arr = {5, 2, 8, 1, 3};

        System.out.println(Arrays.toString(arr));


        // -------------------------------------------------------
        // 12. Arrays.sort()
        // -------------------------------------------------------

        Arrays.sort(arr);

        System.out.println("\n---- Arrays.sort() ----");

        System.out.println(Arrays.toString(arr));              // [1, 2, 3, 5, 8]


        // -------------------------------------------------------
        // 13. Arrays.binarySearch()
        //
        // Array should be sorted before binary search.
        // -------------------------------------------------------

        int index = Arrays.binarySearch(arr, 5);

        System.out.println("\n---- Arrays.binarySearch() ----");

        System.out.println("Index of 5: " + index);             // 3


        // -------------------------------------------------------
        // 14. Arrays.copyOf()
        // -------------------------------------------------------

        int[] copiedArray = Arrays.copyOf(arr, arr.length);

        System.out.println("\n---- Arrays.copyOf() ----");

        System.out.println(Arrays.toString(copiedArray));


        // -------------------------------------------------------
        // 15. Arrays.fill()
        // -------------------------------------------------------

        int[] filledArray = new int[5];

        Arrays.fill(filledArray, 10);

        System.out.println("\n---- Arrays.fill() ----");

        System.out.println(Arrays.toString(filledArray));      // [10, 10, 10, 10, 10]


        // -------------------------------------------------------
        // 16. ARRAY DEFAULT VALUES
        //
        // When an array is created using new, its elements
        // receive default values.
        // int → 0
        // double → 0.0
        // boolean → false
        // char → '\u0000'
        // reference types → null
        // -------------------------------------------------------

        int[] defaultArray = new int[3];

        System.out.println("\n---- Default Values ----");

        System.out.println(Arrays.toString(defaultArray));     // [0, 0, 0]


        sc.close();
    }
}