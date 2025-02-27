/**
 * Program 7: Inheritance Interfaces Polymorphism
 *
 * This program demonstrates:
 * 1. Inheritance:
 *    - An abstract class 'Animal' with shared attributes and methods.
 *    - Concrete subclasses 'Dog', 'Cat', and 'Lion' overriding the abstract method makeSound().
 *
 * 2. Interfaces:
 *    - The 'Pet' interface declares behaviors like play() and beFriendly().
 *    - 'Dog' and 'Cat' implement the Pet interface.
 *
 * 3. Polymorphism:
 *    - Using a single Animal reference to hold objects of different types.
 *    - Dynamic method dispatch: the overridden makeSound() method is called based on the object type.
 *    - Use of the instanceof operator to check interface implementation.
 *
 * To compile: javac 07_oops.java
 * To run:     java 07_oops
 */

public class InheritanceInterfacesPolymorphism {
    public static void main(String[] args) {
        System.out.println("=== Inheritance, Interfaces, and Polymorphism Demo ===\n");

        // Creating an array of Animal references holding different types of animals.
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Buddy", 3);    // Dog implements Pet.
        animals[1] = new Cat("Whiskers", 2);   // Cat implements Pet.
        animals[2] = new Lion("Simba", 5);     // Lion does not implement Pet.

        // Loop through the array and call methods polymorphically.
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal.getName());
            animal.makeSound(); // Calls the overridden method based on the actual object's type.
            animal.eat();       // Common method defined in the base class.

            // If the animal is a pet (i.e., implements the Pet interface), call pet-specific methods.
            if (animal instanceof Pet) {
                Pet pet = (Pet) animal;  // Downcasting to access Pet methods.
                pet.play();
                pet.beFriendly();
            } else {
                System.out.println(animal.getName() + " is not considered a pet.");
            }
            System.out.println();
        }
    }
}

/**
 * Abstract Class Animal:
 * Represents the general concept of an animal.
 */
abstract class Animal {
    protected String name;
    protected int age;

    /**
     * Constructor for Animal.
     * @param name the name of the animal.
     * @param age the age of the animal.
     */
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the animal.
     */
    public String getName() {
        return name;
    }

    /**
     * Common method for eating.
     */
    public void eat() {
        System.out.println(name + " is eating.");
    }

    /**
     * Abstract method to be implemented by subclasses to make the animal sound.
     */
    public abstract void makeSound();
}

/**
 * Interface Pet:
 * Declares behaviors expected of domesticated animals.
 */
interface Pet {
    /**
     * Defines how a pet plays.
     */
    void play();

    /**
     * Defines how a pet shows friendliness.
     */
    void beFriendly();
}

/**
 * Dog class:
 * Inherits from Animal and implements the Pet interface.
 */
class Dog extends Animal implements Pet {
    public Dog(String name, int age) {
        super(name, age);
    }

    /**
     * Overrides the abstract method from Animal.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    /**
     * Implementation of the play behavior for a Dog.
     */
    @Override
    public void play() {
        System.out.println(name + " is playing fetch.");
    }

    /**
     * Implementation of the friendly behavior for a Dog.
     */
    @Override
    public void beFriendly() {
        System.out.println(name + " wags its tail happily.");
    }
}

/**
 * Cat class:
 * Inherits from Animal and implements the Pet interface.
 */
class Cat extends Animal implements Pet {
    public Cat(String name, int age) {
        super(name, age);
    }

    /**
     * Overrides the abstract method from Animal.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    /**
     * Implementation of the play behavior for a Cat.
     */
    @Override
    public void play() {
        System.out.println(name + " is playing with a ball of yarn.");
    }

    /**
     * Implementation of the friendly behavior for a Cat.
     */
    @Override
    public void beFriendly() {
        System.out.println(name + " purrs softly.");
    }
}

/**
 * Lion class:
 * Inherits from Animal but does not implement the Pet interface, showing that not all animals are pets.
 */
class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

    /**
     * Overrides the abstract method from Animal.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " roars: ROAR!");
    }

    /**
     * Additional behavior specific to wild animals.
     */
    public void hunt() {
        System.out.println(name + " is hunting in the savanna.");
    }
}
