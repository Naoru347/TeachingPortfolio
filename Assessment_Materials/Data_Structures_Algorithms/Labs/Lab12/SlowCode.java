import java.util.*;
import java.io.*;

/**
 * Lab 12: Performance Report - Slow Code Examples
 * 
 * This class contains intentionally inefficient implementations that students
 * will profile, analyze, and optimize. Each method represents a common
 * performance anti-pattern that appears in real-world code.
 * 
 * Your task:
 * 1. Run this code and observe the performance
 * 2. Profile each method to identify bottlenecks
 * 3. Implement optimized versions in OptimizationReport.java
 * 4. Compare before/after performance
 * 
 * @author Lab 12 Framework
 */
public class SlowCode {
    
    // Test data sizes for performance testing
    private static final int SMALL_SIZE = 1000;
    private static final int MEDIUM_SIZE = 5000;
    private static final int LARGE_SIZE = 10000;
    
    /**
     * Runs all slow methods with timing to show performance issues.
     */
    public static void main(String[] args) {
        System.out.println("=== SLOW CODE PERFORMANCE DEMONSTRATION ===");
        System.out.println("Running inefficient implementations...");
        System.out.println();
        
        // Run each slow method with timing
        demonstrateSlowSearch();
        demonstrateSlowDataStructure();
        demonstrateSlowNestedLoops();
        demonstrateSlowStringConcatenation();
        
        System.out.println("=== ANALYSIS COMPLETE ===");
        System.out.println("Now profile these methods in PerformanceAnalysis.java");
        System.out.println("Then implement optimizations in OptimizationReport.java");
    }
    
    // =============================================================================
    // INEFFICIENT SEARCH - Problem #1
    // =============================================================================
    
