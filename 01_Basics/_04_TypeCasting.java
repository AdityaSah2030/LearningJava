// Program to demonstrate Type Casting in Java
// Casting = converting one data type to another

public class _04_TypeCasting {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // 1. WIDENING CASTING (Implicit / Automatic)
        //    → Smaller type → Larger type (no data loss, Java does it automatically)
        //    byte → short → int → long → float → double
        // -------------------------------------------------------
        System.out.println("---- Widening Casting (Implicit) ----");

        byte   b = 42;
        short  s = b;       // byte  → short  (automatic)
        int    i = s;       // short → int    (automatic)
        long   l = i;       // int   → long   (automatic)
        float  f = l;       // long  → float  (automatic)
        double d = f;       // float → double (automatic)

        System.out.println("byte   : " + b);
        System.out.println("short  : " + s);
        System.out.println("int    : " + i);
        System.out.println("long   : " + l);
        System.out.println("float  : " + f);
        System.out.println("double : " + d);

        // -------------------------------------------------------
        // 2. NARROWING CASTING (Explicit / Manual)
        //    → Larger type → Smaller type (may lose data, must cast manually)
        //    double → float → long → int → short → byte
        // -------------------------------------------------------
        System.out.println("\n---- Narrowing Casting (Explicit) ----");

        double  dVal = 99.99;
        float   fVal = (float)  dVal;   // double → float  | may lose precision
        long    lVal = (long)   dVal;   // double → long   | decimal part is DROPPED (not rounded)
        int     iVal = (int)    dVal;   // double → int    | decimal part is DROPPED
        short   sVal = (short)  iVal;   // int    → short  | may overflow if value is too large
        byte    bVal = (byte)   iVal;   // int    → byte   | may overflow

        System.out.println("double → float  : " + fVal); // 99.99
        System.out.println("double → long   : " + lVal); // 99   (decimal dropped)
        System.out.println("double → int    : " + iVal); // 99   (decimal dropped)
        System.out.println("int    → short  : " + sVal); // 99
        System.out.println("int    → byte   : " + bVal); // 99

        // -------------------------------------------------------
        // 3. DATA LOSS EXAMPLE (overflow on narrowing)
        // -------------------------------------------------------
        System.out.println("\n---- Data Loss on Overflow ----");
        int bigInt = 300;
        byte overflow = (byte) bigInt;  // 300 is outside byte range (-128 to 127)
        System.out.println("int 300 → byte  : " + overflow); // 44  (wraps around)

        double pi = 3.14159;
        int piInt = (int) pi;           // decimal portion is truncated, NOT rounded
        System.out.println("double 3.14159 → int : " + piInt); // 3

        // -------------------------------------------------------
        // 4. CASTING IN EXPRESSIONS
        // -------------------------------------------------------
        System.out.println("\n---- Casting in Expressions ----");
        int x = 7, y = 2;

        int    intDiv    = x / y;                      // integer division → 3
        double doubleDiv = (double) x / y;             // cast x to double first → 3.5
        double alsoOk    = x / (double) y;             // casting y also works    → 3.5

        System.out.println("7 / 2           = " + intDiv);     // 3
        System.out.println("(double)7 / 2   = " + doubleDiv);  // 3.5
        System.out.println("7 / (double)2   = " + alsoOk);     // 3.5

        // -------------------------------------------------------
        // 5. CHAR ↔ INT CASTING (useful and common)
        // -------------------------------------------------------
        System.out.println("\n---- char ↔ int Casting ----");
        char ch = 'A';
        int ascii = (int) ch;           // char → int gives ASCII/Unicode value
        System.out.println("'A' as int  : " + ascii);  // 65

        int code = 90;
        char letter = (char) code;      // int → char gives the character for that code
        System.out.println("90 as char  : " + letter); // Z

        // Char arithmetic
        System.out.println("'A' + 1 as char : " + (char)('A' + 1));    // B
        System.out.println("'a' to upper    : " + (char)('a' - 32));   // A

        // -------------------------------------------------------
        // 6. STRING ↔ PRIMITIVE CONVERSIONS (not casting, but related)
        // -------------------------------------------------------
        System.out.println("\n---- String ↔ Primitive Conversions ----");

        // Primitive → String
        int    num = 42;
        String str1 = String.valueOf(num);          // int    → String using valueOf()
        String str2 = Integer.toString(num);        // int    → String using toString()
        String str3 = "" + num;                     // int    → String using concatenation trick

        System.out.println("int → String : \"" + str1 + "\"");
        System.out.println("int → String : \"" + str2 + "\"");
        System.out.println("int → String : \"" + str3 + "\"");

        // String → Primitive
        String numStr = "123";
        int    parsed  = Integer.parseInt(numStr);      // String → int
        double parsedD = Double.parseDouble("3.14");    // String → double
        long   parsedL = Long.parseLong("9876543210");  // String → long

        System.out.println("String \"123\" → int    : " + parsed);
        System.out.println("String \"3.14\" → double: " + parsedD);
        System.out.println("String → long           : " + parsedL);
    }
}


/*
=============================================
WIDENING ORDER (automatic / safe)
=============================================

byte → short → int → long → float → double
                            char → int (char is treated as unsigned)

=============================================
NARROWING ORDER (manual / may lose data)
=============================================

double → float → long → int → short → byte

=============================================
QUICK RULE OF THUMB
=============================================

Going UP   the chain → compiler handles it automatically (Widening)
Going DOWN the chain → you must write the cast explicitly   (Narrowing)

When casting floating point to integer:
  Decimal is TRUNCATED (not rounded)
  3.9 → 3, not 4

When casting to a smaller int type:
  Overflow wraps around using modular arithmetic
  300 as byte → 300 % 256 = 44 (roughly)

=============================================
*/

