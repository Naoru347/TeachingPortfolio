# Lab 5 – Recursive Algorithms

## Overview
Welcome to your fifth Data Structures & Algorithms lab! This session explores recursion – one of the most powerful and elegant problem-solving techniques in computer science. You'll learn to think recursively, implement classic recursive algorithms, and analyze their performance using the Master Theorem.

Building directly on Lab 4's stack concepts, you'll understand how programming languages use stacks to manage recursive function calls. This lab provides essential preparation for tree algorithms (Lab 6) and advanced divide-and-conquer techniques throughout the course.

---

## Learning Objectives
By the end of this lab, you will be able to:
- Design recursive algorithms using the fundamental recursive pattern
- Implement classic divide-and-conquer algorithms (merge sort, binary search, etc.)
- Trace recursive execution and understand the call stack
- Apply the Master Theorem to analyze recursive algorithm complexity
- Choose between recursive and iterative solutions appropriately
- Debug recursive algorithms and avoid common pitfalls

---

## Pre-Lab Preparation (5 minutes)
**Before starting the exercises, ensure you have:**
- Completed Lab 4 (understanding of stacks is crucial!)
- Downloaded `RecursionStarter.java`, `RecursionTester.java`, and `MasterTheoremWorksheet.md` from course LMS
- Reviewed textbook Chapter 5 (Recursion) sections 5.1-5.3
- Basic understanding of mathematical induction (helpful but not required)

---

## Part 1: Recursion Fundamentals (20 minutes)

### **Exercise 1.1: Understanding the Recursive Pattern (10 minutes)**

**The Recursive Template:**
Every recursive algorithm follows this pattern:
```java
public ReturnType recursiveMethod(parameters) {
    // 1. BASE CASE(S) - when to stop recursion
    if (baseCondition) {
        return baseValue;
    }
    
    // 2. RECURSIVE CASE - break problem into smaller pieces
    // Make the problem smaller
    // Call recursiveMethod on smaller problem
    // Combine results if needed
    return combine(recursiveMethod(smallerProblem));
}
```

**📝 Analyze these examples and identify the pattern:**

**Example 1: Factorial**
```java
public static int factorial(int n) {
    if (n <= 1) {                    // BASE CASE: _________
        return 1;
    }
    return n * factorial(n - 1);     // RECURSIVE CASE: _________
}
```

**Example 2: Sum of Array**
```java
public static int sum(int[] arr, int index) {
    if (index >= arr.length) {       // BASE CASE: _________
        return 0;
    }
    return arr[index] + sum(arr, index + 1);  // RECURSIVE CASE: _________
}
```

**📝 Complete this analysis:**
- **Factorial base case:** When does recursion stop? _________
- **Factorial recursive case:** How does the problem get smaller? _________
- **Sum base case:** When does recursion stop? _________
- **Sum recursive case:** How does the problem get smaller? _________

### **Exercise 1.2: Call Stack Visualization (10 minutes)**

**Key Connection to Lab 4:** Recursion uses the program's call stack to manage function calls!

**📝 Trace the execution of `factorial(4)`:**

```
Call Stack Visualization:
Step 1: factorial(4) called
Stack: [factorial(4)]

Step 2: factorial(4) calls factorial(3)
Stack: [factorial(4), factorial(3)]

Step 3: factorial(3) calls factorial(2)
Stack: [factorial(4), factorial(3), factorial(2)]

Step 4: factorial(2) calls factorial(1)
Stack: [factorial(4), factorial(3), factorial(2), factorial(1)]

Step 5: factorial(1) returns 1 (base case!)
Stack: [factorial(4), factorial(3), factorial(2)]
Return value: 1

Step 6: factorial(2) returns 2 * 1 = 2
Stack: [factorial(4), factorial(3)]
Return value: 2

Continue this pattern...
Step 7: factorial(3) returns _____ * _____ = _____
Step 8: factorial(4) returns _____ * _____ = _____
```

**Understanding:** Each recursive call adds a new frame to the call stack. When a base case is reached, the stack "unwinds" as each function returns its result.

