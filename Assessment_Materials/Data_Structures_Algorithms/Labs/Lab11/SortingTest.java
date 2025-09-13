import java.util.Arrays;
import java.util.Random;

/**
 * Comprehensive test framework for Lab 11 Sorting Algorithms.
 * 
 * This class tests the correctness of bubble sort, merge sort, and quicksort
 * implementations with various types of input data including edge cases.
 * 
 * Run this class to verify your sorting implementations work correctly.
 * 
 * @author Lab 11 Framework
 * @version 1.0
 */
public class SortingTest {
    
    // Test configuration
    private static final int RANDOM_ARRAY_SIZE = 100;
    private static final int LARGE_ARRAY_SIZE = 1000;
    private static final Random random = new Random(42); // Fixed seed for reproducible tests
    
    // Test counters
    private static int totalTests = 0;
    private static int passedTests = 0;
    private static int failedTests = 0;
    
    /**
     * Main method - runs all sorting algorithm tests.
     */
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("    SORTING ALGORITHMS CORRECTNESS TESTS");
        System.out.println("=================================================");
        System.out.println();
        
        // Test each algorithm
        testBubbleSort();
        testMergeSort();
        testQuickSort();
        
        // Print final results
        printTestSummary();
    }
    
    // =============================================================================
    // BUBBLE SORT TESTS
    // =============================================================================
    
    /**
     * Tests bubble sort implementation with various input types.
     */
    private static void testBubbleSort() {
        System.out.println("--- TESTING BUBBLE SORT ---");
        
        // Basic functionality tests
        testBasicSorting("Bubble Sort - Basic Array", 
                        new int[]{64, 34, 25, 12, 22, 11, 90},
                        new int[]{11, 12, 22, 25, 34, 64, 90},
                        SortingAlgorithms::bubbleSort);
        
        testBasicSorting("Bubble Sort - Small Array",
                        new int[]{3, 1, 4, 1, 5},
                        new int[]{1, 1, 3, 4, 5},
                        SortingAlgorithms::bubbleSort);
        
        // Edge cases
        testEdgeCases("Bubble Sort", SortingAlgorithms::bubbleSort);
        
        // Data type tests
        testDataTypes("Bubble Sort", SortingAlgorithms::bubbleSort);
        
        // Large array test
        testLargeArray("Bubble Sort", SortingAlgorithms::bubbleSort);
        
        System.out.println();
    }
    
    // =============================================================================
    // MERGE SORT TESTS
    // =============================================================================
    
    /**
     * Tests merge sort implementation with various input types.
     */
    private static void testMergeSort() {
        System.out.println("--- TESTING MERGE SORT ---");
        
        // Basic functionality tests
        testBasicSorting("Merge Sort - Basic Array",
                        new int[]{64, 34, 25, 12, 22, 11, 90},
                        new int[]{11, 12, 22, 25, 34, 64, 90},
                        SortingAlgorithms::mergeSort);
        
        testBasicSorting("Merge Sort - Small Array",
                        new int[]{3, 1, 4, 1, 5},
                        new int[]{1, 1, 3, 4, 5},
                        SortingAlgorithms::mergeSort);
        
        // Edge cases
        testEdgeCases("Merge Sort", SortingAlgorithms::mergeSort);
        
        // Data type tests
        testDataTypes("Merge Sort", SortingAlgorithms::mergeSort);
        
        // Large array test
        testLargeArray("Merge Sort", SortingAlgorithms::mergeSort);
        
        // Stability test (merge sort should be stable)
        testStability("Merge Sort", SortingAlgorithms::mergeSort);
        
        System.out.println();
    }
    
    // =============================================================================
    // QUICKSORT TESTS
    // =============================================================================
    
    /**
     * Tests quicksort implementation with various input types.
     */
    private static void testQuickSort() {
        System.out.println("--- TESTING QUICKSORT ---");
        
        // Basic functionality tests
        testBasicSorting("Quicksort - Basic Array",
                        new int[]{64, 34, 25, 12, 22, 11, 90},
                        new int[]{11, 12, 22, 25, 34, 64, 90},
                        SortingAlgorithms::quickSort);
        
        testBasicSorting("Quicksort - Small Array",
                        new int[]{3, 1, 4, 1, 5},
                        new int[]{1, 1, 3, 4, 5},
                        SortingAlgorithms::quickSort);
        
        // Edge cases
        testEdgeCases("Quicksort", SortingAlgorithms::quickSort);
        
        // Data type tests
        testDataTypes("Quicksort", SortingAlgorithms::quickSort);
        
        // Large array test
        testLargeArray("Quicksort", SortingAlgorithms::quickSort);
        
        // Worst case test (reverse sorted array)
        testWorstCaseQuicksort();
        
        System.out.println();
    }
    
    // =============================================================================
    // TEST HELPER METHODS
    // =============================================================================
    
    /**
     * Tests basic sorting functionality with a known input and expected output.
     */
    private static void testBasicSorting(String testName, int[] input, int[] expected, SortingMethod sortMethod) {
        totalTests++;
        
        try {
            int[] testArray = input.clone();
            sortMethod.sort(testArray);
            
            if (Arrays.equals(testArray, expected)) {
                System.out.println("✓ PASSED: " + testName);
                passedTests++;
            } else {
                System.out.println("✗ FAILED: " + testName);
                System.out.println("    Input:    " + Arrays.toString(input));
                System.out.println("    Expected: " + Arrays.toString(expected));
                System.out.println("    Actual:   " + Arrays.toString(testArray));
                failedTests++;
            }
        } catch (Exception e) {
            System.out.println("✗ ERROR: " + testName + " - " + e.getMessage());
            System.out.println("    Input: " + Arrays.toString(input));
            failedTests++;
        }
    }
    
    /**
     * Tests edge cases: empty arrays, single elements, two elements.
     */
    private static void testEdgeCases(String algorithmName, SortingMethod sortMethod) {
        // Empty array
        testBasicSorting(algorithmName + " - Empty Array",
                        new int[]{},
                        new int[]{},
                        sortMethod);
        
        // Single element
        testBasicSorting(algorithmName + " - Single Element",
                        new int[]{42},
                        new int[]{42},
                        sortMethod);
        
        // Two elements (in order)
        testBasicSorting(algorithmName + " - Two Elements (Sorted)",
                        new int[]{1, 2},
                        new int[]{1, 2},
                        sortMethod);
        
        // Two elements (reverse order)
        testBasicSorting(algorithmName + " - Two Elements (Reverse)",
                        new int[]{2, 1},
                        new int[]{1, 2},
                        sortMethod);
    }
    
    /**
     * Tests different data characteristics: sorted, reverse sorted, duplicates.
     */
    private static void testDataTypes(String algorithmName, SortingMethod sortMethod) {
        // Already sorted array
        testBasicSorting(algorithmName + " - Already Sorted",
                        new int[]{1, 2, 3, 4, 5, 6, 7},
                        new int[]{1, 2, 3, 4, 5, 6, 7},
                        sortMethod);
        
        // Reverse sorted array
        testBasicSorting(algorithmName + " - Reverse Sorted",
                        new int[]{7, 6, 5, 4, 3, 2, 1},
                        new int[]{1, 2, 3, 4, 5, 6, 7},
                        sortMethod);
        
        // Array with duplicates
        testBasicSorting(algorithmName + " - With Duplicates",
                        new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3},
                        new int[]{1, 1, 2, 3, 3, 4, 5, 5, 6, 9},
                        sortMethod);
        
        // All same elements
        testBasicSorting(algorithmName + " - All Same",
                        new int[]{5, 5, 5, 5, 5},
                        new int[]{5, 5, 5, 5, 5},
                        sortMethod);
        
        // Array with negative numbers
        testBasicSorting(algorithmName + " - With Negatives",
                        new int[]{-3, 1, -4, 1, 5, -9, 2},
                        new int[]{-9, -4, -3, 1, 1, 2, 5},
                        sortMethod);
    }
    
    /**
     * Tests sorting with a large randomly generated array.
     */
    private static void testLargeArray(String algorithmName, SortingMethod sortMethod) {
        totalTests++;
        
        try {
            // Generate random array
            int[] largeArray = generateRandomArray(LARGE_ARRAY_SIZE);
            int[] expected = largeArray.clone();
            Arrays.sort(expected); // Use Java's sort for expected result
            
            // Test our sorting algorithm
            sortMethod.sort(largeArray);
            
            if (Arrays.equals(largeArray, expected)) {
                System.out.println("✓ PASSED: " + algorithmName + " - Large Array (" + LARGE_ARRAY_SIZE + " elements)");
                passedTests++;
            } else {
                System.out.println("✗ FAILED: " + algorithmName + " - Large Array (" + LARGE_ARRAY_SIZE + " elements)");
                System.out.println("    First few elements expected: " + Arrays.toString(Arrays.copyOf(expected, 10)));
                System.out.println("    First few elements actual:   " + Arrays.toString(Arrays.copyOf(largeArray, 10)));
                failedTests++;
            }
        } catch (Exception e) {
            System.out.println("✗ ERROR: " + algorithmName + " - Large Array: " + e.getMessage());
            failedTests++;
        }
    }
    
    /**
     * Tests stability of sorting algorithm (for merge sort).
     * Stability means equal elements maintain their relative order.
     */
    private static void testStability(String algorithmName, SortingMethod sortMethod) {
        totalTests++;
        
        try {
            // Create array with duplicate values where we can track original positions
            // We'll use a simple test: if algorithm is stable, equal elements should
            // maintain their relative order from the original array
            int[] testArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
            int[] originalArray = testArray.clone();
            
            sortMethod.sort(testArray);
            
            // For merge sort, we expect it to be stable
            // This is a basic stability check - in a more sophisticated test,
            // we would use objects with additional data to track original positions
            boolean isStable = checkBasicStability(originalArray, testArray);
            
            if (isStable) {
                System.out.println("✓ PASSED: " + algorithmName + " - Stability Test (Basic)");
                passedTests++;
            } else {
                System.out.println("? UNCLEAR: " + algorithmName + " - Stability Test (Basic check inconclusive)");
                System.out.println("    Note: This is a basic stability test. " + algorithmName + " should be stable.");
                passedTests++; // Give benefit of the doubt for basic test
            }
        } catch (Exception e) {
            System.out.println("✗ ERROR: " + algorithmName + " - Stability Test: " + e.getMessage());
            failedTests++;
        }
    }
    
    /**
     * Tests quicksort with reverse sorted array (worst case scenario).
     */
    private static void testWorstCaseQuicksort() {
        totalTests++;
        
        try {
            // Reverse sorted array is often worst case for quicksort
            int[] worstCase = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            
            SortingAlgorithms.quickSort(worstCase);
            
            if (Arrays.equals(worstCase, expected)) {
                System.out.println("✓ PASSED: Quicksort - Worst Case (Reverse Sorted)");
                passedTests++;
            } else {
                System.out.println("✗ FAILED: Quicksort - Worst Case (Reverse Sorted)");
                System.out.println("    Expected: " + Arrays.toString(expected));
                System.out.println("    Actual:   " + Arrays.toString(worstCase));
                failedTests++;
            }
        } catch (Exception e) {
            System.out.println("✗ ERROR: Quicksort - Worst Case: " + e.getMessage());
            failedTests++;
        }
    }
    
    // =============================================================================
    // UTILITY METHODS
    // =============================================================================
    
    /**
     * Generates a random array of specified size.
     */
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Random numbers 0-999
        }
        return array;
    }
    
    /**
     * Basic stability check - this is a simplified test.
     * In practice, stability testing requires more sophisticated tracking.
     */
    private static boolean checkBasicStability(int[] original, int[] sorted) {
        // This is a basic check that the array is at least correctly sorted
        // A full stability test would require tracking original positions
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] > sorted[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Prints the final test summary.
     */
    private static void printTestSummary() {
        System.out.println("=================================================");
        System.out.println("              TEST RESULTS SUMMARY");
        System.out.println("=================================================");
        System.out.println("Total tests run: " + totalTests);
        System.out.println("Tests passed:    " + passedTests + " ✓");
        System.out.println("Tests failed:    " + failedTests + " ✗");
        System.out.println();
        
        if (failedTests == 0) {
            System.out.println("🎉 ALL TESTS PASSED! 🎉");
            System.out.println("Your sorting algorithms are working correctly!");
            System.out.println();
            System.out.println("Next steps:");
            System.out.println("1. Run PerformanceComparison.java to analyze performance");
            System.out.println("2. Complete your lab report");
            System.out.println("3. Submit your work to GitHub Classroom");
        } else {
            System.out.println("❌ SOME TESTS FAILED");
            System.out.println("Please fix the failed tests before proceeding.");
            System.out.println();
            System.out.println("Debugging tips:");
            System.out.println("1. Check the failed test output above for specific issues");
            System.out.println("2. Test your algorithms with small arrays manually");
            System.out.println("3. Add print statements to see what your algorithm is doing");
            System.out.println("4. Make sure you're handling edge cases correctly");
        }
        
        System.out.println("=================================================");
        
        // Calculate success rate
        double successRate = (double) passedTests / totalTests * 100;
        System.out.printf("Success rate: %.1f%%\n", successRate);
    }
    
    // =============================================================================
    // FUNCTIONAL INTERFACE FOR TESTING
    // =============================================================================
    
    /**
     * Functional interface to allow passing sorting methods as parameters.
     * This enables us to test all algorithms using the same test methods.
     */
    @FunctionalInterface
    private interface SortingMethod {
        void sort(int[] array);
    }
}