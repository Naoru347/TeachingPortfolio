# Lab 4 – Stack/Queue ADT

## Overview
Welcome to your fourth Data Structures & Algorithms lab! This session introduces you to two fundamental Abstract Data Types (ADTs): stacks and queues. You'll implement both using different underlying data structures (arrays and linked lists) and explore their real-world applications.

Building on your linked list implementation from Lab 3, you'll see how basic data structures serve as building blocks for more specialized ADTs. This lab directly supports your semester project by providing essential components for many applications.

---

## Learning Objectives
By the end of this lab, you will be able to:
- Design and implement Stack and Queue ADT interfaces
- Implement stacks and queues using both array-based and linked-based approaches
- Analyze the trade-offs between different implementation strategies
- Apply LIFO (Last In, First Out) and FIFO (First In, First Out) principles correctly
- Use stacks and queues to solve real-world programming problems
- Evaluate when to choose stacks vs queues vs other data structures

---

## Pre-Lab Preparation (5 minutes)
**Before starting the exercises, ensure you have:**
- Completed Lab 3 (linked list implementation working properly)
- Downloaded `StackQueueStarter.java` and `StackQueueTester.java` from course LMS
- Reviewed textbook Chapter 6 (Stacks and Queues) sections 6.1-6.2
- Basic understanding of ADT vs implementation concepts

---

## Part 1: ADT Design and Interface Definition (15 minutes)

### **Exercise 1.1: Understanding ADTs vs Implementations (8 minutes)**

**Key Concept:** An Abstract Data Type (ADT) defines WHAT operations are available, while an implementation defines HOW those operations work.

**📝 Complete this comparison table:**

| Aspect | Stack ADT | Queue ADT | ArrayList ADT |
|--------|-----------|-----------|---------------|
| **Core Principle** | LIFO (Last In, First Out) | FIFO (First In, First Out) | Indexed Access |
| **Primary Operations** | push(), pop(), peek() | enqueue(), dequeue(), front() | add(), get(), set() |
| **Access Pattern** | Only top element | Only front and rear | Any element by index |
| **Real-world Analogy** | Stack of plates | Line at grocery store | _____________ |

### **Exercise 1.2: Interface Design Analysis (7 minutes)**

Examine the interfaces in your starter code:

```java
public interface Stack<T> {
    void push(T item);           // Add item to top
    T pop();                     // Remove and return top item
    T peek();                    // Return top item without removing
    boolean isEmpty();           // Check if stack is empty
    int size();                  // Return number of elements
}

public interface Queue<T> {
    void enqueue(T item);        // Add item to rear
    T dequeue();                 // Remove and return front item
    T front();                   // Return front item without removing
    boolean isEmpty();           // Check if queue is empty
    int size();                  // Return number of elements
}
```

**📝 Design Questions:**
1. **Why doesn't Stack have a `back()` method?**
   - Answer: _________________________________

2. **Why doesn't Queue have a `peek()` method?**
   - Answer: _________________________________

3. **What would happen if we added a `get(int index)` method to Stack?**
   - Answer: _________________________________

4. **Which operations should throw exceptions when called on empty structures?**
   - Stack: _________________________________
   - Queue: _________________________________

---

## Part 2: Array-Based Implementation (20 minutes)

### **Exercise 2.1: Array-Based Stack Implementation (12 minutes)**

Open `StackQueueStarter.java` and implement the `ArrayStack` class:

**Method 1: `push(T item)`**
```java
public void push(T item) {
    if (size == capacity) {
        // TODO: Handle array full case
        // HINT: Either resize array or throw exception
    }
    // TODO: Add item to top of stack
    // TODO: Update size
    
    // DESIGN CHOICE: Where is the "top" of your stack?
    // Option A: top = index 0, shift elements
    // Option B: top = end of array, just increment
    // Which is more efficient?
}
```

**Method 2: `pop()`**
```java
public T pop() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    // TODO: Get item from top
    // TODO: Update size and array
    // TODO: Return the item
    
    // IMPORTANT: Should you set the array slot to null? Why or why not?
}
```

**Method 3: `peek()`**
```java
public T peek() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    // TODO: Return top item without modifying stack
}
```

**Implementation Decision:** Where should the "top" of your stack be?
- **Option A:** `top = data[0]` (beginning of array)
- **Option B:** `top = data[size-1]` (end of array)

**📝 Analyze the trade-offs:**
- **Option A - Beginning:**
  - `push()` complexity: _____
  - `pop()` complexity: _____
  - Reason: _____

- **Option B - End:**
  - `push()` complexity: _____
  - `pop()` complexity: _____
  - Reason: _____

**Recommended Choice:** _____ because _____

### **Exercise 2.2: Array-Based Queue Implementation (8 minutes)**

Implement the `ArrayQueue` class. **Key Challenge:** Queues add at one end and remove from the other.

**Naive Approach Problem:**
```java
// INEFFICIENT - requires shifting elements
public T dequeue() {
    T item = data[0];              // Remove from front
    for (int i = 1; i < size; i++) {
        data[i-1] = data[i];       // Shift everything left - O(n)!
    }
    size--;
    return item;
}
```

