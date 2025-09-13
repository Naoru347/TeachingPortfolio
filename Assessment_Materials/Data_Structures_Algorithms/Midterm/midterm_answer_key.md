# CSC 220: Data Structures & Algorithms
## Midterm Examination - Answer Key

**Semester:** Fall 2025  
**Total Points:** 100 points (+ 5 bonus)

---

## Section I: Multiple Choice (20 points)
*Each question worth 2 points*

### Question 1: **a) O(1)**
**Explanation:** Inserting at the beginning of a singly linked list only requires creating a new node and updating two pointers (new node's next and head pointer). This operation doesn't depend on the list size.

### Question 2: **b) Stack**
**Explanation:** Stack follows LIFO principle - the last element added (pushed) is the first one removed (popped). Queue follows FIFO (First In, First Out).

### Question 3: **c) The upper bound of time complexity**
**Explanation:** Big-O notation describes the worst-case scenario or upper bound of an algorithm's time complexity as input size grows.

### Question 4: **c) O(n)**
**Explanation:** Each recursive call uses O(1) space but remains on the call stack. With n recursive calls, the total space complexity is O(n) for the call stack.

### Question 5: **c) Find a specific element**
**Explanation:** Finding a specific element requires traversing the list from head to the target element, which takes O(n) time in worst case. Insert/remove at head are O(1), and getting size is O(1) only if a size field is maintained.

### Question 6: **b) The first node**
**Explanation:** In a circular linked list, the last node points back to the first node, creating a circular structure with no null pointers.

### Question 7: **c) Bidirectional traversal**
**Explanation:** Doubly linked lists have both next and prev pointers, allowing traversal in both directions. This comes at the cost of additional memory usage.

### Question 8: **b) An exception should be thrown or the array resized**
**Explanation:** When an array-based queue becomes full, proper handling requires either throwing an exception or implementing dynamic resizing to maintain data integrity.

### Question 9: **b) Solving recurrence relations**
**Explanation:** The Master Theorem provides a method for solving recurrence relations of the form T(n) = aT(n/b) + f(n), commonly found in divide-and-conquer algorithms.

### Question 10: **c) ⌊log₂(n)⌋**
**Explanation:** The minimum height occurs in a complete binary tree, where height = ⌊log₂(n)⌋. For example, with 7 nodes, minimum height is ⌊log₂(7)⌋ = 2.

---

## Section II: Short Answer (25 points)

### Question 11 (5 points)
**Answer:**
An **Abstract Data Type (ADT)** is a mathematical model that defines a data type by its behavior (operations) without specifying implementation details. It describes what operations can be performed but not how they are implemented.

A **data structure** is a concrete implementation of an ADT that specifies how data is organized in memory and how operations are performed.

**Example:**
- **ADT**: Stack (with operations push, pop, peek, isEmpty)
- **Data Structure**: Array-based stack or linked-list-based stack

**Grading:**
- Clear distinction between ADT and data structure (2 points)
- Correct examples (2 points)
- Clear explanation (1 point)

### Question 12 (5 points)
**Answer:**
Given: T(n) = 2T(n/2) + n

Using Master Theorem form T(n) = aT(n/b) + f(n):
- a = 2
- b = 2  
- f(n) = n

Calculate n^(log_b(a)) = n^(log_2(2)) = n^1 = n

Since f(n) = n = Θ(n^(log_b(a))), this is **Case 2** of Master Theorem.

Therefore: **T(n) = Θ(n log n)**

**Grading:**
- Correct identification of a, b, f(n) (2 points)
- Correct case identification (2 points)
- Correct final answer (1 point)

### Question 13 (5 points)
**Advantages of Linked Lists:**
1. **Dynamic size** - can grow/shrink during runtime
2. **Efficient insertion/deletion** at known positions (O(1) if node reference available)
3. **Memory efficiency** - allocates memory as needed

**Disadvantages of Linked Lists:**
1. **No random access** - must traverse from head to reach elements (O(n))
2. **Memory overhead** - extra memory needed for storing pointers

**Grading:**
- Each correct advantage (1 point each, 3 total)
- Each correct disadvantage (1 point each, 2 total)

### Question 14 (5 points)
**Answer:**
a) Insert at the beginning: **O(1)**
b) Insert at the end (no tail pointer): **O(n)**
c) Delete a specific node (given only the data): **O(n)**
d) Find the middle element: **O(n)**
e) Reverse the entire list: **O(n)**

