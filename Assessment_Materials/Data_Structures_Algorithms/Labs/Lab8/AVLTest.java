import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/**
 * Comprehensive unit tests for AVL Tree implementation.
 * 
 * This test class covers:
 * - Basic tree operations
 * - All four rotation types
 * - AVL property maintenance during insertions and deletions
 * - Balance factor calculations
 * - Height management
 * - Edge cases and error conditions
 * - Performance characteristics
 * 
 * @author Student Name
 * @version Lab 8 - AVL Tree Implementation
 */
public class AVLTest {
    
    private AVLTree emptyTree;
    private AVLTree singleNodeTree;
    private AVLTree balancedTree;
    
    /**
     * Set up test fixtures before each test method.
     */
    @BeforeEach
    public void setUp() {
        // Empty tree
        emptyTree = new AVLTree();
        
        // Single node tree
        singleNodeTree = new AVLTree(10);
        
        // Balanced tree with multiple nodes
        balancedTree = new AVLTree();
        int[] values = {50, 25, 75, 15, 35, 60, 85};
        for (int value : values) {
            balancedTree.insert(value);
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
        assertEquals(-1, emptyTree.height());
        assertTrue(emptyTree.isValidAVL());
    }
    
    @Test
    public void testSingleNodeConstruction() {
        assertNotNull(singleNodeTree.getRoot());
        assertEquals(10, singleNodeTree.getRoot().getData());
        assertEquals(1, singleNodeTree.size());
        assertFalse(singleNodeTree.isEmpty());
        assertEquals(0, singleNodeTree.height());
        assertTrue(singleNodeTree.isValidAVL());
        assertEquals(0, singleNodeTree.getRootBalanceFactor());
    }
    
    @Test
    public void testClearOperation() {
        assertFalse(balancedTree.isEmpty());
        balancedTree.clear();
        assertTrue(balancedTree.isEmpty());
        assertEquals(0, balancedTree.size());
        assertNull(balancedTree.getRoot());
        assertTrue(balancedTree.isValidAVL());
    }
    
    // =====================================================
    // AVL NODE TESTS
    // =====================================================
    
    @Test
    public void testAVLNodeHeightCalculation() {
        AVLNode leaf = new AVLNode(5);
        assertEquals(0, leaf.getHeight());
        assertEquals(0, leaf.getBalanceFactor());
        assertTrue(leaf.isBalanced());
        
        AVLNode parent = new AVLNode(10);
        parent.setLeft(leaf);
        parent.updateHeight();
        assertEquals(1, parent.getHeight());
        assertEquals(1, parent.getBalanceFactor());
        assertTrue(parent.isBalanced());
    }
    
    @Test
    public void testAVLNodeBalanceFactorCalculation() {
        AVLNode root = new AVLNode(10);
        
        // Left heavy scenario
        root.left = new AVLNode(5);
        root.left.left = new AVLNode(3);
        root.updateHeight();
        assertEquals(2, root.getBalanceFactor());
        assertTrue(root.isLeftHeavy());
        assertFalse(root.isBalanced());
        
        // Right heavy scenario
        root.left = null;
        root.right = new AVLNode(15);
        root.right.right = new AVLNode(20);
        root.updateHeight();
        assertEquals(-2, root.getBalanceFactor());
        assertTrue(root.isRightHeavy());
        assertFalse(root.isBalanced());
    }
    
    @Test
    public void testAVLNodeValidation() {
        AVLNode validNode = new AVLNode(10);
        validNode.left = new AVLNode(5);
        validNode.right = new AVLNode(15);
        validNode.updateHeight();
        
        assertTrue(validNode.isValidAVL());
        assertTrue(validNode.isBalanced());
        assertEquals(0, validNode.getBalanceFactor());
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
        assertTrue(balancedTree.search(50));  // Root
        assertTrue(balancedTree.search(25));  // Left subtree
        assertTrue(balancedTree.search(75));  // Right subtree
        assertTrue(balancedTree.search(15));  // Leaf
        assertTrue(balancedTree.search(85));  // Leaf
        
        // Test searching for non-existing values
        assertFalse(balancedTree.search(0));
        assertFalse(balancedTree.search(100));
        assertFalse(balancedTree.search(30));
    }
    
    // =====================================================
    // SINGLE ROTATION TESTS
    // =====================================================
    
    @Test
    public void testRightRotationScenario() {
        AVLTree tree = new AVLTree();
        
        // Insert values that will cause left-left imbalance
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);  // This should trigger right rotation
        
        // Verify tree structure after rotation
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
        
        // Root should now be 20
        assertEquals(20, tree.getRoot().getData());
        assertEquals(10, tree.getRoot().getLeft().getData());
        assertEquals(30, tree.getRoot().getRight().getData());
        
        // Verify heights
        assertEquals(1, tree.height());
        assertEquals(0, tree.getRootBalanceFactor());
    }
    
