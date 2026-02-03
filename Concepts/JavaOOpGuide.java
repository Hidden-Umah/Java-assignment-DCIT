package Concepts;
/**
 * THE COMPLETE GUIDE TO JAVA OBJECT-ORIENTED PROGRAMMING
 * From Beginner to Confident OOP Engineer
 * 
 * This file contains comprehensive Java code examples demonstrating all OOP concepts.
 * Each section is clearly commented and executable.
 */

// ============================================================================
// SECTION 1: WHAT ARE CLASSES AND OBJECTS?
// ============================================================================

/**
 * A Class is a BLUEPRINT or TEMPLATE for creating objects.
 * An Object is a SPECIFIC INSTANCE created from a class.
 * 
 * Analogy: Recipe (class) vs Cake (object)
 */
class Student {
    // Fields (data that objects will have)
    public String name;
    public int age;
    public double gpa;
    
    // Method (behavior - what objects can do)
    public void study() {
        System.out.println(name + " is studying");
    }
}

// Creating objects from the Student blueprint:
// Student alice = new Student();
// alice.name = "Alice";
// alice.age = 20;
// alice.gpa = 3.8;
// alice.study();  // Output: Alice is studying


















































// ============================================================================
// SECTION 2: INSTANCES VS CLASSES
// ============================================================================

/**
 * The Fundamental Difference:
 * 
 * - Class: Template/Blueprint (One per class definition)
 * - Instance: An actual object created from the template (Many can exist)
 * 
 * Each instance is COMPLETELY SEPARATE.
 * Modifying one doesn't affect others.
 */
class Car {
    public String color;
    public int speed;
}

// Example of separate instances:
// Car car1 = new Car();
// car1.color = "Red";
// car1.speed = 0;
// 
// Car car2 = new Car();
// car2.color = "Blue";
// car2.speed = 0;
// 
// Modifying one doesn't affect the other:
// car1.color = "Red";
// car1.speed = 100;
// System.out.println(car1.color);  // Output: Red
// System.out.println(car2.color);  // Output: Blue (unchanged!)


















































// ============================================================================
// SECTION 3: FIELDS (ATTRIBUTES)
// ============================================================================

/**
 * Fields are variables that belong to an object.
 * They hold the object's data or state.
 * They answer: "What information does this object know about itself?"
 */
class Person {
    // Fields - these hold data for each Person object
    public String name;
    public int age;
    public String email;
    
    // Local variable (only exists in method, not a field)
    public void introduce() {
        String greeting = "Hello";  // LOCAL VARIABLE - only exists in this method
        System.out.println(greeting + ", I'm " + name);
    }
}

// Fields have default values when object is created:
// Person person = new Person();
// System.out.println(person.name);    // Output: null
// System.out.println(person.age);     // Output: 0
// System.out.println(person.email);   // Output: null


















































// ============================================================================
// SECTION 4: METHODS
// ============================================================================

/**
 * Methods are actions or behaviors that an object can perform.
 * They're functions that belong to a class.
 * They answer: "What can this object do?"
 */
class BankAccount {
    public double balance;
    
    // Method: withdraw money from account
    // void = this method doesn't return a value
    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrew: $" + amount);
    }
    
    // Method: check balance
    // double = this method returns a double value
    public double getBalance() {
        return balance;
    }
    
    // Method: deposit money
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: $" + amount);
    }
    
    // Method with validation
    public boolean withdraw_safe(double amount) {
        if (amount <= balance && amount > 0) {
            balance = balance - amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        }
        System.out.println("Cannot withdraw: insufficient funds");
        return false;
    }
}

// Usage:
// BankAccount account = new BankAccount();
// account.balance = 1000;
// account.withdraw(250);              // Output: Withdrew: $250
// double currentBalance = account.getBalance();  // currentBalance = 750


















































// ============================================================================
// SECTION 5: CONSTRUCTORS
// ============================================================================

/**
 * A Constructor is a special method that runs when you create a new object.
 * It's the object's initialization method.
 * Think of it as the "setup" that happens right after an object is born.
 */
class User {
    public String username;
    public String email;
    public int age;
    
    // Constructor - has same name as class, no return type
    public User(String username, String email, int age) {
        this.username = username;   // this.username = parameter username
        this.email = email;
        this.age = age;
    }
}

// Usage - object is initialized immediately:
// User user1 = new User("john_doe", "john@email.com", 25);
// User user2 = new User("maria_garcia", "maria@email.com", 28);
// // Both users are fully initialized


















































// ============================================================================
// SECTION 5B: MULTIPLE CONSTRUCTORS (Constructor Overloading)
// ============================================================================

/**
 * Sometimes you want different ways to create an object.
 * You can have multiple constructors with different parameters.
 */
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

// Usage - different ways to create a pizza:
// Pizza pepperoni = new Pizza("Large", 15.99, "Pepperoni");
// Pizza cheese = new Pizza("Medium", 11.99);
// Pizza basic = new Pizza("Small");


















































// ============================================================================
// SECTION 5C: CALLING OTHER CONSTRUCTORS WITH THIS
// ============================================================================

/**
 * One constructor can call another using this().
 * This avoids code duplication.
 */
class Rectangle {
    public int width;
    public int height;
    
    // Constructor 1: Both dimensions
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    // Constructor 2: Square (width = height)
    // This calls Constructor 1
    public Rectangle(int size) {
        this(size, size);  // Calls the Rectangle(int, int) constructor
    }
    
    public int calculateArea() {
        return width * height;
    }
}

