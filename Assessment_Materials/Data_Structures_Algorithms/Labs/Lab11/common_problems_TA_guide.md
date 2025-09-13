# Common Problems Guide - Lab 11: Sorting Module
*Quick Reference for TAs Working with Students*

---

## How to Use This Guide
1. **Identify the symptom** from student's description
2. **Run the diagnostic steps** to confirm the cause
3. **Guide student through the solution** (don't fix it for them!)
4. **Verify the fix** with test cases

---

## 💥 ARRAY INDEX OUT OF BOUNDS

### **Symptom:** ArrayIndexOutOfBoundsException during sorting
**Student says:** "My program crashes with array index error"

### **Quick Diagnostic:**
```java
// Add this temporarily to see what's happening:
System.out.println("Array length: " + array.length);
System.out.println("Accessing index: " + j); // or whatever index variable
```

### **Common Cause #1: Bubble Sort Loop Bounds**
```java
// WRONG - goes one index too far
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - 1; j++) {  // ❌ Should be n-1-i
        if (array[j] > array[j + 1]) {  // ❌ Will access array[n] eventually
            // swap
        }
    }
}
```

**Solution Steps:**
1. **Ask:** "How many passes do you need for n elements?"
2. **Explain:** "After pass i, the i largest elements are in place"
3. **Guide them to fix:**
```java
// CORRECT - reduces range each pass
for (int i = 0; i < n - 1; i++) {          // Only n-1 passes needed
    for (int j = 0; j < n - 1 - i; j++) {  // ✅ Reduce range each pass
        if (array[j] > array[j + 1]) {
            // swap
        }
    }
}
```

### **Common Cause #2: Merge Sort Bounds Error**
```java
// WRONG - incorrect mid calculation or bounds
int mid = left + right / 2;  // ❌ Operator precedence issue
// Should be: int mid = (left + right) / 2;

merge(array, left, mid, right + 1, temp);  // ❌ Wrong right bound
```

**Solution:** Guide them to check:
- Parentheses in mid calculation
- Recursive call bounds: left to mid, mid+1 to right
- Merge parameters match the ranges

### **Test Fix:**
Try with small arrays: `{3, 1, 4}`, `{5, 2}`, `{1}`

---

## ♾️ INFINITE LOOPS / STACK OVERFLOW

### **Symptom:** Program hangs or crashes with StackOverflowError
**Student says:** "My sorting never finishes" or "Stack overflow error"

### **For Bubble Sort Infinite Loop:**

**Common Cause: Missing Loop Increment**
```java
// WRONG - missing increment
int i = 0;
while (i < n) {
    // ... sorting logic
    // ❌ Forgot to increment i!
}
```

**Quick Fix:** Add the missing increment or use for-loop instead.

### **For Merge Sort Stack Overflow:**

**Common Cause #1: Missing Base Case**
```java
// WRONG - no base case
public static void mergeSort(int[] array, int left, int right) {
    int mid = (left + right) / 2;
    mergeSort(array, left, mid);      // ❌ Always recurses
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}
```

**Solution:**
```java
// CORRECT - add base case
public static void mergeSort(int[] array, int left, int right) {
    if (left >= right) return;  // ✅ Base case stops recursion
    
    int mid = (left + right) / 2;
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}
```

**Common Cause #2: Wrong Recursive Parameters**
```java
// WRONG - not reducing problem size
mergeSort(array, left, right);  // ❌ Same parameters = infinite recursion
```

**Diagnostic Questions:**
1. "What's your base case?"
2. "Are your recursive calls getting smaller ranges?"
3. "Let's trace through a 2-element array"

### **For Quicksort Stack Overflow:**

**Common Cause: Bad Partition**
```java
// WRONG - partition returns same bounds
private static int partition(int[] array, int low, int high) {
    // Buggy partition that doesn't move pivot
    return low;  // ❌ Or return high; - no progress made
}
```

**Test Fix:**
```java
// Test partition independently:
int[] test = {3, 7, 1, 9, 5};
int pivotPos = partition(test, 0, 4);
System.out.println("Pivot position: " + pivotPos);
System.out.println("Array after partition: " + Arrays.toString(test));
// Pivot should be between original position and final position
```

---

## ❌ SORTING DOESN'T WORK (WRONG OUTPUT)

### **Symptom:** Algorithm completes but array isn't sorted
**Student says:** "My sort runs but doesn't sort correctly"

### **For Bubble Sort Issues:**

**Common Cause: Missing Swap**
```java
// WRONG - comparing but not swapping
if (array[j] > array[j + 1]) {
    // ❌ Found elements out of order but didn't swap!
}
```

**Solution:**
```java
if (array[j] > array[j + 1]) {
    // ✅ Actually swap the elements
    int temp = array[j];
    array[j] = array[j + 1];
    array[j + 1] = temp;
}
```

### **For Merge Sort Issues:**

**Common Cause: Broken Merge Operation**
```java
// WRONG - incorrect merge logic
private static void merge(int[] array, int left, int mid, int right, int[] temp) {
    int i = left, j = mid, k = left;  // ❌ j should be mid + 1
    
    while (i <= mid && j <= right) {
        if (temp[i] <= temp[j]) {  // ❌ Should compare array elements first
            array[k++] = temp[i++];
        }
    }
}
```

**Debugging Steps:**
1. **Test merge separately:** Create array with two sorted halves
2. **Trace merge step:** Show exactly what elements should be compared
3. **Check copying:** Verify all elements get copied back to main array

**Correct merge pattern:**
```java
// Copy to temp array first
for (int x = left; x <= right; x++) {
    temp[x] = array[x];
}

// Merge from temp back to array
int i = left, j = mid + 1, k = left;
while (i <= mid && j <= right) {
    if (temp[i] <= temp[j]) {
        array[k++] = temp[i++];
    } else {
        array[k++] = temp[j++];
    }
}

// Copy remaining elements
while (i <= mid) array[k++] = temp[i++];
while (j <= right) array[k++] = temp[j++];
```

### **For Quicksort Issues:**

**Common Cause: Incorrect Partition**
```java
// WRONG - partition doesn't properly separate elements
private static int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low;  // ❌ Should be low - 1
    
    for (int j = low; j < high; j++) {
        if (array[j] <= pivot) {
            swap(array, i, j);
            i++;  // ❌ Should increment i BEFORE swap
        }
    }
}
```

**Visual debugging:**
```java
// Add prints to see partitioning:
System.out.println("Before partition: " + Arrays.toString(array));
System.out.println("Pivot: " + pivot);
int result = partition(array, low, high);
System.out.println("After partition: " + Arrays.toString(array));
System.out.println("Pivot now at position: " + result);
```

### **Test Fix:**
Use these simple test cases:
- `{3, 1, 2}` - should become `{1, 2, 3}`
- `{1, 2, 3}` - already sorted, should stay same
- `{3, 2, 1}` - reverse sorted
- `{2, 2, 2}` - all duplicates

---

## 🐌 PERFORMANCE ISSUES

### **Symptom:** Performance test shows unexpected results
**Student says:** "My timing results don't make sense"

### **Common Cause #1: Testing Too-Small Arrays**
```java
// WRONG - arrays too small for meaningful timing
int[] smallArray = {3, 1, 4, 1, 5};  // Only 5 elements
long startTime = System.currentTimeMillis();
bubbleSort(smallArray);
long endTime = System.currentTimeMillis();
System.out.println("Time: " + (endTime - startTime)); // Often prints 0
```

**Solution:** Use larger arrays (1000+ elements) for timing tests.

### **Common Cause #2: Not Timing Correctly**
```java
// WRONG - including array creation in timing
long startTime = System.currentTimeMillis();
int[] array = generateRandomArray(1000);  // ❌ Don't time array creation
bubbleSort(array);
long endTime = System.currentTimeMillis();
```

**Correct timing pattern:**
```java
int[] array = generateRandomArray(1000);  // Create array first
long startTime = System.nanoTime();        // Use nanoTime for precision
bubbleSort(array);
long endTime = System.nanoTime();
double milliseconds = (endTime - startTime) / 1_000_000.0;
```

### **Common Cause #3: Not Testing Correct Algorithm**
**Student says:** "Bubble sort is faster than merge sort"

**Diagnostic questions:**
1. "Did you implement bubble sort correctly?"
2. "Are you testing the same array size for all algorithms?"
3. "Are you using the same input data?"

**Usually indicates:** Bubble sort implementation is wrong/incomplete, or using very small arrays.

---

## 🔧 COMPILATION ERRORS

### **Symptom:** Code won't compile
**Student says:** "I'm getting compiler errors"

### **Common Error: Missing Method Parameters**
```java
// WRONG - calling helper method without temp array parameter
public static void mergeSort(int[] array) {
    mergeSortHelper(array, 0, array.length - 1);  // ❌ Missing temp parameter
}

private static void mergeSortHelper(int[] array, int left, int right, int[] temp) {
    // Method signature expects temp array
}
```

**Solution:** Create temp array and pass it:
```java
public static void mergeSort(int[] array) {
    int[] temp = new int[array.length];
    mergeSortHelper(array, 0, array.length - 1, temp);  // ✅ Pass temp array
}
```

### **Common Error: Method Visibility**
```java
// WRONG - helper methods should be private
public static void mergeSortHelper(...) {  // ❌ Should be private
```

**Solution:** Make helper methods private:
```java
private static void mergeSortHelper(...) {  // ✅ Private helper
```

---

## 📊 TESTING PROBLEMS

### **Symptom:** SortingTest.java fails
**Student says:** "My tests aren't passing"

### **Quick Diagnostic Steps:**
1. **Test each algorithm individually:**
```java
int[] test = {3, 1, 4, 1, 5};
System.out.println("Before: " + Arrays.toString(test));
bubbleSort(test);
System.out.println("After: " + Arrays.toString(test));
// Should print: After: [1, 1, 3, 4, 5]
```

2. **Check edge cases:**
```java
// Test these cases:
bubbleSort(new int[]{});        // Empty array
bubbleSort(new int[]{5});       // Single element  
bubbleSort(new int[]{2, 1});    // Two elements
bubbleSort(new int[]{1, 1, 1}); // All duplicates
```

3. **Verify method signatures match:**
```java
// Make sure your methods match exactly:
public static void bubbleSort(int[] array)
public static void mergeSort(int[] array)  
public static void quickSort(int[] array)
```

### **Common Test Failures:**

**"Method not implemented" errors:**
- Check that method body isn't just `// TODO` comment
- Verify method actually modifies the array (doesn't just return)

**"Wrong sorting result" errors:**
- Test with simple case manually: `{3, 1, 2}`
- Add debug prints to see what algorithm is doing
- Check if algorithm is modifying original array vs. creating new one

---

## 🆘 EMERGENCY DEBUGGING COMMANDS

### **When Student is Completely Stuck:**

**1. Test Bubble Sort with Prints:**
```java
public static void bubbleSort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
        System.out.println("Pass " + i + ": " + Arrays.toString(array));
        boolean swapped = false;
        for (int j = 0; j < n - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                System.out.println("  Swapping " + array[j] + " and " + array[j+1]);
                // swap
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break; // Early termination optimization
    }
}
```

**2. Test Merge Operation Separately:**
```java
// Create array with two sorted halves for testing merge
int[] testMerge = {1, 3, 5, 2, 4, 6}; // [1,3,5] and [2,4,6]
int[] temp = new int[6];
merge(testMerge, 0, 2, 5, temp);
System.out.println("Merged result: " + Arrays.toString(testMerge));
// Should print: [1, 2, 3, 4, 5, 6]
```

**3. Test Partition Function:**
```java
int[] testPartition = {3, 7, 1, 9, 5}; // Pivot is 5
System.out.println("Before partition: " + Arrays.toString(testPartition));
int pivotIndex = partition(testPartition, 0, 4);
System.out.println("After partition: " + Arrays.toString(testPartition));
System.out.println("Pivot at position: " + pivotIndex);
// Should show elements ≤5 on left, >5 on right, 5 at pivotIndex
```

**4. Minimal Working Examples:**
```java
// These should work for any correctly implemented sorting algorithm:
int[] tiny = {2, 1};
bubbleSort(tiny.clone()); // or mergeSort, quickSort
System.out.println("Sorted 2 elements: " + Arrays.toString(tiny));

int[] small = {3, 1, 4, 1, 5, 9, 2};
mergeSort(small.clone());
System.out.println("Sorted 7 elements: " + Arrays.toString(small));
```

---

## ⚡ QUICK FIXES CHECKLIST

**Before diving deep, check these common issues:**

**For Array Bounds Errors:**
- [ ] Loop bounds use `< n-1` not `< n` for comparisons
- [ ] Recursive calls use `left < right` not `left <= right`
- [ ] Array access uses valid indices (0 to length-1)

**For Wrong Results:**
- [ ] Actually swapping elements in bubble sort
- [ ] Merge operation copies all elements back
- [ ] Partition operation moves pivot to correct position
- [ ] Base cases prevent infinite recursion

**For Performance Issues:**
- [ ] Testing with arrays of 1000+ elements
- [ ] Using `System.nanoTime()` for precision timing
- [ ] Not including array creation in timing measurements
- [ ] Algorithms are actually implemented correctly

**For Compilation Errors:**
- [ ] Method signatures match exactly (public static void)
- [ ] Helper methods are private
- [ ] All required parameters are passed to helper methods
- [ ] No syntax errors in method implementations

---

## 🎯 WHEN TO ESCALATE TO INSTRUCTOR

**Escalate when:**
- Student has fundamental misunderstanding of algorithm after multiple explanations
- Code structure is completely wrong and needs architectural changes
- Student is asking about advanced optimizations beyond lab scope
- Persistent confusion about recursion concepts after hands-on examples

**Don't escalate for:**
- Off-by-one errors that can be debugged systematically
- Missing swaps or incorrect comparisons
- Method signature mismatches
- Simple performance measurement issues

---

**Remember:** Most sorting algorithm bugs follow predictable patterns. Guide students through systematic debugging with small examples rather than fixing their code directly. The debugging process teaches problem-solving skills that transfer to other programming challenges!