**Grading:**
- Each correct complexity (1 point each)

### Question 15 (5 points)
**Answer:**
A **circular array** implementation uses a fixed-size array where the queue "wraps around" when it reaches the end of the array. Two pointers (front and rear) track the queue boundaries, and when they reach the array end, they reset to index 0.

This approach avoids shifting elements when dequeuing, which would be O(n) operation. Instead, we simply move the front pointer, maintaining O(1) for both enqueue and dequeue operations.

**Grading:**
- Explanation of circular array concept (2 points)
- Explanation of why it's better than shifting (2 points)
- Mention of O(1) operations (1 point)

---

## Section III: Algorithm Analysis (20 points)

### Question 16 (10 points)
**Analysis:**
```java
public int mysteryAlgorithm(int[] arr, int n) {
    int count = 0;                    // O(1)
    for (int i = 0; i < n; i++) {     // Outer loop: n iterations
        for (int j = i + 1; j < n; j++) { // Inner loop: variable iterations
            if (arr[i] > arr[j]) {    // O(1)
                count++;              // O(1)
            }
        }
    }
    return count;                     // O(1)
}
```

**Detailed Analysis:**
- When i = 0: inner loop runs (n-1) times
- When i = 1: inner loop runs (n-2) times
- When i = 2: inner loop runs (n-3) times
- ...
- When i = n-1: inner loop runs 0 times

Total iterations = (n-1) + (n-2) + ... + 1 = n(n-1)/2 = (n² - n)/2

**Final Answer:** T(n) = **O(n²)**

**Grading:**
- Correct analysis of loop structure (4 points)
- Correct mathematical calculation (4 points)
- Correct Big-O notation (2 points)

### Question 17 (10 points)

**a) Time Complexity (5 points)**
The time complexity is **O(2ⁿ)** or **O(φⁿ)** where φ ≈ 1.618 (golden ratio).

**Reasoning:** Each call makes two recursive calls, creating a binary tree of recursive calls. The tree has approximately 2ⁿ nodes, leading to exponential time complexity. The algorithm recalculates the same values multiple times.

**Grading:**
- Correct complexity O(2ⁿ) or O(φⁿ) (3 points)
- Correct reasoning about exponential growth (2 points)

**b) Improvement (5 points)**
**Approach:** Use **dynamic programming** with memoization or bottom-up approach.

**Memoization example:**
- Store computed values in an array/map
- Check if value already computed before recursive call
- Return stored value if available

**Time Complexity:** O(n)
**Space Complexity:** O(n)

**Grading:**
- Mention of dynamic programming/memoization (3 points)
- Correct improved time complexity O(n) (2 points)

---

## Section IV: Implementation Problems (25 points)

### Question 18 (10 points)
**Answer:**
```java
public int findMax(ListNode head) {
    if (head == null) {
        throw new IllegalArgumentException("List cannot be empty");
    }
    
    int max = head.data;
    ListNode current = head.next;
    
    while (current != null) {
        if (current.data > max) {
            max = current.data;
        }
        current = current.next;
    }
    
    return max;
}
```

**Grading:**
- Correct algorithm logic (4 points)
- Proper initialization of max value (2 points)
- Correct loop structure and traversal (2 points)
- Proper handling of edge cases (2 points)

**Alternative recursive solution also acceptable:**
```java
public int findMax(ListNode head) {
    if (head == null) {
        throw new IllegalArgumentException("List cannot be empty");
    }
    
    if (head.next == null) {
        return head.data;
    }
    
    int maxOfRest = findMax(head.next);
    return Math.max(head.data, maxOfRest);
}
```

