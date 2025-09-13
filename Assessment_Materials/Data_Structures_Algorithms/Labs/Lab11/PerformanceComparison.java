import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

/**
 * Performance comparison framework for Lab 11 Sorting Algorithms.
 * 
 * This class measures and compares the execution time of bubble sort,
 * merge sort, and quicksort on different types and sizes of data.
 * 
 * The results help students understand the practical differences between
 * O(n²) and O(n log n) algorithms and how input characteristics affect performance.
 * 
 * @author Lab 11 Framework
 * @version 1.0
 */
public class PerformanceComparison {
    
    // Test configuration
    private static final int[] TEST_SIZES = {100, 500, 1000, 2000, 5000};
    private static final int WARMUP_RUNS = 3;  // JVM warmup iterations
    private static final int TIMING_RUNS = 5;  // Number of runs for average timing
    private static final Random random = new Random(42); // Fixed seed for consistency
    
    /**
     * Main method - runs comprehensive performance comparison.
     */
    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("    SORTING ALGORITHMS PERFORMANCE COMPARISON");
        System.out.println("=======================================================");
        System.out.println();
        
        System.out.println("Testing Configuration:");
        System.out.println("• Array sizes: " + Arrays.toString(TEST_SIZES));
        System.out.println("• Each test averaged over " + TIMING_RUNS + " runs");
        System.out.println("• JVM warmup: " + WARMUP_RUNS + " runs per test");
        System.out.println("• Time measured in milliseconds (ms)");
        System.out.println();
        
        // Run performance tests
        testRandomData();
        testSortedData();
        testReverseSortedData();
        testDuplicateData();
        
