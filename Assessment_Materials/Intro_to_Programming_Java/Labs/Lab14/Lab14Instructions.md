# **Lab 14: Sorting Algorithm Comparison (Java Version)**

---

## **Objectives**
1. Practice writing pseudocode to plan algorithm implementation.
2. Understand and implement basic sorting algorithms in Java.
3. Compare the runtime performance of sorting algorithms on datasets of different sizes.
4. Analyze the trade-offs between simplicity and efficiency in algorithm design.

---

## **Scenario**
Sorting data efficiently is a key task in many applications, from organizing search results to processing large datasets. In this lab, you will compare two sorting algorithms: **bubble sort** and **selection sort**. By writing pseudocode and implementing these algorithms in Java, you will analyze their performance and understand their strengths and weaknesses.

---

## **Instructions**

### **Step 1: Write Pseudocode for Bubble Sort**
1. In a text file or on paper, write pseudocode for the **bubble sort** algorithm.
   - Bubble sort repeatedly steps through the array, compares adjacent elements, and swaps them if they are in the wrong order.
2. Your pseudocode should include:
   - A loop to repeat passes through the array.
   - A nested loop to compare and possibly swap adjacent elements.

### **Step 2: Implement Bubble Sort in Java**
1. Create a Java method `public static void bubbleSort(int[] arr)` that implements bubble sort.
2. Test it using a small array (e.g., `{5, 3, 8, 6, 2}`) and print the sorted result.

### **Step 3: Write Pseudocode for Selection Sort**
1. In the same text file or notebook, write pseudocode for **selection sort**.
   - Selection sort repeatedly finds the smallest value from the unsorted part of the array and places it at the beginning.
2. Your pseudocode should include:
   - A loop to iterate over the unsorted portion.
   - A condition to find the minimum element and swap it.

### **Step 4: Implement Selection Sort in Java**
1. Create a Java method `public static void selectionSort(int[] arr)`.
2. Test it using the same sample array and print the sorted result.

### **Step 5: Compare Runtime Performance**
1. Generate random integer arrays of sizes 10, 100, and 1000 using `java.util.Random`.
2. Measure the execution time of each algorithm using `System.nanoTime()`:
```java
long start = System.nanoTime();
bubbleSort(data);
long end = System.nanoTime();
System.out.println("Bubble Sort Time: " + (end - start) / 1e6 + " ms");
```
3. Record the runtime for each dataset size and algorithm in a table.

### **Step 6: Analyze the Results**
1. Summarize your findings, including:
   - Which algorithm was faster for each dataset.
   - Advantages and limitations of both algorithms.
   - Observations on performance scalability.
2. Write a 1-2 paragraph reflection on your observations and lessons learned about algorithm design and performance.

---

## **Stretch Challenges (Optional)**
1. Implement a more efficient algorithm (e.g., quick sort or merge sort) and compare runtimes.
2. Visualize runtime differences using a charting library like JFreeChart.
3. Modify the sorting algorithms to sort an array of objects (e.g., a list of `Student` objects by GPA).

---

## **Submission Instructions**
1. Submit the following to your GitHub Classroom repository:
   - A Java file named `SortingAlgorithms.java` with your implementations.
   - A PDF with:
     - Your pseudocode for both sorting algorithms.
     - A short reflection.
     - A table or chart summarizing runtimes.

---

## **Example Runtime Table**
| Dataset Size | Bubble Sort Time (ms) | Selection Sort Time (ms) |
|--------------|------------------------|----------------------------|
| 10           | 0.10                   | 0.20                       |
| 100          | 5.50                   | 4.80                       |
| 1000         | 450.00                 | 320.00                     |

---

## **Hints and Tips**
1. **Pseudocode:** Focus on the logic; worry about syntax later.
2. **Testing:** Start small to confirm correctness before scaling up.
3. **Time Complexity:** Understand that both algorithms are O(n^2), but actual performance may vary.
4. **Documentation:** Comment your code clearly to explain how your sorting algorithms work.

---

Good luck with your sorting algorithm lab! This exercise will help strengthen your skills in algorithm design, analysis, and Java programming.