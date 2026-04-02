// Program to demonstrate all primitive data types and Scanner-based input/output in Java

import java.util.Scanner;   // Import Scanner class for user input

public class _01_DataTypes_IO_Scanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // Create Scanner object reading from keyboard

        // -------------------------------------------------------
        // JAVA PRIMITIVE DATA TYPES - 8 total
        // -------------------------------------------------------
        // byte     → 1 byte  | range: -128 to 127
        // short    → 2 bytes | range: -32,768 to 32,767
        // int      → 4 bytes | range: -2^31 to 2^31-1
        // long     → 8 bytes | range: -2^63 to 2^63-1
        // float    → 4 bytes | single precision decimal
        // double   → 8 bytes | double precision decimal
        // char     → 2 bytes | single Unicode character
        // boolean  → 1 bit   | true or false

        // ---------- VARIABLE DECLARATIONS WITH DEFAULT VALUES ----------
        byte   byteVal    = 100;
        short  shortVal   = 30000;
        int    intVal     = 100000;
        long   longVal    = 10000000000L;    // 'L' suffix required for long literals
        float  floatVal   = 3.14f;           // 'f' suffix required for float literals
        double doubleVal  = 3.14159265358;
        char   charVal    = 'A';
        boolean boolVal   = true;

        // ---------- PRINT DEFAULT VALUES ----------
        System.out.println("---- DEFAULT VALUES ----");
        System.out.println("byte    : " + byteVal);
        System.out.println("short   : " + shortVal);
        System.out.println("int     : " + intVal);
        System.out.println("long    : " + longVal);
        System.out.println("float   : " + floatVal);
        System.out.println("double  : " + doubleVal);
        System.out.println("char    : " + charVal);
        System.out.println("boolean : " + boolVal);

        // ---------- SCANNER INPUT ----------
        System.out.println("\n---- SCANNER INPUT ----");

        System.out.print("Enter an integer   : ");
        int inputInt = sc.nextInt();            // reads int

        System.out.print("Enter a float      : ");
        float inputFloat = sc.nextFloat();      // reads float

        System.out.print("Enter a double     : ");
        double inputDouble = sc.nextDouble();   // reads double

        System.out.print("Enter a long       : ");
        long inputLong = sc.nextLong();         // reads long

        sc.nextLine();                          // consume leftover newline after nextLong()

        System.out.print("Enter a word       : ");
        String inputWord = sc.next();           // reads single word (stops at space)

        sc.nextLine();                          // consume leftover newline after next()

        System.out.print("Enter a sentence   : ");
        String inputLine = sc.nextLine();       // reads full line including spaces

        System.out.print("Enter a character  : ");
        char inputChar = sc.next().charAt(0);  // Scanner has no nextChar(), use this trick

        System.out.print("Enter a boolean    : ");
        boolean inputBool = sc.nextBoolean();  // reads true / false

        // ---------- OUTPUT ----------
        System.out.println("\n---- OUTPUT ----");
        System.out.println("Integer   : " + inputInt);
        System.out.println("Float     : " + inputFloat);
        System.out.printf ("Double    : %.3f%n", inputDouble);   // printf for formatted output
        System.out.println("Long      : " + inputLong);
        System.out.println("Word      : " + inputWord);
        System.out.println("Sentence  : " + inputLine);
        System.out.println("Character : " + inputChar);
        System.out.println("Boolean   : " + inputBool);

        // ---------- SIZE / RANGE CONSTANTS ----------
        System.out.println("\n---- SIZE & RANGE CONSTANTS ----");
        System.out.println("Integer.MAX_VALUE  : " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE  : " + Integer.MIN_VALUE);
        System.out.println("Long.MAX_VALUE     : " + Long.MAX_VALUE);
        System.out.println("Float.MAX_VALUE    : " + Float.MAX_VALUE);
        System.out.println("Double.MAX_VALUE   : " + Double.MAX_VALUE);

        // ---------- WRAPPER CLASSES (non-primitive versions) ----------
        // Each primitive has a Wrapper class — used in Collections, Generics etc.
        Integer  wInt    = 42;          // auto-boxing: int → Integer automatically
        Double   wDouble = 3.14;
        Boolean  wBool   = false;
        Character wChar  = 'Z';

        System.out.println("\n---- WRAPPER CLASSES ----");
        System.out.println("Integer  : " + wInt);
        System.out.println("Double   : " + wDouble);
        System.out.println("Boolean  : " + wBool);
        System.out.println("Character: " + wChar);

        sc.close();     // Always close Scanner after use to free resources
    }
}


/*
=============================================
QUICK REFERENCE — SCANNER METHODS
=============================================

sc.nextInt()        → reads int
sc.nextLong()       → reads long
sc.nextFloat()      → reads float
sc.nextDouble()     → reads double
sc.nextBoolean()    → reads true/false
sc.next()           → reads one word (stops at whitespace)
sc.nextLine()       → reads entire line including spaces
sc.next().charAt(0) → reads first character of input

NOTE: After nextInt(), nextDouble() etc., a leftover '\n'
    stays in the buffer. Call sc.nextLine() to consume it
    before using sc.nextLine() for string input.

=============================================
JAVA vs C — KEY DIFFERENCES
=============================================

| Feature       | C              | Java                     |
|---------------|----------------|--------------------------|
| I/O           | scanf/printf   | Scanner / System.out     |
| String type   | char array     | String (object)          |
| Boolean type  | no bool (int)  | boolean (true/false)     |
| char size     | 1 byte (ASCII) | 2 bytes (Unicode/UTF-16) |
| Long literal  | just the value | must suffix with L       |
| Float literal | just the value | must suffix with f       |

=============================================
*/