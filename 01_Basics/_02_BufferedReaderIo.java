// Program to demonstrate BufferedReader for user input in Java
// BufferedReader is faster than Scanner for reading large inputs
// It reads everything as String → must be manually parsed to other types

import java.io.BufferedReader;      // For BufferedReader class
import java.io.InputStreamReader;   // Wraps System.in into a Reader
import java.io.IOException;         // BufferedReader throws checked IOException

public class _02_BufferedReaderIo {

    public static void main(String[] args) throws IOException {
        // throws IOException is required — BufferedReader methods throw checked exceptions

        // ---------- SETUP ----------
        // System.in                  → raw byte stream from keyboard
        // InputStreamReader(System.in) → converts bytes to characters
        // BufferedReader(...)        → buffers characters for efficient line reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ---------- READING A STRING ----------
        System.out.print("Enter your name          : ");
        String name = br.readLine();    // readLine() reads a full line as String
        System.out.println("Hello, " + name + "!");

        // ---------- READING AN INTEGER ----------
        System.out.print("Enter an integer         : ");
        int num = Integer.parseInt(br.readLine());  // parse String → int
        System.out.println("Integer entered          : " + num);

        // ---------- READING A DOUBLE ----------
        System.out.print("Enter a double           : ");
        double d = Double.parseDouble(br.readLine());   // parse String → double
        System.out.printf("Double entered (2 dec)   : %.2f%n", d);

        // ---------- READING A FLOAT ----------
        System.out.print("Enter a float            : ");
        float f = Float.parseFloat(br.readLine());  // parse String → float
        System.out.println("Float entered            : " + f);

        // ---------- READING A LONG ----------
        System.out.print("Enter a long             : ");
        long l = Long.parseLong(br.readLine());     // parse String → long
        System.out.println("Long entered             : " + l);

        // ---------- READING A CHAR ----------
        System.out.print("Enter a character        : ");
        char c = br.readLine().charAt(0);           // read line, pick first character
        System.out.println("Character entered        : " + c);

        // ---------- READING A BOOLEAN ----------
        System.out.print("Enter true or false      : ");
        boolean b = Boolean.parseBoolean(br.readLine());    // parse String → boolean
        System.out.println("Boolean entered          : " + b);

        // ---------- SUMMARY OUTPUT ----------
        System.out.println("\n---- SUMMARY OUTPUT ----");
        System.out.println("Name      : " + name);
        System.out.println("Integer   : " + num);
        System.out.printf ("Double    : %.2f%n", d);
        System.out.println("Float     : " + f);
        System.out.println("Long      : " + l);
        System.out.println("Char      : " + c);
        System.out.println("Boolean   : " + b);

        // No explicit close needed here, but good practice:
        br.close();
    }
}


/*
=============================================
QUICK REFERENCE — PARSE METHODS
=============================================

Integer.parseInt(str)       → String to int
Long.parseLong(str)         → String to long
Float.parseFloat(str)       → String to float
Double.parseDouble(str)     → String to double
Boolean.parseBoolean(str)   → String to boolean ("true"/"false")
str.charAt(0)               → First character of a String

These are static methods on Wrapper classes.
They throw NumberFormatException if input is not valid.

=============================================
SCANNER vs BUFFEREDREADER
=============================================

| Feature              | Scanner              | BufferedReader           |
|----------------------|----------------------|--------------------------|
| Package              | java.util            | java.io                  |
| Exception            | No checked exception | Throws IOException       |
| Speed                | Slower               | Faster (buffered)        |
| Reads line           | nextLine()           | readLine()               |
| Type parsing         | Built-in (nextInt()) | Manual (parseInt())      |
| Best used for        | Simple programs      | Large/competitive input  |

TIP: For competitive programming or reading large data,
    prefer BufferedReader. For simple console apps, Scanner is fine.

=============================================
*/

