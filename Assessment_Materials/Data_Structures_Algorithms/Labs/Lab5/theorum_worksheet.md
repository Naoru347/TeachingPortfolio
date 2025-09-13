# Master Theorem Worksheet
## Lab 5: Recursive Algorithm Analysis

### Instructions
Complete this worksheet to practice applying the Master Theorem to analyze recursive algorithms. Show all work and explain your reasoning.

---

## Master Theorem Review

**The Master Theorem** applies to recurrences of the form:
```
T(n) = a * T(n/b) + f(n)
```

Where:
- `a ≥ 1` = number of recursive calls
- `b > 1` = factor by which problem size is reduced
- `f(n)` = work done outside the recursive calls

**Three Cases:**

**Case 1:** If `f(n) = O(n^c)` where `c < log_b(a)`, then `T(n) = Θ(n^log_b(a))`

**Case 2:** If `f(n) = Θ(n^c)` where `c = log_b(a)`, then `T(n) = Θ(n^c * log(n))`

**Case 3:** If `f(n) = Ω(n^c)` where `c > log_b(a)` and regularity condition holds, then `T(n) = Θ(f(n))`

---

## Problem 1: Binary Search Analysis

**Algorithm:** Recursive binary search
```java
public static int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) return -1;                    // Base case
    int mid = left + (right - left) / 2;            // O(1) work
    if (arr[mid] == target) return mid;             // O(1) work
    else if (target < arr[mid])
        return binarySearch(arr, target, left, mid-1);    // 1 recursive call, size n/2
    else
        return binarySearch(arr, target, mid+1, right);   // 1 recursive call, size n/2
}
```

**Step 1:** Write the recurrence relation
```
T(n) = _____ * T(_____) + _____
```

**Step 2:** Identify the values
- `a = _____` (number of recursive calls)
- `b = _____` (size reduction factor) 
- `f(n) = _____` (work outside recursion)

**Step 3:** Calculate log_b(a)
```
log_b(a) = log_____(_____) = _____
```

**Step 4:** Compare f(n) with n^log_b(a)
- `f(n) = O(n^_____)` where c = _____
- `log_b(a) = _____`
- Since `c _____ log_b(a)`, this is **Case _____**

**Step 5:** Apply Master Theorem
```
T(n) = _____
```

---

## Problem 2: Merge Sort Analysis

**Algorithm:** Recursive merge sort
```java
public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;        // O(1) work
        mergeSort(arr, left, mid);                  // 1st recursive call, size n/2
        mergeSort(arr, mid + 1, right);             // 2nd recursive call, size n/2
        merge(arr, left, mid, right);               // O(n) work to merge
    }
}
```

**Step 1:** Write the recurrence relation
```
T(n) = _____ * T(_____) + _____
```

**Step 2:** Identify the values
- `a = _____`
- `b = _____`
- `f(n) = _____`

**Step 3:** Calculate log_b(a)
```
log_b(a) = log_____(_____) = _____
```

**Step 4:** Compare f(n) with n^log_b(a)
- `f(n) = O(n^_____)` where c = _____
- `log_b(a) = _____`
- Since `c _____ log_b(a)`, this is **Case _____**

**Step 5:** Apply Master Theorem
```
T(n) = _____
```

---

## Problem 3: Tree Height Calculation

**Algorithm:** Calculate height of binary tree
```java
public static int treeHeight(TreeNode node) {
    if (node == null) return 0;                     // Base case
    int leftHeight = treeHeight(node.left);         // 1st recursive call
    int rightHeight = treeHeight(node.right);       // 2nd recursive call  
    return Math.max(leftHeight, rightHeight) + 1;   // O(1) work
}
```

**Step 1:** Write the recurrence relation
```
T(n) = _____ * T(_____) + _____
```

**Step 2:** Identify the values
- `a = _____`
- `b = _____` (assuming balanced tree)
- `f(n) = _____`

**Step 3:** Calculate log_b(a)
```
log_b(a) = log_____(_____) = _____
```

**Step 4:** Compare f(n) with n^log_b(a)
- `f(n) = O(n^_____)` where c = _____
- `log_b(a) = _____`
- Since `c _____ log_b(a)`, this is **Case _____**

**Step 5:** Apply Master Theorem
```
T(n) = _____
```

---

## Problem 4: Matrix Multiplication (Strassen's Algorithm)

**Algorithm:** Strassen's matrix multiplication divides each n×n matrix into four (n/2)×(n/2) submatrices and uses 7 recursive multiplications instead of 8.

**Given:** The recurrence relation is `T(n) = 7 * T(n/2) + O(n²)`

**Step 1:** Identify the values
- `a = _____`
- `b = _____`
- `f(n) = _____`

**Step 2:** Calculate log_b(a)
```
log_b(a) = log₂(7) ≈ 2.81
```

