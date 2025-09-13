# Lab 7: Binary Search Tree Implementation

## Overview
**Week:** 9  
**Due Date:** Thursday of Week 9, 11:59 PM  
**Points:** 100 points  
**Estimated Time:** 4-6 hours

This lab focuses on implementing a complete Binary Search Tree (BST) with core operations including insertion, deletion, search, and traversals. You'll also conduct performance analysis to understand the practical implications of BST operations under different scenarios.

---

## Learning Objectives

By the end of this lab, you will be able to:

1. **Implement BST Operations**
   - Design and implement recursive insertion, deletion, and search algorithms
   - Handle edge cases including empty trees and single-node scenarios

2. **Tree Traversal Mastery**
   - Implement in-order, pre-order, and post-order traversals
   - Understand the relationship between in-order traversal and sorted output

3. **Algorithm Analysis**
   - Analyze time complexity for best, average, and worst-case scenarios
   - Understand the impact of tree balance on performance

4. **Software Engineering Practices**
   - Write comprehensive unit tests for tree operations
   - Apply debugging strategies for recursive data structures

---

## Prerequisites

Before starting this lab, ensure you understand:
- Binary tree terminology (root, leaf, parent, child, height, depth)
- Recursive algorithm design
- Basic tree traversal concepts from Lab 6
- Big-O notation and algorithm analysis

---

## Part 1: BST Node Implementation (15 minutes)

### Step 1.1: Examine the Starter Code
Review the provided `BSTNode.java` file. This class represents individual nodes in your BST.

**Key Components:**
- `data`: The value stored in the node
- `left`: Reference to the left child
- `right`: Reference to the right child
- Basic constructor and getter methods

### Step 1.2: Understand the BST Property
**BST Invariant:** For any node `n`:
- All values in the left subtree ≤ `n.data`
- All values in the right subtree > `n.data`
- Both left and right subtrees are also valid BSTs

---

## Part 2: Core BST Operations (90 minutes)

### Step 2.1: Implement Search (20 minutes)

Complete the `search(int value)` method in `BST.java`.

**Algorithm:**
1. Start at root
2. If current node is null, return false
3. If value equals current node's data, return true
4. If value < current node's data, search left subtree
5. If value > current node's data, search right subtree

**Testing:** Use the provided test cases to verify your implementation.

### Step 2.2: Implement Insertion (25 minutes)

Complete the `insert(int value)` method.

**Algorithm:**
1. If tree is empty, create new root
2. Use recursive helper to find insertion point
3. Maintain BST property during insertion
4. Handle duplicate values according to specification

**Edge Cases to Consider:**
- Inserting into empty tree
- Inserting duplicate values
- Inserting values that create unbalanced tree

### Step 2.3: Implement Traversals (25 minutes)

Complete all three traversal methods:
- `inOrderTraversal()`: Left → Root → Right
- `preOrderTraversal()`: Root → Left → Right  
- `postOrderTraversal()`: Left → Right → Root

**Note:** In-order traversal of a BST should return values in sorted order.

### Step 2.4: Implement Deletion (20 minutes)

Complete the `delete(int value)` method. This is the most complex BST operation.

**Three Cases:**
1. **Node with no children:** Simply remove the node
2. **Node with one child:** Replace node with its child
3. **Node with two children:** Replace with in-order successor (or predecessor)

**In-order Successor:** The smallest value in the right subtree

---

## Part 3: Performance Analysis (45 minutes)

### Step 3.1: Understand Test Scenarios

You'll analyze BST performance under three scenarios:

1. **Best Case:** Balanced tree with random insertions
2. **Average Case:** Mixed operations on moderately balanced tree
3. **Worst Case:** Degenerate tree (essentially a linked list)

### Step 3.2: Complete Performance Tests

In `PerformanceAnalysis.java`, implement:
- `measureInsertionTime()`: Time insertion of n elements
- `measureSearchTime()`: Time search operations
- `measureDeletionTime()`: Time deletion operations

### Step 3.3: Data Collection

Run tests with different dataset sizes: 100, 500, 1000, 5000 elements

**Expected Results:**
- **Balanced BST:** O(log n) operations
- **Degenerate BST:** O(n) operations

### Step 3.4: Analysis Report

Create a brief report (2-3 paragraphs) analyzing your results:
- Compare performance across different scenarios
- Explain why worst-case performance degrades
- Discuss implications for real-world applications

---

## Part 4: Integration with Semester Project (30 minutes)

### Step 4.1: Project Integration
Consider how your BST implementation could enhance your semester project:
- Fast lookup operations for user data
- Sorted data retrieval
- Efficient range queries

### Step 4.2: Design Considerations
Document in your lab report:
- Where BST could improve your project's performance
- What data would benefit from BST organization
- Potential limitations of basic BST vs. balanced alternatives

---

## Testing Requirements

