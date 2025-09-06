# Lab 4 TA Common Problems Guide
## Stack/Queue ADT Implementation - Data Structures & Algorithms

This guide helps TAs quickly identify and solve common issues students encounter during Lab 4. Stacks and queues introduce ADT concepts and array/linked implementation trade-offs that can challenge students.

---

## **ADT Concept Issues**

### 🔥 **Very Common Problems**

#### **Problem 1.1: Confusion Between ADT and Implementation**
**Symptoms:**
- Student asks "Which stack is better?" without context
- Mixes interface methods with implementation details
- Can't explain why same ADT has different implementations

**Teaching Approach:**
```
ADT = WHAT (the contract/interface)
- Stack: push(), pop(), peek() 
- Defines behavior, not how it works

Implementation = HOW (the actual code)
- ArrayStack: uses array internally
- LinkedStack: uses linked nodes internally
- Both provide same ADT behavior

Analogy: "Car" (ADT) vs "Honda Civic" vs "Tesla Model 3" (implementations)
```

**Quick Questions to Check Understanding:**
- "What operations does the Stack ADT provide?"
- "How is ArrayStack different from LinkedStack in behavior?" (Answer: They're not!)
- "When would you choose one implementation over another?"

#### **Problem 1.2: LIFO vs FIFO Confusion**
**Symptoms:**
- Student implements stack with FIFO behavior
- Queue that behaves like stack  
- Can't remember which is which

**Memory Aids:**
```
Stack = LIFO = "Last In, First Out"
- Like a stack of plates
- Only access the top plate
- Real examples: browser back button, undo functionality

Queue = FIFO = "First In, First Out"  
- Like a line at the grocery store
- First person in line is first to be served
- Real examples: print queue, task scheduling
```

**Quick Test:**
Have them trace: push(A), push(B), push(C), pop(), pop()
- **Stack result:** pop() returns C, then B (LIFO ✓)
- **Queue result:** dequeue() returns A, then B (FIFO ✓)

---

## **Array-Based Implementation Issues**

### 🔥 **Very Common Problems**

#### **Problem 2.1: ArrayStack - Wrong "Top" Location**
**Symptoms:**
- Student puts stack top at index 0
- Push/pop operations take O(n) time due to shifting
- Confused about why array implementation is slow

**Common Bug:**
```java
// INEFFICIENT - top at index 0
public void push(T item) {
    // Shift everything right first
    for (int i = size; i > 0; i--) {
        data[i] = data[i-1];  // O(n) operation!
    }
    data[0] = item;  // Put new item at "top"
    size++;
}
```

**Correct Approach:**
```java
// EFFICIENT - top at index size-1
public void push(T item) {
    if (size == capacity) resize();
    data[size] = item;  // O(1) operation!
    size++;
}
```

**Teaching Point:** "Which end of the array gives you O(1) access?"

#### **Problem 2.2: Circular Buffer Confusion in ArrayQueue**
**Symptoms:**
- Student doesn't understand modulo arithmetic
- Front/rear pointers get "stuck" or go out of bounds
- Queue stops working after wraparound

**Step-by-Step Teaching:**
```java
// Draw this on whiteboard:
capacity = 5, array = [_, _, _, _, _]
front = 0, rear = 0, size = 0

enqueue("A"): data[0] = "A", rear = 1
enqueue("B"): data[1] = "B", rear = 2  
enqueue("C"): data[2] = "C", rear = 3

dequeue(): return data[0], front = 1
dequeue(): return data[1], front = 2

enqueue("D"): data[3] = "D", rear = 4
enqueue("E"): data[4] = "E", rear = (4+1) % 5 = 0  // WRAPAROUND!
enqueue("F"): data[0] = "F", rear = 1

Array now: [F, _, C, D, E]
front = 2, rear = 1, size = 4
```

**Key Teaching Point:** "The array is circular - when you reach the end, wrap back to the beginning"

#### **Problem 2.3: Array Resizing Logic Errors**
**Symptoms:**
- Elements disappear during resize
- Wrong capacity after resize
- Circular buffer breaks after resize

**Common Bug in Queue Resize:**
```java
// BUGGY - doesn't handle circular buffer correctly
private void resize() {
    T[] newData = (T[]) new Object[capacity * 2];
    for (int i = 0; i < size; i++) {
        newData[i] = data[i];  // WRONG! Doesn't respect front/rear
    }
}

// CORRECT - copies in logical order
private void resize() {
    T[] newData = (T[]) new Object[capacity * 2];
    for (int i = 0; i < size; i++) {
        newData[i] = data[(front + i) % capacity];  // Correct order!
    }
    front = 0;
    rear = size;
    capacity *= 2;
    data = newData;
}
```

### 🟡 **Moderately Common Problems**

#### **Problem 2.4: Memory Leak Prevention**
**Symptoms:**
- Student doesn't set removed elements to null
- Confused about why this matters
- Memory usage grows even after popping elements

**Explanation:**
```java
// Without null assignment:
public T pop() {
    size--;
    return data[size];  // Element still referenced in array!
}

// With proper cleanup:
public T pop() {
    size--;
    T item = data[size];
    data[size] = null;  // Allow garbage collection
    return item;
}
```

**Teaching Point:** "Java's garbage collector can't clean up objects that are still referenced"

---

## **Linked Implementation Issues**

### 🔥 **Very Common Problems**

#### **Problem 3.1: LinkedStack - Add at Wrong End**
**Symptoms:**
- Student adds new elements at tail of linked list
- Push/pop operations become O(n) instead of O(1)
- Doesn't understand why linked implementation is slow

**Analysis:**
```java
// INEFFICIENT - add at tail
public void push(T item) {
    Node<T> newNode = new Node<>(item);
    if (head == null) {
        head = newNode;
    } else {
        Node<T> current = head;
        while (current.next != null) {  // O(n) traversal!
            current = current.next;
        }
        current.next = newNode;
    }
}

// EFFICIENT - add at head
public void push(T item) {
    Node<T> newNode = new Node<>(item);
    newNode.next = head;  // O(1) operation!
    head = newNode;
}
```

**Teaching Point:** "For O(1) operations, you need direct access. Where do you have direct access in a linked list?"

#### **Problem 3.2: LinkedQueue - Missing Tail Pointer**
**Symptoms:**
- Student tries to implement queue with only head pointer
- Enqueue becomes O(n) operation
- Doesn't understand why they need tail pointer

**Problem Code:**
```java
// INEFFICIENT - only head pointer
public void enqueue(T item) {
    Node<T> newNode = new Node<>(item);
    if (head == null) {
        head = newNode;
    } else {
        Node<T> current = head;
        while (current.next != null) {  // O(n) to find end!
            current = current.next;
        }
        current.next = newNode;
    }
}
```

**Correct Approach:**
```java
// EFFICIENT - both head and tail pointers
private Node<T> head;  // Front (dequeue here)
private Node<T> tail;  // Rear (enqueue here)

public void enqueue(T item) {
    Node<T> newNode = new Node<>(item);
    if (tail == null) {
        head = tail = newNode;  // First element
    } else {
        tail.next = newNode;    // O(1) add to end
        tail = newNode;
    }
}
```

#### **Problem 3.3: LinkedQueue - Head/Tail Update Errors**
**Symptoms:**
- Queue becomes corrupted after operations
- Null pointer exceptions in edge cases
- Single element operations fail

**Most Common Bug:**
```java
// BUGGY - doesn't handle single element removal
public T dequeue() {
    T item = head.data;
    head = head.next;      // What if this makes head null?
    size--;
    return item;
}

// CORRECT - handles all cases
public T dequeue() {
    if (isEmpty()) {
        throw new NoSuchElementException("Queue is empty");
    }
    T item = head.data;
    head = head.next;
    
    if (head == null) {    // Was the last element
        tail = null;       // Update tail too!
    }
    
    size--;
    return item;
}
```

**Teaching Point:** "When you remove the last element, both head AND tail become null"

### 🟡 **Moderately Common Problems**

#### **Problem 3.4: Pointer Update Sequence**
**Symptoms:**
- Links get broken during insertion/removal
- Lost references to nodes
- Operations work sometimes but not always

**Safe Update Pattern:**
```java
// For any pointer manipulation:
// 1. Store what you need first
// 2. Make new connections
// 3. Update main pointers last

public void enqueue(T item) {
    Node<T> newNode = new Node<>(item);
    
    // Step 1: Handle empty case first
    if (isEmpty()) {
        head = tail = newNode;
        return;
    }
    
    // Step 2: Make connections before updating pointers
    tail.next = newNode;   // Connect old tail to new node
    tail = newNode;        // Update tail pointer
}
```

---

## **Application Implementation Issues**

### 🔥 **Very Common Problems**

#### **Problem 4.1: Balanced Parentheses Logic Errors**
**Symptoms:**
- Returns true for unbalanced expressions
- Doesn't handle multiple bracket types
- Crashes on closing brackets when stack is empty

**Common Bug Patterns:**
```java
// BUG 1: Doesn't check if brackets match
if (c == ')' || c == ']' || c == '}') {
    if (stack.isEmpty()) return false;
    stack.pop();  // WRONG! Doesn't check what was popped
}

// BUG 2: Doesn't handle unmatched opening brackets
return true;  // WRONG! Should check if stack is empty

// CORRECT:
if (c == ')' || c == ']' || c == '}') {
    if (stack.isEmpty()) return false;
    char open = stack.pop();
    if (!matches(open, c)) return false;  // Check match!
}
return stack.isEmpty();  // Only balanced if no unmatched opens
```

#### **Problem 4.2: Text Editor Undo Implementation**
**Symptoms:**
- Undo doesn't work or works incorrectly
- Current state gets saved incorrectly
- Multiple undos don't work

**Common Issues:**
```java
// BUG: Saves state AFTER modification
public void type(String text) {
    currentText += text;
    undoStack.push(currentText);  // WRONG! Saves NEW state
}

// CORRECT: Save state BEFORE modification
public void type(String text) {
    undoStack.push(currentText);  // Save current state first
    currentText += text;          // Then modify
}
```

---

## **Performance Analysis Issues**

### 🟡 **Moderately Common Problems**

#### **Problem 5.1: Complexity Analysis Confusion**
**Symptoms:**
- Student thinks all operations are O(1)
- Doesn't understand amortized complexity
- Can't explain performance trade-offs

**Teaching Framework:**
```
Operation | ArrayStack | LinkedStack | ArrayQueue | LinkedQueue
----------|------------|-------------|------------|------------
Push/Enq  | O(1)*      | O(1)        | O(1)*      | O(1)
Pop/Deq   | O(1)       | O(1)        | O(1)       | O(1)
Peek/Front| O(1)       | O(1)        | O(1)       | O(1)
Space/elem| ~8 bytes   | ~16 bytes   | ~8 bytes   | ~16 bytes

*Amortized O(1) due to occasional resizing
```

**Key Teaching Points:**
- **Array implementations:** Better cache locality, less memory per element
- **Linked implementations:** No resizing needed, but more memory overhead
- **Amortized analysis:** Occasional O(n) resize doesn't affect average performance

#### **Problem 5.2: Use Case Decision Making**
**Symptoms:**
- Student can't decide which implementation to use
- Doesn't consider real-world constraints
- Focuses only on Big-O complexity

**Decision Framework:**
```
Choose Array-based when:
- Memory is limited
- Cache performance matters
- Size is predictable
- Need minimum overhead

Choose Linked-based when:
- Size varies dramatically
- Memory allocation is flexible
- Avoiding resize pauses is critical
- Easy implementation is priority
```

---

## **Quick Diagnostic Commands for TAs**

### **Test Basic Functionality:**
```java
// Quick stack test:
Stack<String> s = new ArrayStack<>();
s.push("A"); s.push("B"); s.push("C");
System.out.println(s.pop()); // Should print "C"

// Quick queue test:
Queue<String> q = new LinkedQueue<>();
q.enqueue("A"); q.enqueue("B"); q.enqueue("C");
System.out.println(q.dequeue()); // Should print "A"
```

### **Check LIFO/FIFO Behavior:**
```java
// This should demonstrate correct behavior:
for (int i = 1; i <= 3; i++) {
    stack.push(i);
    queue.enqueue(i);
}
// Stack pops: 3, 2, 1 (LIFO)
// Queue dequeues: 1, 2, 3 (FIFO)
```

### **Test Edge Cases:**
```java
// Empty structure operations (should throw exceptions):
try { emptyStack.pop(); } catch (EmptyStackException e) { /* OK */ }
try { emptyQueue.dequeue(); } catch (NoSuchElementException e) { /* OK */ }
```

---

## **Escalation Guidelines**

### **Handle Immediately:**
- Basic LIFO/FIFO implementation errors
- Array indexing and circular buffer confusion
- Pointer update sequence problems
- Simple performance complexity questions

### **Escalate to Instructor:**
- Fundamental misunderstanding of ADT concepts
- Student seems overwhelmed by multiple implementation types
- Deep theoretical questions about amortized analysis
- Complex debugging requiring extensive code rewrite

### **Document for Instructor:**
- Patterns in where students struggle with ADT vs implementation
- Common misconceptions about circular buffers
- Suggestions for improving starter code clarity
- Students who might need additional pointer/reference review

---

## **Time Management Tips**

### **Triage Strategy:**
1. **Quick fixes (2-3 min):** LIFO/FIFO direction errors, missing null checks
2. **Medium fixes (5-8 min):** Circular buffer logic, pointer sequence errors
3. **Complex issues (10+ min):** Complete ADT misunderstanding, application logic

### **When to Say "Office Hours":**
- Student needs fundamental review of ADT concepts
- Multiple interconnected implementation errors
- Struggling with both array AND linked approaches
- Complex application debugging beyond lab scope

### **Efficient Teaching:**
1. **Start with behavior:** "Show me what your stack/queue does"
2. **Check the basics:** "Is this LIFO or FIFO?"
3. **Focus on one implementation:** Don't try to fix array AND linked simultaneously
4. **Use visual aids:** Draw the data structure state

---

## **Key Teaching Moments**

### **When Stack Behaves Like Queue:**
- "Let's trace through push/pop operations step by step"
- "Where is the 'top' of your stack?"

### **When Circular Buffer Confuses:**
- "Let's draw the array and trace the front/rear pointers"
- "What happens when rear reaches the end of the array?"

### **When Performance Seems Wrong:**
- "Count the steps - how many operations does this take?"
- "Which end of the structure gives you direct access?"

### **When Applications Don't Work:**
- "What data do you need to save for undo?"
- "Is this a LIFO or FIFO problem?"

Remember: This lab introduces fundamental ADT concepts that students will use throughout the rest of the course. Take time to ensure they understand the interface vs implementation distinction!