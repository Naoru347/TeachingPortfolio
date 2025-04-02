# **Lab 6: Customized Quiz Generator (Java Edition)**

---

## **Objectives**
1. Use variable scope effectively in a Java program.
2. Modularize code into multiple reusable methods.
3. Understand how methods interact and share data.
4. Learn to use generative AI tools (e.g., ChatGPT) as a resource for debugging and conceptual understanding.

---

## **Scenario**
You’re building a **Quiz Generator** to help yourself and your classmates review course concepts. The program will present a series of questions from different categories (e.g., Java Basics, Programming Logic, or General Knowledge). It will keep track of the score, provide immediate feedback, and allow users to retake the quiz or select a different category.

---

## **Instructions**

### **Core Requirements**
1. **Define Reusable Methods**:
   - Create a method `getQuestions(String category)` that returns a list of questions and answers for the selected category.
   - Write a method `askQuestion(String question, String answer)` to:
     - Display a question to the user.
     - Collect and validate their answer using `Scanner`.
     - Return whether the answer was correct.
   - Create a method `calculateScore(int correctAnswers, int totalQuestions)` to calculate and display the user’s score.

2. **Build the Menu System**:
   - Present users with a menu of categories (e.g., Java Basics, Programming Logic, General Knowledge).
   - Allow them to:
     1. Select a category and start the quiz.
     2. View their score.
     3. Exit the program.

3. **Track User Performance**:
   - Use a global (static) variable to track the total score across quiz attempts.
   - Use local variables for question-answer pairs and round scores.

4. **Error Handling**:
   - Ensure the program handles invalid menu options gracefully.
   - Validate user input using `try-catch` blocks to prevent crashes.

---

### **Stretch Challenges** *(Optional)*
1. Add a "timed quiz" mode that uses `System.currentTimeMillis()` or `Timer` to limit the time allowed per question.
2. Allow users to add their own questions to the quiz dynamically and save them using file I/O (`FileWriter`, `BufferedWriter`).

---

## **Guidance on Using Generative AI Tools**
You are encouraged to use tools like ChatGPT, but you **must not** use them to write the code for you. Instead, use AI tools to:

1. **Understand Concepts**:
   - Ask the AI questions like:
     - "What’s the difference between local and static variables in Java?"
     - "How do methods share data in Java?"

2. **Debug Issues**:
   - Paste your code and ask:
     - "Why isn’t my method returning the correct value?"
     - "How do I fix this error: `<insert error message>`?"

3. **Review Code Logic**:
   - Share your pseudocode and ask:
     - "Does this look like a good approach for a quiz program?"
     - "How can I refactor this to make it more modular or efficient?"

> **Important**: Document how you used AI tools in your lab report (see the lab report template).

---

## **Submission Instructions**
1. Save your program as `Lab6.java`.
2. Submit the following to GitHub Classroom under the `Lab6` folder:
   - The Java source file.
   - A 1–2 page lab report describing your approach, challenges, and AI tool use (if applicable).

---

## **Hints**
1. Use `HashMap<String, List<Question>>` to store question banks per category.
2. Create a `Question` class to organize question-answer pairs if needed.