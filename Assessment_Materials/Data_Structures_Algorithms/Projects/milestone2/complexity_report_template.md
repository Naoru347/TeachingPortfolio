# Complexity Report Template

*Milestone 2 – Advanced ADT Extensions*  
*Due: End of Week 11*  
*Weight: 10 %*

---

## 1. Introduction
- **Objective:** Briefly state the purpose of the report (e.g., evaluate empirical performance of your ADT implementations vs. theoretical complexity).  
- **Scope:** List which data structures and methods are benchmarked (e.g., `BinarySearchTree.insert`, `AVLTree.delete`, `HashTable.put`, etc.).

---

## 2. Experimental Setup
### 2.1 Environment
- **Hardware:** CPU model, clock speed, RAM.  
- **Software:** OS version, JDK version, Java compiler flags.  
- **Benchmark Tool:** Describe or link to your benchmark suite (e.g., `benchmark/BSTBenchmark.java`).

### 2.2 Data Sets & Parameters
- **Input Sizes:** Range of `n` values (e.g., 1,000; 10,000; 100,000).  
- **Data Distribution:** Random, sorted, reverse-sorted, or specific patterns.  
- **Repetitions:** Number of runs per measurement to average out noise.

---

## 3. Results
### 3.1 Raw Timing Data
Present tables of average runtime (ms) for each method at different input sizes:

| Method             | n = 1k | n = 10k | n = 100k | ... | Notes               |
|--------------------|-------:|--------:|---------:|-----|---------------------|
| `BST.insert`       |      - |       - |        - |     |                     |
| `AVLTree.search`   |      - |       - |        - |     |                     |

### 3.2 Visualization
Embed or reference plots (e.g., line graphs) showing runtime vs. `n`:

```
// Insert your generated chart images here or link to files in milestone2/benchmarks/
```  

---

## 4. Theoretical vs. Empirical Analysis
| Method             | Theoretical T(n) | Empirical Trend   | Comments                         |
|--------------------|-----------------:|------------------:|----------------------------------|
| `BST.insert`       | O(h) ≈ O(n)      | ~ linear (O(n))   | Matches expectation for unbalanced inputs |
| `AVLTree.insert`   | O(log n)        | ~ logarithmic     | Slight overhead from rotations         |
| `HashTable.put`    | O(1) amortized  | ~ constant       | Degrades slightly at high load factor   |

- **Deviation Explanation:** Discuss any discrepancies (e.g., caching effects, GC pauses).

---

## 5. Conclusion
- **Summary of Findings:** Recap how empirical results align (or not) with theoretical complexities.  
- **Implications:** What do these findings suggest about your implementations and real-world usage?  
- **Recommendations:** Propose optimizations or scenarios where one ADT is preferred over another.

---

*Save this report as `milestone2/docs/complexity_report.md` and submit alongside your benchmarks and code.*

