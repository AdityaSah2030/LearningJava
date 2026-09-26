// Program to demonstrate Anonymous Classes using an Abstract Class

public class _14_AnonymousClass_Abstract {

    // ABSTRACT CLASS
    abstract static class Animal {

        abstract void sound();

        void eat() {
            System.out.println("Animal is eating.");
        }
    }

    public static void main(String[] args) {

        // ANONYMOUS CLASS
        // No separate subclass name is created.
        Animal dog = new Animal() {

            @Override
            void sound() {
                System.out.println("Dog barks.");
            }
        };

        dog.sound();
        dog.eat();
    }
}