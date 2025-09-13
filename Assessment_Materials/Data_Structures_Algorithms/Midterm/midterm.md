# CSC 220: Data Structures & Algorithms
## Midterm Examination

**Semester:** Fall 2025  
**Date:** Week 8  
**Duration:** 75 minutes  
**Total Points:** 100 points (15% of course grade)  
**Exam Type:** Closed book, individual work

---

## Instructions

- **Read all questions carefully** before beginning
- **Show your work** for all calculations and analysis
- **Write clearly** - illegible answers will not receive credit
- **Manage your time** - approximately 1 minute per point
- **No electronic devices** permitted except calculators
- **Ask questions** by raising your hand if clarification is needed

---

## Section I: Multiple Choice (20 points)
*Choose the best answer for each question. Each question is worth 2 points.*

### Question 1
What is the time complexity of inserting an element at the beginning of a singly linked list?
a) O(1)  
b) O(log n)  
c) O(n)  
d) O(n²)

### Question 2
Which data structure uses the LIFO (Last In, First Out) principle?
a) Queue  
b) Stack  
c) Linked List  
d) Array

### Question 3
In the context of algorithm analysis, what does "Big-O notation" represent?
a) The exact number of operations  
b) The best-case time complexity  
c) The upper bound of time complexity  
d) The average-case time complexity

### Question 4
What is the space complexity of a recursive algorithm that makes n recursive calls, each using O(1) additional space?
a) O(1)  
b) O(log n)  
c) O(n)  
d) O(n²)

### Question 5
Which of the following operations on a singly linked list requires O(n) time in the worst case?
a) Insert at head  
b) Remove from head  
c) Find a specific element  
d) Get the size (assuming a size variable is maintained)

### Question 6
In a circular linked list, what does the last node's next pointer reference?
a) null  
b) The first node  
c) The second node  
d) Itself

### Question 7
What is the primary advantage of a doubly linked list over a singly linked list?
a) Less memory usage  
b) Faster insertion at head  
c) Bidirectional traversal  
d) Better cache performance

### Question 8
For an array-based queue implementation, what happens when the queue becomes full?
a) Elements are overwritten  
b) An exception should be thrown or the array resized  
c) The oldest elements are automatically removed  
d) New elements are ignored silently

### Question 9
What is the Master Theorem used for?
a) Analyzing iterative algorithms  
b) Solving recurrence relations  
c) Implementing recursive data structures  
d) Optimizing memory usage

### Question 10
In a binary tree with n nodes, what is the minimum possible height?
a) 1  
b) log₂(n)  
c) ⌊log₂(n)⌋  
d) n-1

---

## Section II: Short Answer (25 points)
*Provide concise but complete answers. Show your work where applicable.*

### Question 11 (5 points)
Explain the difference between an Abstract Data Type (ADT) and a data structure. Provide one example of each.

**Answer:**
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________

### Question 12 (5 points)
Given the following recurrence relation, solve for T(n) using the Master Theorem:
T(n) = 2T(n/2) + n

Show your work and identify which case of the Master Theorem applies.

**Answer:**
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________

### Question 13 (5 points)
List three advantages and two disadvantages of using a linked list compared to an array for storing a sequence of elements.

**Advantages:**
1. _____________________________________________________________
2. _____________________________________________________________
3. _____________________________________________________________

**Disadvantages:**
1. _____________________________________________________________
2. _____________________________________________________________

### Question 14 (5 points)
Write the time complexity (Big-O notation) for each of the following operations on a singly linked list with n elements:

a) Insert at the beginning: _______________
b) Insert at the end (no tail pointer): _______________
c) Delete a specific node (given only the data): _______________
d) Find the middle element: _______________
e) Reverse the entire list: _______________

### Question 15 (5 points)
Explain what a "circular array" implementation means in the context of queues. Why is this approach used instead of shifting elements?

**Answer:**
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________

---

## Section III: Algorithm Analysis (20 points)
*Analyze the given algorithms and provide detailed explanations.*

