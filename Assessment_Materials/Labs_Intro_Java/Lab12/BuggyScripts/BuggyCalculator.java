import java.util.Scanner;

public class BuggyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Runtime Error: Misspelled 'scanner' as 'scnner'
        System.out.print("Enter the first number: ");
        double num1 = Double.parseDouble(scnner.nextLine());

        System.out.print("Enter the second number: ");
        double num2 = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter an operation (+, -, *, /): ");
        String operation = scanner.nextLine();

        double result;

        // Syntax Error: Missing closing brace for if block
        if (operation.equals("+"))
            result = num1 + num2;
        else if (operation.equals("-")) {
            result = num1 - num2;
        } else if (operation.equals("*")) {
            result = num1 * num2;
        } else if (operation.equals("/")) {
            // Logic Error: No check for division by zero
            result = num1 / num2;
        } else {
            System.out.println("Invalid operation.");
            result = Double.NaN;
        }

        if (!Double.isNaN(result)) {
            System.out.println("The result is: " + result);
        }
    }
}
