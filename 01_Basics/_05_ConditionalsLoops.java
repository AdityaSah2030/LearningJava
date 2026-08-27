// Program to demonstrate Conditional Statements and Loops in Java

import java.util.Scanner;

public class _05_ConditionalsLoops {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // -------------------------------------------------------
        // 1. SIMPLE if
        // -------------------------------------------------------

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num > 0) {
            System.out.println("Number is positive.");
        }


        // -------------------------------------------------------
        // 2. if-else
        // -------------------------------------------------------

        System.out.print("\nEnter a number: ");
        num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("Number is even.");
        } else {
            System.out.println("Number is odd.");
        }


        // -------------------------------------------------------
        // 3. if-else-if LADDER
        // -------------------------------------------------------

        System.out.print("\nEnter your marks: ");
        int marks = sc.nextInt();

        if (marks >= 90) {
            System.out.println("Grade: A+");
        } else if (marks >= 75) {
            System.out.println("Grade: A");
        } else if (marks >= 60) {
            System.out.println("Grade: B");
        } else if (marks >= 40) {
            System.out.println("Grade: C");
        } else if (marks >= 0) {
            System.out.println("Grade: Fail");
        } else {
            System.out.println("Invalid marks.");
        }


        // -------------------------------------------------------
        // 4. NESTED if
        // -------------------------------------------------------

        System.out.print("\nEnter your age: ");
        int age = sc.nextInt();

        System.out.print("Are you a citizen? (1/0): ");
        int citizen = sc.nextInt();

        if (citizen == 1) {
            if (age >= 18) {
                System.out.println("Eligible to vote.");
            } else {
                System.out.println("You must be 18 or older.");
            }
        } else {
            System.out.println("Not eligible to vote.");
        }


        // -------------------------------------------------------
        // 5. SWITCH-CASE
        // -------------------------------------------------------

        System.out.println("\n---- Switch Case ----");

        System.out.println("1. Square");
        System.out.println("2. Cube");
        System.out.println("3. Exit");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter number: ");
                num = sc.nextInt();
                System.out.println("Square = " + (num * num));
                break;

            case 2:
                System.out.print("Enter number: ");
                num = sc.nextInt();
                System.out.println("Cube = " + (num * num * num));
                break;

            case 3:
                System.out.println("Exit selected.");
                break;

            default:
                System.out.println("Invalid choice.");
        }


        // -------------------------------------------------------
        // 6. SWITCH WITH STRING
        // -------------------------------------------------------

        System.out.print("\nEnter a day: ");
        sc.nextLine();
        String day = sc.nextLine();

        switch (day.toLowerCase()) {

            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
                System.out.println("Weekday");
                break;

            case "saturday":
            case "sunday":
                System.out.println("Weekend");
                break;

            default:
                System.out.println("Invalid day");
        }


        // -------------------------------------------------------
        // 7. SWITCH EXPRESSION
        // Java 14+
        //
        // -> does not require break and can return a value.
        // -------------------------------------------------------

        int dayNumber = 3;

        String dayName = switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid";
        };

        System.out.println("Day: " + dayName);


        // -------------------------------------------------------
        // 8. FOR LOOP
        // -------------------------------------------------------

        System.out.println("\n---- For Loop ----");

        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }

        System.out.println();


        // -------------------------------------------------------
        // 9. WHILE LOOP
        // -------------------------------------------------------

        System.out.println("\n---- While Loop ----");

        int i = 1;

        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }

        System.out.println();


        // -------------------------------------------------------
        // 10. DO-WHILE LOOP
        //
        // Executes at least once before checking the condition.
        // -------------------------------------------------------

        System.out.println("\n---- Do-While Loop ----");

        int j = 1;

        do {
            System.out.print(j + " ");
            j++;
        } while (j <= 5);

        System.out.println();


        // -------------------------------------------------------
        // 11. ENHANCED FOR / FOR-EACH LOOP
        // Used mainly with arrays and collections.
        // -------------------------------------------------------

        System.out.println("\n---- For-Each Loop ----");

        int[] numbers = {10, 20, 30, 40, 50};

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();


        // -------------------------------------------------------
        // 12. NESTED LOOPS
        // -------------------------------------------------------

        System.out.println("\n---- Nested Loops ----");

        for (int row = 1; row <= 3; row++) {

            for (int col = 1; col <= 3; col++) {
                System.out.print(row * col + "\t");
            }

            System.out.println();
        }


        // -------------------------------------------------------
        // 13. BREAK
        // Immediately exits the loop.
        // -------------------------------------------------------

        System.out.println("\n---- Break ----");

        for (int k = 1; k <= 10; k++) {

            if (k == 6) {
                break;
            }

            System.out.print(k + " ");
        }

        System.out.println();


        // -------------------------------------------------------
        // 14. CONTINUE
        // Skips the current iteration.
        // -------------------------------------------------------

        System.out.println("\n---- Continue ----");

        for (int k = 1; k <= 10; k++) {

            if (k % 2 == 0) {
                continue;
            }

            System.out.print(k + " ");
        }

        System.out.println();


        // -------------------------------------------------------
        // 15. LABELLED BREAK
        // Breaks out of the outer loop.
        // -------------------------------------------------------

        System.out.println("\n---- Labelled Break ----");

        outer:
        for (int row = 1; row <= 3; row++) {

            for (int col = 1; col <= 3; col++) {

                if (row == 2 && col == 2) {
                    break outer;
                }

                System.out.println(
                    "row = " + row + ", col = " + col
                );
            }
        }


        // -------------------------------------------------------
        // 16. LABELLED CONTINUE
        // Continues the outer loop.
        // -------------------------------------------------------

        System.out.println("\n---- Labelled Continue ----");

        outer:
        for (int row = 1; row <= 3; row++) {

            for (int col = 1; col <= 3; col++) {

                if (col == 2) {
                    continue outer;
                }

                System.out.println(
                    "row = " + row + ", col = " + col
                );
            }
        }


        // -------------------------------------------------------
        // 17. INFINITE LOOP WITH break
        // -------------------------------------------------------

        System.out.println("\n---- Infinite Loop ----");

        int count = 1;

        while (true) {

            System.out.println("Count: " + count);
            count++;

            if (count > 3) {
                break;
            }
        }


        // -------------------------------------------------------
        // 18. MULTIPLE VARIABLES IN for LOOP
        // -------------------------------------------------------

        System.out.println("\n---- Multiple Variables ----");

        for (int a = 1, b = 5; a <= 5; a++, b--) {
            System.out.println("a = " + a + ", b = " + b);
        }

        
        sc.close();
    }
}