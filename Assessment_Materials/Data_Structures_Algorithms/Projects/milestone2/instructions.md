# Milestone 2: Advanced ADT Extensions

**Due Date:** Week 11 (See course schedule)  
**Weight:** 10% of total course grade  
**Team Size:** 2-3 students  
**Estimated Time:** 15-20 hours per team member

---

## Overview

Building on your foundational data structures from Milestone 1, you will now implement four advanced Abstract Data Types (ADTs) that demonstrate sophisticated algorithmic concepts: Binary Search Trees (BST), AVL Trees, Binary Heaps, and Hash Tables. This milestone emphasizes both correct implementation and performance analysis, requiring you to bridge theory with empirical evidence.

## Learning Objectives

By completing this milestone, you will:

1. **Implement Self-Balancing Structures**: Build AVL trees with proper rotation algorithms
2. **Master Hash Table Design**: Implement collision resolution strategies and analyze load factors
3. **Apply Heap Properties**: Create efficient priority queue implementations
4. **Conduct Empirical Analysis**: Benchmark your implementations against theoretical predictions
5. **Practice Professional Documentation**: Create UML diagrams and technical reports

---

## Technical Requirements

### 1. Binary Search Tree (BST)

Implement a generic BST supporting the following operations:

#### Core Methods
```java
public class BST<T extends Comparable<T>> {
    // Construction
    public BST()
    
    // Core Operations
    public void insert(T data)
    public boolean remove(T data)
    public boolean contains(T data)
    public T findMin()
    public T findMax()
    
    // Traversals
    public List<T> inorderTraversal()
    public List<T> preorderTraversal()
    public List<T> postorderTraversal()
    
    // Analysis Methods
    public int size()
    public int height()
    public boolean isEmpty()
    
    // Advanced Features
    public T findKthSmallest(int k)  // 1-indexed
    public List<T> rangeQuery(T low, T high)
}
```

#### Implementation Requirements
- Handle duplicate values consistently (specify your policy in documentation)
- Implement iterative or recursive approaches (document your choice)
- Ensure all operations maintain BST property
- Include comprehensive edge case handling

### 2. AVL Tree (Self-Balancing BST)

Extend your BST implementation or create a new AVL tree class:

#### Additional Methods
```java
public class AVLTree<T extends Comparable<T>> extends BST<T> {
    // Balance factor management
    private int getHeight(Node node)
    private int getBalance(Node node)
    
    // Rotation operations
    private Node rotateRight(Node y)
    private Node rotateLeft(Node x)
    private Node rotateLeftRight(Node node)
    private Node rotateRightLeft(Node node)
    
    // Override with balancing logic
    @Override
    public void insert(T data)
    @Override
    public boolean remove(T data)
    
    // Verification methods
    public boolean isBalanced()
    public void printBalanceFactors()
}
```

#### Implementation Requirements
- Maintain balance factor for each node (-1, 0, or 1)
- Implement all four rotation types
- Ensure O(log n) height guarantee
- Provide balance verification methods for testing

### 3. Binary Heap (Priority Queue)

Implement both min-heap and max-heap variants:

#### Core Methods
```java
public class BinaryHeap<T extends Comparable<T>> {
    // Construction
    public BinaryHeap(boolean isMaxHeap)
    public BinaryHeap(List<T> initialData, boolean isMaxHeap)  // Heapify constructor
    
    // Core Operations
    public void insert(T data)
    public T extractRoot()  // removeMin() or removeMax()
    public T peekRoot()     // min() or max()
    
    // Utility Methods
    public int size()
    public boolean isEmpty()
    public void clear()
    
    // Advanced Features
    public void changePriority(T oldData, T newData)
    public List<T> heapSort()  // Returns sorted list, preserves original heap
    public boolean isValidHeap()  // Verification method
}
```

#### Implementation Requirements
- Use array-based implementation with proper indexing
- Implement both bubble-up and bubble-down operations
- Support both min-heap and max-heap configurations
- Include heapify constructor for O(n) construction from array

### 4. Hash Table

Implement a hash table with multiple collision resolution strategies:

#### Core Methods
```java
public class HashTable<K, V> {
    // Construction with collision strategy choice
    public HashTable(CollisionStrategy strategy)
    public HashTable(int initialCapacity, CollisionStrategy strategy)
    
    // Core Operations
    public void put(K key, V value)
    public V get(K key)
    public boolean remove(K key)
    public boolean containsKey(K key)
    
    // Capacity Management
    private void resize()
    public double getLoadFactor()
    public int getCapacity()
    public int size()
    
    // Analysis Methods
    public int getCollisions()
    public double getAverageProbeLength()
    public void printHashDistribution()
}

public enum CollisionStrategy {
    LINEAR_PROBING,
    QUADRATIC_PROBING,
    SEPARATE_CHAINING
}
```

#### Implementation Requirements
- Support all three collision resolution strategies
- Implement automatic resizing when load factor exceeds 0.75
- Provide comprehensive collision and performance statistics
- Use proper hash function (consider both built-in and custom options)

---

## Integration Requirements

### Project Integration Points

Your advanced ADTs must integrate meaningfully into your semester project. Choose **at least two** of the following integration scenarios:

1. **Search Optimization**: Use BST/AVL for efficient data lookups in your application
2. **Priority Management**: Implement a task scheduler or event queue using your heap
3. **Caching System**: Use hash table for fast data retrieval or memoization
4. **Data Processing Pipeline**: Combine multiple ADTs for complex data operations

### Integration Deliverables