---

## Part 2: Classic Recursive Algorithms (25 minutes)

### **Exercise 2.1: Simple Recursive Problems (15 minutes)**

Open `RecursionStarter.java` and implement these fundamental recursive algorithms:

**Problem 1: Power Function**
```java
/**
 * TODO: Calculate base^exponent using recursion
 * Examples: power(2, 3) = 8, power(5, 0) = 1
 */
public static long power(int base, int exponent) {
    // TODO: Identify base case(s)
    // HINT: What is base^0? What about negative exponents?
    
    // TODO: Identify recursive case
    // HINT: base^n = base * base^(n-1)
    
    return 0; // Placeholder
}
```

**Problem 2: String Reversal**
```java
/**
 * TODO: Reverse a string using recursion
 * Examples: reverse("hello") = "olleh", reverse("a") = "a"
 */
public static String reverse(String str) {
    // TODO: Base case - what's the smallest string you can reverse?
    
    // TODO: Recursive case - how do you break down the problem?
    // HINT: reverse("hello") = reverse("ello") + "h"
    
    return ""; // Placeholder
}
```

**Problem 3: Palindrome Checker**
```java
/**
 * TODO: Check if a string is a palindrome using recursion
 * Examples: isPalindrome("racecar") = true, isPalindrome("hello") = false
 */
public static boolean isPalindrome(String str) {
    // TODO: Base cases - when is a string definitely a palindrome?
    // HINT: Empty string? Single character? Two identical characters?
    
    // TODO: Recursive case - compare first and last characters
    // HINT: If first == last, check the middle part recursively
    
    return false; // Placeholder
}
```

**📝 For each algorithm, identify:**
- **Base case(s):** _________
- **How the problem gets smaller:** _________
- **What gets combined/returned:** _________

### **Exercise 2.2: Divide-and-Conquer Algorithms (10 minutes)**

Implement these classic divide-and-conquer algorithms:

**Algorithm 1: Binary Search (Recursive)**
```java
/**
 * TODO: Implement recursive binary search
 * Returns index of target, or -1 if not found
 */
public static int binarySearch(int[] arr, int target, int left, int right) {
    // TODO: Base case - when should search stop?
    // HINT: When left > right, element not found
    
    // TODO: Divide - find middle point
    int mid = left + (right - left) / 2;
    
    // TODO: Conquer - check middle element
    // TODO: If found, return index
    // TODO: If target < middle, search left half
    // TODO: If target > middle, search right half
    
    return -1; // Placeholder
}
```

**Algorithm 2: Merge Sort**
```java
/**
 * TODO: Implement recursive merge sort
 */
public static void mergeSort(int[] arr, int left, int right) {
    // TODO: Base case - when is array small enough to stop dividing?
    // HINT: When left >= right, subarray has 0 or 1 elements
    
    if (left < right) {
        // TODO: Divide - find middle point
        int mid = left + (right - left) / 2;
        
        // TODO: Conquer - recursively sort both halves
        // mergeSort(arr, left, mid);
        // mergeSort(arr, mid + 1, right);
        
        // TODO: Combine - merge the sorted halves
        // merge(arr, left, mid, right);
    }
}

/**
 * Helper method to merge two sorted subarrays
 */
private static void merge(int[] arr, int left, int mid, int right) {
    // Implementation provided in starter code
}
```

**📝 Complexity Analysis:**
- **Binary Search:** How many times can you divide n elements in half? _________
- **Merge Sort:** How many levels of recursion? _________ operations per level? _________

---

## Part 3: Master Theorem Applications (15 minutes)

### **Exercise 3.1: Recurrence Relations (8 minutes)**

**The Master Theorem** helps analyze divide-and-conquer algorithms with recurrences of the form:
```
T(n) = a * T(n/b) + f(n)
```

Where:
- `a` = number of recursive calls
- `b` = factor by which problem size is reduced
- `f(n)` = work done outside recursive calls

**📝 Identify a, b, and f(n) for these algorithms:**

