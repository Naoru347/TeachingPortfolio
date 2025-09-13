# **Lab 7: Grade Tracker**

---

## **Objectives**
1. Learn to create, manipulate, and iterate through lists in Python.
2. Apply slicing techniques to extract subsets of data.
3. Write reusable functions to perform calculations on list data.
4. Practice identifying patterns and insights in numerical data.
5. Develop critical skills for using AI tools effectively for debugging and conceptual understanding.

---

## **Scenario**
You are tracking your grades for a series of assignments in your programming course. Your goal is to analyze your grades, calculate averages, and determine if you're on track to meet your academic goals.

You will write a program that helps manage a list of grades, calculate important statistics, and identify performance trends.

---

## **Instructions**

### **Core Requirements**

#### **Step 1: Setup**
1. Create a Python file named `grade_tracker.py`.
2. Start your program by defining a list of five grades (e.g., `[85, 90, 78, 92, 88]`).
3. Print the list of grades and calculate the **average grade** using a loop or the `sum()` function.

---

#### **Step 2: Manipulating Grades**
Perform the following operations on the list of grades:
1. Add a new grade for an extra credit assignment using `.append()`.
2. Use `.remove()` to drop the **lowest grade** in the list.
3. Use slicing to create a sublist of the **top 3 grades**.

For each operation, print the updated list and explain the result in a comment.

---

#### **Step 3: Analyze Grades**
Perform the following tasks:
1. Iterate through the list and print whether each grade is **Pass** or **Fail** (assume 70 is the passing threshold).
2. Write a function `grade_summary(grades)` that:
   - Returns the **highest grade**.
   - Returns the **lowest grade**.
   - Calculates the **average grade**.
3. Print the results of the `grade_summary()` function.

---

#### **Step 4: User Interaction**
1. Allow the user to input a grade to add to the list.
   - Prompt the user to enter a grade.
   - Append the grade to the list and print the updated list.
2. Write a function `check_grade(grade)` that:
   - Checks if a grade exists in the list.
   - Prints a message stating whether the grade is found.

---

### **Stretch Challenges** *(Optional)*

1. **Predict Final Grades**: Assume the user has two more assignments left. Write a function `predict_average(grades, future_grades)` that:
   - Takes the current grades and two predicted future grades as input.
   - Calculates and returns the average grade including the future grades.
2. **Grade Curve**: Add 5 points to each grade (but cap it at 100). Use a loop or list comprehension.

---

## **Guidance on Using AI Tools Effectively**

### **Best Practices for Critical AI Use**
1. **Conceptual Understanding**:
   - Use AI tools to clarify concepts you don’t fully understand.
   - Example prompts to ask:
     - "How do I calculate the average of a list in Python?"
     - "What’s the best way to remove the lowest value from a list?"

2. **Debugging**:
   - Paste your code and error messages to AI tools and ask for help understanding the problem.
   - Example prompts:
     - "Why isn’t my function returning the correct value?"
     - "How can I fix this error: `<insert error message>`?"

3. **Code Review**:
   - Share your code and ask for feedback on structure or readability.
   - Example prompts:
     - "Does my function look efficient?"
     - "How can I simplify this code?"

### **Critical Reflection**
- For every suggestion made by an AI tool, ask yourself:
  - Does this solve my problem effectively?
  - Do I understand why this solution works?
  - How could this solution be improved or customized for my program?
- Document all AI interactions in your lab report, including:
  - The specific questions you asked.
  - How you used the answers to improve your code.
  - Any parts of the suggestions you modified or rejected, and why.

---

## **Submission Instructions**
1. Save your program as `grade_tracker.py`.
2. Submit the following to GitHub Classroom:
   - The Python script.
   - A 1-2 page lab report detailing your approach, challenges, and how you used generative AI (if applicable).

---

## **Hints**
1. Use Python’s `max()` and `min()` functions for the highest and lowest grades.
2. Use slicing to extract the top 3 grades:
   ```python
   top_grades = sorted(grades, reverse=True)[:3]
   ```
3. Use `input()` to interact with the user:
   ```python
   new_grade = int(input("Enter a new grade: "))
   grades.append(new_grade)
   ```
4. For error handling, consider invalid user input (e.g., non-numeric grades).

---
