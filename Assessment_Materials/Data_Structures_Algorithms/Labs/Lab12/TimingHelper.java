import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * TimingHelper - Utility class for accurate performance measurement in Lab 12.
 * 
 * This class provides easy-to-use methods for timing operations, measuring memory usage,
 * and performing statistical analysis of performance data. All methods are static -
 * no need to create TimingHelper objects.
 * 
 * Key Features:
 * - High-precision timing with System.nanoTime()
 * - Automatic JVM warmup handling
 * - Statistical timing with multiple runs
 * - Memory usage measurement
 * - Simple API for student use
 * 
 * @author Lab 12 Framework
 * @version 1.0
 */
public class TimingHelper {
    
    // Configuration constants
    private static final int DEFAULT_WARMUP_RUNS = 3;
    private static final int DEFAULT_TIMING_RUNS = 5;
    private static final double NANOS_TO_MILLIS = 1_000_000.0;
    
    // For tracking nested timing operations
    private static final Map<String, Long> activeTimers = new HashMap<>();
    
    // =============================================================================
    // SIMPLE TIMING METHODS
    // =============================================================================
    
    /**
     * Times a single operation with high precision.
     * No warmup - use for operations that are already warmed up.
     * 
     * @param operation the operation to time
     * @return execution time in milliseconds
     */
    public static double timeOperation(Runnable operation) {
        long start = System.nanoTime();
        operation.run();
        long end = System.nanoTime();
        return (end - start) / NANOS_TO_MILLIS;
    }
    
    /**
     * Times an operation with automatic JVM warmup.
     * Performs warmup runs, then times the operation multiple times and returns average.
     * 
     * @param operation the operation to time
     * @return average execution time in milliseconds
     */
    public static double timeWithWarmup(Runnable operation) {
        return timeWithWarmup(operation, DEFAULT_WARMUP_RUNS, DEFAULT_TIMING_RUNS);
    }
    
    /**
     * Times an operation with custom warmup and timing run counts.
     * 
     * @param operation the operation to time
     * @param warmupRuns number of warmup runs (typically 3-5)
     * @param timingRuns number of timing runs to average (typically 5-10)
     * @return average execution time in milliseconds
     */
    public static double timeWithWarmup(Runnable operation, int warmupRuns, int timingRuns) {
        // JVM Warmup
        for (int i = 0; i < warmupRuns; i++) {
            operation.run();
        }
        
        // Actual timing
        long totalTime = 0;
        for (int i = 0; i < timingRuns; i++) {
            long start = System.nanoTime();
            operation.run();
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        
        return (totalTime / (double) timingRuns) / NANOS_TO_MILLIS;
    }
    
    /**
     * Times an operation and returns detailed timing statistics.
     * 
     * @param operation the operation to time
     * @param runs number of timing runs
     * @return TimingResult with average, min, max, and standard deviation
     */
    public static TimingResult timeWithStatistics(Runnable operation, int runs) {
        // JVM Warmup
        for (int i = 0; i < DEFAULT_WARMUP_RUNS; i++) {
            operation.run();
        }
        
        // Collect timing data
        double[] times = new double[runs];
        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            operation.run();
            long end = System.nanoTime();
            times[i] = (end - start) / NANOS_TO_MILLIS;
        }
        
        return new TimingResult(times);
    }
    
    // =============================================================================
    // START/STOP TIMING METHODS
    // =============================================================================
    
    /**
     * Starts timing an operation with a given name.
     * Use with endTiming() for manual timing control.
     * 
     * @param operationName name to identify this timing operation
     */
    public static void startTiming(String operationName) {
        activeTimers.put(operationName, System.nanoTime());
    }
    
    /**
     * Ends timing for an operation and returns the elapsed time.
     * 
     * @param operationName name of the timing operation to end
     * @return elapsed time in milliseconds, or -1 if operation not found
     */
    public static double endTiming(String operationName) {
        Long startTime = activeTimers.remove(operationName);
        if (startTime == null) {
            System.err.println("Warning: No active timer found for operation: " + operationName);
            return -1;
        }
        
        long endTime = System.nanoTime();
        return (endTime - startTime) / NANOS_TO_MILLIS;
    }
    
    /**
     * Ends timing and prints the result automatically.
     * 
     * @param operationName name of the timing operation to end
     * @return elapsed time in milliseconds
     */
    public static double endTimingAndPrint(String operationName) {
        double elapsed = endTiming(operationName);
        if (elapsed >= 0) {
            System.out.printf("%s: %.2f ms\n", operationName, elapsed);
        }
        return elapsed;
    }
    
    // =============================================================================
    // MEMORY MEASUREMENT METHODS
    // =============================================================================
    
    /**
     * Gets current memory usage in bytes.
     * 
     * @return current memory usage (total - free memory)
     */
    public static long getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
    
    /**
     * Gets current memory usage in megabytes.
     * 
     * @return current memory usage in MB
     */
    public static double getMemoryUsageMB() {
        return getMemoryUsage() / (1024.0 * 1024.0);
    }
    
