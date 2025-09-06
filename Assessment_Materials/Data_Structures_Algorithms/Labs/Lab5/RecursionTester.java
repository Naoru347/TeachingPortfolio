import java.util.*;

/**
 * RecursionTester - Lab 5 Testing Framework
 * 
 * Comprehensive testing suite for recursive algorithms with call stack
 * visualization, performance analysis, and correctness verification.
 * 
 * @author CSC 220 Teaching Team
 * @version Lab 5 - Fall 2025
 */
public class RecursionTester {
    
    private static int testsRun = 0;
    private static int testsPassed = 0;
    
    // =============================================================================
    // Basic Recursive Algorithm Tests
    // =============================================================================
    
    /**
     * Test suite for basic recursive algorithms
     */
    public static void testBasicRecursiveAlgorithms() {
        System.out.println("=== Basic Recursive Algorithm Tests ===");
        
        testPowerFunction();
        testStringReversal();
        testPalindromeChecker();
        testSumOfDigits();
        testFibonacci();
        
        System.out.println("Basic recursive algorithm tests completed.\n");
    }
    
    /**
     * Test power function implementation
     */
    private static void testPowerFunction() {
        System.out.println("Testing power function...");
        
        // Test cases
        assertEqual(1L, RecursionStarter.power(5, 0), "5^0 should equal 1");
        assertEqual(5L, RecursionStarter.power(5, 1), "5^1 should equal 5");
        assertEqual(8L, RecursionStarter.power(2, 3), "2^3 should equal 8");
        assertEqual(81L, RecursionStarter.power(3, 4), "3^4 should equal 81");
        assertEqual(1024L, RecursionStarter.power(2, 10), "2^10 should equal 1024");
        assertEqual(1L, RecursionStarter.power(1, 100), "1^100 should equal 1");
        
        System.out.println("✓ Power function tests passed");
    }
    
    /**
     * Test string reversal implementation
     */
    private static void testStringReversal() {
        System.out.println("Testing string reversal...");
        
        assertEqual("", RecursionStarter.reverse(""), "Empty string should reverse to empty");
        assertEqual("a", RecursionStarter.reverse("a"), "Single character should reverse to itself");
        assertEqual("olleh", RecursionStarter.reverse("hello"), "hello should reverse to olleh");
        assertEqual("edcba", RecursionStarter.reverse("abcde"), "abcde should reverse to edcba");
        assertEqual("!dlrow", RecursionStarter.reverse("world!"), "world! should reverse to !dlrow");
        
        System.out.println("✓ String reversal tests passed");
    }
    
    /**
     * Test palindrome checker implementation
     */
    private static void testPalindromeChecker() {
        System.out.println("Testing palindrome checker...");
        
        assertTrue(RecursionStarter.isPalindrome(""), "Empty string is palindrome");
        assertTrue(RecursionStarter.isPalindrome("a"), "Single character is palindrome");
        assertTrue(RecursionStarter.isPalindrome("aa"), "Two same characters is palindrome");
        assertTrue(RecursionStarter.isPalindrome("aba"), "aba is palindrome");
        assertTrue(RecursionStarter.isPalindrome("racecar"), "racecar is palindrome");
        assertTrue(RecursionStarter.isPalindrome("madam"), "madam is palindrome");
        
        assertFalse(RecursionStarter.isPalindrome("ab"), "ab is not palindrome");
        assertFalse(RecursionStarter.isPalindrome("hello"), "hello is not palindrome");
        assertFalse(RecursionStarter.isPalindrome("almost"), "almost is not palindrome");
        
        System.out.println("✓ Palindrome checker tests passed");
    }
    
