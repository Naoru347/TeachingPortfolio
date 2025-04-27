# **Lab 1: Environment Setup and First Program**

## **Objectives**
1. Set up your programming environment (Python and Visual Studio Code).
2. Understand basic Python syntax by writing and running your first Python program.
3. Document your process and reflections in a one-page lab report.

---

## **Instructions**

### **Part 1: Setting Up Your Environment**
1. **Install Python:**
   - Download the latest version of Python from [python.org](https://www.python.org/).
   - Follow the installation instructions for your operating system.
   - During installation, ensure you check the box to **"Add Python to PATH"**.
   - After installation, open your terminal or command prompt and type:
     ```bash
     python --version
     ```
     If installed correctly, this will show the Python version number (e.g., `Python 3.x.x`).

2. **Install Visual Studio Code (VS Code):**
   - Download VS Code from [code.visualstudio.com](https://code.visualstudio.com/).
   - Follow the installation instructions for your operating system.
   - Open VS Code and install the Python extension:
     - Go to the Extensions view (`Ctrl+Shift+X` or the square icon on the sidebar).
     - Search for "Python" and install the extension published by Microsoft.

3. **Clone the Starter Repository:**
   - Open GitHub Classroom and accept the invitation link for this lab.
   - Clone the repository to your local machine:
     ```bash
     git clone <repository_url>
     ```
     Replace `<repository_url>` with the link provided in GitHub Classroom.
   - Navigate to the cloned folder:
     ```bash
     cd <folder_name>
     ```
     Replace `<folder_name>` with the name of the repository folder.

4. **Open the Project in VS Code:**
   - Launch VS Code and open the folder you just cloned.
   - Familiarize yourself with the structure of the starter template.

---

### **Part 2: Writing Your First Python Program**
1. **Create a New Python File:**
   - In VS Code, create a new file in your project folder and name it `hello.py`.

2. **Write Your Code:**
   - Type the following code into `hello.py`:
     ```python
     # This program greets the user
     print("Hello, World!")

     # Ask for the user's name
     name = input("What is your name? ")

     # Greet the user with their name
     print(f"Hello, {name}!")
     ```

3. **Save Your File:**
   - Use `Ctrl+S` (Windows/Linux) or `Cmd+S` (Mac) to save your file.

4. **Run Your Program:**
   - Open the integrated terminal in VS Code (`Ctrl+`` or View > Terminal`).
   - Run your program by typing:
     ```bash
     python hello.py
     ```
   - Verify that your program:
     - Prints "Hello, World!" to the terminal.
     - Prompts you to enter your name.
     - Greets you with "Hello, [Your Name]!".

---

### **Part 3: Writing Your Lab Report**
1. **Overview:**
   - You will write a one-page lab report summarizing your experience with this lab.

2. **Report Template:**
   - Use the lab report template provided on the course LMS.
   - Your report should include:
     - **Objective:** What was the purpose of the lab?
     - **Process:** A brief description of how you completed the lab (e.g., setup steps, coding process).
     - **Challenges:** Any difficulties you encountered and how you resolved them.
     - **Reflection:** What you learned from the lab and how it connects to your broader goals in programming.

3. **Format:**
   - Submit the lab report as a PDF or Markdown file to GitHub Classroom along with your script.

---

### **Part 4: Submitting Your Work**
1. **Stage Your Changes:**
   - In the terminal, stage your changes:
     ```bash
     git add hello.py lab_report.md
     ```

2. **Commit Your Changes:**
   - Write a commit message describing your work:
     ```bash
     git commit -m "Completed Lab 1: Hello, World! and Lab Report"
     ```

3. **Push Your Changes:**
   - Push your work to GitHub:
     ```bash
     git push
     ```

4. **Verify Submission:**
   - Log in to GitHub Classroom and ensure your `hello.py` and lab report are visible in the repository.

---

### **Important Notes**
- **AI Usage Policy:**  
  For this lab, AI tools are **NOT** permitted. Completing this setup and program independently is essential to building foundational skills.

- **Help and Support:**  
  If you encounter any issues, refer to:
  - The [Python Documentation](https://docs.python.org/3/).
  - The VS Code Python Extension guide.
  - Post questions in the class discussion forum or ask during office hours.

---

### **Checklist for Completion**
Before submitting, ensure:
- [ ] Python and VS Code are installed correctly.
- [ ] You’ve written and tested the `hello.py` program.
- [ ] Your program runs without errors and meets the objectives.
- [ ] Your lab report follows the provided template and reflects on your work.
- [ ] You’ve pushed your completed script and lab report to GitHub Classroom.

---

**Congratulations on completing your first lab!**
