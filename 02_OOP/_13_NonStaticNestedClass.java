// Program to demonstrate Non-Static Nested Classes in Java

public class _13_NonStaticNestedClass {

    // OUTER CLASS
    static class University {

        String universityName = "Techno India";
        static String location = "Kolkata";

        // MEMBER INNER CLASS
        class Department {

            String departmentName = "AIML";

            void showDepartment() {
                System.out.println("University: " + universityName);
                System.out.println("Location: " + location);
                System.out.println("Department: " + departmentName);
            }
        }

        // METHOD CONTAINING A LOCAL CLASS
        void showStudent() {

            String studentName = "Aditya";

            // LOCAL INNER CLASS
            class Student {

                void showStudentInfo() {
                    System.out.println("Student: " + studentName);
                    System.out.println("University: " + universityName);
                    System.out.println("Location: " + location);
                }
            }

            Student student = new Student();
            student.showStudentInfo();
        }
    }

    public static void main(String[] args) {

        // OBJECT OF OUTER CLASS
        University university = new University();

        // OBJECT OF MEMBER INNER CLASS
        // An outer class object is required.
        University.Department department = university.new Department();

        System.out.println("---- Member Inner Class ----");
        department.showDepartment();

        // LOCAL INNER CLASS
        System.out.println("\n---- Local Inner Class ----");
        university.showStudent();
    }
}