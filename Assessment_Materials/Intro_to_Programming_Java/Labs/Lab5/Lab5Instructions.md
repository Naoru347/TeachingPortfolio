# **Lab 5: Budget Calculator (Java Edition)**

---

## **Objectives**
1. Create and call methods in Java to manage modular code.
2. Work with arrays or array lists and mathematical calculations to solve real-world problems.
3. Practice passing arguments and using return values in methods.

---

## **Instructions**

### **Basic Budget Tracker**
1. Write a Java program that acts as a simple budget tracker.
   - Define methods to:
     - Add an expense to a list (ArrayList).
     - Calculate the total expenses.
     - Calculate the average expense.

2. **Add Expenses**:
   - Prompt the user to enter expenses one at a time using a `Scanner`.
   - Store these expenses in an `ArrayList<Double>`.
   - Allow the user to stop entering expenses when they type a specific keyword (e.g., "done").

3. **Calculate and Display Results**:
   - Call your methods to:
     - Display the total expenses.
     - Display the average expense, rounded to two decimal places using `String.format` or `DecimalFormat`.
   - Format the output for clarity.

---

### **Enhance the Program**
1. Extend the program with additional functionality:
   - Define a method to find and display the highest and lowest expenses from the list.
   - Add input validation to ensure only valid numbers are added as expenses. Use `try-catch` to handle errors.

2. Make the program interactive:
   - Create a simple text-based menu system using a `while` loop that allows the user to:
     - Add expenses
     - View total and average expenses
     - View the highest and lowest expense
     - Exit the program

---

### **Submission**
1. Save your program as `Lab5.java`.
2. Push your `.java` file to GitHub Classroom under the `Lab5` folder in your repository.

---

## **Hints**
- Think carefully about the parameters each method needs and what it should return.
- Use loops and conditionals to handle repeated operations and menu selection.
- Test your program with both valid and invalid input to ensure it works as expected.

---

## **Stretch Challenge (Optional)**
If you finish early, add categorization:
- Modify the program to allow the user to assign categories (e.g., "food," "transportation") to expenses using a second list or a `Map<String, List<Double>>`.
- Add a feature to calculate and display totals for each category.

---

## **Lab Report Reminder**
Don’t forget to write up your 1–2 page lab report using the provided template. Include reflections on how this skill could be applied to the **Midterm** or **Final Project**.