### Unit Tests (Required)
Your `BSTTest.java` should include tests for:

**Search Tests:**
- Search in empty tree
- Search for existing values
- Search for non-existing values

**Insertion Tests:**
- Insert into empty tree
- Insert multiple values
- Insert duplicate values
- Insert values creating left-heavy tree
- Insert values creating right-heavy tree

**Deletion Tests:**
- Delete from empty tree
- Delete leaf nodes
- Delete nodes with one child
- Delete nodes with two children
- Delete root node

**Traversal Tests:**
- Verify in-order gives sorted output
- Compare traversal outputs for known tree structure

### Performance Tests (Required)
- Benchmark all three scenarios (best, average, worst)
- Test with multiple dataset sizes
- Document timing results

---

## Submission Requirements

Submit the following files to GitHub Classroom:

1. **`BST.java`** - Your complete BST implementation
2. **`BSTTest.java`** - Comprehensive unit tests
3. **`PerformanceAnalysis.java`** - Performance testing code
4. **`lab7_report.md`** - Analysis report and project integration discussion
5. **`performance_results.txt`** - Raw timing data from your tests

### Repository Organization
```
lab7-bst-[username]/
├── src/
│   ├── BST.java
│   ├── BSTTest.java
│   └── PerformanceAnalysis.java
├── data/
│   └── performance_results.txt
├── lab7_report.md
└── README.md
```

---


---

## Assessment Rubric

| **Criteria** | **Excellent** | **Good** | **Satisfactory** | **Needs Improvement** | **Points** |
|--------------|---------------|----------|------------------|------------------------|-------------|
| **Core Functionality (40%)** | 36–40 pts: All BST operations (insert, delete, search, traversals) implemented correctly; handles all edge cases; maintains BST invariant; performance analysis code fully functional | 32–35 pts: Most operations correct with minor issues; handles most edge cases; invariant mostly maintained; performance analysis mostly functional | 28–31 pts: Core operations present but buggy in edge cases; invariant occasionally violated; performance analysis partially implemented | 0–27 pts: Major functionality missing/incorrect; invariant frequently violated; performance analysis non-functional | **/40** |
| **Code Quality (30%)** | 27–30 pts: Clean, well-organized code; effective recursion; meaningful variable names; consistent style; proper error handling | 24–26 pts: Mostly clean code with minor style issues; recursion used well; generally meaningful names and consistent style | 21–23 pts: Functional but inconsistently styled/organized; recursion adequate but could improve; some unclear names | 0–20 pts: Poorly organized/difficult to read; ineffective recursion/algorithms; unclear or inconsistent naming/style | **/30** |
| **Documentation & Analysis (20%)** | 18–20 pts: Comprehensive report with insightful performance analysis; clear results explanation; thoughtful project integration; well-commented code | 16–17 pts: Complete report with adequate analysis; clear explanations; some project integration; generally well-commented code | 14–15 pts: Basic report covering required elements; superficial analysis; minimal project integration; some comments | 0–13 pts: Incomplete/missing report; little/no analysis; no applications discussed; poorly commented or uncommented code | **/20** |
| **Professionalism & Testing (10%)** | 9–10 pts: On-time, organized repo; comprehensive unit tests (all functions & edge cases); frequent, meaningful commits; clean repo | 8 pts: On-time, mostly organized repo; good test coverage with minor gaps; regular commits with reasonable messages | 7 pts: On-time, repo could be better organized; basic tests but missing important cases; some commits but not frequent | 0–6 pts: Late/poorly organized repo; minimal/ineffective tests; few commits or unclear messages | **/10** |

---

## Getting Help

### Before Asking for Help:
1. Review your tree traversal logic step-by-step
2. Use debugger to trace through recursive calls
3. Test with small, simple examples first
4. Work with our TA team to work through your logic/code
5. Come to office hours for additional support

### Office Hours Topics:
- Debugging recursive deletion logic
- Understanding in-order successor algorithm
- Interpreting performance analysis results
- Project integration strategies

### Collaboration Policy:
- Discuss algorithms and approaches with classmates
- Share debugging strategies and testing ideas
- **Do NOT share actual code implementations**
- All submitted code must be your own work

---

## Resources

### Required Reading:
- Textbook Chapter 8: Binary Search Trees
- Course notes on tree traversals and recursive algorithms

### Helpful Tools:
- [VisuAlgo BST Visualization](https://visualgo.net/en/bst)
- [BST Simulator](https://www.cs.usfca.edu/~galles/visualization/BST.html)
- Java Debugger for tracing recursive calls

### Reference Materials:
- Java Collections Framework TreeSet documentation
- Algorithm analysis examples from previous labs

---

**Final Note:** This lab builds crucial foundations for understanding balanced trees (AVL, Red-Black) in upcoming weeks. Focus on understanding the recursive patterns and BST properties - these concepts will be essential for your semester project and future coursework.
