# Lab 3 – List Implementation

## Overview
Welcome to your third Data Structures & Algorithms lab! This session moves beyond array-based structures to explore the fundamental concept of linked data structures. You'll implement both singly and doubly linked lists, understanding when and why to choose linked structures over arrays.

This lab directly supports your semester project by giving you practical experience with dynamic memory allocation, pointer manipulation, and the trade-offs between different linear data structures. By the end, you'll have a solid foundation for building more complex structures like stacks, queues, and trees.

---

## Learning Objectives
By the end of this lab, you will be able to:
- Implement singly and doubly linked list data structures from scratch
- Perform core linked list operations: insertion, deletion, and traversal
- Analyze the time and space complexity of linked list operations
- Compare linked lists with array-based structures for different use cases
- Apply proper memory management and pointer manipulation techniques
- Test linked list implementations thoroughly using systematic approaches

---

## Pre-Lab Preparation (5 minutes)
**Before starting the exercises, ensure you have:**
- Completed Labs 1 & 2 (environment and complexity analysis)
- Downloaded `LinkedListStarter.java` and `LinkedListTester.java` from course LMS
- Reviewed textbook Chapter 3 (Linked Lists) sections 3.1-3.3
- Notebook ready for complexity analysis notes

---

## Part 1: Understanding Linked List Concepts (15 minutes)

### **Exercise 1.1: Memory Layout Analysis (8 minutes)**

**Concept Review:**
Arrays store elements in contiguous memory locations, while linked lists store elements in nodes scattered throughout memory, connected by references (pointers).

**📝 Compare these representations:**

**Array Layout:**
```
Memory:   [100][101][102][103][104]
Elements:  [A] [B] [C] [D] [E]
```

**Linked List Layout:**
```
Memory:   [A|150] -> [B|203] -> [C|075] -> [D|188] -> [E|null]
Address:   100       150       203       075       188
```

**Analysis Questions:**
1. **Access Time:** How long does it take to find the element at position 3?
   - Array: _____ (Big-O complexity)
   - Linked List: _____ (Big-O complexity)

2. **Insertion at Beginning:** How long to insert a new element at position 0?
   - Array: _____ (Big-O complexity + why)
   - Linked List: _____ (Big-O complexity + why)

3. **Memory Usage:** Compare memory overhead for storing 1000 integers
   - Array: _____ bytes total
   - Linked List: _____ bytes total (assume 8-byte pointers)

### **Exercise 1.2: Node Structure Design (7 minutes)**

Examine the node classes in your starter code:

```java
// Singly Linked Node
class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data) { this.data = data; }
}

// Doubly Linked Node  
class DoublyNode<T> {
    T data;
    DoublyNode<T> next;
    DoublyNode<T> prev;
    
    public DoublyNode(T data) { this.data = data; }
}
```

**📝 Draw the memory representation of:**
1. A 3-node singly linked list: "A" -> "B" -> "C"
2. A 3-node doubly linked list: "A" <-> "B" <-> "C"

**Design Questions:**
- Why does DoublyNode need both `next` and `prev` references?
- What are the trade-offs between singly and doubly linked lists?
- When would you choose each type?

---

## Part 2: Singly Linked List Implementation (25 minutes)

### **Exercise 2.1: Basic Operations Implementation (15 minutes)**

Open `LinkedListStarter.java` and implement the `SinglyLinkedList` class methods:

**Method 1: `addFirst(T data)`**
```java
public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    // TODO: Connect the new node to the existing list
    // TODO: Update head reference
    // TODO: Update size
}
```

**Method 2: `addLast(T data)`**
```java
public void addLast(T data) {
    Node<T> newNode = new Node<>(data);
    if (head == null) {
        // TODO: Handle empty list case
    } else {
        // TODO: Traverse to end and add new node
    }
    // TODO: Update size
}
```

