# **Lab 2: Basic Calculations Program**

## **Objectives**
1. Work with variables and basic data types.
2. Perform arithmetic and string operations.
3. Learn to handle errors using basic exception handling.

---

## **Instructions**

### **Part 1: Setting Up Your Environment**
1. Open your programming environment (VS Code or your preferred IDE).
2. Create a new Python file named `basic_calculations.py`.

---

### **Part 2: Program Requirements**

#### **Task 1: Basic Arithmetic Operations**
1. Prompt the user to enter two numbers.
    - Use the `input()` function to accept user input and `float()` to convert the input to a numeric data type.
      ```python
      num1 = float(input("Enter the first number: "))
      num2 = float(input("Enter the second number: "))
      ```
2. Perform the following operations:
    - Addition
    - Subtraction
    - Multiplication
    - Division
3. Print the results clearly, for example:
    ```
    The sum of 5 and 3 is 8.
    The difference between 5 and 3 is 2.
    The product of 5 and 3 is 15.
    The quotient of 5 and 3 is 1.67.
    ```

#### **Task 2: String Operations**
1. Prompt the user to enter two strings.
    - Example:
      ```python
      str1 = input("Enter the first string: ")
      str2 = input("Enter the second string: ")
      ```
2. Concatenate the two strings and display the result:
    ```
    Concatenated string: HelloWorld
    ```
3. Print the length of each string individually.
    ```
    Length of first string: 5
    Length of second string: 5
    ```

#### **Task 3: Error Handling for Division by Zero**
1. Add error handling to ensure the program doesn’t crash when attempting division by zero:
    - Use a `try...except` block:
      ```python
      try:
          division_result = num1 / num2
          print(f"The quotient of {num1} and {num2} is {division_result}")
      except ZeroDivisionError:
          print("Error: Division by zero is not allowed.")
      ```

---

### **Part 3: Code Formatting and Documentation**
1. Include comments in your code to explain what each section does.
    - Example:
      ```python
      # Prompt the user for two numbers
      num1 = float(input("Enter the first number: "))
      ```
2. Use meaningful variable names that describe their purpose.

---

### **Part 4: Testing Your Program**
1. Test your program with the following scenarios:
    - Two positive numbers (e.g., 5 and 3).
    - A positive and a negative number (e.g., 7 and -2).
    - Division by zero (e.g., 4 and 0).
    - Two strings of varying lengths (e.g., "Hello" and "World").

---

### **Part 5: Submitting Your Work**
1. Save your completed Python script as `basic_calculations.py`.
2. Submit your script to the GitHub Classroom repository for this lab.

---

### **Lab Report Reminder**
After completing the lab, write a 1-page lab report using the provided template. Be sure to:
- Summarize what you accomplished.
- Highlight challenges and how you resolved them.
- Explain how this knowledge might be useful in your midterm or final project.

Lab reports should also be submitted to the GitHub Classroom repository as `lab2_report.md`.
