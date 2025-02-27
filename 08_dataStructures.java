/**
 * Program 8: Data Structures
 *
 * This program demonstrates several core data structures in Java:
 *
 * 1. Lists:
 *    - ArrayList: Dynamic array implementation.
 *    - LinkedList: Doubly-linked list implementation.
 *
 * 2. Sets:
 *    - HashSet: Unordered collection of unique elements.
 *    - TreeSet: Sorted collection of unique elements.
 *
 * 3. Maps:
 *    - HashMap: Key-value pairs with fast access.
 *    - TreeMap: Sorted map based on keys.
 *
 * 4. Queues:
 *    - PriorityQueue: Elements ordered based on natural ordering or a custom comparator.
 *    - LinkedList used as a Queue: FIFO ordering.
 *
 * 5. Stacks:
 *    - Stack: LIFO data structure.
 *
 * To compile: javac 08_dataStructures.java
 * To run:     java 08_dataStructures
 */

import java.util.*;

public class DataStructuresDemo {
    public static void main(String[] args) {
        System.out.println("=== Data Structures Demonstration ===\n");

        // 1. Lists
        demoLists();

        // 2. Sets
        demoSets();

        // 3. Maps
        demoMaps();

        // 4. Queues
        demoQueues();

        // 5. Stacks
        demoStacks();
    }

    /**
     * Demonstrates List implementations: ArrayList and LinkedList.
     */
    private static void demoLists() {
        System.out.println("1. Lists Demonstration:");

        // ArrayList: Dynamic array implementation.
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);

        // Inserting element at a specific index.
        arrayList.add(1, "Date");
        System.out.println("After inserting 'Date' at index 1: " + arrayList);

        // Removing an element.
        arrayList.remove("Banana");
        System.out.println("After removing 'Banana': " + arrayList);

        // Iterating using enhanced for loop.
        System.out.println("Iterating over ArrayList:");
        for (String fruit : arrayList) {
            System.out.println("- " + fruit);
        }
        System.out.println();

        // LinkedList: Doubly-linked list implementation.
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Lion");
        linkedList.add("Tiger");
        linkedList.add("Leopard");
        System.out.println("LinkedList: " + linkedList);

        // Adding at beginning and end using LinkedList specific methods.
        LinkedList<String> animalList = (LinkedList<String>) linkedList;
        animalList.addFirst("Cheetah");
        animalList.addLast("Panther");
        System.out.println("After adding at first and last: " + animalList);

        // Iterating using an iterator.
        System.out.println("Iterating over LinkedList using iterator:");
        Iterator<String> iterator = animalList.iterator();
        while (iterator.hasNext()) {
            System.out.println("-- " + iterator.next());
        }
        System.out.println();
    }

    /**
     * Demonstrates Set implementations: HashSet and TreeSet.
     */
    private static void demoSets() {
        System.out.println("2. Sets Demonstration:");

        // HashSet: Unordered collection, no duplicates.
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(42);
        hashSet.add(7);
        hashSet.add(15);
        hashSet.add(42); // Duplicate element will not be added.
        System.out.println("HashSet: " + hashSet);

        // Iterating over a HashSet.
        System.out.println("Iterating over HashSet:");
        for (Integer num : hashSet) {
            System.out.println("-- " + num);
        }

        // TreeSet: Sorted set implementation.
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(42);
        treeSet.add(7);
        treeSet.add(15);
        treeSet.add(99);
        System.out.println("TreeSet (sorted): " + treeSet);
        System.out.println();
    }

    /**
     * Demonstrates Map implementations: HashMap and TreeMap.
     */
    private static void demoMaps() {
        System.out.println("3. Maps Demonstration:");

        // HashMap: Stores key-value pairs.
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 30);
        hashMap.put("Bob", 25);
        hashMap.put("Charlie", 35);
        System.out.println("HashMap: " + hashMap);

        // Accessing a value by key.
        int ageOfAlice = hashMap.get("Alice");
        System.out.println("Age of Alice: " + ageOfAlice);

        // Iterating over key-value pairs.
        System.out.println("Iterating over HashMap entries:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("-- " + entry.getKey() + " : " + entry.getValue());
        }

        // TreeMap: Sorted map by keys.
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("David", 40);
        treeMap.put("Eve", 28);
        treeMap.put("Frank", 33);
        System.out.println("TreeMap (sorted by keys): " + treeMap);
        System.out.println();
    }

    /**
     * Demonstrates Queue implementations: PriorityQueue and LinkedList as Queue.
     */
    private static void demoQueues() {
        System.out.println("4. Queues Demonstration:");

        // PriorityQueue: Elements are ordered based on natural ordering.
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Peek from PriorityQueue: " + priorityQueue.peek());
        System.out.println("Poll from PriorityQueue: " + priorityQueue.poll());
        System.out.println("After poll, PriorityQueue: " + priorityQueue);

        // LinkedList as Queue: FIFO ordering.
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("LinkedList as Queue: " + queue);
        System.out.println("Peek from Queue: " + queue.peek());
        System.out.println("Poll from Queue: " + queue.poll());
        System.out.println("After poll, Queue: " + queue);
        System.out.println();
    }

    /**
     * Demonstrates the Stack data structure.
     */
    private static void demoStacks() {
        System.out.println("5. Stacks Demonstration:");

        // Stack: LIFO structure.
        Stack<String> stack = new Stack<>();
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");
        System.out.println("Initial Stack: " + stack);

        // Peek at the top element.
        System.out.println("Peek top element: " + stack.peek());

        // Pop elements from the stack.
        System.out.println("Popping elements from stack:");
        while (!stack.isEmpty()) {
            System.out.println("-- Popped: " + stack.pop());
        }
        System.out.println("Stack after popping all elements: " + stack);
        System.out.println();
    }
}