1. **Use Case Documentation**: Explain why each ADT was chosen for specific application features
2. **Performance Justification**: Demonstrate how ADT choice improves application performance
3. **Integration Testing**: Show ADTs working within your larger application context

---

## Performance Analysis Requirements

### Benchmarking Suite

You must create comprehensive benchmarks measuring:

1. **Time Complexity Verification**
   - Test operations with datasets of size: 1K, 5K, 10K, 50K, 100K
   - Measure insertion, search, and deletion times
   - Compare results against theoretical O(log n), O(1), etc. predictions

2. **Space Complexity Analysis**
   - Measure memory usage for different data structure sizes
   - Compare space efficiency between implementations

3. **Collision Analysis** (Hash Tables)
   - Test hash distribution with different data types
   - Measure collision rates for different load factors
   - Compare collision resolution strategy performance

### Benchmark Implementation

Use the provided `benchmark_suite_template.java` as your starting point. Your benchmarks must:

- Run multiple trials and report average times
- Include both best-case and worst-case scenarios
- Test with different data types (integers, strings, custom objects)
- Generate data suitable for graphing and analysis

---

## Documentation Requirements

### 1. UML Class Diagrams

Create comprehensive UML diagrams showing:
- All four ADT classes with complete method signatures
- Inheritance relationships (BST → AVL)
- Integration points with your main application
- Use provided UML template as starting point

### 2. Complexity Report

Write a 4-6 page technical report including:

#### Section 1: Implementation Overview (1 page)
- Brief description of each ADT implementation
- Key design decisions and trade-offs
- Integration strategy with main project

#### Section 2: Theoretical Analysis (1-2 pages)
- Expected time/space complexity for each operation
- Comparison between BST and AVL performance characteristics
- Hash table load factor and collision strategy analysis

#### Section 3: Empirical Results (2-3 pages)
- Benchmark results with charts/graphs
- Comparison of measured vs. theoretical performance
- Analysis of any discrepancies or unexpected results
- Discussion of best-case vs. worst-case scenarios

#### Section 4: Conclusions and Reflection (1 page)
- Summary of key findings
- Lessons learned about algorithm performance
- Recommendations for real-world usage

---

## Submission Requirements

### Code Deliverables
```
milestone2/
├── src/
│   ├── datastructures/
│   │   ├── BST.java
│   │   ├── AVLTree.java
│   │   ├── BinaryHeap.java
│   │   └── HashTable.java
│   ├── benchmarks/
│   │   ├── BenchmarkSuite.java
│   │   └── PerformanceTimer.java
│   ├── tests/
│   │   ├── BSTTest.java
│   │   ├── AVLTest.java
│   │   ├── HeapTest.java
│   │   └── HashTableTest.java
│   └── integration/
│       └── ApplicationIntegration.java
├── docs/
│   ├── complexity_report.pdf
│   ├── uml_diagrams.pdf
│   └── integration_documentation.md
├── benchmarks/
│   ├── results_data.csv
│   └── performance_charts.png
└── README.md
```

### Submission Checklist
- [ ] All four ADT implementations complete and tested
- [ ] Comprehensive unit tests with >80% code coverage
- [ ] Benchmark suite with results for all required scenarios
- [ ] UML diagrams for all classes
- [ ] Complete complexity analysis report
- [ ] Integration with main project demonstrated
- [ ] All code properly documented with JavaDoc comments
- [ ] README with build and run instructions

---

## Grading Criteria

| Component | Weight | Description |
|-----------|--------|-------------|
| **Implementation Quality** | 40% | Correctness, efficiency, and code quality of all four ADTs |
| **Performance Analysis** | 25% | Comprehensive benchmarking and theoretical comparison |
| **Documentation** | 20% | UML diagrams, complexity report, and code documentation |
| **Integration** | 10% | Meaningful integration with semester project |
| **Testing** | 5% | Comprehensive unit tests and edge case coverage |

### Implementation Quality Rubric
- **Excellent (90-100%)**: All ADTs implemented correctly with optimal algorithms, excellent code quality, comprehensive error handling
- **Good (80-89%)**: Most functionality correct with minor bugs, good code structure, adequate error handling
- **Satisfactory (70-79%)**: Basic functionality works but with some bugs or suboptimal implementations
- **Needs Improvement (<70%)**: Major functionality missing or incorrect, poor code quality

---

## Getting Started

1. **Review Milestone 1**: Ensure your foundational structures are solid
2. **Choose Integration Points**: Decide which ADTs will enhance your application
3. **Start with BST**: Implement and test BST thoroughly before moving to AVL
4. **Implement Incrementally**: Complete one ADT fully before starting the next
5. **Test Early and Often**: Use unit tests to verify correctness at each step
6. **Begin Benchmarking Early**: Don't wait until the end to start performance analysis

## Resources

- **Course Textbook**: Goodrich, Tamassia, & Goldwasser, Chapters 8-11
- **Visualization Tools**: Use VisuAlgo or similar tools to verify your implementations
- **Benchmark Template**: See provided `benchmark_suite_template.java`
- **UML Template**: Use provided DrawIO template for consistency

## Questions and Help

- **Office Hours**: Tuesday/Thursday 1:00-3:00 PM
- **Lab Sessions**: Get help during Thursday lab time
- **Discussion Forum**: Post implementation questions (no code sharing)
- **Team Meetings**: Schedule regular check-ins with your team members

---

**Remember**: This milestone builds the foundation for your final project performance. Focus on correctness first, then optimization. Document your design decisions and be prepared to defend your implementation choices during the oral exit exam.

Good luck!