// Program to demonstrate Anonymous Classes using an Interface

public class _15_AnonymousClass_Interface {

    // INTERFACE
    interface Animal {

        void sound();

        default void eat() {
            System.out.println("Animal is eating.");
        }
    }

    public static void main(String[] args) {

        // ANONYMOUS CLASS
        // No separate implementing class is created.
        Animal dog = new Animal() {

            @Override
            public void sound() {
                System.out.println("Dog barks.");
            }
        };

        dog.sound();
        dog.eat();
    }
}