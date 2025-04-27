# **Lab 14: Sorting Algorithm Comparison**

---

## **Objectives**
1. Practice writing pseudocode to plan algorithm implementation.
2. Understand and implement basic sorting algorithms.
3. Compare the runtime performance of sorting algorithms on datasets of different sizes.
4. Analyze the trade-offs between simplicity and efficiency in algorithm design.

---

## **Scenario**
Sorting data efficiently is a key task in many applications, from organizing search results to processing large datasets. In this lab, you will compare two sorting algorithms: **bubble sort** and **selection sort**. By writing pseudocode and implementing these algorithms in Python, you will analyze their performance and understand their strengths and weaknesses.

---

## **Instructions**

### **Step 1: Write Pseudocode for Bubble Sort**
1. In a text file or on paper, write pseudocode for the **bubble sort** algorithm.
   - Bubble sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
2. Ensure your pseudocode includes:
   - A loop to repeat the passes through the list.
   - A nested loop to compare adjacent elements.
   - A condition to swap elements if necessary.

### **Step 2: Implement Bubble Sort in Python**
1. Create a Python function `bubble_sort(arr)` that implements the bubble sort algorithm.
2. Test the function with a small list of numbers (e.g., `[5, 3, 8, 6, 2]`).
3. Print the sorted result to ensure your function works correctly.

### **Step 3: Write Pseudocode for Selection Sort**
1. In the same text file or on paper, write pseudocode for the **selection sort** algorithm.
   - Selection sort repeatedly finds the smallest (or largest) element in the unsorted part of the list and places it at the beginning.
2. Ensure your pseudocode includes:
   - A loop to traverse the unsorted part of the list.
   - A condition to find the smallest element in the unsorted part.
   - A swap operation to place the smallest element in the correct position.

### **Step 4: Implement Selection Sort in Python**
1. Create a Python function `selection_sort(arr)` that implements the selection sort algorithm.
2. Test the function with the same list of numbers you used for bubble sort.
3. Print the sorted result to ensure your function works correctly.

### **Step 5: Compare Runtime Performance**
1. Generate random datasets of different sizes (e.g., 10, 100, 1000 elements) using Python’s `random` module.
   ```python
   import random
   data_small = [random.randint(1, 100) for _ in range(10)]
   data_medium = [random.randint(1, 1000) for _ in range(100)]
   data_large = [random.randint(1, 10000) for _ in range(1000)]
   ```
2. Measure the runtime of both sorting algorithms using Python’s `time` module:
   ```python
   import time
   start = time.time()
   bubble_sort(data_small)
   end = time.time()
   print(f"Bubble Sort Time: {end - start:.6f} seconds")
   ```
3. Record the runtime for each dataset and sorting algorithm in a table.

### **Step 6: Analyze the Results**
1. Create a summary of your findings, including:
   - Which algorithm performed better for small, medium, and large datasets.
   - The advantages and disadvantages of each algorithm.
   - Observations about the scalability of the algorithms.
2. Write a short reflection (1-2 paragraphs) on what you learned about algorithm design and performance analysis.

---

## **Stretch Challenges (Optional)**
1. Implement a more advanced sorting algorithm like **quick sort** or **merge sort**, and compare its performance with bubble sort and selection sort.
2. Visualize the runtime performance using a Python library like `matplotlib`.
3. Modify the sorting algorithms to sort a list of dictionaries by a specific key (e.g., `"name"` or `"age"`).

---

## **Submission Instructions**
1. Submit the following files to the course LMS:
   - `sorting_algorithms.py` (your Python script with both sorting algorithms).
   - A a combined PDF with:
        - Your pseudocode for bubble sort and selection sort.
        - A 1-2 paragraph reflection on your findings.
        - A table or chart summarizing the runtime performance of both algorithms.

---

## **Example Runtime Table**
| Dataset Size | Bubble Sort Time (s) | Selection Sort Time (s) |
|--------------|-----------------------|-------------------------|
| 10           | 0.0001               | 0.0002                 |
| 100          | 0.0055               | 0.0048                 |
| 1000         | 0.4500               | 0.3200                 |

---

## **Hints and Tips**
1. **Pseudocode:** Focus on the logic of the algorithms without worrying about syntax.
2. **Testing:** Test your functions with small datasets before scaling up.
3. **Optimization:** Understand the time complexity of the algorithms (both are O(n²) but behave differently in practice).
4. **Documentation:** Add comments to your code to explain each step of the algorithm.

---

Good luck with your algorithm development and comparison! This lab will deepen your understanding of problem-solving and performance analysis.
