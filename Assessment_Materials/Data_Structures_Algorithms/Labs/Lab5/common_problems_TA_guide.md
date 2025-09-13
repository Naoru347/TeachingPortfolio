# Lab 5 TA Common Problems Guide
## Recursive Algorithms - Data Structures & Algorithms

This guide helps TAs quickly identify and solve common issues students encounter during Lab 5. Recursion introduces new thinking patterns that can be challenging for students coming from purely iterative backgrounds.

---

## **Fundamental Recursion Concept Issues**

### 🔥 **Very Common Problems**

#### **Problem 1.1: Missing or Incorrect Base Cases**
**Symptoms:**
- StackOverflowError when running recursive methods
- Student says "my program hangs and never finishes"
- Infinite recursion that crashes the JVM

**Most Common Patterns:**
```java
// BUG 1: No base case at all
public static int badFactorial(int n) {
    return n * badFactorial(n - 1);  // Will never stop!
}

// BUG 2: Unreachable base case
public static int badPower(int base, int exp) {
    if (exp == 1) return base;  // What about exp = 0?
    return base * badPower(base, exp - 1);  // exp=0 never handled
}

// BUG 3: Wrong base case condition
public static String badReverse(String str) {
    if (str.length() == 0) return "";  // Good so far...
    return badReverse(str.substring(1)) + str.charAt(0);  // But what about length 1?
}
```

**Teaching Strategy:**
1. **"When should recursion stop?"** - Start here every time
2. **"What's the smallest version of this problem?"** - Help them think
3. **"Trace through with the smallest examples"** - Use n=0, n=1, empty string, single character

**Quick Fix Framework:**
- **Empty/zero cases:** Usually base cases
- **Single element cases:** Often base cases  
- **"Can I solve this directly?"** If yes, it's probably a base case

#### **Problem 1.2: Problem Doesn't Get Smaller**
**Symptoms:**
- Stack overflow on what seems like valid input
- Student confused why recursion doesn't work
- Recursive calls using same parameter values

**Common Bug Patterns:**
```java
// BUG 1: Parameter never changes
public static int badSum(int[] arr, int index) {
    if (index >= arr.length) return 0;
    return arr[index] + badSum(arr, index);  // index never increments!
}

// BUG 2: Problem gets bigger instead of smaller
public static int badCountdown(int n) {
    if (n == 0) return 0;
    return badCountdown(n + 1);  // n increases instead of decreases!
}

// BUG 3: Wrong direction in string problems
public static String badReverse(String str) {
    if (str.length() <= 1) return str;
    return str.charAt(0) + badReverse(str);  // str never gets smaller!
}
```

**Teaching Points:**
- **"How does the problem get smaller with each call?"**
- **"What parameter should change?"**
- **"Are we moving toward the base case?"**

**Debugging Technique:**
```java
// Add debug prints to see parameter changes
public static int debugFactorial(int n) {
    System.out.println("factorial(" + n + ") called");
    if (n <= 1) {
        System.out.println("Base case reached");
        return 1;
    }
    return n * debugFactorial(n - 1);
}
```

#### **Problem 1.3: Confusion About What Gets Returned**
**Symptoms:**
- Wrong results even when recursion terminates
- Student doesn't understand how values flow back up
- Confusion about combining recursive results

**Teaching with Call Stack Visualization:**
```
factorial(4) = 4 * factorial(3)
                   │
                   └─→ factorial(3) = 3 * factorial(2)
                                          │
                                          └─→ factorial(2) = 2 * factorial(1)
                                                                │
                                                                └─→ factorial(1) = 1

Now values flow back up:
factorial(1) returns 1
factorial(2) returns 2 * 1 = 2  
factorial(3) returns 3 * 2 = 6
factorial(4) returns 4 * 6 = 24
```

**Common Return Logic Errors:**
```java
// BUG: Not using the recursive result
public static String badReverse(String str) {
    if (str.length() <= 1) return str;
    badReverse(str.substring(1));  // Result is ignored!
    return str.charAt(0);  // Wrong!
}

// CORRECT: Use the recursive result
public static String reverse(String str) {
    if (str.length() <= 1) return str;
    return reverse(str.substring(1)) + str.charAt(0);  // Combine correctly
}
```

