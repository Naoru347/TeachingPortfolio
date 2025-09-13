# Lab 11: Sorting Module Implementation

## Overview
**Week:** 14  
**Due Date:** Thursday of Week 14, 11:59 PM  
**Points:** 100 points  
**Estimated Time:** 75 minutes (in-lab) + 30 minutes (report writing)

This lab focuses on implementing fundamental comparison sorting algorithms and analyzing their performance characteristics. You'll implement three key sorting algorithms representing different complexity classes, then compare their performance on various datasets to understand when to choose each algorithm.

---

## Learning Objectives

By the end of this lab, you will be able to:

1. **Algorithm Implementation**
   - Implement bubble sort (O(n²) simple algorithm)
   - Implement merge sort (O(n log n) divide-and-conquer algorithm)
   - Implement quicksort (O(n log n) average case, O(n²) worst case)
   - Understand trade-offs between different sorting approaches

2. **Performance Analysis**
   - Measure and compare actual running times of sorting algorithms
   - Understand how input characteristics affect algorithm performance
   - Analyze best-case, average-case, and worst-case scenarios empirically

3. **Algorithm Selection**
   - Choose appropriate sorting algorithms based on data characteristics
   - Understand when simple algorithms outperform complex ones
   - Apply sorting knowledge to real-world programming scenarios

---

## Prerequisites

Before starting this lab, ensure you understand:
- Array manipulation and indexing
- Recursion concepts (for merge sort and quicksort)
- Big-O notation and algorithm complexity analysis
- Basic timing and performance measurement concepts

---

## Setup Instructions

### **Step 1: Download Starter Files**
1. Accept the GitHub Classroom assignment link
2. Clone your repository:
   ```bash
   git clone [your-repo-url]
   cd lab11-sorting-[username]
   ```
3. Verify you have these starter files:
   - `SortingAlgorithms.java` (template with method stubs)
   - `SortingTest.java` (test framework)
   - `PerformanceComparison.java` (timing framework)
   - `ArrayUtils.java` (utility methods - already implemented)
   - `sample_data.txt` (test data)
   - `lab11_report_template.md` (report template)

### **Step 2: Initial Setup Test**
1. Compile and run the starter code:
   ```bash
   javac *.java
   java SortingTest
   ```
2. You should see output indicating which methods need implementation
3. Run the performance test (will show errors until algorithms are implemented):
   ```bash
   java PerformanceComparison
   ```

---

## Part 1: Bubble Sort Implementation (15 minutes)

### **Background: Bubble Sort**
Bubble sort repeatedly steps through the array, compares adjacent elements, and swaps them if they're in the wrong order. It's called "bubble sort" because smaller elements "bubble" to the beginning of the array.

**Time Complexity:** O(n²) in all cases  
**Space Complexity:** O(1) - sorts in-place  
**Stable:** Yes - equal elements maintain relative order

### **Algorithm Steps:**
1. Compare adjacent elements from left to right
2. Swap them if they're in wrong order  
3. After each pass, the largest element "bubbles up" to the end
4. Repeat for n-1 passes (where n is array length)
5. Optimize: stop early if no swaps occur in a pass

### **Implementation Task:**
Complete the `bubbleSort()` method in `SortingAlgorithms.java`:

```java
public static void bubbleSort(int[] array) {
    // TODO: Implement bubble sort
    // Remember to:
    // 1. Use nested loops (outer loop for passes, inner for comparisons)
    // 2. Compare adjacent elements: array[j] and array[j+1]  
    // 3. Swap if array[j] > array[j+1]
    // 4. Optimization: use a flag to detect if array is already sorted
}
```

### **Test Your Implementation:**
```bash
java SortingTest
```
Look for "Bubble sort: PASSED" in the output.

---

## Part 2: Merge Sort Implementation (25 minutes)

### **Background: Merge Sort**
Merge sort uses divide-and-conquer: divide the array into halves, recursively sort each half, then merge the sorted halves back together.

**Time Complexity:** O(n log n) in all cases  
**Space Complexity:** O(n) - requires additional memory for merging  
**Stable:** Yes - can maintain relative order of equal elements

