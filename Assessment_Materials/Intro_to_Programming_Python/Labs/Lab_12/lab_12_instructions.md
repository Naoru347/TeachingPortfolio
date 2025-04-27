# **Lab 12: Debugging Treasure Hunt**

---

## **Objectives**
1. Identify and resolve syntax, runtime, and logical errors in Python code.
2. Learn and apply debugging techniques to analyze and fix broken code.
3. Practice using error messages, print statements, and `try/except` blocks to debug effectively.
4. Gain confidence in debugging through an engaging and competitive activity.

### **AI-use & Peer Collaboration Note**
As this lab includes a bonus challenges, the use of any and all AI tools and/or peer collaboration is expressly forbidden. Violating this restriction will result in the negation of any and all bonus points for the offending student and an immediate zero score for this lab.

---

## **Scenario**
You are a junior developer working on a team, and your task is to debug several broken scripts. Each script has a few intentional errors (syntax, runtime, or logic). Your job is to:
1. Identify the errors.
2. Fix the code.
3. Write a brief explanation of the error and how you resolved it.
4. *Before* moving on to the next script in the challenge, come notify me that you've finished work on your current file so that I can update the bonus board. 

To make things fun, you can earn **bonus points** for each bug you find and fix correctly. However, the bonus diminishes as you make use of supports (read: hints), so work efficiently!

---

## **Instructions**

### **Part 1: Debug the Scripts**
1. **Start with the First Script:**
   - Download the provided folder containing multiple buggy scripts.
   - Open the first script and run it to identify any errors.

2. **Identify the Error:**
   - Use error messages and debugging techniques to pinpoint the problem.
   - Write a brief explanation of the issue in your lab report.

3. **Fix the Code:**
   - Correct the identified bug.
   - Test the code to ensure it works as intended.

4. **Move to the Next Script:**
   - Repeat the process for each script in the folder.
   - Notify me *before* moving on to the next script in the challenge.

**Special Note:** If you're stuck, come talk to me for a hint, with a ding of 1 point per hint, max 3 hints per script.

---

### **Part 2: Write a Debugging Log**
For each script you debug, document the following in your lab report:
1. **File Name:** The name of the script.
2. **Error Description:** A brief description of the error.
3. **Fix:** A clear explanation of how you fixed the issue.
4. **Testing:** A description of how you tested the fixed code.

---

### **Part 3: Bonus Challenge - Diminishing Bonus Points**
Earn bonus points by identifying, describing, and fixing bugs correctly. Points diminish based on the number of hints you use or the time taken to complete the lab.

**Bonus Point System:**
- **Full Bonus:** Earn **2 points** per bug if you:
  - Identify and fix it without hints.
  - Provide a clear and accurate description in your debugging log.
- **Partial Bonus:** Earn **1 point** per bug if you:
  - Use a hint to identify or fix the bug.
  - Still provide a clear description in your debugging log.

> **Note:** Bonus points are capped at **10 points per student**.

---

## **Setup**
1. **Download the Debugging Scripts Folder:**
   - The folder contains 5 scripts, each with 2-3 intentional errors.
   - Errors include syntax issues (e.g., missing colons), runtime exceptions (e.g., division by zero), and logical flaws (e.g., incorrect loop conditions).
2. **Use Any Debugging Tools You Prefer:**
   - Python error messages.
   - Print statements.
   - Debugging tools in your IDE (e.g., PyCharm, VS Code).

---

## **Submission Instructions**
1. Submit the following files to your GitHub Classroom repo:
   - **Corrected Scripts:** Each script after fixing the errors.
   - **Debugging Log:** A single document that describes the errors, fixes, and testing process for each script.

2. Ensure your debugging log is well-organized and clearly formatted.

---

## **Hints and Tips**
1. **Start Simple:** Fix syntax errors first, as they prevent the script from running.
2. **Read the Error Messages Carefully:** Python’s error messages often tell you exactly where the problem is.
3. **Use Print Statements:** Print intermediate values to see where your logic might be going wrong.
4. **Try/Except Blocks:** Add `try/except` blocks to handle runtime errors and prevent the program from crashing.
5. **Work Systematically:** Focus on one bug at a time rather than trying to fix everything at once.

---

## **Example Debugging Log Entry**
### **File Name:** `calculator.py`
- **Error Description:** Syntax error on line 5 due to a missing colon in the `if` statement.
- **Fix:** Added the missing colon at the end of the `if` statement.
- **Testing:** Entered several test cases for the calculator to ensure the `if` condition executes correctly.
  - Test case: `2 + 2` → Output: `4`
  - Test case: `5 / 0` → Handled with an exception message.

---

## **Grading Criteria**
| **Category**             | **Weight** |
|--------------------------|------------|
| **Debugging Accuracy**   | 55%        |
| **Clarity of Fixes**     | 25%        |
| **Testing Thoroughness** | 20%        |

---

Good luck on your Debugging Treasure Hunt! Remember, debugging is not just about fixing problems—it’s about understanding how your code works and learning from the process.
