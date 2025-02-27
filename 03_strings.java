/**
 * Program 3: String Manipulation
 *
 * This program demonstrates detailed operations on Java Strings, including:
 * 1. String creation and immutability.
 * 2. Comparison: using '==' versus equals() and equalsIgnoreCase().
 * 3. Concatenation: using the '+' operator and concat() method.
 * 4. Basic methods: length(), charAt(), substring(), indexOf(), and lastIndexOf().
 * 5. Splitting a string into an array using split().
 * 6. Replacement operations: using replace() and replaceAll() for regex-based changes.
 * 7. Trimming whitespace with trim().
 * 8. Case conversions: using toUpperCase() and toLowerCase().
 * 9. String formatting with String.format().
 * 10. Efficient string manipulation using StringBuilder (insert, append, delete).
 *
 * To compile: 03_strings.java
 * To run:     java 03_strings
 */

public class StringManipulation {
    public static void main(String[] args) {
        System.out.println("=== Detailed String Manipulation Demo ===\n");

        // 1. String Creation and Immutability
        String literalString = "Hello, Java!";
        String objectString = new String("Hello, World!");
        System.out.println("Literal String: " + literalString);
        System.out.println("Object String: " + objectString);
        System.out.println();

        // 2. String Comparison: '==' vs. equals()
        String s1 = "Test";
        String s2 = "Test";
        String s3 = new String("Test");

        System.out.println("Comparing s1 and s2 with '==': " + (s1 == s2));  // true: same interned instance
        System.out.println("Comparing s1 and s3 with '==': " + (s1 == s3));  // false: different objects in memory
        System.out.println("Comparing s1 and s3 with equals(): " + s1.equals(s3)); // true: same content
        System.out.println("Comparing s1 and 'test' with equalsIgnoreCase(): " + s1.equalsIgnoreCase("test"));
        System.out.println();

        // 3. String Concatenation
        String part1 = "Hello";
        String part2 = "World";
        // Using '+' operator
        String concatenated = part1 + ", " + part2 + "!";
        System.out.println("Concatenated using '+': " + concatenated);
        // Using concat() method
        String concatenated2 = part1.concat(", ").concat(part2).concat("!");
        System.out.println("Concatenated using concat(): " + concatenated2);
        System.out.println();

        // 4. Basic String Methods
        String demo = "Java String Manipulation";
        System.out.println("Original string: " + demo);
        // length() returns the number of characters
        System.out.println("Length: " + demo.length());
        // charAt() returns the character at a specific index
        System.out.println("Character at index 5: " + demo.charAt(5));
        // substring() extracts a portion of the string (from index 5 to 11, exclusive)
        System.out.println("Substring (index 5 to 11): " + demo.substring(5, 11));
        // indexOf() returns the index of the first occurrence of a substring
        System.out.println("Index of 'String': " + demo.indexOf("String"));
        // lastIndexOf() returns the last occurrence of a character or substring
        System.out.println("Last index of 'a': " + demo.lastIndexOf("a"));
        System.out.println();

        // 5. Splitting a String
        String csv = "apple,banana,cherry,date";
        String[] fruits = csv.split(",");
        System.out.println("Splitting a CSV string into fruits:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        System.out.println();

        // 6. Replacement and Regular Expressions
        String original = "The rain in SPAIN stays mainly in the plain.";
        // Using replace(): simple literal replacement (replaces all occurrences of "ain" with "###")
        String replaced = original.replace("ain", "###");
        System.out.println("Original string: " + original);
        System.out.println("After replace() (\"ain\" -> \"###\"): " + replaced);
        // Using replaceAll(): uses regex to remove all vowels
        String noVowels = original.replaceAll("[AEIOUaeiou]", "");
        System.out.println("After replaceAll() removing vowels: " + noVowels);
        System.out.println();

        // 7. Trimming Whitespace
        String spaced = "   Trim me!   ";
        System.out.println("Before trim(): '" + spaced + "'");
        System.out.println("After trim(): '" + spaced.trim() + "'");
        System.out.println();

        // 8. Case Conversion
        String mixedCase = "JaVa ProGRamMing";
        System.out.println("Original: " + mixedCase);
        System.out.println("To Upper Case: " + mixedCase.toUpperCase());
        System.out.println("To Lower Case: " + mixedCase.toLowerCase());
        System.out.println();

        // 9. String Formatting
        int num = 42;
        double pi = 3.14159;
        String formatted = String.format("Formatted string -> Number: %d, PI: %.2f", num, pi);
        System.out.println(formatted);
        System.out.println();

        // 10. Efficient String Manipulation with StringBuilder
        // Since Strings are immutable, StringBuilder is used for frequent modifications.
        StringBuilder sb = new StringBuilder("Start");
        sb.append(" - middle");
        sb.append(" - end");
        System.out.println("StringBuilder after appends: " + sb.toString());
        // Insert a substring at the beginning
        sb.insert(0, "Begin: ");
        System.out.println("After insert: " + sb.toString());
        // Delete a part of the string (remove "Begin: ")
        sb.delete(0, 7);
        System.out.println("After delete: " + sb.toString());
    }
}
