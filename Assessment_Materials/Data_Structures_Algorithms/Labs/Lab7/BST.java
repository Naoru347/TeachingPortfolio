import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Tree implementation for Lab 7.
 * 
 * This class implements a BST with the following operations:
 * - Insert: Add new values while maintaining BST property
 * - Delete: Remove values and restructure tree appropriately  
 * - Search: Find values efficiently using BST property
 * - Traversals: In-order, pre-order, and post-order tree traversals
 * 
 * BST Property: For any node n:
 * - All values in left subtree ≤ n.data
 * - All values in right subtree > n.data
 * 
 * @author Student Name
 * @version Lab 7 - BST Implementation
 */
public class BST {
    
    private BSTNode root;  // Reference to the root of the tree
    private int size;      // Number of nodes in the tree
    
    /**
     * Constructor for creating an empty BST.
     */
    public BST() {
        root = null;
        size = 0;
    }
    
    /**
     * Constructor for creating a BST with a single root node.
     * 
     * @param rootData the data for the root node
     */
    public BST(int rootData) {
        root = new BSTNode(rootData);
        size = 1;
    }
    
    // =====================================================
    // BASIC TREE OPERATIONS
    // =====================================================
    
    /**
     * Returns the root node of the tree.
     * Used primarily for testing purposes.
     * 
     * @return reference to root node, or null if tree is empty
     */
    public BSTNode getRoot() {
        return root;
    }
    
    /**
     * Returns the number of nodes in the tree.
     * 
     * @return the size of the tree
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the tree is empty.
     * 
     * @return true if tree has no nodes, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Removes all nodes from the tree.
     */
    public void clear() {
        root = null;
        size = 0;
    }
    
    // =====================================================
    // SEARCH OPERATION
    // =====================================================
    
    /**
     * Searches for a value in the BST.
     * 
     * @param value the value to search for
     * @return true if value is found, false otherwise
     */
    public boolean search(int value) {
        // TODO: Implement search operation
        // Hint: Use the searchHelper method
        return false;  // Replace with your implementation
    }
    
    /**
     * Recursive helper method for searching.
     * 
     * @param current the current node being examined
     * @param value the value to search for
     * @return true if value is found in subtree rooted at current, false otherwise
     */
    private boolean searchHelper(BSTNode current, int value) {
        // TODO: Implement recursive search logic
        // Base case: What happens when current is null?
        // Recursive cases: Compare value with current.data and search appropriate subtree
        return false;  // Replace with your implementation
    }
    
    // =====================================================
    // INSERT OPERATION
    // =====================================================
    
    /**
     * Inserts a new value into the BST while maintaining the BST property.
     * 
     * @param value the value to insert
     */
    public void insert(int value) {
        // TODO: Implement insert operation
        // Hint: Use insertHelper and update root reference
        // Don't forget to update size!
    }
    
    /**
     * Recursive helper method for insertion.
     * 
     * @param current the current node being examined
     * @param value the value to insert
     * @return the root of the subtree after insertion
     */
    private BSTNode insertHelper(BSTNode current, int value) {
        // TODO: Implement recursive insertion logic
        // Base case: If current is null, create and return new node
        // Recursive cases: Compare value with current.data and insert in appropriate subtree
        // Remember: Return the current node to maintain tree structure
        return null;  // Replace with your implementation
    }
    
    // =====================================================
    // DELETE OPERATION
    // =====================================================
    
    /**
     * Deletes a value from the BST while maintaining the BST property.
     * 
     * @param value the value to delete
     * @return true if value was found and deleted, false otherwise
     */
    public boolean delete(int value) {
        // TODO: Implement delete operation
        // Hint: Use deleteHelper and update root reference
        // Don't forget to update size if deletion occurs!
        return false;  // Replace with your implementation
    }
    
    /**
     * Recursive helper method for deletion.
     * 
     * @param current the current node being examined
     * @param value the value to delete
     * @return the root of the subtree after deletion
     */
    private BSTNode deleteHelper(BSTNode current, int value) {
        // TODO: Implement recursive deletion logic
        // Base case: If current is null, value not found
        // 
        // If value is found, handle three cases:
        // Case 1: Node has no children (leaf) - return null
        // Case 2: Node has one child - return the child
        // Case 3: Node has two children - replace with in-order successor
        //
        // For Case 3, you'll need the findSuccessor method
        return null;  // Replace with your implementation
    }
    
    /**
     * Finds the in-order successor of a node (smallest value in right subtree).
     * Used in deletion when removing a node with two children.
     * 
     * @param node the node whose successor to find
     * @return the in-order successor node
     */
    private BSTNode findSuccessor(BSTNode node) {
        // TODO: Implement successor finding logic
        // The successor is the leftmost node in the right subtree
        // Start with node.right and go left until you can't go further
        return null;  // Replace with your implementation
    }
    