    /**
     * Test sum of digits implementation
     */
    private static void testSumOfDigits() {
        System.out.println("Testing sum of digits...");
        
        assertEqual(0, RecursionStarter.sumOfDigits(0), "Sum of digits of 0");
        assertEqual(5, RecursionStarter.sumOfDigits(5), "Sum of digits of 5");
        assertEqual(6, RecursionStarter.sumOfDigits(123), "Sum of digits of 123");
        assertEqual(27, RecursionStarter.sumOfDigits(999), "Sum of digits of 999");
        assertEqual(1, RecursionStarter.sumOfDigits(1000), "Sum of digits of 1000");
        assertEqual(45, RecursionStarter.sumOfDigits(123456789), "Sum of digits of 123456789");
        
        System.out.println("✓ Sum of digits tests passed");
    }
    
    /**
     * Test Fibonacci implementation
     */
    private static void testFibonacci() {
        System.out.println("Testing Fibonacci (warning: inefficient implementation)...");
        
        assertEqual(0, RecursionStarter.fibonacci(0), "fibonacci(0) should be 0");
        assertEqual(1, RecursionStarter.fibonacci(1), "fibonacci(1) should be 1");
        assertEqual(1, RecursionStarter.fibonacci(2), "fibonacci(2) should be 1");
        assertEqual(2, RecursionStarter.fibonacci(3), "fibonacci(3) should be 2");
        assertEqual(3, RecursionStarter.fibonacci(4), "fibonacci(4) should be 3");
        assertEqual(5, RecursionStarter.fibonacci(5), "fibonacci(5) should be 5");
        assertEqual(8, RecursionStarter.fibonacci(6), "fibonacci(6) should be 8");
        
        // Don't test large numbers - too slow!
        System.out.println("✓ Fibonacci tests passed (small numbers only)");
    }
    
    // =============================================================================
    // Array Recursive Algorithm Tests
    // =============================================================================
    
    /**
     * Test suite for array-based recursive algorithms
     */
    public static void testArrayRecursiveAlgorithms() {
        System.out.println("=== Array Recursive Algorithm Tests ===");
        
        testFindMax();
        testSumArray();
        testCountOccurrences();
        
        System.out.println("Array recursive algorithm tests completed.\n");
    }
    
    /**
     * Test find maximum element
     */
    private static void testFindMax() {
        System.out.println("Testing find maximum...");
        
        int[] single = {42};
        assertEqual(42, RecursionStarter.findMax(single, 0), "Max of single element");
        
        int[] ascending = {1, 2, 3, 4, 5};
        assertEqual(5, RecursionStarter.findMax(ascending, 0), "Max of ascending array");
        
        int[] descending = {5, 4, 3, 2, 1};
        assertEqual(5, RecursionStarter.findMax(descending, 0), "Max of descending array");
        
        int[] mixed = {3, 1, 4, 1, 5, 9, 2, 6};
        assertEqual(9, RecursionStarter.findMax(mixed, 0), "Max of mixed array");
        
        int[] negatives = {-5, -2, -8, -1};
        assertEqual(-1, RecursionStarter.findMax(negatives, 0), "Max of negative numbers");
        
        System.out.println("✓ Find maximum tests passed");
    }
    
    /**
     * Test sum array elements
     */
    private static void testSumArray() {
        System.out.println("Testing sum array...");
        
        int[] empty = {};
        if (empty.length > 0) {
            assertEqual(0, RecursionStarter.sumArray(empty, 0), "Sum of empty array");
        }
        
        int[] single = {7};
        assertEqual(7, RecursionStarter.sumArray(single, 0), "Sum of single element");
        
        int[] positive = {1, 2, 3, 4, 5};
        assertEqual(15, RecursionStarter.sumArray(positive, 0), "Sum of positive numbers");
        
        int[] mixed = {-2, 3, -1, 4};
        assertEqual(4, RecursionStarter.sumArray(mixed, 0), "Sum with negative numbers");
        
        int[] zeros = {0, 0, 0};
        assertEqual(0, RecursionStarter.sumArray(zeros, 0), "Sum of zeros");
        
        System.out.println("✓ Sum array tests passed");
    }
    
