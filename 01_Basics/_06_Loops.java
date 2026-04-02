// Program to demonstrate all loop types in Java
// Covers: for, while, do-while, enhanced for-each, nested loops, break, continue, labeled break

import java.util.Scanner;

public class _06_Loops {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------------------------------------------------------
        // 1. for LOOP — when number of iterations is known
        // -------------------------------------------------------
        System.out.println("---- for loop (1 to 5) ----");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");   // prints: 1 2 3 4 5
        }
        System.out.println();

        // -------------------------------------------------------
        // 2. while LOOP — when condition drives repetition
        // -------------------------------------------------------
        System.out.println("\n---- while loop (sum until 0) ----");
        System.out.println("Enter numbers (0 to stop):");
        int num, sum = 0;
        num = sc.nextInt();
        while (num != 0) {
            sum += num;
            num = sc.nextInt();
        }
        System.out.println("Sum = " + sum);

        // -------------------------------------------------------
        // 3. do-while LOOP — executes at least ONCE before checking condition
        // -------------------------------------------------------
        System.out.println("\n---- do-while loop (password check) ----");
        int password;
        do {
            System.out.print("Enter password (1234 to unlock): ");
            password = sc.nextInt();
        } while (password != 1234);    // condition checked AFTER the loop body runs
        System.out.println("Access granted!");

        // -------------------------------------------------------
        // 4. NESTED LOOPS — loop inside a loop
        // -------------------------------------------------------
        System.out.println("\n---- Nested loops (multiplication table 1 to 3) ----");
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                System.out.print(row * col + "\t");
            }
            System.out.println(); // newline after each row
        }

        // -------------------------------------------------------
        // 5. ENHANCED for-each LOOP (Java-specific, no C equivalent)
        //    → Used to iterate over arrays and collections
        //    → Cannot modify elements, no index access
        // -------------------------------------------------------
        System.out.println("\n---- Enhanced for-each loop ----");
        int[] nums = {10, 20, 30, 40, 50};
        for (int n : nums) {        // read as: "for each n in nums"
            System.out.print(n + " ");
        }
        System.out.println();

        String[] fruits = {"Apple", "Banana", "Mango"};
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // -------------------------------------------------------
        // 6. break — exits the loop immediately
        // -------------------------------------------------------
        System.out.println("\n---- break example ----");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Breaking at i = " + i);
                break;          // exits the loop when i hits 6
            }
            System.out.print(i + " ");  // prints 1 2 3 4 5, then breaks
        }
        System.out.println();

        // break in while loop
        System.out.println("\n---- break in while loop ----");
        int count = 0;
        while (true) {          // infinite loop — must use break to exit
            System.out.print(count + " ");
            count++;
            if (count == 5) break;
        }
        System.out.println();

        // -------------------------------------------------------
        // 7. continue — skips current iteration, continues loop
        // -------------------------------------------------------
        System.out.println("\n---- continue example (skip even numbers) ----");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;       // skip this iteration if i is even
            }
            System.out.print(i + " ");  // prints only odd numbers: 1 3 5 7 9
        }
        System.out.println();

        // -------------------------------------------------------
        // 8. LABELED break (Java-specific — break out of outer loop from inside inner loop)
        //    No direct equivalent in C
        // -------------------------------------------------------
        System.out.println("\n---- Labeled break example ----");
        outer:                              // label applied to the outer loop
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Breaking outer loop at i=" + i + ", j=" + j);
                    break outer;            // breaks out of the OUTER loop entirely
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        // -------------------------------------------------------
        // 9. LABELED continue (continue the outer loop from inside inner loop)
        // -------------------------------------------------------
        System.out.println("\n---- Labeled continue example ----");
        loop:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) continue loop;  // skips rest of inner loop, continues OUTER loop
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        // -------------------------------------------------------
        // 10. INFINITE LOOP WITH break (common pattern)
        // -------------------------------------------------------
        System.out.println("\n---- Menu loop (infinite + break) ----");
        while (true) {
            System.out.println("1. Say Hello  2. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Hello!");
            } else if (choice == 2) {
                System.out.println("Goodbye!");
                break;      // exits the infinite loop
            } else {
                System.out.println("Invalid choice, try again.");
                // loop continues for invalid input
            }
        }

        sc.close();
    }
}


/*
=============================================
LOOP COMPARISON
=============================================

for loop    → use when you know how many times to loop
while loop  → use when condition is checked BEFORE each iteration
do-while    → use when loop body must run AT LEAST ONCE
for-each    → use when iterating over arrays or collections (read-only)

=============================================
break vs continue
=============================================

break       → EXIT the loop entirely
continue    → SKIP current iteration, go to next one

=============================================
LABELED break/continue (Java only)
=============================================

label:
for (...) {         ← outer loop labeled
    for (...) {
        break label;    ← breaks outer loop
        continue label; ← continues outer loop
    }
}

Useful to avoid complex boolean flags when
breaking out of deeply nested loops.

=============================================
*/