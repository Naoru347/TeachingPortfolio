# **Lab 12: Debugging Treasure Hunt (Java Edition)**

---

## **Objectives**
1. Identify and resolve syntax, runtime, and logical errors in Java code.
2. Apply debugging techniques including print statements and `try-catch` blocks.
3. Practice systematic problem-solving through a fun and competitive lab activity.
4. Build confidence in debugging Java programs.

### **AI-use & Peer Collaboration Note**
The use of **any AI tools** or **peer collaboration** during this lab is **strictly prohibited**. Violation will result in **zero points** for this lab and disqualification from **any bonus point eligibility**.

---

## **Scenario**
You are a junior Java developer and have been assigned to fix broken Java programs written by another developer. Each file contains multiple bugs (e.g., missing semicolons, `NullPointerException`s, incorrect conditionals, etc.).

Your tasks:
1. Identify the bug(s).
2. Fix the code.
3. Write a short explanation of what was wrong and how you fixed it.
4. Before proceeding to the next script, notify the instructor to be eligible for bonus tracking.

Earn **bonus points** for finding and fixing bugs quickly and correctly. 

---

## **Instructions**

### **Part 1: Debug the Scripts**
1. **Start with the First File:**
   - Download the folder containing the 5 buggy `.java` files.
   - Open the first file in your IDE (VS Code, IntelliJ, Eclipse, etc.).
   - Attempt to compile and run the file.

2. **Identify the Error:**
   - Use compiler messages and logical reasoning to locate the problem.
   - Document the issue in your debugging log.

3. **Fix the Code:**
   - Correct the issue and test the program.

4. **Proceed to the Next Script:**
   - Only after showing your fixed code to the instructor.

**Note:** You may ask for up to 3 hints per script. Each hint costs 1 point from the potential bonus.

---

### **Part 2: Debugging Log**
For each script, write the following in your debugging log:
- **File Name:**
- **Error Description:**
- **Fix:**
- **Testing Performed:**

Example:
```markdown
### File Name: Calculator.java
- Error Description: Missing semicolon at the end of a return statement.
- Fix: Added the missing semicolon.
- Testing Performed: Ran 3 sample test cases to verify addition, subtraction, and division.
```

---

### **Part 3: Bonus Points - Diminishing Returns**
Earn up to **10 bonus points** by finding and fixing bugs without hints.

| Condition                 | Points per bug |
|--------------------------|----------------|
| No hints used            | 2              |
| 1-3 hints used (max)     | 1              |

---

## **Setup**
1. **Download the Debugging Folder:**
   - Contains 5 Java files (e.g., `Calculator.java`, `GradeTracker.java`, etc.).
   - Each has 2-3 intentional bugs.

2. **Use IDE Features:**
   - Compiler errors.
   - Stack traces.
   - Print debugging.
   - `try-catch` for exception handling.

---

## **Submission Instructions**
Submit the following to your GitHub Classroom repository:
1. **Fixed Java Files:** All corrected `.java` files.
2. **Debugging Log:** A Markdown or PDF file documenting your work.

---

## **Hints and Tips**
- Fix **syntax errors** first so the program can compile.
- Use `System.out.println()` to print variable values and trace program flow.
- Read Java exceptions and stack traces carefully to find runtime issues.
- Think through the logic to fix conditionals, loops, and calculations.
- Fix **one bug at a time**. Compile and test after each fix.

---

## **Example Debugging Log Entry**
```markdown
### File Name: StudentScores.java
- Error Description: ArrayIndexOutOfBoundsException due to incorrect loop condition.
- Fix: Changed loop condition from `i <= scores.length` to `i < scores.length`.
- Testing: Ran test cases with 5 student scores. No crash and correct average displayed.
```

---

## **Grading Criteria**
| **Category**             | **Weight** |
|--------------------------|------------|
| **Debugging Accuracy**   | 55%        |
| **Clarity of Fixes**     | 25%        |
| **Testing Thoroughness** | 20%        |

---

Good luck with your Debugging Treasure Hunt! The better you get at debugging, the more effective a developer you become. Keep calm and squash those bugs!