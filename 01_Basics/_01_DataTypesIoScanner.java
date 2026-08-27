// Program to demonstrate Primitive Data Types and Scanner Input/Output in Java

import java.util.Scanner;

public class _01_DataTypesIoScanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------------------------------------------------------
        // PRIMITIVE DATA TYPES
        // -------------------------------------------------------

        byte byteVal = 100;                  // 1 byte
        short shortVal = 30000;              // 2 bytes
        int intVal = 100000;                 // 4 bytes
        long longVal = 10000000000L;         // 8 bytes, L suffix
        float floatVal = 3.14f;              // 4 bytes, f suffix
        double doubleVal = 3.14159265358;    // 8 bytes
        char charVal = 'A';                  // Single character
        boolean boolVal = true;              // true or false

        System.out.println("---- PRIMITIVE DATA TYPES ----");

        System.out.println("byte    : " + byteVal);
        System.out.println("short   : " + shortVal);
        System.out.println("int     : " + intVal);
        System.out.println("long    : " + longVal);
        System.out.println("float   : " + floatVal);
        System.out.println("double  : " + doubleVal);
        System.out.println("char    : " + charVal);
        System.out.println("boolean : " + boolVal);


        // -------------------------------------------------------
        // SCANNER INPUT
        // -------------------------------------------------------

        System.out.println("\n---- SCANNER INPUT ----");

        System.out.print("Enter an integer  : ");
        int inputInt = sc.nextInt();

        System.out.print("Enter a float     : ");
        float inputFloat = sc.nextFloat();

        System.out.print("Enter a double    : ");
        double inputDouble = sc.nextDouble();

        System.out.print("Enter a long      : ");
        long inputLong = sc.nextLong();

        sc.nextLine();      // Consume leftover newline

        System.out.print("Enter a word      : ");
        String inputWord = sc.next();

        sc.nextLine();      // Consume leftover newline

        System.out.print("Enter a sentence  : ");
        String inputLine = sc.nextLine();

        System.out.print("Enter a character : ");
        char inputChar = sc.next().charAt(0);

        System.out.print("Enter a boolean   : ");
        boolean inputBool = sc.nextBoolean();


        // -------------------------------------------------------
        // OUTPUT
        // -------------------------------------------------------

        System.out.println("\n---- OUTPUT ----");

        System.out.println("Integer   : " + inputInt);
        System.out.println("Float     : " + inputFloat);
        System.out.printf("Double    : %.3f%n", inputDouble);
        System.out.println("Long      : " + inputLong);
        System.out.println("Word      : " + inputWord);
        System.out.println("Sentence  : " + inputLine);
        System.out.println("Character : " + inputChar);
        System.out.println("Boolean   : " + inputBool);


        // -------------------------------------------------------
        // SIZE AND RANGE
        // -------------------------------------------------------

        System.out.println("\n---- SIZE & RANGE ----");

        System.out.println("Integer.MAX_VALUE : " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE : " + Integer.MIN_VALUE);
        System.out.println("Long.MAX_VALUE    : " + Long.MAX_VALUE);
        System.out.println("Float.MAX_VALUE   : " + Float.MAX_VALUE);
        System.out.println("Double.MAX_VALUE  : " + Double.MAX_VALUE);


        // -------------------------------------------------------
        // WRAPPER CLASSES
        // -------------------------------------------------------

        Integer wInt = 42;
        Double wDouble = 3.14;
        Boolean wBool = false;
        Character wChar = 'Z';

        System.out.println("\n---- WRAPPER CLASSES ----");

        System.out.println("Integer   : " + wInt);
        System.out.println("Double    : " + wDouble);
        System.out.println("Boolean   : " + wBool);
        System.out.println("Character : " + wChar);

        sc.close();
    }
}