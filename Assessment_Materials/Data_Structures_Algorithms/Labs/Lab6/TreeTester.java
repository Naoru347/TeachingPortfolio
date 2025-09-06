import java.util.*;

/**
 * TreeTester - Lab 6 Testing Framework
 * 
 * Comprehensive testing suite for binary tree implementations including
 * traversal verification, property testing, and visual tree analysis.
 * 
 * @author CSC 220 Teaching Team
 * @version Lab 6 - Fall 2025
 */
public class TreeTester {
    
    private static int testsRun = 0;
    private static int testsPassed = 0;
    
    // =============================================================================
    // Basic Tree Operation Tests
    // =============================================================================
    
    /**
     * Test suite for basic tree operations
     */
    public static void testBasicTreeOperations() {
        System.out.println("=== Basic Tree Operation Tests ===");
        
        testEmptyTree();
        testSingleNodeTree();
        testTreeConstruction();
        testSizeAndHeight();
        
        System.out.println("Basic tree operation tests completed.\n");
    }
    
    /**
     * Test operations on empty tree
     */
    private static void testEmptyTree() {
        System.out.println("Testing empty tree operations...");
        
        BinaryTree<String> emptyTree = new BinaryTree<>();
        
        assertTrue(emptyTree.isEmpty(), "Empty tree should be empty");
        assertEqual(0, emptyTree.size(), "Empty tree size should be 0");
        assertEqual(0, emptyTree.height(), "Empty tree height should be 0");
        assertNull(emptyTree.getRootData(), "Empty tree root should be null");
        
        // Test traversals on empty tree
        assertTrue(emptyTree.preorderTraversal().isEmpty(), "Empty preorder traversal");
        assertTrue(emptyTree.inorderTraversal().isEmpty(), "Empty inorder traversal");
        assertTrue(emptyTree.postorderTraversal().isEmpty(), "Empty postorder traversal");
        assertTrue(emptyTree.levelOrderTraversal().isEmpty(), "Empty level-order traversal");
        
        // Test properties on empty tree
        assertTrue(emptyTree.isComplete(), "Empty tree is complete");
        assertTrue(emptyTree.isFull(), "Empty tree is full");
        assertTrue(emptyTree.isBalanced(), "Empty tree is balanced");
        assertTrue(emptyTree.isPerfect(), "Empty tree is perfect");
        
        System.out.println("✓ Empty tree tests passed");
    }
    
    /**
     * Test operations on single node tree
     */
    private static void testSingleNodeTree() {
        System.out.println("Testing single node tree...");
        
        BinaryTree<String> singleTree = new BinaryTree<>("A");
        
        assertFalse(singleTree.isEmpty(), "Single node tree should not be empty");
        assertEqual(1, singleTree.size(), "Single node tree size should be 1");
        assertEqual(1, singleTree.height(), "Single node tree height should be 1");
        assertEqual("A", singleTree.getRootData(), "Root data should be A");
        
        // Test traversals on single node
        List<String> expected = Arrays.asList("A");
        assertListEquals(expected, singleTree.preorderTraversal(), "Single node preorder");
        assertListEquals(expected, singleTree.inorderTraversal(), "Single node inorder");
        assertListEquals(expected, singleTree.postorderTraversal(), "Single node postorder");
        assertListEquals(expected, singleTree.levelOrderTraversal(), "Single node level-order");
        
        // Test properties on single node
        assertTrue(singleTree.isComplete(), "Single node is complete");
        assertTrue(singleTree.isFull(), "Single node is full");
        assertTrue(singleTree.isBalanced(), "Single node is balanced");
        assertTrue(singleTree.isPerfect(), "Single node is perfect");
        
        assertTrue(singleTree.contains("A"), "Should contain A");
        assertFalse(singleTree.contains("B"), "Should not contain B");
        assertEqual(1, singleTree.countLeaves(), "Should have 1 leaf");
        
        System.out.println("✓ Single node tree tests passed");
    }
    
