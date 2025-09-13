package benchmarks;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import datastructures.*;

/**
 * Comprehensive benchmark suite for Data Structures Milestone 2
 * 
 * This template provides the framework for timing and analyzing your ADT implementations.
 * Complete the TODO sections to benchmark your specific implementations.
 * 
 * @author Your Team Name
 * @version Milestone 2
 */
public class BenchmarkSuite {
    
    // Test data sizes - modify as needed
    private static final int[] DATA_SIZES = {1000, 5000, 10000, 50000, 100000};
    private static final int WARMUP_ITERATIONS = 3;
    private static final int BENCHMARK_ITERATIONS = 5;
    
    // Results storage
    private List<BenchmarkResult> results;
    private PrintWriter csvWriter;
    
    public BenchmarkSuite() {
        this.results = new ArrayList<>();
        initializeCSVOutput();
    }
    
    /**
     * Main benchmarking method - runs all performance tests
     */
    public void runAllBenchmarks() {
        System.out.println("Starting Comprehensive ADT Benchmark Suite");
        System.out.println("==========================================");
        
        // Warm up the JVM
        performWarmup();
        
        // Run benchmarks for each ADT
        benchmarkBST();
        benchmarkAVL();
        benchmarkHeap();
        benchmarkHashTable();
        
        // Generate final report
        generateSummaryReport();
        closeCSVOutput();
    }
    
    /**
     * Benchmark Binary Search Tree operations
     */
    private void benchmarkBST() {
        System.out.println("\n=== BST Performance Analysis ===");
        
        for (int size : DATA_SIZES) {
            System.out.printf("Testing BST with %d elements...\n", size);
            
            // TODO: Replace with your BST implementation
            BST<Integer> bst = new BST<>();
            
            // Generate test data
            Integer[] insertData = generateRandomIntegers(size);
            Integer[] searchData = generateSearchData(insertData, size);
            
            // Benchmark insertion
            long insertTime = timeOperation(() -> {
                for (Integer value : insertData) {
                    bst.insert(value);
                }
            }, "BST Insert");
            
            // Benchmark search
            long searchTime = timeOperation(() -> {
                for (Integer value : searchData) {
                    bst.contains(value);
                }
            }, "BST Search");
            
            // Benchmark traversal
            long traversalTime = timeOperation(() -> {
                bst.inorderTraversal();
            }, "BST Traversal");
            
            // Record results
            recordResult("BST", "Insert", size, insertTime);
            recordResult("BST", "Search", size, searchTime);
            recordResult("BST", "Traversal", size, traversalTime);
            
            // Analyze tree structure
            analyzeBSTStructure(bst, size);
        }
    }
    
    /**
     * Benchmark AVL Tree operations
     */
    private void benchmarkAVL() {
        System.out.println("\n=== AVL Tree Performance Analysis ===");
        
        for (int size : DATA_SIZES) {
            System.out.printf("Testing AVL with %d elements...\n", size);
            
            // TODO: Replace with your AVL implementation
            AVLTree<Integer> avl = new AVLTree<>();
            
            Integer[] insertData = generateRandomIntegers(size);
            Integer[] searchData = generateSearchData(insertData, size);
            
            // Benchmark insertion (should be slower than BST due to balancing)
            long insertTime = timeOperation(() -> {
                for (Integer value : insertData) {
                    avl.insert(value);
                }
            }, "AVL Insert");
            
            // Benchmark search (should be faster than unbalanced BST)
            long searchTime = timeOperation(() -> {
                for (Integer value : searchData) {
                    avl.contains(value);
                }
            }, "AVL Search");
            
            recordResult("AVL", "Insert", size, insertTime);
            recordResult("AVL", "Search", size, searchTime);
            
            // Verify balance property
            verifyAVLBalance(avl, size);
        }
    }
    
    /**
     * Benchmark Binary Heap operations
     */
    private void benchmarkHeap() {
        System.out.println("\n=== Binary Heap Performance Analysis ===");
        
        for (int size : DATA_SIZES) {
            System.out.printf("Testing Heap with %d elements...\n", size);
            
            // TODO: Replace with your BinaryHeap implementation
            BinaryHeap<Integer> minHeap = new BinaryHeap<>(false); // min-heap
            BinaryHeap<Integer> maxHeap = new BinaryHeap<>(true);  // max-heap
            
            Integer[] insertData = generateRandomIntegers(size);
            
            // Benchmark insertion
            long minInsertTime = timeOperation(() -> {
                for (Integer value : insertData) {
                    minHeap.insert(value);
                }
            }, "MinHeap Insert");
            
            // Benchmark extraction
            long extractTime = timeOperation(() -> {
                for (int i = 0; i < size / 2; i++) { // Extract half the elements
                    if (!minHeap.isEmpty()) {
                        minHeap.extractRoot();
                    }
                }
            }, "MinHeap Extract");
            
            // Test heapify constructor
            List<Integer> dataList = Arrays.asList(insertData);
            long heapifyTime = timeOperation(() -> {
                new BinaryHeap<>(dataList, false);
            }, "Heapify Constructor");
            
            recordResult("Heap", "Insert", size, minInsertTime);
            recordResult("Heap", "Extract", size, extractTime);
            recordResult("Heap", "Heapify", size, heapifyTime);
        }
    }
    
