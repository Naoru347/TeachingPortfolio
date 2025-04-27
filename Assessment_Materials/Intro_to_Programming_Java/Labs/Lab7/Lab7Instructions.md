# **Lab 7: Grade Tracker (Java Edition)**

---

## **Objectives**
1. Learn to create, manipulate, and iterate through arrays and ArrayLists in Java.
2. Apply indexing and sorting to extract subsets of data.
3. Write reusable methods to perform calculations on numerical data.
4. Practice identifying patterns and insights in user performance.
5. Develop critical skills for using AI tools effectively for debugging and conceptual understanding.

---

## **Scenario**
You are tracking your grades for a series of assignments in your programming course. Your goal is to analyze your grades, calculate averages, and determine if you're on track to meet your academic goals.

You will write a program that helps manage a list of grades using an `ArrayList<Integer>`, calculate important statistics, and identify performance trends.

---

## **Instructions**

### **Core Requirements**

#### **Step 1: Setup**
1. Create a Java file named `GradeTracker.java`.
2. In the `main()` method, define an `ArrayList<Integer>` with five grades (e.g., 85, 90, 78, 92, 88).
3. Print the list of grades and calculate the **average grade** using a loop or helper method.

---

#### **Step 2: Manipulating Grades**
Perform the following operations on the list of grades:
1. Add a new grade for an extra credit assignment using `.add()`.
2. Use `Collections.min()` to find and remove the **lowest grade**.
3. Sort the list and extract the **top 3 grades** using `.subList()`.

For each operation, print the updated list and include explanatory comments in your code.

---

#### **Step 3: Analyze Grades**
Perform the following tasks:
1. Iterate through the list and print whether each grade is **Pass** or **Fail** (assume 70 is the passing threshold).
2. Write a method `gradeSummary(List<Integer> grades)` that:
   - Returns the **highest grade**.
   - Returns the **lowest grade**.
   - Calculates and returns the **average grade**.
3. Print the results of the `gradeSummary()` method.

---

#### **Step 4: User Interaction**
1. Prompt the user to input a grade using `Scanner`.
   - Add the grade to the list and print the updated list.
2. Write a method `checkGrade(List<Integer> grades, int grade)` that:
   - Checks if a grade exists in the list.
   - Prints a message stating whether the grade was found.

---

### **Stretch Challenges** *(Optional)*

1. **Predict Final Grades**: Assume the user has two more assignments left. Write a method `predictAverage(List<Integer> grades, int g1, int g2)` that:
   - Takes the current grades and two future grades.
   - Calculates and returns the predicted average.
2. **Grade Curve**: Add 5 points to each grade (but cap it at 100). Use a loop and `.set()`.

---

## **Guidance on Using AI Tools Effectively**

### **Best Practices for Critical AI Use**
1. **Conceptual Understanding**:
   - Use AI tools to clarify concepts you don’t fully understand.
   - Example prompts:
     - "How do I calculate the average of a list in Java?"
     - "How do I remove the lowest value from an ArrayList?"

2. **Debugging**:
   - Paste your code and error messages into AI tools and ask for help.
   - Example prompts:
     - "Why is my method returning the wrong result?"
     - "What’s causing this NullPointerException?"

3. **Code Review**:
   - Ask the AI to review your method and suggest improvements.
   - Example prompts:
     - "How can I make this method more efficient?"
     - "Is there a cleaner way to iterate over my list?"

### **Critical Reflection**
- For every AI suggestion, reflect on:
  - Does this solve my problem effectively?
  - Do I understand how and why it works?
  - Could I modify this to better fit my needs?
- Document all AI interactions in your lab report, including:
  - What you asked.
  - How the response influenced your code.
  - Any modifications you made to improve or customize the suggestion.

---

## **Submission Instructions**
1. Save your program as `GradeTracker.java`.
2. Submit the following to GitHub Classroom:
   - Your Java source file.
   - A 1–2 page lab report that explains your approach, challenges, and use of generative AI (if applicable).

---

## **Hints**
1. Use `Collections.max()` and `Collections.min()` for highest and lowest grades.
2. Sort grades using `Collections.sort()` and access the top grades with `.subList(0, 3)`.
3. Use `Scanner` for user input:
   ```java
   Scanner scanner = new Scanner(System.in);
   int newGrade = scanner.nextInt();
   ```
4. Use `try-catch` blocks to handle invalid input or runtime exceptions.

---