# Bit Manipulation for DSA — Java Edition

---

## Table of Contents

1. [Bitwise Operators Cheat Sheet (Prerequisite Concepts)](#1-bitwise-operators-cheat-sheet-prerequisite-concepts)
2. [Check Odd or Even](#2-check-odd-or-even)
3. [Check if a Number is a Power of 2](#3-check-if-a-number-is-a-power-of-2)
4. [Swap Two Numbers Using XOR](#4-swap-two-numbers-using-xor)
5. [Find the Unique Element (All Others Appear Twice)](#5-find-the-unique-element-all-others-appear-twice)
6. [Count Number of Set Bits](#6-count-number-of-set-bits)
7. [Remove the Last (Rightmost) Set Bit](#7-remove-the-last-rightmost-set-bit)
8. [Get the Last (Rightmost) Set Bit](#8-get-the-last-rightmost-set-bit)
9. [Fast / Binary Exponentiation (Bitwise Recap)](#9-fast--binary-exponentiation-bitwise-recap)
10. [Check / Set / Clear / Toggle / Update the i-th Bit](#10-check--set--clear--toggle--update-the-i-th-bit)
11. [Two Unique Elements (Bonus Extension)](#11-two-unique-elements-bonus-extension)
12. [Generate All Subsets Using Bitmasks](#12-generate-all-subsets-using-bitmasks)
13. [Count Set Bits for All Numbers 0 to N (Bit DP)](#13-count-set-bits-for-all-numbers-0-to-n-bit-dp)
14. [Complexity Summary Table](#14-complexity-summary-table)
15. [Java-Specific Pitfalls to Remember](#15-java-specific-pitfalls-to-remember)

---

## 1. Bitwise Operators Cheat Sheet (Prerequisite Concepts)

Before any of the tricks below make sense, these facts need to be automatic:

| Operator | Symbol | What it does |
|---|---|---|
| AND | `&` | 1 only if **both** bits are 1 |
| OR | `\|` | 1 if **either** bit is 1 |
| XOR | `^` | 1 if the bits **differ** |
| NOT | `~` | flips every bit (`~x` = `-x - 1`) |
| Left shift | `<<` | shifts bits left, fills with 0 (multiply by 2 per shift) |
| Signed right shift | `>>` | shifts bits right, **sign-extends** (fills with the sign bit) |
| Unsigned right shift | `>>>` | shifts bits right, **always fills with 0** (Java-only, no C++ equivalent) |

Facts worth memorizing:

- Java's `int` is **32-bit signed two's complement**; `long` is 64-bit. There is no unsigned integer type in Java.
- Negative numbers are stored as `~x + 1` (invert every bit, then add 1). This is *why* `n & (-n)` isolates the lowest set bit (see section 8).
- `n << k` is equivalent to `n * 2^k`, and `n >> k` is equivalent to `n / 2^k` (floor division, careful with negatives) — both O(1), much faster than actual multiply/divide in a tight loop.
- XOR is commutative, associative, and self-inverse: `a ^ a = 0` and `a ^ 0 = a`. This one identity powers sections 4, 5, and 10.
- `n & (n - 1)` clears the lowest set bit. `n & (-n)` isolates the lowest set bit. These two are the workhorses of almost every bit-manipulation problem you'll see.

---

## 2. Check Odd or Even

```java
public static boolean isOdd(int n) {
    return (n & 1) == 1;
}
```

The last bit is `1` exactly when the number is odd. This is preferred over
`n % 2 == 1` for one important reason: **`%` misbehaves on negative numbers
in Java**. `-3 % 2` evaluates to `-1`, not `1`, so `n % 2 == 1` silently
returns `false` for `-3`. `(n & 1) == 1` gives the correct answer for both
positive and negative inputs because it only looks at the last bit of the
two's-complement representation.

**Time:** O(1) &nbsp;&nbsp; **Space:** O(1)

---

## 3. Check if a Number is a Power of 2

```java
public static boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```

A power of 2 has **exactly one set bit** (`1`, `10`, `100`, `1000`, ...).
`n & (n - 1)` clears the lowest set bit — if that was the *only* set bit,
the result is `0`. The `n > 0` guard matters: without it, `n = 0` would
incorrectly pass (`0 & -1 == 0`), and negative numbers have their own bit
patterns that can also accidentally satisfy the check.

**Time:** O(1) &nbsp;&nbsp; **Space:** O(1)

---

## 4. Swap Two Numbers Using XOR

```java
public static void swapXOR(int[] arr, int i, int j) {
    if (i == j) return; // CRITICAL: skip if same index/variable
    arr[i] ^= arr[j];
    arr[j] ^= arr[i];
    arr[i] ^= arr[j];
}
```

Walk through it: after line 1, `arr[i] = a^b`. After line 2,
`arr[j] = b ^ (a^b) = a`. After line 3, `arr[i] = (a^b) ^ a = b`. No
temporary variable needed.

> **The `i == j` guard is not optional.** If both indices point to the
> *same* memory location, the first line does `x ^= x`, which zeroes it out
> permanently — you lose the value instead of "swapping" it with itself.
> In interviews this is exactly the kind of edge case that separates a
> correct answer from a subtly broken one. In real code, a plain temp-variable
> swap is just as fast and far more readable — know this trick for
> interviews, but don't reach for it in production.

**Time:** O(1) &nbsp;&nbsp; **Space:** O(1)

---

## 5. Find the Unique Element (All Others Appear Twice)

Every element appears exactly twice except one — find it in linear time
and constant space.

```java
public static int findUnique(int[] arr) {
    int result = 0;
    for (int num : arr) {
        result ^= num;
    }
    return result;
}
```

XOR-ing every element together: every value that appears twice cancels
itself out (`a ^ a = 0`), and XOR-ing with `0` leaves the rest unchanged
(`a ^ 0 = a`). Whatever survives at the end is the one element that had no
pair.

This beats the "obvious" first instinct — a `HashMap<Integer, Integer>`
frequency count — which is also O(n) time but costs O(n) *space*. The XOR
trick does it in O(1) space.

**Time:** O(n) &nbsp;&nbsp; **Space:** O(1)

---

## 6. Count Number of Set Bits

Three approaches worth knowing, roughly in order of "how an interview
usually wants you to build it up":

```java
// Naive: check all 32 bits of an int
public static int countSetBitsNaive(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
        if ((n & (1 << i)) != 0) count++;
    }
    return count;
}

// Brian Kernighan's Algorithm: only loops once per SET bit, not per bit
public static int countSetBitsBrianKernighan(int n) {
    int count = 0;
    while (n != 0) {
        n = n & (n - 1); // clears the lowest set bit each time
        count++;
    }
    return count;
}
```

> Java also ships a built-in, `Integer.bitCount(n)`, which is effectively
> O(1) (it's a JIT/hardware-backed intrinsic using a parallel
> "popcount" trick under the hood). **Know Brian Kernighan's approach for
> interviews** — it's the expected answer and the same `n & (n-1)` idea
> reappears constantly — but reach for `Integer.bitCount()` in real code.

**Time:** O(32) naive, O(k) Brian Kernighan where k = number of set bits, O(1) built-in &nbsp;&nbsp; **Space:** O(1) all three

---

## 7. Remove the Last (Rightmost) Set Bit

```java
public static int removeLastSetBit(int n) {
    return n & (n - 1);
}
```

This is the exact same expression used inside Brian Kernighan's algorithm
above — worth isolating as its own trick since it shows up standalone in
plenty of problems (e.g., checking power-of-2, or peeling bits off one at
a time in a loop).

**Why it works:** subtracting 1 flips the lowest set bit to `0` and flips
every bit *after* it (which were all `0`) to `1`. Bits above the lowest
set bit are untouched by the borrow. ANDing with the original `n` keeps
those untouched higher bits and zeroes out everything from the lowest set
bit downward.

**Time:** O(1) &nbsp;&nbsp; **Space:** O(1)

---

## 8. Get the Last (Rightmost) Set Bit

```java
public static int getLastSetBit(int n) {
    return n & (-n);
}
```

In two's complement, `-n` is `~n + 1`. Inverting `n` flips every bit
*except* trailing zeros stay as they were only after the `+1` carries
through them — the net effect is that `-n` matches `n` exactly at the
lowest set bit and is inverted everywhere above it. ANDing the two leaves
only that one bit standing.

Example: `n = 12` → `1100`. `-n` → `...110100`. `n & (-n)` → `0100` = `4`.

> Java built-in equivalents: `Integer.lowestOneBit(n)` returns the same
> **value** as this function; `Integer.numberOfTrailingZeros(n)` returns
> the bit's **position** (index) instead of its value — useful when you
> need "which bit" rather than "what number is that bit worth."

**Time:** O(1) &nbsp;&nbsp; **Space:** O(1)

---

## 9. Fast / Binary Exponentiation (Bitwise Recap)

Already covered in `_02_BasicMaths.md` (section 14), but it's fundamentally
a bit-manipulation technique, so it belongs here too: it computes
`base^exp` in O(log exp) by walking the binary representation of the
exponent one bit at a time.

```java
public static long fastPow(long base, long exp) {
    long result = 1;
    while (exp > 0) {
        if ((exp & 1) == 1) {   // is the current lowest bit of exp set?
            result *= base;
        }
        base *= base;           // base doubles its "weight" each bit
        exp >>= 1;               // move to the next bit
    }
    return result;
}
```

Think of `exp` in binary, e.g. `13 = 1101`. The loop multiplies in
`base^1`, `base^4`, `base^8` — exactly the bits that are `1` — and skips
`base^2` because that bit is `0`. That's the whole trick.

**Time:** O(log exp) &nbsp;&nbsp; **Space:** O(1)

---

## 10. Check / Set / Clear / Toggle / Update the i-th Bit

The five operations every bitmask problem is built from. `i` is the bit
index, counted from `0` at the least significant bit.

```java
// Is the i-th bit set?
public static boolean checkBit(int n, int i) {
    return (n & (1 << i)) != 0;
}

// Turn the i-th bit ON
public static int setBit(int n, int i) {
    return n | (1 << i);
}

// Turn the i-th bit OFF
public static int clearBit(int n, int i) {
    return n & ~(1 << i);
}

// Flip the i-th bit
public static int toggleBit(int n, int i) {
    return n ^ (1 << i);
}

// Set the i-th bit to a specific value (0 or 1)
public static int updateBit(int n, int i, int value) {
    n = clearBit(n, i);       // always clear first
    return n | (value << i);  // then OR in the new value
}
```

`updateBit` clearing first and then OR-ing in the value (rather than just
XOR-ing) is deliberate — it works correctly regardless of what the bit's
previous value was, whereas a careless XOR-based "set to value" only
works if you already know the old bit.

**Time:** O(1) for each &nbsp;&nbsp; **Space:** O(1)

---

## 11. Two Unique Elements (Bonus Extension)

A harder variant of section 5: **two** elements appear once each, and
every other element appears exactly twice.

```java
public static int[] findTwoUnique(int[] arr) {
    int xorAll = 0;
    for (int num : arr) xorAll ^= num;
    // xorAll now equals a ^ b (the two unique numbers), since every
    // paired value cancelled out already.

    int diffBit = xorAll & (-xorAll); // any bit where a and b differ
    int a = 0, b = 0;
    for (int num : arr) {
        if ((num & diffBit) != 0) a ^= num;
        else b ^= num;
    }
    return new int[]{a, b};
}
```

Since `a != b`, `xorAll` is non-zero, so it has at least one set bit — and
that bit must come from either `a` or `b` alone (never both, otherwise
XOR would have cancelled it). Using that bit to split the whole array into
two groups puts `a` and `b` in different groups; XOR-ing each group
separately cancels every pair within it and leaves exactly one unique
value per group — same idea as section 5, applied twice.

**Time:** O(n) &nbsp;&nbsp; **Space:** O(1)

---

## 12. Generate All Subsets Using Bitmasks

Essential prerequisite before touching subset-sum, bitmask DP, or
"traveling salesman"-style DP — represent every subset of `n` elements as
an integer from `0` to `2^n - 1`, where bit `i` tells you whether element
`i` is included.

```java
public static List<List<Integer>> allSubsets(int[] arr) {
    int n = arr.length;
    List<List<Integer>> subsets = new ArrayList<>();

    for (int mask = 0; mask < (1 << n); mask++) {
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                subset.add(arr[i]);
            }
        }
        subsets.add(subset);
    }
    return subsets;
}
```

`mask = 0` gives the empty subset, `mask = (1 << n) - 1` gives the full
set, and every integer in between corresponds to exactly one unique
subset — no duplicates, no missed combinations.

**Time:** O(n · 2ⁿ) &nbsp;&nbsp; **Space:** O(n · 2ⁿ) for the returned subsets

---

## 13. Count Set Bits for All Numbers 0 to N (Bit DP)

A pattern that combines a bit trick with DP — computing set-bit counts
for every number from `0` to `n` in one linear pass instead of calling
Brian Kernighan's algorithm `n` separate times.

```java
public static int[] countBitsDP(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        dp[i] = dp[i >> 1] + (i & 1);
    }
    return dp;
}
```

`i >> 1` is `i` with its lowest bit dropped (i.e., `i / 2`), and its set-bit
count has already been computed earlier in the loop. Add back `1` if `i`'s
own lowest bit (`i & 1`) was set. Classic bottom-up DP reusing a bit trick.

**Time:** O(n) &nbsp;&nbsp; **Space:** O(n)

---

## 14. Complexity Summary Table

| Topic | Time | Space |
|---|---|---|
| Check Odd/Even | O(1) | O(1) |
| Check Power of 2 | O(1) | O(1) |
| Swap Using XOR | O(1) | O(1) |
| Find Unique Element (one, rest pairs) | O(n) | O(1) |
| Count Set Bits (naive) | O(32) | O(1) |
| Count Set Bits (Brian Kernighan) | O(k) set bits | O(1) |
| Count Set Bits (`Integer.bitCount`) | O(1) | O(1) |
| Remove Last Set Bit | O(1) | O(1) |
| Get Last Set Bit | O(1) | O(1) |
| Fast Exponentiation | O(log exp) | O(1) |
| Check/Set/Clear/Toggle/Update i-th Bit | O(1) | O(1) |
| Two Unique Elements | O(n) | O(1) |
| Generate All Subsets (bitmask) | O(n · 2ⁿ) | O(n · 2ⁿ) |
| Count Set Bits 0..N (Bit DP) | O(n) | O(n) |

---

## 15. Java-Specific Pitfalls to Remember

- **`>>` vs `>>>`:** `>>` is the *signed* right shift — it sign-extends,
  so shifting a negative number keeps it negative (`-8 >> 1 == -4`).
  `>>>` is the *unsigned* right shift — it always fills with `0`, so
  `-8 >>> 1` produces a large positive number instead. C/C++ has no
  `>>>` equivalent; this trips up people coming from those languages.
- **No unsigned integer type:** Java `int`/`long` are always signed
  two's complement. Tricks that assume "unsigned wraparound" (common in
  C) need extra care — reach for `>>>` or `Integer`/`Long`'s unsigned
  helper methods (`Integer.toUnsignedLong`, etc.) instead.
- **`1 << 31` overflows into the sign bit:** in a 32-bit `int`, `1 << 31`
  equals `Integer.MIN_VALUE`, a *negative* number. This silently breaks
  subset-bitmask code for `n = 31`: the loop condition
  `mask < (1 << n)` compares against a negative number and the loop body
  never executes. Bitmask enumeration over `int` is only safe up to
  `n = 30`; beyond that, switch to `1L << i` (`long`) for the mask.
- **`n & (n - 1)` and `n & (-n)` on `n = 0`:** both return `0` — there's
  no set bit to remove or isolate, so guard for `n == 0` if your problem
  needs to distinguish "no bits" from "bit at position 0."
- **Prefer built-ins in real code:** `Integer.bitCount(n)`,
  `Integer.lowestOneBit(n)`, `Integer.highestOneBit(n)`, and
  `Integer.numberOfTrailingZeros(n)` are all backed by fast intrinsics.
  Know the manual derivations above for interviews, but don't hand-roll
  them in production.
