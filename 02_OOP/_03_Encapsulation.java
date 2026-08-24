// Program to demonstrate Encapsulation in Java

// ---------- STUDENT CLASS ----------
class Student {

    // -------------------------------------------------------
    // PRIVATE ATTRIBUTES
    //
    // private prevents direct access to these variables
    // from outside the Student class.
    //
    // This is called DATA HIDING.
    // -------------------------------------------------------

    private String name;
    private int age;
    private double marks;


    // -------------------------------------------------------
    // GETTER METHODS
    //
    // Getters are used to READ private data.
    // -------------------------------------------------------

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getMarks() {
        return marks;
    }


    // -------------------------------------------------------
    // SETTER METHODS
    //
    // Setters are used to MODIFY private data.
    // We can also add validation before changing the value.
    // -------------------------------------------------------

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }

    void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks.");
        }
    }
}


// ---------- MAIN CLASS ----------
public class _03_Encapsulation {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // 1. CREATING STUDENT OBJECT
        // -------------------------------------------------------

        Student student = new Student();


        // -------------------------------------------------------
        // 2. SETTING VALUES USING SETTERS
        //
        // Direct access like:
        // student.name = "Aditya";
        //
        // is NOT allowed because name is private.
        // -------------------------------------------------------

        student.setName("Aditya");
        student.setAge(20);
        student.setMarks(89.5);


        // -------------------------------------------------------
        // 3. ACCESSING VALUES USING GETTERS
        // -------------------------------------------------------

        System.out.println("---- Student Details ----");
        System.out.println("Name  : " + student.getName());
        System.out.println("Age   : " + student.getAge());
        System.out.println("Marks : " + student.getMarks());


        // -------------------------------------------------------
        // 4. VALIDATION USING SETTERS
        //
        // The setter can control what values are allowed.
        // -------------------------------------------------------

        System.out.println("\n---- Testing Validation ----");

        student.setAge(-5);
        student.setMarks(120);

        System.out.println("\nStudent Age   : " + student.getAge());
        System.out.println("Student Marks : " + student.getMarks());
    }
}