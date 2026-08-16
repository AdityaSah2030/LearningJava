// Program to demonstrate Methods (Functions) and Recursion in Java
// Covers: void methods, return type methods, parameters, overloading, varargs, recursion

public class _08_MethodsRecursion {

    // -------------------------------------------------------
    // METHOD SYNTAX:
    // accessModifier returnType methodName(paramType param, ...) { body }
    //
    // static → method belongs to the class, not an instance
    //          (we use static here because main() is static and can only call static methods directly)
    // -------------------------------------------------------

    // ---------- 1. VOID METHOD — no return, no parameters ----------
    static void greet() {
        System.out.println("Hello! Welcome to the Methods Demo.");
    }

    // ---------- 2. VOID METHOD — no return, with parameters ----------
    static void printSum(int a, int b) {
        System.out.println("Sum of " + a + " and " + b + " = " + (a + b));
    }

    // ---------- 3. METHOD WITH RETURN VALUE ----------
    static int multiply(int a, int b) {
        return a * b;   // return sends a value back to the caller
    }

    static double areaOfCircle(double radius) {
        return Math.PI * radius * radius;   // Math.PI is a constant = 3.14159...
    }

    // ---------- 4. METHOD OVERLOADING ----------
    // Same method name, different parameter list (type or count)
    // Java decides which version to call based on arguments passed
    static int add(int a, int b) {
        System.out.println("add(int, int) called");
        return a + b;
    }

    static double add(double a, double b) {
        System.out.println("add(double, double) called");
        return a + b;
    }

    static int add(int a, int b, int c) {
        System.out.println("add(int, int, int) called");
        return a + b + c;
    }

    // ---------- 5. VARARGS (Variable-Length Arguments) ----------
    // Allows a method to accept any number of arguments (Java-specific)
    // Must be the LAST parameter; treated as an array inside the method
    static int sumAll(int... numbers) {     // int... means zero or more ints
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    // ---------- 6. PASSING ARRAYS TO METHODS ----------
    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Arrays are passed by REFERENCE — changes inside method affect original
    static void doubleEach(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;    // modifies the original array
        }
    }

    // ---------- 7. RETURNING ARRAYS FROM METHODS ----------
    static int[] generateSquares(int n) {
        int[] squares = new int[n];
        for (int i = 0; i < n; i++) {
            squares[i] = (i + 1) * (i + 1);
        }
        return squares;
    }

    // ---------- 8. RECURSION ----------
    // A method that calls ITSELF to solve a smaller version of the same problem
    // Must have a BASE CASE (stops recursion) and a RECURSIVE CASE

    // Factorial: n! = n × (n-1) × (n-2) × ... × 1
    static int factorial(int n) {
        if (n == 0 || n == 1)   // Base case: 0! = 1, 1! = 1
            return 1;
        return n * factorial(n - 1);    // Recursive case
    }

    // Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, ...
    // fib(n) = fib(n-1) + fib(n-2)
    static int fibonacci(int n) {
        if (n <= 0) return 0;   // Base case 1
        if (n == 1) return 1;   // Base case 2
        return fibonacci(n - 1) + fibonacci(n - 2);    // Recursive case
    }

    // Sum of digits: 123 → 1+2+3 = 6
    static int sumOfDigits(int n) {
        if (n == 0) return 0;       // Base case
        return (n % 10) + sumOfDigits(n / 10);  // last digit + recurse on rest
    }

    // Power: base^exp
    static double power(double base, int exp) {
        if (exp == 0) return 1;     // Base case: anything^0 = 1
        if (exp < 0)  return 1.0 / power(base, -exp);  // handle negative exponent
        return base * power(base, exp - 1);     // Recursive case
    }

