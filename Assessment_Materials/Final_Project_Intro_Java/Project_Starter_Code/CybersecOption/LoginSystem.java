import java.util.HashMap;
import java.util.Scanner;

public class LoginSystem {

    private static HashMap<String, String> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Login System!");

        boolean running = true;
        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine().trim();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public static void register() {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine().trim();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try a different one.");
            return;
        }

        System.out.print("Enter a new password: ");
        String password = scanner.nextLine().trim();

        users.put(username, password);
        System.out.println("Registration successful!");
    }
}
