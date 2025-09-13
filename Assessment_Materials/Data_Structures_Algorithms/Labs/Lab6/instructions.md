# Lab 6 – Tree ADT & Traversals

## Overview
Welcome to your sixth Data Structures & Algorithms lab! This session introduces binary trees - one of the most important and versatile data structures in computer science. You'll implement a complete binary tree ADT, master the three fundamental traversal algorithms, and explore tree properties that form the foundation for more advanced tree structures.

Building directly on Lab 5's recursion mastery, you'll see how every tree operation is naturally recursive. This lab provides the essential foundation for binary search trees (Lab 7), balanced trees (Lab 8), and many other tree-based algorithms throughout computer science.

---

## Learning Objectives
By the end of this lab, you will be able to:
- Implement a complete binary tree ADT with recursive operations
- Master preorder, inorder, and postorder traversal algorithms
- Analyze tree properties: height, size, balance, and structural characteristics
- Apply tree traversals to solve real-world problems
- Choose appropriate tree representations and traversal strategies
- Verify tree properties and detect structural issues

---

## Pre-Lab Preparation (5 minutes)
**Before starting the exercises, ensure you have:**
- Completed Lab 5 (recursion skills are essential!)
- Downloaded `BinaryTreeStarter.java`, `TreeTester.java`, and `TreeTraversalWorksheet.md` from course LMS
- Reviewed textbook Chapter 8 (Trees) sections 8.1-8.3
- Basic understanding of hierarchical data structures

---

## Part 1: Tree Fundamentals and Terminology (15 minutes)

### **Exercise 1.1: Understanding Tree Structure (8 minutes)**

**Key Concepts:**
```
Tree Terminology:
- Node: Contains data and references to children
- Root: Top node (no parent)
- Leaf: Node with no children  
- Parent: Node with children
- Child: Node with a parent
- Sibling: Nodes with same parent
- Height: Length of longest path from node to leaf
- Depth: Length of path from root to node
- Level: All nodes at same depth
```

**📝 Analyze this tree structure:**
```
       A
      / \
     B   C
    /   / \
   D   E   F
      /
     G
```

**Complete this analysis:**
- **Root:** _____
- **Leaves:** _____
- **Parent of E:** _____
- **Children of C:** _____
- **Siblings of B:** _____
- **Height of tree:** _____
- **Depth of G:** _____
- **Nodes at level 2:** _____

### **Exercise 1.2: Binary Tree Properties (7 minutes)**

**Binary Tree Definition:** Each node has at most two children (left and right)

**📝 Tree Property Verification:**

**Tree 1:**
```
     1
    / \
   2   3
  /   / \
 4   5   6
```

**Tree 2:**
```
     A
    /
   B
  /
 C
```

**Tree 3:**
```
     X
    / \
   Y   Z
  / \   \
 W   V   U
```

**Complete this analysis:**
| Property | Tree 1 | Tree 2 | Tree 3 |
|----------|--------|--------|--------|
| **Is it binary?** | _____ | _____ | _____ |
| **Height** | _____ | _____ | _____ |
| **Number of nodes** | _____ | _____ | _____ |
| **Number of leaves** | _____ | _____ | _____ |
| **Is it complete?** | _____ | _____ | _____ |
| **Is it full?** | _____ | _____ | _____ |

**Definitions:**
- **Complete:** All levels filled except possibly the last, filled left to right
- **Full:** Every node has either 0 or 2 children (no nodes with exactly 1 child)

---

## Part 2: Binary Tree Implementation (20 minutes)

### **Exercise 2.1: TreeNode and Basic Operations (10 minutes)**

Open `BinaryTreeStarter.java` and examine the TreeNode structure:

```java
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
    
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
```

**Implement basic tree operations:**

