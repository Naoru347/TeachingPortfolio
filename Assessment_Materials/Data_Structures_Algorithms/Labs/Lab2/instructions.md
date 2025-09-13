# Lab 2 – Complexity Exercises

## Overview
Welcome to your second Data Structures & Algorithms lab! This session introduces you to algorithmic analysis – one of the most important skills in computer science. You'll learn to analyze algorithms both theoretically (using Big-O notation) and empirically (through timing experiments).

Understanding complexity analysis is crucial for making informed decisions about which algorithms and data structures to use in your semester project. By the end of this lab, you'll be able to predict algorithm performance and validate your predictions through experimentation.

---

## Learning Objectives
By the end of this lab, you will be able to:
- Analyze simple algorithms using Big-O, Big-Ω, and Big-Θ notation
- Distinguish between best-case, average-case, and worst-case performance
- Design and conduct empirical timing experiments
- Interpret experimental results and compare them to theoretical predictions
- Apply complexity analysis to real algorithm selection decisions

---

## Pre-Lab Preparation (5 minutes)
**Before starting the lab exercises, ensure you have:**
- Completed Lab 1 (environment setup working properly)
- Java compilation and execution working
- Access to your Lab 1 SimpleArrayList implementation
- Notebook or text editor for recording observations

---

## Part 1: Theoretical Complexity Analysis (25 minutes)

### **Exercise 1.1: Basic Loop Analysis (10 minutes)**

Analyze the time complexity of these code snippets. For each one, determine the Big-O complexity and identify what n represents.

**Snippet A:**
```java
public int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}
```

**Snippet B:**
```java
public void printPairs(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[i] + ", " + arr[j]);
        }
    }
}
```

**Snippet C:**
```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

**📝 Record your answers:**
- Snippet A: Big-O = _____, n represents _____
- Snippet B: Big-O = _____, n represents _____  
- Snippet C: Big-O = _____, n represents _____

### **Exercise 1.2: Your SimpleArrayList Analysis (15 minutes)**

Analyze the time complexity of each method in your Lab 1 SimpleArrayList implementation:

**Methods to analyze:**
1. `add(T element)` - both average case and worst case (when resizing occurs)
2. `get(int index)`
3. `size()`
4. `isEmpty()`

**For each method, determine:**
- **Best-case complexity:** What's the fastest this method could run?
- **Average-case complexity:** What's the typical performance?
- **Worst-case complexity:** What's the slowest this method could run?

**📝 Create a table like this:**
| Method | Best Case | Average Case | Worst Case | Explanation |
|--------|-----------|--------------|------------|-------------|
| add()  |           |              |            |             |
| get()  |           |              |            |             |
| size() |           |              |            |             |
| isEmpty() |        |              |            |             |

---

## Part 2: Empirical Timing Experiments (35 minutes)

### **Exercise 2.1: Set Up Timing Infrastructure (10 minutes)**

Download the starter file `ComplexityTester.java` from the course LMS. This file provides timing utilities but you'll implement the algorithms and test methods yourself.

**Starter code provides:**
- `timeOperation(Runnable operation)` - Times any code block
- `generateRandomArray(int size)` - Creates test data
- `nanosToMillis(long nanos)` - Converts timing units
- Helper methods for creating sorted/reverse-sorted arrays

**You'll implement:**
- `linearSearch()` and `bubbleSort()` algorithms
- Test methods that use the timing utilities  
- Data collection and results formatting
```

### **Exercise 2.2: Linear vs Quadratic Algorithm Comparison (15 minutes)**

Implement and time these two algorithms:

**Algorithm 1: Linear Search**
```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

**Algorithm 2: Bubble Sort**
```java
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap elements
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

**Experiment Design:**
Test both algorithms with arrays of sizes: 100, 500, 1000, 2000, 5000

**For Linear Search:**
- Search for an element at the beginning (best case)
- Search for an element at the end (worst case)
- Search for a non-existent element (also worst case)

**For Bubble Sort:**
- Sort a random array
- Sort an already-sorted array (best case)
- Sort a reverse-sorted array (worst case)

**📝 Record your timing results in tables:**

**Linear Search Results (in milliseconds):**
| Array Size | Best Case | Worst Case | Non-existent |
|------------|-----------|------------|--------------|
| 100        |           |            |              |
| 500        |           |            |              |
| 1000       |           |            |              |
| 2000       |           |            |              |
| 5000       |           |            |              |

**Bubble Sort Results (in milliseconds):**
| Array Size | Random Array | Sorted Array | Reverse Sorted |
|------------|--------------|--------------|----------------|
| 100        |              |              |                |
| 500        |              |              |                |
| 1000       |              |              |                |
| 2000       |              |              |                |
| 5000       |              |              |                |

