// Program to demonstrate Classes and Objects in Java

// ---------- STUDENT CLASS ----------
// A class is a blueprint/template for creating objects
class Student {

    // ---------- ATTRIBUTES ----------
    // These represent the data/state of a Student object
    String name;
    int age;
    double marks;

    // ---------- METHOD ----------
    // This represents the behaviour of a Student object
    void displayDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);
    }
}


// ---------- MAIN CLASS ----------
public class _01_ClassesObjects {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // 1. CREATING OBJECTS
        //
        // Student     → class/type
        // student1   → reference variable
        // new Student() → creates an object in heap memory
        // -------------------------------------------------------

        Student student1 = new Student();
        Student student2 = new Student();

        // -------------------------------------------------------
        // 2. ASSIGNING VALUES TO OBJECT ATTRIBUTES
        // -------------------------------------------------------

        student1.name = "Aditya";
        student1.age = 20;
        student1.marks = 89.5;

        student2.name = "Rahul";
        student2.age = 21;
        student2.marks = 92.0;

        // -------------------------------------------------------
        // 3. ACCESSING OBJECT DATA
        // -------------------------------------------------------
        System.out.println("---- Student 1 ----");
        System.out.println("Name  : " + student1.name);
        System.out.println("Age   : " + student1.age);
        System.out.println("Marks : " + student1.marks);

        System.out.println("\n---- Student 2 ----");
        System.out.println("Name  : " + student2.name);
        System.out.println("Age   : " + student2.age);
        System.out.println("Marks : " + student2.marks);

        // -------------------------------------------------------
        // 4. CALLING OBJECT METHOD
        // -------------------------------------------------------
        System.out.println("\n---- Using displayDetails() ----");
        student1.displayDetails();

        System.out.println();
        student2.displayDetails();
    }
}