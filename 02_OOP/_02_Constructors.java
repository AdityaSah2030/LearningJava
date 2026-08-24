// Program to demonstrate Constructors in Java
// Covers: default, non-parameterized, parameterized and copy constructors

// ---------- STUDENT CLASS ----------
class Student {

    String name;
    int age;
    double marks;

    // -------------------------------------------------------
    // 1. DEFAULT CONSTRUCTOR
    //
    // If no constructor is written, Java automatically provides
    // a default constructor with no parameters.
    //
    // This constructor is shown through the DefaultStudent class
    // below because writing any constructor removes the compiler-
    // generated default constructor.
    // -------------------------------------------------------

}


// ---------- STUDENT WITH NON-PARAMETERIZED CONSTRUCTOR ----------
class NonParameterizedStudent {

    String name;
    int age;
    double marks;

    // -------------------------------------------------------
    // 2. NON-PARAMETERIZED / NO-ARGUMENT CONSTRUCTOR
    //
    // This constructor is explicitly written by the programmer
    // and does not take any parameters.
    // -------------------------------------------------------

    NonParameterizedStudent() {
        name = "Unknown";
        age = 0;
        marks = 0.0;
    }

    void displayDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);
    }
}


// ---------- STUDENT WITH PARAMETERIZED CONSTRUCTOR ----------
class ParameterizedStudent {

    String name;
    int age;
    double marks;

    // -------------------------------------------------------
    // 3. PARAMETERIZED CONSTRUCTOR
    //
    // Constructor receives values as parameters and initializes
    // the object's attributes.
    // -------------------------------------------------------

    ParameterizedStudent(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    void displayDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);
    }
}


// ---------- STUDENT WITH COPY CONSTRUCTOR ----------
class CopyStudent {

    String name;
    int age;
    double marks;

    // Parameterized constructor
    CopyStudent(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // -------------------------------------------------------
    // 4. COPY CONSTRUCTOR
    //
    // Creates a new object by copying values from another object
    // of the same class.
    // -------------------------------------------------------

    CopyStudent(CopyStudent student) {
        this.name = student.name;
        this.age = student.age;
        this.marks = student.marks;
    }

    void displayDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);
    }
}


// ---------- MAIN CLASS ----------
public class _02_Constructors {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // 1. DEFAULT CONSTRUCTOR
        //
        // The Student class has no constructor, so Java provides
        // a compiler-generated default constructor automatically.
        // Attributes receive their default values:
        // String → null, int → 0, double → 0.0
        // -------------------------------------------------------

        Student student1 = new Student();

        System.out.println("---- Default Constructor ----");
        System.out.println("Name  : " + student1.name);
        System.out.println("Age   : " + student1.age);
        System.out.println("Marks : " + student1.marks);


        // -------------------------------------------------------
        // 2. NON-PARAMETERIZED CONSTRUCTOR
        // -------------------------------------------------------

        NonParameterizedStudent student2 = new NonParameterizedStudent();

        System.out.println("\n---- Non-Parameterized Constructor ----");
        student2.displayDetails();


        // -------------------------------------------------------
        // 3. PARAMETERIZED CONSTRUCTOR
        // -------------------------------------------------------

        ParameterizedStudent student3 = new ParameterizedStudent("Aditya", 20, 89.5);

        System.out.println("\n---- Parameterized Constructor ----");
        student3.displayDetails();


        // -------------------------------------------------------
        // 4. COPY CONSTRUCTOR
        // -------------------------------------------------------

        CopyStudent student4 = new CopyStudent("Rahul", 21, 92.0);

        CopyStudent student5 = new CopyStudent(student4);

        System.out.println("\n---- Original Object ----");
        student4.displayDetails();

        System.out.println("\n---- Copied Object ----");
        student5.displayDetails();
    }
}