# **Lab 4: Guessing Game with Iteration**

---

## **Objectives**
1. Use loops to manage repetitive tasks.
2. Apply conditional logic to provide feedback based on user input.
3. Combine randomness and iteration for interactive gameplay.

---

## **Instructions**

### **Part 1: Setting Up the Game**
1. **Import the `random` Module:**  
   - Use Python’s built-in `random` module to generate a random number.
   - Generate a random integer between 1 and 100.  
     ```python
     import random
     secret_number = random.randint(1, 100)
     ```
   - Print a welcome message to the user, explaining the rules of the game:  
     > "Welcome to the Guessing Game! I have chosen a number between 1 and 100. Try to guess it!"

2. **Initialize the Game Variables:**  
   - Set up a variable to track the number of attempts the user has made (e.g., `attempts = 0`).

---

### **Part 2: Game Logic**
1. **Set Up the `while` Loop:**  
   - Use a `while` loop to allow the user to guess until they find the correct number.
   - Prompt the user to enter their guess and convert it to an integer:  
     ```python
     guess = int(input("Enter your guess: "))
     ```
   - Increment the attempts counter each time the user guesses.  

2. **Provide Feedback:**  
   - Inside the loop, compare the user’s guess with the secret number:
     - If the guess is too high, print: `"Too high! Try again."`
     - If the guess is too low, print: `"Too low! Try again."`
     - If the guess is correct, print: `"Congratulations! You guessed the number in [attempts] attempts!"`
   - Break the loop when the user guesses correctly.

---

### **Part 3: Play Again (Stretch Challenge)**
1. **Ask the User if They Want to Play Again:**  
   - Once the user guesses correctly, prompt them with:  
     > "Would you like to play again? (Y/N)"
   - If they enter `Y`, reset the game:
     - Generate a new random number.
     - Reset the attempts counter to 0.
   - If they enter `N`, print:  
     > "Thanks for playing! See you next time!"  
   - Use a `while` loop to ensure valid input for this prompt (e.g., only accept `Y` or `N`).

---

## **Code Style and Documentation**
- Add meaningful comments to explain your code, especially for the `while` loop and conditionals.
- Ensure the program is well-structured and readable, with proper indentation and spacing.

---

## **Submission**
1. Save your completed program as `lab_4.py`.  
2. Push your script to GitHub Classroom under the `Lab4` folder in your repository.  

---

## **Hints**
- Test your program with edge cases (e.g., guessing 1, 100, or numbers outside the range).
- Think about how you might handle invalid input (e.g., letters instead of numbers).

---
## **Lab Report Reminder**
Don’t forget to write up your 1-2 page lab report using the provided template. Include reflections on how this skill could be applied to the **Midterm** or **Final Project**. 

