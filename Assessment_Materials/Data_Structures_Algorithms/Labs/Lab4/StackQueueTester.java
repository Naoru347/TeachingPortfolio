import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * StackQueueTester - Lab 4 Testing Framework
 * 
 * Comprehensive testing suite for both array-based and linked-based
 * stack and queue implementations. Includes unit tests, performance
 * comparisons, and application testing.
 * 
 * @author CSC 220 Teaching Team
 * @version Lab 4 - Fall 2025
 */
public class StackQueueTester {
    
    private static int testsRun = 0;
    private static int testsPassed = 0;
    
    // =============================================================================
    // Stack Testing Methods
    // =============================================================================
    
    /**
     * Comprehensive test suite for both stack implementations
     */
    public static void testStacks() {
        System.out.println("=== Stack Implementation Tests ===");
        
        testStackBasicOperations();
        testStackEdgeCases();
        testStackErrorConditions();
        testStackResizing();
        
        System.out.println("Stack tests completed.\n");
    }
    
    /**
     * Test basic stack operations for both implementations
     */
    private static void testStackBasicOperations() {
        System.out.println("Testing stack basic operations...");
        
        // Test ArrayStack
        testStackImpl(new ArrayStack<>(), "ArrayStack");
        
        // Test LinkedStack
        testStackImpl(new LinkedStack<>(), "LinkedStack");
        
        System.out.println("✓ Basic stack operations tests passed");
    }
    
    /**
     * Generic test method for any stack implementation
     */
    private static void testStackImpl(Stack<String> stack, String implName) {
        // Test empty stack
        assertTrue(stack.isEmpty(), implName + " should be empty initially");
        assertEqual(0, stack.size(), implName + " size should be 0 initially");
        
        // Test push operations
        stack.push("A");
        assertFalse(stack.isEmpty(), implName + " should not be empty after push");
        assertEqual(1, stack.size(), implName + " size should be 1");
        assertEqual("A", stack.peek(), implName + " peek should return A");
        
        stack.push("B");
        stack.push("C");
        assertEqual(3, stack.size(), implName + " size should be 3");
        assertEqual("C", stack.peek(), implName + " peek should return C (LIFO)");
        
        // Test pop operations
        String popped = stack.pop();
        assertEqual("C", popped, implName + " should pop C first (LIFO)");
        assertEqual(2, stack.size(), implName + " size should be 2 after pop");
        assertEqual("B", stack.peek(), implName + " peek should return B");
        
        popped = stack.pop();
        assertEqual("B", popped, implName + " should pop B second");
        assertEqual("A", stack.peek(), implName + " peek should return A");
        
        popped = stack.pop();
        assertEqual("A", popped, implName + " should pop A last");
        assertTrue(stack.isEmpty(), implName + " should be empty after all pops");
    }
    
    /**
     * Test stack edge cases
     */
    private static void testStackEdgeCases() {
        System.out.println("Testing stack edge cases...");
        
        Stack<Integer> stack = new ArrayStack<>();
        
        // Test single element
        stack.push(42);
        assertEqual((Integer) 42, stack.peek(), "Single element peek");
        assertEqual((Integer) 42, stack.pop(), "Single element pop");
        assertTrue(stack.isEmpty(), "Stack should be empty after single pop");
        
        // Test push/pop sequence
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        
        for (int i = 4; i >= 0; i--) {
            assertEqual((Integer) i, stack.pop(), "LIFO order should be maintained");
        }
        
        System.out.println("✓ Stack edge cases tests passed");
    }
    
    /**
     * Test stack error conditions
     */
    private static void testStackErrorConditions() {
        System.out.println("Testing stack error conditions...");
        
        Stack<String> emptyStack = new LinkedStack<>();
        
        // Test pop on empty stack
        try {
            emptyStack.pop();
            fail("Should throw EmptyStackException");
        } catch (EmptyStackException e) {
            // Expected
            testsRun++;
            testsPassed++;
        }
        
        // Test peek on empty stack
        try {
            emptyStack.peek();
            fail("Should throw EmptyStackException");
        } catch (EmptyStackException e) {
            // Expected
            testsRun++;
            testsPassed++;
        }
        
        System.out.println("✓ Stack error conditions tests passed");
    }
    