### Question 19 (15 points)
**Answer:**
```java
public class ArrayStack<T> {
    private T[] stack;
    private int top;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        this.capacity = size;
        this.stack = (T[]) new Object[size];
        this.top = -1;
    }
    
    public void push(T item) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow");
        }
        stack[++top] = item;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        T item = stack[top];
        stack[top--] = null; // Help GC
        return item;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == capacity - 1;
    }
}
```

**Grading:**
- Constructor implementation (3 points)
- Push method with error handling (3 points)
- Pop method with error handling (3 points)
- Peek method with error handling (2 points)
- isEmpty method (2 points)
- isFull method (2 points)

---

## Section V: Tree Traversals (10 points)

### Question 20 (10 points)
Given tree:
```
       A
      / \
     B   C
    / \   \
   D   E   F
  /
 G
```

**a) Preorder traversal (3 points):** **A, B, D, G, E, C, F**
**Explanation:** Visit root, then left subtree, then right subtree

**b) Inorder traversal (3 points):** **G, D, B, E, A, C, F**
**Explanation:** Visit left subtree, then root, then right subtree

**c) Postorder traversal (4 points):** **G, D, E, B, F, C, A**
**Explanation:** Visit left subtree, then right subtree, then root

**Grading:**
- Preorder: 3 points for completely correct sequence, 1 point for minor errors
- Inorder: 3 points for completely correct sequence, 1 point for minor errors  
- Postorder: 4 points for completely correct sequence, 2 points for minor errors

---

## Bonus Section (5 points)

### Bonus Question (5 points)
**Answer:**
**Amortized analysis** is a technique for analyzing the average time complexity of a sequence of operations, rather than the worst-case complexity of individual operations. It provides a more realistic performance measure when some operations are expensive but occur infrequently.

**Example:** Dynamic array (like ArrayList) resizing
- Most insertions are O(1)
- Occasionally, when array is full, insertion requires O(n) time to resize and copy elements
- Amortized analysis shows that over n insertions, the average time per insertion is still O(1)
- Even though some individual insertions are O(n), the expensive operations are rare enough that the overall average remains constant

**Other examples:** Splay trees, hash table resizing, union-find with path compression

**Grading:**
- Correct definition of amortized analysis (2 points)
- Appropriate example with explanation (2 points)  
- Clear understanding of why it's useful (1 point)

---

## Grade Distribution Guide

### A Range (90-100 points)
- Demonstrates mastery of fundamental concepts
- Correct implementation of algorithms
- Clear understanding of complexity analysis
- Minor errors only

### B Range (80-89 points)
- Good understanding of most concepts
- Generally correct implementations with minor issues
- Some difficulty with complexity analysis
- Few significant errors

### C Range (70-79 points)
- Basic understanding of concepts
- Implementation attempts show understanding but contain errors
- Limited grasp of complexity analysis
- Several significant errors

### D Range (60-69 points)
- Minimal understanding of concepts
- Implementations incomplete or largely incorrect
- Poor grasp of algorithmic principles
- Many significant errors

### F Range (<60 points)
- Insufficient demonstration of course concepts
- Major gaps in understanding
- Implementations largely missing or incorrect

---

## Common Student Errors to Watch For

### Multiple Choice
- Confusing time and space complexity
- Mixing up LIFO/FIFO principles
- Misunderstanding Big-O vs. exact complexity

### Short Answer
- Incomplete explanations of ADT vs. data structure
- Errors in Master Theorem application
- Missing advantages/disadvantages

### Algorithm Analysis
- Incorrect loop counting
- Forgetting about nested loop interactions
- Wrong Big-O conclusions

### Implementation
- Missing error handling
- Incorrect pointer manipulation
- Off-by-one errors in array indexing

### Tree Traversals
- Confusing traversal orders
- Skipping nodes or incorrect sequencing

Use this answer key to ensure consistent, fair grading across all student submissions.