**Circular Buffer Solution:**
```java
private T[] data;
private int front;    // Index of first element
private int rear;     // Index where next element will be added
private int size;
private int capacity;

public void enqueue(T item) {
    if (size == capacity) {
        // TODO: Handle full queue (resize or exception)
    }
    // TODO: Add item at rear position
    // TODO: Update rear index (handle wraparound)
    // TODO: Update size
    
    // HINT: rear = (rear + 1) % capacity;
}

public T dequeue() {
    if (isEmpty()) {
        throw new NoSuchElementException("Queue is empty");
    }
    // TODO: Get item from front position
    // TODO: Update front index (handle wraparound)
    // TODO: Update size
    // TODO: Return the item
    
    // HINT: front = (front + 1) % capacity;
}
```

**📝 Circular Buffer Understanding:**
If `capacity = 5`, trace through this sequence:
1. enqueue("A"), enqueue("B"), enqueue("C")
2. dequeue() → returns "A"
3. enqueue("D"), enqueue("E")
4. dequeue() → returns "B"
5. enqueue("F")

Draw the array state after each operation:
- After step 1: `front=___, rear=___, array=[_,_,_,_,_]`
- After step 2: `front=___, rear=___, array=[_,_,_,_,_]`
- After step 3: `front=___, rear=___, array=[_,_,_,_,_]`
- After step 4: `front=___, rear=___, array=[_,_,_,_,_]`
- After step 5: `front=___, rear=___, array=[_,_,_,_,_]`

---

## Part 3: Linked-Based Implementation (15 minutes)

### **Exercise 3.1: Linked Stack Implementation (8 minutes)**

Implement `LinkedStack` using your linked list knowledge from Lab 3:

```java
private Node<T> top;
private int size;

public void push(T item) {
    // TODO: Create new node
    // TODO: Link it to current top
    // TODO: Update top reference
    // TODO: Update size
    
    // QUESTION: Should you add at head or tail of linked list?
    // Consider: Which gives O(1) performance?
}

public T pop() {
    if (isEmpty()) {
        throw new EmptyStackException();
    }
    // TODO: Get data from top node
    // TODO: Update top to next node
    // TODO: Update size
    // TODO: Return the data
}
```

**📝 Design Decision:**
- **Add at head (beginning) of list:**
  - `push()` complexity: _____
  - `pop()` complexity: _____

- **Add at tail (end) of list:**
  - `push()` complexity: _____
  - `pop()` complexity: _____

**Which should you choose and why?** _____

### **Exercise 3.2: Linked Queue Implementation (7 minutes)**

Implement `LinkedQueue` with both head and tail pointers:

```java
private Node<T> head;   // Front of queue (dequeue here)
private Node<T> tail;   // Rear of queue (enqueue here)
private int size;

public void enqueue(T item) {
    Node<T> newNode = new Node<>(item);
    if (isEmpty()) {
        // TODO: Handle empty queue case
        // HINT: Both head and tail point to new node
    } else {
        // TODO: Add to tail and update tail pointer
    }
    // TODO: Update size
}

public T dequeue() {
    if (isEmpty()) {
        throw new NoSuchElementException("Queue is empty");
    }
    // TODO: Get data from head
    // TODO: Update head pointer
    // TODO: Handle single-element case
    // TODO: Update size
    // TODO: Return data
}
```

**📝 Complexity Analysis:**
- `enqueue()` complexity: _____ (Why?)
- `dequeue()` complexity: _____ (Why?)
- Space complexity per element: _____ (Why?)

---

## Part 4: Real-World Applications (10 minutes)

### **Exercise 4.1: Stack Applications**

Implement these stack-based solutions:

**Problem 1: Balanced Parentheses Checker**
```java
public static boolean isBalanced(String expression) {
    Stack<Character> stack = new ArrayStack<>();
    
    for (char c : expression.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            // TODO: Push opening bracket
        } else if (c == ')' || c == ']' || c == '}') {
            // TODO: Check if matches top of stack
            // TODO: Handle unmatched closing bracket
        }
    }
    
    // TODO: Return true if stack is empty (all matched)
    return false; // Placeholder
}
```

**Test Cases:**
- `isBalanced("()")` → should return `true`
- `isBalanced("([{}])")` → should return `true`
- `isBalanced("([)]")` → should return `false`
- `isBalanced("(()")` → should return `false`

**Problem 2: Undo Functionality**
```java
public class TextEditor {
    private Stack<String> undoStack = new LinkedStack<>();
    private String currentText = "";
    
    public void type(String text) {
        // TODO: Save current state to undo stack
        // TODO: Update current text
    }
    
    public void undo() {
        // TODO: Restore previous state from stack
        // TODO: Handle case where no undo available
    }
}
```

### **Exercise 4.2: Queue Applications**

