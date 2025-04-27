import java.util.*;

public class BuggyLibraryManager {
    static Map<String, Integer> inventory = new HashMap<>();
    static Map<String, Integer> borrowCount = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize book inventory
        inventory.put("Book A", 3);
        inventory.put("Book B", 2);
        inventory.put("Book C", 1);

        // Initialize borrow count
        for (String book : inventory.keySet()) {
            borrowCount.put(book, 0);
        }

        while (true) {
            System.out.println("\nLibrary Manager");
            System.out.println("1. Borrow a book");
            System.out.println("2. View borrow statistics");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter the book name to borrow: ");
                String bookName = scanner.nextLine();
                borrowBook(bookName);
            } else if (choice.equals("2")) {
                displayStatistics();
            } else if (choice.equals("3")) {
                break;
            } else {
                System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    // BUG #1: Updates *every* book's borrow count instead of just the selected one
    public static void borrowBook(String bookName) {
        if (inventory.containsKey(bookName) && inventory.get(bookName) > 0) {
            inventory.put(bookName, inventory.get(bookName) - 1);

            for (String book : borrowCount.keySet()) {
                borrowCount.put(book, borrowCount.get(book) + 1);
            }

            // BUG #2: Incorrect string formatting with '+' instead of using printf
            System.out.println("\nYou have borrowed '" + bookName + "'.");
        } else {
            System.out.println("\nSorry, '" + bookName + "' is not available.");
        }
    }

    // BUG #3: Typo or logic error may lead to incorrect statistics being displayed if borrowCount is wrong
    public static void displayStatistics() {
        System.out.println("\nBorrow Statistics:");
        for (String book : borrowCount.keySet()) {
            int count = borrowCount.get(book);
            System.out.println(book + ": Borrowed " + count + " times");
        }
    }
}
