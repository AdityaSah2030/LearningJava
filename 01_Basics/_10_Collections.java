// Program to demonstrate Collections in Java
// Covers: ArrayList, LinkedList, HashSet, HashMap, iteration, sorting

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class _10_Collections {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // WHY COLLECTIONS?
        // Arrays have fixed size — once created, cannot grow or shrink
        // Collections are DYNAMIC — resize automatically
        //
        // java.util.Collections Framework:
        //   List  → ordered, allows duplicates  (ArrayList, LinkedList)
        //   Set   → unordered, NO duplicates    (HashSet, TreeSet)
        //   Map   → key-value pairs             (HashMap, TreeMap)
        // -------------------------------------------------------

        // -------------------------------------------------------
        // PART 1: ArrayList<T>
        // → Dynamic array, ordered, allows duplicates, index-based access
        // → Best for: frequent read/access by index
        // -------------------------------------------------------
        System.out.println("==============================");
        System.out.println("        ARRAYLIST");
        System.out.println("==============================");

        // <Integer> is the generic type — tells ArrayList what type to store
        // Use wrapper classes (Integer, Double, etc.) NOT primitives (int, double)
        ArrayList<String> fruits = new ArrayList<>();   // empty list, <> is diamond operator

        // ---------- ADDING ELEMENTS ----------
        fruits.add("Apple");                // add to end
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add(1, "Grapes");            // add at specific index (shifts others right)

        System.out.println("Fruits list : " + fruits);          // [Apple, Grapes, Banana, Mango, Orange]
        System.out.println("Size        : " + fruits.size());   // 5 (not .length — collections use .size())

        // ---------- ACCESSING ELEMENTS ----------
        System.out.println("Index 0     : " + fruits.get(0));   // Apple
        System.out.println("Index 2     : " + fruits.get(2));   // Banana

        // ---------- MODIFYING ELEMENTS ----------
        fruits.set(2, "Papaya");            // replace element at index 2
        System.out.println("After set(2): " + fruits);

        // ---------- REMOVING ELEMENTS ----------
        fruits.remove("Orange");            // remove by value (first occurrence)
        fruits.remove(0);                   // remove by index
        System.out.println("After remove: " + fruits);

        // ---------- SEARCHING ----------
        System.out.println("Contains Mango  : " + fruits.contains("Mango"));   // true
        System.out.println("Index of Mango  : " + fruits.indexOf("Mango"));    // index or -1
        System.out.println("isEmpty         : " + fruits.isEmpty());           // false

        // ---------- SORTING ----------
        Collections.sort(fruits);           // sorts alphabetically (natural order)
        System.out.println("Sorted          : " + fruits);

        Collections.reverse(fruits);        // reverse the list
        System.out.println("Reversed        : " + fruits);

        // ---------- ITERATION ----------
        System.out.println("\n-- Iteration Methods --");

        // Method 1: for-each loop (simplest)
        System.out.print("for-each    : ");
        for (String f : fruits) {
            System.out.print(f + " ");
        }
        System.out.println();

        // Method 2: index-based for loop (when you need the index)
        System.out.print("index loop  : ");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.print(i + ":" + fruits.get(i) + " ");
        }
        System.out.println();

        // Method 3: forEach with lambda (Java 8+)
        System.out.print("forEach λ   : ");
        fruits.forEach(f -> System.out.print(f + " "));     // lambda expression
        System.out.println();

        // ---------- ARRAYLIST OF INTEGERS ----------
        System.out.println("\n-- ArrayList<Integer> --");
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 5; i++) nums.add(i * 10);     // 10 20 30 40 50
        System.out.println("Numbers       : " + nums);
        System.out.println("Min           : " + Collections.min(nums));
        System.out.println("Max           : " + Collections.max(nums));
        Collections.shuffle(nums);
        System.out.println("Shuffled      : " + nums);

        // ---------- CONVERTING ARRAY ↔ ARRAYLIST ----------
        System.out.println("\n-- Array ↔ ArrayList --");
        String[] arr = {"X", "Y", "Z"};
        ArrayList<String> fromArray = new ArrayList<>(java.util.Arrays.asList(arr));  // Array → ArrayList
        System.out.println("From array    : " + fromArray);

        Object[] backToArray = fromArray.toArray();        // ArrayList → Array
        System.out.println("Back to array : " + java.util.Arrays.toString(backToArray));


        // -------------------------------------------------------
        // PART 2: LinkedList<T>
        // → Doubly linked list, fast insert/delete at both ends
        // → Slower random access than ArrayList
        // → Best for: frequent insertions/deletions at ends (e.g., queue/stack use cases)
        // -------------------------------------------------------
        System.out.println("\n==============================");
        System.out.println("        LINKEDLIST");
        System.out.println("==============================");

        LinkedList<String> queue = new LinkedList<>();
        queue.addFirst("Task 1");           // add to front
        queue.addLast("Task 2");            // add to end
        queue.addLast("Task 3");
        queue.addFirst("Urgent Task");
        System.out.println("LinkedList  : " + queue);
        System.out.println("First       : " + queue.getFirst());
        System.out.println("Last        : " + queue.getLast());
        queue.removeFirst();                // remove from front
        System.out.println("After removeFirst: " + queue);


        // -------------------------------------------------------
        // PART 3: HashSet<T>
        // → Unordered collection, NO duplicate values
        // → Very fast add/contains/remove (O(1))
        // → Best for: uniqueness checks
        // -------------------------------------------------------
        System.out.println("\n==============================");
        System.out.println("        HASHSET");
        System.out.println("==============================");

        HashSet<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red");      // duplicate — silently ignored
        colors.add("Green");    // duplicate — silently ignored

        System.out.println("HashSet     : " + colors);                 // order NOT guaranteed
        System.out.println("Size        : " + colors.size());          // 3 (duplicates removed)
        System.out.println("Has 'Blue'  : " + colors.contains("Blue")); // true

        colors.remove("Green");
        System.out.println("After remove: " + colors);


        // -------------------------------------------------------
        // PART 4: HashMap<K, V>
        // → Stores KEY → VALUE pairs
        // → Keys are unique; values can repeat
        // → Very fast lookup by key (O(1))
        // → Best for: dictionaries, frequency counts, lookups
        // -------------------------------------------------------
        System.out.println("\n==============================");
        System.out.println("        HASHMAP");
        System.out.println("==============================");

        HashMap<String, Integer> scores = new HashMap<>();

        // ---------- ADDING KEY-VALUE PAIRS ----------
        scores.put("Alice", 95);        // put(key, value)
        scores.put("Bob", 82);
        scores.put("Charlie", 78);
        scores.put("Diana", 90);
        scores.put("Alice", 99);        // duplicate key → OVERWRITES existing value

        System.out.println("Scores map  : " + scores);
        System.out.println("Size        : " + scores.size());          // 4 (Alice overwritten, not duplicated)

        // ---------- ACCESSING VALUES ----------
        System.out.println("Alice's score  : " + scores.get("Alice"));         // 99
        System.out.println("Bob's score    : " + scores.get("Bob"));           // 82
        System.out.println("Unknown key    : " + scores.get("Zara"));          // null (key not found)

        // getOrDefault — returns default if key missing
        System.out.println("Eve (default)  : " + scores.getOrDefault("Eve", 0)); // 0

        // ---------- CHECKING KEYS/VALUES ----------
        System.out.println("Has key 'Diana'  : " + scores.containsKey("Diana"));     // true
        System.out.println("Has value 82     : " + scores.containsValue(82));        // true
        System.out.println("Is empty?        : " + scores.isEmpty());                // false

        // ---------- MODIFYING ----------
        scores.put("Charlie", 85);      // update Charlie's score
        scores.remove("Bob");           // remove Bob entirely
        System.out.println("After updates: " + scores);

        // ---------- ITERATING OVER HASHMAP ----------
        System.out.println("\n-- Iteration Methods --");

        // Method 1: iterate over keys using keySet()
        System.out.println("Keys only:");
        for (String key : scores.keySet()) {
            System.out.println("  " + key);
        }

        // Method 2: iterate over values using values()
        System.out.println("Values only:");
        for (int val : scores.values()) {
            System.out.println("  " + val);
        }

        // Method 3: iterate over key-value pairs using entrySet() — MOST COMMON
        System.out.println("Key-Value pairs:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }

        // Method 4: forEach with lambda (Java 8+)
        System.out.println("forEach lambda:");
        scores.forEach((k, v) -> System.out.println("  " + k + " : " + v));

        // ---------- PRACTICAL EXAMPLE: Frequency Count with HashMap ----------
        System.out.println("\n-- Frequency Count Example --");
        String sentence = "the quick brown fox jumps over the lazy dog the fox";
        String[] words = sentence.split(" ");

        HashMap<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);  // increment count, default 0
        }
        System.out.println("Word frequencies: " + freq);
    }
}


