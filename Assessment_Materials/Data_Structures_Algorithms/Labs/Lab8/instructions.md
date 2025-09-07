# Lab 8: AVL Tree Rotations & Self-Balancing

## Overview
**Week:** 10  
**Due Date:** Thursday of Week 10, 11:59 PM  
**Points:** 100 points  
**Estimated Time:** 5-7 hours

This lab extends your BST implementation from Lab 7 to create a self-balancing AVL tree. You'll implement rotation algorithms, maintain balance factors, and analyze the performance improvements of balanced trees over basic BSTs.

---

## Learning Objectives

By the end of this lab, you will be able to:

1. **Understand Self-Balancing Concepts**
   - Explain why tree balance matters for performance
   - Calculate and maintain balance factors
   - Identify when rotations are needed

2. **Implement Rotation Algorithms**
   - Design and implement single rotations (left and right)
   - Design and implement double rotations (left-right and right-left)
   - Apply rotations during insertion and deletion operations

3. **Maintain AVL Properties**
   - Calculate node heights efficiently
   - Update balance factors after tree modifications
   - Ensure AVL invariant is preserved through all operations

4. **Analyze Performance Improvements**
   - Compare AVL tree performance with basic BST
   - Understand guaranteed O(log n) operation complexity
   - Evaluate trade-offs between balance maintenance and operation speed

---

## Prerequisites

Before starting this lab, ensure you understand:
- Binary Search Tree operations from Lab 7
- Tree height and depth concepts
- Recursive algorithm design
- The relationship between tree balance and performance

---

## Background: AVL Trees

### AVL Tree Properties
An AVL tree is a self-balancing BST where:
1. **BST Property**: For any node, left subtree ≤ node < right subtree
2. **Balance Property**: For any node, the height difference between left and right subtrees is at most 1
3. **Height Calculation**: Height of a node = 1 + max(height of left child, height of right child)
4. **Balance Factor**: BF(node) = height(left subtree) - height(right subtree)

### Balance Factor Rules
- **Balanced**: BF ∈ {-1, 0, 1}
- **Left Heavy**: BF = 2 (requires right rotation)
- **Right Heavy**: BF = -2 (requires left rotation)

### Rotation Types
1. **Single Right Rotation (RR)**: When left subtree is too heavy
2. **Single Left Rotation (LL)**: When right subtree is too heavy
3. **Left-Right Rotation (LR)**: When left child's right subtree causes imbalance
4. **Right-Left Rotation (RL)**: When right child's left subtree causes imbalance

---

## Part 1: AVL Node Implementation (20 minutes)

### Step 1.1: Examine AVLNode Structure
Review the provided `AVLNode.java` file. This extends the basic node concept with:
- `height`: The height of the subtree rooted at this node
- Helper methods for balance factor calculation
- Height management utilities

### Step 1.2: Understand Height Management
**Key Concepts:**
- Leaf nodes have height 0
- Empty (null) nodes have height -1
- Height is always 1 + max(left height, right height)
- Balance factor = left height - right height

---

## Part 2: Single Rotation Implementation (60 minutes)

### Step 2.1: Right Rotation (30 minutes)

Implement the `rotateRight(AVLNode y)` method.

**Scenario**: Left subtree of y is too heavy (BF = 2)

**Algorithm**:
```
     y                x
    / \              / \
   x   C    -->     A   y
  / \                  / \
 A   B                B   C
```

**Steps**:
1. Store x = y.left
2. Set y.left = x.right
3. Set x.right = y
4. Update heights of y and x
5. Return x as new root

### Step 2.2: Left Rotation (30 minutes)

Implement the `rotateLeft(AVLNode x)` method.

**Scenario**: Right subtree of x is too heavy (BF = -2)

**Algorithm**:
```
   x                  y
  / \                / \
 A   y      -->     x   C
    / \            / \
   B   C          A   B
```

**Steps**:
1. Store y = x.right
2. Set x.right = y.left
3. Set y.left = x
4. Update heights of x and y
5. Return y as new root

---

## Part 3: Double Rotation Implementation (60 minutes)

### Step 3.1: Left-Right Rotation (30 minutes)

**Scenario**: Left child's right subtree causes imbalance

**Algorithm**: First rotate left on left child, then rotate right on root
```
     z              z               y
    / \            / \             / \
   x   D          y   D           x   z
  / \     -->    / \     -->     / \ / \
 A   y          x   C           A  B C  D
    / \        / \
   B   C      A   B
```

### Step 3.2: Right-Left Rotation (30 minutes)