        // Print analysis guidance
        printAnalysisGuidance();
    }
    
    // =============================================================================
    // PERFORMANCE TEST METHODS
    // =============================================================================
    
    /**
     * Tests performance on random data (typical use case).
     */
    private static void testRandomData() {
        System.out.println("--- RANDOM DATA PERFORMANCE ---");
        System.out.println("Testing with randomly shuffled arrays");
        System.out.println();
        
        printTableHeader();
        
        for (int size : TEST_SIZES) {
            int[] randomData = generateRandomArray(size);
            
            double bubbleTime = measureSortingTime(randomData, "bubble");
            double mergeTime = measureSortingTime(randomData, "merge");
            double quickTime = measureSortingTime(randomData, "quick");
            
            printTableRow(size, bubbleTime, mergeTime, quickTime);
        }
        
        System.out.println();
        System.out.println("Analysis: Random data shows typical performance characteristics.");
        System.out.println("Expected: Bubble sort O(n²), Merge sort O(n log n), Quicksort O(n log n) average");
        System.out.println();
    }
    
    /**
     * Tests performance on already sorted data.
     */
    private static void testSortedData() {
        System.out.println("--- ALREADY SORTED DATA PERFORMANCE ---");
        System.out.println("Testing with arrays that are already in sorted order");
        System.out.println();
        
        printTableHeader();
        
        for (int size : TEST_SIZES) {
            int[] sortedData = generateSortedArray(size);
            
            double bubbleTime = measureSortingTime(sortedData, "bubble");
            double mergeTime = measureSortingTime(sortedData, "merge");
            double quickTime = measureSortingTime(sortedData, "quick");
            
            printTableRow(size, bubbleTime, mergeTime, quickTime);
        }
        
        System.out.println();
        System.out.println("Analysis: Already sorted data reveals best-case behavior.");
        System.out.println("Expected: Bubble sort O(n) if optimized, others still O(n log n)");
        System.out.println();
    }
    
    /**
     * Tests performance on reverse sorted data.
     */
    private static void testReverseSortedData() {
        System.out.println("--- REVERSE SORTED DATA PERFORMANCE ---");
        System.out.println("Testing with arrays in reverse sorted order (worst case for some algorithms)");
        System.out.println();
        
        printTableHeader();
        
        for (int size : TEST_SIZES) {
            int[] reverseData = generateReverseSortedArray(size);
            
            double bubbleTime = measureSortingTime(reverseData, "bubble");
            double mergeTime = measureSortingTime(reverseData, "merge");
            double quickTime = measureSortingTime(reverseData, "quick");
            
            printTableRow(size, bubbleTime, mergeTime, quickTime);
        }
        
        System.out.println();
        System.out.println("Analysis: Reverse sorted data often represents worst-case scenarios.");
        System.out.println("Expected: Bubble sort O(n²), Merge sort still O(n log n), Quicksort may be O(n²)");
        System.out.println();
    }
    
    /**
     * Tests performance on data with many duplicate values.
     */
    private static void testDuplicateData() {
        System.out.println("--- DATA WITH DUPLICATES PERFORMANCE ---");
        System.out.println("Testing with arrays containing many duplicate values");
        System.out.println();
        
        printTableHeader();
        
        for (int size : TEST_SIZES) {
            int[] duplicateData = generateDuplicateArray(size);
            
            double bubbleTime = measureSortingTime(duplicateData, "bubble");
            double mergeTime = measureSortingTime(duplicateData, "merge");
            double quickTime = measureSortingTime(duplicateData, "quick");
            
            printTableRow(size, bubbleTime, mergeTime, quickTime);
        }
        
        System.out.println();
        System.out.println("Analysis: Duplicate values test how algorithms handle equal elements.");
        System.out.println("Expected: Similar to random data, but may show stability differences");
        System.out.println();
    }
    
    // =============================================================================
    // TIMING AND MEASUREMENT METHODS
    // =============================================================================
    
    /**
     * Measures the average execution time of a sorting algorithm.
     * 
     * @param data the array to sort (will be copied for each test)
     * @param algorithm which sorting algorithm to test ("bubble", "merge", "quick")
     * @return average execution time in milliseconds
     */
    private static double measureSortingTime(int[] data, String algorithm) {
        // JVM Warmup - run the algorithm a few times before measuring
        for (int i = 0; i < WARMUP_RUNS; i++) {
            int[] warmupArray = data.clone();
            runSortingAlgorithm(warmupArray, algorithm);
        }
        
        // Actual timing runs
        long totalTime = 0;
        int successfulRuns = 0;
        
        for (int run = 0; run < TIMING_RUNS; run++) {
            int[] testArray = data.clone();
            
            try {
                long startTime = System.nanoTime();
                runSortingAlgorithm(testArray, algorithm);
                long endTime = System.nanoTime();
                
                totalTime += (endTime - startTime);
                successfulRuns++;
                
            } catch (Exception e) {
                System.err.println("Error in " + algorithm + " sort: " + e.getMessage());
                return -1; // Indicate error
            }
        }
        
        if (successfulRuns == 0) {
            return -1; // No successful runs
        }
        
        // Convert nanoseconds to milliseconds and return average
        return (totalTime / (double) successfulRuns) / 1_000_000.0;
    }
    
    /**
     * Runs the specified sorting algorithm on the given array.
     * 
     * @param array the array to sort
     * @param algorithm which algorithm to run
     */
    private static void runSortingAlgorithm(int[] array, String algorithm) {
        switch (algorithm.toLowerCase()) {
            case "bubble":
                SortingAlgorithms.bubbleSort(array);
                break;
            case "merge":
                SortingAlgorithms.mergeSort(array);
                break;
            case "quick":
                SortingAlgorithms.quickSort(array);
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
    }
    
    // =============================================================================
    // DATA GENERATION METHODS
    // =============================================================================
    
    /**
     * Generates an array of random integers.
     */
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10); // Random values 0 to size*10
        }
        return array;
    }
    
    /**
     * Generates an array that is already sorted.
     */
    private static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1; // Values 1, 2, 3, ..., size
        }
        return array;
    }
    
    /**
     * Generates an array that is sorted in reverse order.
     */
    private static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i; // Values size, size-1, ..., 2, 1
        }
        return array;
    }
    
    /**
     * Generates an array with many duplicate values.
     */
    private static int[] generateDuplicateArray(int size) {
        int[] array = new int[size];
        int numUniqueValues = Math.max(1, size / 10); // Only 10% unique values
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(numUniqueValues) + 1; // Limited range for duplicates
        }
        return array;
    }
    
    // =============================================================================
    // OUTPUT FORMATTING METHODS
    // =============================================================================
    
    /**
     * Prints the header for performance comparison tables.
     */
    private static void printTableHeader() {
        System.out.println("┌──────────┬─────────────┬─────────────┬─────────────┐");
        System.out.println("│   Size   │ Bubble Sort │ Merge Sort  │  Quicksort  │");
        System.out.println("│          │    (ms)     │    (ms)     │    (ms)     │");
        System.out.println("├──────────┼─────────────┼─────────────┼─────────────┤");
    }
    
    /**
     * Prints a row of performance data in table format.
     */
    private static void printTableRow(int size, double bubbleTime, double mergeTime, double quickTime) {
        System.out.printf("│ %8d │ %11.2f │ %11.2f │ %11.2f │%n", 
                         size, bubbleTime, mergeTime, quickTime);
    }
    
    /**
     * Prints analysis guidance to help students interpret results.
     */
    private static void printAnalysisGuidance() {
        System.out.println("=======================================================");
        System.out.println("                  ANALYSIS GUIDANCE");
        System.out.println("=======================================================");
        System.out.println();
        
        System.out.println("📊 INTERPRETING THE RESULTS:");
        System.out.println();
        
        System.out.println("• BUBBLE SORT (O(n²)):");
        System.out.println("  - Should be slowest overall, especially on larger arrays");
        System.out.println("  - Time should roughly quadruple when array size doubles");
        System.out.println("  - May be faster on very small arrays due to simplicity");
        System.out.println("  - Best case: already sorted data (if optimized with early termination)");
        System.out.println();
        
        System.out.println("• MERGE SORT (O(n log n)):");
        System.out.println("  - Should show consistent performance across all input types");
        System.out.println("  - Time increases predictably with size (roughly doubles when size doubles)");
        System.out.println("  - Uses additional memory for merging operations");
        System.out.println("  - Stable sort - maintains relative order of equal elements");
        System.out.println();
        
        System.out.println("• QUICKSORT (O(n log n) average, O(n²) worst case):");
        System.out.println("  - Usually fastest on random data");
        System.out.println("  - May perform poorly on already sorted or reverse sorted data");
        System.out.println("  - Performance depends on pivot selection strategy");
        System.out.println("  - Uses less additional memory than merge sort");
        System.out.println();
        
        System.out.println("🔍 WHAT TO LOOK FOR:");
        System.out.println();
        System.out.println("1. SCALING BEHAVIOR:");
        System.out.println("   • Bubble sort should slow down dramatically with larger arrays");
        System.out.println("   • Merge sort should scale more gracefully");
        System.out.println("   • Quicksort should be fast on random data but may struggle on sorted data");
        System.out.println();
        
        System.out.println("2. INPUT SENSITIVITY:");
        System.out.println("   • Compare performance on different data types");
        System.out.println("   • Notice which algorithms are affected by input characteristics");
        System.out.println("   • Identify best and worst case scenarios for each algorithm");
        System.out.println();
        
        System.out.println("3. CROSSOVER POINTS:");
        System.out.println("   • At what array size does bubble sort become noticeably slower?");
        System.out.println("   • When do the O(n log n) algorithms start to show their advantage?");
        System.out.println();
        
        System.out.println("💡 FOR YOUR LAB REPORT:");
        System.out.println();
        System.out.println("• Which algorithm performed best overall? Why?");
        System.out.println("• How did input type (random vs sorted) affect each algorithm?");
        System.out.println("• Do the results match theoretical complexity expectations?");
        System.out.println("• When would you choose each algorithm in practice?");
        System.out.println("• How do these results inform your semester project choices?");
        System.out.println();
        
        System.out.println("⚠️  NOTES:");
        System.out.println("• Small differences (< 1ms) may not be significant");
        System.out.println("• JVM optimizations can affect results on small arrays");
        System.out.println("• Multiple runs help account for system variation");
        System.out.println("• Focus on overall trends rather than exact numbers");
        System.out.println();
        
        System.out.println("=======================================================");
        System.out.println("Save these results for your lab report analysis!");
        System.out.println("=======================================================");
    }
    
    /**
     * Optional method to save results to a file for later analysis.
     * Students can uncomment and modify this if they want to save results.
     */
    /*
    private static void saveResultsToFile(String filename) {
        try {
            // Implementation for saving results to file
            // Students can implement this if they want to save their timing data
            System.out.println("Results saved to " + filename);
        } catch (Exception e) {
            System.out.println("Error saving results: " + e.getMessage());
        }
    }
    */
}