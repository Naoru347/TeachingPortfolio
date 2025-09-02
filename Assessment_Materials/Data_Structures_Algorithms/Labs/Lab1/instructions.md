# Lab 1 – Environment Setup & "Hello Data Structures"

## Overview
Welcome to your first Data Structures & Algorithms lab! This foundational activity ensures everyone has a consistent development environment and introduces you to the tools and workflow you'll use throughout the semester-long project.

You'll configure your development environment, learn essential Git operations for team collaboration, and implement your first simple data structure. This lab establishes the technical foundation for success in your upcoming team projects while introducing key concepts of Abstract Data Types (ADTs).

---

## Learning Objectives
By the end of this lab, you will be able to:
- Configure a professional Java development environment with IDE and build tools
- Execute basic Git commands for version control and team collaboration
- Implement a simple ArrayList following ADT design principles  
- Write and run unit tests to verify data structure correctness
- Follow course standards for code documentation and repository organization

---

## Instructions

### Step 1: Environment Verification (20 minutes)

**1.1 Verify Java Installation**
Open your terminal/command prompt and run:
```bash
java -version
javac -version
```
Both should show Java 17 or later. If not, download and install Java JDK 17+ from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/).

**1.2 Verify Git Installation**  
Run:
```bash
git --version
```
Should return Git 2.30+. If missing, install from [git-scm.com](https://git-scm.com/).

**1.3 Configure Git Identity**
Set up your Git identity (use your university email):
```bash
git config --global user.name "Your Full Name"
git config --global user.email "your.email@gwu.edu"
```

**1.4 Test IDE Setup**
Open your chosen IDE (IntelliJ IDEA or VS Code w/ Java Extensions) and verify:
- Java project creation works
- Syntax highlighting is active
- You can compile and run a simple "Hello World" program

If you encounter issues, check the **Environment Setup Guide** on the course LMS or ask your TA for assistance.

### Step 2: Repository Setup and Project Structure (15 minutes)

**2.1 Create Your Lab Repository**
Navigate to where you want to store your lab work and run:
```bash
mkdir lab1-lastname-firstname
cd lab1-lastname-firstname
git init
```
Replace `lastname-firstname` with your actual name (e.g., `lab1-smith-john`).

**2.2 Set Up Project Structure**
Create the following directory structure:
```
lab1-lastname-firstname/
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       └── java/
├── README.md
└── .gitignore
```

Use these commands:
```bash
mkdir -p src/main/java src/test/java
touch README.md .gitignore
```

**2.3 Create .gitignore File**
Add the following content to your `.gitignore` file:
```
# Compiled class files
*.class

# IDE files
.idea/
.vscode/
*.iml
.eclipse/

# Build outputs
target/
build/
out/

# OS files
.DS_Store
Thumbs.db
```

### Step 3: Implement SimpleArrayList Data Structure (30 minutes)

**3.1 Create the List Interface**
In `src/main/java/`, create a file called `SimpleList.java`:
```java
public interface SimpleList<T> {
    void add(T element);
    T get(int index);
    int size();
    boolean isEmpty();
}
```

**3.2 Implement SimpleArrayList Class**
In the same directory, create `SimpleArrayList.java`. Your implementation should:
- Implement the `SimpleList<T>` interface
- Use a generic array to store elements internally
- Handle dynamic resizing when the array becomes full
- Include proper error checking (e.g., bounds checking for `get()`)

**Key Requirements:**
- Initial capacity of 10 elements
- Double the capacity when array becomes full
- Throw `IndexOutOfBoundsException` for invalid indices
- Include JavaDoc comments for all public methods

**Example method signature:**
```java
public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    // Your implementation here
}
```

**3.3 Write Unit Tests**
In `src/test/java/`, create `SimpleArrayListTest.java`:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleArrayListTest {
    @Test
    public void testAddAndGet() {
        // Test adding elements and retrieving them
    }
    
    @Test
    public void testSizeAndIsEmpty() {
        // Test size() and isEmpty() methods
    }
    
    @Test
    public void testBoundsChecking() {
        // Test that invalid indices throw exceptions
    }
    
    @Test
    public void testDynamicResizing() {
        // Test that array expands when needed
    }
}
```

Write meaningful tests that verify your implementation works correctly.

### Step 4: Documentation and Git Workflow (10 minutes)

**4.1 Create README.md**
Write a professional README that includes:
- Brief description of what you implemented
- Compilation instructions
- How to run the tests
- Any design decisions you made

**Example structure:**
```markdown
# Lab 1: SimpleArrayList Implementation

## Description
A generic ArrayList implementation demonstrating basic dynamic array concepts.

## Compilation
```bash
javac -cp ".:junit-platform-console-standalone-1.8.2.jar" src/main/java/*.java src/test/java/*.java
```

## Running Tests
```bash
java -cp ".:junit-platform-console-standalone-1.8.2.jar" org.junit.platform.console.ConsoleLauncher --scan-classpath
```

## Design Decisions
- Initial capacity: 10 elements
- Growth strategy: Double capacity when full
- Error handling: IndexOutOfBoundsException for invalid indices
```

**4.2 Commit Your Work**
Stage and commit your changes:
```bash
git add .
git commit -m "Initial implementation of SimpleArrayList with unit tests

- Implemented SimpleList interface
- Created SimpleArrayList with dynamic resizing
- Added comprehensive unit tests
- Included documentation and build instructions"
```

---

## Deliverable
Submit a **single ZIP file** containing your complete lab1 directory with:
1. **Complete source code** (interface, implementation, and tests)
2. **README.md** with clear compilation and execution instructions
3. **Proper Git history** showing your development process
4. **All tests passing** when run by the TA

**File Naming Convention:** `Lab1_Lastname_Firstname.zip`

**Submission Method:** Upload to course LMS under "Lab 1 Submission"

---

## Assessment Criteria
Your lab will be evaluated on:

| Category | Weight | Description |
|----------|--------|-------------|
| **Environment Setup** | 20% | Java, Git, and IDE properly configured and demonstrated |
| **Implementation Quality** | 40% | SimpleArrayList correctly implements all interface methods with proper error handling |
| **Testing Coverage** | 25% | Unit tests are comprehensive and all pass |
| **Documentation & Professionalism** | 15% | Clear README, proper code comments, good Git commit messages |

---

## Suggested Time: 75 minutes
- Environment setup and verification: 20 minutes
- Repository setup: 15 minutes  
- Implementation and testing: 30 minutes
- Documentation and submission: 10 minutes

If you don't complete the lab during class time, finish it before the next class session.

---

## Getting Help
- **TA Office Hours:** Monday/Wednesday 4:00-6:00 PM in SEAS Lab 201
- **Course Discord:** #technical-help channel for quick questions
- **Instructor Office Hours:** Tuesday/Thursday 1:00-3:00 PM
- **Setup Issues:** Check the detailed Environment Setup Guide on course LMS

Remember: This lab sets up the foundation for your entire semester project. Take time to get your environment working properly – it will save you hours of frustration later!

---

## Optional Resources
- [Git Handbook](https://guides.github.com/introduction/git-handbook/) - Git basics and workflow
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/) - Unit testing framework
- [Oracle Java Documentation](https://docs.oracle.com/en/java/) - Java language reference
- [Effective Java](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/) - Best practices for Java development