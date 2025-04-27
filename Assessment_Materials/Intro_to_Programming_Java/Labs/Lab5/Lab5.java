import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lab 5: Budget Calculator
 * Java Starter Code
 */
public class Lab5 {
    // TODO: Welcome message explaining the purpose of the program

    // TODO: Initialize an ArrayList to store expenses
    static ArrayList<Double> expenses = new ArrayList<>();

    // Method to add an expense to the list
    public static void addExpense(double amount) {
        // TODO: Append the amount to the expenses list
    }

    // Method to calculate total expenses
    public static double calculateTotal() {
        // TODO: Sum all items in the expenses list and return the result
        return 0.0;
    }

    // Method to calculate average expense
    public static double calculateAverage() {
        // TODO: Divide the total by the number of expenses and return the result
        return 0.0;
    }

    // Main method to drive the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Budget Calculator!");

        // TODO: Add a loop to repeatedly prompt the user for input
        // Options:
        // 1. Add an expense
        // 2. View total expenses
        // 3. View average expense
        // 4. Exit the program

        // TODO: Call appropriate methods based on the user's choice
        // Example:
        // if (choice == 1) {
        //     System.out.print("Enter the expense amount: ");
        //     double amount = scanner.nextDouble();
        //     addExpense(amount);
        // }

        // TEMPORARY
        // DELETE THIS LINE WHEN YOU COMPLETE THE LAB
        System.out.println("Finish the TODOs to complete Lab 5!");

        scanner.close();
    }
}