### Question 16 (10 points)
Analyze the time complexity of the following algorithm. Show your work and provide the final Big-O notation.

```java
public int mysteryAlgorithm(int[] arr, int n) {
    int count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] > arr[j]) {
                count++;
            }
        }
    }
    return count;
}
```

**Analysis:**
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________

**Final Answer:** T(n) = _______________

### Question 17 (10 points)
Consider the following recursive algorithm:

```java
public int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n-1) + fibonacci(n-2);
}
```

a) (5 points) What is the time complexity of this algorithm? Explain your reasoning.

**Answer:**
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________

b) (5 points) How could you improve the time complexity of this algorithm? Describe the approach and its time complexity.

**Answer:**
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________

---

## Section IV: Implementation Problems (25 points)
*Write code solutions for the following problems.*

### Question 18 (10 points)
Implement a method to find the maximum element in a singly linked list. Assume the linked list stores integers and has at least one element.

```java
public class ListNode {
    int data;
    ListNode next;
    
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public int findMax(ListNode head) {
    // Your implementation here
    
    
    
    
    
    
    
}
```

### Question 19 (15 points)
Implement a stack using an array. Include the basic operations: push, pop, peek, isEmpty, and isFull. Handle appropriate error conditions.

```java
public class ArrayStack<T> {
    private T[] stack;
    private int top;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        // Your implementation here
        
        
        
    }
    
    public void push(T item) {
        // Your implementation here
        
        
        
        
    }
    
    public T pop() {
        // Your implementation here
        
        
        
        
    }
    
    public T peek() {
        // Your implementation here
        
        
        
    }
    
    public boolean isEmpty() {
        // Your implementation here
        
    }
    
    public boolean isFull() {
        // Your implementation here
        
    }
}
```

---

## Section V: Tree Traversals (10 points)
*Answer questions about binary tree operations.*

### Question 20 (10 points)
Given the following binary tree:

```
       A
      / \
     B   C
    / \   \
   D   E   F
  /
 G
```

a) (3 points) Write the **preorder** traversal sequence:
_______________________________________________

b) (3 points) Write the **inorder** traversal sequence:
_______________________________________________

c) (4 points) Write the **postorder** traversal sequence:
_______________________________________________

---

## Bonus Section (5 points)
*Optional - for extra credit only*

### Bonus Question (5 points)
Explain the concept of "amortized analysis" and provide a simple example of when it would be useful in analyzing data structure operations.

**Answer:**
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________

---

## Answer Sheet Summary
*For your reference - ensure all sections are completed*

- [ ] Section I: Multiple Choice (20 points)
- [ ] Section II: Short Answer (25 points)  
- [ ] Section III: Algorithm Analysis (20 points)
- [ ] Section IV: Implementation Problems (25 points)
- [ ] Section V: Tree Traversals (10 points)
- [ ] Bonus Section (5 points - optional)

**Total Points Available:** 100 + 5 bonus = 105 points maximum

---

## Grading Rubric

### Multiple Choice (20 points)
- **Each question:** 2 points for correct answer, 0 for incorrect

### Short Answer (25 points)
- **Complete and accurate answer:** Full points
- **Partially correct or missing details:** Partial credit
- **Incorrect or missing:** 0 points

### Algorithm Analysis (20 points)
- **Correct analysis with clear reasoning:** Full points
- **Correct answer with incomplete reasoning:** 75% credit
- **Incorrect analysis but some understanding shown:** 25-50% credit
- **No attempt or completely incorrect:** 0 points

### Implementation Problems (25 points)
- **Correct, complete implementation:** Full points
- **Minor errors or missing edge cases:** 80-90% credit
- **Major logical errors but some understanding:** 50-75% credit
- **Significant errors or incomplete:** 25-50% credit
- **No attempt:** 0 points

### Tree Traversals (10 points)
- **All sequences correct:** Full points
- **One sequence incorrect:** 7 points
- **Two sequences incorrect:** 4 points
- **All sequences incorrect:** 0 points

---

**END OF EXAM**

*Good luck! Remember to review your answers if time permits.*