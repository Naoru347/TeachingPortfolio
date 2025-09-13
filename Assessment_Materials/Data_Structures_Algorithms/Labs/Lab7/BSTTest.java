import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Comprehensive unit tests for BST implementation.
 * 
 * This test class covers all major BST operations:
 * - Basic tree operations (construction, size, empty)
 * - Search functionality 
 * - Insertion with various scenarios
 * - Deletion with all three cases
 * - Tree traversals
 * - Utility methods
 * - Edge cases and error conditions
 * 
 * Students should run these tests frequently during development
 * and ensure all tests pass before submission.
 * 
 * @author Student Name
 * @version Lab 7 - BST Implementation
 */
public class BSTTest {
    
    private BST emptyTree;
    private BST singleNodeTree;
    private BST balancedTree;
    private BST degenerateTree;
    
    /**
     * Set up test fixtures before each test method.
     * Creates various tree configurations for testing.
     */
    @BeforeEach
    public void setUp() {
        // Empty tree
        emptyTree = new BST();
        
        // Single node tree
        singleNodeTree = new BST(10);
        
        // Balanced tree: Insert 5, 3, 7, 1, 4, 6, 9
        //       5
        //      / \
        //     3   7
        //    / \ / \
        //   1  4 6  9
        balancedTree = new BST();
        int[] balancedValues = {5, 3, 7, 1, 4, 6, 9};
        for (int value : balancedValues) {
            balancedTree.insert(value);
        }
        
        // Degenerate tree (essentially a linked list): Insert 1, 2, 3, 4, 5
        //   1
        //    \
        //     2
        //      \
        //       3
        //        \
        //         4
        //          \
        //           5
        degenerateTree = new BST();
        int[] degenerateValues = {1, 2, 3, 4, 5};
        for (int value : degenerateValues) {
            degenerateTree.insert(value);
        }
    }
    
    // =====================================================
    // BASIC TREE OPERATION TESTS
    // =====================================================
    
    @Test
    public void testEmptyTreeConstruction() {
        assertNull(emptyTree.getRoot());
        assertEquals(0, emptyTree.size());
        assertTrue(emptyTree.isEmpty());
    }
    
    @Test
    public void testSingleNodeConstruction() {
        assertNotNull(singleNodeTree.getRoot());
        assertEquals(10, singleNodeTree.getRoot().getData());
        assertEquals(1, singleNodeTree.size());
        assertFalse(singleNodeTree.isEmpty());
    }
    
    @Test
    public void testClearOperation() {
        assertFalse(balancedTree.isEmpty());
        balancedTree.clear();
        assertTrue(balancedTree.isEmpty());
        assertEquals(0, balancedTree.size());
        assertNull(balancedTree.getRoot());
    }
    
    // =====================================================
    // SEARCH OPERATION TESTS
    // =====================================================
    
    @Test
    public void testSearchInEmptyTree() {
        assertFalse(emptyTree.search(5));
        assertFalse(emptyTree.search(0));
        assertFalse(emptyTree.search(-1));
    }
    
    @Test
    public void testSearchInSingleNodeTree() {
        assertTrue(singleNodeTree.search(10));
        assertFalse(singleNodeTree.search(5));
        assertFalse(singleNodeTree.search(15));
    }
    
    @Test
    public void testSearchInBalancedTree() {
        // Test finding existing values
        assertTrue(balancedTree.search(5));  // Root
        assertTrue(balancedTree.search(3));  // Left subtree
        assertTrue(balancedTree.search(7));  // Right subtree
        assertTrue(balancedTree.search(1));  // Leaf
        assertTrue(balancedTree.search(9));  // Leaf
        
        // Test searching for non-existing values
        assertFalse(balancedTree.search(0));   // Less than minimum
        assertFalse(balancedTree.search(10));  // Greater than maximum
        assertFalse(balancedTree.search(2));   // Between existing values
        assertFalse(balancedTree.search(8));   // Between existing values
    }
    
    @Test
    public void testSearchInDegenerateTree() {
        for (int i = 1; i <= 5; i++) {
            assertTrue(degenerateTree.search(i));
        }
        assertFalse(degenerateTree.search(0));
        assertFalse(degenerateTree.search(6));
    }
    
    // =====================================================
    // INSERTION OPERATION TESTS
    // =====================================================
    