---

## **Implementation-Specific Issues**

### 🔥 **Very Common Problems**

#### **Problem 2.1: String Manipulation Errors**
**Symptoms:**
- StringIndexOutOfBoundsException in string recursion
- Wrong substring boundaries
- Character access errors

**Common String Bugs:**
```java
// BUG 1: Wrong substring parameters
public static String badReverse(String str) {
    if (str.length() <= 1) return str;
    return badReverse(str.substring(0)) + str.charAt(0);  // substring(0) is wrong!
}

// BUG 2: Accessing characters in empty string
public static boolean badPalindrome(String str) {
    if (str.length() == 0) return true;  // Good
    if (str.charAt(0) == str.charAt(str.length() - 1)) {  // Crash on empty string!
        return badPalindrome(str.substring(1, str.length() - 1));
    }
    return false;
}

// BUG 3: Wrong substring boundaries
public static boolean badPalindrome(String str) {
    if (str.length() <= 1) return true;
    if (str.charAt(0) == str.charAt(str.length() - 1)) {
        return badPalindrome(str.substring(1, str.length()));  // Should be length() - 1
    }
    return false;
}
```

**String Method Reference for TAs:**
- `str.substring(1)` = all characters except first
- `str.substring(0, str.length() - 1)` = all characters except last
- `str.substring(1, str.length() - 1)` = all characters except first and last
- `str.charAt(0)` = first character
- `str.charAt(str.length() - 1)` = last character

#### **Problem 2.2: Array Index Management**
**Symptoms:**
- ArrayIndexOutOfBoundsException in array recursion
- Wrong starting index or boundary conditions
- Confusion about index parameter purpose

**Common Array Index Bugs:**
```java
// BUG 1: Starting with wrong index
public static int badSum(int[] arr) {
    return badSumHelper(arr, 1);  // Should start at index 0!
}

// BUG 2: Wrong boundary check
public static int badMax(int[] arr, int index) {
    if (index > arr.length) return Integer.MIN_VALUE;  // Should be >=
    return Math.max(arr[index], badMax(arr, index + 1));
}

// BUG 3: Not incrementing index
public static int badSum(int[] arr, int index) {
    if (index >= arr.length) return 0;
    return arr[index] + badSum(arr, index);  // index should be index + 1
}
```

**Teaching Strategy:**
- **Always trace with small arrays:** [5] or [3, 7]
- **"What index do we start with?"** (usually 0)
- **"When do we stop?"** (when index >= length)
- **"How do we move toward stopping?"** (increment index)

#### **Problem 2.3: Binary Search Implementation Errors**
**Symptoms:**
- Infinite recursion in binary search
- Wrong results for valid targets
- Stack overflow on simple searches

**Most Common Binary Search Bugs:**
```java
// BUG 1: Wrong overflow-safe midpoint calculation
int mid = (left + right) / 2;  // Can overflow for large arrays!
// CORRECT: int mid = left + (right - left) / 2;

// BUG 2: Wrong recursive call boundaries
if (arr[mid] < target) {
    return binarySearch(arr, target, mid, right);  // Should be mid + 1!
} else {
    return binarySearch(arr, target, left, mid);   // Should be mid - 1!
}

// BUG 3: Wrong base case
if (left >= right) return -1;  // Should be left > right
```

**Binary Search Teaching Template:**
```java
public static int binarySearch(int[] arr, int target, int left, int right) {
    // BASE CASE: Invalid range
    if (left > right) return -1;
    
    // DIVIDE: Find middle (overflow-safe)
    int mid = left + (right - left) / 2;
    
    // CONQUER: Check middle, then search appropriate half
    if (arr[mid] == target) return mid;
    else if (target < arr[mid]) return binarySearch(arr, target, left, mid - 1);
    else return binarySearch(arr, target, mid + 1, right);
}
```

### 🟡 **Moderately Common Problems**

#### **Problem 2.4: Merge Sort Implementation Issues**
**Symptoms:**
- Array not getting sorted
- Array corruption during merge process
- Stack overflow in merge sort