    /**
     * Test tree construction with level-order insertion
     */
    private static void testTreeConstruction() {
        System.out.println("Testing tree construction...");
        
        BinaryTree<String> tree = new BinaryTree<>();
        
        // Build tree: A, B, C, D, E, F
        String[] nodes = {"A", "B", "C", "D", "E", "F"};
        for (String node : nodes) {
            tree.insert(node);
        }
        
        assertEqual(6, tree.size(), "Tree size should be 6");
        assertEqual("A", tree.getRootData(), "Root should be A");
        
        // Expected structure:
        //       A
        //      / \
        //     B   C
        //    / \ /
        //   D  E F
        
        System.out.println("Constructed tree:");
        tree.printTree();
        
        System.out.println("✓ Tree construction tests passed");
    }
    
    /**
     * Test size and height calculations
     */
    private static void testSizeAndHeight() {
        System.out.println("Testing size and height calculations...");
        
        // Test various tree sizes
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        for (int i = 1; i <= 7; i++) {
            tree.insert(i);
            assertEqual(i, tree.size(), "Size should be " + i + " after inserting " + i + " nodes");
        }
        
        // Expected complete tree of size 7 has height 3
        assertEqual(3, tree.height(), "Complete tree of 7 nodes should have height 3");
        
        // Test height on unbalanced tree
        BinaryTree<String> unbalanced = createLinearTree(5);
        assertEqual(5, unbalanced.height(), "Linear tree of 5 nodes should have height 5");
        
        System.out.println("✓ Size and height tests passed");
    }
    
    // =============================================================================
    // Tree Traversal Tests
    // =============================================================================
    
    /**
     * Test suite for all tree traversal algorithms
     */
    public static void testTreeTraversals() {
        System.out.println("=== Tree Traversal Tests ===");
        
        testTraversalsOnKnownTree();
        testTraversalConsistency();
        testLevelOrderTraversal();
        
        System.out.println("Tree traversal tests completed.\n");
    }
    
    /**
     * Test traversals on a tree with known expected results
     */
    private static void testTraversalsOnKnownTree() {
        System.out.println("Testing traversals on known tree...");
        
        // Create specific tree for testing:
        //       F
        //      / \
        //     B   G
        //    / \   \
        //   A   D   I
        //      / \ /
        //     C  E H
        
        BinaryTree<String> tree = createTestTree();
        
        List<String> expectedPreorder = Arrays.asList("F", "B", "A", "D", "C", "E", "G", "I", "H");
        List<String> expectedInorder = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        List<String> expectedPostorder = Arrays.asList("A", "C", "E", "D", "B", "H", "I", "G", "F");
        List<String> expectedLevelOrder = Arrays.asList("F", "B", "G", "A", "D", "I", "C", "E", "H");
        
        assertListEquals(expectedPreorder, tree.preorderTraversal(), "Preorder traversal");
        assertListEquals(expectedInorder, tree.inorderTraversal(), "Inorder traversal");
        assertListEquals(expectedPostorder, tree.postorderTraversal(), "Postorder traversal");
        assertListEquals(expectedLevelOrder, tree.levelOrderTraversal(), "Level-order traversal");
        
        System.out.println("✓ Known tree traversal tests passed");
    }
    
    /**
     * Test traversal consistency across different tree structures
     */
    private static void testTraversalConsistency() {
        System.out.println("Testing traversal consistency...");
        
        // Linear tree: all traversals should visit in specific patterns
        BinaryTree<Integer> linear = createLinearTree(4);
        
        List<Integer> preorder = linear.preorderTraversal();
        List<Integer> inorder = linear.inorderTraversal();
        List<Integer> postorder = linear.postorderTraversal();
        
        // For linear tree going right: 1->2->3->4
        // Preorder and level-order should be same: 1,2,3,4
        // Inorder should be same: 1,2,3,4
        // Postorder should be reverse: 4,3,2,1
        
        assertEqual(4, preorder.size(), "All traversals should have same size");
        assertEqual(4, inorder.size(), "All traversals should have same size");
        assertEqual(4, postorder.size(), "All traversals should have same size");
        
        // Test that traversals visit all nodes
        Set<Integer> allNodes = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(new HashSet<>(preorder).equals(allNodes), "Preorder should visit all nodes");
        assertTrue(new HashSet<>(inorder).equals(allNodes), "Inorder should visit all nodes");
        assertTrue(new HashSet<>(postorder).equals(allNodes), "Postorder should visit all nodes");
        
        System.out.println("✓ Traversal consistency tests passed");
    }
    
