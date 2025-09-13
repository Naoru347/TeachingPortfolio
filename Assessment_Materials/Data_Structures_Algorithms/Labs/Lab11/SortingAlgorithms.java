/**
 * Lab 11: Sorting Module Implementation
 * 
 * This class contains implementations of three fundamental sorting algorithms:
 * - Bubble Sort: Simple O(n²) algorithm using adjacent comparisons
 * - Merge Sort: Divide-and-conquer O(n log n) algorithm
 * - Quicksort: Partitioning-based O(n log n) average case algorithm
 * 
 * @author [Your Name]
 * @version Lab 11
 */
public class SortingAlgorithms {
    
    // =============================================================================
    // BUBBLE SORT IMPLEMENTATION
    // =============================================================================
    
    /**
     * Sorts an array using the bubble sort algorithm.
     * 
     * Algorithm: Repeatedly step through the array, compare adjacent elements,
     * and swap them if they're in the wrong order. Continue until no swaps are needed.
     * 
     * Time Complexity: O(n²) in all cases
     * Space Complexity: O(1) - sorts in-place
     * Stable: Yes - equal elements maintain relative order
     * 
     * @param array the array to sort (modified in-place)
     */
    public static void bubbleSort(int[] array) {
        // TODO: Implement bubble sort
        
        // Algorithm steps:
        // 1. Use nested loops - outer loop for passes, inner loop for comparisons
        // 2. In each pass, compare adjacent elements: array[j] and array[j+1]
        // 3. Swap if array[j] > array[j+1] (for ascending order)
        // 4. After each pass, the largest unsorted element "bubbles up" to the end
        // 5. Reduce the range of inner loop each pass (last i elements are sorted)
        
        // Hints:
        // - You need n-1 passes for n elements
        // - Inner loop should go from 0 to n-1-i (where i is pass number)
        // - Don't forget to actually swap the elements!
        
        // Optional optimization: use a flag to detect if array is already sorted
        // If no swaps occur in a pass, the array is sorted and you can break early
        
        int n = array.length;
        
        // Your implementation here
        
    }
    
    // =============================================================================
    // MERGE SORT IMPLEMENTATION  
    // =============================================================================
    
    /**
     * Sorts an array using the merge sort algorithm.
     * 
     * Algorithm: Divide array into halves, recursively sort each half,
     * then merge the sorted halves back together.
     * 
     * Time Complexity: O(n log n) in all cases
     * Space Complexity: O(n) - requires temporary array for merging
     * Stable: Yes - equal elements maintain relative order
     * 
     * @param array the array to sort (modified in-place)
     */
    public static void mergeSort(int[] array) {
        // TODO: Implement merge sort entry point
        
        // This is the public interface method. It should:
        // 1. Handle edge cases (empty array or single element)
        // 2. Create a temporary array for merging operations
        // 3. Call the recursive helper method with appropriate parameters
        
        // Hint: You'll need a temp array of the same size as the input array
        // This temp array can be reused throughout the recursion for efficiency
        
        if (array == null || array.length <= 1) {
            return; // Nothing to sort
        }
        
        // Your implementation here
        
    }
    
    /**
     * Recursive helper method for merge sort.
     * 
     * @param array the array being sorted
     * @param left the starting index of the range to sort
     * @param right the ending index of the range to sort (inclusive)
     * @param temp temporary array for merging operations
     */
    private static void mergeSortHelper(int[] array, int left, int right, int[] temp) {
        // TODO: Implement recursive merge sort helper
        
        // Algorithm steps:
        // 1. Base case: if left >= right, return (single element or invalid range)
        // 2. Find middle point: mid = (left + right) / 2
        // 3. Recursively sort left half: mergeSortHelper(array, left, mid, temp)
        // 4. Recursively sort right half: mergeSortHelper(array, mid+1, right, temp)
        // 5. Merge the two sorted halves: merge(array, left, mid, right, temp)
        
        // Important: Make sure your recursive calls work on smaller ranges!
        // left to mid, and mid+1 to right
        
        // Your implementation here
        
    }
    
    /**
     * Merges two sorted subarrays into one sorted subarray.
     * 
     * @param array the array containing both subarrays
     * @param left the start index of the first subarray
     * @param mid the end index of the first subarray (first subarray is left to mid)
     * @param right the end index of the second subarray (second subarray is mid+1 to right)
     * @param temp temporary array for merging
     */
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        // TODO: Implement merge operation
        
        // This is the heart of merge sort - combining two sorted arrays into one
        // 
        // Algorithm steps:
        // 1. Copy both subarrays into the temp array
        // 2. Use three pointers:
        //    - i: current position in left subarray
        //    - j: current position in right subarray  
        //    - k: current position in main array where we're writing
        // 3. Compare temp[i] and temp[j], put the smaller one into array[k]
        // 4. Advance the appropriate pointers
        // 5. Copy any remaining elements from either subarray
        
        // Step 1: Copy data to temp array
        // for (int x = left; x <= right; x++) {
        //     temp[x] = array[x];
        // }
        
        // Step 2-5: Merge logic
        // int i = left;     // Start of left subarray in temp
        // int j = mid + 1;  // Start of right subarray in temp
        // int k = left;     // Start position in main array
        
