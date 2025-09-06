import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * LinkedListTester - Lab 3 Testing Framework
 * 
 * This file provides comprehensive testing utilities for both singly and
 * doubly linked list implementations. It includes unit tests, performance
 * comparisons, and debugging helpers.
 * 
 * @author CSC 220 Teaching Team
 * @version Lab 3 - Fall 2025
 */
public class LinkedListTester {
    
    // =============================================================================
    // Singly Linked List Tests
    // =============================================================================
    
    /**
     * Comprehensive test suite for SinglyLinkedList
     */
    public static void testSinglyLinkedList() {
        System.out.println("=== Singly Linked List Tests ===");
        
        testSinglyBasicOperations();
        testSinglyEdgeCases();
        testSinglyErrorConditions();
        
        System.out.println("Singly linked list tests completed.\n");
    }
    
    /**
     * Test basic operations: add, remove, get, size
     */
    private static void testSinglyBasicOperations() {
        System.out.println("Testing basic operations...");
        
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        
        // Test empty list
        assert list.isEmpty() : "New list should be empty";
        assert list.size() == 0 : "New list size should be 0";
        
        // Test addFirst
        list.addFirst("B");
        list.addFirst("A");
        assert list.size() == 2 : "Size should be 2 after adding 2 elements";
        assert !list.isEmpty() : "List should not be empty";
        assert list.peekFirst().equals("A") : "First element should be A";
        
        // Test addLast
        list.addLast("C");
        list.addLast("D");
        assert list.size() == 4 : "Size should be 4";
        
        // Test get method
        assert list.get(0).equals("A") : "Element at index 0 should be A";
        assert list.get(1).equals("B") : "Element at index 1 should be B";
        assert list.get(2).equals("C") : "Element at index 2 should be C";
        assert list.get(3).equals("D") : "Element at index 3 should be D";
        
        // Test removeFirst
        String removed = list.removeFirst();
        assert removed.equals("A") : "Removed element should be A";
        assert list.size() == 3 : "Size should be 3 after removal";
        assert list.get(0).equals("B") : "New first element should be B";
        
        // Test contains
        assert list.contains("B") : "List should contain B";
        assert list.contains("C") : "List should contain C";
        assert !list.contains("A") : "List should not contain A after removal";
        assert !list.contains("Z") : "List should not contain Z";
        
        System.out.println("✓ Basic operations test passed");
        System.out.println("  Current list: " + list);
    }
    
    /**
     * Test edge cases: single element, empty operations
     */
    private static void testSinglyEdgeCases() {
        System.out.println("Testing edge cases...");
        
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        
        // Test single element operations
        list.addFirst(42);
        assert list.size() == 1 : "Size should be 1";
        assert list.get(0).equals(42) : "Element should be 42";
        
        Integer removed = list.removeFirst();
        assert removed.equals(42) : "Removed element should be 42";
        assert list.isEmpty() : "List should be empty after removing last element";
        
        // Test addLast on empty list
        list.addLast(100);
        assert list.size() == 1 : "Size should be 1";
        assert list.peekFirst().equals(100) : "First element should be 100";
        
        list.removeFirst();
        assert list.isEmpty() : "List should be empty";
        
        System.out.println("✓ Edge cases test passed");
    }
    
