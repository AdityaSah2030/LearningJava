/**
 * Generics
 *
 * This program demonstrates the usage of Generics in Java, covering:
 *
 * 1. Generic Class:
 *    - A simple generic class "Box<T>" that can hold any type of value.
 *
 * 2. Generic Methods:
 *    - A method to print elements of an array of any type.
 *    - A method to find the maximum element in an array using bounded type parameters.
 *
 * 3. Generic Interface:
 *    - A generic interface "Pair<K, V>" and its implementation.
 *
 * 4. Using Java Collections with Generics:
 *    - Demonstrates creating an ArrayList and a HashMap with specified type parameters.
 *
 * To compile: javac 11_generics.java
 * To run:     java 11_generics
 */

import java.util.*;

public class GenericsDemo {
    public static void main(String[] args) {
        System.out.println("=== Generics Demonstration ===\n");

        // 1. Generic Class: Box<T>
        Box<Integer> integerBox = new Box<>();
        integerBox.set(123);
        System.out.println("Box holding an Integer: " + integerBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics!");
        System.out.println("Box holding a String: " + stringBox.get());
        System.out.println();

        // 2. Generic Methods
        // Generic method to print array elements.
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"One", "Two", "Three"};
        System.out.println("Printing Integer array:");
        printArray(intArray);
        System.out.println("Printing String array:");
        printArray(strArray);
        System.out.println();

        // Generic method to find maximum element in an array
        Integer[] numbers = {10, 25, 5, 30, 20};
        Integer maxNumber = findMax(numbers);
        System.out.println("Maximum number in array: " + maxNumber);
        System.out.println();

        // 3. Generic Interface and its implementation
        // Create a pair of key-value elements
        Pair<String, Integer> personAge = new PairImpl<>("Alice", 30);
        System.out.println("Pair: " + personAge.getKey() + " is " + personAge.getValue() + " years old.");
        System.out.println();

        // 4. Using Java Collections with Generics
        // ArrayList with generics
        List<String> stringList = new ArrayList<>();
        stringList.add("Alpha");
        stringList.add("Beta");
        stringList.add("Gamma");
        System.out.println("ArrayList with Strings: " + stringList);

        // HashMap with generics
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount.put("Hello", 1);
        wordCount.put("World", 2);
        System.out.println("HashMap with String keys and Integer values: " + wordCount);
    }

    /**
     * Generic method to print elements of an array.
     *
     * @param array an array of any type.
     * @param <T> the type of elements in the array.
     */
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Generic method to find the maximum element in an array.
     * The type parameter T must extend Comparable<T> to allow comparison.
     *
     * @param array an array of elements that are comparable.
     * @param <T> the type of elements in the array.
     * @return the maximum element in the array.
     */
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null; // Alternatively, throw an exception.
        }
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
}

/**
 * Generic Class: Box<T>
 * This class encapsulates a single object of type T.
 *
 * @param <T> the type of the object to store in the box.
 */
class Box<T> {
    private T value;

    /**
     * Sets the value inside the box.
     *
     * @param value the value to be stored.
     */
    public void set(T value) {
        this.value = value;
    }

    /**
     * Retrieves the value stored in the box.
     *
     * @return the stored value.
     */
    public T get() {
        return value;
    }
}

/**
 * Generic Interface: Pair<K, V>
 * This interface represents a pair of objects: a key of type K and a value of type V.
 *
 * @param <K> the type of the key.
 * @param <V> the type of the value.
 */
interface Pair<K, V> {
    K getKey();
    V getValue();
}

/**
 * Implementation of the generic interface Pair<K, V>.
 *
 * @param <K> the type of the key.
 * @param <V> the type of the value.
 */
class PairImpl<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    /**
     * Constructor to initialize key and value.
     *
     * @param key the key of the pair.
     * @param value the value of the pair.
     */
    public PairImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key.
     *
     * @return the key.
     */
    @Override
    public K getKey() {
        return key;
    }

    /**
     * Returns the value.
     *
     * @return the value.
     */
    @Override
    public V getValue() {
        return value;
    }
}
