# **Lab 4: Guessing Game with Iteration (Java Edition)**

---

## **Objectives**
1. Use loops to manage repetitive tasks.
2. Apply conditional logic to provide feedback based on user input.
3. Combine randomness and iteration for interactive gameplay.

---

## **Instructions**

### **Part 1: Setting Up the Game**
1. **Import Random Number Generation:**
   - Use Java’s `java.util.Random` class to generate a random number.
   - Generate a random integer between 1 and 100:
     ```java
     Random rand = new Random();
     int secretNumber = rand.nextInt(100) + 1; // [1, 100]
     ```

2. **Display Welcome Message:**
   - Print:
     ```
     Welcome to the Guessing Game! I have chosen a number between 1 and 100. Try to guess it!
     ```

3. **Initialize Game Variables:**
   - Track the number of attempts using an `int` variable (e.g., `attempts = 0`).

---

### **Part 2: Game Logic**
1. **Use a `while` Loop:**
   - Create a loop that continues until the user guesses the correct number.
   - Prompt the user to enter their guess using a `Scanner`:
     ```java
     System.out.print("Enter your guess: ");
     int guess = scanner.nextInt();
     ```

2. **Provide Feedback:**
   - Compare the guess to the secret number and print:
     - `"Too high! Try again."` if the guess is too high
     - `"Too low! Try again."` if the guess is too low
     - `"Congratulations! You guessed the number in X attempts!"` if correct
   - Break the loop if the guess is correct.
   - Increment the attempt counter each time.

---

### **Part 3: Play Again (Stretch Challenge)**
1. **Ask to Play Again:**
   - After the user wins, ask:
     ```
     Would you like to play again? (Y/N)
     ```
   - If the input is `Y` (case-insensitive), reset the game:
     - Generate a new random number
     - Reset the attempt counter
   - If the input is `N`, print:
     ```
     Thanks for playing! See you next time!
     ```
   - Validate input using a loop until a valid `Y` or `N` is entered.

---

## **Code Style and Documentation**
- Add meaningful comments to explain your logic.
- Ensure good formatting with clear indentation and spacing.

---

## **Submission**
1. Save your file as `Lab4.java`.
2. Push your `.java` file to GitHub Classroom under the `Lab4` folder in your repository.

---

## **Hints**
- Try edge cases like guessing 1, 100, or numbers out of range.
- Consider adding error handling using `try-catch` to prevent crashes on invalid input.

---

## **Lab Report Reminder**
Don’t forget to write your 1–2 page lab report using the provided template. Reflect on how this lab connects to skills needed for the **Midterm** or **Final Project**.