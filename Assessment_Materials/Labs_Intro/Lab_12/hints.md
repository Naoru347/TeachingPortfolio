# Hints for Students
As you give out hints, update teacher_hint_log.xlsx to track num hints provided to each student for the diminishing bonus. If a script is incomplete, mark with '0'. 

## **Hints for Debugging: `basic_calculator.py`**

---

#### **1. Syntax Error:**
- **Hint:** "Check the syntax in your `if` statement. Did you forget something at the end?"
- **Details:** Syntax errors occur when the structure of the code doesn't follow Python's rules. Missing a colon (`:`) at the end of an `if` statement is a common mistake.

#### **2. Logic Error:**
- **Hint:** "What happens if `num2` is zero during division? Consider adding a condition to handle this case."
- **Details:** Dividing by zero will cause the program to crash with a `ZeroDivisionError`. A condition should be added to check if `num2` is zero before performing the division.

#### **3. Runtime Error:**
- **Hint:** "There's a typo in the function name used to get input. Double-check it against Python's built-in functions."
- **Details:** The function `imput` does not exist in Python. It should be corrected to `input` to fix this runtime error.

---

## **Hints for Debugging: `grade_calculator.py`**

---

#### **1. Logical Error:**
- **Hint:** "Are you sure you’re adding numbers together correctly? Check the data type of `grade` before adding it to `total`."
- **Details:** The script tries to add a string (e.g., `"85"`) to `total` instead of converting it to an integer. Fix this by wrapping `grade` in `int()`.

#### **2. Runtime Error:**
- **Hint:** "What if someone enters letters instead of numbers? Wrap your code in a `try/except` block to handle this gracefully."
- **Details:** Non-numeric input will cause a `ValueError` when converting to an integer. Use `try/except` to catch this error and prompt the user to re-enter valid input.

#### **3. Edge Case Bug:**
- **Hint:** "What happens if the user provides no input? Check the length of `grades` before calculating the average."
- **Details:** If the user doesn’t provide input, the `grades` list will be empty, and dividing by zero will raise an error. Add a condition to check if the list is empty before calculating the average.

---

## **Hints for Debugging: `password_validator.py`**

---

#### **1. Logic Error:**
- **Hint:** "Are you sure the conditions for a valid password are being combined correctly? Should the password meet all conditions or just one?"
- **Details:** The script incorrectly validates the password as valid if any one condition is true. Use logical operators (`and`) to ensure all conditions are satisfied.

#### **2. Runtime Error:**
- **Hint:** "What happens if the user enters an empty password? Check how the code handles this case."
- **Details:** Calling `index("")` on an empty string causes a runtime error. Add a condition to check if the input is empty before performing validations.

#### **3. Edge Case Bug:**
- **Hint:** "Does the program correctly handle passwords with special characters like `@` or `!`? Test these scenarios."
- **Details:** The script doesn’t validate special characters properly. Update the logic to ensure special characters don’t bypass the number-checking rule.

---

## **Hints for Debugging: `password_validator.py`**

---

#### **1. Logic Error:**
- **Hint:** "Are you sure the conditions for a valid password are being combined correctly? Should the password meet all conditions or just one?"
- **Details:** The script incorrectly validates the password as valid if any one condition is true. Use logical operators (`and`) to ensure all conditions are satisfied.

#### **2. Runtime Error:**
- **Hint:** "What happens if the user enters an empty password? Check how the code handles this case."
- **Details:** Calling `index("")` on an empty string causes a runtime error. Add a condition to check if the input is empty before performing validations.

#### **3. Edge Case Bug:**
- **Hint:** "Does the program correctly handle passwords with special characters like `@` or `!`? Test these scenarios."
- **Details:** The script doesn’t validate special characters properly. Update the logic to ensure special characters don’t bypass the number-checking rule.

---