    /**
     * Test array stack resizing behavior
     */
    private static void testStackResizing() {
        System.out.println("Testing array stack resizing...");
        
        Stack<Integer> stack = new ArrayStack<>(3); // Small initial capacity
        
        // Push more elements than initial capacity
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        
        assertEqual(10, stack.size(), "Stack should handle resizing");
        
        // Verify LIFO order is maintained after resizing
        for (int i = 9; i >= 0; i--) {
            assertEqual((Integer) i, stack.pop(), "LIFO order after resize");
        }
        
        System.out.println("✓ Stack resizing tests passed");
    }
    
    // =============================================================================
    // Queue Testing Methods
    // =============================================================================
    
    /**
     * Comprehensive test suite for both queue implementations
     */
    public static void testQueues() {
        System.out.println("=== Queue Implementation Tests ===");
        
        testQueueBasicOperations();
        testQueueEdgeCases();
        testQueueErrorConditions();
        testCircularBufferBehavior();
        
        System.out.println("Queue tests completed.\n");
    }
    
    /**
     * Test basic queue operations for both implementations
     */
    private static void testQueueBasicOperations() {
        System.out.println("Testing queue basic operations...");
        
        // Test ArrayQueue
        testQueueImpl(new ArrayQueue<>(), "ArrayQueue");
        
        // Test LinkedQueue
        testQueueImpl(new LinkedQueue<>(), "LinkedQueue");
        
        System.out.println("✓ Basic queue operations tests passed");
    }
    
    /**
     * Generic test method for any queue implementation
     */
    private static void testQueueImpl(Queue<String> queue, String implName) {
        // Test empty queue
        assertTrue(queue.isEmpty(), implName + " should be empty initially");
        assertEqual(0, queue.size(), implName + " size should be 0 initially");
        
        // Test enqueue operations
        queue.enqueue("A");
        assertFalse(queue.isEmpty(), implName + " should not be empty after enqueue");
        assertEqual(1, queue.size(), implName + " size should be 1");
        assertEqual("A", queue.front(), implName + " front should return A");
        
        queue.enqueue("B");
        queue.enqueue("C");
        assertEqual(3, queue.size(), implName + " size should be 3");
        assertEqual("A", queue.front(), implName + " front should still return A (FIFO)");
        
        // Test dequeue operations
        String dequeued = queue.dequeue();
        assertEqual("A", dequeued, implName + " should dequeue A first (FIFO)");
        assertEqual(2, queue.size(), implName + " size should be 2 after dequeue");
        assertEqual("B", queue.front(), implName + " front should return B");
        
        dequeued = queue.dequeue();
        assertEqual("B", dequeued, implName + " should dequeue B second");
        assertEqual("C", queue.front(), implName + " front should return C");
        
        dequeued = queue.dequeue();
        assertEqual("C", dequeued, implName + " should dequeue C last");
        assertTrue(queue.isEmpty(), implName + " should be empty after all dequeues");
    }
    
    /**
     * Test queue edge cases
     */
    private static void testQueueEdgeCases() {
        System.out.println("Testing queue edge cases...");
        
        Queue<Character> queue = new LinkedQueue<>();
        
        // Test single element
        queue.enqueue('X');
        assertEqual((Character) 'X', queue.front(), "Single element front");
        assertEqual((Character) 'X', queue.dequeue(), "Single element dequeue");
        assertTrue(queue.isEmpty(), "Queue should be empty after single dequeue");
        
        // Test enqueue/dequeue sequence
        char[] letters = {'A', 'B', 'C', 'D', 'E'};
        for (char letter : letters) {
            queue.enqueue(letter);
        }
        
        for (char letter : letters) {
            assertEqual((Character) letter, queue.dequeue(), "FIFO order should be maintained");
        }
        
        System.out.println("✓ Queue edge cases tests passed");
    }
    
