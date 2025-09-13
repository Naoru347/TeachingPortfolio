# Milestone 1: Core DS Library Instructions

**Due:** End of Week 6 (Friday 11:59 PM)
**Weight:** 10 %
**Folder:** `milestone1/`

---

## 1. Overview
In this first milestone, you will implement and test the core data structures that form the foundation of our library:

- **Linked Lists:** `SinglyLinkedList`, `DoublyLinkedList`, `CircularLinkedList`
- **Linear ADTs:** `Stack`, `Queue` (both array-backed and list-backed)

Your deliverables include clean, documented Java classes, unit tests demonstrating ≥ 80 % coverage, and a brief design document.

---

## 2. Required Classes & API Signatures

### 2.1 SinglyLinkedList<T>
```java
public class SinglyLinkedList<T> {
    public void add(T value);
    public void add(int index, T value);
    public T get(int index);
    public T remove(int index);
    public int size();
    public boolean isEmpty();
    public void clear();
}
```

### 2.2 DoublyLinkedList<T>
```java
public class DoublyLinkedList<T> {
    public void addFirst(T value);
    public void addLast(T value);
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public int size();
    public boolean contains(T value);
}
```

### 2.3 CircularLinkedList<T>
```java
public class CircularLinkedList<T> {
    public void add(T value);
    public T remove(int index);
    public T get(int index);
    public void rotate();  // move head to next node
    public int size();
}
```

### 2.4 Stack<T>
```java
public class Stack<T> {
    public void push(T value);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public int size();
}
```

### 2.5 Queue<T>
```java
public class Queue<T> {
    public void enqueue(T value);
    public T dequeue();
    public T peek();
    public boolean isEmpty();
    public int size();
}
```

---

## 3. Required Behaviors & Constraints
- **Null safety:** Throw `IllegalArgumentException` if `null` is passed where `T` is not allowed.
- **Index validation:** Throw `IndexOutOfBoundsException` for invalid indices.
- **Performance:** Each operation must run in O(1) or O(n) as appropriate—document expected complexity.
- **Thread-safety:** Not required; single-threaded context.

---

## 4. Deliverables Checklist
Submit all of the following items in your `milestone1/` directory:

- **Source Code** (`milestone1/src/edu/gwu/csc220/ds/`):
  - `SinglyLinkedList.java`
  - `DoublyLinkedList.java`
  - `CircularLinkedList.java`
  - `Stack.java`
  - `Queue.java`
- **Unit Tests** (`milestone1/tests/`):
  - JUnit 5 test classes covering each data structure
  - Overall test coverage ≥ 80%
- **Design Document** (`milestone1/docs/design_doc.md`): 3–4 pages including:
  - ADT interface definitions and UML diagrams (optional)
  - Internal representation descriptions
  - Big-O complexity analysis table for all methods
- **Milestone README** (`milestone1/README.md`):
  - Compilation instructions
  - Usage examples for each implemented class
- **Peer Evaluation**: Completed form submitted via GitHub Issues (see `/docs/peer_evaluation_form.pdf`)

## 5. Submission Instructions. Submission Instructions
1. Create branch `milestone1`.
2. Commit all deliverables and push to origin.
3. Open a pull request titled “Milestone 1: Core DS Library”.
4. Tag the merge commit with `milestone1`.
5. Confirm that CI (if configured) passes and coverage is adequate.

Good luck! Reach out via GitHub Issues or office hours if you encounter blockers.

