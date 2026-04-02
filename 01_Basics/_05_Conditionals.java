// Program to demonstrate all conditional statements in Java
// Covers: if, if-else, if-else-if ladder, nested if, switch-case, switch expression (Java 14+)

import java.util.Scanner;

public class _05_Conditionals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;

        // -------------------------------------------------------
        // 1. SIMPLE if
        // -------------------------------------------------------
        System.out.print("Enter a number (simple if): ");
        num = sc.nextInt();
        if (num > 0) {
            System.out.println("Number is positive.");
        }
        // If condition is false, nothing happens

        // -------------------------------------------------------
        // 2. if-else
        // -------------------------------------------------------
        System.out.print("\nEnter a number (if-else): ");
        num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println("Number is even.");
        } else {
            System.out.println("Number is odd.");
        }

        // -------------------------------------------------------
        // 3. if-else if-else LADDER
        // -------------------------------------------------------
        System.out.print("\nEnter your marks (0-100): ");
        num = sc.nextInt();
        if (num >= 90) {
            System.out.println("Grade: A+");
        } else if (num >= 75) {
            System.out.println("Grade: A");
        } else if (num >= 60) {
            System.out.println("Grade: B");
        } else if (num >= 40) {
            System.out.println("Grade: C");
        } else if (num >= 0) {
            System.out.println("Grade: Fail");
        } else {
            System.out.println("Invalid marks!");
        }

        // -------------------------------------------------------
        // 4. NESTED if
        // -------------------------------------------------------
        System.out.print("\nEnter your age: ");
        int age = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Are you an Indian citizen? (y/n): ");
        char citizen = sc.nextLine().charAt(0);

        if (citizen == 'y' || citizen == 'Y') {
            if (age >= 18) {
                System.out.println("You are eligible to vote.");
            } else {
                System.out.println("You must be at least 18 years old to vote.");
            }
        } else {
            System.out.println("You must be an Indian citizen to vote.");
        }

        // -------------------------------------------------------
        // 5. SWITCH-CASE (traditional)
        // -------------------------------------------------------
        System.out.println("\nMenu:");
        System.out.println("1. Check Even/Odd");
        System.out.println("2. Find Square");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                num = sc.nextInt();
                System.out.println(num + (num % 2 == 0 ? " is Even" : " is Odd"));
                break;  // break exits the switch block — without it, falls through to next case

            case 2:
                System.out.print("Enter a number: ");
                num = sc.nextInt();
                System.out.println("Square of " + num + " = " + (num * num));
                break;

            case 3:
                System.out.println("Exiting...");
                break;

            default:            // runs if no case matches
                System.out.println("Invalid choice! Please enter 1-3.");
                break;
        }

        // -------------------------------------------------------
        // 6. SWITCH WITH STRING (Java supports String in switch, C does not)
        // -------------------------------------------------------
        System.out.print("\nEnter a day name (e.g., Monday): ");
        sc.nextLine();  // consume newline
        String day = sc.nextLine();

        switch (day.toLowerCase()) {        // toLowerCase for case-insensitive comparison
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
                System.out.println(day + " is a Weekday.");
                break;
            case "saturday":
            case "sunday":
                System.out.println(day + " is a Weekend!");
                break;
            default:
                System.out.println("Invalid day name.");
        }

        // -------------------------------------------------------
        // 7. SWITCH EXPRESSION (Java 14+ enhanced switch — cleaner syntax)
        // -------------------------------------------------------
        // No break needed, uses -> arrow syntax, can return a value
        int dayNum = 3;
        String dayName = switch (dayNum) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid";
        };
        System.out.println("\nDay 3 is : " + dayName);  // Wednesday

        // -------------------------------------------------------
        // 8. TERNARY as inline conditional (already in Operators file, shown here for context)
        // -------------------------------------------------------
        int val = 15;
        String result = (val > 10) ? "Greater than 10" : "Not greater than 10";
        System.out.println("\n" + val + " → " + result);

        sc.close();
    }
}


/*
=============================================
SWITCH STATEMENT — KEY RULES
=============================================

1. switch works with: byte, short, int, char, String, enum
    (NOT with: long, float, double)
2. Each case must end with break, or it FALLS THROUGH to the next case
3. default handles when no case matches (like else)
4. Multiple cases can share the same code block (fall-through trick for OR logic)

FALL-THROUGH EXAMPLE:
    case "saturday":
    case "sunday":
        // this runs for both cases

=============================================
TRADITIONAL switch vs SWITCH EXPRESSION (Java 14+)
=============================================

Traditional:                    Switch Expression:
switch (x) {                    String s = switch (x) {
    case 1:                           case 1 -> "One";
        result = "One";                 case 2 -> "Two";
        break;                          default -> "Other";
    ...                           };
}

Switch Expression:
→ No fall-through (each arm is independent)
→ Can return a value
→ Must be exhaustive (all cases covered or default present)

=============================================
*/