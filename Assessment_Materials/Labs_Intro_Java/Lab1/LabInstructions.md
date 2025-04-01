# **Lab 1: Environment Setup and First Program (Java Edition)**

## **Objectives**
1. Set up your programming environment (Java and Visual Studio Code or IntelliJ).
2. Understand basic Java syntax by writing and running your first Java program.
3. Document your process and reflections in a one-page lab report.

---

## **Instructions**

### **Part 1: Setting Up Your Environment**
1. **Install the Java Development Kit (JDK):**
   - Download the latest version of the JDK from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [Adoptium](https://adoptium.net/).
   - Follow the installation instructions for your operating system.
   - After installation, open your terminal or command prompt and type:
     ```bash
     java --version
     ```
     If installed correctly, this will show the Java version number (e.g., `java 17.0.x`).

2. **Install Visual Studio Code (VS Code) or IntelliJ IDEA:**
   - Download VS Code from [code.visualstudio.com](https://code.visualstudio.com/) or IntelliJ IDEA from [jetbrains.com](https://www.jetbrains.com/idea/).
   - For VS Code, install the "Extension Pack for Java":
     - Go to the Extensions view (`Ctrl+Shift+X`).
     - Search for "Java Extension Pack" and install it.

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

4. **Open the Project in Your IDE:**
   - Launch your IDE and open the folder you just cloned.
   - Familiarize yourself with the structure of the starter template.

---

### **Part 2: Writing Your First Java Program**
1. **Create a New Java File:**
   - In your project’s `src` folder (or main folder), create a new file named `HelloWorld.java`.

2. **Write Your Code:**
   - Type the following code into `HelloWorld.java`:
     ```java
     import java.util.Scanner;

     public class HelloWorld {
         public static void main(String[] args) {
             System.out.println("Hello, World!");

             Scanner scanner = new Scanner(System.in);
             System.out.print("What is your name? ");
             String name = scanner.nextLine();

             System.out.println("Hello, " + name + "!");
             scanner.close();
         }
     }
     ```

3. **Save Your File:**
   - Use `Ctrl+S` (Windows/Linux) or `Cmd+S` (Mac) to save your file.

4. **Run Your Program:**
   - Open the integrated terminal (`Ctrl+`` or View > Terminal`).
   - Compile your program:
     ```bash
     javac HelloWorld.java
     ```
   - Run the compiled program:
     ```bash
     java HelloWorld
     ```
   - Verify that your program:
     - Prints "Hello, World!" to the terminal.
     - Prompts you to enter your name.
     - Greets you with "Hello, [Your Name]!".

---

### **Part 3: Writing Your Lab Report**
1. **Overview:**
   - Write a one-page lab report summarizing your experience with this lab.

2. **Report Template:**
   - Use the lab report template provided on the course LMS.
   - Your report should include:
     - **Objective:** What was the purpose of the lab?
     - **Process:** How you completed the lab (e.g., setup steps, coding process).
     - **Challenges:** Any difficulties and how you resolved them.
     - **Reflection:** What you learned and how it connects to your goals.

3. **Format:**
   - Submit your lab report as a PDF or Markdown file to GitHub Classroom along with your `.java` file.

---

### **Part 4: Submitting Your Work**
1. **Stage Your Changes:**
   ```bash
   git add HelloWorld.java lab_report.md
   ```

2. **Commit Your Changes:**
   ```bash
   git commit -m "Completed Lab 1: Hello World and Lab Report"
   ```

3. **Push Your Changes:**
   ```bash
   git push
   ```

4. **Verify Submission:**
   - Log in to GitHub Classroom and ensure your `.java` file and lab report are visible in the repository.

---

### **Important Notes**
- **AI Usage Policy:**  
  For this lab, AI tools are **NOT** permitted. Completing this setup and program independently is essential for building foundational skills.

- **Help and Support:**  
  If you encounter issues, refer to:
  - The [Java Documentation](https://docs.oracle.com/en/java/).
  - The VS Code Java Extension Pack or IntelliJ user guide.
  - Post questions in the class discussion forum or visit office hours.

---

### **Checklist for Completion**
Before submitting, ensure:
- [ ] Java and your IDE are installed correctly.
- [ ] You’ve written and tested the `HelloWorld.java` program.
- [ ] Your program compiles and runs without errors.
- [ ] Your lab report follows the provided template and reflects on your work.
- [ ] You’ve pushed your `.java` file and lab report to GitHub Classroom.

---

**Congratulations on completing your first Java lab!**