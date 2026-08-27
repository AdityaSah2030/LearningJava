// Program to demonstrate Type Casting in Java

public class _04_TypeCasting {

    public static void main(String[] args) {


        // -------------------------------------------------------
        // WIDENING CASTING
        //
        // Smaller data type → Larger data type
        // Done automatically by Java.
        // -------------------------------------------------------

        int intValue = 100;

        long longValue = intValue;
        float floatValue = longValue;
        double doubleValue = floatValue;

        System.out.println("---- Widening Casting ----");

        System.out.println("int    : " + intValue);       // 100
        System.out.println("long   : " + longValue);      // 100
        System.out.println("float  : " + floatValue);     // 100.0
        System.out.println("double : " + doubleValue);    // 100.0


        // -------------------------------------------------------
        // NARROWING CASTING
        //
        // Larger data type → Smaller data type
        // Requires explicit casting.
        // -------------------------------------------------------

        double doubleNumber = 10.75;

        int intNumber = (int) doubleNumber;

        System.out.println("\n---- Narrowing Casting ----");

        System.out.println("double : " + doubleNumber);    // 10.75
        System.out.println("int    : " + intNumber);       // 10

        // Decimal part is removed, not rounded.


        // -------------------------------------------------------
        // DATA LOSS DURING NARROWING
        // -------------------------------------------------------

        int largeNumber = 130;

        byte byteNumber = (byte) largeNumber;

        System.out.println("\n---- Data Loss ----");

        System.out.println("int  : " + largeNumber);       // 130
        System.out.println("byte : " + byteNumber);        // -126


        // -------------------------------------------------------
        // CHAR AND INTEGER
        //
        // char can be converted to int automatically.
        // int can be converted to char using explicit casting.
        // -------------------------------------------------------

        char character = 'A';

        int asciiValue = character;

        char newCharacter = (char) 66;

        System.out.println("\n---- char and int ----");

        System.out.println("Character : " + character);    // A
        System.out.println("int value  : " + asciiValue);  // 65
        System.out.println("char value : " + newCharacter); // B


        // -------------------------------------------------------
        // CASTING DURING CALCULATION
        // -------------------------------------------------------

        int a = 5;
        int b = 2;

        double result1 = a / b;
        double result2 = (double) a / b;

        System.out.println("\n---- Casting in Calculation ----");

        System.out.println("a / b           : " + result1);  // 2.0
        System.out.println("(double) a / b  : " + result2);  // 2.5


        // -------------------------------------------------------
        // EXPRESSION TYPE
        //
        // The result of an arithmetic expression depends on
        // the types of the operands.
        // -------------------------------------------------------

        byte x = 10;
        byte y = 20;

        int sum = x + y;

        System.out.println("\n---- Expression Type ----");

        System.out.println("x + y : " + sum);               // 30

        // byte + byte results in int in Java.


        // -------------------------------------------------------
        // OBJECT TYPE CASTING
        // -------------------------------------------------------

        Object value = "Java";

        String text = (String) value;

        System.out.println("\n---- Object Casting ----");

        System.out.println("Value : " + text);              // Java
    }
}