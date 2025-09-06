import java.util.*;

/**
 * ComplexityTester - Lab 2 Starter Code
 * 
 * This file provides timing utilities for empirical algorithm analysis.
 * You'll implement the algorithms and test methods yourself.
 * 
 * @author CSC 220 Teaching Team
 * @version Lab 2 - Fall 2025
 */
public class ComplexityTester {
    
    /**
     * Times the execution of any operation using a lambda expression
     * 
     * Example usage:
     *   long time = timeOperation(() -> bubbleSort(myArray));
     * 
     * @param operation The code to time (as a Runnable)
     * @return Execution time in nanoseconds
     */
    public static long timeOperation(Runnable operation) {
        // JVM warmup - run once to avoid timing JIT compilation
        operation.run();
        
        // Suggest garbage collection before timing
        System.gc();
        
        // Actual timing
        long start = System.nanoTime();
        operation.run();
        long end = System.nanoTime();
        
        return end - start;
    }
    
    /**
     * Generate a random integer array of specified size
     * Uses fixed seed for reproducible results across runs
     * 
     * @param size Number of elements in the array
     * @return Array filled with random integers 0-999
     */
    public static int[] generateRandomArray(int size) {
        Random rand = new Random(42); // Fixed seed for reproducibility
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
    
    /**
     * Generate a sorted array (best case for some algorithms)
     * 
     * @param size Number of elements
     * @return Sorted array [0, 1, 2, ..., size-1]
     */
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
    
    /**
     * Generate a reverse-sorted array (worst case for some algorithms)
     * 
     * @param size Number of elements
     * @return Reverse sorted array [size-1, size-2, ..., 1, 0]
     */
    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - 1 - i;
        }
        return arr;
    }
    
    /**
     * Convert nanoseconds to milliseconds for more readable output
     * 
     * @param nanos Time in nanoseconds
     * @return Time in milliseconds (as double for precision)
     */
    public static double nanosToMillis(long nanos) {
        return nanos / 1_000_000.0;
    }
    
    /**
     * Create a copy of an array (useful when you need to test the same data multiple times)
     * 
     * @param original The array to copy
     * @return A new array with the same elements
     */
    public static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    /**
     * Print a formatted timing result
     * 
     * @param algorithmName Name of the algorithm tested
     * @param size Size of the dataset
     * @param timeNanos Execution time in nanoseconds
     */
    public static void printResult(String algorithmName, int size, long timeNanos) {
        System.out.printf("%-20s | Size: %6d | Time: %8.2f ms%n", 
                         algorithmName, size, nanosToMillis(timeNanos));
    }
    
    // ========================================
    // TODO: Implement these methods for Exercise 2.2
    // ========================================
    
    /**
     * TODO: Implement linear search algorithm
     * Search for target element in array, return index if found, -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        // Your implementation here
        return -1; // Placeholder
    }
    
    /**
     * TODO: Implement bubble sort algorithm  
     * Sort the array in ascending order using bubble sort
     * Note: This method modifies the original array
     */
    public static void bubbleSort(int[] arr) {
        // Your implementation here
    }
    
    // ========================================
    // TODO: Implement test methods for Exercise 2.2
    // ========================================
    
    /**
     * TODO: Test linear search performance with different cases
     * Test best case (element at beginning), worst case (element at end or not found)
     */
    public static void testLinearSearchPerformance() {
        System.out.println("=== Linear Search Performance Test ===");
        int[] sizes = {100, 500, 1000, 2000, 5000};
        
        for (int size : sizes) {
            // TODO: Create test array
            // TODO: Test best case (search for first element)
            // TODO: Test worst case (search for last element) 
            // TODO: Test worst case (search for non-existent element)
            // TODO: Print results using printResult() method
        }
    }
    
    /**
     * TODO: Test bubble sort performance with different input conditions
     * Test random array, sorted array (best case), reverse sorted array (worst case)
     */
    public static void testBubbleSortPerformance() {
        System.out.println("=== Bubble Sort Performance Test ===");
        int[] sizes = {100, 500, 1000, 2000, 5000};
        
        for (int size : sizes) {
            // TODO: Test with random array
            // TODO: Test with sorted array (best case)
            // TODO: Test with reverse sorted array (worst case)
            // TODO: Print results using printResult() method
            
            // HINT: Use copyArray() to test the same data with different conditions
            // HINT: Use the generate*Array() methods to create test data
        }
    }
    
    /**
     * TODO: Test ArrayList performance comparison (Exercise 2.3)
     * Compare your SimpleArrayList with Java's ArrayList
     */
    public static void testArrayListPerformance() {
        System.out.println("=== ArrayList Performance Comparison ===");
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        
        for (int size : sizes) {
            // TODO: Test your SimpleArrayList performance
            // TODO: Test Java's ArrayList performance
            // TODO: Compare and print results
        }
    }
    
    /**
     * Main method - runs all performance tests
     */
    public static void main(String[] args) {
        System.out.println("CSC 220 Lab 2 - Complexity Analysis");
        System.out.println("=====================================");
        
        // TODO: Uncomment these as you implement the methods
        // testLinearSearchPerformance();
        // System.out.println();
        // testBubbleSortPerformance(); 
        // System.out.println();
        // testArrayListPerformance();
        
        System.out.println("All tests completed!");
    }
}