    @Test
    public void testLeftRotationScenario() {
        AVLTree tree = new AVLTree();
        
        // Insert values that will cause right-right imbalance
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);  // This should trigger left rotation
        
        // Verify tree structure after rotation
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
        
        // Root should now be 20
        assertEquals(20, tree.getRoot().getData());
        assertEquals(10, tree.getRoot().getLeft().getData());
        assertEquals(30, tree.getRoot().getRight().getData());
        
        // Verify heights
        assertEquals(1, tree.height());
        assertEquals(0, tree.getRootBalanceFactor());
    }
    
    // =====================================================
    // DOUBLE ROTATION TESTS
    // =====================================================
    
    @Test
    public void testLeftRightRotationScenario() {
        AVLTree tree = new AVLTree();
        
        // Insert values that will cause left-right imbalance
        tree.insert(30);
        tree.insert(10);
        tree.insert(20);  // This should trigger left-right rotation
        
        // Verify tree structure after rotation
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
        
        // Root should now be 20
        assertEquals(20, tree.getRoot().getData());
        assertEquals(10, tree.getRoot().getLeft().getData());
        assertEquals(30, tree.getRoot().getRight().getData());
        
        // Verify heights
        assertEquals(1, tree.height());
        assertEquals(0, tree.getRootBalanceFactor());
    }
    
    @Test
    public void testRightLeftRotationScenario() {
        AVLTree tree = new AVLTree();
        
        // Insert values that will cause right-left imbalance
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);  // This should trigger right-left rotation
        
        // Verify tree structure after rotation
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
        
        // Root should now be 20
        assertEquals(20, tree.getRoot().getData());
        assertEquals(10, tree.getRoot().getLeft().getData());
        assertEquals(30, tree.getRoot().getRight().getData());
        
        // Verify heights
        assertEquals(1, tree.height());
        assertEquals(0, tree.getRootBalanceFactor());
    }
    
    // =====================================================
    // COMPLEX ROTATION TESTS
    // =====================================================
    
    @Test
    public void testSequentialInsertionWithRotations() {
        AVLTree tree = new AVLTree();
        
        // Insert sequential values (worst case for regular BST)
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        for (int value : values) {
            tree.insert(value);
            assertTrue(tree.isValidAVL(), "Tree should remain valid AVL after inserting " + value);
            assertTrue(tree.isBalanced(), "Tree should remain balanced after inserting " + value);
        }
        
        // Tree should be much more balanced than a regular BST
        int maxHeight = (int) Math.ceil(Math.log(values.length + 1) / Math.log(2)) + 1;
        assertTrue(tree.height() <= maxHeight, "AVL tree height should be logarithmic");
        
        // All values should still be searchable
        for (int value : values) {
            assertTrue(tree.search(value));
        }
        
        // In-order traversal should give sorted result
        List<Integer> inOrder = tree.inOrderTraversal();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), inOrder);
    }
    
    @Test
    public void testMultipleRotationsInSameTree() {
        AVLTree tree = new AVLTree();
        
        // Insert values that will trigger different types of rotations
        int[] values = {50, 25, 75, 10, 30, 60, 80, 5, 15, 27, 35};
        for (int value : values) {
            tree.insert(value);
            assertTrue(tree.isValidAVL());
            assertTrue(tree.isBalanced());
        }
        
        assertEquals(values.length, tree.size());
        
        // Verify all values are present
        for (int value : values) {
            assertTrue(tree.search(value));
        }
    }
    
    // =====================================================
    // INSERTION TESTS
    // =====================================================
    
    @Test
    public void testInsertIntoEmptyTree() {
        emptyTree.insert(42);
        assertFalse(emptyTree.isEmpty());
        assertEquals(1, emptyTree.size());
        assertEquals(42, emptyTree.getRoot().getData());
        assertTrue(emptyTree.search(42));
        assertTrue(emptyTree.isValidAVL());
        assertEquals(0, emptyTree.height());
    }
    
    @Test
    public void testInsertDuplicateValues() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(10);  // Duplicate
        tree.insert(5);
        tree.insert(5);   // Duplicate
        
        assertTrue(tree.isValidAVL());
        assertTrue(tree.search(10));
        assertTrue(tree.search(5));
        
        // Size depends on how duplicates are handled
        // Adjust this test based on your duplicate handling policy
        assertTrue(tree.size() >= 2);  // At least the unique values
    }
    
    @Test
    public void testInsertMaintainsAVLProperty() {
        AVLTree tree = new AVLTree();
        
        // Insert random values and verify AVL property is always maintained
        int[] values = {15, 10, 20, 8, 12, 25, 6, 11, 13, 22, 27};
        for (int value : values) {
            tree.insert(value);
            assertTrue(tree.isValidAVL(), "AVL property violated after inserting " + value);
            assertTrue(tree.isBalanced(), "Tree became unbalanced after inserting " + value);
            
            // Verify height constraint: height ≤ 1.44 * log₂(n+2) - 2
            int n = tree.size();
            int maxAVLHeight = (int) Math.ceil(1.44 * Math.log(n + 2) / Math.log(2) - 2);
            assertTrue(tree.height() <= maxAVLHeight, "Height exceeds AVL bounds");
        }
    }
    
    // =====================================================
    // DELETION TESTS
    // =====================================================
    
    @Test
    public void testDeleteFromEmptyTree() {
        assertFalse(emptyTree.delete(5));
        assertEquals(0, emptyTree.size());
        assertTrue(emptyTree.isValidAVL());
    }
    
    @Test
    public void testDeleteFromSingleNodeTree() {
        assertTrue(singleNodeTree.delete(10));
        assertTrue(singleNodeTree.isEmpty());
        assertEquals(0, singleNodeTree.size());
        assertNull(singleNodeTree.getRoot());
        assertTrue(singleNodeTree.isValidAVL());
        
        assertFalse(singleNodeTree.delete(10));  // Already deleted
    }
    
    @Test
    public void testDeleteLeafNodes() {
        // Delete leaf nodes from balanced tree
        assertTrue(balancedTree.delete(15));
        assertFalse(balancedTree.search(15));
        assertTrue(balancedTree.isValidAVL());
        assertTrue(balancedTree.isBalanced());
        
        assertTrue(balancedTree.delete(85));
        assertFalse(balancedTree.search(85));
        assertTrue(balancedTree.isValidAVL());
        assertTrue(balancedTree.isBalanced());
    }
    
    @Test
    public void testDeleteWithRebalancing() {
        AVLTree tree = new AVLTree();
        
        // Create a tree that will need rebalancing after deletion
        int[] values = {50, 25, 75, 10, 30, 60, 80, 5, 15, 27, 35, 55, 65, 77, 85};
        for (int value : values) {
            tree.insert(value);
        }
        
        // Delete nodes that should trigger rebalancing
        assertTrue(tree.delete(5));   // May cause rebalancing
        assertTrue(tree.delete(10));  // May cause rebalancing
        assertTrue(tree.delete(15));  // May cause rebalancing
        
        // Tree should still be valid and balanced
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
        
        // Remaining values should still be searchable
        int[] remaining = {50, 25, 75, 30, 60, 80, 27, 35, 55, 65, 77, 85};
        for (int value : remaining) {
            assertTrue(tree.search(value), "Value " + value + " should still be in tree");
        }
    }
    
    @Test
    public void testDeleteRootWithTwoChildren() {
        assertTrue(balancedTree.delete(50));  // Delete root
        assertFalse(balancedTree.search(50));
        assertTrue(balancedTree.isValidAVL());
        assertTrue(balancedTree.isBalanced());
        
        // Verify all other values are still present
        int[] remainingValues = {25, 75, 15, 35, 60, 85};
        for (int value : remainingValues) {
            assertTrue(balancedTree.search(value));
        }
    }
    
    // =====================================================
    // TRAVERSAL TESTS
    // =====================================================
    
    @Test
    public void testInOrderTraversalEmpty() {
        List<Integer> result = emptyTree.inOrderTraversal();
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testInOrderTraversalSingleNode() {
        List<Integer> result = singleNodeTree.inOrderTraversal();
        assertEquals(Arrays.asList(10), result);
    }
    
    @Test
    public void testInOrderTraversalBalanced() {
        List<Integer> result = balancedTree.inOrderTraversal();
        
        // Should be sorted
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i-1) < result.get(i), "In-order traversal should be sorted");
        }
        
        // Should contain all inserted values
        List<Integer> expected = Arrays.asList(15, 25, 35, 50, 60, 75, 85);
        assertEquals(expected, result);
    }
    
    @Test
    public void testAllTraversalConsistency() {
        List<Integer> inOrder = balancedTree.inOrderTraversal();
        List<Integer> preOrder = balancedTree.preOrderTraversal();
        List<Integer> postOrder = balancedTree.postOrderTraversal();
        
        // All should have same number of elements
        assertEquals(inOrder.size(), preOrder.size());
        assertEquals(inOrder.size(), postOrder.size());
        assertEquals(inOrder.size(), balancedTree.size());
        
        // All should contain same elements (just different order)
        assertTrue(inOrder.containsAll(preOrder));
        assertTrue(inOrder.containsAll(postOrder));
    }
    
    // =====================================================
    // UTILITY METHOD TESTS
    // =====================================================
    
    @Test
    public void testFindMinMax() {
        // Test empty tree
        assertThrows(IllegalStateException.class, () -> emptyTree.findMin());
        assertThrows(IllegalStateException.class, () -> emptyTree.findMax());
        
        // Test single node tree
        assertEquals(10, singleNodeTree.findMin());
        assertEquals(10, singleNodeTree.findMax());
        
        // Test balanced tree
        assertEquals(15, balancedTree.findMin());
        assertEquals(85, balancedTree.findMax());
    }
    
    @Test
    public void testTreeStatistics() {
        String stats = balancedTree.getTreeStats();
        assertTrue(stats.contains("Size: 7"));
        assertTrue(stats.contains("Is valid AVL: true"));
        assertTrue(stats.contains("Is balanced: true"));
    }
    
    @Test
    public void testToString() {
        assertEquals("[]", emptyTree.toString());
        assertEquals("[10]", singleNodeTree.toString());
        
        String balancedStr = balancedTree.toString();
        assertTrue(balancedStr.contains("15"));
        assertTrue(balancedStr.contains("85"));
    }
    
    // =====================================================
    // PERFORMANCE AND STRESS TESTS
    // =====================================================
    
    @Test
    public void testLargeSequentialInsertion() {
        AVLTree tree = new AVLTree();
        final int NUM_ELEMENTS = 1000;
        
        // Insert sequential numbers (worst case for regular BST)
        for (int i = 1; i <= NUM_ELEMENTS; i++) {
            tree.insert(i);
            if (i % 100 == 0) {  // Check periodically to avoid slow tests
                assertTrue(tree.isValidAVL());
                assertTrue(tree.isBalanced());
            }
        }
        
        assertEquals(NUM_ELEMENTS, tree.size());
        
        // Height should be logarithmic
        int maxHeight = (int) Math.ceil(1.44 * Math.log(NUM_ELEMENTS + 2) / Math.log(2));
        assertTrue(tree.height() <= maxHeight, 
                  "Height " + tree.height() + " should be ≤ " + maxHeight);
        
        // All elements should be searchable
        for (int i = 1; i <= NUM_ELEMENTS; i += 50) {  // Sample check
            assertTrue(tree.search(i));
        }
    }
    
    @Test
    public void testRandomInsertionAndDeletion() {
        AVLTree tree = new AVLTree();
        
        // Insert random values
        int[] values = {50, 17, 76, 9, 23, 54, 14, 19, 72, 67};
        for (int value : values) {
            tree.insert(value);
            assertTrue(tree.isValidAVL());
        }
        
        // Delete some values
        tree.delete(9);
        tree.delete(76);
        tree.delete(50);
        
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
        assertEquals(values.length - 3, tree.size());
        
        // Remaining values should be searchable
        assertTrue(tree.search(17));
        assertTrue(tree.search(23));
        assertTrue(tree.search(54));
        
        // Deleted values should not be found
        assertFalse(tree.search(9));
        assertFalse(tree.search(76));
        assertFalse(tree.search(50));
    }
    
    @Test
    public void testHeightConstraintMaintenance() {
        AVLTree tree = new AVLTree();
        
        // Insert values that would create deep tree in regular BST
        int[] values = new int[63];  // Will create height 6 tree
        for (int i = 0; i < values.length; i++) {
            values[i] = i + 1;
        }
        
        for (int value : values) {
            tree.insert(value);
        }
        
        // AVL tree height should be much smaller than linear
        assertTrue(tree.height() <= 10, "AVL height should be logarithmic");
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
        assertEquals(values.length, tree.size());
    }
    
    // =====================================================
    // EDGE CASE TESTS
    // =====================================================
    
    @Test
    public void testRotationOnRoot() {
        AVLTree tree = new AVLTree();
        
        // Force rotation at root level
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);  // Should trigger rotation
        
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
        
        // Root should have changed due to rotation
        assertTrue(tree.getRoot().getData() != 2);  // Original root
    }
    
    @Test
    public void testComplexRotationScenarios() {
        AVLTree tree = new AVLTree();
        
        // Insert pattern that requires multiple different rotations
        int[] pattern1 = {10, 5, 15, 2, 7, 12, 18, 1, 3, 6, 8};
        for (int value : pattern1) {
            tree.insert(value);
            assertTrue(tree.isValidAVL());
        }
        
        // Delete pattern that requires rebalancing
        tree.delete(1);
        tree.delete(3);
        tree.delete(18);
        
        assertTrue(tree.isValidAVL());
        assertTrue(tree.isBalanced());
    }
    
    @Test
    public void testLargeValueRange() {
        AVLTree tree = new AVLTree();
        
        // Test with extreme values
        int[] extremeValues = {
            Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 
            1000000, -1000000, 42, -42
        };
        
        for (int value : extremeValues) {
            tree.insert(value);
            assertTrue(tree.isValidAVL());
        }
        
        for (int value : extremeValues) {
            assertTrue(tree.search(value));
        }
        
        assertEquals(Integer.MIN_VALUE, tree.findMin());
        assertEquals(Integer.MAX_VALUE, tree.findMax());
    }
}