    /**
     * Test queue error conditions
     */
    private static void testQueueErrorConditions() {
        System.out.println("Testing queue error conditions...");
        
        Queue<String> emptyQueue = new ArrayQueue<>();
        
        // Test dequeue on empty queue
        try {
            emptyQueue.dequeue();
            fail("Should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Expected
            testsRun++;
            testsPassed++;
        }
        
        // Test front on empty queue
        try {
            emptyQueue.front();
            fail("Should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Expected
            testsRun++;
            testsPassed++;
        }
        
        System.out.println("✓ Queue error conditions tests passed");
    }
    
    /**
     * Test circular buffer behavior specifically
     */
    private static void testCircularBufferBehavior() {
        System.out.println("Testing circular buffer behavior...");
        
        Queue<Integer> queue = new ArrayQueue<>();
        
        // Fill, partially empty, then fill again to test wraparound
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        
        // Remove first two elements
        assertEqual((Integer) 0, queue.dequeue(), "Dequeue 0");
        assertEqual((Integer) 1, queue.dequeue(), "Dequeue 1");
        
        // Add more elements (should trigger wraparound)
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        
        // Verify correct order
        assertEqual(6, queue.size(), "Size after wraparound operations");
        assertEqual((Integer) 2, queue.front(), "Front after wraparound");
        
        // Dequeue all and verify order
        int[] expectedOrder = {2, 3, 4, 5, 6, 7};
        for (int expected : expectedOrder) {
            assertEqual((Integer) expected, queue.dequeue(), "Order after wraparound");
        }
        
        assertTrue(queue.isEmpty(), "Queue should be empty after all dequeues");
        
        System.out.println("✓ Circular buffer tests passed");
    }
    
    // =============================================================================
    // Application Testing Methods
    // =============================================================================
    
    /**
     * Test stack and queue applications
     */
    public static void testApplications() {
        System.out.println("=== Application Tests ===");
        
        testBalancedParentheses();
        testTextEditor();
        testPrintQueue();
        
        System.out.println("Application tests completed.\n");
    }
    
    /**
     * Test balanced parentheses checker
     */
    private static void testBalancedParentheses() {
        System.out.println("Testing balanced parentheses checker...");
        
        // Test cases that should return true
        assertTrue(StackQueueApplications.isBalanced("()"), "Simple parentheses");
        assertTrue(StackQueueApplications.isBalanced("([{}])"), "Mixed nested brackets");
        assertTrue(StackQueueApplications.isBalanced(""), "Empty string");
        assertTrue(StackQueueApplications.isBalanced("abc"), "No brackets");
        assertTrue(StackQueueApplications.isBalanced("a(b[c{d}e]f)g"), "Brackets with letters");
        
        // Test cases that should return false
        assertFalse(StackQueueApplications.isBalanced("("), "Unmatched opening");
        assertFalse(StackQueueApplications.isBalanced(")"), "Unmatched closing");
        assertFalse(StackQueueApplications.isBalanced("([)]"), "Wrong nesting order");
        assertFalse(StackQueueApplications.isBalanced("((())"), "Unmatched nested");
        
        System.out.println("✓ Balanced parentheses tests passed");
    }
    
    /**
     * Test text editor undo functionality
     */
    private static void testTextEditor() {
        System.out.println("Testing text editor undo functionality...");
        
        StackQueueApplications.TextEditor editor = new StackQueueApplications.TextEditor();
        
        // Test initial state
        assertEqual("", editor.getText(), "Initial text should be empty");
        
        // Test typing
        editor.type("Hello");
        assertEqual("Hello", editor.getText(), "Text after first type");
        
        editor.type(" World");
        assertEqual("Hello World", editor.getText(), "Text after second type");
        
        // Test undo
        editor.undo();
        assertEqual("Hello", editor.getText(), "Text after first undo");
        
        editor.undo();
        assertEqual("", editor.getText(), "Text after second undo");
        
        // Test undo on empty (should not crash)
        editor.undo();
        assertEqual("", editor.getText(), "Text should remain empty");
        
        System.out.println("✓ Text editor tests passed");
    }
    
    /**
     * Test print queue functionality
     */
    private static void testPrintQueue() {
        System.out.println("Testing print queue functionality...");
        
        StackQueueApplications.PrintQueue printer = new StackQueueApplications.PrintQueue();
        
        // Test initial state
        assertEqual(0, printer.getJobCount(), "Initial job count should be 0");
        
        // Test job submission
        printer.submitJob("Document1.pdf");
        printer.submitJob("Photo.jpg");
        printer.submitJob("Report.docx");
        assertEqual(3, printer.getJobCount(), "Job count after submissions");
        
        // Test job processing (FIFO order)
        printer.processNext(); // Should process Document1.pdf
        assertEqual(2, printer.getJobCount(), "Job count after first process");
        
        printer.processNext(); // Should process Photo.jpg
        printer.processNext(); // Should process Report.docx
        assertEqual(0, printer.getJobCount(), "Job count after all processed");
        
        // Test processing empty queue (should not crash)
        printer.processNext();
        assertEqual(0, printer.getJobCount(), "Job count should remain 0");
        
        System.out.println("✓ Print queue tests passed");
    }
    
    // =============================================================================
    // Performance Comparison Methods
    // =============================================================================
    
    /**
     * Compare performance of different implementations
     */
    public static void comparePerformance() {
        System.out.println("=== Performance Comparison ===");
        
        final int[] sizes = {1000, 5000, 10000};
        
        for (int size : sizes) {
            System.out.println("\nTesting with " + size + " elements:");
            compareStackPerformance(size);
            compareQueuePerformance(size);
        }
        
        System.out.println("Performance comparison completed.\n");
    }
    
    /**
     * Compare stack implementation performance
     */
    private static void compareStackPerformance(int size) {
        // Test ArrayStack
        Stack<Integer> arrayStack = new ArrayStack<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayStack.push(i);
        }
        for (int i = 0; i < size; i++) {
            arrayStack.pop();
        }
        long arrayTime = System.nanoTime() - startTime;
        
        // Test LinkedStack
        Stack<Integer> linkedStack = new LinkedStack<>();
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedStack.push(i);
        }
        for (int i = 0; i < size; i++) {
            linkedStack.pop();
        }
        long linkedTime = System.nanoTime() - startTime;
        
        // Test Java's built-in Stack (extends Vector)
        java.util.Stack<Integer> javaStack = new java.util.Stack<>();
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            javaStack.push(i);
        }
        for (int i = 0; i < size; i++) {
            javaStack.pop();
        }
        long javaTime = System.nanoTime() - startTime;
        
