# The Complete Guide to Java Object-Oriented Programming
## From Beginner to Confident OOP Engineer

## To preview this Readme use the command " Ctrl + Shift + v " - this will open preview pane where you see all the markdown styles.

---

## Table of Contents

1. [Programming Paradigms and Why OOP Exists](#programming-paradigms)
2. [Classes and Objects](#classes-and-objects)
3. [Instances vs Classes](#instances-vs-classes)
4. [Fields (Attributes)](#fields)
5. [Methods](#methods)
6. [Constructors](#constructors)
7. [Access Modifiers](#access-modifiers)
8. [Encapsulation](#encapsulation)
9. [Abstraction](#abstraction)
10. [Inheritance](#inheritance)
11. [Polymorphism](#polymorphism)
12. [Method Overloading and Overriding](#method-overloading-and-overriding)
13. [The `this` Keyword](#this-keyword)
14. [The `static` Keyword](#static-keyword)
15. [The `final` Keyword](#final-keyword)
16. [Composition vs Inheritance](#composition-vs-inheritance)
17. [Packages](#packages)
18. [Real-World Modeling Using OOP](#real-world-modeling)
19. [Common Beginner Mistakes](#common-mistakes)

---

## Programming Paradigms and Why OOP Exists {#programming-paradigms}

### What is a Programming Paradigm?

A **programming paradigm** is a fundamental style of programming—a way of thinking about and solving problems using code. Think of it like architectural styles for buildings: Gothic, Modern, Minimalist. Each has its own principles, patterns, and way of organizing structure.

### The Main Programming Paradigms

1. **Imperative Programming**: You tell the computer HOW to do something step-by-step
   - "First, do this. Then do that. Then do this other thing."
   - Example: Traditional procedural code with functions and loops

2. **Functional Programming**: You describe WHAT you want as a combination of functions
   - Focus on mathematical functions and immutability
   - Treating computation as the evaluation of functions

3. **Object-Oriented Programming (OOP)**: You organize code around OBJECTS that have state (data) and behavior (methods)
   - Think of real-world objects and model them in code

### Why OOP Exists: The Problem It Solves

**Imagine you're writing a banking system using only procedures and functions:**

```java
// ❌ Procedural approach - PROBLEMATIC
double balance_john = 5000;
double balance_mary = 3000;
double balance_bob = 7500;

void withdraw(String accountHolder, double amount) {
    if (accountHolder.equals("john")) {
        balance_john -= amount;
    } else if (accountHolder.equals("mary")) {
        balance_mary -= amount;
    } else if (accountHolder.equals("bob")) {
        balance_bob -= amount;
    }
}

void deposit(String accountHolder, double amount) {
    if (accountHolder.equals("john")) {
        balance_john += amount;
    } else if (accountHolder.equals("mary")) {
        balance_mary += amount;
    } else if (accountHolder.equals("bob")) {
        balance_bob += amount;
    }
}
```

**Problems with this approach:**
- Adding 1,000 new accounts means adding 1,000 new variables
- Every function must check which account it's working with
- Code is repetitive and error-prone
- Easy to accidentally modify someone else's balance
- Impossible to scale

**With OOP:**

```java
// ✅ Object-Oriented approach - ORGANIZED
class BankAccount {
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
}

// Creating accounts
BankAccount john = new BankAccount("John", 5000);
BankAccount mary = new BankAccount("Mary", 3000);
BankAccount bob = new BankAccount("Bob", 7500);

// Using them
john.withdraw(500);
mary.deposit(200);
```

### What OOP Solves

| Problem | Procedural Approach | OOP Approach |
|---------|-------------------|------------|
| **Scalability** | Add 1 account = add new variables + update all functions | Add 1 account = create 1 new object |
| **Code Organization** | Data and functions scattered everywhere | Data and functions bundled together |
| **Maintenance** | Change logic = update in multiple functions | Change logic = update in one place |
| **Real-World Modeling** | Objects forced into procedural functions | Objects model real-world entities naturally |
| **Reusability** | Hard to reuse logic across similar items | Easy to create templates (classes) for similar items |

### Key Insight

> **OOP treats code like a model of the real world. In the real world, objects have properties (state) and can perform actions (behavior). OOP mirrors this.**

---

## Classes and Objects {#classes-and-objects}

### What is a Class?

A **class** is a **blueprint or template** for creating objects. It's like an architectural blueprint for a house—it specifies what a house should have (rooms, doors, windows) but isn't the actual house.

### What is an Object?

An **object** is a **specific instance created from a class**. It's the actual house built from the blueprint.

### The Analogy

Think of a recipe (class) vs. a cake (object):
- **Recipe**: Instructions for how to make a cake. Abstract. You can share one recipe with many people.
- **Cake**: An actual cake made by following the recipe. Concrete. Each cake is separate.

### Your First Class

```java
public class Student {
    // Fields (data that objects will have)
    public String name;
    public int age;
    public double gpa;
    
    // Method (behavior - what objects can do)
    public void study() {
        System.out.println(name + " is studying");
    }
}
```

**Breaking this down:**
- `public class Student` — We're creating a blueprint called "Student"
- `String name` — Objects of this class will have a name
- `public void study()` — Objects can perform the study action

### Creating Objects (Instantiation)

```java
// Creating the first object from the Student blueprint
Student alice = new Student();
alice.name = "Alice";
alice.age = 20;
alice.gpa = 3.8;

// Creating the second object - completely separate
Student bob = new Student();
bob.name = "Bob";
bob.age = 19;
bob.gpa = 3.2;

// Using the objects
alice.study();  // Output: Alice is studying
bob.study();    // Output: Bob is studying
```

**Key understanding:**
- `alice` and `bob` are two different objects created from the same `Student` class
- They have the same structure (same fields and methods)
- But their data is completely separate
- Changing `alice.gpa` doesn't affect `bob.gpa`

### Why Classes Exist

Without classes, for every student you'd need separate variables:

```java
// ❌ Without classes - UNMANAGEABLE
String student1_name = "Alice";
int student1_age = 20;
double student1_gpa = 3.8;

String student2_name = "Bob";
int student2_age = 19;
double student2_gpa = 3.2;

String student3_name = "Carol";
int student3_age = 21;
double student3_gpa = 3.5;

// ... and you'd need separate methods for each student too
```

With classes, all student data is organized:

```java
// ✅ With classes - ORGANIZED
ArrayList<Student> students = new ArrayList<>();
students.add(new Student());
students.add(new Student());
students.add(new Student());

// Can iterate through all students easily
for (Student student : students) {
    student.study();
}
```

---

## Instances vs Classes {#instances-vs-classes}

### The Fundamental Difference

| Aspect | Class | Instance (Object) |
|--------|-------|------------------|
| **What it is** | Template/Blueprint | An actual thing created from the template |
| **How many exist** | One per class definition | Many can be created from one class |
| **Type** | Abstract definition | Concrete realization |
| **Memory** | Stored once in code | Each instance takes up memory |
| **Code representation** | `class Dog { }` | `Dog myDog = new Dog()` |

### The Most Important Concept: Each Instance is Separate

```java
class Car {
    public String color;
    public int speed;
}

// Creating TWO different instances from the Car blueprint
Car car1 = new Car();
car1.color = "Red";
car1.speed = 0;

Car car2 = new Car();
car2.color = "Blue";
car2.speed = 0;

// They are COMPLETELY SEPARATE
car1.color = "Red";
System.out.println(car1.color);  // Output: Red
System.out.println(car2.color);  // Output: Blue (unchanged!)

car1.speed = 100;
System.out.println(car1.speed);  // Output: 100
System.out.println(car2.speed);  // Output: 0 (unchanged!)
```

**Why is this important?**
- Each object has its own memory space
- Modifying one doesn't affect others
- This is how we can have 1,000 Student objects with different data

### Understanding Object Creation with `new`

```java
// Step-by-step breakdown:
Student alice = new Student();

// 1. "new Student()" — Creates a new space in memory for a Student object
// 2. Alice is assigned to that memory location
// 3. Now alice is a reference/pointer to that object

// Think of it like:
// Class = Hotel room blueprint
// new Student() = Building a new room from that blueprint
// alice = The address of that room
```

### Why This Matters

```java
// If you have 100 different users in your app:
ArrayList<User> users = new ArrayList<>();
for (int i = 0; i < 100; i++) {
    users.add(new User());  // Each iteration creates a new instance
}

// Each user is separate and won't interfere with others
```

---

## Fields (Attributes) {#fields}

### What are Fields?

**Fields** are variables that belong to an object. They hold the object's data or state. They answer the question: "What information does this object know about itself?"

### Example: A Student's Fields

```java
class Student {
    public String name;          // Field: the student's name
    public int age;              // Field: the student's age
    public double gpa;           // Field: the student's grade point average
    public String major;         // Field: what the student is studying
    public String studentId;     // Field: unique identifier
}
```

When you create a student object:

```java
Student alice = new Student();
alice.name = "Alice";    // Assigning to field
alice.age = 20;
alice.gpa = 3.8;
alice.major = "Computer Science";
alice.studentId = "CS2024001";
```

### Fields vs Local Variables

**Field:** Belongs to an object, lives as long as the object exists

```java
class Person {
    public String name;  // FIELD - persists with the object
    
    public void introduce() {
        String greeting = "Hello";  // LOCAL VARIABLE - only exists in this method
    }
}

Person john = new Person();
john.name = "John";
System.out.println(john.name);  // ✅ Works - name is a field

// System.out.println(john.greeting);  // ❌ Error - greeting doesn't exist outside introduce()
```

### Default Values

When you create an object, fields automatically get default values:

```java
class Player {
    public int health;      // Default: 0
    public String username; // Default: null
    public boolean isActive; // Default: false
}

Player player = new Player();
System.out.println(player.health);      // Output: 0
System.out.println(player.username);    // Output: null
System.out.println(player.isActive);    // Output: false
```

### Why We Use Fields

**Without fields:**
```java
// ❌ Bad - information is scattered
void processStudentName(String name) { }
void processStudentAge(int age) { }
void processStudentGPA(double gpa) { }
```

**With fields:**
```java
// ✅ Good - information is organized
class Student {
    public String name;
    public int age;
    public double gpa;
}
// All related student data in one place
```

---

## Methods {#methods}

### What are Methods?

**Methods** are actions or behaviors that an object can perform. They're functions that belong to a class. They answer: "What can this object do?"

### The Structure of a Method

```java
public void deposit(double amount) {
    //  ^    ^       ^             ^
    //  |    |       |             |
    // access return  method    parameters
    // modifier  type  name
    
    balance = balance + amount;
    System.out.println("Deposited: $" + amount);
}
```

### Simple Method Example

```java
class BankAccount {
    public double balance;
    
    // Method: withdraw money from account
    public void withdraw(double amount) {
        // This method does something (withdraw money)
        // void means it doesn't return a value
        balance = balance - amount;
        System.out.println("Withdrew: $" + amount);
    }
    
    // Method: check balance
    public double getBalance() {
        // This method returns the balance
        return balance;
    }
}

// Using the methods:
BankAccount account = new BankAccount();
account.balance = 1000;

account.withdraw(250);              // Calls withdraw method
double currentBalance = account.getBalance();  // Calls getBalance method
System.out.println(currentBalance); // Output: 750
```

### Methods That Return Values

```java
class Calculator {
    // This method calculates and RETURNS the result
    public int add(int a, int b) {
        int result = a + b;
        return result;  // Sends the result back to the caller
    }
    
    // Shorter version
    public int multiply(int a, int b) {
        return a * b;
    }
}

Calculator calc = new Calculator();
int sum = calc.add(5, 3);       // sum = 8
int product = calc.multiply(4, 5);  // product = 20
```

### The Importance of Methods

Methods solve the problem of **code duplication and organization**:

```java
// ❌ Without methods - repeated code
BankAccount account1 = new BankAccount();
account1.balance = 1000;

double fee = account1.balance * 0.01;
account1.balance = account1.balance - fee;
System.out.println("Fee applied: $" + fee);

// Same logic again for account2
BankAccount account2 = new BankAccount();
account2.balance = 5000;

fee = account2.balance * 0.01;
account2.balance = account2.balance - fee;
System.out.println("Fee applied: $" + fee);

// ✅ With methods - reusable code
class BankAccount {
    public double balance;
    
    public void applyMaintenanceFee() {
        double fee = balance * 0.01;
        balance = balance - fee;
        System.out.println("Fee applied: $" + fee);
    }
}

BankAccount account1 = new BankAccount();
account1.balance = 1000;
account1.applyMaintenanceFee();  // Just call the method

BankAccount account2 = new BankAccount();
account2.balance = 5000;
account2.applyMaintenanceFee();  // Same method call
```

### Understanding `void` vs Returning a Value

```java
class Student {
    public String name;
    public double gpa;
    
    // void method - performs action but returns nothing
    public void celebrate() {
        System.out.println(name + " is celebrating!");
        // No return statement
    }
    
    // method that returns a boolean
    public boolean isHonorStudent() {
        if (gpa >= 3.5) {
            return true;  // Sends true back
        } else {
            return false;  // Sends false back
        }
    }
}

Student alice = new Student();
alice.name = "Alice";
alice.gpa = 3.8;

alice.celebrate();  // Just executes the action (doesn't use return value)

boolean honor = alice.isHonorStudent();  // Receives true/false
System.out.println("Honor student: " + honor);  // Uses the returned value
```

### Parameters: Giving Methods Information

```java
class Car {
    public int speed;
    
    // This method TAKES A PARAMETER (amount)
    public void accelerate(int amount) {
        speed = speed + amount;
        System.out.println("Speed is now: " + speed);
    }
    
    // This method takes MULTIPLE PARAMETERS
    public void travel(int distance, int timeInHours) {
        speed = distance / timeInHours;
        System.out.println("Traveling at " + speed + " mph");
    }
}

Car myCar = new Car();
myCar.speed = 0;

myCar.accelerate(30);        // Passes 30 to the amount parameter
myCar.travel(100, 2);        // Passes 100 and 2 to the parameters
```

---

## Constructors {#constructors}

### What is a Constructor?

A **constructor** is a special method that runs when you create a new object. It's the object's initialization method. Think of it as the "setup" that happens right after an object is born.

### Why We Need Constructors

**Without constructors:**
```java
class Student {
    public String name;
    public int age;
    public double gpa;
}

Student alice = new Student();
// alice.name is null (empty)
// alice.age is 0
// alice.gpa is 0.0

// We MUST set these manually:
alice.name = "Alice";
alice.age = 20;
alice.gpa = 3.8;

// Imagine doing this for 1000 students... tedious!
```

**With constructors:**
```java
class Student {
    public String name;
    public int age;
    public double gpa;
    
    // Constructor - runs when object is created
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
}

// Now we set everything in one line:
Student alice = new Student("Alice", 20, 3.8);
// alice is fully initialized immediately
```

### Constructor Syntax

```java
class BankAccount {
    public String accountHolder;
    public double balance;
    
    // Constructor has same name as class
    // public BankAccount(...) {
    public BankAccount(String holder, double initialBalance) {
        accountHolder = holder;
        balance = initialBalance;
    }
}

// Usage:
BankAccount myAccount = new BankAccount("John", 5000);
// accountHolder = "John"
// balance = 5000
```

### Multiple Constructors (Constructor Overloading)

Sometimes you want different ways to create an object:

```java
class Pizza {
    public String size;
    public double price;
    public String toppings;
    
    // Constructor 1: All parameters
    public Pizza(String size, double price, String toppings) {
        this.size = size;
        this.price = price;
        this.toppings = toppings;
    }
    
    // Constructor 2: Just size and price (default toppings)
    public Pizza(String size, double price) {
        this.size = size;
        this.price = price;
        this.toppings = "Cheese only";
    }
    
    // Constructor 3: Just size (default price and toppings)
    public Pizza(String size) {
        this.size = size;
        this.price = 9.99;
        this.toppings = "Cheese only";
    }
}

// Different ways to create a pizza:
Pizza pepperoni = new Pizza("Large", 15.99, "Pepperoni");
Pizza cheese = new Pizza("Medium", 11.99);
Pizza basic = new Pizza("Small");
```

### The Default Constructor

If you don't write a constructor, Java provides one automatically:

```java
class Animal {
    // Java automatically creates:
    // public Animal() { }
}

Animal dog = new Animal();  // This works even without explicit constructor
```

Once you create your own constructor, the default one disappears:

```java
class Animal {
    public String name;
    
    public Animal(String name) {  // You created a constructor
        this.name = name;
    }
}

// Animal dog = new Animal();  // ❌ Error! Can't use default constructor
Animal dog = new Animal("Buddy");  // ✅ Must use your constructor
```

### Constructor Best Practices

```java
class User {
    public String username;
    public String email;
    public int age;
    public String country;
    
    // Good constructor: requires essential information
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.country = "USA";  // Default if not provided
    }
    
    // Alternative: More flexible with multiple constructors
    public User(String username, String email, int age, String country) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.country = country;
    }
}

User user1 = new User("john_doe", "john@email.com", 25);
User user2 = new User("maria_garcia", "maria@email.com", 28, "Spain");
```

---

## Access Modifiers {#access-modifiers}

### What are Access Modifiers?

**Access modifiers** control who can access (read/modify) your class's fields and methods. They're like security levels.

### The Four Access Modifiers

```java
public class Student {
    public String publicField;      // Anyone can access
    private String privateField;    // Only this class can access
    protected String protectedField; // This class + subclasses can access
    String defaultField;            // Same package can access (no modifier)
}
```

### 1. `public` — Completely Open

```java
class Car {
    public String color;
    public int year;
    
    public void honk() {
        System.out.println("Beep beep!");
    }
}

Car myCar = new Car();
myCar.color = "Red";      // ✅ Can access directly
myCar.honk();             // ✅ Can call directly
```

**Problem with public fields:**
```java
class BankAccount {
    public double balance;  // DANGEROUS!
}

BankAccount account = new BankAccount();
account.balance = 1000;
account.balance = 1000000;  // Someone can cheat!
```

### 2. `private` — Locked Down

```java
class BankAccount {
    private double balance;  // Protected from outside access
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }
    
    public double getBalance() {
        return balance;
    }
}

BankAccount account = new BankAccount();
// account.balance = 1000000;  // ❌ Error! Can't access private field

account.deposit(500);          // ✅ Must use the method
System.out.println(account.getBalance());
```

**Why private is better:**
- You control how data is modified
- You can add validation (like "amount must be positive")
- You can change the implementation later without breaking outside code

### 3. `protected` — Accessible to Subclasses (we'll cover subclasses soon)

```java
class Animal {
    protected String name;  // Subclasses can access
}

class Dog extends Animal {
    public void bark() {
        System.out.println(name + " is barking");  // ✅ Can access protected field
    }
}
```

### 4. Default (Package-Private) — Accessible within same package

```java
// File: com/myapp/BankAccount.java
package com.myapp;

class BankAccount {  // No access modifier = package-private
    void openAccount() { }
}

// File: com/myapp/BankMain.java
package com.myapp;

BankAccount account = new BankAccount();  // ✅ Same package, can access

// File: com/other/OtherClass.java
package com.other;

BankAccount account = new BankAccount();  // ❌ Different package, can't access
```

### Access Modifier Summary

| Modifier | Same Class | Same Package | Subclass | Everyone |
|----------|-----------|-------------|----------|----------|
| `private` | ✅ | ❌ | ❌ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

### Practical Example: Choosing Modifiers

```java
class PaymentProcessor {
    private String apiKey;           // Private - secret! Only this class uses it
    private boolean isProcessing;    // Private - internal state
    
    protected void validatePayment(double amount) {  // Protected - subclasses might override
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
    
    public void processPayment(double amount) {  // Public - external code calls this
        validatePayment(amount);
        // ... process payment ...
    }
    
    private String encryptData(String data) {  // Private - only used internally
        return "encrypted: " + data;
    }
}
```

---

## Encapsulation {#encapsulation}

### What is Encapsulation?

**Encapsulation** is bundling data (fields) and methods together, and controlling access through modifiers. It's about hiding internal details and exposing only what's necessary.

### The Real-World Analogy

Think of a car:
- **Hidden (Private)**: Engine, transmission, internal wiring
- **Protected (Methods)**: Steering wheel, pedals, gear shift
- **Public Interface**: You interact with the car through the controls

You don't directly touch the engine; you use the steering wheel. The car controls what you can do.

### Encapsulation Problem and Solution

**Without Encapsulation (Dangerous):**

```java
class Student {
    public double gpa;
    public int age;
}

Student alice = new Student();
alice.gpa = 4.0;  // Looks good
alice.gpa = -5.0;  // ❌ WRONG! GPA can't be negative, but nothing stops this
alice.age = -25;   // ❌ WRONG! Age can't be negative, but nothing stops this
```

**With Encapsulation (Safe):**

```java
class Student {
    private double gpa;      // Hidden from outside
    private int age;         // Hidden from outside
    
    // Public method to set GPA with validation
    public void setGpa(double newGpa) {
        if (newGpa >= 0 && newGpa <= 4.0) {
            gpa = newGpa;
        } else {
            System.out.println("Invalid GPA!");
        }
    }
    
    // Public method to get GPA
    public double getGpa() {
        return gpa;
    }
    
    // Same for age
    public void setAge(int newAge) {
        if (newAge > 0 && newAge < 150) {
            age = newAge;
        } else {
            System.out.println("Invalid age!");
        }
    }
    
    public int getAge() {
        return age;
    }
}

Student alice = new Student();
alice.setGpa(3.8);   // ✅ Valid
alice.setGpa(-5.0);  // ❌ Rejected! Prints "Invalid GPA!"
alice.setAge(20);    // ✅ Valid
alice.setAge(-25);   // ❌ Rejected! Prints "Invalid age!"
```

### Getters and Setters

These are the standard way to provide controlled access:

```java
class BankAccount {
    private String accountNumber;
    private double balance;
    
    // Getter: retrieve the value
    public double getBalance() {
        return balance;
    }
    
    // Setter: change the value with validation
    public void setBalance(double newBalance) {
        if (newBalance >= 0) {
            balance = newBalance;
        }
    }
    
    // Sometimes getters and setters do more than just return/set
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

BankAccount account = new BankAccount();
account.setBalance(1000);
System.out.println(account.getBalance());  // 1000
account.withdraw(200);
System.out.println(account.getBalance());  // 800
```

### Why Encapsulation Matters

1. **Prevents Invalid States**
   ```java
   // Without encapsulation: GPA could be -5 or 10
   // With encapsulation: GPA is always between 0-4
   ```

2. **Allows Internal Changes Without Breaking Code**
   ```java
   // Your implementation can change
   class Student {
       private int gpaInHundreds;  // Store as 380 instead of 3.8
       
       public double getGpa() {
           return gpaInHundreds / 100.0;  // Still looks the same to users
       }
   }
   ```

3. **Adds Business Logic**
   ```java
   class Order {
       private List<Item> items;
       
       public void addItem(Item item) {
           if (items.size() < 100) {  // Can't order more than 100 items
               items.add(item);
           }
       }
   }
   ```

4. **Provides Logging and Monitoring**
   ```java
   class User {
       private String email;
       
       public void setEmail(String newEmail) {
           System.out.println("User changed email from " + email + " to " + newEmail);
           email = newEmail;
       }
   }
   ```

### The Complete Picture: Full Encapsulation

```java
class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    private int copiesSold;
    
    // Constructor
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.copiesSold = 0;
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }
    public int getCopiesSold() { return copiesSold; }
    
    // Setters with validation
    public void setPrice(double newPrice) {
        if (newPrice > 0) {
            price = newPrice;
        }
    }
    
    public void setPages(int newPages) {
        if (newPages > 0) {
            pages = newPages;
        }
    }
    
    // Business methods
    public void recordSale() {
        copiesSold++;
    }
    
    public double calculateRevenue() {
        return price * copiesSold;
    }
    
    public String getDescription() {
        return title + " by " + author + " (" + pages + " pages)";
    }
}

// Usage
Book myBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, 12.99);
System.out.println(myBook.getDescription());
myBook.recordSale();
myBook.recordSale();
myBook.recordSale();
System.out.println("Revenue: $" + myBook.calculateRevenue());
```

---

## Abstraction {#abstraction}

### What is Abstraction?

**Abstraction** means showing only the essential details and hiding the complex implementation. It's about creating a simple interface while the internal logic can be complex.

### Abstraction vs Encapsulation

- **Encapsulation**: Bundling data and methods, controlling access with modifiers
- **Abstraction**: Hiding complexity, showing only what's necessary

Think of a TV remote:
- **Encapsulation**: It packages buttons and circuits together in a plastic case
- **Abstraction**: You just see buttons; you don't need to know how the remote communicates with the TV

### Abstract Classes

An **abstract class** is a class that can't be instantiated directly. It serves as a template with some methods that subclasses MUST implement.

#### When Do You Need Abstract Classes?

```java
// Problem: Different animals behave differently
class Animal {
    public void makeSound() {
        System.out.println("Some sound");  // Too generic!
    }
}

Dog dog = new Dog();
dog.makeSound();  // Doesn't sound like a dog at all!

Cat cat = new Cat();
cat.makeSound();  // Doesn't sound like a cat at all!
```

#### Solution: Abstract Class

```java
abstract class Animal {
    // Abstract method: subclasses MUST implement this
    abstract public void makeSound();
    
    // Regular method: subclasses inherit this
    public void sleep() {
        System.out.println("Animal is sleeping...");
    }
}

// ❌ Can't do this:
// Animal animal = new Animal();  // Error! Can't create instance of abstract class

// ✅ Must extend and implement abstract methods:
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

Dog dog = new Dog();
dog.makeSound();  // Output: Woof! Woof!
dog.sleep();      // Output: Animal is sleeping...

Cat cat = new Cat();
cat.makeSound();  // Output: Meow!
cat.sleep();      // Output: Animal is sleeping...
```

**Key insight:** Abstract methods force subclasses to provide their own implementation.

### Interfaces

An **interface** is like an abstract class, but with no implementation at all. It's a contract: "If you implement me, you must have these methods."

#### Interface vs Abstract Class

| Aspect | Abstract Class | Interface |
|--------|---|---|
| Can have fields | Yes | Only constants (final) |
| Can have methods with code | Yes | No (until Java 8) |
| Can be instantiated | No | No |
| What it models | A "is-a" relationship | A capability or contract |
| Example | `Animal` (a class of living things) | `Drawable` (a capability to be drawn) |

#### Using Interfaces

```java
// Define what something that can be drawn must do
interface Drawable {
    void draw();
    void erase();
}

// Define what something that can be resized must do
interface Resizable {
    void resize(int width, int height);
}

// A class can implement multiple interfaces
class Circle implements Drawable, Resizable {
    private int radius;
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
    
    @Override
    public void erase() {
        System.out.println("Erasing the circle");
    }
    
    @Override
    public void resize(int width, int height) {
        radius = width / 2;  // Simplified
        System.out.println("Circle resized");
    }
}

class Rectangle implements Drawable, Resizable {
    private int width;
    private int height;
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
    
    @Override
    public void erase() {
        System.out.println("Erasing the rectangle");
    }
    
    @Override
    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println("Rectangle resized to " + width + "x" + height);
    }
}

// Now we can treat both as Drawable
Drawable[] shapes = new Drawable[2];
shapes[0] = new Circle();
shapes[1] = new Rectangle();

for (Drawable shape : shapes) {
    shape.draw();
    shape.erase();
}
```

### Real-World Abstraction Example

```java
// Interface: describes what a payment method must do
interface PaymentMethod {
    boolean processPayment(double amount);
    void refund(double amount);
    String getPaymentDetails();
}

// Implementation 1: Credit Card
class CreditCard implements PaymentMethod {
    private String cardNumber;
    private double balance;
    
    public CreditCard(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Credit card charged $" + amount);
            return true;
        }
        return false;
    }
    
    @Override
    public void refund(double amount) {
        balance += amount;
        System.out.println("Refunded $" + amount);
    }
    
    @Override
    public String getPaymentDetails() {
        return "Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4);
    }
}

// Implementation 2: Digital Wallet
class DigitalWallet implements PaymentMethod {
    private String walletId;
    private double balance;
    
    public DigitalWallet(String walletId, double balance) {
        this.walletId = walletId;
        this.balance = balance;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Wallet charged $" + amount);
            return true;
        }
        return false;
    }
    
    @Override
    public void refund(double amount) {
        balance += amount;
        System.out.println("Wallet refunded $" + amount);
    }
    
    @Override
    public String getPaymentDetails() {
        return "Digital Wallet: " + walletId;
    }
}

// The code that uses payments doesn't care HOW it's paid
class OnlineStore {
    public void checkout(PaymentMethod paymentMethod, double totalAmount) {
        System.out.println("Processing payment with: " + paymentMethod.getPaymentDetails());
        if (paymentMethod.processPayment(totalAmount)) {
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed!");
        }
    }
}

// Usage
OnlineStore store = new OnlineStore();

PaymentMethod card = new CreditCard("1234-5678-9012-3456", 5000);
store.checkout(card, 99.99);

PaymentMethod wallet = new DigitalWallet("user@email.com", 500);
store.checkout(wallet, 50.00);
```

### Why Abstraction Matters

1. **Simplifies Complexity**: Users don't need to understand implementation
2. **Allows Easy Changes**: Change implementation without changing interface
3. **Enables Polymorphism**: Different types can be used the same way
4. **Reduces Coupling**: Code depends on abstractions, not concrete details

---

## Inheritance {#inheritance}

### What is Inheritance?

**Inheritance** allows one class to inherit fields and methods from another class. It's a "is-a" relationship: "A Dog is an Animal."

### The Problem Inheritance Solves

```java
// ❌ Without inheritance - lots of repetition
class Dog {
    public String name;
    public String breed;
    public int age;
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Cat {
    public String name;
    public String breed;
    public int age;
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Lots of repeated code!
```

```java
// ✅ With inheritance - organized and reusable
class Animal {
    public String name;
    public String breed;
    public int age;
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println(name + " is barking");
    }
}

class Cat extends Animal {
    public void meow() {
        System.out.println(name + " is meowing");
    }
}
```

### How Inheritance Works

```java
class Animal {
    public String name;
    public int age;
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println(name + " is barking");
    }
}

// Dog INHERITS name and age from Animal
// Dog INHERITS the sleep() method from Animal
// Dog ADDS its own bark() method

Dog dog = new Dog();
dog.name = "Buddy";        // From Animal
dog.age = 3;               // From Animal
dog.sleep();               // From Animal - inherited
dog.bark();                // From Dog - own method
```

### Terminology

- **Superclass** (Parent): The class being inherited from (Animal)
- **Subclass** (Child): The class that inherits (Dog)
- **extends**: Keyword used for inheritance

### Constructor Inheritance

Constructors are NOT inherited. You must explicitly call the parent constructor:

```java
class Animal {
    public String name;
    public int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Dog extends Animal {
    public String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);  // Call parent constructor
        this.breed = breed;
    }
}

Dog dog = new Dog("Buddy", 3, "Golden Retriever");
System.out.println(dog.name);    // Buddy
System.out.println(dog.age);     // 3
System.out.println(dog.breed);   // Golden Retriever
```

### Overriding Methods

A subclass can replace a parent's method with its own version:

```java
class Animal {
    public String name;
    
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override  // This annotation shows we're intentionally overriding
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

Animal dog = new Dog();
dog.name = "Rex";
dog.makeSound();  // Output: Rex says: Woof!

Animal cat = new Cat();
cat.name = "Whiskers";
cat.makeSound();  // Output: Whiskers says: Meow!
```

### Important: `super` Keyword

`super` refers to the parent class:

```java
class Person {
    public String name;
    
    public void introduce() {
        System.out.println("I am " + name);
    }
}

class Employee extends Person {
    public String jobTitle;
    
    @Override
    public void introduce() {
        super.introduce();  // Call parent's method
        System.out.println("I am a " + jobTitle);
    }
}

Employee emp = new Employee();
emp.name = "Alice";
emp.jobTitle = "Software Engineer";
emp.introduce();
// Output:
// I am Alice
// I am a Software Engineer
```

### Inheritance Hierarchy

Classes can form a chain:

```java
class Vehicle {
    public int speed;
}

class Car extends Vehicle {
    public int doors;
}

class ElectricCar extends Car {
    public int batteryCapacity;
}

// ElectricCar inherits:
// - speed (from Vehicle)
// - doors (from Car)
// - plus its own batteryCapacity

ElectricCar tesla = new ElectricCar();
tesla.speed = 150;
tesla.doors = 4;
tesla.batteryCapacity = 100;
```

### Real-World Inheritance Example

```java
// Base class for all bank accounts
class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected double interestRate;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
    
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        }
        return false;
    }
    
    public void applyInterest() {
        balance += balance * interestRate;
        System.out.println("Interest applied. New balance: $" + balance);
    }
}

// Savings account has minimum balance requirement
class SavingsAccount extends BankAccount {
    private double minimumBalance = 500;
    
    @Override
    public boolean withdraw(double amount) {
        if ((balance - amount) >= minimumBalance) {
            return super.withdraw(amount);  // Use parent's withdraw
        } else {
            System.out.println("Cannot withdraw. Minimum balance must be maintained.");
            return false;
        }
    }
}

// Checking account has fees
class CheckingAccount extends BankAccount {
    private double monthlyFee = 10;
    
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance -= monthlyFee;
        System.out.println("Monthly fee applied: $" + monthlyFee);
    }
}

// Usage
SavingsAccount savings = new SavingsAccount("SA123", 1000);
savings.interestRate = 0.05;
savings.deposit(500);
savings.withdraw(200);   // ✅ Works
// savings.withdraw(1000);  // ❌ Would fail - violates minimum

CheckingAccount checking = new CheckingAccount("CH456", 2000);
checking.withdraw(500);  // Withdraws $500 + $10 fee
```

---

## Polymorphism {#polymorphism}

### What is Polymorphism?

**Polymorphism** means "many forms." It allows you to write code that works with multiple types. One interface, many implementations.

### Two Types of Polymorphism

1. **Compile-time Polymorphism** (Method Overloading)
2. **Runtime Polymorphism** (Method Overriding)

### Runtime Polymorphism: The Powerful One

The real power of polymorphism comes from being able to use a parent class reference to point to a child class object:

```java
class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// The magic of polymorphism:
Animal dog = new Dog();    // Animal reference, Dog object
Animal cat = new Cat();    // Animal reference, Cat object

dog.makeSound();  // Output: Woof! (Dog's version)
cat.makeSound();  // Output: Meow! (Cat's version)

// Why this is amazing:
Animal[] animals = new Animal[2];
animals[0] = new Dog();
animals[1] = new Cat();

for (Animal animal : animals) {
    animal.makeSound();  // Each calls its own version!
}
// Output:
// Woof!
// Meow!
```

### The Problem Polymorphism Solves

**Without polymorphism:**
```java
void playAnimals(ArrayList<Animal> animals) {
    for (Animal animal : animals) {
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.bark();
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.meow();
        } else if (animal instanceof Bird) {
            Bird bird = (Bird) animal;
            bird.chirp();
        }
        // ... endless if-else statements
    }
}
```

**With polymorphism:**
```java
void playAnimals(ArrayList<Animal> animals) {
    for (Animal animal : animals) {
        animal.makeSound();  // Done! Each animal makes its own sound
    }
}
```

### Real-World Polymorphism Example

```java
// Payment processing system
interface PaymentProcessor {
    boolean process(double amount);
    void refund(double amount);
}

class CreditCardProcessor implements PaymentProcessor {
    @Override
    public boolean process(double amount) {
        System.out.println("Processing $" + amount + " via credit card");
        return true;
    }
    
    @Override
    public void refund(double amount) {
        System.out.println("Refunding $" + amount + " to credit card");
    }
}

class PayPalProcessor implements PaymentProcessor {
    @Override
    public boolean process(double amount) {
        System.out.println("Processing $" + amount + " via PayPal");
        return true;
    }
    
    @Override
    public void refund(double amount) {
        System.out.println("Refunding $" + amount + " to PayPal account");
    }
}

class ApplePayProcessor implements PaymentProcessor {
    @Override
    public boolean process(double amount) {
        System.out.println("Processing $" + amount + " via Apple Pay");
        return true;
    }
    
    @Override
    public void refund(double amount) {
        System.out.println("Refunding $" + amount + " to Apple Pay");
    }
}

// The checkout process doesn't care HOW payment is processed
class ShoppingCart {
    private ArrayList<Item> items = new ArrayList<>();
    
    public void checkout(PaymentProcessor processor) {
        double total = calculateTotal();
        
        if (processor.process(total)) {
            System.out.println("Order complete!");
        } else {
            System.out.println("Payment failed!");
        }
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

// Usage - same checkout works with any processor
ShoppingCart cart = new ShoppingCart();

// Customer chooses credit card
PaymentProcessor processor1 = new CreditCardProcessor();
cart.checkout(processor1);

// Another customer chooses PayPal
PaymentProcessor processor2 = new PayPalProcessor();
cart.checkout(processor2);

// You can add new payment methods WITHOUT changing ShoppingCart!
```

### Why Polymorphism Matters

1. **Open for Extension, Closed for Modification**: Add new types without changing existing code
2. **Loose Coupling**: Code depends on abstractions, not concrete types
3. **Easier Testing**: Can swap implementations with test implementations
4. **Real-World Alignment**: Models how the real world works (things can be used in multiple ways)

---

## Method Overloading and Overriding {#method-overloading-and-overriding}

### Method Overloading

**Overloading** means having multiple methods with the SAME NAME but DIFFERENT PARAMETERS.

#### Same Name, Different Parameters

```java
class Calculator {
    // Version 1: Two integers
    public int add(int a, int b) {
        return a + b;
    }
    
    // Version 2: Two doubles
    public double add(double a, double b) {
        return a + b;
    }
    
    // Version 3: Three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Version 4: Array of integers
    public int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

Calculator calc = new Calculator();
System.out.println(calc.add(5, 3));           // Uses Version 1: 8
System.out.println(calc.add(5.5, 3.2));       // Uses Version 2: 8.7
System.out.println(calc.add(5, 3, 2));        // Uses Version 3: 10
System.out.println(calc.add(new int[]{5, 3, 2}));  // Uses Version 4: 10
```

**Java determines which version to use based on:**
1. Number of parameters
2. Type of parameters
3. Order of parameters

```java
class Formatter {
    // Different parameter types
    public String format(String text) {
        return "Text: " + text;
    }
    
    public String format(int number) {
        return "Number: " + number;
    }
    
    public String format(double number) {
        return "Decimal: " + number;
    }
    
    public String format(boolean value) {
        return "Boolean: " + value;
    }
}

Formatter formatter = new Formatter();
System.out.println(formatter.format("Hello"));        // Text: Hello
System.out.println(formatter.format(42));             // Number: 42
System.out.println(formatter.format(3.14));           // Decimal: 3.14
System.out.println(formatter.format(true));           // Boolean: true
```

#### Why Overloading is Useful

Instead of:
```java
int addIntegers(int a, int b) { return a + b; }
double addDoubles(double a, double b) { return a + b; }
String concatenateStrings(String a, String b) { return a + b; }
```

You can use:
```java
Object add(int a, int b) { return a + b; }
Object add(double a, double b) { return a + b; }
Object add(String a, String b) { return a + b; }
// All same name - easier to remember and use!
```

### Method Overriding

**Overriding** means a subclass provides its own version of a parent class method.

#### Basic Overriding

```java
class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override  // Good practice: tells Java you're intentionally overriding
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

Animal dog = new Dog();
dog.makeSound();  // Calls Dog's version: Woof!

Animal cat = new Cat();
cat.makeSound();  // Calls Cat's version: Meow!
```

#### Rules for Overriding

1. **Method signature must be the same**: Same name, same parameters
2. **Return type must be compatible**
3. **Can't reduce access level** (can't make public method private in subclass)

```java
class Parent {
    public void doSomething() { }      // public
    protected void helper() { }        // protected
}

class Child extends Parent {
    @Override
    public void doSomething() { }      // ✅ Same - public
    
    @Override
    public void helper() { }           // ✅ Expanded - now public
}

// This would be an error:
class BadChild extends Parent {
    // @Override
    // private void doSomething() { }  // ❌ Can't make it more private!
}
```

### Overloading vs Overriding

| Aspect | Overloading | Overriding |
|--------|-----------|-----------|
| **Meaning** | Same method name, different parameters | Subclass provides own version |
| **Parameters** | Must be different | Must be the SAME |
| **When it happens** | Compile time | Runtime |
| **Inheritance** | Can happen in same class or related classes | Only in subclass |
| **Example** | `add(int, int)` vs `add(double, double)` | Parent `makeSound()` vs Child `makeSound()` |

### Practical Example: Both Together

```java
class PaymentProcessor {
    // Overloaded methods
    public boolean process(double amount) {
        return processPayment(amount, "USD");
    }
    
    public boolean process(double amount, String currency) {
        return processPayment(amount, currency);
    }
    
    protected boolean processPayment(double amount, String currency) {
        System.out.println("Processing $" + amount + " " + currency);
        return true;
    }
}

class SecurePaymentProcessor extends PaymentProcessor {
    // Overriding the protected method
    @Override
    protected boolean processPayment(double amount, String currency) {
        // Add security checks
        if (amount > 10000) {
            System.out.println("Security alert: Large transaction");
        }
        return super.processPayment(amount, currency);  // Call parent
    }
}

SecurePaymentProcessor processor = new SecurePaymentProcessor();
processor.process(100);              // Uses first overload
processor.process(15000, "EUR");     // Uses second overload (calls overridden method)
```

---

## The `this` Keyword {#this-keyword}

### What is `this`?

`this` is a reference to the current object. It means "this object I'm currently in."

### Common Use: Distinguishing Variables

```java
class Person {
    public String name;
    public int age;
    
    // Problem: parameter name conflicts with field name
    public void setName(String name) {
        // name = name;  // ❌ Which is which?
        
        this.name = name;  // ✅ Clear: this.name = parameter name
    }
    
    public void setAge(int age) {
        this.age = age;  // Field = parameter
    }
}

Person person = new Person();
person.setName("Alice");
person.setAge(25);
```

### Use in Constructors

```java
class Student {
    public String name;
    public int id;
    public double gpa;
    
    public Student(String name, int id, double gpa) {
        this.name = name;    // "this" refers to the object being created
        this.id = id;
        this.gpa = gpa;
    }
}

Student student = new Student("Bob", 101, 3.5);
// "this" inside the constructor referred to the student object being created
```

### Calling Other Constructors with `this`

Sometimes you want one constructor to use another:

```java
class Rectangle {
    public int width;
    public int height;
    
    // Constructor 1: Both dimensions
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    // Constructor 2: Square (width = height)
    public Rectangle(int size) {
        this(size, size);  // Calls Constructor 1 with this
    }
}

Rectangle rect = new Rectangle(5, 10);  // Uses Constructor 1
Rectangle square = new Rectangle(5);    // Uses Constructor 2, which calls Constructor 1
```

### Returning `this` for Method Chaining

Some methods return `this` to allow chaining:

```java
class StringBuilder {
    public String content = "";
    
    public StringBuilder append(String text) {
        content += text;
        return this;  // Return this object
    }
    
    public StringBuilder addNewLine() {
        content += "\n";
        return this;  // Return this object
    }
    
    public String toString() {
        return content;
    }
}

String result = new StringBuilder()
    .append("Hello")
    .append(" ")
    .append("World")
    .addNewLine()
    .toString();
    
System.out.println(result);  // Hello World
```

### Passing `this` to Other Methods

```java
class Person {
    public String name;
    
    public void introduceTo(Person other) {
        other.receiveIntroduction(this);  // Pass this person
    }
    
    public void receiveIntroduction(Person person) {
        System.out.println("Hello, I'm " + person.name);
    }
}

Person alice = new Person();
alice.name = "Alice";

Person bob = new Person();
bob.name = "Bob";

alice.introduceTo(bob);  // alice passes itself (this) to bob
// Output: Hello, I'm Alice
```

---

## The `static` Keyword {#static-keyword}

### What is `static`?

`static` means "belongs to the class, not to instances." There's only one copy shared by all objects.

### The Problem `static` Solves

```java
// ❌ Without static
class BankAccount {
    public String accountHolder;
    public double balance;
    public double interestRate;  // Each account has its own copy
}

BankAccount acc1 = new BankAccount();
acc1.interestRate = 0.05;

BankAccount acc2 = new BankAccount();
acc2.interestRate = 0.07;  // Different rate? This is confusing!

// In reality, the bank would set one interest rate for ALL accounts
```

```java
// ✅ With static
class BankAccount {
    public String accountHolder;
    public double balance;
    static public double interestRate = 0.05;  // Shared by all accounts
}

BankAccount acc1 = new BankAccount();
System.out.println(acc1.interestRate);  // 0.05

BankAccount.interestRate = 0.07;  // Change it for the whole class

System.out.println(acc1.interestRate);  // Now 0.07 (same for all)
```

### Static Variables

```java
class Student {
    public String name;
    public int id;
    static public int totalStudents = 0;  // Shared across all students
    
    public Student(String name) {
        this.name = name;
        totalStudents++;  // Increment shared counter
    }
}

Student alice = new Student("Alice");
Student bob = new Student("Bob");
Student carol = new Student("Carol");

System.out.println(Student.totalStudents);  // 3
System.out.println(alice.totalStudents);    // Also 3 (same variable)
```

### Static Methods

Static methods can be called on the class itself, without creating an object:

```java
class MathHelper {
    // Regular method - needs an object
    public int calculateFactorial(int n) {
        if (n <= 1) return 1;
        return n * calculateFactorial(n - 1);
    }
    
    // Static method - no object needed
    static public int add(int a, int b) {
        return a + b;
    }
    
    static public int multiply(int a, int b) {
        return a * b;
    }
}

// Can call static method without creating object
int sum = MathHelper.add(5, 3);       // Works
int product = MathHelper.multiply(4, 6);  // Works

// Can't call static method on object
// int bad = new MathHelper().add(5, 3);  // Could work but not recommended

// Regular method NEEDS an object
MathHelper helper = new MathHelper();
int factorial = helper.calculateFactorial(5);
```

### Common Static Methods: `main()`

The entry point of your program is static:

```java
class MyProgram {
    static public void main(String[] args) {
        System.out.println("Program starts");
    }
}
```

Why static? Because it's called before any objects are created!

### Real-World Example: Utility Class

```java
class StringUtils {
    // All methods are static - this is a utility class
    
    static public boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
    
    static public String capitalize(String str) {
        if (isEmpty(str)) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    static public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

// Use without creating object
System.out.println(StringUtils.isEmpty(""));        // true
System.out.println(StringUtils.capitalize("hello")); // Hello
System.out.println(StringUtils.reverse("hello"));    // olleh
```

### Static vs Instance

| Aspect | Static | Instance |
|--------|--------|----------|
| **Belongs to** | Class | Object |
| **How many exist** | One per class | One per object |
| **Access** | `ClassName.variable` | `object.variable` |
| **When created** | When class loads | When object is created |
| **Use case** | Shared data, utility methods | Object-specific data, behaviors |

### Important: Static Limitations

```java
class Account {
    public String accountNumber;      // Instance - different for each
    static public double interestRate = 0.05;  // Static - same for all
    
    public void printInfo() {
        System.out.println(accountNumber);      // ✅ Can access instance
        System.out.println(interestRate);        // ✅ Can access static
    }
    
    static public void printRate() {
        // System.out.println(accountNumber);   // ❌ Can't access instance!
        System.out.println(interestRate);        // ✅ Can access static
    }
}

// Rule: Static methods can only access static members
```

---

## The `final` Keyword {#final-keyword}

### What is `final`?

`final` means "cannot be changed." It can be applied to:
1. **Variables**: Can't reassign
2. **Methods**: Can't override
3. **Classes**: Can't extend

### Final Variables

Once you assign a final variable, you can't change it:

```java
class Configuration {
    final public String APP_NAME = "MyApp";      // Can't be changed
    final public int MAX_USERS = 1000;           // Can't be changed
    public String theme = "Light";               // Can be changed
    
    public void configure() {
        // theme = "Dark";              // ✅ Can change
        // APP_NAME = "NewApp";         // ❌ Can't change final
        // MAX_USERS = 2000;            // ❌ Can't change final
    }
}
```

**Use case**: Define constants

```java
class MathConstants {
    final static public double PI = 3.14159;
    final static public double E = 2.71828;
    final static public double GOLDEN_RATIO = 1.618;
    
    // These never change
}

System.out.println(MathConstants.PI);  // 3.14159
// MathConstants.PI = 3.14;  // ❌ Error! Can't change
```

### Final Methods

A final method can't be overridden:

```java
class Animal {
    public void makeSound() {
        System.out.println("Generic sound");
    }
    
    final public void breathe() {
        System.out.println("Breathing...");
        // This behavior should NEVER be overridden
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {        // ✅ Can override
        System.out.println("Woof!");
    }
    
    // @Override
    // public void breathe() {        // ❌ Can't override final method
    //     System.out.println("Dog breathing");
    // }
}
```

**Use case**: Ensure critical behavior is never changed

```java
class SecureTransaction {
    final public void processSecurePayment(double amount) {
        // Critical security logic that should NEVER be overridden
        validateSecurity();
        transferMoney(amount);
        logTransaction(amount);
    }
}
```

### Final Classes

A final class can't be extended:

```java
final public class Immutable {
    private String value;
    
    public Immutable(String value) {
        this.value = value;
    }
}

// class MyImmutable extends Immutable {  // ❌ Can't extend final class
// }
```

**Use case**: Prevent subclassing for security or design reasons

```java
// Java's String class is final - you can't extend it
// final public class String { }  // This is how String is defined

// You can't do: class MyString extends String { }
```

### Real-World Example: Configuration Class

```java
final public class DatabaseConfig {
    final public String HOST = "localhost";
    final public int PORT = 5432;
    final public String DATABASE = "myapp";
    final public String USERNAME = "admin";
    // PASSWORD is secret - don't hardcode
    
    // Configuration should never be subclassed
    // All values are fixed
    
    final public void printConfig() {
        System.out.println("Host: " + HOST);
        System.out.println("Port: " + PORT);
        System.out.println("Database: " + DATABASE);
    }
}
```

---

## Composition vs Inheritance {#composition-vs-inheritance}

### What's the Question?

When one class needs to use features from another class, you have two choices:
1. **Inheritance** ("is-a"): The class BECOMES the other type
2. **Composition** ("has-a"): The class CONTAINS an instance of the other type

### Inheritance: "is-a" Relationship

```java
// A Dog IS-AN Animal
class Animal {
    public void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Woof!");
    }
}

Dog dog = new Dog();
dog.eat();   // Inherited
dog.bark();  // Own method
```

### Composition: "has-a" Relationship

```java
// A Car HAS-A Engine
class Engine {
    public void start() {
        System.out.println("Engine starting...");
    }
    
    public void stop() {
        System.out.println("Engine stopping...");
    }
}

class Car {
    private Engine engine;  // HAS-A engine
    
    public Car() {
        this.engine = new Engine();
    }
    
    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
        engine.stop();
    }
}

Car car = new Car();
car.drive();
// The car doesn't need to BE an engine, it USES an engine
```

### The Problem: When Inheritance is Wrong

```java
// ❌ BAD - Wrong hierarchy
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {  // Penguins can't actually fly!
    // Forced to inherit fly() even though it's wrong
}

Penguin penguin = new Penguin();
penguin.fly();  // ❌ Semantically wrong - penguins don't fly

// ✅ GOOD - Use composition
class Penguin {
    private Wing wing;  // Penguins have wings, but don't use them to fly
    
    public void swim() {
        System.out.println("Swimming...");
    }
}
```

### Decision: Inheritance vs Composition

**Use Inheritance when:**
- There's a clear "is-a" relationship
- You want to reuse implementation
- It makes semantic sense

```java
class Vehicle { }
class Car extends Vehicle { }  // ✅ A Car IS-A Vehicle
```

**Use Composition when:**
- There's a "has-a" relationship
- You need flexibility
- You want to avoid tight coupling

```java
class Car {
    private Engine engine;    // Car HAS-A Engine
    private Wheels[] wheels;  // Car HAS-A Wheels
}
```

### Real-World Example: Database Connection

**Bad approach (inheritance):**
```java
// ❌ Wrong - ServiceClass doesn't IS-A Database
class ServiceClass extends DatabaseConnection {
    public void process() {
        executeQuery("SELECT * FROM users");
    }
}
```

**Good approach (composition):**
```java
// ✅ Correct - ServiceClass HAS-A DatabaseConnection
class DatabaseConnection {
    public void connect() { }
    public void executeQuery(String query) { }
    public void close() { }
}

class ServiceClass {
    private DatabaseConnection db;  // HAS-A connection
    
    public ServiceClass() {
        this.db = new DatabaseConnection();
    }
    
    public void process() {
        db.executeQuery("SELECT * FROM users");
    }
}
```

### Another Example: Employee Hierarchy

```java
// ✅ GOOD - Clear inheritance
class Employee {
    public String name;
    public double salary;
    
    public void work() {
        System.out.println(name + " is working");
    }
}

class Manager extends Employee {
    public void manageteam() {
        System.out.println(name + " is managing a team");
    }
}

// ✅ GOOD - Composition for address (Employees HAS-A address)
class Address {
    public String street;
    public String city;
    public String zipCode;
}

class Employee {
    public String name;
    public Address address;  // Composition: HAS-A address
    
    public void printAddress() {
        System.out.println(address.street + ", " + address.city);
    }
}
```

### Composition and Delegation

```java
// Delegation: forwarding method calls to composed object
class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Sending email to " + to);
    }
}

class UserNotifier {
    private EmailService emailService;  // Composition
    
    public UserNotifier() {
        this.emailService = new EmailService();
    }
    
    public void notifyUser(String userEmail, String message) {
        // Delegate to EmailService
        emailService.sendEmail(userEmail, message);
    }
}

UserNotifier notifier = new UserNotifier();
notifier.notifyUser("user@example.com", "Welcome!");
// UserNotifier HAS-A EmailService and delegates to it
```

---

## Packages {#packages}

### What are Packages?

**Packages** are folders that organize Java classes. They prevent naming conflicts and organize code logically. Like folders on your computer for organizing files.

### Package Declaration

```java
// File: src/com/myapp/User.java
package com.myapp;

public class User {
    public String name;
}
```

The `package` statement must be the first line (before imports). It declares which package this class belongs to.

### Package Naming Convention

Packages use reverse domain notation:
- `com.google.android`
- `org.apache.commons`
- `java.util`
- `javax.swing`

This prevents conflicts (unlikely two companies have the same domain name).

### Importing Classes from Packages

```java
// File: com/myapp/main/Application.java
package com.myapp.main;

import com.myapp.User;           // Import specific class
import com.myapp.BankAccount;    // Import another class
import com.myapp.payment.*;      // Import all classes in payment package

public class Application {
    public static void main(String[] args) {
        User user = new User();        // ✅ Can use - imported
        BankAccount account = new BankAccount();  // ✅ Can use
    }
}
```

### Full Package Structure

```
MyProject/
├── src/
│   └── com/
│       └── myapp/
│           ├── User.java                 (package: com.myapp)
│           ├── BankAccount.java          (package: com.myapp)
│           ├── payment/
│           │   ├── PaymentProcessor.java (package: com.myapp.payment)
│           │   ├── CreditCard.java       (package: com.myapp.payment)
│           │   └── PayPal.java           (package: com.myapp.payment)
│           └── main/
│               └── Application.java      (package: com.myapp.main)
```

### Same Package Access

```java
// File: com/myapp/User.java
package com.myapp;

public class User {
    public String name;
}

// File: com/myapp/BankAccount.java
package com.myapp;

public class BankAccount {
    public void processUser() {
        User user = new User();  // ✅ Same package - no import needed!
    }
}
```

### Access Modifiers and Packages

Recall: default (package-private) access:

```java
// File: com/myapp/User.java
package com.myapp;

class InternalUser {  // Default access = package-private
    public String name;
}

public class User {   // Public = accessible everywhere
    public String name;
}

// File: com/myapp/UserManager.java
package com.myapp;

InternalUser user = new InternalUser();  // ✅ Same package, can access
User publicUser = new User();             // ✅ Public, can access

// File: com/other/OtherClass.java
package com.other;

InternalUser user = new InternalUser();  // ❌ Different package, can't access
User publicUser = new User();             // ✅ Public, can import and access
```

### Static Imports

```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Geometry {
    public void calculateArea() {
        double radius = 5;
        double area = PI * sqrt(radius);  // No need for Math.PI or Math.sqrt
        System.out.println(area);
    }
}
```

---

## Real-World Modeling Using OOP {#real-world-modeling}

Now let's apply everything we've learned to build a complete system.

### Example: University Management System

```java
// File: com/university/Student.java
package com.university;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private double gpa;
    private ArrayList<Course> enrolledCourses;
    
    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.gpa = 0.0;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
    }
    
    public void submitAssignment(Course course, Assignment assignment) {
        assignment.submit(this, course);
    }
    
    public void updateGPA(double newGPA) {
        if (newGPA >= 0 && newGPA <= 4.0) {
            this.gpa = newGPA;
        }
    }
    
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public double getGPA() { return gpa; }
    public ArrayList<Course> getEnrolledCourses() { return enrolledCourses; }
}
```

```java
// File: com/university/Course.java
package com.university;

import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private Professor professor;
    private ArrayList<Student> enrolledStudents;
    private int capacity;
    
    public Course(String courseId, String courseName, Professor professor, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.professor = professor;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }
    
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false;  // Course is full
    }
    
    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }
    
    public void startClass() {
        System.out.println("Course " + courseName + " started by " + professor.getName());
    }
    
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public Professor getProfessor() { return professor; }
    public ArrayList<Student> getEnrolledStudents() { return enrolledStudents; }
    public int getEnrollmentCount() { return enrolledStudents.size(); }
}
```

```java
// File: com/university/Professor.java
package com.university;

import java.util.ArrayList;

public class Professor {
    private String professorId;
    private String name;
    private String department;
    private ArrayList<Course> taughtCourses;
    
    public Professor(String professorId, String name, String department) {
        this.professorId = professorId;
        this.name = name;
        this.department = department;
        this.taughtCourses = new ArrayList<>();
    }
    
    public void assignCourse(Course course) {
        taughtCourses.add(course);
    }
    
    public void gradeAssignment(Assignment assignment, double score) {
        assignment.setScore(score);
    }
    
    public String getName() { return name; }
    public String getProfessorId() { return professorId; }
    public String getDepartment() { return department; }
}
```

```java
// File: com/university/Assignment.java
package com.university;

public class Assignment {
    private String assignmentId;
    private String title;
    private double totalPoints;
    private double earnedPoints;
    private Student submittedBy;
    private Course course;
    private boolean isGraded;
    
    public Assignment(String assignmentId, String title, double totalPoints) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.totalPoints = totalPoints;
        this.earnedPoints = 0;
        this.isGraded = false;
    }
    
    public void submit(Student student, Course course) {
        this.submittedBy = student;
        this.course = course;
        System.out.println(student.getName() + " submitted " + title);
    }
    
    public void setScore(double score) {
        if (score >= 0 && score <= totalPoints) {
            this.earnedPoints = score;
            this.isGraded = true;
        }
    }
    
    public double getPercentage() {
        return (earnedPoints / totalPoints) * 100;
    }
    
    public String getAssignmentId() { return assignmentId; }
    public double getTotalPoints() { return totalPoints; }
    public double getEarnedPoints() { return earnedPoints; }
    public boolean isGraded() { return isGraded; }
}
```

```java
// File: com/university/University.java
package com.university;

import java.util.ArrayList;

public class University {
    private String universityName;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;
    
    public University(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    
    public void registerStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " registered");
    }
    
    public void hireProfessor(Professor professor) {
        professors.add(professor);
        System.out.println("Professor " + professor.getName() + " hired");
    }
    
    public void createCourse(Course course) {
        courses.add(course);
        System.out.println("Course " + course.getCourseName() + " created");
    }
    
    public void printStatus() {
        System.out.println("\n=== " + universityName + " Status ===");
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Professors: " + professors.size());
        System.out.println("Total Courses: " + courses.size());
    }
}
```

```java
// File: com/university/main/UniversityApplication.java
package com.university.main;

import com.university.*;

public class UniversityApplication {
    public static void main(String[] args) {
        // Create university
        University university = new University("State University");
        
        // Create professors
        Professor dr_smith = new Professor("P001", "Dr. Smith", "Computer Science");
        Professor dr_jones = new Professor("P002", "Dr. Jones", "Mathematics");
        
        university.hireProfessor(dr_smith);
        university.hireProfessor(dr_jones);
        
        // Create courses
        Course javaIntro = new Course("CS101", "Introduction to Java", dr_smith, 30);
        Course calculus = new Course("MATH201", "Calculus I", dr_jones, 25);
        
        university.createCourse(javaIntro);
        university.createCourse(calculus);
        
        // Create students
        Student alice = new Student("S001", "Alice Johnson", "alice@university.edu");
        Student bob = new Student("S002", "Bob Smith", "bob@university.edu");
        Student carol = new Student("S003", "Carol Davis", "carol@university.edu");
        
        university.registerStudent(alice);
        university.registerStudent(bob);
        university.registerStudent(carol);
        
        // Students enroll in courses
        alice.enrollCourse(javaIntro);
        alice.enrollCourse(calculus);
        bob.enrollCourse(javaIntro);
        carol.enrollCourse(calculus);
        
        // Professors create and grade assignments
        Assignment assignment1 = new Assignment("A001", "Hello World Program", 100);
        alice.submitAssignment(javaIntro, assignment1);
        dr_smith.gradeAssignment(assignment1, 95);
        
        System.out.println(alice.getName() + " earned " + 
                          assignment1.getPercentage() + "% on " + 
                          assignment1.getAssignmentId());
        
        // Update GPA
        alice.updateGPA(3.8);
        
        university.printStatus();
    }
}
```

---

## Common Beginner Mistakes {#common-mistakes}

### Mistake 1: Confusing Classes with Objects

```java
// ❌ Wrong thinking
Student student;  // Thinking: "I created a student"
                  // Wrong: You created a REFERENCE, not a student

// ✅ Correct
Student student = new Student("Alice", 20);  // NOW you created an object
```

### Mistake 2: Forgetting `new`

```java
// ❌ Error
BankAccount account;
account.deposit(100);  // NullPointerException! account is null

// ✅ Correct
BankAccount account = new BankAccount();
account.deposit(100);
```

### Mistake 3: Using `==` for String Comparison

```java
// ❌ Wrong
String name1 = new String("Alice");
String name2 = new String("Alice");
if (name1 == name2) {  // Compares ADDRESSES, not content
    System.out.println("Same");  // Won't print
}

// ✅ Correct
if (name1.equals(name2)) {  // Compares content
    System.out.println("Same");  // Will print
}
```

### Mistake 4: Public Fields Instead of Encapsulation

```java
// ❌ Bad
class BankAccount {
    public double balance;
}
account.balance = -5000;  // Nothing prevents invalid data!

// ✅ Good
class BankAccount {
    private double balance;
    
    public void setBalance(double amount) {
        if (amount >= 0) {
            balance = amount;
        }
    }
}
```

### Mistake 5: Forgetting Constructor

```java
// ❌ Forgetting to initialize
class Student {
    public String name;
    public int age;
    // No constructor - name and age are null and 0
}

Student s = new Student();
System.out.println(s.name);  // null
System.out.println(s.age);   // 0

// ✅ With constructor
class Student {
    public String name;
    public int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Student s = new Student("Alice", 20);
System.out.println(s.name);  // Alice
System.out.println(s.age);   // 20
```

### Mistake 6: Misusing Inheritance

```java
// ❌ Wrong - Dog shouldn't extend Voice
class Voice {
    public void makeSound() { }
}

class Dog extends Voice {  // Wrong relationship
}

// ✅ Correct - Voice is a component of Dog
class Voice {
    public void bark() { }
}

class Dog {
    private Voice voice = new Voice();  // Composition
    
    public void bark() {
        voice.bark();
    }
}
```

### Mistake 7: Not Overriding `toString()`

```java
// ❌ Without toString()
class Person {
    public String name;
}

Person p = new Person();
p.name = "Alice";
System.out.println(p);  // Output: Person@7d6f77cc (not helpful)

// ✅ With toString()
class Person {
    public String name;
    
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

Person p = new Person();
p.name = "Alice";
System.out.println(p);  // Output: Person{name='Alice'} (helpful)
```

### Mistake 8: Modifying Static Variables Thinking They're Instance

```java
// ❌ Confusion
class Counter {
    static public int count = 0;
}

Counter c1 = new Counter();
Counter c2 = new Counter();

c1.count = 5;
System.out.println(c2.count);  // Output: 5 (same variable!)
System.out.println(Counter.count);  // Output: 5 (shared)

// ✅ Correct understanding
class Counter {
    public int instanceCount = 0;  // Each object has its own
    static public int totalCount = 0;  // All objects share this
}
```

### Mistake 9: Comparing Objects with `==`

```java
// ❌ Wrong
class Student {
    public int id;
}

Student alice = new Student();
alice.id = 1;

Student alice2 = new Student();
alice2.id = 1;

if (alice == alice2) {  // Compares memory addresses, not content
    System.out.println("Same");  // Won't print
}

// ✅ Correct
class Student {
    public int id;
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.id == other.id;
    }
}

if (alice.equals(alice2)) {  // Compares content
    System.out.println("Same");  // Will print
}
```

### Mistake 10: Circular Dependencies

```java
// ❌ Bad design - classes depend on each other
class Order {
    public Customer customer;
}

class Customer {
    public Order order;  // Creates circular dependency
}

// ✅ Good design - one way relationship
class Order {
    public Customer customer;
}

class Customer {
    // Customer doesn't need to know about Order directly
}
```

---

## Practice Section: Putting It All Together

### Major Concept Review

Let me create practice assignments for you to solidify your understanding.

### Practice Assignment 1: Student Grade Management System

**Assignment:**
Create a complete system to manage students and their grades:

1. Create a `Student` class with:
   - Fields: name, studentId, email
   - Constructor that initializes these fields
   - Private field for GPA that can only be set through validation
   - Methods: `addGrade(int grade)`, `calculateGPA()`, `printTranscript()`

2. Create a `Course` class with:
   - Fields: courseCode, courseName, maxCapacity
   - A collection to store enrolled students
   - Methods: `enrollStudent()`, `removeStudent()`, `isFull()`

3. Create a `GradingSystem` class (utility) with:
   - Static methods: `letterGrade(double gpa)`, `isPassingGrade(int grade)`

4. Create a `School` class that:
   - Manages multiple students and courses
   - Has methods to register students, create courses, enroll students
   - Can print a report of all students and their GPAs

**Questions to Think About:**
- Should GPA be public or private? Why?
- Should Student extend School or contain School? Why?
- How would you prevent a student from enrolling in a course twice?
- What validation would you add to GPA calculation?

### Challenge: E-Commerce System Design

**Your Challenge:**
Design an e-commerce system with the following requirements:

1. Create an `Item` class
2. Create a `ShoppingCart` class that:
   - Can add/remove items
   - Calculates total price
   - Applies discounts
3. Create different `PaymentMethod` classes (CreditCard, PayPal, ApplePay)
4. Create an `Order` class that processes payments
5. Create a `Customer` class that places orders

**Constraints:**
- Payment methods should follow an interface
- Cart should validate that items exist before adding
- Orders should not process with empty carts
- Discounts should have validation

**Design Decisions to Make:**
- Should Customer inherit from User or compose it?
- How should Item be identified (by id, name, both)?
- Should Cart be part of Customer or separate?
- How do you ensure only valid payment methods are used?

### Real-World Modeling Challenge: Library System

**Scenario:**
A local library wants a system to manage books, members, and lending.

**Requirements:**
1. Books can be borrowed and returned
2. Members have borrowing limits
3. Books can have fines for late returns
4. Different book types have different lending periods (3 days for magazines, 14 days for novels)
5. System should track member history

**Your Task:**
1. Identify all classes needed
2. Design the class hierarchy (what should inherit, what should compose?)
3. Identify fields and methods for each class
4. Create the complete implementation
5. Create a main method that demonstrates the system working

**Design Questions:**
- Should Book inherit from Item or should Item inherit from Book?
- How would you differentiate between book types?
- Should Member contain Loans or should Loan contain Member?
- How would you implement the different lending periods?

---

## Conclusion: From Beginner to Confident OOP Engineer

Congratulations! You've now learned all the core concepts of Java Object-Oriented Programming. Let's recap what you've mastered:

### What You Can Now Do:

1. **Design classes** that model real-world entities
2. **Organize code** using inheritance and composition
3. **Protect data** using encapsulation and access modifiers
4. **Create flexible systems** using interfaces and polymorphism
5. **Structure projects** using packages
6. **Build applications** that scale with new features without rewriting existing code
7. **Avoid common pitfalls** that beginners encounter

### The OOP Mindset:

Instead of thinking "What steps do I need to follow?", think:
- "What objects exist in this problem?"
- "What information does each object need?"
- "What can each object do?"
- "How do objects interact?"
- "How can I organize these objects logically?"

### Next Steps:

1. **Practice**: Build your own projects using these principles
2. **Refactor**: Take old procedural code and restructure it as OOP
3. **Study Design Patterns**: Learn common solutions to recurring problems
4. **Join Communities**: Share your code and get feedback
5. **Read Source Code**: Study how Java libraries are designed

### Key Principles to Remember:

- **DRY** (Don't Repeat Yourself): Use inheritance and methods to avoid code duplication
- **SOLID Principles**: Five principles for writing maintainable code
- **Encapsulation**: Hide complexity, expose simple interfaces
- **Composition over Inheritance**: Favor "has-a" when it makes sense
- **Program to Interfaces**: Depend on abstractions, not concrete classes

You're now ready to tackle real-world Java projects with confidence. The principles you've learned here will serve you throughout your programming career, not just in Java but in any object-oriented language.

Happy coding!

---

## Additional Resources for Deeper Learning

### Design Patterns to Study Next:
- Singleton
- Factory
- Builder
- Observer
- Strategy
- Decorator
- Adapter

### SOLID Principles:
- **S**ingle Responsibility Principle
- **O**pen/Closed Principle
- **L**iskov Substitution Principle
- **I**nterface Segregation Principle
- **D**ependency Inversion Principle

### Advanced Topics:
- Generics (`<T>`)
- Collections Framework
- Exception Handling
- File I/O
- Multithreading
- Networking
- Database Connectivity (JDBC)

---

**End of Complete Java OOP Guide**

This guide covered everything you need to start writing object-oriented Java code professionally. Master these concepts through practice and reading code, and you'll be well on your way to becoming an excellent software engineer.
