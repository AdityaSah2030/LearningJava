# Basic Maths for DSA — Java Edition

A single reference covering the "Basic Maths" playlist chapters plus a few
extra topics that always show up alongside them in interviews and competitive
programming. Everything is written in **plain Java using only primitives and
arrays** — no `ArrayList`, `HashMap`, `HashSet`, etc. (`Arrays.fill` is a
static utility method on the `java.util.Arrays` class, not part of the
Collections Framework, so it's used freely below.)

Wrap all of these in one class if you want a single compilable file:

```java
import java.util.Arrays;

public class BasicMaths {
    // paste methods here
    public static void main(String[] args) {
        // quick manual tests
    }
}
```

---

## Table of Contents

1. [Print Digits of a Number](#1-print-digits-of-a-number)
2. [Count Digits](#2-count-digits)
3. [Sum of Digits](#3-sum-of-digits)
4. [Reverse a Number](#4-reverse-a-number)
5. [Check Palindrome Number](#5-check-palindrome-number)
6. [Check Prime Number](#6-check-prime-number)
7. [GCD of Two Numbers](#7-gcd-of-two-numbers)
8. [LCM of Two Numbers](#8-lcm-of-two-numbers)
9. [Armstrong Number](#9-armstrong-number)
10. [Find All Divisors / Perfect Number](#10-find-all-divisors--perfect-number)
11. [Print All Primes from 1 to N (Sieve of Eratosthenes)](#11-print-all-primes-from-1-to-n-sieve-of-eratosthenes)
12. [Beyond the Video: Essentials from the Reference Notes](#12-beyond-the-video-essentials-from-the-reference-notes)
13. [Bonus: Frequently Paired Interview Topics](#13-bonus-frequently-paired-interview-topics)
14. [Complexity Summary Table](#14-complexity-summary-table)
15. [Java-Specific Pitfalls to Remember](#15-java-specific-pitfalls-to-remember)

---

## 1. Print Digits of a Number

```java
// Digits come out LAST-digit-first because of how % and / work
public static void printDigits(int n) {
    n = Math.abs(n);
    if (n == 0) {
        System.out.println(0);
        return;
    }
    while (n > 0) {
        System.out.println(n % 10);
        n /= 10;
    }
}
```

If you need them in the original left-to-right order, recursion is the
cleanest way (the digit is printed *after* the recursive call returns):

```java
public static void printDigitsInOrder(int n) {
    n = Math.abs(n);
    if (n < 10) {
        System.out.println(n);
        return;
    }
    printDigitsInOrder(n / 10);
    System.out.println(n % 10);
}
```

**Time:** O(log n) &nbsp;&nbsp; **Space:** O(1) iterative, O(log n) recursive (call stack)

---

## 2. Count Digits

Two approaches — know both, but prefer the iterative one in practice.

```java
public static int countDigitsIterative(int n) {
    if (n == 0) return 1;
    n = Math.abs(n);
    int count = 0;
    while (n > 0) {
        n /= 10;
        count++;
    }
    return count;
}

public static int countDigitsLog(int n) {
    if (n == 0) return 1;
    n = Math.abs(n);
    return (int) Math.floor(Math.log10(n) + 1);
}
```

> **Gotcha:** `Math.log10` uses floating point internally, so for exact
> powers of 10 it can occasionally be off by one due to precision error
> (e.g. `log10(1000)` sometimes evaluates to `2.9999999999...`). The
> iterative version is always correct — use it when correctness matters
> more than the O(1)-looking shortcut.

**Time:** O(log n) &nbsp;&nbsp; **Space:** O(1)

---

## 3. Sum of Digits

```java
public static int sumOfDigits(int n) {
    n = Math.abs(n);
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}
```

**Bonus — Digital Root:** repeatedly summing digits until one digit remains
has an O(1) closed form: for `n > 0`, digital root `= 1 + (n - 1) % 9`
(and `0` for `n == 0`). Handy if a follow-up asks you to avoid the loop.

**Time:** O(log n) &nbsp;&nbsp; **Space:** O(1)

---

## 4. Reverse a Number

```java
public static int reverseNumber(int n) {
    boolean isNegative = n < 0;
    n = Math.abs(n);

    long reversed = 0; // long buffer so we can detect int overflow safely
    while (n > 0) {
        reversed = reversed * 10 + n % 10;
        n /= 10;
    }

    if (reversed > Integer.MAX_VALUE) {
        throw new ArithmeticException("Reversed number overflows int range");
    }
    return isNegative ? (int) -reversed : (int) reversed;
}
```

Using a `long` accumulator and checking against `Integer.MAX_VALUE` before
casting back is the difference between a correct solution and one that
silently wraps around on inputs like `1534236469` — this exact overflow
check is what LeetCode's "Reverse Integer" problem is testing.

**Time:** O(log n) &nbsp;&nbsp; **Space:** O(1)

---

## 5. Check Palindrome Number

```java
public static boolean isPalindrome(int n) {
    if (n < 0) return false; // a negative number is never a palindrome
    int original = n;
    int reversed = 0;
    while (n > 0) {
        reversed = reversed * 10 + n % 10;
        n /= 10;
    }
    return original == reversed;
}
```

Same overflow caveat as above applies for numbers near `Integer.MAX_VALUE`
— use a `long` for `reversed` if you want it bulletproof.

**Time:** O(log n) &nbsp;&nbsp; **Space:** O(1)

---

## 6. Check Prime Number

Every prime `> 3` is of the form `6k ± 1`, so after ruling out 2 and 3 you
only need to test candidates 6 apart. This is the standard optimized
version (upgraded from the naive "check up to n/2" approach).

```java
public static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;

    for (int i = 5; (long) i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
}
```

> The `(long) i * i` cast prevents `i * i` from overflowing `int` when `n`
> is close to `Integer.MAX_VALUE`.

**Time:** O(√n) &nbsp;&nbsp; **Space:** O(1)

---

## 7. GCD of Two Numbers

Euclidean algorithm — recursive and iterative versions.

```java
public static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

public static int gcdIterative(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
```

**Time:** O(log(min(a, b))) &nbsp;&nbsp; **Space:** O(1) iterative, O(log(min(a,b))) recursive

---

## 8. LCM of Two Numbers

```java
public static long lcm(int a, int b) {
    // divide by gcd BEFORE multiplying to reduce overflow risk
    return ((long) a / gcd(a, b)) * b;
}
```

Returning `long` and dividing before multiplying both matter here — for two
large `int`s, `a * b` can overflow before you ever get to divide by the gcd.

**Time:** O(log(min(a, b))) &nbsp;&nbsp; **Space:** O(1)

---

## 9. Armstrong Number

An n-digit number that equals the sum of each digit raised to the power `n`
(e.g. `153 = 1³ + 5³ + 3³`).

```java
public static boolean isArmstrong(int n) {
    int original = n;
    int numDigits = countDigitsIterative(n);
    int sum = 0;
    int temp = n;

    while (temp > 0) {
        int digit = temp % 10;
        sum += (int) Math.pow(digit, numDigits);
        temp /= 10;
    }
    return sum == original;
}
```

> `Math.pow` returns a `double`, which is fine for the small digit values
> here (0–9) but is generally worth avoiding for integer math because of
> floating-point rounding. See [Fast Exponentiation](#123-fast--binary-exponentiation)
> below for an all-integer alternative if you want to be strict about it.

**Time:** O(log n) &nbsp;&nbsp; **Space:** O(1)

---

## 10. Find All Divisors / Perfect Number

### Print all divisors in sorted order, in O(√n), with no storage sort needed

The trick: only iterate to `√n`. Print the small divisor immediately (it's
already in ascending order); stash its paired larger divisor in a plain
array and print that array in reverse afterward.

```java
public static void printDivisors(int n) {
    int[] largerDivisors = new int[(int) Math.sqrt(n) + 1];
    int count = 0;

    for (int i = 1; (long) i * i <= n; i++) {
        if (n % i == 0) {
            System.out.print(i + " ");           // small divisor: already sorted
            if (i != n / i) {
                largerDivisors[count++] = n / i;  // stash the paired large divisor
            }
        }
    }

    for (int i = count - 1; i >= 0; i--) {        // print large divisors descending
        System.out.print(largerDivisors[i] + " "); // -> overall ascending order
    }
    System.out.println();
}
```

### Perfect Number

A number equal to the sum of its proper divisors (excluding itself), e.g.
`6 = 1 + 2 + 3` and `28 = 1 + 2 + 4 + 7 + 14`.

```java
public static boolean isPerfectNumber(int n) {
    if (n <= 1) return false;
    int sum = 1; // 1 is a proper divisor of every n > 1
    for (int i = 2; (long) i * i <= n; i++) {
        if (n % i == 0) {
            sum += i;
            if (i != n / i) sum += n / i;
        }
    }
    return sum == n;
}
```

**Time:** O(√n) &nbsp;&nbsp; **Space:** O(√n) for `printDivisors` (the stash array), O(1) for `isPerfectNumber`

---

## 11. Print All Primes from 1 to N (Sieve of Eratosthenes)

```java
public static boolean[] sieveOfEratosthenes(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    if (n >= 1) isPrime[1] = false;

    for (int i = 2; (long) i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    return isPrime;
}

public static void printAllPrimes(int n) {
    boolean[] isPrime = sieveOfEratosthenes(n);
    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) System.out.print(i + " ");
    }
    System.out.println();
}
```

**Why start marking at `i * i`?** Every smaller composite multiple of `i`
(like `2i`, `3i`, ... up to `(i-1)i`) has already been marked by a smaller
prime factor, so starting at `i * i` skips redundant work.

**Time:** O(n log log n) &nbsp;&nbsp; **Space:** O(n)

---

## 12. Beyond the Video: Essentials from the Reference Notes

These didn't appear in the video chapter list but sit right next to
"primes" and "sieve" in almost every DSA course and interview — worth
knowing alongside sections 6 and 11 above.

### 12.1 Prime Factorization (Optimized)

```java
public static void printPrimeFactors(int n) {
    while (n % 2 == 0) {
        System.out.print(2 + " ");
        n /= 2;
    }
    for (int i = 3; (long) i * i <= n; i += 2) {
        while (n % i == 0) {
            System.out.print(i + " ");
            n /= i;
        }
    }
    if (n > 2) {
        System.out.print(n + " "); // whatever's left is itself prime
    }
    System.out.println();
}
```

**Time:** O(√n) &nbsp;&nbsp; **Space:** O(1) (excluding output)

### 12.2 Smallest Prime Factor (SPF) Sieve

Precompute once in O(n log log n), then factorize *any* number ≤ n in
O(log n) — useful when you need to factorize many numbers, not just one.

```java
public static int[] smallestPrimeFactor(int n) {
    int[] spf = new int[n + 1];
    for (int i = 1; i <= n; i++) spf[i] = i; // default: SPF of i is i itself

    for (int i = 2; (long) i * i <= n; i++) {
        if (spf[i] == i) { // i is prime (never overwritten)
            for (int j = i * i; j <= n; j += i) {
                if (spf[j] == j) spf[j] = i;
            }
        }
    }
    return spf;
}

public static void factorizeUsingSPF(int n, int[] spf) {
    while (n > 1) {
        System.out.print(spf[n] + " ");
        n /= spf[n];
    }
    System.out.println();
}
```

**Time:** O(n log log n) preprocessing, O(log n) per query &nbsp;&nbsp; **Space:** O(n)

### 12.3 Fast / Binary Exponentiation

Computes `base^exp` in O(log exp) instead of O(exp) by squaring the base
and halving the exponent each step.

```java
public static long fastPow(long base, long exp) {
    long result = 1;
    while (exp > 0) {
        if ((exp & 1) == 1) {
            result *= base;
        }
        base *= base;
        exp >>= 1;
    }
    return result;
}
```

**Time:** O(log exp) &nbsp;&nbsp; **Space:** O(1)

### 12.4 Modular Exponentiation

Same idea, but taking `% mod` after every multiplication so intermediate
values never overflow — essential whenever a problem says *"answer modulo
`10^9 + 7`"*.

```java
public static long modPow(long base, long exp, long mod) {
    long result = 1;
    base %= mod;
    while (exp > 0) {
        if ((exp & 1) == 1) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        exp >>= 1;
    }
    return result;
}
```

**Time:** O(log exp) &nbsp;&nbsp; **Space:** O(1)

### 12.5 Count Primes in Range [L, R] — Segmented Sieve (Advanced)

Flagged as **advanced / optional** — this is the one genuinely
competitive-programming-level topic here (needed when `R` is too large to
sieve from 0, e.g. up to `10^12`, but `R - L` is small). Skip it on a first
pass and come back once sections 1–11 feel automatic.

```java
public static int countPrimesInRange(long L, long R) {
    int limit = (int) Math.sqrt(R) + 1;

    // 1. Sieve base primes up to sqrt(R)
    boolean[] mark = new boolean[limit + 1];
    Arrays.fill(mark, true);
    if (limit >= 0) mark[0] = false;
    if (limit >= 1) mark[1] = false;

    int[] primes = new int[limit + 1];
    int primeCount = 0;
    for (int i = 2; i <= limit; i++) {
        if (mark[i]) {
            primes[primeCount++] = i;
            for (long j = (long) i * i; j <= limit; j += i) {
                mark[(int) j] = false;
            }
        }
    }

    // 2. Use those base primes to sieve the [L, R] window directly
    boolean[] isPrime = new boolean[(int) (R - L + 1)];
    Arrays.fill(isPrime, true);
    if (L == 1) isPrime[0] = false;

    for (int idx = 0; idx < primeCount; idx++) {
        long p = primes[idx];
        long firstMultiple = Math.max((long) p * p, ((L + p - 1) / p) * p);
        for (long j = firstMultiple; j <= R; j += p) {
            isPrime[(int) (j - L)] = false;
        }
    }

    int count = 0;
    for (boolean b : isPrime) {
        if (b) count++;
    }
    return count;
}
```

**Time:** O(√R + (R − L + 1) log log R) &nbsp;&nbsp; **Space:** O(√R + (R − L + 1))

---

## 13. Bonus: Frequently Paired Interview Topics

Two more that regularly show up in the same interview round as "basic
maths" and build directly on the ideas above.

### 13.1 Trailing Zeros in N!

Trailing zeros come from factors of `10 = 2 × 5`, and factors of 5 are
always the bottleneck (there are always more 2s than 5s), so just count
factors of 5 across `1..n`:

```java
public static int trailingZerosInFactorial(int n) {
    int count = 0;
    for (long p = 5; n / p >= 1; p *= 5) {
        count += n / p;
    }
    return count;
}
```

**Time:** O(log₅ n) &nbsp;&nbsp; **Space:** O(1)

### 13.2 nCr (Binomial Coefficient)

Computing `n! / (r! (n-r)!)` directly overflows fast. Multiplying and
dividing in the same loop, in this exact order, keeps every intermediate
result an exact integer (a well-known combinatorial identity) and stays
small for much longer:

```java
public static long nCr(int n, int r) {
    if (r > n - r) r = n - r; // nCr == nC(n-r): reduce iterations
    long result = 1;
    for (int i = 0; i < r; i++) {
        result *= (n - i);
        result /= (i + 1);
    }
    return result;
}
```

**Time:** O(r) &nbsp;&nbsp; **Space:** O(1)

---

## 14. Complexity Summary Table

| Topic | Time | Space |
|---|---|---|
| Print / Count / Sum of Digits | O(log n) | O(1) |
| Reverse a Number | O(log n) | O(1) |
| Check Palindrome Number | O(log n) | O(1) |
| Check Prime | O(√n) | O(1) |
| GCD | O(log(min(a,b))) | O(1) |
| LCM | O(log(min(a,b))) | O(1) |
| Armstrong Number | O(log n) | O(1) |
| Print All Divisors | O(√n) | O(√n) |
| Perfect Number Check | O(√n) | O(1) |
| Sieve of Eratosthenes | O(n log log n) | O(n) |
| Prime Factorization | O(√n) | O(1) |
| SPF Sieve + Factorize | O(n log log n) preprocess, O(log n)/query | O(n) |
| Fast Exponentiation | O(log exp) | O(1) |
| Modular Exponentiation | O(log exp) | O(1) |
| Count Primes in [L, R] | O(√R + (R−L+1) log log R) | O(√R + (R−L+1)) |
| Trailing Zeros in N! | O(log₅ n) | O(1) |
| nCr | O(r) | O(1) |

---

## 15. Java-Specific Pitfalls to Remember

- **`int` overflow in loop conditions:** `i * i <= n` can overflow before
  the comparison happens when `i` is large — cast to `(long) i * i` (used
  throughout this doc) instead of changing `i`'s type.
- **`Math.pow` returns `double`:** fine for small exponents, risky for
  exact integer results at scale — prefer `fastPow`/`modPow` for anything
  that needs to be exact.
- **`Math.log10` precision:** can misfire by ±1 on exact powers of 10;
  prefer the iterative digit-count loop when correctness matters.
- **Multiply-before-divide overflow:** in LCM and nCr, the *order* of
  multiply/divide operations is chosen specifically to avoid overflow —
  don't reorder them casually.
- **No Collections needed here:** every problem above is solvable with
  `int`/`long` primitives and plain arrays (`int[]`, `boolean[]`). If you
  find yourself reaching for `ArrayList` on one of these, it's a sign to
  simplify, not a sign the array won't fit.
