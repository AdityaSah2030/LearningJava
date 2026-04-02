// Program to demonstrate Strings and Arrays in Java
// Covers: String methods, StringBuilder, 1D arrays, 2D arrays, for-each

import java.util.Arrays;    // for Arrays utility methods
import java.util.Scanner;

public class _07_Strings_Arrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------------------------------------------------------
        // PART 1: STRINGS
        // In Java, String is an OBJECT (not a char array like in C)
        // Strings are IMMUTABLE — once created, cannot be changed in place
        // -------------------------------------------------------

        // ---------- STRING CREATION ----------
        String s1 = "Hello";                        // String literal (stored in String pool)
        String s2 = new String("World");            // String object (stored in heap)
        String s3 = "";                             // empty string
        String s4 = null;                           // null reference (no object)

        // ---------- STRING INPUT ----------
        System.out.print("Enter a word (no spaces): ");
        String word = sc.next();                    // reads one word

        sc.nextLine();                              // consume leftover newline

        System.out.print("Enter a full sentence  : ");
        String sentence = sc.nextLine();            // reads full line with spaces

        System.out.println("Word     : " + word);
        System.out.println("Sentence : " + sentence);

        // ---------- STRING METHODS ----------
        String str = "  Hello, Java World!  ";
        System.out.println("\n---- String Methods ----");
        System.out.println("Original            : \"" + str + "\"");
        System.out.println("length()            : " + str.length());                // total chars including spaces
        System.out.println("trim()              : \"" + str.trim() + "\"");         // remove leading/trailing spaces
        System.out.println("toUpperCase()       : " + str.trim().toUpperCase());    // all caps
        System.out.println("toLowerCase()       : " + str.trim().toLowerCase());    // all lower
        System.out.println("charAt(7)           : " + str.trim().charAt(7));        // char at index 7 → J
        System.out.println("indexOf('J')        : " + str.trim().indexOf('J'));     // first index of 'J'
        System.out.println("contains(\"Java\")    : " + str.contains("Java"));      // true
        System.out.println("startsWith(\"  He\")  : " + str.startsWith("  He"));    // true
        System.out.println("endsWith(\"!  \")     : " + str.endsWith("!  "));       // true
        System.out.println("replace('l','L')    : " + str.trim().replace('l', 'L')); // replaces all l with L
        System.out.println("substring(7,11)     : " + str.trim().substring(7, 11)); // "Java" (index 7 to 10)
        System.out.println("isEmpty()           : " + s3.isEmpty());               // true for ""
        System.out.println("isBlank()           : " + "   ".isBlank());            // true for whitespace-only (Java 11+)

        // ---------- STRING COMPARISON ----------
        System.out.println("\n---- String Comparison ----");
        String a = "apple";
        String b = "apple";
        String c = new String("apple");

        // IMPORTANT: == compares references (memory address), NOT content
        System.out.println("a == b          : " + (a == b));             // true  (same pool object)
        System.out.println("a == c          : " + (a == c));             // false (c is a new heap object)
        System.out.println("a.equals(c)     : " + a.equals(c));          // true  (compares content)
        System.out.println("a.equalsIgnoreCase(\"APPLE\") : " + a.equalsIgnoreCase("APPLE")); // true
        System.out.println("a.compareTo(\"banana\") : " + a.compareTo("banana")); // negative (a < banana)

        // ---------- STRING SPLITTING & JOINING ----------
        System.out.println("\n---- split() and join() ----");
        String csv = "Alice,Bob,Charlie,Diana";
        String[] names = csv.split(",");            // split by comma
        for (String name : names) {
            System.out.println("Name: " + name);
        }

        String joined = String.join(" | ", names);  // join array with separator
        System.out.println("Joined: " + joined);

        // ---------- STRING CONVERSION ----------
        System.out.println("\n---- String Conversion ----");
        int num = 42;
        String fromInt = String.valueOf(num);       // int → String
        int backToInt  = Integer.parseInt(fromInt); // String → int
        char[] charArr = "Hello".toCharArray();     // String → char array
        String fromArr = new String(charArr);       // char array → String

        System.out.println("int → String  : " + fromInt);
        System.out.println("String → int  : " + backToInt);
        System.out.println("char array    : " + java.util.Arrays.toString(charArr));
        System.out.println("back to String: " + fromArr);

        // ---------- STRINGBUILDER (mutable, use for string manipulation in loops) ----------
        // String concatenation in a loop creates many objects → slow
        // StringBuilder is mutable → much faster
        System.out.println("\n---- StringBuilder ----");
        StringBuilder sb = new StringBuilder();     // empty
        sb.append("Hello");                         // append
        sb.append(", ");
        sb.append("Java!");
        sb.insert(5, " World");                     // insert at index 5
        sb.replace(0, 5, "Hi");                     // replace index 0-4 with "Hi"
        sb.delete(2, 8);                            // delete chars from index 2 to 7
        sb.reverse();                               // reverse the string
        System.out.println("StringBuilder result : " + sb.toString());
        System.out.println("Length               : " + sb.length());


        // -------------------------------------------------------
        // PART 2: ARRAYS
        // Arrays in Java are OBJECTS, have fixed size, and are zero-indexed
        // -------------------------------------------------------

        // ---------- 1D ARRAY DECLARATION & INITIALIZATION ----------
        System.out.println("\n\n---- 1D Array ----");

        int[] arr1 = new int[5];                    // declare array of 5 ints (default 0)
        int[] arr2 = {10, 20, 30, 40, 50};          // declare and initialize inline
        int[] arr3;                                 // just a reference, no object yet
        arr3 = new int[]{1, 2, 3};                  // allocate later

        // ---------- ARRAY INPUT ----------
        System.out.print("Enter 5 integers: ");
        for (int i = 0; i < arr1.length; i++) {     // .length gives size (not .length() — no parentheses)
            arr1[i] = sc.nextInt();
        }

        // ---------- ARRAY OUTPUT ----------
        System.out.print("You entered: ");
        for (int val : arr1) {                      // for-each loop over array
            System.out.print(val + " ");
        }
        System.out.println();

        // ---------- ARRAY UTILITIES ----------
        System.out.println("\n---- Array Utilities (java.util.Arrays) ----");
        int[] data = {5, 3, 8, 1, 9, 2};

        System.out.println("Original : " + Arrays.toString(data));  // print array as string
        Arrays.sort(data);                                            // sort in ascending order
        System.out.println("Sorted   : " + Arrays.toString(data));
        System.out.println("Min      : " + data[0]);                 // after sorting, min is at index 0
        System.out.println("Max      : " + data[data.length - 1]);   // max is at last index

        int[] copy = Arrays.copyOf(data, data.length);               // copy entire array
        int[] partial = Arrays.copyOfRange(data, 1, 4);              // copy index 1 to 3
        System.out.println("Copy     : " + Arrays.toString(copy));
        System.out.println("Partial  : " + Arrays.toString(partial));

        System.out.println("binarySearch(8): " + Arrays.binarySearch(data, 8)); // search (array must be sorted)

        // ---------- 2D ARRAY ----------
        System.out.println("\n---- 2D Array (Matrix) ----");
        int[][] matrix = new int[2][3];             // 2 rows, 3 columns

        System.out.println("Enter elements for 2x3 matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix:");
        for (int[] row : matrix) {                  // for-each over rows
            for (int val : row) {                   // for-each over columns
                System.out.printf("%4d", val);       // right-aligned with width 4
            }
            System.out.println();
        }

        // ---------- JAGGED ARRAY (rows of different lengths — Java only) ----------
        System.out.println("\n---- Jagged Array (Java-specific) ----");
        int[][] jagged = new int[3][];              // 3 rows, columns not defined yet
        jagged[0] = new int[]{1};                   // row 0 has 1 element
        jagged[1] = new int[]{2, 3};                // row 1 has 2 elements
        jagged[2] = new int[]{4, 5, 6};             // row 2 has 3 elements

        for (int[] row : jagged) {
            System.out.println(Arrays.toString(row));
        }

        sc.close();
    }
}


/*
=============================================
STRING — KEY FACTS
=============================================

1. Strings are immutable — methods return new Strings, never modify in place
2. Use .equals() to compare content, NOT ==
3. == compares object references (memory addresses)
4. String pool: literals like "hello" are reused from pool
5. Use StringBuilder for heavy string manipulation in loops

=============================================
STRING vs STRINGBUILDER vs STRINGBUFFER
=============================================

String          → immutable, thread-safe, slow for concatenation in loops
StringBuilder   → mutable, NOT thread-safe, fast (use in single-threaded code)
StringBuffer    → mutable, thread-safe, slightly slower than StringBuilder

=============================================
ARRAY — KEY FACTS
=============================================

1. Fixed size — cannot grow or shrink after creation
2. Zero-indexed (first element at index 0)
3. .length gives size (no parentheses)
4. Default values: 0 for int/double, false for boolean, null for objects
5. ArrayIndexOutOfBoundsException if you access out-of-range index
6. Use ArrayList if you need dynamic size

C ARRAY vs JAVA ARRAY:
→ Java arrays are objects with .length
→ Java does bounds checking (throws exception)
→ C arrays are raw pointers with no bounds checking

=============================================
*/