### **Exercise 2.3: ArrayList vs Array Performance (10 minutes)**

Compare the performance of your SimpleArrayList against Java's built-in ArrayList and plain arrays.

**Test this operation:** Adding n elements to the data structure

```java
public static void testArrayListPerformance(int size) {
    // Test your SimpleArrayList
    SimpleArrayList<Integer> myList = new SimpleArrayList<>();
    long myTime = timeOperation(() -> {
        for (int i = 0; i < size; i++) {
            myList.add(i);
        }
    });
    
    // Test Java's ArrayList
    ArrayList<Integer> javaList = new ArrayList<>();
    long javaTime = timeOperation(() -> {
        for (int i = 0; i < size; i++) {
            javaList.add(i);
        }
    });
    
    System.out.printf("Size %d: MyList=%.2fms, JavaList=%.2fms%n", 
                      size, nanosToMillis(myTime), nanosToMillis(javaTime));
}
```

**📝 Test sizes:** 1000, 5000, 10000, 50000, 100000

**Record your observations:**
- How does your SimpleArrayList compare to Java's ArrayList?
- Do you see the expected O(n) growth pattern?
- What might explain any performance differences?

---

## Part 3: Analysis and Reflection (10 minutes)

### **Exercise 3.1: Theory vs Practice Comparison**

**📝 Answer these questions:**

1. **Linear Search Analysis:**
   - Did your timing results match the expected O(n) complexity?
   - What was the ratio between worst-case and best-case times?
   - How did the times change as array size doubled?

2. **Bubble Sort Analysis:**
   - Did your timing results confirm O(n²) complexity?
   - What was the difference between best-case (sorted) and worst-case (reverse sorted)?
   - How did the times change as array size doubled?

3. **ArrayList Comparison:**
   - Why might Java's ArrayList be faster than your implementation?
   - Did both show similar O(n) growth patterns?
   - What optimizations might Java's ArrayList have that yours doesn't?

### **Exercise 3.2: Real-World Applications**

**📝 For your semester project, consider:**

1. **When would you choose linear search vs binary search?**
   - Consider the trade-offs between search speed and data structure requirements

2. **When might O(n²) algorithms be acceptable?**
   - Think about scenarios where simplicity might outweigh efficiency

3. **How will complexity analysis guide your project decisions?**
   - Consider which operations will be most frequent in your application

---

## Deliverable

Submit a **single PDF file** containing:

1. **Theoretical Analysis (Part 1):**
   - Your Big-O analysis for the three code snippets
   - Completed complexity table for your SimpleArrayList methods
   - Brief explanations for your reasoning

2. **Experimental Results (Part 2):**
   - Both timing tables (Linear Search and Bubble Sort)
   - ArrayList comparison results
   - Your `ComplexityTester.java` source code

3. **Analysis and Reflection (Part 3):**
   - Answers to theory vs practice questions
   - Discussion of real-world applications
   - Insights for your semester project

**File Naming Convention:** `Lab2_Lastname_Firstname.pdf`

**Submission Method:** Upload to course LMS under "Lab 2 Submission"

---

## Assessment Criteria

| Category | Weight | Description |
|----------|--------|-------------|
| **Theoretical Analysis** | 30% | Correct Big-O analysis and clear reasoning |
| **Experimental Design** | 25% | Proper timing methodology and complete data collection |
| **Results Interpretation** | 25% | Insightful comparison of theory vs practice |
| **Code Quality** | 20% | Clean, working ComplexityTester implementation |

---

## Troubleshooting Tips

**If timing results seem inconsistent:**
- Run each test multiple times and take the average
- Make sure no other programs are consuming CPU
- Use larger data sizes if times are too small to measure accurately

**If your computer is slow:**
- Reduce the maximum array sizes
- Focus on the growth patterns rather than absolute times
- The relative relationships are more important than exact numbers

**If compilation fails:**
- Make sure your SimpleArrayList from Lab 1 is in the same directory
- Check that all import statements are correct
- Verify Java version compatibility

---

## Optional Extensions

**For students who finish early:**

1. **Implement and time binary search** - Compare with linear search
2. **Test different sorting algorithms** - Add selection sort or insertion sort
3. **Visualize your results** - Create simple graphs showing complexity curves
4. **Test space complexity** - Monitor memory usage during array resizing

---

## Next Week Preview

In Lab 3, you'll implement different types of linked lists and compare their performance characteristics with the array-based structures you analyzed today. Understanding complexity analysis will help you make informed decisions about when to use linked structures vs array-based structures in your semester project.

**Preparation for Lab 3:**
- Review pointer concepts and memory management
- Read textbook Chapter 3 (Linked Lists)
- Think about scenarios where linked lists might outperform arrays