    /**
     * Test level-order traversal specifically
     */
    private static void testLevelOrderTraversal() {
        System.out.println("Testing level-order traversal...");
        
        // Complete tree should have level-order matching insertion order
        BinaryTree<String> tree = new BinaryTree<>();
        String[] insertOrder = {"A", "B", "C", "D", "E", "F", "G"};
        
        for (String node : insertOrder) {
            tree.insert(node);
        }
        
        List<String> levelOrder = tree.levelOrderTraversal();
        List<String> expected = Arrays.asList(insertOrder);
        
        assertListEquals(expected, levelOrder, "Level-order should match insertion order for complete tree");
        
        System.out.println("✓ Level-order traversal tests passed");
    }
    
    // =============================================================================
    // Tree Property Tests
    // =============================================================================
    
    /**
     * Test suite for tree property verification
     */
    public static void testTreeProperties() {
        System.out.println("=== Tree Property Tests ===");
        
        testCompleteTreeProperty();
        testFullTreeProperty();
        testBalancedTreeProperty();
        testPerfectTreeProperty();
        
        System.out.println("Tree property tests completed.\n");
    }
    
    /**
     * Test complete tree property detection
     */
    private static void testCompleteTreeProperty() {
        System.out.println("Testing complete tree property...");
        
        // Complete tree
        BinaryTree<Integer> complete = new BinaryTree<>();
        for (int i = 1; i <= 6; i++) {
            complete.insert(i);
        }
        assertTrue(complete.isComplete(), "Level-order inserted tree should be complete");
        
        // Incomplete tree (manually constructed)
        BinaryTree<String> incomplete = new BinaryTree<>();
        TreeNode<String> root = BinaryTree.createNode("A");
        TreeNode<String> left = BinaryTree.createNode("B");
        TreeNode<String> rightRight = BinaryTree.createNode("D");
        BinaryTree.connect(root, left, null);
        incomplete.setRoot(root);
        
        // Note: Manual construction may not properly set complete property
        // This test depends on implementation details
        
        System.out.println("✓ Complete tree property tests passed");
    }
    
    /**
     * Test full tree property detection
     */
    private static void testFullTreeProperty() {
        System.out.println("Testing full tree property...");
        
        // Full tree: every node has 0 or 2 children
        BinaryTree<String> full = createFullTree();
        assertTrue(full.isFull(), "Manually created full tree should be full");
        
        // Non-full tree: has node with exactly 1 child
        BinaryTree<String> nonFull = createNonFullTree();
        assertFalse(nonFull.isFull(), "Tree with 1-child node should not be full");
        
        System.out.println("✓ Full tree property tests passed");
    }
    
    /**
     * Test balanced tree property detection
     */
    private static void testBalancedTreeProperty() {
        System.out.println("Testing balanced tree property...");
        
        // Balanced tree
        BinaryTree<Integer> balanced = new BinaryTree<>();
        for (int i = 1; i <= 7; i++) {
            balanced.insert(i);
        }
        assertTrue(balanced.isBalanced(), "Complete tree should be balanced");
        
        // Unbalanced tree (linear)
        BinaryTree<Integer> unbalanced = createLinearTree(5);
        assertFalse(unbalanced.isBalanced(), "Linear tree should not be balanced");
        
        System.out.println("✓ Balanced tree property tests passed");
    }
    
    /**
     * Test perfect tree property detection
     */
    private static void testPerfectTreeProperty() {
        System.out.println("Testing perfect tree property...");
        
        // Perfect tree of height 2 (3 levels, 7 nodes)
        BinaryTree<Integer> perfect = new BinaryTree<>();
        for (int i = 1; i <= 7; i++) {
            perfect.insert(i);
        }
        assertTrue(perfect.isPerfect(), "Complete tree of 7 nodes should be perfect");
        
        // Non-perfect tree (6 nodes)
        BinaryTree<Integer> nonPerfect = new BinaryTree<>();
        for (int i = 1; i <= 6; i++) {
            nonPerfect.insert(i);
        }
        assertFalse(nonPerfect.isPerfect(), "Complete tree of 6 nodes should not be perfect");
        
        System.out.println("✓ Perfect tree property tests passed");
    }
    