**Problem 1: Print Job Scheduler**
```java
public class PrintQueue {
    private Queue<String> jobs = new LinkedQueue<>();
    
    public void submitJob(String jobName) {
        // TODO: Add job to queue
        System.out.println("Job submitted: " + jobName);
    }
    
    public void processNext() {
        // TODO: Process next job in FIFO order
        // TODO: Handle empty queue case
    }
}
```

**Problem 2: BFS Graph Traversal (Preview)**
```java
public List<String> breadthFirstSearch(Graph graph, String start) {
    Queue<String> toVisit = new ArrayQueue<>();
    Set<String> visited = new HashSet<>();
    List<String> result = new ArrayList<>();
    
    toVisit.enqueue(start);
    
    while (!toVisit.isEmpty()) {
        String current = toVisit.dequeue();
        if (!visited.contains(current)) {
            // TODO: Mark as visited and add to result
            // TODO: Add neighbors to queue
        }
    }
    
    return result;
}
```

---

## Part 5: Performance Analysis and Comparison (10 minutes)

### **Exercise 5.1: Implementation Comparison**

**📝 Complete this performance comparison table:**

| Operation | ArrayStack | LinkedStack | ArrayQueue | LinkedQueue |
|-----------|------------|-------------|------------|-------------|
| **Push/Enqueue** | O(1)* | O(1) | O(1)* | O(1) |
| **Pop/Dequeue** | O(1) | O(1) | O(1) | O(1) |
| **Peek/Front** | O(1) | O(1) | O(1) | O(1) |
| **Space per element** | ~8 bytes | ~16 bytes | ~8 bytes | ~16 bytes |
| **Memory locality** | Excellent | Poor | Excellent | Poor |
| **Resize cost** | O(n) | N/A | O(n) | N/A |

*Amortized O(1) with dynamic resizing

### **Exercise 5.2: Use Case Decision Matrix**

**📝 For each scenario, choose the best implementation and explain:**

1. **Stack for browser back button (frequent push/pop, memory critical):**
   - Choice: _____________
   - Reason: _____________

2. **Queue for server request handling (millions of requests, predictable size):**
   - Choice: _____________
   - Reason: _____________

3. **Stack for recursive algorithm (unknown depth, occasional very deep recursion):**
   - Choice: _____________
   - Reason: _____________

4. **Queue for real-time streaming (continuous flow, memory bandwidth important):**
   - Choice: _____________
   - Reason: _____________

---

## Deliverable

Submit a **single ZIP file** containing:

1. **Complete Implementation:**
   - `ArrayStack.java` and `LinkedStack.java` fully implemented
   - `ArrayQueue.java` and `LinkedQueue.java` fully implemented
   - All application examples working

2. **Analysis Document (PDF):**
   - Completed comparison tables and performance analysis
   - Use case decision matrix with explanations
   - Circular buffer trace from Exercise 2.2
   - Reflection on ADT design principles

3. **Testing Evidence:**
   - Screenshots or text output of all tests passing
   - Evidence of application examples working correctly

**File Naming Convention:** `Lab4_Lastname_Firstname.zip`

**Submission Method:** Upload to course LMS under "Lab 4 Submission"

---

## Assessment Criteria

| Category | Weight | Description |
|----------|--------|-------------|
| **Implementation Correctness** | 40% | All four data structures work correctly |
| **Code Quality** | 25% | Clean code, proper error handling, efficient algorithms |
| **ADT Understanding** | 20% | Correct interface usage and design principles |
| **Analysis Quality** | 15% | Thoughtful performance analysis and use case reasoning |

---

## Looking Ahead to Project Integration

**Week 5 Project Milestone:**
You'll integrate stack and queue components into your semester project. Consider:
- **Which ADTs does your project need?** (Undo functionality? Task queues? Navigation history?)
- **What implementation approach fits your performance requirements?**
- **How will you test these components within your larger application?**

**Common Project Applications:**
- **Calculator apps:** Stack for expression evaluation
- **Game engines:** Queue for event processing
- **Text editors:** Stack for undo/redo functionality
- **Web browsers:** Stack for navigation history
- **Server applications:** Queue for request handling

---

## Troubleshooting Tips

**Array Resizing Issues:**
- Always create new array with larger capacity
- Copy all existing elements to new array
- Update capacity variable
- Consider growth strategy (double vs increment)

**Circular Buffer Confusion:**
- Draw pictures showing front/rear positions
- Use modulo arithmetic: `(index + 1) % capacity`
- Remember that `rear` points to next empty slot
- Handle full vs empty queue detection

**Linked Implementation Memory Leaks:**
- Set removed node references to null
- Be careful with head/tail updates in edge cases
- Handle single-element removal properly

---

## Optional Extensions

**For students who finish early:**

1. **Implement deque (double-ended queue)** with both array and linked versions
2. **Add iterator support** for enhanced for-loops
3. **Implement priority queue** using heap or sorted array
4. **Create stack-based calculator** for arithmetic expressions
5. **Build queue-based simulation** (e.g., bank teller, traffic light)

---

## Next Week Preview

In Lab 5, you'll explore recursion and see how stacks are used internally by programming languages to manage function calls. Understanding stacks thoroughly will make recursive algorithm design much more intuitive.