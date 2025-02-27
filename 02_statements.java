/**
 * Program 2: Statements & Scope
 *
 * This program demonstrates:
 * 1. Conditional Statements:
 *    - if-else if-else: Used for decision-making based on conditions.
 *    - switch-case: An alternative to if-else for discrete values.
 *
 * 2. Looping Constructs:
 *    - For loop: Iterates a set number of times.
 *    - While loop: Iterates as long as a condition is true.
 *    - Do-while loop: Similar to while but guarantees at least one execution.
 *
 * 3. Block Scope:
 *    - Variables declared inside a block (delimited by {}) are only accessible within that block.
 *
 * 4. Method Scope:
 *    - Variables declared inside a method are local to that method.
 *
 * 5. Control Flow Modifiers:
 *    - break: Exits the current loop.
 *    - continue: Skips the current iteration and proceeds to the next iteration.
 *
 * To compile: javac 02_statements.java
 * To run:     java 02_statements
 */

public class StatementsAndScope {
    public static void main(String[] args) {
        System.out.println("=== Statements and Scope Demo ===\n");

        // --- Conditional Statements ---
        // Example 1: if-else if-else to determine a grade based on a score.
        int score = 75;
        System.out.println("Determining grade for score: " + score);
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
        System.out.println();

        // Example 2: switch-case to map a day number to a day name.
        int day = 3;
        String dayName;
        System.out.println("Mapping day number " + day + " to day name:");
        switch(day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }
        System.out.println("Day " + day + " is " + dayName);
        System.out.println();

        // --- Looping Constructs ---
        // For loop: Executes a block a fixed number of times.
        System.out.println("For loop demonstration:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration (for): " + i);
        }
        System.out.println();

        // While loop: Executes as long as the condition is true.
        System.out.println("While loop demonstration:");
        int count = 0;
        while (count < 5) {
            System.out.println("Count (while): " + count);
            count++;
        }
        System.out.println();

        // Do-while loop: Executes at least once, then repeats if condition is true.
        System.out.println("Do-While loop demonstration:");
        int doCount = 0;
        do {
            System.out.println("doCount (do-while): " + doCount);
            doCount++;
        } while (doCount < 5);
        System.out.println();

        // --- Block Scope ---
        // Demonstrating that a variable declared inside a block is not accessible outside it.
        {
            int blockVar = 100;
            System.out.println("Inside block: blockVar = " + blockVar);
        }
        // Uncommenting the next line would cause an error because blockVar is not visible here.
        // System.out.println("Outside block: blockVar = " + blockVar);
        System.out.println();

        // --- Method Scope ---
        // Calling a method to show that variables inside methods have local scope.
        printLocalScope();
        System.out.println();

        // --- Nested Loops with Control Flow Modifiers ---
        // Nested loops with continue: Skipping an iteration when a condition is met.
        System.out.println("Nested loop demonstration with 'continue':");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    continue; // Skip the rest of this iteration when j equals 2.
                }
                System.out.println("i: " + i + ", j: " + j);
            }
        }
        System.out.println();

        // Using break in a loop: Exiting a loop when a condition is met.
        System.out.println("Break example in a loop:");
        for (int i = 1; i <= 5; i++) {
            if (i == 4) {
                break; // Exit the loop when i equals 4.
            }
            System.out.println("i: " + i);
        }
    }

    /**
     * This method demonstrates that variables declared within a method are local to that method.
     */
    public static void printLocalScope() {
        int localVar = 50;
        System.out.println("Inside printLocalScope method, localVar = " + localVar);
    }
}