    /**
     * Benchmark Hash Table with different collision strategies
     */
    private void benchmarkHashTable() {
        System.out.println("\n=== Hash Table Performance Analysis ===");
        
        CollisionStrategy[] strategies = {
            CollisionStrategy.LINEAR_PROBING,
            CollisionStrategy.QUADRATIC_PROBING,
            CollisionStrategy.SEPARATE_CHAINING
        };
        
        for (CollisionStrategy strategy : strategies) {
            System.out.printf("\nTesting %s strategy:\n", strategy);
            
            for (int size : DATA_SIZES) {
                // TODO: Replace with your HashTable implementation
                HashTable<Integer, String> hashTable = new HashTable<>(strategy);
                
                Integer[] keys = generateRandomIntegers(size);
                String[] values = generateRandomStrings(size);
                
                // Benchmark insertion
                long insertTime = timeOperation(() -> {
                    for (int i = 0; i < size; i++) {
                        hashTable.put(keys[i], values[i]);
                    }
                }, "HashTable Insert");
                
                // Benchmark search
                long searchTime = timeOperation(() -> {
                    for (Integer key : keys) {
                        hashTable.get(key);
                    }
                }, "HashTable Search");
                
                recordResult("HashTable_" + strategy, "Insert", size, insertTime);
                recordResult("HashTable_" + strategy, "Search", size, searchTime);
                
                // Analyze hash performance
                analyzeHashTablePerformance(hashTable, size, strategy);
            }
        }
    }
    
    /**
     * Times a single operation using high-precision timing
     */
    private long timeOperation(Runnable operation, String operationName) {
        long totalTime = 0;
        
        // Run multiple iterations for accuracy
        for (int i = 0; i < BENCHMARK_ITERATIONS; i++) {
            System.gc(); // Suggest garbage collection between runs
            
            long startTime = System.nanoTime();
            operation.run();
            long endTime = System.nanoTime();
            
            totalTime += (endTime - startTime);
        }
        
        return totalTime / BENCHMARK_ITERATIONS; // Return average time in nanoseconds
    }
    
    /**
     * Generate array of random integers
     */
    private Integer[] generateRandomIntegers(int count) {
        Random random = new Random(42); // Fixed seed for reproducible results
        Integer[] data = new Integer[count];
        
        for (int i = 0; i < count; i++) {
            data[i] = random.nextInt(count * 10); // Range: 0 to count*10
        }
        
        return data;
    }
    
    /**
     * Generate search data (mix of existing and non-existing values)
     */
    private Integer[] generateSearchData(Integer[] existingData, int searchCount) {
        Random random = new Random(123);
        Integer[] searchData = new Integer[searchCount];
        
        for (int i = 0; i < searchCount; i++) {
            if (random.nextBoolean() && existingData.length > 0) {
                // 50% chance: search for existing value
                searchData[i] = existingData[random.nextInt(existingData.length)];
            } else {
                // 50% chance: search for non-existing value
                searchData[i] = random.nextInt(searchCount * 20) + searchCount * 10;
            }
        }
        
        return searchData;
    }
    
    /**
     * Generate array of random strings
     */
    private String[] generateRandomStrings(int count) {
        Random random = new Random(456);
        String[] strings = new String[count];
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            int length = 5 + random.nextInt(10); // String length 5-15
            
            for (int j = 0; j < length; j++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            
            strings[i] = sb.toString();
        }
        
        return strings;
    }
    
    /**
     * Analyze BST structure properties
     */
    private void analyzeBSTStructure(BST<Integer> bst, int size) {
        // TODO: Implement analysis using your BST methods
        System.out.printf("  BST Height: %d (theoretical optimal: %.2f)\n", 
                         bst.height(), Math.log(size) / Math.log(2));
        System.out.printf("  BST Size: %d\n", bst.size());
    }
    
    /**
     * Verify AVL balance property
     */
    private void verifyAVLBalance(AVLTree<Integer> avl, int size) {
        // TODO: Implement verification using your AVL methods
        System.out.printf("  AVL Height: %d (theoretical optimal: %.2f)\n", 
                         avl.height(), Math.log(size) / Math.log(2));
        System.out.printf("  AVL Balanced: %s\n", avl.isBalanced());
    }
    
