/**
 * Program 1: Data Types & Variables
 *
 * This program demonstrates in depth:
 * 1. Primitive Data Types:
 *    - byte, short, int, long for integer values.
 *    - float and double for floating-point numbers.
 *    - char for single characters.
 *    - boolean for logical values.
 * 2. Variable Declaration, Initialization, and Usage.
 * 3. Type Casting:
 *    - Implicit (widening conversion) and explicit (narrowing conversion).
 * 4. Wrapper Classes for each primitive type.
 * 5. Variable Scope and Lifetime within blocks.
 * 6. Defining Constants using the 'final' keyword.
 * 7. Introduction to Strings as a non-primitive yet fundamental type.
 *
 * To compile: javac 01_basics.java
 * To run:     java 01_basics
 */

public class DataTypesAndVariables {
    public static void main(String[] args) {
        // --- Primitive Data Types and Their Ranges ---
        
        // 1. Integer Types
        byte byteVar = 100;             // 8-bit signed integer (-128 to 127)
        short shortVar = 10000;         // 16-bit signed integer (-32768 to 32767)
        int intVar = 100000;            // 32-bit signed integer
        long longVar = 10000000000L;    // 64-bit signed integer, 'L' suffix for long literals
        
        // 2. Floating Point Types
        float floatVar = 3.14f;         // 32-bit floating point, 'f' suffix required
        double doubleVar = 3.14159265359; // 64-bit floating point
        
        // 3. Character Type
        char charVar = 'A';             // 16-bit Unicode character
        
        // 4. Boolean Type
        boolean boolVar = true;         // Boolean: true or false
        
        // Displaying the values of the primitive types.
        System.out.println("=== Primitive Data Types ===");
        System.out.println("Byte Value: " + byteVar);
        System.out.println("Short Value: " + shortVar);
        System.out.println("Int Value: " + intVar);
        System.out.println("Long Value: " + longVar);
        System.out.println("Float Value: " + floatVar);
        System.out.println("Double Value: " + doubleVar);
        System.out.println("Char Value: " + charVar);
        System.out.println("Boolean Value: " + boolVar);
        System.out.println();

        // --- Type Casting Examples ---
        // Implicit Casting (Widening Conversion)
        int fromByte = byteVar; // Automatically converts byte to int (no data loss)
        System.out.println("Implicit Casting (byte to int): " + fromByte);
        
        // Explicit Casting (Narrowing Conversion)
        int originalInt = 257;
        // When casting int to byte, the value may overflow.
        byte fromInt = (byte) originalInt;  // 257 % 256 equals 1 due to overflow
        System.out.println("Explicit Casting (int 257 to byte): " + fromInt);
        System.out.println();
        
        // --- Wrapper Classes ---
        // Each primitive type has an associated wrapper class.
        Integer intWrapper = Integer.valueOf(intVar);
        Double doubleWrapper = Double.valueOf(doubleVar);
        Character charWrapper = Character.valueOf(charVar);
        Boolean boolWrapper = Boolean.valueOf(boolVar);
        
        System.out.println("=== Wrapper Classes ===");
        System.out.println("Integer Wrapper: " + intWrapper);
        System.out.println("Double Wrapper: " + doubleWrapper);
        System.out.println("Character Wrapper: " + charWrapper);
        System.out.println("Boolean Wrapper: " + boolWrapper);
        System.out.println();
        
        // --- Variable Scope and Lifetime ---
        // Variables declared within a block are only available within that block.
        {
            int blockScopedVar = 50;
            System.out.println("Block Scoped Variable (inside block): " + blockScopedVar);
        }
        // The following line is commented out because blockScopedVar is not accessible here.
        // System.out.println("Block Scoped Variable (outside block): " + blockScopedVar);
        System.out.println();
        
        // --- Defining Constants ---
        // Use 'final' to declare a constant whose value cannot be changed.
        final int CONSTANT_VALUE = 100;
        System.out.println("Constant Value: " + CONSTANT_VALUE);
        System.out.println();
        
        // --- Strings: A Special Non-Primitive Type ---
        // Although not a primitive, String is one of the most essential data types in Java.
        String greeting = "Hello, Java Data Types!";
        System.out.println("String Value: " + greeting);
    }
}
