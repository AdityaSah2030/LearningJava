# Time and Space Complexity — Complete Study Notes

## Table of Contents
1. [Why Complexity Analysis](#1-why-complexity-analysis)
2. [Asymptotic Notations (Formal Definitions)](#2-asymptotic-notations-formal-definitions)
3. [Reading the Notations and Their Relationships](#3-reading-the-notations-and-their-relationships)
4. [Rules for Combining Asymptotic Notations](#4-rules-for-combining-asymptotic-notations)
5. [Growth Rate Hierarchy](#5-growth-rate-hierarchy)
6. [Analyzing Time Complexity](#6-analyzing-time-complexity)
7. [Recurrence Relations](#7-recurrence-relations)
8. [Space Complexity](#8-space-complexity)
9. [Amortized Analysis](#9-amortized-analysis)
10. [Best, Average, and Worst Case](#10-best-average-and-worst-case)
11. [Comparison Tables](#11-comparison-tables)
12. [Complexity Classes Beyond Big-O (P, NP)](#12-complexity-classes-beyond-big-o-p-np)
13. [Quick Revision Sheet](#13-quick-revision-sheet)

---

## 1. Why Complexity Analysis

Complexity analysis measures how the resources an algorithm consumes grow as the input size `n` increases, independent of the machine, compiler, or programming language used to implement it.

Two resources matter:

- **Time complexity** — number of basic operations (not wall-clock seconds) as a function of `n`.
- **Space complexity** — amount of memory (not counting the input itself, unless stated otherwise) as a function of `n`.

The reason we use asymptotic notation instead of counting exact operations is that exact counts depend on hardware and implementation details, while asymptotic growth rate does not. It tells us how an algorithm *scales*.

---

## 2. Asymptotic Notations (Formal Definitions)

Every notation below is technically a **set of functions**. Writing `f(n) = O(g(n))` is shorthand for `f(n) ∈ O(g(n))`.

### Big-O — Upper Bound (worst case does not exceed this)

```
O(g(n)) = { f(n) : ∃ positive constants c, n₀ such that
            0 ≤ f(n) ≤ c·g(n)  for all n ≥ n₀ }
```

Meaning: beyond some point `n₀`, `f(n)` never grows faster than a constant multiple of `g(n)`.

### Big-Omega (Ω) — Lower Bound (algorithm never does better than this)

```
Ω(g(n)) = { f(n) : ∃ positive constants c, n₀ such that
            0 ≤ c·g(n) ≤ f(n)  for all n ≥ n₀ }
```

### Big-Theta (Θ) — Tight Bound (grows at exactly this rate)

```
Θ(g(n)) = { f(n) : ∃ positive constants c₁, c₂, n₀ such that
            0 ≤ c₁·g(n) ≤ f(n) ≤ c₂·g(n)  for all n ≥ n₀ }
```

`f(n) = Θ(g(n))` if and only if `f(n) = O(g(n))` **and** `f(n) = Ω(g(n))`. This is the strongest, most informative statement — it means `f` and `g` grow at the same rate.

### Little-o — Strict Upper Bound (grows strictly slower)

```
o(g(n)) = { f(n) : ∀ constants c > 0, ∃ n₀ such that
            0 ≤ f(n) < c·g(n)  for all n ≥ n₀ }
```

Unlike Big-O, this must hold for **every** c, not just some c. It means `f` grows strictly slower than `g`.

### Little-omega (ω) — Strict Lower Bound (grows strictly faster)

```
ω(g(n)) = { f(n) : ∀ constants c > 0, ∃ n₀ such that
            0 ≤ c·g(n) < f(n)  for all n ≥ n₀ }
```

### Limit-Based Definitions (equivalent, often faster to apply)

If the limit exists:

```
lim(n→∞) f(n)/g(n) = 0        →  f(n) = o(g(n))
lim(n→∞) f(n)/g(n) = c, 0<c<∞ →  f(n) = Θ(g(n))
lim(n→∞) f(n)/g(n) = ∞        →  f(n) = ω(g(n))
lim(n→∞) f(n)/g(n) < ∞        →  f(n) = O(g(n))
lim(n→∞) f(n)/g(n) > 0        →  f(n) = Ω(g(n))
```

### Worked Proof Example

Show `f(n) = 3n² + 2n + 1 = O(n²)`.

For `n ≥ 1`: `3n² + 2n + 1 ≤ 3n² + 2n² + n² = 6n²`.
So taking `c = 6` and `n₀ = 1` satisfies `f(n) ≤ c·n²` for all `n ≥ n₀`. Hence `f(n) = O(n²)`. ∎

---

## 3. Reading the Notations and Their Relationships

| Notation | Bound type | Analogy with real numbers |
|---|---|---|
| O(g) | Upper bound (≤) | `f ≤ g` |
| Ω(g) | Lower bound (≥) | `f ≥ g` |
| Θ(g) | Tight bound (=) | `f = g` |
| o(g) | Strict upper (<) | `f < g` |
| ω(g) | Strict lower (>) | `f > g` |

**Key properties** (analogous to inequalities):

- **Reflexivity**: `f(n) = O(f(n))`, `f(n) = Ω(f(n))`, `f(n) = Θ(f(n))` — but not for `o`, `ω`.
- **Symmetry**: `f(n) = Θ(g(n))` iff `g(n) = Θ(f(n))`.
- **Transpose symmetry**: `f(n) = O(g(n))` iff `g(n) = Ω(f(n))`.
- **Transitivity**: if `f = O(g)` and `g = O(h)`, then `f = O(h)` (same holds for Ω, Θ, o, ω).

**Common misconception**: Big-O does *not* mean "worst case" by definition — it is just an upper bound on whatever case you are analyzing (best, average, or worst). People say "worst-case is O(n²)" because that is the case being bounded, not because O itself implies worst case.

---

## 4. Rules for Combining Asymptotic Notations

- **Sum rule** (sequential statements): `O(f(n)) + O(g(n)) = O(max(f(n), g(n)))`
  Example: a loop of `n` followed by a loop of `n²` is `O(n²)`, not `O(n³)`.

- **Product rule** (nested statements): `O(f(n)) × O(g(n)) = O(f(n)·g(n))`
  Example: a loop of `n` inside a loop of `n` is `O(n²)`.

- **Constants are dropped**: `O(c·f(n)) = O(f(n))` for any constant `c > 0`.

- **Only the dominant term survives**: `O(n³ + n² + n) = O(n³)`.

- **Polynomial dominance**: any polynomial of degree `k` is `O(n^k)` regardless of lower-order terms or coefficients.

---

## 5. Growth Rate Hierarchy

From slowest to fastest growing (each is `o()` of the next):

```
O(1) < O(log n) < O(√n) < O(n) < O(n log n) < O(n²) < O(n³) < ... < O(n^k) < O(2ⁿ) < O(n!) < O(nⁿ)
```

| Class | Name | Typical source |
|---|---|---|
| O(1) | Constant | Array index access, hash lookup (avg) |
| O(log n) | Logarithmic | Binary search, balanced BST height |
| O(√n) | Root | Trial division primality check |
| O(n) | Linear | Single pass / linear search |
| O(n log n) | Linearithmic | Merge sort, heap sort, efficient sorting lower bound |
| O(n²) | Quadratic | Nested loops, bubble/insertion sort |
| O(n³) | Cubic | Naive matrix multiplication, Floyd–Warshall |
| O(2ⁿ) | Exponential | Subsets, naive recursive Fibonacci |
| O(n!) | Factorial | Permutations, brute-force TSP |

A useful exam fact: **comparison-based sorting has a proven lower bound of Ω(n log n)** — no comparison sort can beat this, because there are `n!` possible orderings and a decision tree needs `log₂(n!) = Θ(n log n)` comparisons to distinguish them.

---

## 6. Analyzing Time Complexity

### Consecutive (non-nested) statements — apply the sum rule, take the maximum

```java
for (int i = 0; i < n; i++) { }      // O(n)
for (int j = 0; j < n; j++)          // O(n²)
    for (int k = 0; k < n; k++) { }
// total: O(n) + O(n²) = O(n²)
```

### Nested, dependent loops (variable bound) — count actual iterations, don't assume the product blindly

For `for (i = 0; i < n; i++) for (j = 0; j < i; j++)`, total iterations = `0+1+2+...+(n-1) = n(n-1)/2 = O(n²)`. The bound still comes out `O(n²)`, but you should be able to derive it, not just guess it.

### Loops with multiplicative step — logarithmic

```java
for (int i = 1; i < n; i *= 2) { }   // O(log n): i doubles each time
```

### General procedure for any block of code

1. Identify the basic operation (comparison, assignment, arithmetic step).
2. Count how many times it executes as a function of `n`.
3. Drop constants and lower-order terms to get the asymptotic class.

---

## 7. Recurrence Relations

Recursive algorithms are analyzed with a **recurrence relation**: `T(n)` expressed in terms of `T` on smaller inputs. Three standard solving methods:

### 7.1 Substitution Method (guess and prove by induction)

Guess a bound, then prove it holds by mathematical induction.

Example: `T(n) = 2T(n/2) + n`. Guess `T(n) = O(n log n)`, i.e. `T(n) ≤ c·n·log n`.

*Inductive step*: assume true for `n/2`: `T(n/2) ≤ c(n/2)log(n/2)`.
```
T(n) = 2T(n/2) + n
     ≤ 2·c(n/2)log(n/2) + n
     = cn·log(n/2) + n
     = cn·log n − cn + n
     ≤ cn·log n     (holds whenever c ≥ 1)
```
So `T(n) = O(n log n)`. ∎

### 7.2 Recursion Tree Method

Draw the recursion as a tree, find the cost per level, then sum across levels.

Example: `T(n) = T(n/3) + T(2n/3) + n`. Every level costs exactly `n` in total work (the split sizes add up to the parent's cost), and the tree has depth `O(log n)` (bounded by the slower-shrinking branch `2n/3`). Total cost ≈ `n · O(log n) = O(n log n)`.

### 7.3 Master Theorem (for `T(n) = aT(n/b) + f(n)`, with `a ≥ 1`, `b > 1`)

Compare `f(n)` against `n^(log_b a)`:

| Case | Condition | Result |
|---|---|---|
| 1 | `f(n) = O(n^(log_b a − ε))` for some `ε > 0` | `T(n) = Θ(n^(log_b a))` |
| 2 | `f(n) = Θ(n^(log_b a) · logᵏ n)` for `k ≥ 0` | `T(n) = Θ(n^(log_b a) · log^(k+1) n)` |
| 3 | `f(n) = Ω(n^(log_b a + ε))` for some `ε > 0`, and `a·f(n/b) ≤ c·f(n)` for some `c < 1` (regularity condition) | `T(n) = Θ(f(n))` |

**Worked examples:**

- `T(n) = 2T(n/2) + n` → `a=2, b=2`, `n^(log₂2)=n`. `f(n)=n=Θ(n^1 log⁰n)` → **Case 2** → `T(n) = Θ(n log n)` (this is merge sort).
- `T(n) = 8T(n/2) + n²` → `n^(log₂8)=n³`. `f(n)=n²=O(n^(3−ε))` → **Case 1** → `T(n) = Θ(n³)`.
- `T(n) = 2T(n/2) + n²` → `n^(log₂2)=n`. `f(n)=n²=Ω(n^(1+ε))`, regularity holds → **Case 3** → `T(n) = Θ(n²)`.

**Common recurrences you should recognize instantly:**

| Recurrence | Solution | Algorithm |
|---|---|---|
| `T(n) = T(n/2) + O(1)` | `Θ(log n)` | Binary search |
| `T(n) = 2T(n/2) + O(n)` | `Θ(n log n)` | Merge sort |
| `T(n) = T(n-1) + O(1)` | `Θ(n)` | Simple linear recursion |
| `T(n) = T(n-1) + O(n)` | `Θ(n²)` | Selection sort (recursive) |
| `T(n) = 2T(n-1) + O(1)` | `Θ(2ⁿ)` | Naive recursive Fibonacci |

---

## 8. Space Complexity

### Components of space used by a program

```
Total space = Fixed part + Variable part
```

- **Fixed part**: space for code, simple variables, constants — independent of input size.
- **Variable part (auxiliary space)**: space for dynamically allocated memory, recursion stack, and data structures that scale with input.

Two related but distinct terms:

- **Auxiliary space**: extra space used *excluding* the input itself. This is usually what "space complexity" means in interviews.
- **Total space complexity**: auxiliary space + input space.

An algorithm is called **in-place** if its auxiliary space is `O(1)` — it only uses a constant amount of extra memory beyond the input (e.g., swapping elements within the same array).

### Recursive algorithms and stack space

Every recursive call adds a frame to the call stack. Space complexity of recursion = `O(maximum depth of the recursion tree)`, not the number of calls.

```java
static long factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);   // depth n → O(n) stack space
}
```

Note the contrast with naive Fibonacci: its **time** complexity is `O(2ⁿ)` because the number of calls is exponential, but its **space** complexity is only `O(n)`, because at any moment the call stack holds at most `n` frames (only one branch of the recursion tree is "in progress" at a time). This distinction — time counts total calls, space counts maximum simultaneous depth — is one of the most tested ideas in this topic.

### Common space complexities

| Class | Example |
|---|---|
| O(1) | In-place swap-based sorts (heap sort, insertion sort) |
| O(log n) | Recursive binary search, balanced BST traversal (stack depth) |
| O(n) | Copying an array, single-branch recursion, merge sort's auxiliary array |
| O(n²) | Adjacency matrix, DP table for two-parameter problems |

---

## 9. Amortized Analysis

Amortized analysis bounds the **average cost per operation over a worst-case sequence of operations**, even when individual operations occasionally cost much more. It is not the same as average-case analysis (which assumes a probability distribution over inputs) — amortized bounds hold for every possible sequence.

Three standard methods:

- **Aggregate method**: compute total cost of `n` operations, divide by `n`.
  Example: dynamic array (ArrayList) doubling — `n` insertions cost `O(n)` total (geometric series of resize costs), so amortized cost per insertion is `O(1)`.

- **Accounting (banker's) method**: assign each operation an amortized "charge"; overcharge cheap operations to prepay for expensive ones later, keeping a non-negative credit balance at all times.

- **Potential method**: define a potential function `Φ` over the data structure's state; amortized cost of an operation = actual cost + change in potential (`Φᵢ − Φᵢ₋₁`).

---

## 10. Best, Average, and Worst Case

These describe *which input* you are analyzing; O, Ω, Θ describe *how tightly* you are bounding that case. The two ideas are independent of each other.

| Case | Meaning |
|---|---|
| Best case | Most favorable input (e.g., already-sorted array for insertion sort) |
| Average case | Expected performance over a distribution of inputs |
| Worst case | Least favorable input — the standard for guarantees |

**Quick sort example**: best/average case `Θ(n log n)` with a good pivot choice, worst case `Θ(n²)` when the pivot is always the smallest/largest element (e.g., already-sorted input with a naive pivot rule).

---

## 11. Comparison Tables

### Sorting Algorithms

| Algorithm | Best | Average | Worst | Space | Stable? |
|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | No |
| Counting Sort | O(n+k) | O(n+k) | O(n+k) | O(n+k) | Yes |
| Radix Sort | O(nk) | O(nk) | O(nk) | O(n+k) | Yes |

### Searching Algorithms

| Algorithm | Best | Average | Worst | Space |
|---|---|---|---|---|
| Linear Search | O(1) | O(n) | O(n) | O(1) |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| Hash Table | O(1) | O(1) | O(n) | O(n) |
| BST Search | O(1) | O(log n) | O(n) | O(1) |
| AVL / Balanced Tree | O(1) | O(log n) | O(log n) | O(1) |

### Data Structure Operations

| Structure | Access | Search | Insert | Delete | Space |
|---|---|---|---|---|---|
| Array | O(1) | O(n) | O(n) | O(n) | O(n) |
| Dynamic Array | O(1) | O(n) | O(1) amortized | O(n) | O(n) |
| Linked List | O(n) | O(n) | O(1)* | O(1)* | O(n) |
| Stack / Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| Hash Table | N/A | O(1) avg | O(1) avg | O(1) avg | O(n) |
| Balanced BST | O(log n) | O(log n) | O(log n) | O(log n) | O(n) |
| Binary Heap | O(1)** | O(n) | O(log n) | O(log n) | O(n) |
| Graph (adj. list) | — | O(V+E) | O(1) | O(E) | O(V+E) |
| Graph (adj. matrix) | O(1) edge check | O(1) edge check | O(1) | O(1) | O(V²) |

\* at a known position (e.g., head); O(n) to find the position first
\** peek at min/max only

---

## 12. Complexity Classes Beyond Big-O (P, NP)

A short conceptual layer that final-year courses usually connect to time complexity:

- **P**: problems solvable in polynomial time, `O(n^k)` for some constant `k`, by a deterministic algorithm.
- **NP**: problems whose *proposed solution* can be **verified** in polynomial time (not necessarily solved in polynomial time).
- **NP-Complete**: the hardest problems in NP — every problem in NP can be reduced to them in polynomial time (e.g., SAT, TSP decision version, Knapsack decision version).
- **NP-Hard**: at least as hard as NP-Complete problems, but not required to be in NP themselves (may not even have a verifiable polynomial-time check).
- **P vs NP**: still an open problem — whether `P = NP` is one of the seven Millennium Prize problems.

This is why algorithms like brute-force TSP or subset-sum stay at exponential/factorial time: no polynomial-time solution is known, and proving one exists (or doesn't) would resolve P vs NP.

---

## 13. Quick Revision Sheet

- `O` = upper bound, `Ω` = lower bound, `Θ` = tight bound, `o`/`ω` = their strict versions.
- Formal O: `f(n) ≤ c·g(n)` for `n ≥ n₀`.
- Sum rule → take the max; product rule → multiply, for nested loops.
- Recursion: solve with substitution, recursion tree, or Master theorem.
- Master theorem compares `f(n)` to `n^(log_b a)` — three cases based on which one dominates.
- Space complexity of recursion = **maximum call-stack depth**, not the number of calls.
- In-place = `O(1)` auxiliary space.
- Amortized ≠ average case — amortized holds over any worst-case sequence of operations.
- Comparison sorting has a proven `Ω(n log n)` lower bound.
- Best/average/worst describe *which input*; O/Ω/Θ describe *how tight the bound* is — independent axes.
