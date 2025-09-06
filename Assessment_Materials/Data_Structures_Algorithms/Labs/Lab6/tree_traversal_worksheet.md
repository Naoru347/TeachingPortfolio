# Tree Traversal Worksheet
## Lab 6: Binary Tree ADT & Traversals

### Instructions
Complete this worksheet to practice manual tree traversals and understand the recursive patterns. Show your work by listing the order in which nodes are visited.

---

## Traversal Review

**The Three Recursive Traversals:**
- **Preorder:** Root → Left → Right (process node before children)
- **Inorder:** Left → Root → Right (process node between children)  
- **Postorder:** Left → Right → Root (process node after children)

**The Iterative Traversal:**
- **Level-order:** Process nodes level by level, left to right (uses queue)

---

## Problem 1: Simple Binary Tree

**Given Tree:**
```
       A
      / \
     B   C
    /   / \
   D   E   F
```

**Step-by-step Traversals:**

### Preorder (Root → Left → Right)
**Strategy:** Visit root, then completely traverse left subtree, then right subtree

**Trace:**
1. Start at A (root) → **Visit A**
2. Go left to B → **Visit B**  
3. Go left to D → **Visit D** (leaf, backtrack to B)
4. B's right is null, backtrack to A
5. Go right to C → **Visit C**
6. Go left to E → **Visit E** (leaf, backtrack to C)
7. Go right to F → **Visit F** (leaf, done)

**Result:** A, B, D, C, E, F

### Your Turn - Complete These:

**Inorder (Left → Root → Right):**
**Strategy:** Completely traverse left subtree, visit root, then traverse right subtree

**Trace:**
1. Start at A, go left to B, go left to D
2. D is leaf → **Visit D**, backtrack to B
3. B has no more left children → **Visit B**
4. B has no right children, backtrack to A
5. A has no more left children → **Visit A**
6. Go right to C, go left to E
7. E is leaf → **Visit E**, backtrack to C
8. C has no more left children → **Visit C**
9. Go right to F → **Visit F**

**Your Result:** _________________

**Postorder (Left → Right → Root):**
**Strategy:** Completely traverse both subtrees, then visit root

**Your Trace:**
1. ________________________________
2. ________________________________
3. ________________________________
4. ________________________________
5. ________________________________
6. ________________________________

**Your Result:** _________________

**Level-order (Breadth-First):**
**Strategy:** Use queue, process level by level

**Your Trace:**
1. Queue: [A] → Process A, add B, C → Queue: [B, C]
2. Queue: [B, C] → Process B, add D → Queue: [C, D]
3. ________________________________
4. ________________________________
5. ________________________________
6. ________________________________

**Your Result:** _________________

---

## Problem 2: Unbalanced Tree

**Given Tree:**
```
     1
    /
   2
  /
 3
/
4
```

**Complete all four traversals:**

**Preorder:** _________________

**Inorder:** _________________

**Postorder:** _________________

**Level-order:** _________________

**Analysis Questions:**
1. **Which traversals give the same result for this tree?** _________________
2. **Why does this happen?** _________________
3. **What type of tree structure is this?** _________________

---

## Problem 3: Complete Binary Tree

**Given Tree:**
```
       F
      / \
     B   G
    / \ / \
   A  D E  I
     /     /
    C     H
```

**Complete all traversals:**

**Preorder:** _________________

**Inorder:** _________________

**Postorder:** _________________

**Level-order:** _________________

**Verification Questions:**
1. **How many nodes are in this tree?** _____
2. **What is the height of this tree?** _____
3. **Is this tree complete?** _____ **Why?** _________________
4. **Is this tree full?** _____ **Why?** _________________

---

## Problem 4: Expression Tree

**Given Expression Tree for: (A + B) * (C - D)**
```
       *
      / \
     +   -
    / \ / \
   A  B C  D
```

**Complete all traversals:**

**Preorder:** _________________

**Inorder:** _________________

**Postorder:** _________________

**Level-order:** _________________

**Application Questions:**
1. **Which traversal gives prefix notation?** _________________
2. **Which traversal gives infix notation?** _________________
3. **Which traversal gives postfix notation?** _________________
4. **What is the prefix expression?** _________________
5. **What is the postfix expression?** _________________

---

## Problem 5: Single Node Tree

**Given Tree:**
```
   X
```

**Complete all traversals:**

**Preorder:** _____

**Inorder:** _____

**Postorder:** _____

**Level-order:** _____

**Analysis:**
1. **Why are all traversals the same?** _________________
2. **What is the height of this tree?** _____
3. **Is this tree complete, full, balanced, and perfect?** _________________

---

## Problem 6: Tree Construction from Traversals

