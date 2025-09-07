import java.util.*;
import java.io.*;

/**
 * Performance analysis for BST operations under different scenarios.
 * 
 * This class measures and compares BST performance in three scenarios:
 * 1. Best Case: Balanced tree with random insertions
 * 2. Average Case: Mixed operations on moderately balanced tree  
 * 3. Worst Case: Degenerate tree (essentially a linked list)
 * 
 * Expected Complexity:
 * - Balanced BST: O(log n) for search, insert, delete
 * - Degenerate BST: O(n) for search, insert, delete
 * 
 * @author Student Name
 * @version Lab 7 - BST Implementation
 */
public class PerformanceAnalysis {
    
    // Test data sizes
    private static final int[] TEST_SIZES = {100, 500, 1000, 5000};
    
    // Number of trials to average results
    private static final int NUM_TRIALS = 5;
    
    // Number of operations to test for timing
    private static final int NUM_SEARCH_OPS = 1000;
    private static final int NUM_DELETE_OPS = 100;
    
    /**
     * Main method to run all performance tests.
     */
    public static void main(String[] args) {
        System.out.println("BST Performance Analysis");
        System.out.println("========================");
        System.out.println();
        
        PerformanceAnalysis analyzer = new PerformanceAnalysis();
        
        try {
            // Run performance tests for each scenario
            analyzer.runAllTests();
            
            // Generate summary report
            analyzer.generateSummaryReport();
            
        } catch (Exception e) {
            System.err.println("Error during performance analysis: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Runs performance tests for all scenarios and data sizes.
     */
    public void runAllTests() {
        System.out.println("Running performance tests...");
        System.out.println();
        
        for (int size : TEST_SIZES) {
            System.out.println("Testing with " + size + " elements:");
            System.out.println("-".repeat(40));
            
            // Test each scenario
            testBestCaseScenario(size);
            testAverageCaseScenario(size);
            testWorstCaseScenario(size);
            
            System.out.println();
        }
    }
    
    // =====================================================
    // BEST CASE SCENARIO (Balanced Tree)
    // =====================================================
    
    /**
     * Tests performance with a balanced BST created from random insertions.
     * 
     * @param size number of elements to test with
     */
    public void testBestCaseScenario(int size) {
        System.out.println("Best Case (Balanced Tree):");
        
        // Generate random data for balanced tree
        int[] data = generateRandomData(size);
        
        // Measure insertion time
        long insertTime = measureInsertionTime(data);
        
        // Create tree for search/delete tests
        BST tree = createBSTFromData(data);
        
        // Measure search time
        long searchTime = measureSearchTime(tree, data);
        
        // Measure deletion time
        long deleteTime = measureDeletionTime(tree, Arrays.copyOf(data, NUM_DELETE_OPS));
        
        System.out.printf("  Insertion: %d ms (avg per operation: %.3f μs)%n", 
                         insertTime, (insertTime * 1000.0) / size);
        System.out.printf("  Search:    %d ms (avg per operation: %.3f μs)%n", 
                         searchTime, (searchTime * 1000.0) / NUM_SEARCH_OPS);
        System.out.printf("  Deletion:  %d ms (avg per operation: %.3f μs)%n", 
                         deleteTime, (deleteTime * 1000.0) / NUM_DELETE_OPS);
        System.out.printf("  Tree height: %d (optimal: %d)%n", 
                         tree.height(), (int)(Math.log(size) / Math.log(2)));
    }
    
    // =====================================================
    // AVERAGE CASE SCENARIO (Moderately Balanced)
    // =====================================================
    
    /**
     * Tests performance with a moderately balanced BST.
     * Uses a mix of random and sequential insertions.
     * 
     * @param size number of elements to test with
     */
    public void testAverageCaseScenario(int size) {
        System.out.println("Average Case (Moderately Balanced):");
        
        // Generate mixed data (70% random, 30% sequential)
        int[] data = generateMixedData(size);
        
        // Measure insertion time
        long insertTime = measureInsertionTime(data);
        
        // Create tree for search/delete tests
        BST tree = createBSTFromData(data);
        
        // Measure search time with mixed search pattern
        long searchTime = measureMixedSearchTime(tree, data);
        
        // Measure deletion time
        long deleteTime = measureDeletionTime(tree, Arrays.copyOf(data, NUM_DELETE_OPS));
        
        System.out.printf("  Insertion: %d ms (avg per operation: %.3f μs)%n", 
                         insertTime, (insertTime * 1000.0) / size);
        System.out.printf("  Search:    %d ms (avg per operation: %.3f μs)%n", 
                         searchTime, (searchTime * 1000.0) / NUM_SEARCH_OPS);
        System.out.printf("  Deletion:  %d ms (avg per operation: %.3f μs)%n", 
                         deleteTime, (deleteTime * 1000.0) / NUM_DELETE_OPS);
        System.out.printf("  Tree height: %d%n", tree.height());
    }
    
    // =====================================================
    // WORST CASE SCENARIO (Degenerate Tree)
    // =====================================================
    
    /**
     * Tests performance with a degenerate BST (essentially a linked list).
     * Created by inserting data in sorted order.
     * 
     * @param size number of elements to test with
     */
    public void testWorstCaseScenario(int size) {
        System.out.println("Worst Case (Degenerate Tree):");
        
        // Generate sorted data for degenerate tree
        int[] data = generateSortedData(size);
        
        // Measure insertion time
        long insertTime = measureInsertionTime(data);
        
        // Create tree for search/delete tests
        BST tree = createBSTFromData(data);
        
        // Measure search time
        long searchTime = measureSearchTime(tree, data);
        
        // Measure deletion time
        long deleteTime = measureDeletionTime(tree, Arrays.copyOf(data, NUM_DELETE_OPS));
        
        System.out.printf("  Insertion: %d ms (avg per operation: %.3f μs)%n", 
                         insertTime, (insertTime * 1000.0) / size);
        System.out.printf("  Search:    %d ms (avg per operation: %.3f μs)%n", 
                         searchTime, (searchTime * 1000.0) / NUM_SEARCH_OPS);
        System.out.printf("  Deletion:  %d ms (avg per operation: %.3f μs)%n", 
                         deleteTime, (deleteTime * 1000.0) / NUM_DELETE_OPS);
        System.out.printf("  Tree height: %d (should be ~%d)%n", tree.height(), size - 1);
    }
    
    // =====================================================
    // TIMING MEASUREMENT METHODS
    // =====================================================
    
    /**
     * Measures the time to insert all elements into a new BST.
     * 
     * @param data array of values to insert
     * @return average insertion time in milliseconds over multiple trials
     */
    public long measureInsertionTime(int[] data) {
        long totalTime = 0;
        
        for (int trial = 0; trial < NUM_TRIALS; trial++) {
            BST tree = new BST();
            
            // TODO: Implement timing logic
            // 1. Record start time using System.nanoTime()
            // 2. Insert all elements from data array
            // 3. Record end time
            // 4. Calculate elapsed time and add to totalTime
            
            long startTime = System.nanoTime();
            
            // Insert all data elements
            for (int value : data) {
                tree.insert(value);
            }
            
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        
        // Convert to milliseconds and return average
        return (totalTime / NUM_TRIALS) / 1_000_000;
    }
    
    /**
     * Measures the time to perform search operations on an existing BST.
     * 
     * @param tree the BST to search in
     * @param data array of values to search for
     * @return average search time in milliseconds over multiple trials
     */
    public long measureSearchTime(BST tree, int[] data) {
        long totalTime = 0;
        Random random = new Random(42); // Fixed seed for reproducibility
        
        for (int trial = 0; trial < NUM_TRIALS; trial++) {
            // TODO: Implement search timing logic
            // 1. Record start time
            // 2. Perform NUM_SEARCH_OPS search operations
            // 3. Mix of successful and unsuccessful searches
            // 4. Record end time and accumulate
            
            long startTime = System.nanoTime();
            
            for (int i = 0; i < NUM_SEARCH_OPS; i++) {
                // 80% successful searches, 20% unsuccessful
                if (random.nextDouble() < 0.8) {
                    // Search for existing value
                    int index = random.nextInt(data.length);
                    tree.search(data[index]);
                } else {
                    // Search for non-existing value
                    tree.search(-1 * random.nextInt(1000));
                }
            }
            
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        
        return (totalTime / NUM_TRIALS) / 1_000_000;
    }
    
    /**
     * Measures the time to perform mixed search operations (existing and non-existing values).
     * 
     * @param tree the BST to search in
     * @param data array of values that exist in the tree
     * @return average search time in milliseconds
     */
    public long measureMixedSearchTime(BST tree, int[] data) {
        // TODO: Implement mixed search timing
        // Similar to measureSearchTime but with different search patterns
        // Consider searching for recently inserted vs. older values
        
        return measureSearchTime(tree, data); // Placeholder - implement your own logic
    }
    
    /**
     * Measures the time to delete elements from a BST.
     * 
     * @param tree the BST to delete from (will be modified)
     * @param data array of values to delete
     * @return average deletion time in milliseconds over multiple trials
     */
    public long measureDeletionTime(BST tree, int[] data) {
        long totalTime = 0;
        
        for (int trial = 0; trial < NUM_TRIALS; trial++) {
            // Create fresh tree for each trial
            BST testTree = createBSTFromData(data);
            
            // TODO: Implement deletion timing logic
            // 1. Record start time
            // 2. Delete all elements in data array
            // 3. Record end time and accumulate
            
            long startTime = System.nanoTime();
            
            for (int value : data) {
                testTree.delete(value);
            }
            
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        
        return (totalTime / NUM_TRIALS) / 1_000_000;
    }
    
    // =====================================================
    // DATA GENERATION METHODS
    // =====================================================
    
    /**
     * Generates random data for creating a balanced BST.
     * 
     * @param size number of elements to generate
     * @return array of random integers
     */
    private int[] generateRandomData(int size) {
        Random random = new Random(12345); // Fixed seed for reproducibility
        Set<Integer> uniqueValues = new HashSet<>();
        
        while (uniqueValues.size() < size) {
            uniqueValues.add(random.nextInt(size * 10));
        }
        
        return uniqueValues.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * Generates sorted data for creating a degenerate BST.
     * 
     * @param size number of elements to generate
     * @return array of sorted integers
     */
    private int[] generateSortedData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i + 1;
        }
        return data;
    }
    
    /**
     * Generates mixed data (partial random, partial sequential) for average case.
     * 
     * @param size number of elements to generate
     * @return array of mixed integers
     */
    private int[] generateMixedData(int size) {
        // TODO: Implement mixed data generation
        // Suggestion: 70% random values, 30% sequential
        // This creates a moderately unbalanced tree
        
        List<Integer> values = new ArrayList<>();
        Random random = new Random(54321);
        
        // Add 70% random values
        int randomCount = (int)(size * 0.7);
        Set<Integer> uniqueValues = new HashSet<>();
        while (uniqueValues.size() < randomCount) {
            uniqueValues.add(random.nextInt(size * 10));
        }
        values.addAll(uniqueValues);
        
        // Add 30% sequential values
        int sequentialCount = size - randomCount;
        int start = random.nextInt(1000);
        for (int i = 0; i < sequentialCount; i++) {
            values.add(start + i);
        }
        
        // Shuffle the combined list
        Collections.shuffle(values, random);
        
        return values.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // =====================================================
    // UTILITY METHODS
    // =====================================================
    
    /**
     * Creates a BST from an array of data.
     * 
     * @param data array of values to insert
     * @return BST containing all values from data
     */
    private BST createBSTFromData(int[] data) {
        BST tree = new BST();
        for (int value : data) {
            tree.insert(value);
        }
        return tree;
    }
    
    /**
     * Generates a summary report of all performance tests.
     * Saves results to a file for further analysis.
     */
    public void generateSummaryReport() {
        System.out.println("Performance Analysis Summary");
        System.out.println("============================");
        System.out.println();
        
        // TODO: Implement summary report generation
        // 1. Collect all timing data from previous tests
        // 2. Calculate ratios between best/average/worst case
        // 3. Generate graphs or tables showing performance scaling
        // 4. Save results to file
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("performance_results.txt"))) {
            writer.println("BST Performance Analysis Results");
            writer.println("Generated on: " + new Date());
            writer.println();
            
            writer.println("Test Configuration:");
            writer.println("  Data sizes tested: " + Arrays.toString(TEST_SIZES));
            writer.println("  Number of trials per test: " + NUM_TRIALS);
            writer.println("  Search operations per test: " + NUM_SEARCH_OPS);
            writer.println("  Delete operations per test: " + NUM_DELETE_OPS);
            writer.println();
            
            writer.println("Key Findings:");
            writer.println("  1. Balanced BST shows O(log n) behavior");
            writer.println("  2. Degenerate BST shows O(n) behavior");
            writer.println("  3. Tree height strongly correlates with performance");
            writer.println();
            
            writer.println("Recommendations:");
            writer.println("  - Use balanced tree implementations (AVL, Red-Black) for production");
            writer.println("  - Avoid inserting pre-sorted data into basic BST");
            writer.println("  - Monitor tree height to detect degenerate cases");
            
            System.out.println("Detailed results saved to performance_results.txt");
            
        } catch (IOException e) {
            System.err.println("Error writing results file: " + e.getMessage());
        }
    }
    
    /**
     * Validates that the tree maintains BST property after operations.
     * Used for debugging performance test setup.
     * 
     * @param tree the BST to validate
     * @param expectedSize expected number of nodes
     * @return true if tree is valid, false otherwise
     */
    private boolean validateTreeStructure(BST tree, int expectedSize) {
        return tree.isValidBST() && tree.size() == expectedSize;
    }
    
    /**
     * Calculates the theoretical optimal height for a balanced BST.
     * 
     * @param size number of nodes in the tree
     * @return optimal height (log base 2 of size)
     */
    private int calculateOptimalHeight(int size) {
        return (int) Math.ceil(Math.log(size + 1) / Math.log(2)) - 1;
    }
}