1. **Binary Search:** `T(n) = 1 * T(n/2) + O(1)`
   - `a = _____` (how many recursive calls?)
   - `b = _____` (how much smaller is each call?)
   - `f(n) = _____` (work done outside recursion?)

2. **Merge Sort:** `T(n) = 2 * T(n/2) + O(n)`
   - `a = _____`
   - `b = _____`
   - `f(n) = _____`

3. **Factorial:** `T(n) = 1 * T(n-1) + O(1)`
   - **Question:** Does this fit the Master Theorem pattern? Why or why not?
   - Answer: _________

### **Exercise 3.2: Master Theorem Cases (7 minutes)**

**The Master Theorem has three cases:**

**Case 1:** If `f(n) = O(n^c)` where `c < log_b(a)`, then `T(n) = Θ(n^log_b(a))`
**Case 2:** If `f(n) = Θ(n^c)` where `c = log_b(a)`, then `T(n) = Θ(n^c * log(n))`
**Case 3:** If `f(n) = Ω(n^c)` where `c > log_b(a)`, then `T(n) = Θ(f(n))`

**📝 Apply the Master Theorem:**

1. **Binary Search:** `T(n) = 1 * T(n/2) + O(1)`
   - `log_b(a) = log_2(1) = 0`
   - `f(n) = O(1) = O(n^0)`
   - Since `c = 0 = log_b(a)`, this is **Case 2**
   - Therefore: `T(n) = Θ(n^0 * log(n)) = Θ(log(n))` ✓

2. **Merge Sort:** `T(n) = 2 * T(n/2) + O(n)`
   - `log_b(a) = log_2(2) = _____`
   - `f(n) = O(n) = O(n^___)`
   - Since `c _____ log_b(a)`, this is **Case _____**
   - Therefore: `T(n) = _____`

3. **Hypothetical Algorithm:** `T(n) = 4 * T(n/2) + O(n)`
   - `log_b(a) = log_2(4) = _____`
   - `f(n) = O(n) = O(n^___)`
   - Since `c _____ log_b(a)`, this is **Case _____**
   - Therefore: `T(n) = _____`

---

## Part 4: Recursion vs Iteration Trade-offs (10 minutes)

### **Exercise 4.1: Implementation Comparison**

**📝 Compare recursive vs iterative implementations:**

```java
// Recursive Fibonacci (inefficient)
public static int fibRecursive(int n) {
    if (n <= 1) return n;
    return fibRecursive(n-1) + fibRecursive(n-2);
}

// Iterative Fibonacci (efficient)
public static int fibIterative(int n) {
    if (n <= 1) return n;
    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }
    return b;
}
```

**Analysis Questions:**
1. **Time Complexity:**
   - Recursive: _____ (exponential due to repeated calculations)
   - Iterative: _____ (linear)

2. **Space Complexity:**
   - Recursive: _____ (call stack depth)
   - Iterative: _____ (constant space)

3. **When to use recursive approach?**
   - ✓ Problem naturally divides into subproblems
   - ✓ Tree/graph traversal
   - ✓ Code clarity and elegance matter
   - ✗ Simple linear problems
   - ✗ Performance is critical

### **Exercise 4.2: Tail Recursion Optimization**

**Concept:** Tail recursion occurs when the recursive call is the last operation in the function.

```java
// NOT tail recursive (multiplication happens after recursive call)
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);  // Operation AFTER recursive call
}

// Tail recursive version
public static int factorialTail(int n, int accumulator) {
    if (n <= 1) return accumulator;
    return factorialTail(n - 1, n * accumulator);  // Recursive call is LAST
}
```

**📝 Convert to tail recursive form:**
```java
// Original: sum of 1 to n
public static int sum(int n) {
    if (n <= 0) return 0;
    return n + sum(n - 1);
}

// TODO: Rewrite as tail recursive
public static int sumTail(int n, int accumulator) {
    // Your implementation here
}
```

---

## Part 5: Practical Applications and Debugging (5 minutes)

### **Exercise 5.1: Common Recursion Pitfalls**