/*
=============================================
COLLECTION QUICK REFERENCE
=============================================

ArrayList<T>
→ add(val), add(idx, val), get(idx), set(idx, val),
    remove(idx), remove(val), size(), contains(val),
    indexOf(val), isEmpty(), clear()
→ Sort: Collections.sort(list)
→ Import: java.util.ArrayList

LinkedList<T>
→ addFirst(), addLast(), getFirst(), getLast(),
    removeFirst(), removeLast() — plus all ArrayList methods
→ Import: java.util.LinkedList

HashSet<T>
→ add(val), remove(val), contains(val), size(), isEmpty()
→ No get(index) — no index-based access
→ Import: java.util.HashSet

HashMap<K, V>
→ put(key, val), get(key), remove(key),
    containsKey(key), containsValue(val),
    keySet(), values(), entrySet(), size()
→ getOrDefault(key, defaultVal) — safe get
→ Import: java.util.HashMap, java.util.Map

=============================================
ARRAY vs ARRAYLIST
=============================================

| Feature       | Array          | ArrayList              |
|---------------|----------------|------------------------|
| Size          | Fixed          | Dynamic                |
| Type          | Primitive OK   | Wrapper class only     |
| Access speed  | Faster         | Slightly slower        |
| Methods       | None           | add, remove, sort etc. |
| Syntax        | int[] arr      | ArrayList<Integer> list|
| Length        | arr.length     | list.size()            |

=============================================
*/