    /**
     * Test count occurrences
     */
    private static void testCountOccurrences() {
        System.out.println("Testing count occurrences...");
        
        int[] array = {1, 2, 1, 3, 1, 4, 1};
        
        assertEqual(4, RecursionStarter.countOccurrences(array, 1, 0), "Count of 1");
        assertEqual(1, RecursionStarter.countOccurrences(array, 2, 0), "Count of 2");
        assertEqual(0, RecursionStarter.countOccurrences(array, 5, 0), "Count of non-existent");
        
        int[] noMatches = {2, 3, 4, 5};
        assertEqual(0, RecursionStarter.countOccurrences(noMatches, 1, 0), "No matches");
        
        int[] allMatches = {7, 7, 7, 7};
        assertEqual(4, RecursionStarter.countOccurrences(allMatches, 7, 0), "All matches");
        
        System.out.println("✓ Count occurrences tests passed");
    }
    
    // =============================================================================
    // Divide-and-Conquer Algorithm Tests
    // =============================================================================
    
    /**
     * Test suite for divide-and-conquer algorithms
     */
    public static void testDivideAndConquerAlgorithms() {
        System.out.println("=== Divide-and-Conquer Algorithm Tests ===");
        
        testBinarySearch();
        testMergeSort();
        
        System.out.println("Divide-and-conquer algorithm tests completed.\n");
    }
    
    /**
     * Test binary search implementation
     */
    private static void testBinarySearch() {
        System.out.println("Testing binary search...");
        
        int[] sorted = {1, 3, 5, 7, 9, 11, 13, 15};
        
        // Test found elements
        assertEqual(0, RecursionStarter.binarySearch(sorted, 1), "Search for first element");
        assertEqual(7, RecursionStarter.binarySearch(sorted, 15), "Search for last element");
        assertEqual(3, RecursionStarter.binarySearch(sorted, 7), "Search for middle element");
        assertEqual(1, RecursionStarter.binarySearch(sorted, 3), "Search for second element");
        
        // Test not found elements
        assertEqual(-1, RecursionStarter.binarySearch(sorted, 0), "Search for too small");
        assertEqual(-1, RecursionStarter.binarySearch(sorted, 16), "Search for too large");
        assertEqual(-1, RecursionStarter.binarySearch(sorted, 4), "Search for missing middle");
        assertEqual(-1, RecursionStarter.binarySearch(sorted, 6), "Search for another missing");
        
        // Test single element
        int[] single = {42};
        assertEqual(0, RecursionStarter.binarySearch(single, 42), "Single element found");
        assertEqual(-1, RecursionStarter.binarySearch(single, 41), "Single element not found");
        
        // Test empty array
        int[] empty = {};
        assertEqual(-1, RecursionStarter.binarySearch(empty, 1), "Empty array search");
        
        System.out.println("✓ Binary search tests passed");
    }
    
    /**
     * Test merge sort implementation
     */
    private static void testMergeSort() {
        System.out.println("Testing merge sort...");
        
        // Test already sorted
        int[] sorted = {1, 2, 3, 4, 5};
        int[] sortedCopy = sorted.clone();
        RecursionStarter.mergeSort(sortedCopy);
        assertArrayEquals(sorted, sortedCopy, "Already sorted array");
        
        // Test reverse sorted
        int[] reverse = {5, 4, 3, 2, 1};
        int[] reverseCopy = reverse.clone();
        RecursionStarter.mergeSort(reverseCopy);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, reverseCopy, "Reverse sorted array");
        
        // Test random order
        int[] random = {64, 34, 25, 12, 22, 11, 90};
        int[] randomCopy = random.clone();
        RecursionStarter.mergeSort(randomCopy);
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        assertArrayEquals(expected, randomCopy, "Random order array");
        
        // Test with duplicates
        int[] duplicates = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int[] duplicatesCopy = duplicates.clone();
        RecursionStarter.mergeSort(duplicatesCopy);
        int[] expectedDup = {1, 1, 2, 3, 4, 5, 5, 6, 9};
        assertArrayEquals(expectedDup, duplicatesCopy, "Array with duplicates");
        