**Scenario**: Right child's left subtree causes imbalance

**Algorithm**: First rotate right on right child, then rotate left on root
```
   x                x               y
  / \              / \             / \
 A   z            A   y           x   z
    / \              / \         / \ / \
   y   D    -->     B   z  -->  A  B C  D
  / \                  / \
 B   C                C   D
```

---

## Part 4: AVL Insertion with Rebalancing (90 minutes)

### Step 4.1: Insert Algorithm (45 minutes)

Complete the `insert(int value)` method that:
1. Performs standard BST insertion
2. Updates heights along the path back to root
3. Checks balance factors and applies rotations as needed

**Insertion Steps**:
1. Insert using standard BST insertion
2. Update height of current node
3. Calculate balance factor
4. If |balance factor| > 1, determine rotation type needed
5. Apply appropriate rotation
6. Return the new root of the subtree

### Step 4.2: Rotation Decision Logic (45 minutes)

Implement the logic to determine which rotation to apply:

```java
if (balanceFactor > 1) {
    // Left heavy
    if (getBalanceFactor(node.left) >= 0) {
        // Left-Left case: Single right rotation
        return rotateRight(node);
    } else {
        // Left-Right case: Double rotation
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }
}
if (balanceFactor < -1) {
    // Right heavy
    if (getBalanceFactor(node.right) <= 0) {
        // Right-Right case: Single left rotation
        return rotateLeft(node);
    } else {
        // Right-Left case: Double rotation
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }
}
```

---

## Part 5: AVL Deletion with Rebalancing (60 minutes)

### Step 5.1: Delete Algorithm (45 minutes)

Implement `delete(int value)` method that:
1. Performs standard BST deletion
2. Updates heights along the path back to root
3. Checks balance factors and rebalances as needed

**Note**: Deletion may cause imbalances at multiple levels, so rebalancing must be checked at every node on the path to root.

### Step 5.2: Deletion Rebalancing (15 minutes)

The rebalancing logic after deletion is similar to insertion, but you must check balance at every ancestor node, not just the insertion point.

---

## Part 6: Performance Analysis (45 minutes)

### Step 6.1: Height Comparison (15 minutes)

Create test cases that demonstrate:
- Basic BST with sequential insertion (degenerate tree)
- AVL tree with same sequential insertion (balanced tree)
- Height comparison between the two approaches

### Step 6.2: Operation Timing (30 minutes)

Using `AVLPerformanceAnalysis.java`, measure and compare:
- Search times: AVL vs. Basic BST
- Insertion times: AVL vs. Basic BST (including rebalancing overhead)
- Overall performance with different data patterns

**Expected Results**:
- AVL tree: Consistent O(log n) performance
- Basic BST: O(log n) best case, O(n) worst case
- AVL overhead: Slight increase in insertion/deletion time, significant improvement in search time for unbalanced data

---

## Part 7: Integration with Semester Project (30 minutes)

### Step 7.1: Project Enhancement
Consider how AVL trees could improve your semester project:
- Database indexing for fast lookups
- User data management with guaranteed performance
- Real-time applications requiring consistent response times

### Step 7.2: Trade-off Analysis
Document the trade-offs:
- **Pros**: Guaranteed O(log n) operations, consistent performance
- **Cons**: Additional memory for height storage, rotation overhead
- **When to use**: Large datasets, performance-critical applications, frequent searches

---

## Testing Requirements

### Unit Tests (Required)
Your `AVLTest.java` should include tests for:

**Rotation Tests**:
- Single right rotation scenario
- Single left rotation scenario
- Left-right double rotation scenario
- Right-left double rotation scenario
- Multiple rotations in sequence

**AVL Property Tests**:
- Balance factor calculation
- Height calculation after operations
- AVL invariant maintenance after insertions
- AVL invariant maintenance after deletions

**Integration Tests**:
- Sequential insertion (worst case for basic BST)
- Random insertion patterns
- Mixed insert/delete operations
- Large dataset performance comparison

### Visualization Tests (Recommended)
Use `RotationVisualizer.java` to:
- Visualize tree structure before and after rotations
- Verify balance factors are correctly calculated
- Debug rotation logic with visual feedback

---

## Submission Requirements

Submit the following files to GitHub Classroom:

1. **`AVLTree.java`** - Your complete AVL tree implementation
2. **`AVLTest.java`** - Comprehensive unit tests
3. **`AVLPerformanceAnalysis.java`** - Performance comparison code
4. **`lab8_report.md`** - Analysis report and project integration discussion
5. **`rotation_examples.txt`** - Manual trace of rotation examples
6. **`performance_comparison.txt`** - AVL vs BST performance data