    // =====================================================
    // TREE TRAVERSAL OPERATIONS
    // =====================================================
    
    /**
     * Performs in-order traversal of the tree (Left → Root → Right).
     * For a BST, this should return values in sorted order.
     * 
     * @return list of values in in-order traversal order
     */
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }
    
    /**
     * Recursive helper for in-order traversal.
     * 
     * @param current the current node being visited
     * @param result the list to store traversal results
     */
    private void inOrderHelper(BSTNode current, List<Integer> result) {
        // TODO: Implement in-order traversal logic
        // Pattern: Visit left subtree, process current node, visit right subtree
    }
    
    /**
     * Performs pre-order traversal of the tree (Root → Left → Right).
     * 
     * @return list of values in pre-order traversal order
     */
    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }
    
    /**
     * Recursive helper for pre-order traversal.
     * 
     * @param current the current node being visited
     * @param result the list to store traversal results
     */
    private void preOrderHelper(BSTNode current, List<Integer> result) {
        // TODO: Implement pre-order traversal logic
        // Pattern: Process current node, visit left subtree, visit right subtree
    }
    
    /**
     * Performs post-order traversal of the tree (Left → Right → Root).
     * 
     * @return list of values in post-order traversal order
     */
    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }
    
    /**
     * Recursive helper for post-order traversal.
     * 
     * @param current the current node being visited
     * @param result the list to store traversal results
     */
    private void postOrderHelper(BSTNode current, List<Integer> result) {
        // TODO: Implement post-order traversal logic
        // Pattern: Visit left subtree, visit right subtree, process current node
    }
    
    // =====================================================
    // UTILITY METHODS
    // =====================================================
    
    /**
     * Calculates the height of the tree.
     * Height is the length of the longest path from root to a leaf.
     * 
     * @return the height of the tree, or -1 if tree is empty
     */
    public int height() {
        return heightHelper(root);
    }
    
    /**
     * Recursive helper for calculating height.
     * 
     * @param current the current node
     * @return the height of the subtree rooted at current
     */
    private int heightHelper(BSTNode current) {
        // TODO: Implement height calculation
        // Base case: If current is null, return -1
        // Recursive case: Return 1 + max(height of left subtree, height of right subtree)
        return -1;  // Replace with your implementation
    }
    
    /**
     * Finds the minimum value in the tree.
     * 
     * @return the minimum value, or throws exception if tree is empty
     * @throws IllegalStateException if tree is empty
     */
    public int findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find minimum in empty tree");
        }
        // TODO: Implement findMin
        // Hint: In a BST, minimum is always the leftmost node
        return -1;  // Replace with your implementation
    }
    
    /**
     * Finds the maximum value in the tree.
     * 
     * @return the maximum value, or throws exception if tree is empty
     * @throws IllegalStateException if tree is empty
     */
    public int findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find maximum in empty tree");
        }
        // TODO: Implement findMax
        // Hint: In a BST, maximum is always the rightmost node
        return -1;  // Replace with your implementation
    }
    
    /**
     * Validates that this tree maintains the BST property.
     * Useful for testing and debugging.
     * 
     * @return true if tree is a valid BST, false otherwise
     */
    public boolean isValidBST() {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    /**
     * Recursive helper for BST validation.
     * 
     * @param current the current node
     * @param minVal the minimum allowed value for this subtree
     * @param maxVal the maximum allowed value for this subtree
     * @return true if subtree rooted at current is valid BST
     */
    private boolean isValidBSTHelper(BSTNode current, int minVal, int maxVal) {
        // TODO: Implement BST validation logic
        // Base case: null node is valid
        // Check: current.data must be within [minVal, maxVal]
        // Recursive: validate left subtree with updated max, right subtree with updated min
        return true;  // Replace with your implementation
    }
    
    /**
     * Creates a visual representation of the tree for debugging.
     * Prints the tree structure sideways.
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTreeHelper(root, 0);
        }
    }
    
    /**
     * Recursive helper for tree printing.
     * 
     * @param current the current node
     * @param depth the depth of the current node (for indentation)
     */
    private void printTreeHelper(BSTNode current, int depth) {
        if (current != null) {
            printTreeHelper(current.right, depth + 1);
            System.out.println("  ".repeat(depth) + current.data);
            printTreeHelper(current.left, depth + 1);
        }
    }
    
    /**
     * Returns a string representation of the tree using in-order traversal.
     * 
     * @return string representation of tree values
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        return inOrderTraversal().toString();
    }
}