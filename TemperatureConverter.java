import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Display the menu with options
        System.out.println("Temperature Converter");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");
        System.out.print("Please select an option (1 or 2): ");

        // Read the user's choice
        int choice = getValidChoice(scanner);

        // Process based on the user's choice
        if (choice == 1) {
            // Celsius to Fahrenheit
            System.out.print("Enter temperature in Celsius: ");
            double celsius = getValidTemperature(scanner);
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("%.2f Celsius is %.2f Fahrenheit.%n", celsius, fahrenheit);
        } else if (choice == 2) {
            // Fahrenheit to Celsius
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = getValidTemperature(scanner);
            double celsius = fahrenheitToCelsius(fahrenheit);
            System.out.printf("%.2f Fahrenheit is %.2f Celsius.%n", fahrenheit, celsius);
        }

        // Close the scanner
        scanner.close();
    }

    // Method to get a valid choice (1 or 2) from the user
    public static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            // Validate input to ensure it's 1 or 2
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    break; // Valid choice
                } else {
                    System.out.print("Invalid choice. Please enter 1 or 2: ");
                }
            } else {
                System.out.print("Invalid input. Please enter 1 or 2: ");
                scanner.next(); // Clear invalid input
            }
        }
        return choice;
    }

    // Method to get a valid temperature input (numeric value)
    public static double getValidTemperature(Scanner scanner) {
        double temperature;
        while (true) {
            // Validate input to ensure it's a valid double
            if (scanner.hasNextDouble()) {
                temperature = scanner.nextDouble();
                break; // Valid temperature input
            } else {
                System.out.print("Invalid input. Please enter a valid temperature: ");
                scanner.next(); // Clear invalid input
            }
        }
        return temperature;
    }

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