### **Algorithm Steps:**
1. **Divide:** Split array into two halves
2. **Conquer:** Recursively sort both halves
3. **Combine:** Merge the two sorted halves into one sorted array

### **Implementation Task:**
Complete both methods in `SortingAlgorithms.java`:

```java
public static void mergeSort(int[] array) {
    // TODO: Implement merge sort entry point
    // Call mergeSortHelper with appropriate parameters
    // Handle base case (arrays of length 0 or 1)
}

private static void mergeSortHelper(int[] array, int left, int right, int[] temp) {
    // TODO: Implement recursive merge sort
    // 1. Base case: if left >= right, return (single element or invalid range)
    // 2. Find middle point: mid = (left + right) / 2
    // 3. Recursively sort left half: mergeSortHelper(array, left, mid, temp)
    // 4. Recursively sort right half: mergeSortHelper(array, mid+1, right, temp)
    // 5. Merge the sorted halves: merge(array, left, mid, right, temp)
}

private static void merge(int[] array, int left, int mid, int right, int[] temp) {
    // TODO: Implement merge operation
    // 1. Copy both halves into temp array
    // 2. Use three pointers: i (left half), j (right half), k (main array)
    // 3. Compare temp[i] and temp[j], put smaller into array[k]
    // 4. Copy any remaining elements
}
```

### **Test Your Implementation:**
```bash
java SortingTest
```
Look for "Merge sort: PASSED" in the output.

---

## Part 3: Quicksort Implementation (20 minutes)

### **Background: Quicksort**
Quicksort picks a 'pivot' element and partitions the array so elements smaller than the pivot come before it, and larger elements come after. Then it recursively sorts the sub-arrays.

**Time Complexity:** O(n log n) average case, O(n²) worst case  
**Space Complexity:** O(log n) average case due to recursion  
**Stable:** No - relative order of equal elements may change

