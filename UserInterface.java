import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {

    // Overloaded methods for addition
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Subtraction (int)
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication (double)
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division (int) with exception handling
    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed!");
        }
        return (double) a / b;
    }
}

public class UserInterface {
    private Scanner scanner;
    private Calculator calculator;

    public UserInterface() {
        scanner = new Scanner(System.in);
        calculator = new Calculator();
    }

    public void performAddition() {
        try {
            System.out.print("Enter number of operands (2 or 3): ");
            int count = scanner.nextInt();

            if (count == 2) {
                System.out.print("Enter first number: ");
                double a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b = scanner.nextDouble();
                double result = calculator.add(a, b);
                System.out.println("Result: " + result);

            } else if (count == 3) {
                System.out.print("Enter first number: ");
                int a = scanner.nextInt();
                System.out.print("Enter second number: ");
                int b = scanner.nextInt();
                System.out.print("Enter third number: ");
                int c = scanner.nextInt();
                int result = calculator.add(a, b, c);
                System.out.println("Result: " + result);

            } else {
                System.out.println("Invalid number of operands!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter valid numbers.");
            scanner.nextLine(); 
        }
    }

    public void performSubtraction() {
        try {
            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();
            int result = calculator.subtract(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers.");
            scanner.nextLine();
        }
    }

    public void performMultiplication() {
        try {
            System.out.print("Enter first double: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second double: ");
            double b = scanner.nextDouble();
            double result = calculator.multiply(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter decimal numbers.");
            scanner.nextLine();
        }
    }

    public void performDivision() {
        try {
            System.out.print("Enter numerator (integer): ");
            int a = scanner.nextInt();
            System.out.print("Enter denominator (integer): ");
            int b = scanner.nextInt();

            double result = calculator.divide(a, b);
            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers.");
            scanner.nextLine();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\n=== Welcome to the Calculator Application ===");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> performAddition();
                    case 2 -> performSubtraction();
                    case 3 -> performMultiplication();
                    case 4 -> performDivision();
                    case 5 -> System.out.println("Exiting... Thank you!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid choice.");
                scanner.nextLine();
                choice = 0; 
            }

        } while (choice != 5);
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}