**Common Merge Sort Bugs:**
```java
// BUG 1: Wrong base case
if (left == right) return;  // Should be left >= right

// BUG 2: Wrong midpoint in recursive calls
mergeSort(arr, left, mid + 1);      // Should be left, mid
mergeSort(arr, mid, right);         // Should be mid + 1, right

// BUG 3: Not calling merge
mergeSort(arr, left, mid);
mergeSort(arr, mid + 1, right);
// Missing: merge(arr, left, mid, right);
```

---

## **Divide-and-Conquer Understanding Issues**

### 🔥 **Very Common Problems**

#### **Problem 3.1: Not Understanding the Three Steps**
**Symptoms:**
- Student tries to solve entire problem in one step
- Confusion about what "divide" means
- Missing the "combine" step

**Teaching Framework - Always Use This Pattern:**
```
1. DIVIDE: Break the problem into smaller pieces
2. CONQUER: Solve the smaller pieces (recursively)
3. COMBINE: Put the solutions together
```

**Examples:**
```java
// Binary Search:
// DIVIDE: Find middle point
// CONQUER: Search the correct half
// COMBINE: Return the result (no actual combination needed)

// Merge Sort:
// DIVIDE: Split array in half
// CONQUER: Sort both halves recursively  
// COMBINE: Merge the sorted halves
```

#### **Problem 3.2: Master Theorem Application Errors**
**Symptoms:**
- Wrong values for a, b, or f(n)
- Can't identify which case applies
- Confusion about logarithm calculations

**Step-by-Step Teaching Process:**
```
For T(n) = a * T(n/b) + f(n):

Step 1: "How many recursive calls?" → a
Step 2: "How much smaller is each call?" → b  
Step 3: "How much work outside recursion?" → f(n)
Step 4: "Calculate log_b(a)"
Step 5: "Compare f(n) with n^log_b(a)"
```

**Common Master Theorem Mistakes:**
```java
// Binary Search: T(n) = 1 * T(n/2) + O(1)
// WRONG: a = 2 (thinking about two possible branches)
// CORRECT: a = 1 (only one recursive call is made)

// Merge Sort: T(n) = 2 * T(n/2) + O(n)  
// WRONG: a = 1 (forgetting about second recursive call)
// CORRECT: a = 2 (two recursive calls to sort each half)
```

---

## **Performance and Stack Issues**

### 🟡 **Moderately Common Problems**

#### **Problem 4.1: Stack Overflow with Large Inputs**
**Symptoms:**
- Works for small inputs but crashes for large ones
- StackOverflowError with valid base cases
- Student doesn't understand why recursion has limits

