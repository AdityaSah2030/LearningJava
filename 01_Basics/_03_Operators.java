// Program to demonstrate all types of operators in Java
// Mirrors C operators with Java-specific notes

public class _03_Operators {

    public static void main(String[] args) {

        int a = 10, b = 3;

        // -------------------------------------------------------
        // 1. ARITHMETIC OPERATORS
        // -------------------------------------------------------
        System.out.println("---- Arithmetic Operators ----");
        System.out.println("a + b  = " + (a + b));           // 13  → addition
        System.out.println("a - b  = " + (a - b));           // 7   → subtraction
        System.out.println("a * b  = " + (a * b));           // 30  → multiplication
        System.out.println("a / b  = " + (a / b));           // 3   → integer division (truncates)
        System.out.println("a % b  = " + (a % b));           // 1   → modulus (remainder)

        // Floating point division — cast to double first
        System.out.printf("a / b (double) = %.2f%n", (double) a / b);  // 3.33

        // -------------------------------------------------------
        // 2. RELATIONAL (COMPARISON) OPERATORS
        // -------------------------------------------------------
        System.out.println("\n---- Relational Operators ----");
        System.out.println("a > b  : " + (a > b));           // true
        System.out.println("a < b  : " + (a < b));           // false
        System.out.println("a >= b : " + (a >= b));          // true
        System.out.println("a <= b : " + (a <= b));          // false
        System.out.println("a == b : " + (a == b));          // false
        System.out.println("a != b : " + (a != b));          // true
        // Note: For Strings, use .equals() not == (== compares references in Java)

        // -------------------------------------------------------
        // 3. LOGICAL OPERATORS
        // -------------------------------------------------------
        System.out.println("\n---- Logical Operators ----");
        System.out.println("(a>b) && (b>0) : " + ((a > b) && (b > 0)));   // true  → AND
        System.out.println("(a<b) || (b>0) : " + ((a < b) || (b > 0)));   // true  → OR
        System.out.println("!(a < b)       : " + (!(a < b)));              // true  → NOT
        // Short-circuit: && stops if left is false, || stops if left is true

        // -------------------------------------------------------
        // 4. ASSIGNMENT OPERATORS
        // -------------------------------------------------------
        System.out.println("\n---- Assignment Operators ----");
        int result = a;
        System.out.println("result  = " + result);  // 10
        result += b;    System.out.println("After +=  : " + result);   // 13
        result -= 3;    System.out.println("After -=  : " + result);   // 10
        result *= 2;    System.out.println("After *=  : " + result);   // 20
        result /= 4;    System.out.println("After /=  : " + result);   // 5
        result %= 3;    System.out.println("After %=  : " + result);   // 2

        // -------------------------------------------------------
        // 5. INCREMENT AND DECREMENT OPERATORS
        // -------------------------------------------------------
        System.out.println("\n---- Increment / Decrement ----");
        int x = 5;
        System.out.println("x         = " + x);            // 5
        System.out.println("x++ (post)= " + x++);          // 5 → uses value THEN increments
        System.out.println("x now     = " + x);            // 6
        System.out.println("++x (pre) = " + ++x);          // 7 → increments THEN uses value
        System.out.println("x--  (post)= " + x--);         // 7 → uses value THEN decrements
        System.out.println("x now     = " + x);            // 6

        // -------------------------------------------------------
        // 6. BITWISE OPERATORS
        // -------------------------------------------------------
        System.out.println("\n---- Bitwise Operators ----");
        System.out.println("a & b  = " + (a & b));         // 2   → AND each bit
        System.out.println("a | b  = " + (a | b));         // 11  → OR each bit
        System.out.println("a ^ b  = " + (a ^ b));         // 9   → XOR each bit
        System.out.println("~a     = " + (~a));             // -11 → NOT (flip all bits)
        System.out.println("a << 1 = " + (a << 1));        // 20  → left shift by 1 (×2)
        System.out.println("a >> 1 = " + (a >> 1));        // 5   → right shift by 1 (÷2), sign preserved
        System.out.println("a >>> 1= " + (a >>> 1));       // 5   → unsigned right shift (no sign extension)
        // >>> is Java-specific (no equivalent in C)

        // -------------------------------------------------------
        // 7. TERNARY OPERATOR
        // -------------------------------------------------------
        System.out.println("\n---- Ternary Operator ----");
        int max = (a > b) ? a : b;                          // condition ? valueIfTrue : valueIfFalse
        System.out.println("Max of a and b = " + max);     // 10

        String status = (a % 2 == 0) ? "Even" : "Odd";
        System.out.println("a is : " + status);            // Even

        // -------------------------------------------------------
        // 8. INSTANCEOF OPERATOR (Java-specific, no C equivalent)
        // -------------------------------------------------------
        System.out.println("\n---- instanceof Operator ----");
        String str = "Hello";
        System.out.println("str instanceof String : " + (str instanceof String));  // true
        // Used to check if an object is an instance of a particular class

        // -------------------------------------------------------
        // 9. MATH CLASS (replaces <math.h> from C)
        // -------------------------------------------------------
        System.out.println("\n---- Math Class Functions ----");
        System.out.println("Math.sqrt(16)   = " + Math.sqrt(16));      // 4.0
        System.out.println("Math.pow(2,3)   = " + Math.pow(2, 3));     // 8.0
        System.out.println("Math.abs(-5)    = " + Math.abs(-5));       // 5
        System.out.println("Math.max(a,b)   = " + Math.max(a, b));     // 10
        System.out.println("Math.min(a,b)   = " + Math.min(a, b));     // 3
        System.out.println("Math.PI         = " + Math.PI);            // 3.14159...
        System.out.println("Math.floor(3.9) = " + Math.floor(3.9));    // 3.0
        System.out.println("Math.ceil(3.1)  = " + Math.ceil(3.1));     // 4.0
        System.out.println("Math.round(3.5) = " + Math.round(3.5));    // 4
    }
}


/*
=============================================
OPERATOR PRECEDENCE (High to Low, simplified)
=============================================

1.  ()  []  .                     → Parentheses, array, member access
2.  ++  --  ~  !                  → Unary
3.  *  /  %                       → Multiplicative
4.  +  -                          → Additive
5.  <<  >>  >>>                   → Shift
6.  <  >  <=  >=  instanceof      → Relational
7.  ==  !=                        → Equality
8.  &                             → Bitwise AND
9.  ^                             → Bitwise XOR
10. |                             → Bitwise OR
11. &&                            → Logical AND
12. ||                            → Logical OR
13. ?:                            → Ternary
14. =  +=  -=  *=  /=  ...        → Assignment

=============================================
JAVA vs C — OPERATOR DIFFERENCES
=============================================

Java has  >>>  (unsigned right shift) — C does not
Java has  instanceof               — C does not
Java uses .equals() for String comparison, not ==
Java booleans are true/false, not 1/0

=============================================
*/

