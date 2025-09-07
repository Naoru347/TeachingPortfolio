import java.util.ArrayList;
import java.util.List;

/**
 * AVL Tree implementation - a self-balancing binary search tree.
 * 
 * This class maintains the AVL property: for any node, the height difference
 * between left and right subtrees is at most 1. This guarantees O(log n)
 * performance for all operations.
 * 
 * AVL Properties:
 * 1. BST Property: left subtree ≤ node < right subtree
 * 2. Balance Property: |height(left) - height(right)| ≤ 1 for all nodes
 * 3. Height Property: height = 1 + max(height(left), height(right))
 * 
 * @author Student Name
 * @version Lab 8 - AVL Tree Implementation
 */
public class AVLTree {
    
    private AVLNode root;  // Reference to the root of the tree
    private int size;      // Number of nodes in the tree
    
    /**
     * Constructor for creating an empty AVL tree.
     */
    public AVLTree() {
        root = null;
        size = 0;
    }
    
    /**
     * Constructor for creating an AVL tree with a single root node.
     * 
     * @param rootData the data for the root node
     */
    public AVLTree(int rootData) {
        root = new AVLNode(rootData);
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
    public AVLNode getRoot() {
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
     * Returns the height of the tree.
     * 
     * @return height of the tree, or -1 if empty
     */
    public int height() {
        return AVLNode.getHeight(root);
    }
    
    /**
     * Removes all nodes from the tree.
     */
    public void clear() {
        root = null;
        size = 0;
    }
    
    // =====================================================
    // ROTATION OPERATIONS
    // =====================================================
    
    /**
     * Performs a right rotation on the given node.
     * Used when the left subtree is too heavy (balance factor > 1).
     * 
     * Before:     After:
     *     y         x
     *    / \       / \
     *   x   C     A   y
     *  / \           / \
     * A   B         B   C
     * 
     * @param y the root of the subtree to rotate
     * @return the new root of the subtree after rotation
     */
    private AVLNode rotateRight(AVLNode y) {
        // TODO: Implement right rotation
        // Step 1: Store x = y.left
        // Step 2: Make y.left = x.right (move subtree B)
        // Step 3: Make x.right = y (rotate)
        // Step 4: Update heights (y first, then x)
        // Step 5: Return x as new root
        
        return null; // Replace with your implementation
    }
    
    /**
     * Performs a left rotation on the given node.
     * Used when the right subtree is too heavy (balance factor < -1).
     * 
     * Before:     After:
     *   x           y
     *  / \         / \
     * A   y       x   C
     *    / \     / \
     *   B   C   A   B
     * 
     * @param x the root of the subtree to rotate
     * @return the new root of the subtree after rotation
     */
    private AVLNode rotateLeft(AVLNode x) {
        // TODO: Implement left rotation
        // Step 1: Store y = x.right
        // Step 2: Make x.right = y.left (move subtree B)
        // Step 3: Make y.left = x (rotate)
        // Step 4: Update heights (x first, then y)
        // Step 5: Return y as new root
        
        return null; // Replace with your implementation
    }
    
    /**
     * Performs a left-right (LR) double rotation.
     * Used when left child's right subtree causes imbalance.
     * 
     * @param z the root of the subtree to rotate
     * @return the new root after double rotation
     */
    private AVLNode rotateLeftRight(AVLNode z) {
        // TODO: Implement left-right rotation
        // Step 1: Perform left rotation on z.left
        // Step 2: Perform right rotation on z
        // This is equivalent to:
        // z.left = rotateLeft(z.left);
        // return rotateRight(z);
        
        return null; // Replace with your implementation
    }
    
    /**
     * Performs a right-left (RL) double rotation.
     * Used when right child's left subtree causes imbalance.
     * 
     * @param z the root of the subtree to rotate
     * @return the new root after double rotation
     */
    private AVLNode rotateRightLeft(AVLNode z) {
        // TODO: Implement right-left rotation
        // Step 1: Perform right rotation on z.right
        // Step 2: Perform left rotation on z
        // This is equivalent to:
        // z.right = rotateRight(z.right);
        // return rotateLeft(z);
        
        return null; // Replace with your implementation
    }
    
    // =====================================================
    // BALANCING OPERATIONS
    // =====================================================
    
    /**
     * Rebalances a node if necessary after insertion or deletion.
     * Determines which rotation is needed based on balance factors.
     * 
     * @param node the node to potentially rebalance
     * @return the new root of the subtree after rebalancing
     */
    private AVLNode rebalance(AVLNode node) {
        if (node == null) {
            return null;
        }
        
        // Update height first
        node.updateHeight();
        
        // Get balance factor
        int balanceFactor = node.getBalanceFactor();
        
        // TODO: Implement rebalancing logic
        // 
        // Left Heavy (BF > 1):
        //   - If left child is left heavy or balanced: Single right rotation
        //   - If left child is right heavy: Left-Right double rotation
        //
        // Right Heavy (BF < -1):
        //   - If right child is right heavy or balanced: Single left rotation  
        //   - If right child is left heavy: Right-Left double rotation
        //
        // Balanced (BF ∈ {-1, 0, 1}): No rotation needed
        
        // Pattern:
        // if (balanceFactor > 1) {
        //     // Left heavy cases
        //     if (AVLNode.getBalanceFactor(node.left) >= 0) {
        //         // Left-Left case
        //         return rotateRight(node);
        //     } else {
        //         // Left-Right case  
        //         return rotateLeftRight(node);
        //     }
        // }
        // if (balanceFactor < -1) {
        //     // Right heavy cases
        //     // TODO: Implement right heavy logic
        // }
        
        return node; // Replace with your implementation
    }
    
    // =====================================================
    // SEARCH OPERATION
    // =====================================================
    
    /**
     * Searches for a value in the AVL tree.
     * 
     * @param value the value to search for
     * @return true if value is found, false otherwise
     */
    public boolean search(int value) {
        return searchHelper(root, value);
    }
    
    /**
     * Recursive helper method for searching.
     * 
     * @param current the current node being examined
     * @param value the value to search for
     * @return true if value is found in subtree rooted at current
     */
    private boolean searchHelper(AVLNode current, int value) {
        // TODO: Implement search logic (same as BST)
        // Base case: current is null
        // Recursive cases: compare value with current.data and search appropriate subtree
        
        return false; // Replace with your implementation
    }
    
    // =====================================================
    // INSERT OPERATION WITH REBALANCING
    // =====================================================
    
    /**
     * Inserts a new value into the AVL tree while maintaining balance.
     * 
     * @param value the value to insert
     */
    public void insert(int value) {
        root = insertHelper(root, value);
    }
    
    /**
     * Recursive helper method for insertion with rebalancing.
     * 
     * @param current the current node being examined
     * @param value the value to insert
     * @return the root of the subtree after insertion and rebalancing
     */
    private AVLNode insertHelper(AVLNode current, int value) {
        // TODO: Implement AVL insertion
        // 
        // Step 1: Perform standard BST insertion
        // Step 2: Update size if new node was created
        // Step 3: Rebalance the current node
        // 
        // Base case: if current is null, create new node and increment size
        // Recursive cases: compare value with current.data and insert in appropriate subtree
        // After recursive call: rebalance current node
        
        return null; // Replace with your implementation
    }
    
    // =====================================================
    // DELETE OPERATION WITH REBALANCING
    // =====================================================
    
    /**
     * Deletes a value from the AVL tree while maintaining balance.
     * 
     * @param value the value to delete
     * @return true if value was found and deleted, false otherwise
     */
    public boolean delete(int value) {
        int originalSize = size;
        root = deleteHelper(root, value);
        return size < originalSize;
    }
    
    /**
     * Recursive helper method for deletion with rebalancing.
     * 
     * @param current the current node being examined
     * @param value the value to delete
     * @return the root of the subtree after deletion and rebalancing
     */
    private AVLNode deleteHelper(AVLNode current, int value) {
        // TODO: Implement AVL deletion
        //
        // Step 1: Perform standard BST deletion
        // Step 2: Update size if node was deleted
        // Step 3: Rebalance the current node
        //
        // Base case: if current is null, value not found
        // If value found, handle three cases:
        //   - No children: return null
        //   - One child: return the child
        //   - Two children: replace with successor and delete successor
        // After deletion: rebalance current node
        
        return null; // Replace with your implementation
    }
    
    /**
     * Finds the in-order successor of a node (smallest value in right subtree).
     * 
     * @param node the node whose successor to find
     * @return the in-order successor node
     */
    private AVLNode findSuccessor(AVLNode node) {
        AVLNode current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    // =====================================================
    // TREE TRAVERSAL OPERATIONS
    // =====================================================
    
    /**
     * Performs in-order traversal of the tree.
     * For AVL trees, this returns values in sorted order.
     * 
     * @return list of values in sorted order
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
    private void inOrderHelper(AVLNode current, List<Integer> result) {
        if (current != null) {
            inOrderHelper(current.left, result);
            result.add(current.data);
            inOrderHelper(current.right, result);
        }
    }
    
    /**
     * Performs pre-order traversal of the tree.
     * 
     * @return list of values in pre-order
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
    private void preOrderHelper(AVLNode current, List<Integer> result) {
        if (current != null) {
            result.add(current.data);
            preOrderHelper(current.left, result);
            preOrderHelper(current.right, result);
        }
    }
    
    /**
     * Performs post-order traversal of the tree.
     * 
     * @return list of values in post-order
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
    private void postOrderHelper(AVLNode current, List<Integer> result) {
        if (current != null) {
            postOrderHelper(current.left, result);
            postOrderHelper(current.right, result);
            result.add(current.data);
        }
    }
    
    // =====================================================
    // UTILITY AND VALIDATION METHODS
    // =====================================================
    
    /**
     * Validates that this tree maintains the AVL properties.
     * Checks both BST property and balance property for all nodes.
     * 
     * @return true if tree is a valid AVL tree, false otherwise
     */
    public boolean isValidAVL() {
        if (root == null) {
            return true;
        }
        return root.isValidAVL();
    }
    
    /**
     * Checks if the tree is balanced (all nodes have balance factor ∈ {-1, 0, 1}).
     * 
     * @return true if tree is balanced, false otherwise
     */
    public boolean isBalanced() {
        return isBalancedHelper(root);
    }
    
    /**
     * Recursive helper for balance checking.
     * 
     * @param node the current node to check
     * @return true if subtree rooted at node is balanced
     */
    private boolean isBalancedHelper(AVLNode node) {
        if (node == null) {
            return true;
        }
        
        if (!node.isBalanced()) {
            return false;
        }
        
        return isBalancedHelper(node.left) && isBalancedHelper(node.right);
    }
    
    /**
     * Finds the minimum value in the tree.
     * 
     * @return the minimum value
     * @throws IllegalStateException if tree is empty
     */
    public int findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find minimum in empty tree");
        }
        return root.findMin();
    }
    
    /**
     * Finds the maximum value in the tree.
     * 
     * @return the maximum value
     * @throws IllegalStateException if tree is empty
     */
    public int findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot find maximum in empty tree");
        }
        return root.findMax();
    }
    
    /**
     * Gets the balance factor of the root node.
     * Useful for debugging and testing.
     * 
     * @return balance factor of root, or 0 if tree is empty
     */
    public int getRootBalanceFactor() {
        return AVLNode.getBalanceFactor(root);
    }
    
    /**
     * Creates a visual representation of the tree for debugging.
     * Shows data, height, and balance factor for each node.
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTreeHelper(root, 0);
        }
    }
    
    /**
     * Recursive helper for tree printing with indentation.
     * 
     * @param current the current node
     * @param depth the depth of the current node (for indentation)
     */
    private void printTreeHelper(AVLNode current, int depth) {
        if (current != null) {
            printTreeHelper(current.right, depth + 1);
            System.out.println("  ".repeat(depth) + current.toString());
            printTreeHelper(current.left, depth + 1);
        }
    }
    
    /**
     * Creates a detailed tree structure representation.
     * Useful for debugging rotation logic.
     */
    public void printDetailedTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printDetailedHelper(root, "", true);
        }
    }
    
    /**
     * Recursive helper for detailed tree printing with tree structure.
     * 
     * @param node the current node
     * @param prefix the prefix for this level
     * @param isLast whether this is the last child at this level
     */
    private void printDetailedHelper(AVLNode node, String prefix, boolean isLast) {
        if (node != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + node.toString());
            
            if (node.left != null || node.right != null) {
                if (node.left != null) {
                    printDetailedHelper(node.left, prefix + (isLast ? "    " : "│   "), node.right == null);
                }
                if (node.right != null) {
                    printDetailedHelper(node.right, prefix + (isLast ? "    " : "│   "), true);
                }
            }
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
    
    /**
     * Gets statistics about the tree structure.
     * Useful for performance analysis.
     * 
     * @return formatted string with tree statistics
     */
    public String getTreeStats() {
        if (isEmpty()) {
            return "Empty tree";
        }
        
        int actualHeight = height();
        int optimalHeight = (int) Math.ceil(Math.log(size + 1) / Math.log(2)) - 1;
        double balanceRatio = (double) actualHeight / optimalHeight;
        
        return String.format(
            "Tree Statistics:\n" +
            "  Size: %d nodes\n" +
            "  Height: %d (optimal: %d)\n" +
            "  Balance ratio: %.2f\n" +
            "  Root balance factor: %d\n" +
            "  Is balanced: %s\n" +
            "  Is valid AVL: %s",
            size, actualHeight, optimalHeight, balanceRatio,
            getRootBalanceFactor(), isBalanced(), isValidAVL()
        );
    }
}