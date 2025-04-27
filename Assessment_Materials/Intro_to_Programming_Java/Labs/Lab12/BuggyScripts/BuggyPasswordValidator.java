import java.util.Scanner;

public class BuggyPasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a password to validate: ");
        String password = scanner.nextLine();

        // BUG #1: Only prints message, does not actually stop validation on short password
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
        }

        // BUG #2: Prints "must contain" even if the requirement is met (should print only if missing)
        if (containsUppercase(password)) {
            System.out.println("Password must contain at least one uppercase letter.");
        }

        if (containsDigit(password)) {
            System.out.println("Password must contain at least one number.");
        }

        // BUG #3: Faulty logic in final validation (invalid use of indexOf with empty string)
        if (password.indexOf("") != -1) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Password is invalid.");
        }
    }

    // Helper method to check for uppercase
    public static boolean containsUppercase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check for digits
    public static boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
