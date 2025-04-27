# **Lab 6: Customized Quiz Generator**

---

## **Objectives**
1. Use variable scope effectively in a Python program.
2. Modularize code into multiple reusable functions.
3. Understand how functions interact and share data.
4. Learn to use generative AI tools (e.g., ChatGPT) as a resource for debugging and conceptual understanding.

---

## **Scenario**
You’re building a **Quiz Generator** to help yourself and your classmates review course concepts. The program will present a series of questions from different categories (e.g., Python basics, programming logic, or general knowledge). It will keep track of the score, provide immediate feedback, and allow users to retake the quiz or select a different category.

---

## **Instructions**

### **Core Requirements**
1. **Define Reusable Functions**:
   - Create a function `get_questions(category)` to return a list of questions and answers for the selected category.
   - Write a function `ask_question(question, answer)` to:
     - Display a question to the user.
     - Collect and validate their answer.
     - Return whether the answer was correct.
   - Create a function `calculate_score(correct_answers, total_questions)` to calculate and display the user’s score.

2. **Build the Menu System**:
   - Present users with a menu of categories (e.g., Python Basics, Programming Logic, General Knowledge).
   - Allow them to:
     1. Select a category and start the quiz.
     2. View their score.
     3. Exit the program.

3. **Track User Performance**:
   - Use a global variable to track the score across quiz attempts.
   - Use local variables for individual question-answer pairs and temporary scores.

4. **Error Handling**:
   - Ensure the program handles invalid menu options gracefully.
   - Validate user input to avoid crashes (e.g., entering non-numeric values).

---

### **Stretch Challenges** *(Optional)*
1. Add a "timed quiz" mode that limits the time allowed for each question.
2. Allow the user to add their own questions to the quiz dynamically and save them to a file.

---

## **Guidance on Using Generative AI Tools**
You are encouraged to use tools like ChatGPT, but you **must not** use them to write the code for you. Instead, use AI tools to:
1. **Understand Concepts**:
   - Ask the AI questions like:
     - "What’s the difference between local and global variables in Python?"
     - "How do functions share data in Python?"
2. **Debug Issues**:
   - Paste your code and ask:
     - "Why isn’t my function returning the correct value?"
     - "What steps do I need to take to understand this error: `<insert error message>`?"
3. **Review Code Logic**:
   - Share your plan or pseudocode and ask:
     - "Does this look like a good approach to build a quiz program?"
     - "How can I make this function more modular or reusable?"

> **Important**: Document how you used AI tools in your lab report (see the lab report template).

---

## **Submission Instructions**
1. Save your program as `lab_6.py`.
2. Submit the following to GitHub Classroom under the `Lab6` folder:
   - The Python script.
   - A 1-2 page lab report detailing your approach, challenges, and how you used generative AI (if applicable).

---

## **Hints**
1. Use dictionaries to store questions and answers for each category. Example:
   ```python
   questions = {
       "Python Basics": [
           {"question": "What does `print()` do?", "answer": "prints output"},
           {"question": "What data type is `42`?", "answer": "integer"}
       ],
       "General Knowledge": [
           {"question": "What is the capital of France?", "answer": "Paris"}
       ]
   }