**Method 1: `insert(T data)`**
```java
/**
 * TODO: Insert data into the tree (for now, just insert in level order)
 * Use a queue to insert nodes level by level, left to right
 */
public void insert(T data) {
    TreeNode<T> newNode = new TreeNode<>(data);
    
    if (root == null) {
        // TODO: Handle empty tree case
        // HINT: root = newNode;
        return;
    }
    
    // TODO: Use queue for level-order insertion
    // HINT: Use Queue from Lab 4 or java.util.LinkedList
    // HINT: Find first node with available child slot
    
    // Queue<TreeNode<T>> queue = new LinkedList<>();
    // queue.offer(root);
    // 
    // while (!queue.isEmpty()) {
    //     TreeNode<T> current = queue.poll();
    //     
    //     if (current.left == null) {
    //         current.left = newNode;
    //         return;
    //     } else if (current.right == null) {
    //         current.right = newNode;
    //         return;
    //     } else {
    //         queue.offer(current.left);
    //         queue.offer(current.right);
    //     }
    // }
}
```

**Method 2: `size()`**
```java
/**
 * TODO: Count total number of nodes in tree using recursion
 */
public int size() {
    return sizeHelper(root);
}

private int sizeHelper(TreeNode<T> node) {
    // TODO: Base case - empty tree
    // HINT: if (node == null) return 0;
    
    // TODO: Recursive case - count this node + left subtree + right subtree
    // HINT: return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    
    return 0; // Placeholder
}
```

**Method 3: `height()`**
```java
/**
 * TODO: Calculate height of tree using recursion
 */
public int height() {
    return heightHelper(root);
}

private int heightHelper(TreeNode<T> node) {
    // TODO: Base case - empty tree has height 0
    
    // TODO: Recursive case - height is 1 + max of subtree heights
    // HINT: Math.max(heightHelper(node.left), heightHelper(node.right)) + 1
    
    return 0; // Placeholder
}
```

### **Exercise 2.2: Tree Construction Practice (10 minutes)**

**Build these trees programmatically:**

**Tree A: Simple Complete Tree**
```java
BinaryTree<String> treeA = new BinaryTree<>();
// TODO: Insert nodes to create this structure:
//       "A"
//      /   \
//    "B"   "C"
//   /  \
// "D"  "E"

// HINT: Insert in this order: A, B, C, D, E
```

**Tree B: Single Path Tree**
```java
BinaryTree<Integer> treeB = new BinaryTree<>();
// TODO: Create this structure:
//   1
//    \
//     2
//      \
//       3
//        \
//         4

// Note: This requires manual node creation, not level-order insertion
```

**📝 Test your implementations:**
- **Tree A size:** _____ (expected: 5)
- **Tree A height:** _____ (expected: 3)
- **Tree B size:** _____ (expected: 4)  
- **Tree B height:** _____ (expected: 4)

---

## Part 3: Tree Traversal Algorithms (25 minutes)

### **Exercise 3.1: Understanding Traversal Patterns (10 minutes)**

**The Three Traversals:**
```java
// Preorder:  Root → Left → Right
// Inorder:   Left → Root → Right  
// Postorder: Left → Right → Root
```

**📝 Manual Traversal Practice:**

**Given this tree:**
```
       F
      / \
     B   G
    / \   \
   A   D   I
      / \  /
     C   E H
```

**Trace each traversal by hand:**

**Preorder (Root → Left → Right):**
1. Visit F, then go left to B
2. Visit B, then go left to A
3. Visit A (leaf), backtrack to B, go right to D
4. Visit D, then go left to C
5. Visit C (leaf), backtrack to D, go right to E
6. Visit E (leaf), backtrack to F, go right to G
7. Visit G, no left child, go right to I
8. Visit I, go left to H
9. Visit H (leaf), done

**Result:** F, B, A, D, C, E, G, I, H

**Your turn - complete these:**
- **Inorder result:** _____________________
- **Postorder result:** _____________________

### **Exercise 3.2: Recursive Traversal Implementation (15 minutes)**

**Implement all three traversals:**

**Preorder Traversal:**
```java
/**
 * TODO: Implement preorder traversal (Root → Left → Right)
 */
public List<T> preorderTraversal() {
    List<T> result = new ArrayList<>();
    preorderHelper(root, result);
    return result;
}

private void preorderHelper(TreeNode<T> node, List<T> result) {
    // TODO: Base case - empty node
    // HINT: if (node == null) return;
    
    // TODO: Preorder logic:
    // 1. Process current node (add to result)
    // 2. Traverse left subtree
    // 3. Traverse right subtree
    
    // result.add(node.data);                    // Process root
    // preorderHelper(node.left, result);       // Traverse left
    // preorderHelper(node.right, result);      // Traverse right
}
```