// Usage:
// Rectangle rect = new Rectangle(5, 10);  // Uses Constructor 1
// Rectangle square = new Rectangle(5);    // Uses Constructor 2, which calls Constructor 1


















































// ============================================================================
// SECTION 6: ACCESS MODIFIERS
// ============================================================================

/**
 * Access modifiers control who can access (read/modify) your class's fields and methods.
 * They're like security levels.
 * 
 * Four access modifiers:
 * - public: Anyone can access
 * - private: Only this class can access
 * - protected: This class + subclasses can access
 * - (default/package-private): Same package can access
 */
class Example_AccessModifiers {
    public String publicField = "Anyone can access";
    private String privateField = "Only this class can access";
    protected String protectedField = "This class + subclasses can access";
    String defaultField = "Same package can access";  // No modifier = default access
    
    // Getter for private field
    public String getPrivateField() {
        return privateField;
    }
}

// Example: Why public fields are dangerous
class BadBankAccount {
    public double balance;  // DANGEROUS - anyone can modify!
}

// Someone could cheat:
// BadBankAccount account = new BadBankAccount();
// account.balance = 1000000;  // Easy to hack!


















































// ============================================================================
// SECTION 7: ENCAPSULATION
// ============================================================================

/**
 * Encapsulation is bundling data (fields) and methods together,
 * and controlling access through modifiers.
 * It's about hiding internal details and exposing only what's necessary.
 * 
 * Real-world analogy: A car
 * - Hidden (Private): Engine, transmission, internal wiring
 * - Protected (Methods): Steering wheel, pedals, gear shift
 * - Public Interface: You interact with the car through the controls
 */
class GoodBankAccount {
    private double balance;      // Hidden from outside - private
    private String accountNumber;
    
    // Constructor
    public GoodBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    // Getter: retrieve the value
    public double getBalance() {
        return balance;
    }
    
    // Setter: change the value with validation
    public void setBalance(double newBalance) {
        if (newBalance >= 0) {
            balance = newBalance;
        } else {
            System.out.println("Invalid balance!");
        }
    }
    
    // Method with business logic
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        }
        System.out.println("Withdrawal failed!");
        return false;
    }
    
    // Another withdrawal method with fee
    public void withdrawWithFee(double amount) {
        double fee = amount * 0.01;  // 1% fee
        if (amount + fee <= balance) {
            balance -= (amount + fee);
            System.out.println("Withdrew: $" + amount + " (fee: $" + fee + ")");
        }
    }
}

// Usage:
// GoodBankAccount account = new GoodBankAccount("12345", 1000);
// account.withdraw(200);                    // Works
// account.withdrawWithFee(300);             // Works with fee calculation
// System.out.println(account.getBalance()); // Get balance through getter
// account.setBalance(-500);                 // Rejected - validation prevents it


















































// ============================================================================
// SECTION 7B: COMPLETE ENCAPSULATION EXAMPLE
// ============================================================================

/**
 * A Book class demonstrating full encapsulation:
 * - All fields are private
 * - All access is through methods
 * - Validation is built into setters
 * - Business logic is encapsulated
 */
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


















































// ============================================================================
// SECTION 8: ABSTRACTION
// ============================================================================

/**
 * Abstraction means showing only the essential details and hiding complex implementation.
 * It's about creating a simple interface while the internal logic can be complex.
 * 
 * Real-world example: A TV remote
 * - Hidden: How the remote communicates with the TV
 * - Shown: Buttons for the user to interact with
 */


















































// ============================================================================
// SECTION 8A: ABSTRACT CLASSES
// ============================================================================

/**
 * An abstract class is a class that can't be instantiated directly.
 * It serves as a template with some methods that subclasses MUST implement.
 * 
 * You can't do: Animal animal = new Animal();
 * But you can: Dog dog = new Dog();
 */
abstract class Animal {
    public String name;
    
    // Abstract method: subclasses MUST implement this
    abstract public void makeSound();
    
    // Regular method: subclasses inherit this
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

// Concrete implementation of abstract class
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}

// Another concrete implementation
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// Usage:
// Animal dog = new Dog();
// dog.name = "Rex";
// dog.makeSound();  // Output: Rex says: Woof! Woof!
// dog.sleep();      // Output: Rex is sleeping...
//
// Animal cat = new Cat();
// cat.name = "Whiskers";
// cat.makeSound();  // Output: Whiskers says: Meow!


















































// ============================================================================
// SECTION 8B: INTERFACES
// ============================================================================

/**
 * An interface is like an abstract class, but with no implementation at all.
 * It's a contract: "If you implement me, you must have these methods."
 * 
 * A class can implement MULTIPLE interfaces (but extend only ONE class).
 */

// Interface 1: Defines what something that can be drawn must do
interface Drawable {
    void draw();
    void erase();
}

// Interface 2: Defines what something that can be resized must do
interface Resizable {
    void resize(int width, int height);
}

// A class that implements BOTH interfaces
class Circle implements Drawable, Resizable {
    private int radius;
    
    public Circle(int radius) {
        this.radius = radius;
    }
    
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

// Another class implementing both interfaces
class Rectangle1 implements Drawable, Resizable {
    private int width;
    private int height;
    
