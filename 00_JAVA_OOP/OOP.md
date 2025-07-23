# Java OOP – Object-Oriented Programming Revision for Interviews
Java is a pure object-oriented language (except for primitive types), and interviewers assess your grasp of OOP principles, design thinking, and your ability to write maintainable and reusable code.


| Pillar            | Definition                                                           | Java Implementation                              | Real-World Example                      | Key Idea                                  |
|-------------------|----------------------------------------------------------------------|--------------------------------------------------|-----------------------------------------|-------------------------------------------|
| **Encapsulation** | Bundling data (fields) and methods into a single unit (class)        | Using private fields with public getters/setters | Medicine inside a pill capsule          | Protect data via access controls          |
| **Abstraction**   | Hiding implementation details and exposing only essential features   | Using abstract classes and interfaces            | Driver uses accelerator (hides engine)  | Simplify complexity by hiding details     |
| **Inheritance**   | Mechanism to acquire properties of another class (is-a relationship) | Using `extends`                                  | Puppy inherits traits from a Dog parent | Reuse code via parent-child relationships |
| **Polymorphism**  | Same interface, different behaviors                                  | Method overloading and overriding                | A woman acts as doctor/mother/athlete   | One interface, multiple implementations   |

## 💬 Common Interview Questions & Answers

### 1. What is Encapsulation in Java? Why is it important?
**Answer:**  
Encapsulation is the practice of keeping fields (data) private and providing public methods to access or modify them. This protects the internal state of an object from unintended changes and enforces control over how the data is accessed or updated.
```java
public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }
}
```
> 🔍 Interviewer might follow up with:  
"What if we make the field public?"  
👉 Answer: It breaks encapsulation, as external code can directly change the state (e.g., set a negative balance).
---
### 2. What is Abstraction? How is it implemented in Java?
Answer:  
Abstraction means hiding complex implementation details and showing only relevant information to the user. Java achieves abstraction using:
- **Abstract Classes:** Classes that cannot be instantiated and can contain abstract methods (without implementation).
- **Interfaces:** Contracts that classes can implement, defining methods that must be provided.

```java
abstract class Animal {
    abstract void makeSound();  // abstract method
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}
```
> ❗ Interviewer might ask:  
“When do you use an abstract class vs interface?”  
👉 Use interface for full abstraction or multiple inheritance of types; use abstract class when you want to share code across subclasses.
---
### 3. What is Inheritance? How does Java support it?
Answer:  
Inheritance lets one class acquire fields and methods of another class.
```java
// 父类
public class Vehicle {
    protected String brand; 
    protected String color;

    public void move() {
        System.out.println("Vehicle is moving...");
    }
}

// 子类继承父类
public class ElectricCar extends Vehicle {
    // 特有属性
    private int batteryCapacity;

    // 特有方法
    public void charge() {
        System.out.println("Charging the electric car...");
    }

    // 重写(Override)父类方法
    @Override
    public void move() {
        System.out.println("Electric car is moving silently...");
    }
}
```
> 🔁 Java supports single inheritance only (i.e., one class can extend only one parent class). But multiple inheritance of type is supported via interfaces.
---
### 4. What is Polymorphism? What are its types in Java?

Answer:  
Polymorphism allows the same method or interface to behave differently depending on the context.  

Two types:
- Compile-time Polymorphism (Method Overloading)
- Runtime Polymorphism (Method Overriding)

**Overloading example:**
```java
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```
**Overriding Example:**
```java
class Animal {
    void sound() { System.out.println("Generic sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Bark"); }
}
```
> ✅ Interview Tip: Always mention that method overriding requires inheritance + runtime binding (dynamic dispatch).


### 5. What is the difference between `==` and `equals()` in Java?
**Answer:**  
`==` checks for reference equality (whether both references point to the same object), while `equals()` checks for value equality (whether the contents of the objects are the same).

```java
String str1 = new String("Hello");
String str2 = new String("Hello");
System.out.println(str1 == str2);           // false (different references)
System.out.println(str1.equals(str2));      // true (same content)
``` 
> ❗ Interviewer might ask:
> "What if we use `==` on two String literals?"  
> 👉 Answer: String literals are interned, so `==` will return true if both refer to the same literal in the string pool.
```java
String str3 = "Hello";
String str4 = "Hello";
System.out.println(str3 == str4);          // true (same reference in string pool)
```

### 6. What is the use of `super` and `this`?
**Answer:**
- `super` is used to refer to the parent class's members (fields or methods)
- `this` refers to the current instance of the class.

```java
class Parent{
    void show(){
        System.out.println("Parent class method");
    }
}

class Child extends Parent{
    void display(){
        super.show();
    }
}
```

> Follow-up: Can this() and super() be used together?  
👉 No, both must be the first line in a constructor, so they cannot appear together.