### **Algorithm Steps:**
1. Choose a pivot element (we'll use the last element)
2. Partition: rearrange array so elements ≤ pivot come before it
3. Recursively quicksort the sub-array before the pivot
4. Recursively quicksort the sub-array after the pivot

### **Implementation Task:**
Complete both methods in `SortingAlgorithms.java`:

```java
public static void quickSort(int[] array) {
    // TODO: Implement quicksort entry point
    // Call quickSortHelper with appropriate parameters
    // Handle base case (arrays of length 0 or 1)
}

private static void quickSortHelper(int[] array, int low, int high) {
    // TODO: Implement recursive quicksort
    // 1. Base case: if low >= high, return
    // 2. Partition array and get pivot position: pivotIndex = partition(array, low, high)
    // 3. Recursively sort left sub-array: quickSortHelper(array, low, pivotIndex - 1)
    // 4. Recursively sort right sub-array: quickSortHelper(array, pivotIndex + 1, high)
}

private static int partition(int[] array, int low, int high) {
    // TODO: Implement partitioning using last element as pivot
    // 1. Choose pivot = array[high]
    // 2. Keep track of position for elements smaller than pivot
    // 3. Iterate through array, swap smaller elements to the left
    // 4. Place pivot in its correct position
    // 5. Return pivot's final position
}
```

### **Test Your Implementation:**
```bash
java SortingTest
```
Look for "Quicksort: PASSED" in the output.

---

## Part 4: Performance Analysis (10 minutes)

### **Understanding Performance Comparison**
Now that all algorithms are implemented, compare their performance on different types of data:

1. **Random data** - typical case for most algorithms
2. **Already sorted data** - best case for some, worst for others  
3. **Reverse sorted data** - worst case for many algorithms
4. **Arrays with duplicates** - tests stability and efficiency

### **Run Performance Tests:**
```bash
java PerformanceComparison
```

This will test all three algorithms on different data types and sizes, measuring:
- **Execution time** in milliseconds
- **Number of comparisons** made
- **Relative performance** between algorithms

### **Analyze the Results:**
Look for patterns in the output:
- Which algorithm is fastest on random data?
- How does performance change with array size?
- Which algorithms perform well on already-sorted data?
- When does quicksort show its worst-case behavior?

---

## Part 5: Report Writing (5 minutes setup, 30 minutes completion)

### **Complete Your Analysis Report**
Using the template `lab11_report_template.md`, write a brief analysis covering:

1. **Algorithm Implementations** (2-3 sentences each)
   - Brief description of how each algorithm works
   - Any implementation challenges you faced

2. **Performance Analysis** (1-2 paragraphs)
   - Which algorithm performed best overall?
   - How did different input types affect performance?
   - Did results match theoretical expectations?

3. **Algorithm Selection Recommendations** (1 paragraph)
   - When would you choose bubble sort?
   - When would you choose merge sort?
   - When would you choose quicksort?

4. **Integration with Semester Project** (1 paragraph)
   - Which sorting algorithm would be best for your project?
   - What characteristics of your project's data influenced this choice?

---

## Testing Requirements

### **Correctness Testing**
Your implementations must pass all tests in `SortingTest.java`:

**Basic Functionality Tests:**
- Empty arrays and single-element arrays
- Arrays with duplicate elements
- Already sorted and reverse sorted arrays
- Random arrays of various sizes

**Stability Tests (for stable algorithms):**
- Verify that equal elements maintain relative order
- Test with arrays containing many duplicate values

### **Performance Testing**
Your `PerformanceComparison.java` should demonstrate:
- Timing measurements for all three algorithms
- Testing on different input types (random, sorted, reverse, duplicates)
- Clear output showing performance differences

---

## Submission Requirements

Submit the following files to GitHub Classroom:

### **Required Files:**
1. **`SortingAlgorithms.java`** - Complete implementations of all three sorting algorithms
2. **`SortingTest.java`** - Any additional tests you created (optional)
3. **`PerformanceComparison.java`** - Any modifications to the performance testing (optional)
4. **`lab11_report.md`** - Completed analysis report following the template
5. **`performance_results.txt`** - Copy of your performance test output

### **Repository Organization:**
```
lab11-sorting-[username]/
├── src/
│   ├── SortingAlgorithms.java
│   ├── SortingTest.java
│   ├── PerformanceComparison.java
│   └── ArrayUtils.java (provided)
├── data/
│   ├── sample_data.txt (provided)
│   └── performance_results.txt
├── lab11_report.md
└── README.md
```

### **Submission Checklist:**
- [ ] All three sorting algorithms implemented and tested
- [ ] Performance comparison runs without errors
- [ ] Report completed with analysis and recommendations
- [ ] Code is well-commented and follows Java conventions
- [ ] All files committed and pushed to GitHub
- [ ] Repository is clean and organized

### **Git Workflow:**
```bash
# After completing each algorithm:
git add .
git commit -m "Implemented bubble sort" # (or merge sort, quicksort)
git push

# Final submission:
git add .
git commit -m "Completed Lab 11: Sorting algorithms and analysis"
git push
```

---

## Assessment Rubric

| **Category** | **Excellent (90-100%)** | **Good (80-89%)** | **Satisfactory (70-79%)** | **Needs Improvement (0-69%)** | **Weight** |
|--------------|-------------------------|-------------------|---------------------------|------------------------------|------------|
| **Algorithm Implementation** | All three algorithms correctly implemented; handles all edge cases; efficient and clean code; excellent comments | Good implementations with minor issues; handles most edge cases; generally efficient; adequate comments | Basic implementations work for simple cases; some edge case issues; acceptable efficiency; minimal comments | Major implementation errors; doesn't handle edge cases; poor efficiency; inadequate comments | **50%** |
| **Performance Analysis** | Comprehensive performance testing; insightful analysis of results; clear understanding of complexity trade-offs; identifies patterns correctly | Good performance testing; solid analysis; understands most complexity trade-offs; identifies main patterns | Basic performance testing; limited analysis; understands some complexity concepts; identifies obvious patterns | Minimal performance testing; poor analysis; limited understanding; fails to identify patterns | **25%** |
| **Technical Report** | Excellent analysis report; clear algorithm explanations; insightful performance discussion; thoughtful project integration | Good report with solid explanations; adequate performance discussion; reasonable project integration | Basic report meeting requirements; simple explanations; limited performance discussion; minimal project integration | Poor report quality; inadequate explanations; little performance discussion; no project integration | **15%** |
| **Code Quality & Testing** | Clean, well-organized code; comprehensive testing; excellent documentation; follows Java conventions perfectly | Good code organization; adequate testing; good documentation; follows most conventions | Functional code with some organization issues; basic testing; adequate documentation; some convention violations | Poorly organized code; minimal testing; poor documentation; many convention violations | **10%** |

### **Grade Scale:**
- **A (90-100%)**: Exceptional understanding of sorting algorithms and performance analysis
- **B (80-89%)**: Good grasp of concepts with solid implementations
- **C (70-79%)**: Satisfactory understanding meeting basic requirements
- **D (60-69%)**: Below expectations with significant issues
- **F (0-59%)**: Failing to demonstrate minimum competency

---

## Getting Help

### **Before Asking for Help:**
1. **Test incrementally** - implement and test each algorithm one at a time
2. **Use the debugger** - step through your sorting algorithms with small arrays
3. **Print intermediate steps** - add System.out.println() to see what your algorithm is doing
4. **Check array bounds** - ensure you're not accessing invalid indices
5. **Verify test cases** - run `SortingTest` after each implementation

### **Office Hours Topics:**
- Algorithm logic and implementation strategies
- Debugging infinite loops or incorrect sorting
- Understanding recursion in merge sort and quicksort
- Performance measurement and analysis techniques
- Interpreting timing results and complexity trade-offs

### **Common Questions & Quick Answers:**

**Q: "My sorting algorithm runs forever"**  
A: Check your loop conditions and array bounds. Add print statements to see the current state.

**Q: "My algorithm doesn't sort correctly"**  
A: Test with a small array (3-4 elements) and trace through step by step on paper.

**Q: "Performance results don't match theory"**  
A: Small arrays may not show theoretical behavior. Try larger arrays (1000+ elements).

**Q: "How do I know if my algorithm is stable?"**  
A: Test with duplicate values and verify their relative positions don't change.

### **Collaboration Policy:**
- **Discuss sorting concepts and approaches freely**
- **Share debugging strategies and testing techniques**
- **Help classmates understand algorithm logic**
- **Do NOT share actual implementation code**
- **All submitted code must be your own individual work**

---

## Resources

### **Required Reading:**
- Textbook Chapter 12: Sorting Algorithms
- Course notes on divide-and-conquer algorithms
- Algorithm complexity analysis materials

### **Helpful Visualizations:**
- [Sorting Algorithm Visualizer](https://www.sortvisualizer.com/)
- [Bubble Sort Animation](https://visualgo.net/en/sorting)
- [Merge Sort Step-by-Step](https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/visualize/)
- [Quicksort Visualization](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)

### **Reference Materials:**
- Java Arrays class documentation
- Big-O complexity cheat sheets
- Algorithm performance comparison charts

### **When to Use Each Algorithm:**
- **Bubble Sort**: Educational purposes, very small datasets, when simplicity is paramount
- **Merge Sort**: When stability is required, consistent O(n log n) performance needed, large datasets
- **Quicksort**: General-purpose sorting, when average-case performance matters most, memory-constrained environments

---

## Extension Opportunities (Optional)

If you finish early or want additional challenges:

1. **Implement optimizations:**
   - Add early termination to bubble sort
   - Use median-of-three pivot selection for quicksort
   - Implement hybrid sort (quicksort + insertion sort for small arrays)

2. **Add more algorithms:**
   - Selection sort (another O(n²) algorithm)
   - Insertion sort (good for small arrays)
   - Heap sort (guaranteed O(n log n))

3. **Enhanced analysis:**
   - Count exact number of comparisons and swaps
   - Measure memory usage
   - Test with different data distributions

4. **Real-world integration:**
   - Sort strings instead of integers
   - Sort custom objects using Comparable interface
   - Implement parallel quicksort

---

**Final Note:** Sorting algorithms are fundamental to computer science and appear in countless real-world applications. The three algorithms you implement today represent different design philosophies and trade-offs. Understanding when and why to choose each algorithm will serve you throughout your programming career. Focus on understanding the logic behind each algorithm, not just getting them to work - this knowledge transfers to many other algorithmic problems you'll encounter.