import java.util.Random;
import java.util.Scanner;

/**
 * Lab 4: Guessing Game Starter Code
 */
public class Lab4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // TODO: Generate a random number between 1 and 100
        int secretNumber = rand.nextInt(100) + 1;

        // TODO: Print a welcome message explaining the rules
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

        // TODO: Initialize the number of attempts
        int attempts = 0;

        // TODO: Implement the game loop
        // Hint: Use a while loop to keep asking the user for guesses
        boolean gameRunning = true;

        while (gameRunning) {
            // TODO: Prompt the user to guess the number
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            // TODO: Increment the attempts counter
            attempts++;

            // TODO: Compare the guess to the secret number
            // TODO: Provide feedback if the guess is too high, too low, or correct
            if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
                gameRunning = false; // End the game loop
            }

            // TEMPORARY
            // REMOVE OR COMMENT OUT THIS LINE UNTIL YOU COMPLETE THE LAB
            // break;
        }

        // This should always execute unless the function exits earlier
        System.out.println("Finish the TODOs to complete Lab 4. You've got this!");

        // TODO: Ask the user if they want to play again
        // Stretch Challenge: Implement a play-again feature

        scanner.close();
    }
}