    @Test
    public void testInsertIntoEmptyTree() {
        emptyTree.insert(42);
        assertFalse(emptyTree.isEmpty());
        assertEquals(1, emptyTree.size());
        assertEquals(42, emptyTree.getRoot().getData());
        assertTrue(emptyTree.search(42));
    }
    
    @Test
    public void testInsertMultipleValues() {
        BST tree = new BST();
        int[] values = {5, 3, 7, 1, 9, 2, 8};
        
        for (int i = 0; i < values.length; i++) {
            tree.insert(values[i]);
            assertEquals(i + 1, tree.size());
            assertTrue(tree.search(values[i]));
        }
    }
    
    @Test
    public void testInsertDuplicateValues() {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(5);  // Duplicate
        tree.insert(3);
        tree.insert(3);  // Duplicate
        
        // TODO: Decide how your BST handles duplicates
        // This test may need to be adjusted based on your implementation
        // Option 1: Allow duplicates (size should be 4)
        // Option 2: Ignore duplicates (size should be 2)
        
        assertTrue(tree.search(5));
        assertTrue(tree.search(3));
        // Uncomment and adjust based on your duplicate handling:
        // assertEquals(expected_size, tree.size());
    }
    
    @Test
    public void testInsertCreatesValidBST() {
        BST tree = new BST();
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        
        for (int value : values) {
            tree.insert(value);
            assertTrue(tree.isValidBST(), "Tree should remain valid BST after inserting " + value);
        }
    }
    
    // =====================================================
    // DELETION OPERATION TESTS
    // =====================================================
    
    @Test
    public void testDeleteFromEmptyTree() {
        assertFalse(emptyTree.delete(5));
        assertEquals(0, emptyTree.size());
    }
    
    @Test
    public void testDeleteFromSingleNodeTree() {
        assertTrue(singleNodeTree.delete(10));
        assertTrue(singleNodeTree.isEmpty());
        assertEquals(0, singleNodeTree.size());
        assertNull(singleNodeTree.getRoot());
        
        assertFalse(singleNodeTree.delete(10));  // Already deleted
    }
    
    @Test
    public void testDeleteLeafNodes() {
        // Delete leaf nodes from balanced tree
        assertTrue(balancedTree.delete(1));  // Left leaf
        assertFalse(balancedTree.search(1));
        assertEquals(6, balancedTree.size());
        assertTrue(balancedTree.isValidBST());
        
        assertTrue(balancedTree.delete(6));  // Right leaf
        assertFalse(balancedTree.search(6));
        assertEquals(5, balancedTree.size());
        assertTrue(balancedTree.isValidBST());
    }
    
    @Test
    public void testDeleteNodeWithOneChild() {
        // Create a tree where we can test single-child deletion
        BST tree = new BST();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);   // 3 will have only left child after this
        tree.insert(8);   // 7 will have only right child
        
        // Delete node with only left child
        assertTrue(tree.delete(3));
        assertFalse(tree.search(3));
        assertTrue(tree.search(1));  // Child should still be there
        assertTrue(tree.isValidBST());
        