    public Rectangle1(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle " + width + "x" + height);
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

// Usage:
// Drawable[] shapes = new Drawable[2];
// shapes[0] = new Circle(5);
// shapes[1] = new Rectangle(10, 20);
//
// for (Drawable shape : shapes) {
//     shape.draw();
//     shape.erase();
// }


















































// ============================================================================
// SECTION 8C: REAL-WORLD ABSTRACTION - PAYMENT SYSTEM
// ============================================================================

/**
 * Payment processing system using interfaces.
 * Different payment methods implement the same interface.
 * The code that uses payments doesn't care HOW payment is processed.
 */

interface PaymentMethod {
    boolean processPayment(double amount);
    void refund(double amount);
    String getPaymentDetails();
}

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


















































// ============================================================================
// SECTION 9: INHERITANCE
// ============================================================================

/**
 * Inheritance allows one class to inherit fields and methods from another class.
 * It's a "is-a" relationship: "A Dog is an Animal."
 * 
 * Terminology:
 * - Superclass (Parent): The class being inherited from
 * - Subclass (Child): The class that inherits
 * - extends: Keyword used for inheritance
 */

class Animal_Parent {
    public String name;
    public int age;
    
    // Constructor in parent
    public Animal_Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void makeSound() {
        System.out.println(name + " makes a sound");
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Dog inherits from Animal
class Dog_Child extends Animal_Parent {
    public void bark() {
        System.out.println(name + " is barking");
    }
    
    // Constructor must call parent constructor using super()
    public Dog_Child(String name, int age) {
        super(name, age);  // Call parent constructor
    }
}

// Cat also inherits from Animal
class Cat_Child extends Animal_Parent {
    public void meow() {
        System.out.println(name + " is meowing");
    }
    
    public Cat_Child(String name, int age) {
        super(name, age);
    }
}

// Usage:
// Dog dog = new Dog_Child("Buddy", 3);
// dog.name = "Buddy";     // Inherited field
// dog.age = 3;            // Inherited field
// dog.eat();              // Inherited method
// dog.bark();             // Own method


















































// ============================================================================
// SECTION 9B: INHERITANCE HIERARCHY (CHAIN)
// ============================================================================

/**
 * Classes can form a hierarchy chain.
 * A subclass can itself be a superclass for another class.
 */

class Vehicle {
    public int speed;
}

class Car_Hierarchy extends Vehicle {
    public int doors;
}

class ElectricCar extends Car_Hierarchy {
    public int batteryCapacity;
    
    public void printInfo() {
        // Can access all inherited fields
        System.out.println("Speed: " + speed);
        System.out.println("Doors: " + doors);
        System.out.println("Battery: " + batteryCapacity);
    }
}

// Usage:
// ElectricCar tesla = new ElectricCar();
// tesla.speed = 150;           // From Vehicle
// tesla.doors = 4;             // From Car
// tesla.batteryCapacity = 100; // Own field


















































// ============================================================================
// SECTION 9C: REAL-WORLD INHERITANCE - BANK ACCOUNTS
// ============================================================================

/**
 * Bank account hierarchy:
 * - Base class for all accounts
 * - Specialized account types (Savings, Checking)
 * - Each type overrides methods with specific behavior
 */

class BankAccount_Base {
    protected String accountNumber;
    protected double balance;
    protected double interestRate;
    
    public BankAccount_Base(String accountNumber, double initialBalance) {
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
class SavingsAccount extends BankAccount_Base {
    private double minimumBalance = 500;
    
    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
        this.interestRate = 0.05;
    }
    
    @Override
    public boolean withdraw(double amount) {
        if ((balance - amount) >= minimumBalance) {
            return super.withdraw(amount);  // Call parent's withdraw
        } else {
            System.out.println("Cannot withdraw. Minimum balance must be maintained.");
            return false;
        }
    }
}

// Checking account has monthly fees
class CheckingAccount extends BankAccount_Base {
    private double monthlyFee = 10;
    
    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
        this.interestRate = 0.01;
    }
    
    public void applyMonthlyFee() {
        balance -= monthlyFee;
        System.out.println("Monthly fee of $" + monthlyFee + " applied");
    }
}


















































// ============================================================================
// SECTION 10: POLYMORPHISM
// ============================================================================

/**
 * Polymorphism means "many forms."
 * It allows you to write code that works with multiple types.
 * One interface, many implementations.
 * 
 * The real power comes from using a parent class reference to point to
 * a child class object.
 */

// Base class
class Animal_Poly {
    public String name;
    
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass 1
class Dog_Poly extends Animal_Poly {
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

// Subclass 2
class Cat_Poly extends Animal_Poly {
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// The magic of polymorphism:
// Animal dog = new Dog_Poly();     // Animal reference, Dog object
// Animal cat = new Cat_Poly();     // Animal reference, Cat object
//
// dog.makeSound();  // Output: Woof! (Dog's version)
// cat.makeSound();  // Output: Meow! (Cat's version)
//
// You can use them the same way, but they behave differently!


















































// ============================================================================
// SECTION 10B: POLYMORPHISM WITH ARRAYS
// ============================================================================

// This demonstrates the power of polymorphism:
// You can treat different types the same way

class AnimalDemo {
    public static void demonstratePolymorphism() {
        // Array of Animal references
        Animal_Poly[] animals = new Animal_Poly[3];
        
        // But hold different actual types
        animals[0] = new Dog_Poly();
        animals[0].name = "Rex";
        
        animals[1] = new Cat_Poly();
        animals[1].name = "Whiskers";
        
        animals[2] = new Dog_Poly();
        animals[2].name = "Buddy";
        
        // Call the same method on each
        // But each one calls its own version!
        for (Animal_Poly animal : animals) {
            animal.makeSound();
        }
        // Output:
        // Rex says: Woof!
        // Whiskers says: Meow!
        // Buddy says: Woof!
    }
}


















































// ============================================================================
// SECTION 10C: REAL-WORLD POLYMORPHISM - PAYMENT PROCESSING
// ============================================================================

/**
 * The checkout process doesn't care HOW payment is processed.
 * It just knows about the PaymentMethod interface.
 */

class ShoppingCart {
    private double total = 0;
    
    public void addItem(double price) {
        total += price;
    }
    
    // This method accepts ANY PaymentMethod
    // Works with CreditCard, DigitalWallet, or any new payment method added later
    public void checkout(PaymentMethod processor) {
        System.out.println("Processing payment with: " + processor.getPaymentDetails());
        if (processor.processPayment(total)) {
            System.out.println("Order complete!");
        } else {
            System.out.println("Payment failed!");
        }
    }
}

// Usage:
// ShoppingCart cart = new ShoppingCart();
// cart.addItem(50);
// cart.addItem(49.99);
//
// PaymentMethod creditCard = new CreditCard("1234-5678-9012-3456", 500);
// cart.checkout(creditCard);
//
// PaymentMethod wallet = new DigitalWallet("user@email.com", 200);
// cart.checkout(wallet);  // Same checkout works with different payment method!


















































// ============================================================================
// SECTION 11: METHOD OVERLOADING AND OVERRIDING
// ============================================================================

/**
 * Method Overloading: Multiple methods with SAME NAME but DIFFERENT PARAMETERS
 * - Compile-time polymorphism
 * - Happens in same class or related classes
 * 
 * Method Overriding: Subclass provides its own version of parent's method
 * - Runtime polymorphism
 * - Only in subclass
 */


















































// ============================================================================
// SECTION 11A: METHOD OVERLOADING
// ============================================================================

/**
 * Same method name, but different parameters.
 * Java determines which version to use based on:
 * 1. Number of parameters
 * 2. Type of parameters
 * 3. Order of parameters
 */

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

// Usage:
// Calculator calc = new Calculator();
// System.out.println(calc.add(5, 3));              // Uses Version 1: 8
// System.out.println(calc.add(5.5, 3.2));          // Uses Version 2: 8.7
// System.out.println(calc.add(5, 3, 2));           // Uses Version 3: 10
// System.out.println(calc.add(new int[]{5, 3, 2})); // Uses Version 4: 10

class Formatter {
    // Different parameter types - each is overloaded
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

// Usage:
// Formatter formatter = new Formatter();
// System.out.println(formatter.format("Hello"));        // Text: Hello
// System.out.println(formatter.format(42));             // Number: 42
// System.out.println(formatter.format(3.14));           // Decimal: 3.14
// System.out.println(formatter.format(true));           // Boolean: true

// ============================================================================
// SECTION 11B: METHOD OVERRIDING
// ============================================================================

/**
 * Subclass provides its own version of parent's method.
 * The method signature must be identical.
 * Return type must be compatible.
 * Can't reduce access level.
 */

class Parent {
    public void doSomething() {
        System.out.println("Parent version");
    }
    
    protected void helper() {
        System.out.println("Parent helper");
    }
}

class Child extends Parent {
    @Override  // Annotation shows you're intentionally overriding
    public void doSomething() {
        System.out.println("Child version");
    }
    
    @Override
    public void helper() {
        System.out.println("Child helper");
    }
}

// Usage:
// Parent parent = new Parent();
// parent.doSomething();  // Output: Parent version
//
// Child child = new Child();
// child.doSomething();   // Output: Child version
//
// Parent parentRef = new Child();
// parentRef.doSomething();  // Output: Child version (polymorphism!)


















































// ============================================================================
// SECTION 11C: PRACTICAL EXAMPLE - BOTH OVERLOADING AND OVERRIDING
// ============================================================================

class PaymentProcessor_Base {
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

class SecurePaymentProcessor extends PaymentProcessor_Base {
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

// Usage:
// SecurePaymentProcessor processor = new SecurePaymentProcessor();
// processor.process(100);              // Uses first overload
// processor.process(15000, "EUR");     // Uses second overload (calls overridden method)


















































// ============================================================================
// SECTION 12: THE THIS KEYWORD
// ============================================================================

/**
 * 'this' is a reference to the current object.
 * It means "this object I'm currently in."
 * 
 * Common uses:
 * 1. Distinguish between parameter and field with same name
 * 2. Call other constructors
 * 3. Return from methods for chaining
 * 4. Pass reference to other methods
 */

class Person_This {
    public String name;
    public int age;
    
    // Problem: parameter name conflicts with field name
    public void setName(String name) {
        this.name = name;  // this.name = parameter name
    }
    
    public void setAge(int age) {
        this.age = age;  // this.age = parameter age
    }
    
    // Using this in constructor
    public Person_This(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


















































// ============================================================================
// SECTION 12B: CALLING CONSTRUCTORS WITH THIS
// ============================================================================

class Rectangle_This {
    public int width;
    public int height;
    
    public Rectangle_This(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    // Square constructor calls the Rectangle constructor
    public Rectangle_This(int size) {
        this(size, size);  // Calls the Rectangle(int, int) constructor
    }
}


















































// ============================================================================
// SECTION 12C: METHOD CHAINING WITH THIS
// ============================================================================

/**
 * Some methods return 'this' to allow chaining.
 * This allows elegant, fluent APIs.
 */

class StringBuilderDemo {
    public String content = "";
    
    public StringBuilderDemo append(String text) {
        content += text;
        return this;  // Return this object for chaining
    }
    
    public StringBuilderDemo addNewLine() {
        content += "\n";
        return this;  // Return this object for chaining
    }
    
    @Override
    public String toString() {
        return content;
    }
}

// Usage:
// String result = new StringBuilderDemo()
//     .append("Hello")
//     .append(" ")
//     .append("World")
//     .addNewLine()
//     .toString();
// System.out.println(result);  // Hello World


















































// ============================================================================
// SECTION 12D: PASSING THIS TO OTHER METHODS
// ============================================================================

class Greeter {
    public void greetPerson(Person_This person) {
        System.out.println("Hello, " + person.name);
    }
}

// Usage:
// Person p = new Person("Alice");
// Greeter g = new Greeter();
// g.greetPerson(p);  // Passing the person object


















































// ============================================================================
// SECTION 13: THE STATIC KEYWORD
// ============================================================================

/**
 * 'static' means "belongs to the class, not to instances."
 * There's only one copy shared by all objects.
 * 
 * Can be applied to:
 * - Variables (static fields)
 * - Methods (static methods)
 * - Blocks (static initializers)
 */


















































// ============================================================================
// SECTION 13A: STATIC VARIABLES
// ============================================================================

/**
 * A static variable is shared by all instances of the class.
 * There's only ONE copy, not one per object.
 */

class BankAccount_Static {
    public String accountHolder;
    public double balance;
    
    // Static variable - SHARED by all accounts
    static public double interestRate = 0.05;
    
    // Instance counter - shared by all
    static public int totalAccounts = 0;
    
    public BankAccount_Static(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;  // Increment shared counter
    }
}

// Usage:
// BankAccount acc1 = new BankAccount_Static("John", 1000);
// BankAccount acc2 = new BankAccount_Static("Jane", 2000);
//
// System.out.println(BankAccount.interestRate);  // 0.05
// System.out.println(acc1.interestRate);         // Also 0.05 (same variable!)
//
// BankAccount.interestRate = 0.07;  // Change it for ALL accounts
// System.out.println(acc1.interestRate);  // Now 0.07
// System.out.println(acc2.interestRate);  // Also 0.07
//
// System.out.println(BankAccount.totalAccounts);  // 2


















































// ============================================================================
// SECTION 13B: STATIC METHODS
// ============================================================================

/**
 * Static methods can be called without creating an object.
 * They can only access static variables and call static methods.
 * They can't access instance variables or instance methods.
 */

class MathHelper {
    // Static methods - no object needed
    static public int add(int a, int b) {
        return a + b;
    }
    
    static public int multiply(int a, int b) {
        return a * b;
    }
    
    static public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

// Usage - no object creation needed:
// int sum = MathHelper.add(5, 3);              // Works
// int product = MathHelper.multiply(4, 6);     // Works


















































// ============================================================================
// SECTION 13C: STATIC UTILITY CLASS
// ============================================================================

/**
 * A utility class with all static methods.
 * You don't instantiate it, just call methods on the class itself.
 */

class StringUtils {
    // All methods are static
    
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
    
    static public int wordCount(String str) {
        if (isEmpty(str)) return 0;
        return str.split(" ").length;
    }
}

// Usage:
// System.out.println(StringUtils.isEmpty(""));         // true
// System.out.println(StringUtils.capitalize("hello"));  // Hello
// System.out.println(StringUtils.reverse("hello"));     // olleh
// System.out.println(StringUtils.wordCount("hello world")); // 2


















































// ============================================================================
// SECTION 13D: STATIC vs INSTANCE
// ============================================================================

class Account {
    // Instance variables - different for each object
    public String accountNumber;
    public double balance;
    
    // Static variables - shared by all objects
    static public double interestRate = 0.05;
    static public int totalAccounts = 0;
    
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    
    // Instance method - works with instance variables
    public void printInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate);  // Can access static
    }
    
    // Static method - can only access static variables
    static public void printGlobalStats() {
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate);
        // System.out.println(accountNumber);  // ❌ Can't access instance!
    }
}


















































// ============================================================================
// SECTION 14: THE FINAL KEYWORD
// ============================================================================

/**
 * 'final' means "cannot be changed."
 * Can be applied to:
 * 1. Variables: Can't reassign
 * 2. Methods: Can't override
 * 3. Classes: Can't extend
 */


















































// ============================================================================
// SECTION 14A: FINAL VARIABLES (CONSTANTS)
// ============================================================================

/**
 * Once you assign a final variable, you can't change it.
 * Usually used for constants.
 */

class MathConstants {
    // Final variables - can't be changed
    final static public double PI = 3.14159;
    final static public double E = 2.71828;
    final static public double GOLDEN_RATIO = 1.618;
    
    // Instance final variable
    final public String name;
    
    public MathConstants(String name) {
        this.name = name;  // Can assign once in constructor
        // this.name = "other";  // ❌ Can't reassign - it's final
    }
}

// Usage:
// System.out.println(MathConstants.PI);  // 3.14159
// // MathConstants.PI = 3.14;  // ❌ Error! Can't change final


















































// ============================================================================
// SECTION 14B: FINAL METHODS
// ============================================================================

/**
 * A final method can't be overridden.
 * Use when behavior should NEVER be changed by subclasses.
 */

class Animal_Final {
    public void makeSound() {
        System.out.println("Generic sound");
    }
    
    // This method is critical and should never be overridden
    final public void breathe() {
        System.out.println("Breathing...");
    }
}

class Dog_Final extends Animal_Final {
    @Override
    public void makeSound() {        // ✅ Can override
        System.out.println("Woof!");
    }
    
    // @Override
    // public void breathe() {        // ❌ Can't override final method
    //     System.out.println("Dog breathing");
    // }
}

// ============================================================================
// SECTION 14C: FINAL CLASSES
// ============================================================================

/**
 * A final class can't be extended.
 * Use when subclassing would break design or security.
 */

final class Immutable {
    private String value;
    
    public Immutable(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}

// class MyImmutable extends Immutable {  // ❌ Error! Can't extend final class
// }

// Real-world example: Java's String class is final
// final public class String { }  // This is how Java defines it


















































// ============================================================================
// SECTION 14D: REAL-WORLD EXAMPLE - CONFIGURATION CLASS
// ============================================================================

/**
 * Configuration should never be subclassed.
 * All values are constants.
 */

final class DatabaseConfig {
    final public String HOST = "localhost";
    final public int PORT = 5432;
    final public String DATABASE = "myapp";
    final public String USERNAME = "admin";
    
    final public void printConfig() {
        System.out.println("Host: " + HOST);
        System.out.println("Port: " + PORT);
        System.out.println("Database: " + DATABASE);
    }
}


















































// ============================================================================
// SECTION 15: COMPOSITION vs INHERITANCE
// ============================================================================

/**
 * When one class needs features from another, you have two choices:
 * 
 * 1. Inheritance ("is-a"): The class BECOMES the other type
 * 2. Composition ("has-a"): The class CONTAINS an instance of the other type
 */

// ============================================================================
// SECTION 15A: INHERITANCE - IS-A RELATIONSHIP
// ============================================================================

class Vehicle_Comp {
    public void start() {
        System.out.println("Vehicle starting");
    }
}

// A Car IS-A Vehicle
class Car_Inheritance extends Vehicle_Comp {
    @Override
    public void start() {
        System.out.println("Car engine starting");
    }
}

// Usage:
// Car car = new Car_Inheritance();
// car.start();  // Works - Car is-a Vehicle


















































// ============================================================================
// SECTION 15B: COMPOSITION - HAS-A RELATIONSHIP
// ============================================================================

/**
 * A Car HAS-A Engine, not IS-A Engine.
 * Composition is often better than inheritance.
 */

class Engine {
    public void start() {
        System.out.println("Engine starting...");
    }
    
    public void stop() {
        System.out.println("Engine stopping...");
    }
}

class Car_Composition {
    private Engine engine;  // HAS-A engine (composition)
    
    public Car_Composition() {
        this.engine = new Engine();
    }
    
    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
        engine.stop();
    }
}

// Usage:
// Car car = new Car_Composition();
// car.drive();
// The car doesn't need to BE an engine, it USES an engine


















































// ============================================================================
// SECTION 15C: WHEN INHERITANCE IS WRONG
// ============================================================================

/**
 * Real-world example: Penguin and Bird
 * Wrong: Penguin extends Bird (penguins can't fly!)
 * Right: Use composition or separate hierarchy
 */

// ❌ WRONG - Wrong hierarchy
abstract class Bird_Wrong {
    public void fly() {
        System.out.println("Flying...");
    }
}

// class Penguin_Wrong extends Bird_Wrong {
//     // Forced to inherit fly() even though it's wrong!
//     // Semantic nonsense
// }

// ✅ RIGHT - Use composition
class Penguin {
    // Penguins have wings, but don't use them to fly
    public void swim() {
        System.out.println("Penguin swimming...");
    }
}


















































// ============================================================================
// SECTION 15D: DECISION MATRIX
// ============================================================================

/**
 * Use Inheritance when:
 * - There's a clear "is-a" relationship
 * - You want to reuse implementation
 * - It makes semantic sense
 * Example: class Dog extends Animal
 *
 * Use Composition when:
 * - There's a "has-a" relationship
 * - You need flexibility
 * - You want to avoid tight coupling
 * Example: class Car { private Engine engine; }
 */


















































// ============================================================================
// SECTION 15E: REAL-WORLD EXAMPLE - DATABASE WITH COMPOSITION
// ============================================================================

/**
 * RIGHT approach: Use composition
 * ServiceClass HAS-A DatabaseConnection
 */

class DatabaseConnection {
    public void connect() {
        System.out.println("Connected to database");
    }
    
    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }
    
    public void close() {
        System.out.println("Connection closed");
    }
}

class UserService {
    private DatabaseConnection db;  // HAS-A connection (composition)
    
    public UserService() {
        this.db = new DatabaseConnection();
    }
    
    public void process() {
        db.connect();
        db.executeQuery("SELECT * FROM users");
        db.close();
    }
}


















































// ============================================================================
// SECTION 16: REAL-WORLD MODELING - UNIVERSITY SYSTEM
// ============================================================================

/**
 * Complete university management system demonstrating all OOP concepts.
 */

class Student_System {
    private String studentId;
    private String name;
    private String email;
    private double gpa;
    
    public Student_System(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.gpa = 0.0;
    }
    
    public void updateGPA(double newGPA) {
        if (newGPA >= 0 && newGPA <= 4.0) {
            this.gpa = newGPA;
        }
    }
    
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public String getEmail() { return email; }
    public double getGPA() { return gpa; }
}

class Professor_System {
    private String professorId;
    private String name;
    private String department;
    
    public Professor_System(String professorId, String name, String department) {
        this.professorId = professorId;
        this.name = name;
        this.department = department;
    }
    
    public String getProfessorId() { return professorId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
}

class Course_System {
    private String courseId;
    private String courseName;
    private Professor_System professor;
    private int capacity;
    
    public Course_System(String courseId, String courseName, Professor_System professor, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.professor = professor;
        this.capacity = capacity;
    }
    
    public String getCourseName() { return courseName; }
    public Professor_System getProfessor() { return professor; }
    public String getCourseId() { return courseId; }
    public int getCapacity() { return capacity; }
}

class Assignment_System {
    private String assignmentId;
    private String title;
    private double totalPoints;
    private double earnedPoints;
    
    public Assignment_System(String assignmentId, String title, double totalPoints) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.totalPoints = totalPoints;
        this.earnedPoints = 0;
    }
    
    public void setScore(double score) {
        if (score >= 0 && score <= totalPoints) {
            this.earnedPoints = score;
        }
    }
    
    public double getPercentage() {
        if (totalPoints == 0) return 0;
        return (earnedPoints / totalPoints) * 100;
    }
    
    public String getAssignmentId() { return assignmentId; }
    public String getTitle() { return title; }
}


















































// ============================================================================
// SECTION 17: COMMON BEGINNER MISTAKES
// ============================================================================

/**
 * 10 common mistakes beginners make with Java OOP.
 * Understanding these prevents countless bugs.
 */

// ============================================================================
// MISTAKE 1: Confusing Classes with Objects
// ============================================================================

class Mistake1_Demo {
    public void demonstrate() {
        // ❌ Wrong thinking
        Student studentRef;  // You created a REFERENCE, not a student
                             // studentRef is null (points to nothing)
        
        // ✅ Correct
        Student student = new Student();  // NOW you created an object
        student.name = "Alice";
        student.age = 20;
        student.gpa = 3.8;
    }
}


















































// ============================================================================
// MISTAKE 2: Forgetting new
// ============================================================================

class Mistake2_Demo {
    public void demonstrate() {
        // ❌ Error
        // BankAccount account;
        // account.deposit(100);  // NullPointerException! account is null
        
        // ✅ Correct
        BankAccount account = new BankAccount();  // Use 'new'
        account.balance = 1000;
        account.deposit(100);
    }
}


















































// ============================================================================
// MISTAKE 3: Using == for String Comparison
// ============================================================================

class Mistake3_Demo {
    public void demonstrate() {
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
    }
}


















































// ============================================================================
// MISTAKE 4: Public Fields Instead of Encapsulation
// ============================================================================

class Mistake4_BadExample {
    public double balance;  // ❌ Bad - no protection
}

class Mistake4_GoodExample {
    private double balance;  // ✅ Good - protected
    
    public void setBalance(double amount) {
        if (amount >= 0) {  // Validation
            balance = amount;
        }
    }
    
    public double getBalance() {
        return balance;
    }
}


















































// ============================================================================
// MISTAKE 5: Forgetting Constructor
// ============================================================================

class Mistake5_BadExample {
    public String name;
    public int age;
    // No constructor - name is null, age is 0
}

class Mistake5_GoodExample {
    public String name;
    public int age;
    
    public Mistake5_GoodExample(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


















































// ============================================================================
// MISTAKE 6: Misusing Inheritance
// ============================================================================

class Mistake6_WrongExample {
    // ❌ Wrong - Dog shouldn't extend Voice
    // class Dog extends Voice { }
}

class Mistake6_RightExample {
    // ✅ Right - Voice is a component of Dog
    class Voice {
        public void bark() { }
    }
    
    class Dog {
        private Voice voice = new Voice();  // Composition
        
        public void bark() {
            voice.bark();
        }
    }
}


















































// ============================================================================
// MISTAKE 7: Not Overriding toString()
// ============================================================================

class Mistake7_BadExample {
    public String name;
    // No toString() override
    // System.out.println(obj) outputs: Person@7d6f77cc (not helpful)
}

class Mistake7_GoodExample {
    public String name;
    
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";  // Helpful output
    }
}


















































// ============================================================================
// MISTAKE 8: Modifying Static Variables Thinking They're Instance
// ============================================================================

class Mistake8_Example {
    static public int count = 0;  // Shared by all instances
    public int instanceCount = 0; // Each instance has its own
}

// Usage:
// Mistake8_Example obj1 = new Mistake8_Example();
// Mistake8_Example obj2 = new Mistake8_Example();
// obj1.count = 5;
// System.out.println(obj2.count);  // Also 5! (shared static)


















































// ============================================================================
// MISTAKE 9: Comparing Objects with ==
// ============================================================================

class Mistake9_BadExample {
    public int id;
    // Using == compares memory addresses, not content
}

class Mistake9_GoodExample {
    public int id;
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Mistake9_GoodExample)) return false;
        Mistake9_GoodExample other = (Mistake9_GoodExample) obj;
        return this.id == other.id;
    }
}


















































// ============================================================================
// MISTAKE 10: Circular Dependencies
// ============================================================================

class Mistake10_BadExample {
    // ❌ Bad design - circular dependency
    // class Order { public Customer customer; }
    // class Customer { public Order order; }
}

class Mistake10_GoodExample {
    // ✅ Good - one-way relationship
    class Order {
        public Customer_MC customer;
    }
    
    class Customer_MC {
        // Customer doesn't need to know about Order
    }
}

// ============================================================================
// MAIN CLASS - DEMONSTRATING ALL CONCEPTS
// ============================================================================

public class JavaOOpGuide {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("JAVA OBJECT-ORIENTED PROGRAMMING - COMPREHENSIVE GUIDE");
        System.out.println("=".repeat(80));
        
        // SECTION 1: Classes and Objects
        System.out.println("\n1. CLASSES AND OBJECTS");
        System.out.println("-".repeat(80));
        Student alice = new Student();
        alice.name = "Alice";
        alice.age = 20;
        alice.gpa = 3.8;
        alice.study();
        
        // SECTION 2: Instances vs Classes
        System.out.println("\n2. INSTANCES VS CLASSES (Separate Objects)");
        System.out.println("-".repeat(80));
        Car car1 = new Car();
        car1.color = "Red";
        car1.speed = 0;
        
        Car car2 = new Car();
        car2.color = "Blue";
        car2.speed = 0;
        
        System.out.println("Car 1 color: " + car1.color);  // Red
        System.out.println("Car 2 color: " + car2.color);  // Blue (unchanged!)
        
        // SECTION 3: Encapsulation
        System.out.println("\n3. ENCAPSULATION");
        System.out.println("-".repeat(80));
        GoodBankAccount account = new GoodBankAccount("ACC123", 1000);
        account.withdraw(200);
        System.out.println("Balance: " + account.getBalance());
        account.setBalance(-500);  // Rejected by validation
        System.out.println("Balance after attempted invalid set: " + account.getBalance());
        
        // SECTION 4: Inheritance
        System.out.println("\n4. INHERITANCE");
        System.out.println("-".repeat(80));
        Dog_Child dog = new Dog_Child("Buddy", 3);
        dog.eat();      // Inherited
        dog.bark();     // Own method
        
        // SECTION 5: Polymorphism
        System.out.println("\n5. POLYMORPHISM");
        System.out.println("-".repeat(80));
        Animal_Poly[] animals = new Animal_Poly[2];
        animals[0] = new Dog_Poly();
        animals[0].name = "Rex";
        
        animals[1] = new Cat_Poly();
        animals[1].name = "Whiskers";
        
        for (Animal_Poly animal : animals) {
            animal.makeSound();  // Each calls its own version
        }
        
        // SECTION 6: Method Overloading
        System.out.println("\n6. METHOD OVERLOADING");
        System.out.println("-".repeat(80));
        Calculator calc = new Calculator();
        System.out.println("add(5, 3) = " + calc.add(5, 3));
        System.out.println("add(5.5, 3.2) = " + calc.add(5.5, 3.2));
        System.out.println("add(5, 3, 2) = " + calc.add(5, 3, 2));
        
        // SECTION 7: Static Variables
        System.out.println("\n7. STATIC VARIABLES");
        System.out.println("-".repeat(80));
        BankAccount_Static acc1 = new BankAccount_Static("John", 1000);
        BankAccount_Static acc2 = new BankAccount_Static("Jane", 2000);
        System.out.println("Total accounts: " + BankAccount_Static.totalAccounts);
        System.out.println("Interest rate: " + BankAccount_Static.interestRate);
        
        // SECTION 8: Static Methods
        System.out.println("\n8. STATIC METHODS");
        System.out.println("-".repeat(80));
        System.out.println("StringUtils.isEmpty(\"\") = " + StringUtils.isEmpty(""));
        System.out.println("StringUtils.capitalize(\"hello\") = " + StringUtils.capitalize("hello"));
        System.out.println("StringUtils.reverse(\"hello\") = " + StringUtils.reverse("hello"));
        
        // SECTION 9: This keyword
        System.out.println("\n9. THIS KEYWORD");
        System.out.println("-".repeat(80));
        Person_This person = new Person_This("Alice", 25);
        System.out.println("Person: " + person.name + ", Age: " + person.age);
        
        // SECTION 10: Composition
        System.out.println("\n10. COMPOSITION (HAS-A)");
        System.out.println("-".repeat(80));
        Car_Composition mycar = new Car_Composition();
        mycar.drive();
        
        // SECTION 11: Abstract Classes
        System.out.println("\n11. ABSTRACT CLASSES");
        System.out.println("-".repeat(80));
        Animal_Parent dog_abs = new Dog_Child("Max", 4);
        dog_abs.makeSound();
        dog_abs.sleep();
        
        // SECTION 12: Interfaces
        System.out.println("\n12. INTERFACES");
        System.out.println("-".repeat(80));
        Drawable circle = new Circle(5);
        circle.draw();
        circle.erase();
        
        // SECTION 13: Final Variables
        System.out.println("\n13. FINAL KEYWORD");
        System.out.println("-".repeat(80));
        System.out.println("PI = " + MathConstants.PI);
        System.out.println("E = " + MathConstants.E);
        
        // SECTION 14: Interfaces in Practice (Payment)
        System.out.println("\n14. INTERFACES IN PRACTICE - PAYMENTS");
        System.out.println("-".repeat(80));
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(50);
        cart.addItem(49.99);
        
        PaymentMethod card = new CreditCard("1234-5678-9012-3456", 200);
        cart.checkout(card);
        
        // SECTION 15: Real-world example - University System
        System.out.println("\n15. REAL-WORLD SYSTEM - UNIVERSITY");
        System.out.println("-".repeat(80));
        Student_System student1 = new Student_System("S001", "Alice Johnson", "alice@uni.edu");
        Professor_System prof1 = new Professor_System("P001", "Dr. Smith", "Computer Science");
        Course_System course1 = new Course_System("CS101", "Intro to Java", prof1, 30);
        Assignment_System assignment1 = new Assignment_System("A001", "Hello World", 100);
        
        System.out.println("Student: " + student1.getName());
        System.out.println("Professor: " + prof1.getName());
        System.out.println("Course: " + course1.getCourseName());
        
        student1.updateGPA(3.8);
        System.out.println("Student GPA: " + student1.getGPA());
        
        assignment1.setScore(95);
        System.out.println("Assignment Score: " + assignment1.getPercentage() + "%");
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ALL OOP CONCEPTS DEMONSTRATED SUCCESSFULLY!");
        System.out.println("=".repeat(80));
    }
}