**Inorder Traversal:**
```java
/**
 * TODO: Implement inorder traversal (Left → Root → Right)
 */
public List<T> inorderTraversal() {
    List<T> result = new ArrayList<>();
    inorderHelper(root, result);
    return result;
}

private void inorderHelper(TreeNode<T> node, List<T> result) {
    // TODO: Base case
    
    // TODO: Inorder logic:
    // 1. Traverse left subtree
    // 2. Process current node
    // 3. Traverse right subtree
    
    // inorderHelper(node.left, result);        // Traverse left
    // result.add(node.data);                   // Process root
    // inorderHelper(node.right, result);       // Traverse right
}
```

**Postorder Traversal:**
```java
/**
 * TODO: Implement postorder traversal (Left → Right → Root)
 */
public List<T> postorderTraversal() {
    List<T> result = new ArrayList<>();
    postorderHelper(root, result);
    return result;
}

private void postorderHelper(TreeNode<T> node, List<T> result) {
    // TODO: Base case
    
    // TODO: Postorder logic:
    // 1. Traverse left subtree
    // 2. Traverse right subtree  
    // 3. Process current node
    
    // postorderHelper(node.left, result);      // Traverse left
    // postorderHelper(node.right, result);     // Traverse right
    // result.add(node.data);                   // Process root
}
```

**📝 Test your traversals on the tree from Exercise 3.1:**
- **Your preorder result:** _____________________
- **Your inorder result:** _____________________
- **Your postorder result:** _____________________

**Expected results:**
- **Preorder:** F, B, A, D, C, E, G, I, H
- **Inorder:** A, B, C, D, E, F, G, H, I
- **Postorder:** A, C, E, D, B, H, I, G, F

---

## Part 4: Tree Property Verification (10 minutes)

### **Exercise 4.1: Advanced Tree Properties**

**Implement these property checkers:**

**Method 1: `isComplete()`**
```java
/**
 * TODO: Check if tree is complete (all levels filled except possibly last, filled left to right)
 */
public boolean isComplete() {
    if (root == null) return true;
    
    // TODO: Use level-order traversal with queue
    // TODO: Once you encounter a null, all subsequent nodes should be null
    
    // Queue<TreeNode<T>> queue = new LinkedList<>();
    // queue.offer(root);
    // boolean foundNull = false;
    // 
    // while (!queue.isEmpty()) {
    //     TreeNode<T> current = queue.poll();
    //     
    //     if (current == null) {
    //         foundNull = true;
    //     } else {
    //         if (foundNull) return false;  // Found node after null
    //         queue.offer(current.left);
    //         queue.offer(current.right);
    //     }
    // }
    // return true;
    
    return false; // Placeholder
}
```

**Method 2: `isFull()`**
```java
/**
 * TODO: Check if tree is full (every node has 0 or 2 children)
 */
public boolean isFull() {
    return isFullHelper(root);
}

private boolean isFullHelper(TreeNode<T> node) {
    // TODO: Base case - empty tree is full
    
    // TODO: Check if node has exactly one child (not allowed in full tree)
    
    // TODO: Recursively check both subtrees
    
    return false; // Placeholder
}
```

**Method 3: `isBalanced()`**
```java
/**
 * TODO: Check if tree is height-balanced (heights of subtrees differ by at most 1)
 */
public boolean isBalanced() {
    return isBalancedHelper(root) != -1;
}

private int isBalancedHelper(TreeNode<T> node) {
    // TODO: Return height if balanced, -1 if not balanced
    // This is a classic "return multiple values" pattern
    
    return 0; // Placeholder
}
```

### **Exercise 4.2: Tree Analysis Practice**

**📝 For each tree, predict the properties:**

**Tree 1:**
```
     1
    / \
   2   3
  / \
 4   5
```

**Tree 2:**
```
     A
    /
   B
  /
 C
```

**Tree 3:**
```
     X
    / \
   Y   Z
  / \   
 W   V   
```

| Property | Tree 1 | Tree 2 | Tree 3 |
|----------|--------|--------|--------|
| **Height** | _____ | _____ | _____ |
| **Size** | _____ | _____ | _____ |
| **Is Complete?** | _____ | _____ | _____ |
| **Is Full?** | _____ | _____ | _____ |
| **Is Balanced?** | _____ | _____ | _____ |