    /**
     * Analyze hash table performance metrics
     */
    private void analyzeHashTablePerformance(HashTable<Integer, String> hashTable, 
                                           int size, CollisionStrategy strategy) {
        // TODO: Implement analysis using your HashTable methods
        System.out.printf("  Load Factor: %.2f\n", hashTable.getLoadFactor());
        System.out.printf("  Capacity: %d\n", hashTable.getCapacity());
        System.out.printf("  Collisions: %d\n", hashTable.getCollisions());
        System.out.printf("  Avg Probe Length: %.2f\n", hashTable.getAverageProbeLength());
    }
    
    /**
     * Warm up the JVM for more accurate timing
     */
    private void performWarmup() {
        System.out.println("Warming up JVM...");
        
        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            // Simple operations to warm up JIT compiler
            List<Integer> warmupList = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                warmupList.add(j);
            }
            Collections.shuffle(warmupList);
            warmupList.clear();
        }
    }
    
    /**
     * Record benchmark result for later analysis
     */
    private void recordResult(String structure, String operation, int size, long timeNanos) {
        BenchmarkResult result = new BenchmarkResult(structure, operation, size, timeNanos);
        results.add(result);
        
        // Write to CSV
        csvWriter.printf("%s,%s,%d,%d,%.6f\n", 
                        structure, operation, size, timeNanos, timeNanos / 1_000_000.0);
        csvWriter.flush();
        
        // Print to console
        System.out.printf("  %s %s (%d elements): %.2f ms\n", 
                         structure, operation, size, timeNanos / 1_000_000.0);
    }
    
    /**
     * Initialize CSV output for results
     */
    private void initializeCSVOutput() {
        try {
            Files.createDirectories(Paths.get("benchmarks"));
            csvWriter = new PrintWriter(new FileWriter("benchmarks/results_data.csv"));
            csvWriter.println("Structure,Operation,Size,TimeNanos,TimeMs");
        } catch (IOException e) {
            System.err.println("Error creating CSV output: " + e.getMessage());
        }
    }
    
    /**
     * Generate summary report with analysis
     */
    private void generateSummaryReport() {
        System.out.println("\n=== BENCHMARK SUMMARY REPORT ===");
        
        // Group results by structure and operation
        Map<String, List<BenchmarkResult>> groupedResults = results.stream()
            .collect(java.util.stream.Collectors.groupingBy(
                r -> r.structure + "_" + r.operation
            ));
        
        System.out.println("\nPerformance Growth Analysis:");
        System.out.println("(Comparing smallest vs largest dataset)");
        
        for (Map.Entry<String, List<BenchmarkResult>> entry : groupedResults.entrySet()) {
            List<BenchmarkResult> operationResults = entry.getValue();
            operationResults.sort((a, b) -> Integer.compare(a.size, b.size));
            
            if (operationResults.size() >= 2) {
                BenchmarkResult smallest = operationResults.get(0);
                BenchmarkResult largest = operationResults.get(operationResults.size() - 1);
                
                double timeGrowth = (double) largest.timeNanos / smallest.timeNanos;
                double sizeGrowth = (double) largest.size / smallest.size;
                double complexityRatio = timeGrowth / sizeGrowth;
                
                System.out.printf("%s: %.2fx time growth for %.0fx data growth (ratio: %.2f)\n", 
                                entry.getKey(), timeGrowth, sizeGrowth, complexityRatio);
            }
        }
        
        System.out.println("\nResults written to: benchmarks/results_data.csv");
        System.out.println("Import this data into Excel/Google Sheets for visualization");
    }
    
    /**
     * Close CSV output
     */
    private void closeCSVOutput() {
        if (csvWriter != null) {
            csvWriter.close();
        }
    }
    
    /**
     * Data class for storing benchmark results
     */
    private static class BenchmarkResult {
        final String structure;
        final String operation;
        final int size;
        final long timeNanos;
        
        BenchmarkResult(String structure, String operation, int size, long timeNanos) {
            this.structure = structure;
            this.operation = operation;
            this.size = size;
            this.timeNanos = timeNanos;
        }
    }
    
    /**
     * Main method to run benchmarks
     */
    public static void main(String[] args) {
        BenchmarkSuite suite = new BenchmarkSuite();
        suite.runAllBenchmarks();
        
        System.out.println("\n=== BENCHMARK COMPLETE ===");
        System.out.println("Next steps:");
        System.out.println("1. Review console output for immediate insights");
        System.out.println("2. Open benchmarks/results_data.csv in Excel/Google Sheets");
        System.out.println("3. Create charts showing time vs. data size for each operation");
        System.out.println("4. Compare your results against theoretical complexity predictions");
        System.out.println("5. Document any surprising results in your complexity report");
    }
}