    /**
     * Test error conditions and exception handling
     */
    private static void testSinglyErrorConditions() {
        System.out.println("Testing error conditions...");
        
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        
        // Test exceptions on empty list
        try {
            list.removeFirst();
            assert false : "Should throw NoSuchElementException";
        } catch (NoSuchElementException e) {
            // Expected
        }
        
        try {
            list.peekFirst();
            assert false : "Should throw NoSuchElementException";
        } catch (NoSuchElementException e) {
            // Expected
        }
        
        // Test invalid indices
        list.addFirst("A");
        
        try {
            list.get(-1);
            assert false : "Should throw IndexOutOfBoundsException";
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        try {
            list.get(1);
            assert false : "Should throw IndexOutOfBoundsException";
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        System.out.println("✓ Error conditions test passed");
    }
    
    // =============================================================================
    // Doubly Linked List Tests
    // =============================================================================
    
    /**
     * Comprehensive test suite for DoublyLinkedList
     */
    public static void testDoublyLinkedList() {
        System.out.println("=== Doubly Linked List Tests ===");
        
        testDoublyBasicOperations();
        testDoublyBidirectionalOperations();
        testDoublyInsertOperation();
        testDoublyEdgeCases();
        
        System.out.println("Doubly linked list tests completed.\n");
    }
    
    /**
     * Test basic operations for doubly linked list
     */
    private static void testDoublyBasicOperations() {
        System.out.println("Testing doubly linked list basic operations...");
        
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        
        // Test empty list
        assert list.isEmpty() : "New list should be empty";
        assert list.size() == 0 : "New list size should be 0";
        
        // Test addFirst and addLast
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        list.addLast("D");
        
        assert list.size() == 4 : "Size should be 4";
        System.out.println("  List after adds: " + list);
        
        // Test get (should work from both directions)
        assert list.get(0).equals("A") : "Element at index 0 should be A";
        assert list.get(1).equals("B") : "Element at index 1 should be B";
        assert list.get(2).equals("C") : "Element at index 2 should be C";
        assert list.get(3).equals("D") : "Element at index 3 should be D";
        
        // Test removeFirst and removeLast
        String firstRemoved = list.removeFirst();
        String lastRemoved = list.removeLast();
        
        assert firstRemoved.equals("A") : "First removed should be A";
        assert lastRemoved.equals("D") : "Last removed should be D";
        assert list.size() == 2 : "Size should be 2 after removals";
        
        System.out.println("✓ Doubly linked list basic operations passed");
        System.out.println("  List after removals: " + list);
    }
    
    /**
     * Test bidirectional operations
     */
    private static void testDoublyBidirectionalOperations() {
        System.out.println("Testing bidirectional operations...");
        
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        
        // Add elements
        for (int i = 1; i <= 5; i++) {
            list.addLast(i);
        }
        
        System.out.println("  List contents: " + list);
        
        // Test forward and backward printing
        list.printForward();   // Should print: 1 2 3 4 5
        list.printBackward();  // Should print: 5 4 3 2 1
        
        // Test optimized get (from head vs tail)
        assert list.get(0).equals(1) : "First element should be 1";
        assert list.get(4).equals(5) : "Last element should be 5";
        assert list.get(2).equals(3) : "Middle element should be 3";
        
        System.out.println("✓ Bidirectional operations test passed");
    }
    
    /**
     * Test insert operation at various positions
     */
    private static void testDoublyInsertOperation() {
        System.out.println("Testing insert operation...");
        
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        
        // Insert into empty list
        list.insert(0, "B");
        assert list.size() == 1 : "Size should be 1";
        assert list.get(0).equals("B") : "Element should be B";
        
        // Insert at beginning
        list.insert(0, "A");
        assert list.get(0).equals("A") : "First element should be A";
        assert list.get(1).equals("B") : "Second element should be B";
        
        // Insert at end
        list.insert(2, "D");
        assert list.get(2).equals("D") : "Last element should be D";
        
        // Insert in middle
        list.insert(2, "C");
        assert list.size() == 4 : "Size should be 4";
        assert list.get(0).equals("A") : "Element 0 should be A";
        assert list.get(1).equals("B") : "Element 1 should be B";
        assert list.get(2).equals("C") : "Element 2 should be C";
        assert list.get(3).equals("D") : "Element 3 should be D";
        
        System.out.println("✓ Insert operation test passed");
        System.out.println("  Final list: " + list);
    }
    
    /**
     * Test edge cases for doubly linked list
     */
    private static void testDoublyEdgeCases() {
        System.out.println("Testing doubly linked list edge cases...");
        
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        
        // Test single element add/remove cycles
        list.addFirst('X');
        Character removed = list.removeFirst();
        assert removed.equals('X') : "Removed element should be X";
        assert list.isEmpty() : "List should be empty";
        
        list.addLast('Y');
        removed = list.removeLast();
        assert removed.equals('Y') : "Removed element should be Y";
        assert list.isEmpty() : "List should be empty";
        
        // Test error conditions
        try {
            list.removeFirst();
            assert false : "Should throw NoSuchElementException";
        } catch (NoSuchElementException e) {
            // Expected
        }
        
        try {
            list.removeLast();
            assert false : "Should throw NoSuchElementException";
        } catch (NoSuchElementException e) {
            // Expected
        }
        
        try {
            list.insert(-1, 'Z');
            assert false : "Should throw IndexOutOfBoundsException";
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        try {
            list.insert(1, 'Z');
            assert false : "Should throw IndexOutOfBoundsException";
        } catch (IndexOutOfBoundsException e) {
            // Expected
        }
        
        System.out.println("✓ Doubly linked list edge cases passed");
    }
    
    // =============================================================================
    // Performance Comparison Tests
    // =============================================================================
    
    /**
     * Compare performance of different list implementations
     */
    public static void comparePerformance() {
        System.out.println("=== Performance Comparison ===");
        
        final int[] sizes = {1000, 5000, 10000};
        
        for (int size : sizes) {
            System.out.println("\nTesting with " + size + " elements:");
            
            // Test addFirst operations
            compareAddFirstPerformance(size);
            
            // Test addLast operations
            compareAddLastPerformance(size);
            
            // Test random access
            compareRandomAccessPerformance(size);
        }
    }
    
    /**
     * Compare addFirst performance
     */
    private static void compareAddFirstPerformance(int size) {
        // Test SinglyLinkedList addFirst
        SinglyLinkedList<Integer> singlyList = new SinglyLinkedList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            singlyList.addFirst(i);
        }
        long singlyTime = System.nanoTime() - startTime;
        
        // Test DoublyLinkedList addFirst
        DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            doublyList.addFirst(i);
        }
        long doublyTime = System.nanoTime() - startTime;
        
        // Test ArrayList addFirst (add at index 0)
        ArrayList<Integer> arrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(0, i);
        }
        long arrayTime = System.nanoTime() - startTime;
        
        System.out.printf("  AddFirst - Singly: %6.2fms, Doubly: %6.2fms, ArrayList: %6.2fms%n",
                         singlyTime / 1_000_000.0, doublyTime / 1_000_000.0, arrayTime / 1_000_000.0);
    }
    
