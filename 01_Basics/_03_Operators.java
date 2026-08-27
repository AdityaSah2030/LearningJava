// Program to demonstrate Operators in Java

public class _03_Operators {

    public static void main(String[] args) {

        int a = 10;
        int b = 3;


        // -------------------------------------------------------
        // ARITHMETIC OPERATORS
        // -------------------------------------------------------

        System.out.println("---- Arithmetic Operators ----");

        System.out.println("Addition       : " + (a + b));
        System.out.println("Subtraction    : " + (a - b));
        System.out.println("Multiplication : " + (a * b));
        System.out.println("Division       : " + (a / b));
        System.out.println("Modulus        : " + (a % b));


        // -------------------------------------------------------
        // RELATIONAL OPERATORS
        // -------------------------------------------------------

        System.out.println("\n---- Relational Operators ----");

        System.out.println("a == b : " + (a == b));    // false
        System.out.println("a != b : " + (a != b));    // true
        System.out.println("a > b  : " + (a > b));     // true
        System.out.println("a < b  : " + (a < b));     // false
        System.out.println("a >= b : " + (a >= b));    // true
        System.out.println("a <= b : " + (a <= b));    // false


        // -------------------------------------------------------
        // LOGICAL OPERATORS
        // -------------------------------------------------------

        boolean x = true;
        boolean y = false;

        System.out.println("\n---- Logical Operators ----");

        System.out.println("x && y : " + (x && y));    // false
        System.out.println("x || y : " + (x || y));    // true
        System.out.println("!x     : " + (!x));        // false


        // -------------------------------------------------------
        // ASSIGNMENT OPERATORS
        // -------------------------------------------------------

        int c = 10;

        System.out.println("\n---- Assignment Operators ----");

        c += 5;
        System.out.println("c += 5 : " + c);           // 15

        c -= 3;
        System.out.println("c -= 3 : " + c);           // 12

        c *= 2;
        System.out.println("c *= 2 : " + c);           // 24

        c /= 4;
        System.out.println("c /= 4 : " + c);           // 6

        c %= 3;
        System.out.println("c %= 3 : " + c);           // 0


        // -------------------------------------------------------
        // UNARY OPERATORS
        // -------------------------------------------------------

        int d = 5;

        System.out.println("\n---- Unary Operators ----");

        System.out.println("++d      : " + (++d));     // 6
        System.out.println("d++      : " + (d++));     // 6
        System.out.println("After d++: " + d);         // 7
        System.out.println("--d      : " + (--d));     // 6
        System.out.println("d--      : " + (d--));     // 6
        System.out.println("After d--: " + d);         // 5


        // -------------------------------------------------------
        // TERNARY OPERATOR
        //
        // condition ? value_if_true : value_if_false
        // -------------------------------------------------------

        System.out.println("\n---- Ternary Operator ----");

        int age = 20;

        String result = (age >= 18) ? "Adult" : "Minor";

        System.out.println("Result: " + result);        // Adult


        // -------------------------------------------------------
        // BITWISE OPERATORS
        // -------------------------------------------------------

        int p = 5;      // 5 = 0101
        int q = 3;      // 3 = 0011

        System.out.println("\n---- Bitwise Operators ----");

        System.out.println("p & q : " + (p & q));       // 1
        System.out.println("p | q : " + (p | q));       // 7
        System.out.println("p ^ q : " + (p ^ q));       // 6
        System.out.println("~p    : " + (~p));          // -6


        // -------------------------------------------------------
        // SHIFT OPERATORS
        // -------------------------------------------------------

        System.out.println("\n---- Shift Operators ----");

        System.out.println("p << 1 : " + (p << 1));     // 10
        System.out.println("p >> 1 : " + (p >> 1));     // 2
        System.out.println("p >>> 1: " + (p >>> 1));    // 2


        // -------------------------------------------------------
        // instanceof OPERATOR
        // -------------------------------------------------------

        String name = "Aditya";

        System.out.println("\n---- instanceof Operator ----");

        System.out.println("name instanceof String: " + (name instanceof String)); // true


        // -------------------------------------------------------
        // STRING CONCATENATION USING +
        // -------------------------------------------------------

        System.out.println("\n---- String Concatenation ----");

        String firstName = "Aditya";
        String lastName = "Sah";

        System.out.println(firstName + " " + lastName);
        System.out.println("Age: " + age);


        // -------------------------------------------------------
        // OPERATOR OVERLOADING
        //
        // Java does not support user-defined operator overloading.
        // However, + is used for both addition and String
        // concatenation.
        // -------------------------------------------------------

        System.out.println("\n---- + Operator ----");

        System.out.println(10 + 20);              // 30
        System.out.println("10" + 20);             // 1020
    }
}