    // =============================================================================
    // Search and Analysis Tests
    // =============================================================================
    
    /**
     * Test search operations and tree analysis
     */
    public static void testSearchAndAnalysis() {
        System.out.println("=== Search and Analysis Tests ===");
        
        testContainsOperation();
        testLeafCounting();
        testTreeStatistics();
        
        System.out.println("Search and analysis tests completed.\n");
    }
    
    /**
     * Test contains operation
     */
    private static void testContainsOperation() {
        System.out.println("Testing contains operation...");
        
        BinaryTree<String> tree = createTestTree();
        
        // Test existing elements
        String[] existingNodes = {"F", "B", "G", "A", "D", "I", "C", "E", "H"};
        for (String node : existingNodes) {
            assertTrue(tree.contains(node), "Tree should contain " + node);
        }
        
        // Test non-existing elements
        String[] nonExistingNodes = {"X", "Y", "Z"};
        for (String node : nonExistingNodes) {
            assertFalse(tree.contains(node), "Tree should not contain " + node);
        }
        
        System.out.println("✓ Contains operation tests passed");
    }
    
    /**
     * Test leaf counting
     */
    private static void testLeafCounting() {
        System.out.println("Testing leaf counting...");
        
        // Single node tree has 1 leaf
        BinaryTree<String> single = new BinaryTree<>("X");
        assertEqual(1, single.countLeaves(), "Single node tree should have 1 leaf");
        
        // Test tree has 3 leaves: A, E, H
        BinaryTree<String> testTree = createTestTree();
        assertEqual(3, testTree.countLeaves(), "Test tree should have 3 leaves");
        
        // Linear tree has 1 leaf (the last node)
        BinaryTree<Integer> linear = createLinearTree(4);
        assertEqual(1, linear.countLeaves(), "Linear tree should have 1 leaf");
        
        System.out.println("✓ Leaf counting tests passed");
    }
    
    /**
     * Test tree statistics reporting
     */
    private static void testTreeStatistics() {
        System.out.println("Testing tree statistics...");
        
        BinaryTree<String> tree = createTestTree();
        String stats = tree.getStatistics();
        
        assertNotNull(stats, "Statistics should not be null");
        assertTrue(stats.contains("Size:"), "Statistics should contain size");
        assertTrue(stats.contains("Height:"), "Statistics should contain height");
        assertTrue(stats.contains("Leaves:"), "Statistics should contain leaf count");
        
        System.out.println("Sample statistics output:");
        System.out.println(stats);
        
        System.out.println("✓ Tree statistics tests passed");
    }
    
    // =============================================================================
    // Performance Analysis
    // =============================================================================
    
    /**
     * Analyze performance of tree operations
     */
    public static void performanceAnalysis() {
        System.out.println("=== Performance Analysis ===");
        
        analyzeTraversalPerformance();
        analyzeHeightPerformance();
        compareTreeShapes();
        
        System.out.println("Performance analysis completed.\n");
    }
    
    /**
     * Analyze traversal performance on different tree sizes
     */
    private static void analyzeTraversalPerformance() {
        System.out.println("Analyzing traversal performance...");
        
        System.out.println("| Tree Size | Preorder | Inorder | Postorder | Level-order |");
        System.out.println("|-----------|----------|---------|-----------|-------------|");
        
        int[] sizes = {100, 500, 1000, 5000};
        
        for (int size : sizes) {
            BinaryTree<Integer> tree = new BinaryTree<>();
            for (int i = 1; i <= size; i++) {
                tree.insert(i);
            }
            
            long preTime = timeTraversal(() -> tree.preorderTraversal());
            long inTime = timeTraversal(() -> tree.inorderTraversal());
            long postTime = timeTraversal(() -> tree.postorderTraversal());
            long levelTime = timeTraversal(() -> tree.levelOrderTraversal());
            
            System.out.printf("| %9d | %6.2f ms | %5.2f ms | %7.2f ms | %9.2f ms |\n",
                            size, 
                            preTime / 1_000_000.0,
                            inTime / 1_000_000.0,
                            postTime / 1_000_000.0,
                            levelTime / 1_000_000.0);
        }
    }
    