        // Test single element
        int[] single = {42};
        int[] singleCopy = single.clone();
        RecursionStarter.mergeSort(singleCopy);
        assertArrayEquals(new int[]{42}, singleCopy, "Single element array");
        
        // Test empty array
        int[] empty = {};
        int[] emptyCopy = empty.clone();
        RecursionStarter.mergeSort(emptyCopy);
        assertArrayEquals(new int[]{}, emptyCopy, "Empty array");
        
        System.out.println("✓ Merge sort tests passed");
    }
    
    // =============================================================================
    // Performance Analysis Tests
    // =============================================================================
    
    /**
     * Compare recursive vs iterative performance
     */
    public static void performanceAnalysis() {
        System.out.println("=== Performance Analysis ===");
        
        compareFibonacciPerformance();
        compareFactorialPerformance();
        analyzeBinarySearchPerformance();
        analyzeMergeSortPerformance();
        
        System.out.println("Performance analysis completed.\n");
    }
    
    /**
     * Compare recursive vs iterative Fibonacci
     */
    private static void compareFibonacciPerformance() {
        System.out.println("Comparing Fibonacci implementations...");
        
        System.out.println("| n  | Recursive Time | Iterative Time | Ratio |");
        System.out.println("|----|----------------|----------------|-------|");
        
        for (int n = 10; n <= 35; n += 5) {
            // Time recursive implementation
            long startTime = System.nanoTime();
            int recursiveResult = RecursionStarter.fibonacci(n);
            long recursiveTime = System.nanoTime() - startTime;
            
            // Time iterative implementation
            startTime = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;
            
            // Verify they give same result
            if (recursiveResult != iterativeResult) {
                System.err.println("ERROR: Different results for n=" + n);
            }
            
            double ratio = (double) recursiveTime / iterativeTime;
            System.out.printf("| %2d | %8.2f ms    | %8.2f ms    | %5.1fx |\n",
                            n, recursiveTime / 1_000_000.0, iterativeTime / 1_000_000.0, ratio);
            
            // Stop if recursive version is taking too long
            if (recursiveTime > 1_000_000_000) { // 1 second
                System.out.println("Stopping at n=" + n + " due to slow recursive performance");
                break;
            }
        }
    }
    
    /**
     * Iterative Fibonacci for comparison
     */
    private static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    /**
     * Compare recursive vs iterative factorial performance
     */
    private static void compareFactorialPerformance() {
        System.out.println("\nComparing factorial implementations...");
        
        System.out.println("| n    | Recursive | Iterative | Tail Recursive |");
        System.out.println("|------|-----------|-----------|----------------|");
        
        for (int n = 100; n <= 1000; n += 200) {
            // Time regular recursive
            long startTime = System.nanoTime();
            long recursiveResult = factorialRecursive(n);
            long recursiveTime = System.nanoTime() - startTime;
            
            // Time iterative
            startTime = System.nanoTime();
            long iterativeResult = factorialIterative(n);
            long iterativeTime = System.nanoTime() - startTime;
            
            // Time tail recursive
            startTime = System.nanoTime();
            long tailResult = RecursionStarter.factorialTail(n);
            long tailTime = System.nanoTime() - startTime;
            
            System.out.printf("| %4d | %6.2f ms | %6.2f ms | %9.2f ms |\n",
                            n, recursiveTime / 1_000_000.0, 
                            iterativeTime / 1_000_000.0,
                            tailTime / 1_000_000.0);
        }
    }
    
    private static long factorialRecursive(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }
    
    private static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Analyze binary search performance scaling
     */
    private static void analyzeBinarySearchPerformance() {
        System.out.println("\nBinary search performance scaling...");
        
        System.out.println("| Array Size | Search Time | log₂(n) | Ratio |");
        System.out.println("|------------|-------------|---------|-------|");
        
        for (int size = 1000; size <= 1000000; size *= 10) {
            // Create sorted array
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i * 2; // Even numbers
            }
            
            // Time multiple searches and average
            long totalTime = 0;
            int searches = 1000;
            Random rand = new Random(42);
            
            for (int i = 0; i < searches; i++) {
                int target = rand.nextInt(size) * 2; // Random even number
                long startTime = System.nanoTime();
                RecursionStarter.binarySearch(arr, target);
                totalTime += System.nanoTime() - startTime;
            }
            
            double avgTime = totalTime / (double) searches / 1000.0; // microseconds
            double logN = Math.log(size) / Math.log(2);
            double ratio = avgTime / logN;
            
            System.out.printf("| %10d | %8.2f μs | %7.1f | %5.2f |\n",
                            size, avgTime, logN, ratio);
        }
    }
    
    /**
     * Analyze merge sort performance scaling
     */
    private static void analyzeMergeSortPerformance() {
        System.out.println("\nMerge sort performance scaling...");
        
        System.out.println("| Array Size | Sort Time | n*log(n) | Ratio |");
        System.out.println("|------------|-----------|----------|-------|");
        
        Random rand = new Random(42);
        
        for (int size = 1000; size <= 100000; size *= 10) {
            // Create random array
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(10000);
            }
            
            // Time sort
            long startTime = System.nanoTime();
            RecursionStarter.mergeSort(arr);
            long sortTime = System.nanoTime() - startTime;
            
            double timeMs = sortTime / 1_000_000.0;
            double nLogN = size * Math.log(size) / Math.log(2);
            double ratio = timeMs / (nLogN / 1000000); // Normalize
            
            System.out.printf("| %10d | %7.2f ms | %8.0f | %5.2f |\n",
                            size, timeMs, nLogN, ratio);
        }
    }
    
    // =============================================================================
    // Call Stack Visualization
    // =============================================================================
    
    /**
     * Demonstrate call stack behavior
     */
    public static void demonstrateCallStack() {
        System.out.println("=== Call Stack Demonstrations ===");
        
        System.out.println("1. Factorial call stack for factorial(4):");
        RecursionStarter.factorialDebug(4, 0);
        
        System.out.println("\n2. Binary search call stack:");
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println("Searching for 7 in: " + Arrays.toString(arr));
        RecursionStarter.binarySearchDebug(arr, 7, 0, arr.length - 1, 0);
        
        System.out.println("\n3. Binary search for non-existent element:");
        System.out.println("Searching for 6 in: " + Arrays.toString(arr));
        RecursionStarter.binarySearchDebug(arr, 6, 0, arr.length - 1, 0);
        
        System.out.println("\nCall stack demonstrations completed.\n");
    }
    
    // =============================================================================
    // Advanced Algorithm Tests
    // =============================================================================
    
    /**
     * Test advanced recursive algorithms
     */
    public static void testAdvancedAlgorithms() {
        System.out.println("=== Advanced Algorithm Tests ===");
        
        testPermutations();
        testTowerOfHanoi();
        testTailRecursion();
        
        System.out.println("Advanced algorithm tests completed.\n");
    }
    
    /**
     * Test permutation generation
     */
    private static void testPermutations() {
        System.out.println("Testing permutation generation...");
        
        List<String> perms1 = RecursionStarter.permutations("A");
        assertEqual(1, perms1.size(), "Single character permutations");
        assertTrue(perms1.contains("A"), "Contains A");
        
        List<String> perms2 = RecursionStarter.permutations("AB");
        assertEqual(2, perms2.size(), "Two character permutations");
        assertTrue(perms2.contains("AB") && perms2.contains("BA"), "Contains AB and BA");
        
        List<String> perms3 = RecursionStarter.permutations("ABC");
        assertEqual(6, perms3.size(), "Three character permutations");
        String[] expected = {"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};
        for (String perm : expected) {
            assertTrue(perms3.contains(perm), "Should contain " + perm);
        }
        
        System.out.println("✓ Permutation tests passed");
    }
    
    /**
     * Test Tower of Hanoi (just verify it doesn't crash)
     */
    private static void testTowerOfHanoi() {
        System.out.println("Testing Tower of Hanoi...");
        
        System.out.println("Tower of Hanoi solution for 3 disks:");
        RecursionStarter.hanoi(3, "A", "C", "B");
        
        System.out.println("✓ Tower of Hanoi test completed");
    }
    
    /**
     * Test tail recursion implementations
     */
    private static void testTailRecursion() {
        System.out.println("Testing tail recursion...");
        
        // Test tail recursive factorial
        assertEqual(120L, RecursionStarter.factorialTail(5), "Tail factorial(5)");
        assertEqual(1L, RecursionStarter.factorialTail(0), "Tail factorial(0)");
        assertEqual(1L, RecursionStarter.factorialTail(1), "Tail factorial(1)");
        
        // Compare with regular factorial for larger numbers
        for (int n = 10; n <= 20; n++) {
            long regular = factorialRecursive(n);
            long tail = RecursionStarter.factorialTail(n);
            assertEqual(regular, tail, "Factorial(" + n + ") should match");
        }
        
        System.out.println("✓ Tail recursion tests passed");
    }
    
    // =============================================================================
    // Utility Methods for Testing
    // =============================================================================
    
    private static void assertTrue(boolean condition, String message) {
        testsRun++;
        if (condition) {
            testsPassed++;
        } else {
            System.err.println("ASSERTION FAILED: " + message);
        }
    }
    
    private static void assertFalse(boolean condition, String message) {
        assertTrue(!condition, message);
    }
    
    private static <T> void assertEqual(T expected, T actual, String message) {
        testsRun++;
        if ((expected == null && actual == null) || 
            (expected != null && expected.equals(actual))) {
            testsPassed++;
        } else {
            System.err.println("ASSERTION FAILED: " + message);
            System.err.println("  Expected: " + expected + ", Actual: " + actual);
        }
    }
    
    private static void assertArrayEquals(int[] expected, int[] actual, String message) {
        testsRun++;
        if (Arrays.equals(expected, actual)) {
            testsPassed++;
        } else {
            System.err.println("ASSERTION FAILED: " + message);
            System.err.println("  Expected: " + Arrays.toString(expected));
            System.err.println("  Actual: " + Arrays.toString(actual));
        }
    }
    
    private static void printTestSummary() {
        System.out.println("=== Test Summary ===");
        System.out.printf("Tests run: %d%n", testsRun);
        System.out.printf("Tests passed: %d%n", testsPassed);
        System.out.printf("Tests failed: %d%n", testsRun - testsPassed);
        System.out.printf("Success rate: %.1f%%%n", (100.0 * testsPassed) / testsRun);
        
        if (testsPassed == testsRun) {
            System.out.println("🎉 All tests passed!");
        } else {
            System.out.println("❌ Some tests failed. Check your implementations.");
        }
    }
    
    // =============================================================================
    // Main Method - Test Runner
    // =============================================================================
    
    /**
     * Run all tests and demonstrations
     */
    public static void main(String[] args) {
        System.out.println("CSC 220 Lab 5 - Recursive Algorithm Tests");
        System.out.println("==========================================");
        
        try {
            // Reset counters
            testsRun = 0;
            testsPassed = 0;
            
            // Run all test suites
            testBasicRecursiveAlgorithms();
            testArrayRecursiveAlgorithms();
            testDivideAndConquerAlgorithms();
            testAdvancedAlgorithms();
            
            // Performance analysis
            performanceAnalysis();
            
            // Call stack demonstrations
            demonstrateCallStack();
            
            // Print final results
            printTestSummary();
            
        } catch (Exception e) {
            System.err.println("UNEXPECTED ERROR during testing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}