    /**
     * INEFFICIENT: Linear search on sorted data.
     * 
     * This method performs linear search (O(n)) on data that is already sorted.
     * A binary search would be much more efficient (O(log n)).
     * 
     * Performance Issue: Doesn't take advantage of sorted order
     * Expected Optimization: Binary search
     * 
     * @param sortedArray array sorted in ascending order
     * @param target value to search for
     * @return index of target, or -1 if not found
     */
    public static int inefficientSearch(int[] sortedArray, int target) {
        // INTENTIONALLY INEFFICIENT: Linear search on sorted data
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] == target) {
                return i;
            }
            // Note: We could break early if sortedArray[i] > target, but even
            // that wouldn't make this as efficient as binary search
        }
        return -1;
    }
    
    /**
     * Demonstrates the inefficient search performance.
     */
    private static void demonstrateSlowSearch() {
        System.out.println("--- Inefficient Search Performance ---");
        
        // Create sorted test data
        int[] sortedData = generateSortedArray(LARGE_SIZE);
        int target = LARGE_SIZE - 100; // Near the end, worst case for linear search
        
        long startTime = System.nanoTime();
        
        // Perform multiple searches to make timing measurable
        int result = -1;
        for (int i = 0; i < 1000; i++) {
            result = inefficientSearch(sortedData, target);
        }
        
        long endTime = System.nanoTime();
        double elapsedMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.printf("Linear search (1000 searches): %.2f ms\n", elapsedMs);
        System.out.printf("Found target at index: %d\n", result);
        System.out.println("Problem: O(n) search on sorted data should be O(log n)");
        System.out.println();
    }
    
    // =============================================================================
    // POOR DATA STRUCTURE CHOICE - Problem #2
    // =============================================================================
    
    /**
     * INEFFICIENT: Using ArrayList for frequent insertions at beginning.
     * 
     * This method repeatedly inserts elements at the front of an ArrayList.
     * ArrayList insertion at index 0 requires shifting all existing elements,
     * making each insertion O(n), for total complexity O(n²).
     * 
     * Performance Issue: Wrong data structure for the access pattern
     * Expected Optimization: LinkedList for O(1) insertions at front
     * 
     * @param elements data to insert
     * @return list with elements inserted at front
     */
    public static List<Integer> inefficientDataStructure(int[] elements) {
        // INTENTIONALLY INEFFICIENT: ArrayList with front insertions
        List<Integer> result = new ArrayList<>();
        
        for (int element : elements) {
            // ArrayList.add(0, element) is O(n) because it shifts all existing elements
            result.add(0, element); // ❌ This is the performance killer
        }
        
        return result;
    }
    
    /**
     * INEFFICIENT: Using wrong data structure for frequent lookups.
     * 
     * This method uses a List to store data that will be frequently searched.
     * List.contains() is O(n), when a HashSet would provide O(1) lookups.
     * 
     * @param data numbers to store and search
     * @param queries numbers to search for
     * @return count of queries found in data
     */
    public static int inefficientLookups(int[] data, int[] queries) {
        // INTENTIONALLY INEFFICIENT: Using List for frequent lookups
        List<Integer> dataList = new ArrayList<>();
        for (int value : data) {
            dataList.add(value); // Build the list
        }
        
        int foundCount = 0;
        for (int query : queries) {
            // List.contains() is O(n) - searches through entire list each time
            if (dataList.contains(query)) { // ❌ O(n) lookup
                foundCount++;
            }
        }
        
        return foundCount;
    }
    
    /**
     * Demonstrates poor data structure choice performance.
     */
    private static void demonstrateSlowDataStructure() {
        System.out.println("--- Poor Data Structure Performance ---");
        
        // Test frequent insertions at front
        int[] testData = generateRandomArray(MEDIUM_SIZE);
        
        long startTime = System.nanoTime();
        List<Integer> result = inefficientDataStructure(testData);
        long endTime = System.nanoTime();
        double elapsedMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.printf("ArrayList front insertions (%d elements): %.2f ms\n", 
                         testData.length, elapsedMs);
        System.out.printf("Result size: %d\n", result.size());
        
        // Test frequent lookups
        int[] lookupData = generateRandomArray(SMALL_SIZE);
        int[] queries = generateRandomArray(SMALL_SIZE);
        
        startTime = System.nanoTime();
        int foundCount = inefficientLookups(lookupData, queries);
        endTime = System.nanoTime();
        elapsedMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.printf("List lookups (%d queries): %.2f ms\n", queries.length, elapsedMs);
        System.out.printf("Found: %d items\n", foundCount);
        System.out.println("Problem: Wrong data structure for access pattern");
        System.out.println();
    }
    
    // =============================================================================
    // NESTED LOOP PROBLEM - Problem #3
    // =============================================================================
    
    /**
     * INEFFICIENT: Unnecessary nested loops for duplicate detection.
     * 
     * This method uses nested loops (O(n²)) to find duplicates.
     * A single pass with HashSet would be much more efficient (O(n)).
     * 
     * Performance Issue: Nested loops when single pass would work
     * Expected Optimization: HashSet for O(1) lookup
     * 
     * @param array data to check for duplicates
     * @return true if array contains any duplicate values
     */
    public static boolean inefficientDuplicateCheck(int[] array) {
        // INTENTIONALLY INEFFICIENT: O(n²) nested loop approach
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true; // Found duplicate
                }
            }
        }
        return false;
    }
    
    /**
     * INEFFICIENT: Nested loops for finding pairs that sum to target.
     * 
     * This method uses nested loops to find all pairs that sum to a target.
     * While this is a reasonable approach for some problems, it becomes
     * inefficient for large datasets where other approaches could work.
     * 
     * @param array numbers to search
     * @param targetSum desired sum
     * @return count of pairs that sum to target
     */
    public static int inefficientPairSum(int[] array, int targetSum) {
        // INTENTIONALLY INEFFICIENT: Nested loops for pair finding
        int pairCount = 0;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    pairCount++;
                }
            }
        }
        
        return pairCount;
    }
    
    /**
     * Demonstrates nested loop performance issues.
     */
    private static void demonstrateSlowNestedLoops() {
        System.out.println("--- Nested Loop Performance ---");
        
        // Test duplicate detection
        int[] testArray = generateRandomArrayWithDuplicates(MEDIUM_SIZE);
        
        long startTime = System.nanoTime();
        boolean hasDuplicates = inefficientDuplicateCheck(testArray);
        long endTime = System.nanoTime();
        double elapsedMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.printf("Duplicate check (%d elements): %.2f ms\n", 
                         testArray.length, elapsedMs);
        System.out.printf("Has duplicates: %b\n", hasDuplicates);
        
        // Test pair sum finding
        int[] pairArray = generateRandomArray(SMALL_SIZE); // Smaller for O(n²) operation
        int targetSum = 50;
        
        startTime = System.nanoTime();
        int pairs = inefficientPairSum(pairArray, targetSum);
        endTime = System.nanoTime();
        elapsedMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.printf("Pair sum search (%d elements): %.2f ms\n", 
                         pairArray.length, elapsedMs);
        System.out.printf("Pairs found: %d\n", pairs);
        System.out.println("Problem: O(n²) nested loops for operations that could be O(n)");
        System.out.println();
    }
    
    // =============================================================================
    // STRING CONCATENATION PROBLEM - Problem #4
    // =============================================================================
    
    /**
     * INEFFICIENT: String concatenation in a loop.
     * 
     * This method builds a string by concatenating in a loop.
     * String concatenation creates new String objects each time,
     * leading to O(n²) complexity instead of O(n) with StringBuilder.
     * 
     * Performance Issue: String immutability causes repeated copying
     * Expected Optimization: StringBuilder for O(n) complexity
     * 
     * @param words array of words to concatenate
     * @return single string with all words concatenated
     */
    public static String inefficientStringBuilding(String[] words) {
        // INTENTIONALLY INEFFICIENT: String concatenation in loop
        String result = "";
        
        for (String word : words) {
            result += word + " "; // ❌ Creates new String object each time
        }
        
        return result.trim();
    }
    
    /**
     * INEFFICIENT: Building CSV string with repeated concatenation.
     * 
     * This method creates a CSV string using repeated string concatenation.
     * Each concatenation creates a new string, copying all previous content.
     * 
     * @param numbers array of numbers to format as CSV
     * @return CSV string representation
     */
    public static String inefficientCsvBuilder(int[] numbers) {
        // INTENTIONALLY INEFFICIENT: CSV building with string concatenation
        String csv = "";
        
        for (int i = 0; i < numbers.length; i++) {
            csv += numbers[i]; // ❌ String concatenation in loop
            if (i < numbers.length - 1) {
                csv += ","; // ❌ More concatenation
            }
        }
        
        return csv;
    }
    
    /**
     * Demonstrates string concatenation performance issues.
     */
    private static void demonstrateSlowStringConcatenation() {
        System.out.println("--- String Concatenation Performance ---");
        
        // Test word concatenation
        String[] words = generateWordArray(5000);
        
        long startTime = System.nanoTime();
        String result = inefficientStringBuilding(words);
        long endTime = System.nanoTime();
        double elapsedMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.printf("String concatenation (%d words): %.2f ms\n", 
                         words.length, elapsedMs);
        System.out.printf("Result length: %d characters\n", result.length());
        
        // Test CSV building
        int[] numbers = generateRandomArray(MEDIUM_SIZE);
        
        startTime = System.nanoTime();
        String csv = inefficientCsvBuilder(numbers);
        endTime = System.nanoTime();
        elapsedMs = (endTime - startTime) / 1_000_000.0;
        
        System.out.printf("CSV building (%d numbers): %.2f ms\n", 
                         numbers.length, elapsedMs);
        System.out.printf("CSV length: %d characters\n", csv.length());
        System.out.println("Problem: O(n²) string concatenation instead of O(n) StringBuilder");
        System.out.println();
    }
    
    // =============================================================================
    // UTILITY METHODS FOR GENERATING TEST DATA
    // =============================================================================
    
    /**
     * Generates a sorted array of consecutive integers.
     */
    private static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1; // Values 1, 2, 3, ..., size
        }
        return array;
    }
    
    /**
     * Generates an array of random integers.
     */
    private static int[] generateRandomArray(int size) {
        Random random = new Random(42); // Fixed seed for reproducible results
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 2); // Values 0 to 2*size
        }
        return array;
    }
    
    /**
     * Generates an array with some guaranteed duplicates.
     */
    private static int[] generateRandomArrayWithDuplicates(int size) {
        Random random = new Random(42);
        int[] array = new int[size];
        int uniqueValues = size / 4; // Force duplicates by limiting unique values
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(uniqueValues);
        }
        return array;
    }
    
    /**
     * Generates an array of random words for string concatenation testing.
     */
    private static String[] generateWordArray(int size) {
        String[] words = new String[size];
        Random random = new Random(42);
        String[] baseWords = {"hello", "world", "java", "performance", "optimization", 
                             "algorithm", "data", "structure", "efficient", "fast"};
        
        for (int i = 0; i < size; i++) {
            words[i] = baseWords[random.nextInt(baseWords.length)] + i;
        }
        return words;
    }
    
    // =============================================================================
    // CONVENIENCE METHODS FOR PROFILING
    // =============================================================================
    
    /**
     * Runs all inefficient methods for profiling purposes.
     * Students can call this from PerformanceAnalysis.java.
     */
    public static void runAllSlowMethods() {
        System.out.println("Running all slow methods for profiling...");
        
        // Generate test data
        int[] sortedData = generateSortedArray(LARGE_SIZE);
        int[] randomData = generateRandomArray(MEDIUM_SIZE);
        String[] words = generateWordArray(3000);
        
        // Run each slow method
        inefficientSearch(sortedData, LARGE_SIZE - 100);
        inefficientDataStructure(randomData);
        inefficientDuplicateCheck(randomData);
        inefficientStringBuilding(words);
        
        System.out.println("All slow methods completed.");
    }
    
    /**
     * Gets test data for consistent benchmarking.
     * Students can use this to ensure they're testing optimizations 
     * with the same data as the original slow methods.
     */
    public static TestData getStandardTestData() {
        return new TestData(
            generateSortedArray(LARGE_SIZE),
            generateRandomArray(MEDIUM_SIZE),
            generateRandomArrayWithDuplicates(MEDIUM_SIZE),
            generateWordArray(3000),
            generateRandomArray(SMALL_SIZE)
        );
    }
    
    /**
     * Container class for standard test datasets.
     */
    public static class TestData {
        public final int[] sortedArray;
        public final int[] randomArray;
        public final int[] duplicateArray;
        public final String[] wordArray;
        public final int[] smallArray;
        
        public TestData(int[] sortedArray, int[] randomArray, int[] duplicateArray, 
                       String[] wordArray, int[] smallArray) {
            this.sortedArray = sortedArray;
            this.randomArray = randomArray;
            this.duplicateArray = duplicateArray;
            this.wordArray = wordArray;
            this.smallArray = smallArray;
        }
    }
}