        // Delete node with only right child  
        assertTrue(tree.delete(7));
        assertFalse(tree.search(7));
        assertTrue(tree.search(8));  // Child should still be there
        assertTrue(tree.isValidBST());
    }
    
    @Test
    public void testDeleteNodeWithTwoChildren() {
        // Delete root of balanced tree (has two children)
        assertTrue(balancedTree.delete(5));
        assertFalse(balancedTree.search(5));
        assertEquals(6, balancedTree.size());
        assertTrue(balancedTree.isValidBST());
        
        // Verify all other nodes are still present
        int[] remainingValues = {3, 7, 1, 4, 6, 9};
        for (int value : remainingValues) {
            assertTrue(balancedTree.search(value), "Value " + value + " should still be in tree");
        }
    }
    
    @Test
    public void testDeleteNonExistentValue() {
        int originalSize = balancedTree.size();
        assertFalse(balancedTree.delete(42));
        assertEquals(originalSize, balancedTree.size());
        assertTrue(balancedTree.isValidBST());
    }
    
    // =====================================================
    // TRAVERSAL TESTS
    // =====================================================
    
    @Test
    public void testInOrderTraversalEmptyTree() {
        List<Integer> result = emptyTree.inOrderTraversal();
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testInOrderTraversalSingleNode() {
        List<Integer> result = singleNodeTree.inOrderTraversal();
        assertEquals(Arrays.asList(10), result);
    }
    
    @Test
    public void testInOrderTraversalBalancedTree() {
        List<Integer> result = balancedTree.inOrderTraversal();
        List<Integer> expected = Arrays.asList(1, 3, 4, 5, 6, 7, 9);
        assertEquals(expected, result);
        
        // Verify result is sorted (key property of BST in-order traversal)
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i-1) < result.get(i), "In-order traversal should be sorted");
        }
    }
    
    @Test
    public void testPreOrderTraversalBalancedTree() {
        List<Integer> result = balancedTree.preOrderTraversal();
        List<Integer> expected = Arrays.asList(5, 3, 1, 4, 7, 6, 9);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPostOrderTraversalBalancedTree() {
        List<Integer> result = balancedTree.postOrderTraversal();
        List<Integer> expected = Arrays.asList(1, 4, 3, 6, 9, 7, 5);
        assertEquals(expected, result);
    }
    
    @Test
    public void testTraversalConsistency() {
        // All traversals should visit the same number of nodes
        assertEquals(balancedTree.inOrderTraversal().size(), balancedTree.preOrderTraversal().size());
        assertEquals(balancedTree.inOrderTraversal().size(), balancedTree.postOrderTraversal().size());
        assertEquals(balancedTree.inOrderTraversal().size(), balancedTree.size());
    }
    
    // =====================================================
    // UTILITY METHOD TESTS
    // =====================================================
    
    @Test
    public void testHeightCalculation() {
        assertEquals(-1, emptyTree.height());
        assertEquals(0, singleNodeTree.height());
        assertEquals(2, balancedTree.height());
        assertEquals(4, degenerateTree.height());
    }
    
    @Test
    public void testFindMinMax() {
        // Test empty tree
        assertThrows(IllegalStateException.class, () -> emptyTree.findMin());
        assertThrows(IllegalStateException.class, () -> emptyTree.findMax());
        
        // Test single node tree
        assertEquals(10, singleNodeTree.findMin());
        assertEquals(10, singleNodeTree.findMax());
        
        // Test balanced tree
        assertEquals(1, balancedTree.findMin());
        assertEquals(9, balancedTree.findMax());
        
        // Test degenerate tree
        assertEquals(1, degenerateTree.findMin());
        assertEquals(5, degenerateTree.findMax());
    }
    
    @Test
    public void testBSTValidation() {
        assertTrue(emptyTree.isValidBST());
        assertTrue(singleNodeTree.isValidBST());
        assertTrue(balancedTree.isValidBST());
        assertTrue(degenerateTree.isValidBST());
        
        // TODO: Create an invalid BST manually to test validation
        // This requires accessing internal structure, which may not be possible
        // depending on your implementation approach
    }
    
    @Test
    public void testToString() {
        assertEquals("[]", emptyTree.toString());
        assertEquals("[10]", singleNodeTree.toString());
        assertEquals("[1, 3, 4, 5, 6, 7, 9]", balancedTree.toString());
    }
    
    // =====================================================
    // INTEGRATION TESTS
    // =====================================================
    
    @Test
    public void testComplexOperationSequence() {
        BST tree = new BST();
        
        // Insert sequence
        int[] insertValues = {15, 10, 20, 8, 12, 25, 6, 11, 13, 22, 27};
        for (int value : insertValues) {
            tree.insert(value);
        }
        assertEquals(insertValues.length, tree.size());
        assertTrue(tree.isValidBST());
        
        // Search sequence
        for (int value : insertValues) {
            assertTrue(tree.search(value));
        }
        assertFalse(tree.search(999));
        
        // Delete sequence (test different cases)
        assertTrue(tree.delete(6));   // Leaf node
        assertTrue(tree.delete(25));  // Node with one child
        assertTrue(tree.delete(10));  // Node with two children
        assertTrue(tree.delete(15));  // Root node with two children
        
        assertEquals(insertValues.length - 4, tree.size());
        assertTrue(tree.isValidBST());
        
        // Verify deleted values are gone
        assertFalse(tree.search(6));
        assertFalse(tree.search(25));
        assertFalse(tree.search(10));
        assertFalse(tree.search(15));
        
        // Verify remaining values are still there
        int[] remainingValues = {8, 12, 20, 11, 13, 22, 27};
        for (int value : remainingValues) {
            assertTrue(tree.search(value));
        }
    }
    
    @Test
    public void testRandomOperations() {
        BST tree = new BST();
        
        // Insert random values
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        for (int value : values) {
            tree.insert(value);
        }
        
        // Verify structure
        assertTrue(tree.isValidBST());
        assertEquals(values.length, tree.size());
        
        // Test that in-order traversal is sorted
        List<Integer> inOrder = tree.inOrderTraversal();
        for (int i = 1; i < inOrder.size(); i++) {
            assertTrue(inOrder.get(i-1) < inOrder.get(i));
        }
        
        // Delete half the values
        tree.delete(10);
        tree.delete(30);
        tree.delete(50);
        tree.delete(70);
        tree.delete(80);
        
        assertTrue(tree.isValidBST());
        assertEquals(values.length - 5, tree.size());
        
        // Verify in-order is still sorted
        inOrder = tree.inOrderTraversal();
        for (int i = 1; i < inOrder.size(); i++) {
            assertTrue(inOrder.get(i-1) < inOrder.get(i));
        }
    }
    
    // =====================================================
    // EDGE CASE TESTS
    // =====================================================
    
    @Test
    public void testLargeValues() {
        BST tree = new BST();
        
        // Test with large integer values
        int[] largeValues = {Integer.MAX_VALUE, Integer.MIN_VALUE, 1000000, -1000000, 0};
        for (int value : largeValues) {
            tree.insert(value);
        }
        
        for (int value : largeValues) {
            assertTrue(tree.search(value));
        }
        
        assertTrue(tree.isValidBST());
        assertEquals(Integer.MIN_VALUE, tree.findMin());
        assertEquals(Integer.MAX_VALUE, tree.findMax());
    }
    
    @Test
    public void testRepeatedOperations() {
        BST tree = new BST();
        
        // Insert, delete, insert same value multiple times
        tree.insert(42);
        assertTrue(tree.search(42));
        
        assertTrue(tree.delete(42));
        assertFalse(tree.search(42));
        
        tree.insert(42);
        assertTrue(tree.search(42));
        
        assertTrue(tree.delete(42));
        assertFalse(tree.search(42));
        
        // Tree should be empty now
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }
    
    @Test
    public void testDegenerateTreePerformance() {
        // This test doesn't assert performance, but helps visualize degenerate behavior
        BST tree = new BST();
        
        // Create worst-case scenario (sorted insertion)
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }
        
        // Tree should still be valid BST, just unbalanced
        assertTrue(tree.isValidBST());
        assertEquals(10, tree.size());
        assertEquals(9, tree.height());  // Height should be n-1 for degenerate tree
        
        // All values should still be searchable
        for (int i = 1; i <= 10; i++) {
            assertTrue(tree.search(i));
        }
    }
    
    // =====================================================
    // STRESS TESTS (Optional - for thorough testing)
    // =====================================================
    
    @Test
    public void testManyInsertionsAndDeletions() {
        BST tree = new BST();
        final int NUM_OPERATIONS = 100;
        
        // Insert many values
        for (int i = 0; i < NUM_OPERATIONS; i++) {
            tree.insert(i);
        }
        assertEquals(NUM_OPERATIONS, tree.size());
        assertTrue(tree.isValidBST());
        
        // Delete every other value
        for (int i = 0; i < NUM_OPERATIONS; i += 2) {
            assertTrue(tree.delete(i));
        }
        assertEquals(NUM_OPERATIONS / 2, tree.size());
        assertTrue(tree.isValidBST());
        
        // Verify remaining values
        for (int i = 1; i < NUM_OPERATIONS; i += 2) {
            assertTrue(tree.search(i));
        }
        for (int i = 0; i < NUM_OPERATIONS; i += 2) {
            assertFalse(tree.search(i));
        }
    }
    
    // =====================================================
    // HELPER METHODS FOR TESTING
    // =====================================================
    
    /**
     * Helper method to verify that a list is sorted in ascending order.
     * 
     * @param list the list to check
     * @return true if list is sorted, false otherwise
     */
    private boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Helper method to create a tree with specific structure for testing.
     * Use this if you need to test specific tree configurations.
     * 
     * @param values array of values to insert in order
     * @return BST with the values inserted
     */
    private BST createTreeFromArray(int[] values) {
        BST tree = new BST();
        for (int value : values) {
            tree.insert(value);
        }
        return tree;
    }
}