**Method 3: `removeFirst()`**
```java
public T removeFirst() {
    if (head == null) {
        throw new NoSuchElementException("List is empty");
    }
    // TODO: Store data to return
    // TODO: Update head reference
    // TODO: Update size
    // TODO: Return stored data
}
```

**Method 4: `get(int index)`**
```java
public T get(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    // TODO: Traverse to the correct position
    // TODO: Return the data
}
```

### **Exercise 2.2: Testing Your Implementation (10 minutes)**

Use the `LinkedListTester.java` to verify your implementation:

```java
public static void testSinglyLinkedList() {
    SinglyLinkedList<String> list = new SinglyLinkedList<>();
    
    // Test adding elements
    list.addFirst("B");
    list.addFirst("A");
    list.addLast("C");
    
    // Should print: A -> B -> C
    System.out.println("List: " + list);
    
    // Test access
    System.out.println("Element at index 1: " + list.get(1)); // Should be "B"
    
    // Test removal
    String removed = list.removeFirst();
    System.out.println("Removed: " + removed); // Should be "A"
    System.out.println("List after removal: " + list); // Should be B -> C
}
```

**📝 Record your test results:**
- Does `addFirst()` work correctly? ______
- Does `addLast()` work correctly? ______
- Does `get()` return correct elements? ______
- Does `removeFirst()` work correctly? ______

---

## Part 3: Doubly Linked List Implementation (20 minutes)

### **Exercise 3.1: Advanced Operations (15 minutes)**

Implement the `DoublyLinkedList` class methods:

**Method 1: `addFirst(T data)`**
```java
public void addFirst(T data) {
    DoublyNode<T> newNode = new DoublyNode<>(data);
    if (head == null) {
        // TODO: Handle empty list case
        // TODO: Set both head and tail
    } else {
        // TODO: Connect new node to existing head
        // TODO: Update previous pointers
        // TODO: Update head reference
    }
    // TODO: Update size
}
```

**Method 2: `removeLast()`**
```java
public T removeLast() {
    if (tail == null) {
        throw new NoSuchElementException("List is empty");
    }
    // TODO: Store data to return
    if (size == 1) {
        // TODO: Handle single element case
    } else {
        // TODO: Update tail and previous pointers
    }
    // TODO: Update size
    // TODO: Return stored data
}
```

**Method 3: `insert(int index, T data)`**
```java
public void insert(int index, T data) {
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    
    if (index == 0) {
        addFirst(data);
    } else if (index == size) {
        addLast(data);
    } else {
        // TODO: Traverse to insertion point
        // TODO: Create new node and update all pointers
        // TODO: Update size
    }
}
```

### **Exercise 3.2: Bidirectional Traversal (5 minutes)**

Implement methods that take advantage of the doubly linked structure:

**Forward Iteration:**
```java
public void printForward() {
    DoublyNode<T> current = head;
    while (current != null) {
        System.out.print(current.data + " ");
        current = current.next;
    }
    System.out.println();
}
```

**Backward Iteration:**
```java
public void printBackward() {
    // TODO: Start from tail and traverse using prev pointers
}
```

**📝 Test bidirectional traversal:**
Create a list: "A" <-> "B" <-> "C"
- Forward traversal should print: A B C
- Backward traversal should print: C B A

---

## Part 4: Performance Analysis and Comparison (10 minutes)

### **Exercise 4.1: Operation Complexity Analysis**

**📝 Complete this complexity comparison table:**

| Operation | Array | Singly Linked | Doubly Linked | Explanation |
|-----------|-------|---------------|---------------|-------------|
| Access by index | O(1) | O(n) | O(n) | Arrays have direct access |
| Insert at beginning | O(n) | O(1) | O(1) | |
| Insert at end | O(1)* | O(n) | O(1) | |
| Insert at middle | O(n) | O(n) | O(n) | |
| Remove from beginning | O(n) | O(1) | O(1) | |
| Remove from end | O(1) | O(n) | O(1) | |
| Memory per element | 4-8 bytes | 12-16 bytes | 16-24 bytes | |

