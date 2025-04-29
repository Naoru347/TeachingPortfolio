# Milestone 2: Advanced ADT Extensions Instructions

**Due:** End of Week 11 (Friday 11:59 PM)  
**Weight:** 10 %  
**Folder:** `milestone2/`

---

## 1. Overview
In this milestone you’ll extend your core library with advanced abstract data types and evaluate their performance:

1. **Data Structures:**
   - `BinarySearchTree<T>` (insert, delete, search)
   - `AVLTree<T>` (self‑balancing via rotations)
   - `BinaryHeap<T>` + `PriorityQueue<T>`
   - `HashTable<K,V>` with **two** collision‑resolution strategies (e.g., chaining & open addressing)
2. **Benchmark Suite:** Automate timing for key operations across varying input sizes and patterns.
3. **UML Diagram:** Illustrate class hierarchy and relationships.
4. **Complexity Report:** Analyze empirical results vs. theory (2–3 pages).

---

## 2. Required Classes & API Signatures
Implement each class under `milestone2/src/edu/gwu/csc220/ds/` in Java. Use generics and throw appropriate exceptions.

### 2.1 BinarySearchTree<T>
```java
public class BinarySearchTree<T extends Comparable<T>> {
    public void insert(T value);
    public boolean contains(T value);
    public T delete(T value);       // Remove and return value if present
    public int size();
    public boolean isEmpty();
}
```

### 2.2 AVLTree<T>
```java
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    @Override public void insert(T value);  // maintain balance
    @Override public T delete(T value);    // maintain balance
    public int height();
}
```

### 2.3 BinaryHeap<T> & PriorityQueue<T>
```java
public class BinaryHeap<T extends Comparable<T>> {
    public void add(T value);
    public T poll();                // remove and return root
    public T peek();                // return root without removing
    public int size();
}

public class PriorityQueue<T extends Comparable<T>> {
    private BinaryHeap<T> heap;
    public void enqueue(T value);
    public T dequeue();
    public int size();
}
```

### 2.4 HashTable<K,V>
```java
public class HashTable<K,V> {
    public void put(K key, V value);
    public V get(K key);
    public V remove(K key);
    public boolean containsKey(K key);
    public int size();
    public enum CollisionStrategy { CHAINING, LINEAR_PROBING }
    // Constructor takes strategy, initial capacity, load-factor threshold
    public HashTable(CollisionStrategy strategy, int capacity, double loadFactor);
}
```

---

## 3. Benchmark Suite
Place your benchmark code in `milestone2/benchmarks/`:
- **Benchmark harness:** e.g., `BSTBenchmark.java`, `HashTableBenchmark.java` using `System.nanoTime()` or `java.time` for timing.
- **Data patterns:** Test random, sorted, reverse-sorted inputs of sizes: 1 k, 10 k, 100 k.
- **Repetitions:** Run each test ≥ 5 times and average results.
- **Output:** CSV or Markdown tables of timings; generate charts (e.g., via Excel or Java plotting library) and save under `benchmarks/`.

Include a brief `README.md` in `milestone2/benchmarks/` explaining how to run benchmarks:
```bash
javac -d bin $(find src -name "*Benchmark.java") -cp junit.jar
java -cp junit.jar:bin edu.gwu.csc220.benchmarks.BSTBenchmark
```

---

## 4. UML Diagram
- Use the provided `milestone2/uml_template.drawio` canvas.
- Export a PNG or PDF of your final class diagram and place it in `milestone2/docs/` as `class_hierarchy.png`.

---

## 5. Complexity Report
Use the template `milestone2/docs/complexity_report_template.md` to produce `milestone2/docs/complexity_report.md`.
Ensure you fill in:
- Experimental setup details
- Raw timing tables and visualization references
- Theoretical vs. empirical analysis table
- Conclusions & recommendations

---

## 6. Deliverables Checklist
Submit all items in `milestone2/`:
- **Source Code**: Java classes for BST, AVLTree, BinaryHeap, PriorityQueue, HashTable
- **Benchmark Suite**: Benchmark code, raw data tables, and chart images in `benchmarks/`
- **UML Diagram**: `docs/class_hierarchy.png`
- **Complexity Report**: `docs/complexity_report.md` (2–3 pages)
- **Milestone README**: `milestone2/README.md` with build, test, and run instructions
- **Peer Evaluation**: Completed form submitted via GitHub Issues

---

## 7. Submission Instructions
1. Create branch `milestone2`.
2. Commit all deliverables and push to origin.
3. Open a pull request titled “Milestone 2: Advanced ADT Extensions”.
4. Tag the merge commit with `milestone2`.
5. Ensure CI (if configured) passes and benchmarks run successfully.

Reach out via GitHub Issues or office hours with any questions. Good luck!

