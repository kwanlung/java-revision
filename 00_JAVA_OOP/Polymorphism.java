/**
 * Polymorphism in Java allows methods to do different things based on the object that it is acting upon.
 * It is a core concept of Object-Oriented Programming (OOP) that enables objects to be treated as instances of their parent class, allowing for method overriding and dynamic method dispatch.
 * There are two types of polymorphism in Java:
 * 1. Compile-time polymorphism (Method Overloading): This occurs when multiple methods have the same name but different parameters (type, number, or both).
 * 2. Runtime polymorphism (Method Overriding): This occurs when a subclass provides a specific implementation of a method that is already defined in its superclass.
 */
public class Polymorphism {
    // Example of Compile-time polymorphism (Method Overloading)
    public void display(int a) {
        System.out.println("Integer: " + a);
    }

    public void display(String b) {
        System.out.println("String: " + b);
    }

    // Example of Runtime polymorphism (Method Overriding)
    static class Animal {
        void sound() {
            System.out.println("Animal makes a sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Dog barks");
        }
    }

    static class Cat extends Animal {
        @Override
        void sound() {
            System.out.println("Cat meows");
        }
    }

    public static void main(String [] args){
        Polymorphism p = new Polymorphism();
        p.display(10); // Calls the method with integer parameter
        p.display("Hello"); // Calls the method with string parameter

        // Demonstrating Runtime polymorphism
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.sound(); // Outputs: Dog barks
        myCat.sound(); // Outputs: Cat meows
        // Using the parent class reference to call overridden methods
        Animal myAnimal = new Animal();
        myAnimal.sound(); // Outputs: Animal makes a sound
    }
}