*Assuming dynamic array with occasional resizing

### **Exercise 4.2: Use Case Analysis**

**📝 For each scenario, choose the best data structure and explain why:**

1. **Undo functionality in a text editor** (frequent additions/removals at one end)
   - Choice: ______
   - Reason: ______

2. **Music playlist with skip forward/backward** (bidirectional navigation)
   - Choice: ______
   - Reason: ______

3. **Student grade lookup by ID number** (frequent random access)
   - Choice: ______
   - Reason: ______

4. **Browser history with back/forward buttons** (bidirectional, frequent end operations)
   - Choice: ______
   - Reason: ______

---

## Part 5: Integration and Testing (5 minutes)

### **Exercise 5.1: Comprehensive Testing**

Run the full test suite in `LinkedListTester.java`:

```java
public static void runAllTests() {
    System.out.println("=== Singly Linked List Tests ===");
    testSinglyLinkedList();
    
    System.out.println("\n=== Doubly Linked List Tests ===");
    testDoublyLinkedList();
    
    System.out.println("\n=== Performance Comparison ===");
    comparePerformance();
}
```

**📝 Record any test failures and fix them:**
- Test failures: ______
- Fixes applied: ______

---

## Deliverable

Submit a **single ZIP file** containing:

1. **Complete Implementation:**
   - `SinglyLinkedList.java` with all methods implemented
   - `DoublyLinkedList.java` with all methods implemented
   - Your test results and any additional test methods

2. **Analysis Document (PDF):**
   - Completed complexity comparison table
   - Use case analysis with explanations
   - Memory layout drawings from Part 1
   - Reflection on when to choose linked lists vs arrays

3. **Testing Evidence:**
   - Screenshot or text file of your test output
   - Documentation of any bugs found and fixed

**File Naming Convention:** `Lab3_Lastname_Firstname.zip`

**Submission Method:** Upload to course LMS under "Lab 3 Submission"

---

## Assessment Criteria

| Category | Weight | Description |
|----------|--------|-------------|
| **Implementation Correctness** | 40% | Both linked list classes work correctly for all operations |
| **Code Quality** | 25% | Clean code, proper error handling, good variable names |
| **Complexity Analysis** | 20% | Accurate Big-O analysis and thoughtful use case reasoning |
| **Testing Thoroughness** | 15% | Comprehensive testing and proper bug documentation |

---

## Looking Ahead to Project 1

**Week 4 Project Integration:**
Next week you'll integrate your LinkedList implementation into your semester project. Consider:
- Which type of linked list best fits your project needs?
- What additional methods might your project require?
- How will you test linked list functionality within your larger application?

**Preparation for Week 4:**
- Review your project requirements document
- Identify where linked lists could replace or supplement array-based storage
- Consider how linked lists might improve performance for your specific use cases

---

## Troubleshooting Tips

**NullPointerException Issues:**
- Always check if `head` or `tail` is null before dereferencing
- Initialize new nodes properly before linking them
- Update all relevant pointers when adding/removing nodes

**Infinite Loop Problems:**
- Make sure `next` pointers eventually lead to null
- Be careful with circular references in doubly linked lists
- Use debugger to trace through pointer updates step by step

**Size Tracking Errors:**
- Increment size for every successful add operation
- Decrement size for every successful remove operation  
- Remember that insert operations should also update size

---

## Optional Extensions

**For students who finish early:**

1. **Implement `remove(int index)` for both list types**
2. **Add iterator support** for enhanced for-loops
3. **Implement `reverse()` method** for singly linked list
4. **Create circular linked list variant**
5. **Add memory usage monitoring** to compare with ArrayList

---

## Next Week Preview

In Lab 4, you'll use your linked list implementation to build stacks and queues, exploring how basic data structures serve as building blocks for more specialized ADTs. Understanding linked lists thoroughly will make stack and queue implementation much more intuitive.