**Given:**
- **Preorder:** F, B, A, D, C, E, G, I, H
- **Inorder:** A, B, C, D, E, F, G, H, I

**Reconstruct the tree:**

**Step-by-step process:**
1. **Root is first element of preorder:** _____
2. **Find root position in inorder:** Position _____
3. **Left subtree inorder:** _________________
4. **Right subtree inorder:** _________________
5. **Continue recursively...**

**Draw your reconstructed tree:**
```
        ___
       /   \
      ___  ___
     / \   / \
    ___ ___ ___ ___
```

**Verify your answer:**
- **Preorder of your tree:** _________________
- **Inorder of your tree:** _________________
- **Do they match the given sequences?** _____

---

## Problem 7: Traversal Applications

**Match each scenario with the best traversal:**

**Scenarios:**
1. Delete all files in a directory tree (must delete children before parent)
2. Print directory structure with indentation  
3. Copy a tree structure (need parent before children)
4. Evaluate a mathematical expression tree
5. Print nodes level by level for debugging
6. Get sorted order from a binary search tree

**Traversals:**
A. Preorder
B. Inorder  
C. Postorder
D. Level-order

**Your Answers:**
1. _____ 2. _____ 3. _____ 4. _____ 5. _____ 6. _____

**Explain your reasoning for #1:** _________________

**Explain your reasoning for #6:** _________________

---

## Problem 8: Tree Property Analysis

**For each tree, determine the properties:**

**Tree A:**
```
     1
    / \
   2   3
  / \
 4   5
```

**Tree B:**
```
     A
    / \
   B   C
  / \ / \
 D  E F  G
```

**Tree C:**
```
     X
    /
   Y
    \
     Z
```

**Complete this table:**

| Property | Tree A | Tree B | Tree C |
|----------|--------|--------|--------|
| **Height** | _____ | _____ | _____ |
| **Size** | _____ | _____ | _____ |
| **Leaf count** | _____ | _____ | _____ |
| **Complete?** | _____ | _____ | _____ |
| **Full?** | _____ | _____ | _____ |
| **Perfect?** | _____ | _____ | _____ |
| **Balanced?** | _____ | _____ | _____ |

---

## Problem 9: Recursive Pattern Recognition

**For each traversal, complete the recursive pattern:**

**Preorder Template:**
```java
void preorder(TreeNode node) {
    if (node == null) return;
    
    // Step 1: _________________
    // Step 2: _________________  
    // Step 3: _________________
}
```

**Inorder Template:**
```java
void inorder(TreeNode node) {
    if (node == null) return;
    
    // Step 1: _________________
    // Step 2: _________________
    // Step 3: _________________
}
```

**Postorder Template:**
```java
void postorder(TreeNode node) {
    if (node == null) return;
    
    // Step 1: _________________
    // Step 2: _________________
    // Step 3: _________________
}
```

---

## Problem 10: Custom Tree Analysis

**Create your own binary tree with exactly 7 nodes that is:**
- **Complete but not full**
- **Height = 3**

**Draw your tree:**
```
        ___
       /   \
      ___  ___
     / \   /
    ___ ___ ___
```

**Verify your tree:**
- **Is it complete?** _____ **Why?** _________________
- **Is it full?** _____ **Why?** _________________
- **Height = 3?** _____ **Path:** _________________
- **Exactly 7 nodes?** _____ **Count:** _________________

**Traversals of your tree:**
- **Preorder:** _________________
- **Inorder:** _________________
- **Postorder:** _________________
- **Level-order:** _________________

---

## Reflection Questions

**1. Which traversal pattern do you find most intuitive? Why?**

**Answer:** _________________________________________________

**2. How does the tree structure affect the traversal results?**

**Answer:** _________________________________________________

**3. When might you choose iterative over recursive traversal?**

**Answer:** _________________________________________________

**4. How do tree traversals relate to other algorithms you've studied?**

**Answer:** _________________________________________________

**5. What tree properties are most important for different applications?**

**Answer:** _________________________________________________

---

## Answer Key (For Instructor Use)

<details>
<summary>Click to reveal answers</summary>

**Problem 1:**
- Inorder: D, B, A, E, C, F
- Postorder: D, B, E, F, C, A  
- Level-order: A, B, C, D, E, F

**Problem 2:**
- All traversals: 4, 3, 2, 1 (except level-order: 1, 2, 3, 4)

**Problem 3:**
- Preorder: F, B, A, D, C, G, E, I, H
- Inorder: A, B, C, D, F, E, G, H, I
- Postorder: A, C, D, B, E, H, I, G, F
- Level-order: F, B, G, A, D, E, I, C, H

**Problem 7:** 1-C, 2-A, 3-A, 4-C, 5-D, 6-B

</details>