### 7. What is the difference between an abstract class and an interface?
**Answer:**
- An abstract class can have both abstract and concrete methods, can have fields, and supports constructors. 
- An interface can only have abstract methods (until Java 8 introduced default methods) and cannot have fields or constructors.

  | Feature     | Abstract Class                              | Interface                                          |
  |-------------|---------------------------------------------|----------------------------------------------------|
  | Inheritance | `extends` (single)                          | `implements` (multiple)                            |
  | Methods     | Can have both abstract and concrete methods | Only abstract (Java 7), default & static (Java 8+) |
  | Fields      | Can have fields with access modifiers       | All fields are `public static final` (constants)   |
  | Constructor | Yes                                         | No                                                 |

> Use interface to define capabilities (e.g., `Runnable`, `Comparable`), and abstract class to model base behavior with shared code.

```java
abstract class AbstractClass {
    abstract void abstractMethod();
    void concreteMethod() {
        System.out.println("Concrete method in abstract class");
    }
}
interface MyInterface {
    void interfaceMethod(); // implicitly public and abstract
    default void defaultMethod() {
        System.out.println("Default method in interface");
    }
}
```

### 8. Can a class implement multiple interfaces? Can it extend a class and implement interfaces at the same time?
**Answer:**
1. **Can a class implement multiple interfaces?**  
   **Answer:** Yes, a class can implement multiple interfaces in Java. This allows a class to inherit behavior from multiple sources.
2. **Can it extend multiple classes?**  
   **Answer:** Java does `not` support multiple inheritance with classes (extends).

```java
interface Animal {
    void eat();
}
interface Flyable { void fly(); }
interface Swimmable { void swim(); }

class Duck extends Animal implements Flyable, Swimmable {
    public void fly() { System.out.println("Flying"); }
    public void swim() { System.out.println("Swimming"); }
}
```

### 9. What is the significance of the `final` keyword in Java?
**Answer:**
The `final` keyword in Java can be applied to classes, methods, and variables:
- **Final Class:** Cannot be subclassed (e.g., `String` class).
- **Final Method:** Cannot be overridden by subclasses.
- **Final Variable:** Its value cannot be changed once initialized (constant).

```java
final class FinalClass {
    final void finalMethod() {
        System.out.println("This method cannot be overridden");
    }
}
class SubClass extends FinalClass {
    // This will cause a compile-time error
    // void finalMethod() { System.out.println("Cannot override"); }
}
```

### 10. What are the SOLID principles?

| Principle                     | Meaning                                                                     |
|-------------------------------|-----------------------------------------------------------------------------|
| **S** – Single Responsibility | A class should have one and only one reason to change                       |
| **O** – Open/Closed           | Software entities should be open for extension, but closed for modification |
| **L** – Liskov Substitution   | Subtypes should be substitutable for base types                             |
| **I** – Interface Segregation | Prefer many small interfaces over one large interface                       |
| **D** – Dependency Inversion  | Depend on abstractions, not on concrete classes                             |

> You should briefly describe how these principles are followed using Java examples. For instance:  
    - SRP: Separate logging from business logic.  
    - OCP: Add new behavior using inheritance or strategy pattern.

### 11. Can you give a real-world example of OOP?
**Answer: Online payment system**

```java
abstract class Payment {
    abstract void pay(double amount);
}

class CreditCardpayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class paymentProcessor {
    void processPayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}
```
This demonstrates:

- Abstraction (Payment)

- Inheritance (CreditCardPayment)

- Polymorphism (payment.pay() dynamic dispatch)

- Encapsulation (each class manages its own logic)

### 12.  What is constructor overloading?
**Answer:**
You can have multiple constructors with different parameter lists:
```java
class Person{
    String name;
    int age;
    
    Person(String name){
        this.name = name;
    }
    
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
```

### 13. What is the difference between composition and inheritance?
| Feature     | Inheritance                   | Composition          |
|-------------|-------------------------------|----------------------|
| Definition  | “is-a” relationship           | “has-a” relationship |
| Coupling    | Tight                         | Loose                |
| Reusability | Reuses code from parent class | Reuses by delegation |

> Exampel of Composition:
```java
class Engine{
    void start(){
        System.out.println("Engine started");
    }
}

class Car{
    private Engine engine = new Engine();
    void startCar(){
        engine.start(); // Delegation
        System.out.println("Car started");
    }
}
```

### 14. What is the `instanceof` keyword used for?
**Answer:**
The `instanceof` keyword checks whether an object is an instance of a specific class or interface. It returns `true` if the object is an instance, otherwise `false`.

```java

if (animal instanceof Dog) {
    ((Dog) animal).bark();
}

```


### 15. Can you override a private or static method in Java?
**Answer:**

- private methods are not inherited → not overridden

- static methods are hidden, not overridden (method hiding)

No, you cannot override a private method because it is not visible to subclasses. Static methods are also not overridden; they are hidden. If you define a static method with the same name in a subclass, it will hide the parent class's static method, but it won't be considered an override.

```java
class Parent {
    private void display() {
        System.out.println("Parent display");
    }
    
    static void staticDisplay() {
        System.out.println("Parent static display");
    }
}
class Child extends Parent {
    // This will not override the parent's private method
    void display() {
        System.out.println("Child display");
    }
    
    static void staticDisplay() {
        System.out.println("Child static display");
    }
}
```