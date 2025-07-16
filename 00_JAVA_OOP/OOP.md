# Java OOP – Object-Oriented Programming Revision for Interviews
Java is a pure object-oriented language (except for primitive types), and interviewers assess your grasp of OOP principles, design thinking, and your ability to write maintainable and reusable code.


| Pillar            | Definition                                                           | Java Implementation                              |
|-------------------|----------------------------------------------------------------------|--------------------------------------------------|
| **Encapsulation** | Bundling data (fields) and methods into a single unit (class)        | Using private fields with public getters/setters |
| **Abstraction**   | Hiding implementation details and exposing only essential features   | Using abstract classes and interfaces            |
| **Inheritance**   | Mechanism to acquire properties of another class (is-a relationship) | Using `extends`                                  |
| **Polymorphism**  | Same interface, different behaviors                                  | Method overloading and overriding                |

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