    /**
     * Compare addLast performance
     */
    private static void compareAddLastPerformance(int size) {
        // Test SinglyLinkedList addLast
        SinglyLinkedList<Integer> singlyList = new SinglyLinkedList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            singlyList.addLast(i);
        }
        long singlyTime = System.nanoTime() - startTime;
        
        // Test DoublyLinkedList addLast
        DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            doublyList.addLast(i);
        }
        long doublyTime = System.nanoTime() - startTime;
        
        // Test ArrayList addLast (add at end)
        ArrayList<Integer> arrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayTime = System.nanoTime() - startTime;
        
        System.out.printf("  AddLast  - Singly: %6.2fms, Doubly: %6.2fms, ArrayList: %6.2fms%n",
                         singlyTime / 1_000_000.0, doublyTime / 1_000_000.0, arrayTime / 1_000_000.0);
    }
    
    /**
     * Compare random access performance
     */
    private static void compareRandomAccessPerformance(int size) {
        // Prepare lists with data
        SinglyLinkedList<Integer> singlyList = new SinglyLinkedList<>();
        DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            singlyList.addLast(i);
            doublyList.addLast(i);
            arrayList.add(i);
        }
        
        // Test random access - get elements at various positions
        int accessCount = Math.min(1000, size / 10);
        
        // Test SinglyLinkedList get
        long startTime = System.nanoTime();
        for (int i = 0; i < accessCount; i++) {
            int index = (i * 7) % size; // Pseudo-random access pattern
            singlyList.get(index);
        }
        long singlyTime = System.nanoTime() - startTime;
        
        // Test DoublyLinkedList get
        startTime = System.nanoTime();
        for (int i = 0; i < accessCount; i++) {
            int index = (i * 7) % size;
            doublyList.get(index);
        }
        long doublyTime = System.nanoTime() - startTime;
        
        // Test ArrayList get
        startTime = System.nanoTime();
        for (int i = 0; i < accessCount; i++) {
            int index = (i * 7) % size;
            arrayList.get(index);
        }
        long arrayTime = System.nanoTime() - startTime;
        
        System.out.printf("  Get(%d)  - Singly: %6.2fms, Doubly: %6.2fms, ArrayList: %6.2fms%n",
                         accessCount, singlyTime / 1_000_000.0, doublyTime / 1_000_000.0, arrayTime / 1_000_000.0);
    }
    
    // =============================================================================
    // Debugging Utilities
    // =============================================================================
    
    /**
     * Helper method to visualize a singly linked list structure
     */
    public static void visualizeSinglyLinkedList(SinglyLinkedList<String> list) {
        System.out.println("Singly Linked List Visualization:");
        System.out.println("Size: " + list.size());
        
        if (list.isEmpty()) {
            System.out.println("head -> null");
            return;
        }
        
        System.out.print("head -> ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i) + "|next] -> ");
        }
        System.out.println("null");
        System.out.println();
    }
    
    /**
     * Create a sample singly linked list for testing
     */
    public static SinglyLinkedList<String> createSampleSinglyList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addLast("Apple");
        list.addLast("Banana");
        list.addLast("Cherry");
        return list;
    }
    
    /**
     * Create a sample doubly linked list for testing
     */
    public static DoublyLinkedList<String> createSampleDoublyList() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("Red");
        list.addLast("Green");
        list.addLast("Blue");
        return list;
    }
    
    // =============================================================================
    // Main Method - Test Runner
    // =============================================================================
    
    /**
     * Run all tests
     */
    public static void main(String[] args) {
        System.out.println("CSC 220 Lab 3 - Linked List Implementation Tests");
        System.out.println("================================================");
        
        try {
            // Enable assertions
            ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
            
            // Run all test suites
            testSinglyLinkedList();
            testDoublyLinkedList();
            comparePerformance();
            
            System.out.println("=== All Tests Completed Successfully! ===");
            
            // Demonstrate visualization
            System.out.println("\n=== Sample Visualizations ===");
            SinglyLinkedList<String> sampleSingly = createSampleSinglyList();
            visualizeSinglyLinkedList(sampleSingly);
            
            DoublyLinkedList<String> sampleDoubly = createSampleDoublyList();
            System.out.println("Doubly Linked List Sample:");
            sampleDoubly.printForward();
            sampleDoubly.printBackward();
            
        } catch (AssertionError e) {
            System.err.println("TEST FAILED: " + e.getMessage());
            System.err.println("\nPlease check your implementation and try again.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("UNEXPECTED ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}