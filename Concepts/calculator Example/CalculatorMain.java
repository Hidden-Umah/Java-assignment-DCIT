import java.util.Scanner;

// Calculator class handles all operations
class Calculator {
    private double result; // Stores last calculation result

    // Add two numbers
    public double add(double a, double b) {
        result = a + b;
        return result;
    }

    // Subtract second number from first
    public double subtract(double a, double b) {
        result = a - b;
        return result;
    }

    // Multiply two numbers
    public double multiply(double a, double b) {
        result = a * b;
        return result;
    }

    // Divide first number by second
    public double divide(double a, double b) {
        if (b != 0) {
            result = a / b;
            return result;
        } else {
            System.out.println("Error: Division by zero");
            return 0;
        }
    }

    // Return last result
    public double getResult() {
        return result;
    }
}

// Main class with menu-driven calculator
public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator(); // Create Calculator object

        boolean running = true;
        while (running) {
            // Display menu
            System.out.println("\n--- Simple Calculator ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Last Result");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            double a, b;

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    a = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    b = scanner.nextDouble();
                    System.out.println("Result: " + calc.add(a, b));
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    a = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    b = scanner.nextDouble();
                    System.out.println("Result: " + calc.subtract(a, b));
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    a = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    b = scanner.nextDouble();
                    System.out.println("Result: " + calc.multiply(a, b));
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    a = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    b = scanner.nextDouble();
                    System.out.println("Result: " + calc.divide(a, b));
                    break;
                case 5:
                    System.out.println("Last Result: " + calc.getResult());
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting Calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
