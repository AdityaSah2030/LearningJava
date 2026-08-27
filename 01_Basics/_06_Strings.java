// Program to demonstrate Strings and commonly used String methods in Java

public class _06_Strings {

    public static void main(String[] args) {

        String str = "Hello Java";
        String name = "Aditya";


        // -------------------------------------------------------
        // LENGTH
        // -------------------------------------------------------

        System.out.println("Length: " + str.length());              // 10


        // -------------------------------------------------------
        // charAt()
        // -------------------------------------------------------

        System.out.println("Character at index 1: " + str.charAt(1)); // e


        // -------------------------------------------------------
        // substring()
        // -------------------------------------------------------

        System.out.println("Substring: " + str.substring(6));        // Java
        System.out.println("Substring: " + str.substring(0,5));      // Hello


        // -------------------------------------------------------
        // contains()
        // -------------------------------------------------------

        System.out.println("Contains Java: " + str.contains("Java")); // true


        // -------------------------------------------------------
        // equals()
        // -------------------------------------------------------

        String str1 = "Hello";
        String str2 = "Hello";

        System.out.println("str1 equals str2: " + str1.equals(str2)); // true


        // -------------------------------------------------------
        // equalsIgnoreCase()
        // -------------------------------------------------------

        System.out.println("Equals ignoring case: "+ str1.equalsIgnoreCase("hello")); // true


        // -------------------------------------------------------
        // toUpperCase() and toLowerCase()
        // -------------------------------------------------------

        System.out.println("Uppercase: " + str.toUpperCase());      // HELLO JAVA

        System.out.println("Lowercase: " + str.toLowerCase());      // hello java


        // -------------------------------------------------------
        // trim()
        //
        // Removes leading and trailing whitespace.
        // -------------------------------------------------------

        String text = "   Hello Java   ";

        System.out.println("Trimmed: '" + text.trim() + "'");       // 'Hello Java'


        // -------------------------------------------------------
        // split()
        //
        // Splits a String into an array using a delimiter/regex.
        // -------------------------------------------------------

        String fruits = "Apple,Banana,Mango";

        String[] fruitArray = fruits.split(",");

        for (String fruit : fruitArray) {
            System.out.println(fruit);
        }


        // -------------------------------------------------------
        // startsWith() and endsWith()
        // -------------------------------------------------------

        System.out.println("Starts with Hello: " + str.startsWith("Hello")); // true

        System.out.println("Ends with Java: " + str.endsWith("Java")); // true


        // -------------------------------------------------------
        // valueOf()
        //
        // Converts different data types into String.
        // -------------------------------------------------------

        int number = 100;

        String numberString = String.valueOf(number);

        System.out.println("String value: " + numberString);        // 100


        // -------------------------------------------------------
        // toCharArray()
        // -------------------------------------------------------

        char[] characters = str.toCharArray();

        System.out.println("Characters:");

        for (char ch : characters) {
            System.out.print(ch + " ");
        }

        System.out.println();


        // -------------------------------------------------------
        // isEmpty()
        //
        // Returns true when length is 0.
        // -------------------------------------------------------

        String emptyString = "";

        System.out.println("Is empty: " + emptyString.isEmpty());   // true


        // -------------------------------------------------------
        // isBlank()
        //
        // Returns true when String is empty or contains only
        // whitespace. Available since Java 11.
        // -------------------------------------------------------

        String blankString = "   ";

        System.out.println("Is blank: " + blankString.isBlank());   // true


        // -------------------------------------------------------
        // replace()
        // -------------------------------------------------------

        String replaced = str.replace('a', 'o');

        System.out.println("After replace: " + replaced);          // Hello Jovo


        // -------------------------------------------------------
        // replace() WITH STRING
        // -------------------------------------------------------

        String sentence = "I like Java";

        System.out.println(sentence.replace("Java", "Python"));    // I like Python


        // -------------------------------------------------------
        // == vs equals()
        //
        // == compares references.
        // equals() compares String contents.
        // -------------------------------------------------------

        String a = new String("Java");
        String b = new String("Java");

        System.out.println("\n---- == vs equals() ----");

        System.out.println(a == b);                                 // false
        System.out.println(a.equals(b));                            // true


        // -------------------------------------------------------
        // STRING IMMUTABILITY
        //
        // String objects cannot be changed after creation.
        // Methods such as toUpperCase(), replace(), etc. return
        // a new String instead of modifying the original.
        // -------------------------------------------------------

        String original = "hello";

        original.toUpperCase();

        System.out.println("\nOriginal: " + original);              // hello

        original = original.toUpperCase();

        System.out.println("Updated : " + original);                // HELLO
    }
}