---

## Part 5: Real-World Applications (5 minutes)

### **Exercise 5.1: Traversal Applications**

**📝 Match each traversal to its best use case:**

**Use Cases:**
1. **File system deletion** (delete children before parent)
2. **Mathematical expression evaluation** (need operands before operator)
3. **Creating a copy** of the tree (need parent before children)
4. **Printing directory structure** (show folder before contents)
5. **Binary search tree in-order listing** (get sorted order)

**Traversal Matching:**
- **Preorder best for:** _____ and _____
- **Inorder best for:** _____
- **Postorder best for:** _____ and _____

### **Exercise 5.2: Project Integration Planning**

**Week 7 Project Milestone:** Create and test a generic Tree class with traversals

**💡 Tree Integration Ideas:**
- **File system browser:** Directory/file hierarchy with traversals
- **Decision trees:** Game logic or expert systems  
- **Organization charts:** Company/team hierarchies
- **Menu systems:** Nested menu structures
- **Parse trees:** Mathematical expression evaluation
- **Family trees:** Genealogy applications

**📝 Plan your tree integration:**
- **What hierarchical data will you represent?** _____________________
- **Which traversals will be most useful?** _____________________
- **What tree properties matter for your application?** _____________________
- **How will you test tree functionality?** _____________________

---

## Deliverable

Submit a **single ZIP file** containing:

1. **Complete Implementation:**
   - `BinaryTreeComplete.java` with all methods implemented
   - Working tree construction and traversal algorithms
   - All property verification methods functional

2. **Traversal Analysis (PDF):**
   - Completed `TreeTraversalWorksheet.md` with hand-traced traversals
   - Tree property analysis for all example trees
   - Explanations of traversal applications

3. **Testing Evidence:**
   - Screenshots or text output showing all tests passing
   - Custom test cases demonstrating tree functionality
   - Performance comparison of different tree shapes

4. **Project Integration Plan:**
   - Description of tree component for your semester project
   - Design document showing tree structure and traversal usage
   - Testing strategy for tree integration

**File Naming Convention:** `Lab6_Lastname_Firstname.zip`

**Submission Method:** Upload to course LMS under "Lab 6 Submission"

---

## Assessment Criteria

| Category | Weight | Description |
|----------|--------|-------------|
| **Implementation Correctness** | 40% | All tree operations and traversals work correctly |
| **Traversal Understanding** | 25% | Accurate hand-tracing and implementation of all three traversals |
| **Property Analysis** | 20% | Correct analysis of tree properties and characteristics |
| **Code Quality & Testing** | 15% | Clean code with comprehensive testing and documentation |

---

## Looking Ahead

**Lab 7 Preview:** Next week you'll implement Binary Search Trees (BSTs) using these tree fundamentals. Everything you learn about tree structure and traversals today will be essential for:
- BST insertion and deletion algorithms
- Tree-based searching and sorting
- Tree balancing and optimization
- Advanced tree data structures

**Master these tree concepts now - they're fundamental to all advanced tree algorithms!**

---

## Troubleshooting Tips

**Null Pointer Exceptions:**
- Always check `if (node == null)` in recursive methods
- Remember that empty trees and leaf children are null
- Test with empty trees and single-node trees

**Traversal Logic Errors:**
- Remember the order: where does "process current node" go?
- Draw small trees and trace through by hand
- Use debug prints to see the order of operations

**Stack Overflow in Tree Operations:**
- Very deep trees can exceed call stack
- Test with balanced trees first
- Consider iterative implementations for production code

**Property Verification Issues:**
- Test with known examples first
- Draw tree structures to visualize properties
- Remember edge cases: empty trees, single nodes

---

## Optional Extensions

**For students who finish early:**

1. **Implement iterative traversals** using explicit stacks
2. **Create tree from traversal sequences** (given preorder + inorder)
3. **Add tree visualization** methods for debugging
4. **Implement level-order traversal** using queues
5. **Build expression tree evaluator** for mathematical expressions

---

## Next Week Preview

In Lab 7, you'll implement Binary Search Trees that maintain sorted order and provide O(log n) search operations. All the tree concepts you master today will directly apply to building efficient search structures!