        // Your implementation here
        
    }
    
    // =============================================================================
    // QUICKSORT IMPLEMENTATION
    // =============================================================================
    
    /**
     * Sorts an array using the quicksort algorithm.
     * 
     * Algorithm: Choose a pivot element, partition the array so elements
     * smaller than pivot come before it, then recursively sort the subarrays.
     * 
     * Time Complexity: O(n log n) average case, O(n²) worst case
     * Space Complexity: O(log n) average case due to recursion
     * Stable: No - equal elements may change relative order
     * 
     * @param array the array to sort (modified in-place)
     */
    public static void quickSort(int[] array) {
        // TODO: Implement quicksort entry point
        
        // This is the public interface method. It should:
        // 1. Handle edge cases (empty array or single element)
        // 2. Call the recursive helper method with appropriate parameters
        
        if (array == null || array.length <= 1) {
            return; // Nothing to sort
        }
        
        // Your implementation here
        
    }
    
    /**
     * Recursive helper method for quicksort.
     * 
     * @param array the array being sorted
     * @param low the starting index of the range to sort
     * @param high the ending index of the range to sort (inclusive)
     */
    private static void quickSortHelper(int[] array, int low, int high) {
        // TODO: Implement recursive quicksort helper
        
        // Algorithm steps:
        // 1. Base case: if low >= high, return (single element or invalid range)
        // 2. Partition the array and get pivot position: 
        //    pivotIndex = partition(array, low, high)
        // 3. Recursively sort left subarray: quickSortHelper(array, low, pivotIndex - 1)
        // 4. Recursively sort right subarray: quickSortHelper(array, pivotIndex + 1, high)
        
        // After partitioning, the pivot is in its correct final position,
        // so we don't include it in the recursive calls
        
        // Your implementation here
        
    }
    
    /**
     * Partitions the array around a pivot element.
     * 
     * After partitioning:
     * - All elements <= pivot are to the left of the pivot
     * - All elements > pivot are to the right of the pivot
     * - The pivot is in its correct final sorted position
     * 
     * @param array the array to partition
     * @param low the starting index of the range to partition
     * @param high the ending index of the range to partition (inclusive)
     * @return the final position of the pivot element
     */
    private static int partition(int[] array, int low, int high) {
        // TODO: Implement partitioning using last element as pivot
        
        // We'll use the last element as our pivot (array[high])
        // This is called "Lomuto partition scheme"
        //
        // Algorithm steps:
        // 1. Choose pivot = array[high] (last element)
        // 2. Keep track of the position where elements <= pivot should go
        // 3. Scan through the array from low to high-1:
        //    - If current element <= pivot, swap it to the "small elements" section
        // 4. Finally, place the pivot in its correct position
        // 5. Return the pivot's final position
        
        // Variables you'll need:
        // int pivot = array[high];  // The pivot element
        // int i = low - 1;          // Position of last element <= pivot
        
        // Loop through array[low] to array[high-1]:
        // for (int j = low; j < high; j++) {
        //     if (array[j] <= pivot) {
        //         i++;
        //         swap(array, i, j);
        //     }
        // }
        
        // Place pivot in correct position:
        // swap(array, i + 1, high);
        // return i + 1;
        
        // Your implementation here
        return -1; // Replace with correct return value
    }
    
    // =============================================================================
    // UTILITY METHODS
    // =============================================================================
    
    /**
     * Swaps two elements in an array.
     * 
     * @param array the array containing the elements to swap
     * @param i index of first element
     * @param j index of second element
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * Prints an array in a readable format.
     * Useful for debugging your sorting algorithms.
     * 
     * @param array the array to print
     * @param label a label to identify what the array represents
     */
    public static void printArray(int[] array, String label) {
        System.out.print(label + ": [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // =============================================================================
    // TESTING MAIN METHOD (OPTIONAL)
    // =============================================================================
    
    /**
     * Simple test method for debugging your implementations.
     * You can run this to test your algorithms with small arrays.
     */
    public static void main(String[] args) {
        System.out.println("Testing Sorting Algorithms");
        System.out.println("=========================");
        
        // Test data
        int[] test1 = {64, 34, 25, 12, 22, 11, 90};
        int[] test2 = {5, 2, 4, 6, 1, 3};
        int[] test3 = {1}; // Single element
        int[] test4 = {}; // Empty array
        int[] test5 = {3, 3, 3, 3}; // All duplicates
        
        // Test Bubble Sort
        System.out.println("\n--- Testing Bubble Sort ---");
        int[] bubbleTest = test1.clone();
        printArray(bubbleTest, "Before");
        bubbleSort(bubbleTest);
        printArray(bubbleTest, "After ");
        
        // Test Merge Sort
        System.out.println("\n--- Testing Merge Sort ---");
        int[] mergeTest = test1.clone();
        printArray(mergeTest, "Before");
        mergeSort(mergeTest);
        printArray(mergeTest, "After ");
        
        // Test Quicksort
        System.out.println("\n--- Testing Quicksort ---");
        int[] quickTest = test1.clone();
        printArray(quickTest, "Before");
        quickSort(quickTest);
        printArray(quickTest, "After ");
        
        // Test edge cases
        System.out.println("\n--- Testing Edge Cases ---");
        
        int[] edgeTest1 = test3.clone(); // Single element
        bubbleSort(edgeTest1);
        printArray(edgeTest1, "Single element");
        
        int[] edgeTest2 = test4.clone(); // Empty array
        mergeSort(edgeTest2);
        printArray(edgeTest2, "Empty array");
        
        int[] edgeTest3 = test5.clone(); // All duplicates
        quickSort(edgeTest3);
        printArray(edgeTest3, "All duplicates");
    }
}