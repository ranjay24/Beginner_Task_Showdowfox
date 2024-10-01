import java.util.Scanner;

public class AdvanceCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean stop = false;

        while (!stop) {
            System.out.println("=== Advanced Calculator ===");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Scientific Functions");
            System.out.println("3. Conversion Tools");
            System.out.println("4. Quit");
            System.out.print("Select an option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    arithmeticOperations(input);
                    break;
                case 2:
                    scientificFunctions(input);
                    break;
                case 3:
                    conversionTools(input);
                    break;
                case 4:
                    stop = true;
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }

        input.close();
    }

    // Performs basic arithmetic calculations
    private static void arithmeticOperations(Scanner input) {
        System.out.println("=== Arithmetic Operations ===");
        System.out.print("Enter first value: ");
        double value1 = input.nextDouble();
        System.out.print("Enter second value: ");
        double value2 = input.nextDouble();
        System.out.println("Choose operation (+, -, *, /): ");
        char op = input.next().charAt(0);

        double output = 0;
        switch (op) {
            case '+':
                output = value1 + value2;
                break;
            case '-':
                output = value1 - value2;
                break;
            case '*':
                output = value1 * value2;
                break;
            case '/':
                if (value2 != 0) {
                    output = value1 / value2;
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }

        System.out.println("Output: " + output);
    }

    // Provides scientific calculations like square root and power
    private static void scientificFunctions(Scanner input) {
        System.out.println("=== Scientific Functions ===");
        System.out.println("1. Square Root Calculation");
        System.out.println("2. Power Calculation");
        System.out.print("Select a function: ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter a value: ");
                double num = input.nextDouble();
                if (num >= 0) {
                    System.out.println("Square Root: " + Math.sqrt(num));
                } else {
                    System.out.println("Error: Negative number cannot have a real square root.");
                }
                break;
            case 2:
                System.out.print("Enter base value: ");
                double baseVal = input.nextDouble();
                System.out.print("Enter exponent value: ");
                double expVal = input.nextDouble();
                System.out.println("Result: " + Math.pow(baseVal, expVal));
                break;
            default:
                System.out.println("Invalid function.");
        }
    }

    // Performs unit conversions like temperature conversion
    private static void conversionTools(Scanner input) {
        System.out.println("=== Conversion Tools ===");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose a conversion type: ");
        int conversionOption = input.nextInt();

        switch (conversionOption) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                double tempCelsius = input.nextDouble();
                double tempFahrenheit = (tempCelsius * 9 / 5) + 32;
                System.out.println("Temperature in Fahrenheit: " + tempFahrenheit);
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                tempFahrenheit = input.nextDouble();
                tempCelsius = (tempFahrenheit - 32) * 5 / 9;
                System.out.println("Temperature in Celsius: " + tempCelsius);
                break;
            default:
                System.out.println("Invalid conversion type.");
        }
    }
}