    // Binary search (recursive)
    static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) return -1;  // Base case: not found
        int mid = (low + high) / 2;
        if (arr[mid] == target)  return mid;            // Base case: found
        else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, high); // search right
        else                        return binarySearch(arr, target, low, mid - 1);  // search left
    }


    // -------------------------------------------------------
    // MAIN METHOD — entry point, calls all the above methods
    // -------------------------------------------------------
    public static void main(String[] args) {

        // ---------- 1. CALLING VOID METHODS ----------
        System.out.println("---- Calling Methods ----");
        greet();
        printSum(5, 7);

        // ---------- 2. USING RETURN VALUES ----------
        int product = multiply(4, 6);
        System.out.println("Multiplication result : " + product);           // 24

        System.out.printf("Area of circle r=2.5 : %.2f%n", areaOfCircle(2.5)); // 19.63

        // ---------- 3. METHOD OVERLOADING ----------
        System.out.println("\n---- Method Overloading ----");
        System.out.println(add(3, 5));          // calls int version     → 8
        System.out.println(add(2.5, 3.5));      // calls double version  → 6.0
        System.out.println(add(1, 2, 3));       // calls 3-param version → 6

        // ---------- 4. VARARGS ----------
        System.out.println("\n---- Varargs ----");
        System.out.println("sumAll()         = " + sumAll());              // 0  (zero args)
        System.out.println("sumAll(5)        = " + sumAll(5));             // 5
        System.out.println("sumAll(1,2,3)    = " + sumAll(1, 2, 3));       // 6
        System.out.println("sumAll(1,2,3,4,5)= " + sumAll(1, 2, 3, 4, 5)); // 15

        // ---------- 5. ARRAYS IN METHODS ----------
        System.out.println("\n---- Arrays in Methods ----");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Original : ");
        printArray(arr);

        doubleEach(arr);            // array modified in place
        System.out.print("Doubled  : ");
        printArray(arr);

        int[] squares = generateSquares(5);
        System.out.print("Squares  : ");
        printArray(squares);        // 1 4 9 16 25

        // ---------- 6. RECURSION ----------
        System.out.println("\n---- Recursion ----");

        // Factorial
        for (int i = 0; i <= 7; i++) {
            System.out.println("factorial(" + i + ") = " + factorial(i));
        }

        // Fibonacci
        System.out.print("\nFibonacci (first 8): ");
        for (int i = 0; i < 8; i++) {
            System.out.print(fibonacci(i) + " ");  // 0 1 1 2 3 5 8 13
        }
        System.out.println();

        // Sum of digits
        System.out.println("\nsumOfDigits(123) = " + sumOfDigits(123));    // 6
        System.out.println("sumOfDigits(9999)= " + sumOfDigits(9999));     // 36

        // Power
        System.out.println("\npower(2, 10) = " + power(2, 10));             // 1024.0
        System.out.println("power(3, -2) = " + power(3, -2));              // 0.111...

        // Binary search
        System.out.println("\n---- Recursive Binary Search ----");
        int[] sorted = {1, 3, 5, 7, 9, 11, 13};
        int idx = binarySearch(sorted, 7, 0, sorted.length - 1);
        System.out.println("Search for 7 → index : " + idx);      // 3
        System.out.println("Search for 6 → index : " + binarySearch(sorted, 6, 0, sorted.length - 1)); // -1
    }
}


/*
=============================================
METHODS — KEY CONCEPTS
=============================================

1. static method   → belongs to class, callable without creating an object
2. instance method → belongs to object (used with OOP — covered in OOP folder)
3. void            → method returns nothing
4. return type     → method sends back a value of that type

OVERLOADING RULES:
→ Same method name, different parameter COUNT or TYPES
→ Return type alone is NOT enough to overload
→ Java picks the best matching version at compile time

VARARGS:
→ void method(int... nums) accepts 0 or more ints
→ Inside method, treated as int[]
→ Must be the LAST parameter

=============================================
RECURSION — KEY CONCEPTS
=============================================

Every recursive solution needs:
1. BASE CASE   → condition that STOPS recursion
2. RECURSIVE CASE → calls itself with a SMALLER input

Recursion = elegant but uses call stack (can cause StackOverflowError
for very deep recursion). Use iterative approach for performance-critical code.

CALL STACK for factorial(3):
factorial(3) → 3 * factorial(2)
                        ↓
               factorial(2) → 2 * factorial(1)
                                        ↓
                                factorial(1) → 1 (BASE CASE)
                                        ↑
               factorial(2) = 2 * 1 = 2
                        ↑
factorial(3) = 3 * 2 = 6

=============================================
JAVA vs C — METHODS/FUNCTIONS
=============================================

C function:     int add(int a, int b) { return a+b; }
Java method:    static int add(int a, int b) { return a+b; }

Key differences:
→ Java methods must be inside a class (no standalone functions)
→ static methods are called without creating an object
→ Java supports method overloading; C does not
→ Java has varargs (int...); C has stdarg.h (va_list, messier)
→ Java arrays passed to methods are ALWAYS passed by reference
→ Java primitives are passed by VALUE (changes don't affect original)

=============================================
*/