**Step 3:** Compare f(n) with n^log_b(a)
- `f(n) = O(n²)` where c = 2
- `log_b(a) ≈ 2.81`
- Since `c _____ log_b(a)`, this is **Case _____**

**Step 4:** Apply Master Theorem
```
T(n) = _____
```

**Bonus Question:** How does this compare to standard matrix multiplication with complexity O(n³)?

---

## Problem 5: Closest Pair Problem

**Algorithm:** Find the closest pair of points in a 2D plane using divide-and-conquer.

**Given:** `T(n) = 2 * T(n/2) + O(n log n)`

**Your Turn:** Complete the full analysis

**Step 1:** Identify values
- `a = _____`
- `b = _____`  
- `f(n) = _____`

**Step 2:** Calculate log_b(a)
```
log_b(a) = _____
```

**Step 3:** Determine which case applies
- Compare `f(n)` with `n^log_b(a)`
- This is **Case _____**

**Step 4:** Final complexity
```
T(n) = _____
```

---

## Problem 6: Karatsuba Multiplication

**Algorithm:** Fast integer multiplication algorithm

**Given:** `T(n) = 3 * T(n/2) + O(n)`

**Complete Analysis:**

`a = _____`, `b = _____`, `f(n) = _____`

`log_b(a) = _____`

**Case:** _____

**Final complexity:** `T(n) = _____`

---

## Problem 7: Custom Algorithm Analysis

**Algorithm:** Consider this hypothetical divide-and-conquer algorithm:
```java
public static int mystery(int[] arr, int n) {
    if (n <= 1) return arr[0];
    
    // Divide into 4 parts
    int size = n / 4;
    int result1 = mystery(arr, size);           // 1st recursive call
    int result2 = mystery(arr, size);           // 2nd recursive call  
    int result3 = mystery(arr, size);           // 3rd recursive call
    int result4 = mystery(arr, size);           // 4th recursive call
    
    // O(n²) work to combine results
    return combine(result1, result2, result3, result4, n);
}
```

**Complete the analysis:**

**Recurrence:** `T(n) = _____`

**Values:** `a = _____`, `b = _____`, `f(n) = _____`

**log_b(a) = _____**

**Case:** _____

**Complexity:** `T(n) = _____`

---

## Problem 8: When Master Theorem Doesn't Apply

**Explain why the Master Theorem cannot be applied to these recurrences:**

**a)** `T(n) = T(n-1) + O(1)` (like factorial)

**Reason:** _____

**b)** `T(n) = T(n/2) + T(n/3) + O(n)` 

**Reason:** _____

**c)** `T(n) = 2^n * T(n/2) + O(n)`

**Reason:** _____

**For case (a), what is the actual complexity?** _____

---

## Problem 9: Real-World Application

**Scenario:** You're designing a file system indexing algorithm that:
- Divides the file list into 3 equal parts
- Recursively processes each part  
- Spends O(n) time merging the results

**Write the recurrence relation:** _____

**Analyze using Master Theorem:**

**Values:** `a = _____`, `b = _____`, `f(n) = _____`

**Analysis:** _____

**Final complexity:** _____

**Is this better or worse than a simple O(n log n) sorting approach?** _____

---

## Problem 10: Optimization Challenge

**Given two algorithms for the same problem:**

**Algorithm A:** `T(n) = 8 * T(n/2) + O(n²)`
**Algorithm B:** `T(n) = 4 * T(n/2) + O(n² log n)`

**Analyze both algorithms:**

**Algorithm A:**
- Master Theorem analysis: _____
- Final complexity: _____

**Algorithm B:**  
- Master Theorem analysis: _____
- Final complexity: _____

**Which algorithm is better for large n?** _____

**At approximately what value of n do they perform similarly?** _____

---

## Reflection Questions

**1.** Which case of the Master Theorem seems most common in practice? Why?

**Answer:** _____

**2.** When designing a divide-and-conquer algorithm, what factors affect which Master Theorem case you'll end up in?

**Answer:** _____

**3.** How does the Master Theorem help in algorithm design decisions?

**Answer:** _____

**4.** What are the limitations of the Master Theorem, and when might you need other analysis techniques?

**Answer:** _____

---

## Answer Key (For Instructor Use)

<details>
<summary>Click to reveal answers</summary>

**Problem 1:** T(n) = Θ(log n)
**Problem 2:** T(n) = Θ(n log n)  
**Problem 3:** T(n) = Θ(n)
**Problem 4:** T(n) = Θ(n^2.81)
**Problem 5:** T(n) = Θ(n log² n)
**Problem 6:** T(n) = Θ(n^log₂(3)) ≈ Θ(n^1.58)
**Problem 7:** T(n) = Θ(n²)

</details>