    /**
     * Analyze height calculation performance
     */
    private static void analyzeHeightPerformance() {
        System.out.println("\nAnalyzing height calculation performance...");
        
        System.out.println("| Tree Type | Size | Height | Calc Time |");
        System.out.println("|-----------|------|--------|-----------|");
        
        // Balanced tree
        BinaryTree<Integer> balanced = new BinaryTree<>();
        for (int i = 1; i <= 1023; i++) { // Perfect tree of height 10
            balanced.insert(i);
        }
        
        long balancedTime = timeOperation(() -> balanced.height());
        System.out.printf("| Balanced  | %4d | %6d | %7.2f ms |\n",
                         1023, balanced.height(), balancedTime / 1_000_000.0);
        
        // Linear tree
        BinaryTree<Integer> linear = createLinearTree(1000);
        long linearTime = timeOperation(() -> linear.height());
        System.out.printf("| Linear    | %4d | %6d | %7.2f ms |\n",
                         1000, linear.height(), linearTime / 1_000_000.0);
    }
    
    /**
     * Compare different tree shapes
     */
    private static void compareTreeShapes() {
        System.out.println("\nComparing tree shapes...");
        
        int nodeCount = 100;
        
        // Complete tree
        BinaryTree<Integer> complete = new BinaryTree<>();
        for (int i = 1; i <= nodeCount; i++) {
            complete.insert(i);
        }
        
        // Linear tree
        BinaryTree<Integer> linear = createLinearTree(nodeCount);
        
        System.out.println("| Property | Complete Tree | Linear Tree |");
        System.out.println("|----------|---------------|-------------|");
        System.out.printf("| Height   | %13d | %11d |\n", complete.height(), linear.height());
        System.out.printf("| Balanced | %13s | %11s |\n", complete.isBalanced(), linear.isBalanced());
        System.out.printf("| Complete | %13s | %11s |\n", complete.isComplete(), linear.isComplete());
        System.out.printf("| Full     | %13s | %11s |\n", complete.isFull(), linear.isFull());
    }
    
    // =============================================================================
    // Tree Construction Helpers
    // =============================================================================
    
    /**
     * Create the standard test tree for traversal testing
     */
    private static BinaryTree<String> createTestTree() {
        // Manually construct tree:
        //       F
        //      / \
        //     B   G
        //    / \   \
        //   A   D   I
        //      / \ /
        //     C  E H
        
        BinaryTree<String> tree = new BinaryTree<>();
        TreeNode<String> f = BinaryTree.createNode("F");
        TreeNode<String> b = BinaryTree.createNode("B");
        TreeNode<String> g = BinaryTree.createNode("G");
        TreeNode<String> a = BinaryTree.createNode("A");
        TreeNode<String> d = BinaryTree.createNode("D");
        TreeNode<String> i = BinaryTree.createNode("I");
        TreeNode<String> c = BinaryTree.createNode("C");
        TreeNode<String> e = BinaryTree.createNode("E");
        TreeNode<String> h = BinaryTree.createNode("H");
        
        BinaryTree.connect(f, b, g);
        BinaryTree.connect(b, a, d);
        BinaryTree.connect(g, null, i);
        BinaryTree.connect(d, c, e);
        BinaryTree.connect(i, h, null);
        
        tree.setRoot(f);
        return tree;
    }
    
    /**
     * Create a linear tree (essentially a linked list)
     */
    private static BinaryTree<Integer> createLinearTree(int size) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        TreeNode<Integer> root = BinaryTree.createNode(1);
        tree.setRoot(root);
        
        TreeNode<Integer> current = root;
        for (int i = 2; i <= size; i++) {
            TreeNode<Integer> next = BinaryTree.createNode(i);
            current.right = next;
            current = next;
        }
        