### Repository Organization
```
lab8-avl-[username]/
├── src/
│   ├── AVLNode.java
│   ├── AVLTree.java
│   ├── AVLTest.java
│   ├── RotationVisualizer.java
│   └── AVLPerformanceAnalysis.java
├── data/
│   ├── performance_comparison.txt
│   └── rotation_examples.txt
├── lab8_report.md
└── README.md
```

---

## Assessment Rubric

| **Criteria** | **Excellent** | **Good** | **Satisfactory** | **Needs Improvement** | **Points** |
|--------------|---------------|----------|------------------|------------------------|-------------|
| **Core Functionality (40%)** | 36–40 pts: All rotation algorithms implemented correctly (single and double); insertion & deletion maintain AVL properties; height & balance factor calculations accurate; tree remains balanced after all operations | 32–35 pts: Most rotations implemented correctly with minor issues; AVL properties generally maintained; height mostly accurate; tree balance maintained in most scenarios | 28–31 pts: Basic rotation logic implemented but may have bugs; AVL properties sometimes violated; height calculations have some errors; balance maintained in simple cases only | 0–27 pts: Rotation algorithms missing/incorrect; AVL properties frequently violated; height incorrect; balance not maintained | **/40** |
| **Code Quality (30%)** | 27–30 pts: Clean, well-organized code following Java conventions; efficient rotations; proper height & balance management; effective use of helper methods/recursion | 24–26 pts: Mostly clean with minor issues; rotations work but could be more elegant; generally good height management; some effective helpers | 21–23 pts: Functional but inconsistent style; verbose/unclear rotations; height management inefficient; limited use of helpers | 0–20 pts: Poorly organized/difficult to read; inefficient/incorrect rotations; poor height management; little use of coding practices | **/30** |
| **Documentation & Analysis (20%)** | 18–20 pts: Comprehensive report with insightful analysis; clear explanation of rotations & necessity; thoughtful AVL vs BST trade-offs; well-documented step-by-step traces | 16–17 pts: Complete report with adequate analysis; good explanation of rotations; some comparison of AVL vs BST; most examples documented | 14–15 pts: Basic report covering required elements; superficial explanation; limited analysis; few rotation examples | 0–13 pts: Incomplete/missing report; little understanding of rotations; no meaningful analysis; missing examples | **/20** |
| **Professionalism & Testing (10%)** | 9–10 pts: On-time, well-organized repo; comprehensive unit tests (all rotations); performance analysis thorough; clean file organization | 8 pts: On-time, mostly organized repo; good test coverage with minor gaps; basic performance analysis; generally well-organized files | 7 pts: On-time, repo could be better organized; basic tests but missing scenarios; limited analysis; some organizational issues | 0–6 pts: Late/poorly organized repo; minimal/ineffective tests; little/no analysis; poor file organization | **/10** |

---

## Getting Help

### Before Asking for Help:
1. Use the `RotationVisualizer` to debug tree structure problems
2. Test rotations manually with small examples (3-4 nodes)
3. Verify balance factor calculations step-by-step
4. Connect with your TA during the lab or their student hours for support
5. Make time to meet with your professor during office hours if additional support is needed

### Office Hours Topics:
- Debugging rotation logic with specific examples
- Understanding when each rotation type is needed
- Interpreting performance analysis results
- Integrating AVL trees into semester projects

### Collaboration Policy:
- Discuss rotation concepts and algorithms with classmates
- Share debugging strategies and testing approaches
- **Do NOT share actual rotation implementation code**
- All submitted code must be your own work

---

## Resources

### Required Reading:
- Textbook Chapter 10: AVL Trees and Rotations
- Course notes on self-balancing trees

### Helpful Tools:
- [VisuAlgo AVL Tree Visualization](https://visualgo.net/en/bst)
- [AVL Tree Simulator](https://www.cs.usfca.edu/~galles/visualization/AVLtree.html)
- [Rotation Animation Tool](https://www.cs.usfca.edu/~galles/visualization/RotationTool.html)

### Reference Materials:
- Java TreeMap documentation (uses Red-Black trees, similar concept)
- Algorithm analysis examples from Lab 7
- Self-balancing tree research papers (optional advanced reading)

---

**Final Note:** This lab builds essential foundations for understanding self-balancing data structures. The rotation algorithms you implement here are fundamental to many advanced tree structures (Red-Black trees, B-trees, etc.) used in databases and real-world applications. Focus on understanding WHY rotations preserve balance and HOW they maintain performance guarantees.