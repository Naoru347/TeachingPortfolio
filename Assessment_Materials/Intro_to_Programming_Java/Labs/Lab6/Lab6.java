import java.util.*;

/**
 * Lab6.java
 * Starter code for Lab 6: Customized Quiz Generator
 */

public class Lab6 {
    // Global variable for tracking score (optional)
    static int totalCorrectAnswers = 0;
    static int totalQuestions = 0;

    // Method to retrieve questions for a given category
    public static List<Map<String, String>> getQuestions(String category) {
        // TODO: Return a list of question/answer pairs for the selected category
        // You can use a List of Maps, or create a custom Question class if preferred
        return new ArrayList<>();
    }

    // Method to ask a single question and return whether the answer is correct
    public static boolean askQuestion(String question, String answer, Scanner scanner) {
        // TODO: Display the question
        // TODO: Get user input and compare it to the answer (case-insensitive)
        return false;
    }

    // Method to calculate and display the user's score
    public static void calculateScore(int correctAnswers, int totalQuestions) {
        // TODO: Calculate percentage and print it
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Print welcome message and present category menu

        // TODO: Implement menu system
        // Options:
        // 1. Choose category and start quiz
        // 2. View score
        // 3. Exit program

        // TEMPORARY
        // DELETE THIS LINE WHEN LAB IS COMPLETE
        System.out.println("Finish the TODOs to complete Lab 6!");

        scanner.close();
    }
}