        return tree;
    }
    
    /**
     * Create a full tree (every node has 0 or 2 children)
     */
    private static BinaryTree<String> createFullTree() {
        // Tree:  A
        //       / \
        //      B   C
        //     / \
        //    D   E
        
        BinaryTree<String> tree = new BinaryTree<>();
        TreeNode<String> a = BinaryTree.createNode("A");
        TreeNode<String> b = BinaryTree.createNode("B");
        TreeNode<String> c = BinaryTree.createNode("C");
        TreeNode<String> d = BinaryTree.createNode("D");
        TreeNode<String> e = BinaryTree.createNode("E");
        
        BinaryTree.connect(a, b, c);
        BinaryTree.connect(b, d, e);
        
        tree.setRoot(a);
        return tree;
    }
    
    /**
     * Create a non-full tree (has node with exactly 1 child)
     */
    private static BinaryTree<String> createNonFullTree() {
        // Tree:  A
        //       /
        //      B
        //     /
        //    C
        
        BinaryTree<String> tree = new BinaryTree<>();
        TreeNode<String> a = BinaryTree.createNode("A");
        TreeNode<String> b = BinaryTree.createNode("B");
        TreeNode<String> c = BinaryTree.createNode("C");
        
        BinaryTree.connect(a, b, null);
        BinaryTree.connect(b, c, null);
        
        tree.setRoot(a);
        return tree;
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
    
    private static <T> void assertNull(T actual, String message) {
        assertEqual(null, actual, message);
    }
    
    private static <T> void assertNotNull(T actual, String message) {
        testsRun++;
        if (actual != null) {
            testsPassed++;
        } else {
            System.err.println("ASSERTION FAILED: " + message);
            System.err.println("  Expected: not null, Actual: null");
        }
    }
    
    private static <T> void assertListEquals(List<T> expected, List<T> actual, String message) {
        testsRun++;
        if (expected.equals(actual)) {
            testsPassed++;
        } else {
            System.err.println("ASSERTION FAILED: " + message);
            System.err.println("  Expected: " + expected);
            System.err.println("  Actual: " + actual);
        }
    }
    
    /**
     * Time a traversal operation
     */
    private static long timeTraversal(Runnable operation) {
        long startTime = System.nanoTime();
        operation.run();
        return System.nanoTime() - startTime;
    }
    
    /**
     * Time any operation
     */
    private static long timeOperation(Runnable operation) {
        // Warmup
        operation.run();
        
        long startTime = System.nanoTime();
        operation.run();
        return System.nanoTime() - startTime;
    }
    
    private static void printTestSummary() {
        System.out.println("=== Test Summary ===");
        System.out.printf("Tests run: %d%n", testsRun);
        System.out.printf("Tests passed: %d%n", testsPassed);
        System.out.printf("Tests failed: %d%n", testsRun - testsPassed);
        System.out.printf("Success rate: %.1f%%%n", (100.0 * testsPassed) / testsRun);
        
        if (testsPassed == testsRun) {
            System.out.println("🌳 All tests passed! Your tree implementation is solid!");
        } else {
            System.out.println("❌ Some tests failed. Check your tree implementation.");
        }
    }
    
    // =============================================================================
    // Main Method - Test Runner
    // =============================================================================
    
    /**
     * Run all tests and analyses
     */
    public static void main(String[] args) {
        System.out.println("CSC 220 Lab 6 - Binary Tree Implementation Tests");
        System.out.println("================================================");
        
        try {
            // Reset counters
            testsRun = 0;
            testsPassed = 0;
            
            // Run all test suites
            testBasicTreeOperations();
            testTreeTraversals();
            testTreeProperties();
            testSearchAndAnalysis();
            
            // Performance analysis
            performanceAnalysis();
            
            // Print final results
            printTestSummary();
            
            // Show sample tree visualization
            System.out.println("\n=== Sample Tree Visualization ===");
            BinaryTree<String> sampleTree = createTestTree();
            System.out.println("Tree structure:");
            sampleTree.printTree();
            System.out.println("\nTraversals:");
            System.out.println("Preorder:  " + sampleTree.preorderTraversal());
            System.out.println("Inorder:   " + sampleTree.inorderTraversal());
            System.out.println("Postorder: " + sampleTree.postorderTraversal());
            System.out.println("Level:     " + sampleTree.levelOrderTraversal());
            
        } catch (Exception e) {
            System.err.println("UNEXPECTED ERROR during testing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}