**📝 Identify and fix these buggy recursive implementations:**

**Bug 1: Missing Base Case**
```java
// BUGGY - infinite recursion!
public static int badFactorial(int n) {
    return n * badFactorial(n - 1);  // No base case!
}

// FIX: _________
```

**Bug 2: Wrong Base Case**
```java
// BUGGY - doesn't handle n=0 correctly
public static int badPower(int base, int exp) {
    if (exp == 1) return base;  // Wrong! What about exp=0?
    return base * badPower(base, exp - 1);
}

// FIX: _________
```

**Bug 3: Problem Doesn't Get Smaller**
```java
// BUGGY - infinite recursion for some inputs
public static boolean badSearch(int[] arr, int target, int index) {
    if (arr[index] == target) return true;
    return badSearch(arr, target, index);  // index never changes!
}

// FIX: _________
```

### **Exercise 5.2: Project Integration Ideas**

**Week 6 Project Milestone:** Add a recursive feature to your semester project.

**💡 Recursive Feature Ideas:**
- **File system traversal:** Recursively list all files in directories
- **Menu navigation:** Nested menu systems with recursive display
- **Data validation:** Recursive parsing of nested data structures
- **Game logic:** Recursive game state evaluation (tic-tac-toe, etc.)
- **Mathematical calculations:** Recursive formula evaluation

**📝 Plan your recursive feature:**
- **What problem will you solve recursively?** _________
- **What's the base case?** _________
- **How does the problem get smaller?** _________
- **How will you test and debug it?** _________

---

## Deliverable

Submit a **single ZIP file** containing:

1. **Complete Implementation:**
   - `RecursionSolutions.java` with all recursive algorithms implemented
   - Working test cases demonstrating correct functionality

2. **Master Theorem Analysis (PDF):**
   - Completed `MasterTheoremWorksheet.md` with all recurrence analyses
   - Complexity analysis for your implemented algorithms
   - Comparison of recursive vs iterative approaches

3. **Project Integration Plan:**
   - Description of recursive feature for your semester project
   - Pseudocode or implementation plan
   - Testing strategy

**File Naming Convention:** `Lab5_Lastname_Firstname.zip`

**Submission Method:** Upload to course LMS under "Lab 5 Submission"

---

## Assessment Criteria

| Category | Weight | Description |
|----------|--------|-------------|
| **Implementation Correctness** | 40% | All recursive algorithms work correctly with proper base cases |
| **Master Theorem Application** | 25% | Accurate complexity analysis using Master Theorem |
| **Code Quality** | 20% | Clean recursive code with clear structure and comments |
| **Understanding Demonstration** | 15% | Call stack traces and comparison analyses show deep understanding |

---

## Looking Ahead

**Lab 6 Preview:** Next week you'll implement binary trees using recursive algorithms. Everything you learn about recursion today will be essential for:
- Tree traversals (preorder, inorder, postorder)
- Tree insertion and deletion
- Tree search algorithms
- Tree height and balance calculations

**Master these recursive patterns now - they're the foundation for all tree algorithms!**

---

## Troubleshooting Tips

**Stack Overflow Errors:**
- Check for missing or incorrect base cases
- Ensure the problem is getting smaller with each recursive call
- Consider iterative solutions for very large inputs

**Infinite Recursion:**
- Add debug prints to trace recursive calls
- Verify base case conditions are reachable
- Check that recursive calls modify parameters correctly

**Wrong Results:**
- Trace through small examples by hand
- Verify base case returns correct values
- Check that recursive case combines results properly

---

## Optional Extensions

**For students who finish early:**

1. **Implement recursive tree traversal** (preview of Lab 6)
2. **Create recursive maze solver** using backtracking
3. **Implement recursive quicksort** with complexity analysis
4. **Build recursive expression evaluator** for mathematical expressions
5. **Create visualization** of recursive call stack for debugging

---

## Next Week Preview

In Lab 6, you'll apply these recursive techniques to binary trees - one of the most important data structures in computer science. Understanding recursion thoroughly will make tree algorithms feel natural and intuitive!