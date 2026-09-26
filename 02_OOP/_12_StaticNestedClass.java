// Program to demonstrate Static Nested Classes in Java

public class _12_StaticNestedClass {

    // OUTER CLASS
    static class University {

        String universityName = "Techno India";
        static String location = "Kolkata";

        void showUniversity() {
            System.out.println("University: " + universityName);
            System.out.println("Location: " + location);
        }

        // STATIC NESTED CLASS
        static class Department {

            String departmentName = "AIML";

            void showDepartment() {
                System.out.println("Department: " + departmentName);

                // Static nested class can directly access
                // static members of the outer class.
                System.out.println("Location: " + location);
            }

            static void showInfo() {
                System.out.println("This is a static nested class.");
                System.out.println("Outer class: University");
                System.out.println("Nested class: Department");
            }
        }
    }

    public static void main(String[] args) {

        // OBJECT OF OUTER CLASS
        University university = new University();
        university.showUniversity();

        // OBJECT OF STATIC NESTED CLASS
        // No object of University is required.
        University.Department department = new University.Department();

        System.out.println("\n---- Department ----");
        department.showDepartment();

        // CALLING STATIC METHOD OF NESTED CLASS
        System.out.println("\n---- Static Nested Class ----");
        University.Department.showInfo();
    }
}