    /**
     * Measures memory used by an operation.
     * Requests garbage collection before and after for more accurate measurement.
     * 
     * @param operation the operation to measure
     * @return MemoryResult with memory usage details
     */
    public static MemoryResult measureMemoryUsage(Runnable operation) {
        // Request garbage collection for cleaner measurement
        System.gc();
        try {
            Thread.sleep(100); // Give GC time to run
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long memoryBefore = getMemoryUsage();
        
        // Run the operation
        operation.run();
        
        // Request garbage collection again
        System.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long memoryAfter = getMemoryUsage();
        
        return new MemoryResult(memoryBefore, memoryAfter);
    }
    
    /**
     * Measures both timing and memory usage for an operation.
     * 
     * @param operation the operation to measure
     * @return PerformanceResult with both timing and memory data
     */
    public static PerformanceResult measurePerformance(Runnable operation) {
        MemoryResult memoryResult = measureMemoryUsage(() -> {
            // Don't measure timing during memory measurement to avoid interference
            operation.run();
        });
        
        TimingResult timingResult = timeWithStatistics(operation, DEFAULT_TIMING_RUNS);
        
        return new PerformanceResult(timingResult, memoryResult);
    }
    
    // =============================================================================
    // COMPARISON AND ANALYSIS METHODS
    // =============================================================================
    
    /**
     * Compares performance of two operations and calculates speedup.
     * 
     * @param slowOperation the baseline (slower) operation
     * @param fastOperation the optimized (faster) operation
     * @param operationName descriptive name for the operation
     * @return ComparisonResult with timing data and speedup calculation
     */
    public static ComparisonResult compareOperations(Runnable slowOperation, 
                                                   Runnable fastOperation, 
                                                   String operationName) {
        System.out.println("Comparing: " + operationName);
        System.out.println("Warming up and timing baseline operation...");
        double slowTime = timeWithWarmup(slowOperation);
        
        System.out.println("Warming up and timing optimized operation...");
        double fastTime = timeWithWarmup(fastOperation);
        
        return new ComparisonResult(slowTime, fastTime, operationName);
    }
    
    /**
     * Analyzes scaling behavior by testing with different input sizes.
     * 
     * @param operationFactory function that creates operation for given size
     * @param sizes array of input sizes to test
     * @param operationName descriptive name for the operation
     * @return ScalingResult with timing data for each size
     */
    public static ScalingResult analyzeScaling(OperationFactory operationFactory,
                                             int[] sizes, String operationName) {
        System.out.println("Analyzing scaling for: " + operationName);
        
        double[] times = new double[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("Testing size %d...\n", sizes[i]);
            Runnable operation = operationFactory.createOperation(sizes[i]);
            times[i] = timeWithWarmup(operation);
        }
        
        return new ScalingResult(sizes, times, operationName);
    }
    
    // =============================================================================
    // UTILITY METHODS
    // =============================================================================
    
    /**
     * Formats time in appropriate units (ms, seconds, etc.).
     * 
     * @param milliseconds time in milliseconds
     * @return formatted time string
     */
    public static String formatTime(double milliseconds) {
        if (milliseconds < 1.0) {
            return String.format("%.3f ms", milliseconds);
        } else if (milliseconds < 1000.0) {
            return String.format("%.2f ms", milliseconds);
        } else {
            return String.format("%.2f sec", milliseconds / 1000.0);
        }
    }
    
    /**
     * Formats memory in appropriate units (bytes, KB, MB).
     * 
     * @param bytes memory in bytes
     * @return formatted memory string
     */
    public static String formatMemory(long bytes) {
        if (bytes < 1024) {
            return bytes + " bytes";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.1f KB", bytes / 1024.0);
        } else {
            return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
        }
    }
    
    /**
     * Calculates speedup ratio between two times.
     * 
     * @param slowTime baseline time
     * @param fastTime optimized time
     * @return speedup ratio (slowTime / fastTime)
     */
    public static double calculateSpeedup(double slowTime, double fastTime) {
        if (fastTime <= 0) {
            return Double.POSITIVE_INFINITY;
        }
        return slowTime / fastTime;
    }
    
    /**
     * Calculates percentage improvement.
     * 
     * @param oldValue original value
     * @param newValue improved value
     * @return improvement percentage
     */
    public static double calculateImprovement(double oldValue, double newValue) {
        if (oldValue <= 0) {
            return 0;
        }
        return ((oldValue - newValue) / oldValue) * 100.0;
    }
    
    // =============================================================================
    // RESULT CLASSES
    // =============================================================================
    
    /**
     * Contains timing statistics for an operation.
     */
    public static class TimingResult {
        public final double average;
        public final double minimum;
        public final double maximum;
        public final double standardDeviation;
        public final int sampleCount;
        
        public TimingResult(double[] times) {
            this.sampleCount = times.length;
            
            // Calculate statistics
            double sum = 0;
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            
            for (double time : times) {
                sum += time;
                min = Math.min(min, time);
                max = Math.max(max, time);
            }
            
            this.average = sum / times.length;
            this.minimum = min;
            this.maximum = max;
            
            // Calculate standard deviation
            double sumSquaredDiffs = 0;
            for (double time : times) {
                double diff = time - average;
                sumSquaredDiffs += diff * diff;
            }
            this.standardDeviation = Math.sqrt(sumSquaredDiffs / times.length);
        }
        
        @Override
        public String toString() {
            return String.format("Avg: %.2f ms (±%.2f), Range: %.2f-%.2f ms (%d samples)",
                               average, standardDeviation, minimum, maximum, sampleCount);
        }
    }
    
    /**
     * Contains memory usage information.
     */
    public static class MemoryResult {
        public final long memoryBefore;
        public final long memoryAfter;
        public final long memoryUsed;
        
        public MemoryResult(long memoryBefore, long memoryAfter) {
            this.memoryBefore = memoryBefore;
            this.memoryAfter = memoryAfter;
            this.memoryUsed = memoryAfter - memoryBefore;
        }
        
        @Override
        public String toString() {
            return String.format("Memory used: %s (before: %s, after: %s)",
                               formatMemory(memoryUsed), 
                               formatMemory(memoryBefore), 
                               formatMemory(memoryAfter));
        }
    }
    
    /**
     * Contains both timing and memory results.
     */
    public static class PerformanceResult {
        public final TimingResult timing;
        public final MemoryResult memory;
        
        public PerformanceResult(TimingResult timing, MemoryResult memory) {
            this.timing = timing;
            this.memory = memory;
        }
        
        @Override
        public String toString() {
            return String.format("Performance: %s, %s", timing, memory);
        }
    }
    
    /**
     * Contains comparison results between two operations.
     */
    public static class ComparisonResult {
        public final double slowTime;
        public final double fastTime;
        public final double speedup;
        public final double improvement;
        public final String operationName;
        
        public ComparisonResult(double slowTime, double fastTime, String operationName) {
            this.slowTime = slowTime;
            this.fastTime = fastTime;
            this.speedup = calculateSpeedup(slowTime, fastTime);
            this.improvement = calculateImprovement(slowTime, fastTime);
            this.operationName = operationName;
        }
        
        public void printResults() {
            System.out.printf("Results for %s:\n", operationName);
            System.out.printf("  Baseline:    %s\n", formatTime(slowTime));
            System.out.printf("  Optimized:   %s\n", formatTime(fastTime));
            System.out.printf("  Speedup:     %.1fx faster\n", speedup);
            System.out.printf("  Improvement: %.1f%%\n", improvement);
            System.out.println();
        }
    }
    
    /**
     * Contains scaling analysis results.
     */
    public static class ScalingResult {
        public final int[] sizes;
        public final double[] times;
        public final String operationName;
        
        public ScalingResult(int[] sizes, double[] times, String operationName) {
            this.sizes = sizes.clone();
            this.times = times.clone();
            this.operationName = operationName;
        }
        
        public void printResults() {
            System.out.printf("Scaling analysis for %s:\n", operationName);
            System.out.println("Size       | Time       | Time/Size");
            System.out.println("-----------|------------|----------");
            
            for (int i = 0; i < sizes.length; i++) {
                double timePerElement = times[i] / sizes[i];
                System.out.printf("%10d | %10s | %.4f ms\n", 
                                 sizes[i], formatTime(times[i]), timePerElement);
            }
            System.out.println();
        }
    }
    
    /**
     * Functional interface for creating operations of different sizes.
     */
    @FunctionalInterface
    public interface OperationFactory {
        Runnable createOperation(int size);
    }
    
    // =============================================================================
    // DEMONSTRATION AND TESTING
    // =============================================================================
    
    /**
     * Demonstrates TimingHelper capabilities.
     * Students can run this to see examples of how to use the timing utilities.
     */
    public static void main(String[] args) {
        System.out.println("=== TimingHelper Demonstration ===");
        System.out.println();
        
        // Example 1: Simple operation timing
        System.out.println("1. Simple operation timing:");
        double time1 = timeOperation(() -> {
            try { Thread.sleep(50); } catch (InterruptedException e) {}
        });
        System.out.printf("Sleep operation: %.2f ms\n", time1);
        System.out.println();
        
        // Example 2: Start/stop timing
        System.out.println("2. Start/stop timing:");
        startTiming("example_operation");
        try { Thread.sleep(25); } catch (InterruptedException e) {}
        endTimingAndPrint("example_operation");
        System.out.println();
        
        // Example 3: Memory measurement
        System.out.println("3. Memory measurement:");
        MemoryResult memResult = measureMemoryUsage(() -> {
            // Create some objects
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        });
        System.out.println(memResult);
        System.out.println();
        
        // Example 4: Operation comparison
        System.out.println("4. Operation comparison:");
        ComparisonResult comparison = compareOperations(
            () -> { try { Thread.sleep(100); } catch (InterruptedException e) {} },
            () -> { try { Thread.sleep(25); } catch (InterruptedException e) {} },
            "Sleep operations"
        );
        comparison.printResults();
        
        System.out.println("TimingHelper demonstration complete!");
    }
}