/**
 * Program 5: Methods & Constructors
 *
 * This program demonstrates in detail:
 *
 * 1. Method Definitions:
 *    - Instance methods vs. static methods.
 *    - Method Overloading: Multiple methods with the same name but different parameters.
 *    - Return types and void methods.
 *
 * 2. Constructors:
 *    - Default constructors and parameterized constructors.
 *    - Constructor Overloading and Chaining using 'this()'.
 *    - Use of 'this' keyword to refer to current object's members.
 *
 * 3. Demonstration:
 *    - Creating objects with different constructors.
 *    - Calling overloaded instance methods and static methods.
 *
 * To compile: javac 05_methods.java
 * To run:     java 05_methods
 */

public class MethodsAndConstructors {
    public static void main(String[] args) {
        System.out.println("=== Methods and Constructors Demonstration ===\n");

        // Demonstration of method overloading using MathOperations class.
        MathOperations mathOps = new MathOperations();
        System.out.println("Addition (two integers): " + mathOps.add(5, 10));
        System.out.println("Addition (three integers): " + mathOps.add(5, 10, 15));
        System.out.println("Addition (double values): " + mathOps.add(5.5, 10.5));
        System.out.println();

        // Demonstration of a static method call.
        System.out.println("Static multiplication (3 * 4): " + MathOperations.multiply(3, 4));
        System.out.println();

        // Creating Employee objects to demonstrate constructors.
        System.out.println("Creating Employee objects:");
        Employee emp1 = new Employee();  // Calls default constructor
        emp1.displayInfo();

        System.out.println();
        // Using the parameterized constructor.
        Employee emp2 = new Employee("Alice", 30, "Engineering");
        emp2.displayInfo();

        System.out.println();
        // Using an overloaded constructor with constructor chaining.
        Employee emp3 = new Employee("Bob", 25);
        emp3.displayInfo();
    }
}

/**
 * Class MathOperations demonstrates method overloading and static methods.
 */
class MathOperations {
    /**
     * Adds two integers.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Overloaded method: Adds three integers.
     */
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Overloaded method: Adds two double values.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * A static method to multiply two integers.
     */
    public static int multiply(int a, int b) {
        return a * b;
    }
}

/**
 * Class Employee demonstrates the use of constructors and methods.
 */
class Employee {
    // Instance variables
    private String name;
    private int age;
    private String department;

    /**
     * Default constructor.
     * Initializes Employee with default values using constructor chaining.
     */
    public Employee() {
        this("Unknown", 0, "None");
        System.out.println("Default constructor called.");
    }

    /**
     * Parameterized constructor.
     * @param name the name of the employee.
     * @param age the age of the employee.
     * @param department the department where the employee works.
     */
    public Employee(String name, int age, String department) {
        // Using 'this' keyword to refer to instance variables.
        this.name = name;
        this.age = age;
        this.department = department;
        System.out.println("Parameterized constructor (3 params) called.");
    }

    /**
     * Overloaded constructor with two parameters.
     * Uses constructor chaining to set a default department.
     * @param name the name of the employee.
     * @param age the age of the employee.
     */
    public Employee(String name, int age) {
        // Calls the three-parameter constructor with a default department.
        this(name, age, "General");
        System.out.println("Overloaded constructor (2 params) called.");
    }

    /**
     * Displays information about the Employee.
     */
    public void displayInfo() {
        System.out.println("Employee Info: Name = " + name + ", Age = " + age + ", Department = " + department);
    }
}