**Explanation Points:**
- **Call stack has limited size** (typically ~1000-10000 calls)
- **Each recursive call uses stack space**
- **Tail recursion can help** (though Java doesn't optimize it)
- **Some problems need iterative solutions**

**When to Recommend Iterative Solutions:**
```java
// DON'T use recursion for:
// - Simple linear problems (factorial, sum 1 to n)
// - Fibonacci (naive recursive version is exponential)
// - Very deep recursion (file system traversal of deep directories)

// DO use recursion for:
// - Tree/graph traversal
// - Divide-and-conquer algorithms
// - Problems with natural recursive structure
```

#### **Problem 4.2: Exponential Time Complexity (Fibonacci)**
**Symptoms:**
- Recursive Fibonacci extremely slow for n > 30
- Student doesn't understand why
- Wants to test with large values

**Teaching Moment - Fibonacci Tree:**
```
fibonacci(5) calls:
                fib(5)
              /        \
          fib(4)      fib(3)
         /      \    /      \
     fib(3)  fib(2) fib(2) fib(1)
     /   \   /   \  /   \
  fib(2) fib(1) ...

Notice: fib(3) is calculated twice!
        fib(2) is calculated THREE times!
```

**Solution Approaches:**
- **Memoization:** Store results to avoid recalculation
- **Iterative:** Bottom-up approach
- **Tail recursion:** More efficient recursive form

---

## **Advanced Recursion Issues**

### 🟡 **Moderately Common Problems**

#### **Problem 5.1: Backtracking Confusion**
**Symptoms:**
- Permutation generation doesn't work
- Student doesn't understand "choose/explore/unchoose" pattern
- Results are incorrect or incomplete

**Backtracking Template:**
```java
public static void backtrack(/* state parameters */) {
    // BASE CASE: Valid complete solution
    if (isComplete(state)) {
        addSolutionToResult(state);
        return;
    }
    
    // TRY each possible choice
    for (Choice choice : possibleChoices) {
        // CHOOSE: Make the choice
        makeChoice(state, choice);
        
        // EXPLORE: Recurse with new state
        backtrack(/* modified state */);
        
        // UNCHOOSE: Undo the choice (backtrack)
        undoChoice(state, choice);
    }
}
```

#### **Problem 5.2: Tree Recursion Confusion (Preview for Lab 6)**
**Symptoms:**
- Student doesn't understand multiple recursive calls
- Confusion about tree structure vs. array/string recursion
- Wrong base case for tree problems

**Tree Recursion Pattern:**
```java
public static int treeHeight(TreeNode node) {
    // BASE CASE: Empty tree
    if (node == null) return 0;
    
    // RECURSIVE CASE: Height = 1 + max of subtree heights
    int leftHeight = treeHeight(node.left);
    int rightHeight = treeHeight(node.right);
    return Math.max(leftHeight, rightHeight) + 1;
}
```

**Key Teaching Point:** Tree recursion often involves multiple recursive calls, but the pattern is the same.

---

## **Quick Diagnostic Techniques for TAs**

### **Step 1: Check Base Case**
```java
// Ask: "What happens with the smallest input?"
// Test: factorial(0), factorial(1)
//       reverse(""), reverse("a")
//       binarySearch with single element array
```

### **Step 2: Check Problem Reduction**
```java
// Ask: "How does each recursive call get closer to the base case?"
// Look for: n-1, index+1, str.substring(1), mid+1/mid-1
```

### **Step 3: Trace Small Example**
```java
// Always trace with tiny examples:
// factorial(3), reverse("ab"), binarySearch([1,3], 3)
```

### **Stack Overflow Debug:**
```java
// Add this to any recursive method:
private static int depth = 0;
public static int factorial(int n) {
    depth++;
    if (depth > 1000) {
        System.out.println("Too deep! n = " + n);
        System.exit(1);
    }
    // ... rest of method
    depth--;
}
```

---

## **Escalation Guidelines**

### **Handle Immediately:**
- Missing or wrong base cases
- Problem not getting smaller
- Simple string/array indexing errors
- Basic Master Theorem application

### **Escalate to Instructor:**
- Student fundamentally doesn't understand recursion concept
- Deep confusion about call stack and program execution
- Advanced backtracking or dynamic programming questions
- Performance optimization beyond basic concepts

### **Document for Instructor:**
- Patterns in conceptual misunderstandings
- Students who might need additional math support (logarithms, etc.)
- Suggestions for improving recursive thinking exercises

---

## **Time Management Tips**

### **Triage Strategy:**
1. **Quick fixes (2-3 min):** Missing base case, wrong parameter increment
2. **Medium fixes (5-8 min):** String/array indexing, binary search bounds
3. **Complex issues (10+ min):** Fundamental recursion concept, divide-and-conquer understanding

### **When to Say "Office Hours":**
- Student needs complete recursion concept review
- Multiple fundamental errors requiring extensive explanation
- Advanced topics like memoization or tail recursion optimization
- Master Theorem mathematical background needed

### **Efficient Teaching:**
1. **Start with smallest example:** "What should happen with factorial(1)?"
2. **Check base case first:** "When should recursion stop?"
3. **Trace one complete example:** Follow the calls up and down
4. **Don't fix everything at once:** One concept at a time

---

## **Key Teaching Moments**

### **When Student Gets Stack Overflow:**
- "Let's trace through and see if we ever reach the base case"
- "What happens to n with each recursive call?"

### **When Recursion Seems "Magical":**
- "Let's trace through factorial(3) step by step"
- "The computer uses a stack just like we studied in Lab 4!"

### **When Performance is Poor:**
- "Count how many times fibonacci(3) gets calculated"
- "This is why we need dynamic programming or iteration"

### **When Divide-and-Conquer Confuses:**
- "Break it into three steps: divide, conquer, combine"
- "What's the smaller version of this same problem?"

Remember: Recursion is often the first truly "mind-bending" concept students encounter. Be patient and use lots of concrete examples!