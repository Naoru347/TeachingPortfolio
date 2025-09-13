import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BuggyShoppingCart {
    static Map<String, Double> cart = new HashMap<>();

    // Function to add item
    public static void addItem(String name, double price) {
        cart.put(name, price);
    }

    // Function to remove item
    public static void removeItem(String name) {
        cart.remove(name);  // BUG #1: No check if item exists, can cause silent failure or confusion
    }

    // Function to calculate total with 10% discount
    public static double calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            total += entry.getValue() * 0.9;  // BUG #2: Discount is applied silently without user knowledge
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View total");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter the item name: ");
                String name = scanner.nextLine();
                System.out.print("Enter the item price: ");
                double price = Double.parseDouble(scanner.nextLine());
                addItem(name, price);
            } else if (choice.equals("2")) {
                System.out.print("Enter the item name to remove: ");
                String name = scanner.nextLine();
                removeItem(name);  // BUG #1 again: No validation/feedback if item doesn’t exist
            } else if (choice.equals("3")) {
                if (cart.size() < 0) {  // BUG #3: cart.size() < 0 will never be true, should be == 0
                    System.out.println("Your cart is empty.");
                } else {
                    double total = calculateTotal();
                    System.out.printf("Total price: $%.2f\n", total);
                }
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