        System.out.printf("  Stack  - Array: %6.2fms, Linked: %6.2fms, Java: %6.2fms%n",
                         arrayTime / 1_000_000.0, linkedTime / 1_000_000.0, javaTime / 1_000_000.0);
    }
    
    /**
     * Compare queue implementation performance
     */
    private static void compareQueuePerformance(int size) {
        // Test ArrayQueue
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayQueue.enqueue(i);
        }
        for (int i = 0; i < size; i++) {
            arrayQueue.dequeue();
        }
        long arrayTime = System.nanoTime() - startTime;
        
        // Test LinkedQueue
        Queue<Integer> linkedQueue = new LinkedQueue<>();
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedQueue.enqueue(i);
        }
        for (int i = 0; i < size; i++) {
            linkedQueue.dequeue();
        }
        long linkedTime = System.nanoTime() - startTime;
        
        // Test Java's LinkedList as Queue
        LinkedList<Integer> javaQueue = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            javaQueue.offer(i);
        }
        for (int i = 0; i < size; i++) {
            javaQueue.poll();
        }
        long javaTime = System.nanoTime() - startTime;
        
        System.out.printf("  Queue  - Array: %6.2fms, Linked: %6.2fms, Java: %6.2fms%n",
                         arrayTime / 1_000_000.0, linkedTime / 1_000_000.0, javaTime / 1_000_000.0);
    }
    
    // =============================================================================
    // Memory Usage Analysis
    // =============================================================================
    
    /**
     * Analyze memory usage of different implementations
     */
    public static void analyzeMemoryUsage() {
        System.out.println("=== Memory Usage Analysis ===");
        
        final int elements = 1000;
        
        Runtime runtime = Runtime.getRuntime();
        
        // Baseline memory
        runtime.gc();
        long baseline = runtime.totalMemory() - runtime.freeMemory();
        
        // ArrayStack memory usage
        runtime.gc();
        long beforeArray = runtime.totalMemory() - runtime.freeMemory();
        Stack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < elements; i++) {
            arrayStack.push(i);
        }
        runtime.gc();
        long afterArray = runtime.totalMemory() - runtime.freeMemory();
        long arrayMemory = afterArray - beforeArray;
        
        // LinkedStack memory usage
        runtime.gc();
        long beforeLinked = runtime.totalMemory() - runtime.freeMemory();
        Stack<Integer> linkedStack = new LinkedStack<>();
        for (int i = 0; i < elements; i++) {
            linkedStack.push(i);
        }
        runtime.gc();
        long afterLinked = runtime.totalMemory() - runtime.freeMemory();
        long linkedMemory = afterLinked - beforeLinked;
        
        System.out.printf("Memory usage for %d elements:%n", elements);
        System.out.printf("  ArrayStack:  %,d bytes (%.1f bytes per element)%n", 
                         arrayMemory, (double) arrayMemory / elements);
        System.out.printf("  LinkedStack: %,d bytes (%.1f bytes per element)%n", 
                         linkedMemory, (double) linkedMemory / elements);
        System.out.printf("  Ratio: %.1fx more memory for linked implementation%n", 
                         (double) linkedMemory / arrayMemory);
        
        System.out.println("Memory analysis completed.\n");
    }
    
    // =============================================================================
    // Visualization and Debugging Utilities
    // =============================================================================
    
    /**
     * Create sample stacks for demonstration
     */
    public static Stack<String> createSampleStack(String type) {
        Stack<String> stack;
        if ("array".equalsIgnoreCase(type)) {
            stack = new ArrayStack<>();
        } else {
            stack = new LinkedStack<>();
        }
        
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");
        return stack;
    }
    
    /**
     * Create sample queues for demonstration
     */
    public static Queue<String> createSampleQueue(String type) {
        Queue<String> queue;
        if ("array".equalsIgnoreCase(type)) {
            queue = new ArrayQueue<>();
        } else {
            queue = new LinkedQueue<>();
        }
        
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        return queue;
    }
    
    /**
     * Demonstrate stack behavior visually
     */
    public static void demonstrateStackBehavior() {
        System.out.println("=== Stack Behavior Demonstration ===");
        
        Stack<String> stack = new ArrayStack<>();
        
        System.out.println("Starting with empty stack: " + stack);
        
        System.out.println("\nPushing elements (LIFO):");
        String[] items = {"A", "B", "C"};
        for (String item : items) {
            stack.push(item);
            System.out.println("  push(\"" + item + "\") -> " + stack);
        }
        
        System.out.println("\nPopping elements (LIFO):");
        while (!stack.isEmpty()) {
            String popped = stack.pop();
            System.out.println("  pop() -> \"" + popped + "\" | remaining: " + stack);
        }
        
        System.out.println("Stack demonstration completed.\n");
    }
    
    /**
     * Demonstrate queue behavior visually
     */
    public static void demonstrateQueueBehavior() {
        System.out.println("=== Queue Behavior Demonstration ===");
        
        Queue<String> queue = new LinkedQueue<>();
        
        System.out.println("Starting with empty queue: " + queue);
        
        System.out.println("\nEnqueuing elements (FIFO):");
        String[] items = {"A", "B", "C"};
        for (String item : items) {
            queue.enqueue(item);
            System.out.println("  enqueue(\"" + item + "\") -> " + queue);
        }
        
        System.out.println("\nDequeuing elements (FIFO):");
        while (!queue.isEmpty()) {
            String dequeued = queue.dequeue();
            System.out.println("  dequeue() -> \"" + dequeued + "\" | remaining: " + queue);
        }
        
        System.out.println("Queue demonstration completed.\n");
    }
    
    // =============================================================================
    // Utility Methods for Testing
    // =============================================================================
    
    /**
     * Assert that a condition is true
     */
    private static void assertTrue(boolean condition, String message) {
        testsRun++;
        if (condition) {
            testsPassed++;
        } else {
            System.err.println("ASSERTION FAILED: " + message);
            System.err.println("  Expected: true, Actual: false");
        }
    }
    
    /**
     * Assert that a condition is false
     */
    private static void assertFalse(boolean condition, String message) {
        testsRun++;
        if (!condition) {
            testsPassed++;
        } else {
            System.err.println("ASSERTION FAILED: " + message);
            System.err.println("  Expected: false, Actual: true");
        }
    }
    
    /**
     * Assert that two objects are equal
     */
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
    
    /**
     * Fail a test with a message
     */
    private static void fail(String message) {
        testsRun++;
        System.err.println("TEST FAILED: " + message);
    }
    
    /**
     * Print test summary
     */
    private static void printTestSummary() {
        System.out.println("=== Test Summary ===");
        System.out.printf("Tests run: %d%n", testsRun);
        System.out.printf("Tests passed: %d%n", testsPassed);
        System.out.printf("Tests failed: %d%n", testsRun - testsPassed);
        System.out.printf("Success rate: %.1f%%%n", (100.0 * testsPassed) / testsRun);
        
        if (testsPassed == testsRun) {
            System.out.println("🎉 All tests passed!");
        } else {
            System.out.println("❌ Some tests failed. Please check your implementation.");
        }
    }
    
    // =============================================================================
    // Main Method - Test Runner
    // =============================================================================
    
    /**
     * Run all tests and demonstrations
     */
    public static void main(String[] args) {
        System.out.println("CSC 220 Lab 4 - Stack and Queue Implementation Tests");
        System.out.println("====================================================");
        
        try {
            // Reset test counters
            testsRun = 0;
            testsPassed = 0;
            
            // Run all test suites
            testStacks();
            testQueues();
            testApplications();
            
            // Performance analysis
            comparePerformance();
            analyzeMemoryUsage();
            
            // Demonstrations
            demonstrateStackBehavior();
            demonstrateQueueBehavior();
            
            // Print final results
            printTestSummary();
            
            // Additional demonstrations
            System.out.println("\n=== Sample Data Structures ===");
            Stack<String> sampleArrayStack = createSampleStack("array");
            Stack<String> sampleLinkedStack = createSampleStack("linked");
            Queue<String> sampleArrayQueue = createSampleQueue("array");
            Queue<String> sampleLinkedQueue = createSampleQueue("linked");
            
            System.out.println("Sample ArrayStack: " + sampleArrayStack);
            System.out.println("Sample LinkedStack: " + sampleLinkedStack);
            System.out.println("Sample ArrayQueue: " + sampleArrayQueue);
            System.out.println("Sample LinkedQueue: " + sampleLinkedQueue);
            
        } catch (Exception e) {
            System.err.println("UNEXPECTED ERROR during testing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}