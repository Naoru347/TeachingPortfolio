# Lab 1 TA Common Problems Guide
## Data Structures & Algorithms - Environment Setup & "Hello Data Structures"

This guide helps TAs quickly identify and solve the most common issues students encounter during Lab 1. Problems are organized by frequency and include quick diagnostic steps and solutions.

---

## **Environment Setup Issues (Step 1)**

### **Very Common Problems**

#### **Problem 1.1: Java Version Conflicts**
**Symptoms:**
- `java -version` and `javac -version` show different versions
- Student has Java 8 or 11 instead of Java 17+
- "Unsupported class file major version" errors

**Quick Fix:**
```bash
# Check what's installed
java -version
javac -version
which java
which javac

# Windows: Check JAVA_HOME
echo %JAVA_HOME%

# Mac/Linux: Check JAVA_HOME
echo $JAVA_HOME
```

**Solution Steps:**
1. Download Java 17 from [Oracle](https://www.oracle.com/java/technologies/downloads/)
2. Set JAVA_HOME environment variable to new installation
3. Update PATH to point to new Java bin directory
4. Restart terminal/IDE
5. Verify with `java -version` and `javac -version`

#### **Problem 1.2: Git Not Installed or Configured**
**Symptoms:**
- `git --version` returns "command not found"
- Git commands work but show "Please tell me who you are" error
- Student can't commit changes

**Quick Fix:**
```bash
# Check Git installation
git --version

# Configure if missing
git config --global user.name "Student Name"
git config --global user.email "student@gwu.edu"

# Verify configuration
git config --list --global
```

#### **Problem 1.3: IDE Java Setup Issues**
**Symptoms:**
- IDE doesn't recognize Java syntax
- "Cannot resolve symbol" errors for basic Java
- No code completion or syntax highlighting

**Solutions by IDE:**

**IntelliJ IDEA:**
1. File → Project Structure → Project → SDK (set to Java 17)
2. File → Project Structure → Modules → Language Level (set to 17)
3. Restart IDE

**VS Code:**
1. Install "Extension Pack for Java"
2. Ctrl+Shift+P → "Java: Configure Classpath"
3. Verify Java.home setting in VS Code settings

---

## **Repository Setup Issues (Step 2)**

### **Very Common Problems**

#### **Problem 2.1: Directory Structure Confusion**
**Symptoms:**
- Student creates files in wrong directories
- Can't find their Java files
- Compilation errors due to wrong paths

**Quick Fix:**
Show them the correct structure visually:
```
lab1-lastname-firstname/
├── src/
│   ├── main/
│   │   └── java/          ← Java source files go HERE
│   └── test/
│       └── java/          ← Test files go HERE
├── README.md
└── .gitignore
```

**Common Mistake:** Students put files directly in `src/` instead of `src/main/java/`

#### **Problem 2.2: Git Init Issues**
**Symptoms:**
- "Not a git repository" errors
- Can't commit files
- Git commands don't work

**Quick Diagnostic:**
```bash
pwd  # Are they in the right directory?
ls -la  # Is there a .git folder?
git status  # What does Git see?
```

**Solution:**
```bash
cd lab1-lastname-firstname  # Make sure in correct directory
git init  # Initialize if missing
git status  # Should show untracked files
```

### **Moderately Common Problems**

#### **Problem 2.3: .gitignore Not Working**
**Symptoms:**
- `.class` files being tracked by Git
- IDE files (`.idea/`, `.vscode/`) in repository
- `git status` shows files that should be ignored

**Solution:**
1. Verify `.gitignore` exists and has correct content
2. If files already tracked: `git rm --cached filename`
3. Commit the `.gitignore` file first
4. Then add other files

---

## **Implementation Issues (Step 3)**

### **Very Common Problems**

#### **Problem 3.1: Generic Array Creation Error**
**Symptoms:**
- "Cannot create a generic array of T" compilation error
- Student tries `T[] data = new T[capacity];`

**Quick Fix:**
```java
// WRONG:
T[] data = new T[capacity];

// CORRECT:
@SuppressWarnings("unchecked")
T[] data = (T[]) new Object[capacity];
```

**Explanation for Student:** Java doesn't allow direct generic array creation due to type erasure. We create an Object array and cast it.

#### **Problem 3.2: Array Resizing Logic Errors**
**Symptoms:**
- `ArrayIndexOutOfBoundsException` when adding elements
- Array doesn't grow when it should
- Elements get lost during resizing

**Common Bug Patterns:**
```java
// BUG 1: Not copying old elements
private void resize() {
    data = (T[]) new Object[data.length * 2];  // Lost old elements!
}

// BUG 2: Wrong size check
public void add(T element) {
    if (size == data.length - 1) {  // Should be size == data.length
        resize();
    }
}

// CORRECT VERSION:
private void resize() {
    T[] newData = (T[]) new Object[data.length * 2];
    for (int i = 0; i < size; i++) {
        newData[i] = data[i];
    }
    data = newData;
}
```

#### **Problem 3.3: IndexOutOfBoundsException Logic**
**Symptoms:**
- Exception thrown for valid indices
- Exception not thrown for invalid indices
- Confusion about when to throw

**Quick Check:**
```java
public T get(int index) {
    // WRONG: if (index < 0 || index >= data.length)
    // CORRECT: if (index < 0 || index >= size)
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    return data[index];
}
```

**Key Point:** Check against `size`, not `data.length`!

### **Moderately Common Problems**

#### **Problem 3.4: Interface Implementation Issues**
**Symptoms:**
- "Class is not abstract and does not override abstract method" error
- Method signatures don't match interface
- Missing `@Override` annotations

**Solution Checklist:**
- [ ] All interface methods implemented
- [ ] Exact same method signatures (including generics)
- [ ] `@Override` annotation on each method
- [ ] `implements SimpleList<T>` in class declaration

#### **Problem 3.5: Constructor and Field Issues**
**Symptoms:**
- NullPointerException when adding first element
- Fields not properly initialized
- Size not tracking correctly

**Common Issues:**
```java
public SimpleArrayList() {
    // MISSING: data array initialization
    // MISSING: size = 0 (though this defaults to 0)
}

// CORRECT:
public SimpleArrayList() {
    data = (T[]) new Object[DEFAULT_CAPACITY];
    size = 0;
}
```

---

## **Testing Issues (Step 3.3)**

### **Very Common Problems**

#### **Problem 4.1: JUnit Not Found**
**Symptoms:**
- "Cannot resolve symbol" for JUnit imports
- Compilation errors on `@Test` annotations
- "Package org.junit does not exist"

**Quick Fixes:**
1. **IDE Setup:**
   - IntelliJ: Right-click project → Add Framework Support → JUnit
   - VS Code: Install Java Test Runner extension

2. **Manual Setup:**
   - Download JUnit 5 JAR
   - Add to classpath when compiling/running

3. **Maven/Gradle:** Help student set up build system if comfortable

#### **Problem 4.2: Test Logic Errors**
**Symptoms:**
- Tests pass when they should fail
- Tests fail when they should pass
- Assertions backwards (`assertEquals(actual, expected)`)

**Common Mistakes:**
```java
// WRONG: Parameters backwards
assertEquals(list.get(0), "hello");

// CORRECT:
assertEquals("hello", list.get(0));

// WRONG: Not testing what they think
@Test
public void testSizeAndIsEmpty() {
    SimpleArrayList<String> list = new SimpleArrayList<>();
    assertTrue(list.isEmpty());  // Good
    assertEquals(0, list.size());  // Good
    // MISSING: Test after adding elements!
}
```

### **Moderately Common Problems**

#### **Problem 4.3: Test Compilation Issues**
**Symptoms:**
- Tests compile but don't run
- "No tests found" messages
- Test classes not recognized

**Solutions:**
1. Verify test class naming (`*Test.java`)
2. Check test method annotations (`@Test`)
3. Verify test directory structure
4. Check IDE test runner configuration

---

## **Documentation and Submission (Step 4)**

### **Moderately Common Problems**

#### **Problem 5.1: Compilation Instructions Wrong**
**Symptoms:**
- README has incorrect javac commands
- Classpath issues in instructions
- Commands don't work when TA tries them

**Fix Template:**
```markdown
## Compilation
```bash
# Compile main classes
javac src/main/java/*.java

# Compile tests (if using JUnit JAR)
javac -cp ".:junit-platform-console-standalone-1.8.2.jar" src/main/java/*.java src/test/java/*.java
```

#### **Problem 5.2: Git Commit Message Issues**
**Symptoms:**
- Single-line commit messages like "done"
- No descriptive information
- Multiple unrelated changes in one commit

**Teach Good Practices:**
```bash
# BAD:
git commit -m "lab1"

# GOOD:
git commit -m "Implement SimpleArrayList with dynamic resizing

- Add SimpleList interface with generic type parameter
- Implement SimpleArrayList with array doubling strategy
- Include bounds checking with proper exception handling
- Add comprehensive unit tests for all public methods"
```

---

## **Quick Diagnostic Commands for TAs**

### **Environment Checks:**
```bash
java -version && javac -version  # Java setup
git --version && git config --list --global  # Git setup
pwd && ls -la  # Current location and files
```

### **Project Structure Verification:**
```bash
find . -name "*.java" -type f  # Find all Java files
tree .  # Show directory structure (if available)
git status  # What Git sees
```

### **Compilation Test:**
```bash
cd src/main/java && javac *.java  # Quick compile test
ls *.class  # Should see compiled classes
```

---

## **Escalation Guidelines**

### **Handle Immediately:**
- Basic compilation errors
- Git configuration issues
- File organization problems
- Simple implementation bugs

### **Escalate to Instructor:**
- Complex IDE configuration issues requiring admin rights
- Persistent JVM crashes or system-level problems
- Students with significant conceptual misunderstandings about OOP
- Suspected academic integrity issues

### **Document for Instructor:**
- Recurring problems affecting multiple students
- Lab instruction ambiguities or errors
- Suggestions for improving lab materials

---

## **Time Management Tips**

### **Triage Strategy:**
1. **Quick wins first:** Git config, file organization (2-3 minutes)
2. **Common compilation issues:** Generic arrays, method signatures (5 minutes)
3. **Logic problems:** Array resizing, bounds checking (10+ minutes)
4. **Complex debugging:** Only if time permits, otherwise schedule office hours

### **When to Say "Office Hours":**
- Student needs fundamental OOP review
- Complex IDE configuration issues
- Multiple interconnected problems
- Lab session running out of time

Remember: Your goal is to unblock students quickly so they can continue learning. Don't feel obligated to fix every problem perfectly during lab time!