/**
 * AVLNode represents a node in an AVL (self-balancing) tree.
 * This class extends the basic node concept by adding height tracking
 * and balance factor calculation for maintaining tree balance.
 * 
 * AVL Property: For any node, the height difference between left and 
 * right subtrees is at most 1 (balance factor ∈ {-1, 0, 1}).
 * 
 * @author Student Name
 * @version Lab 8 - AVL Tree Implementation
 */
public class AVLNode {
    
    // Instance variables
    public int data;           // The value stored in this node
    public AVLNode left;       // Reference to left child (smaller values)
    public AVLNode right;      // Reference to right child (larger values)
    public int height;         // Height of subtree rooted at this node
    
    /**
     * Constructor for creating a new AVL node with the given data.
     * Left and right children are initialized to null, height to 0.
     * 
     * @param data the integer value to store in this node
     */
    public AVLNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;  // Leaf nodes start with height 0
    }
    
    /**
     * Constructor for creating a new AVL node with data and child references.
     * Height is calculated based on children.
     * 
     * @param data the integer value to store in this node
     * @param left reference to the left child node
     * @param right reference to the right child node
     */
    public AVLNode(int data, AVLNode left, AVLNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = calculateHeight();
    }
    
    /**
     * Returns the data stored in this node.
     * 
     * @return the integer data value
     */
    public int getData() {
        return data;
    }
    
    /**
     * Sets the data for this node.
     * 
     * @param data the new integer value to store
     */
    public void setData(int data) {
        this.data = data;
    }
    
    /**
     * Returns the left child of this node.
     * 
     * @return reference to left child node, or null if no left child
     */
    public AVLNode getLeft() {
        return left;
    }
    
    /**
     * Sets the left child of this node and updates height.
     * 
     * @param left the new left child node
     */
    public void setLeft(AVLNode left) {
        this.left = left;
        updateHeight();
    }
    
    /**
     * Returns the right child of this node.
     * 
     * @return reference to right child node, or null if no right child
     */
    public AVLNode getRight() {
        return right;
    }
    
    /**
     * Sets the right child of this node and updates height.
     * 
     * @param right the new right child node
     */
    public void setRight(AVLNode right) {
        this.right = right;
        updateHeight();
    }
    
    /**
     * Returns the height of this node.
     * Height is the length of the longest path from this node to a leaf.
     * 
     * @return the height of the subtree rooted at this node
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Manually sets the height of this node.
     * Generally, updateHeight() should be used instead to ensure correctness.
     * 
     * @param height the new height value
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    // =====================================================
    // HEIGHT MANAGEMENT METHODS
    // =====================================================
    
    /**
     * Gets the height of a node, handling null nodes correctly.
     * Null nodes are considered to have height -1.
     * 
     * @param node the node to get height of (may be null)
     * @return height of the node, or -1 if node is null
     */
    public static int getHeight(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }
    
    /**
     * Calculates what this node's height should be based on its children.
     * Height = 1 + max(height of left child, height of right child)
     * 
     * @return the calculated height
     */
    public int calculateHeight() {
        int leftHeight = getHeight(left);
        int rightHeight = getHeight(right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    /**
     * Updates this node's height based on its current children.
     * This method should be called after any structural changes to the tree.
     */
    public void updateHeight() {
        this.height = calculateHeight();
    }
    
    // =====================================================
    // BALANCE FACTOR METHODS
    // =====================================================
    
    /**
     * Calculates the balance factor of this node.
     * Balance Factor = height(left subtree) - height(right subtree)
     * 
     * For AVL trees:
     * - Balance factor should be in {-1, 0, 1}
     * - BF > 1: left heavy (needs right rotation)
     * - BF < -1: right heavy (needs left rotation)
     * 
     * @return the balance factor of this node
     */
    public int getBalanceFactor() {
        int leftHeight = getHeight(left);
        int rightHeight = getHeight(right);
        return leftHeight - rightHeight;
    }
    
    /**
     * Gets the balance factor of a node, handling null nodes correctly.
     * Null nodes are considered to have balance factor 0.
     * 
     * @param node the node to get balance factor of (may be null)
     * @return balance factor of the node, or 0 if node is null
     */
    public static int getBalanceFactor(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.getBalanceFactor();
    }
    
    /**
     * Checks if this node is balanced according to AVL property.
     * A node is balanced if its balance factor is in {-1, 0, 1}.
     * 
     * @return true if this node is balanced, false otherwise
     */
    public boolean isBalanced() {
        int bf = getBalanceFactor();
        return bf >= -1 && bf <= 1;
    }
    
    /**
     * Checks if this node is left-heavy (balance factor > 1).
     * 
     * @return true if left subtree is significantly heavier
     */
    public boolean isLeftHeavy() {
        return getBalanceFactor() > 1;
    }
    
    /**
     * Checks if this node is right-heavy (balance factor < -1).
     * 
     * @return true if right subtree is significantly heavier
     */
    public boolean isRightHeavy() {
        return getBalanceFactor() < -1;
    }
    
    // =====================================================
    // NODE TYPE CHECKING METHODS
    // =====================================================
    
    /**
     * Checks if this node is a leaf (has no children).
     * 
     * @return true if this node has no children, false otherwise
     */
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
    /**
     * Checks if this node has only one child.
     * 
     * @return true if this node has exactly one child, false otherwise
     */
    public boolean hasOneChild() {
        return (left == null && right != null) || (left != null && right == null);
    }
    
    /**
     * Checks if this node has two children.
     * 
     * @return true if this node has both left and right children, false otherwise
     */
    public boolean hasTwoChildren() {
        return left != null && right != null;
    }
    
    /**
     * Checks if this node has only a left child.
     * 
     * @return true if this node has left child but no right child
     */
    public boolean hasOnlyLeftChild() {
        return left != null && right == null;
    }
    
    /**
     * Checks if this node has only a right child.
     * 
     * @return true if this node has right child but no left child
     */
    public boolean hasOnlyRightChild() {
        return left == null && right != null;
    }
    
    // =====================================================
    // UTILITY METHODS
    // =====================================================
    
    /**
     * Returns a string representation of this node including height and balance factor.
     * Useful for debugging and testing.
     * 
     * @return string containing the node's data, height, and balance factor
     */
    @Override
    public String toString() {
        return String.format("Node(%d, h=%d, bf=%d)", data, height, getBalanceFactor());
    }
    
    /**
     * Returns a detailed string representation including children information.
     * 
     * @return detailed string representation
     */
    public String toDetailedString() {
        String leftStr = (left == null) ? "null" : String.valueOf(left.data);
        String rightStr = (right == null) ? "null" : String.valueOf(right.data);
        return String.format("Node(%d, h=%d, bf=%d, left=%s, right=%s)", 
                           data, height, getBalanceFactor(), leftStr, rightStr);
    }
    
    /**
     * Compares this node with another object for equality.
     * Two nodes are equal if they have the same data value.
     * Note: This does not compare the tree structure, only the data.
     * 
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AVLNode avlNode = (AVLNode) obj;
        return data == avlNode.data;
    }
    
    /**
     * Returns the hash code for this node based on its data.
     * 
     * @return hash code value for this node
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(data);
    }
    
    /**
     * Creates a deep copy of this node and its subtree.
     * Useful for testing and creating backup copies.
     * 
     * @return a new AVLNode that is a copy of this subtree
     */
    public AVLNode copy() {
        AVLNode newNode = new AVLNode(this.data);
        if (this.left != null) {
            newNode.left = this.left.copy();
        }
        if (this.right != null) {
            newNode.right = this.right.copy();
        }
        newNode.updateHeight();
        return newNode;
    }
    
    /**
     * Validates that the subtree rooted at this node maintains AVL properties.
     * Checks both BST property and balance property.
     * 
     * @return true if subtree is a valid AVL tree, false otherwise
     */
    public boolean isValidAVL() {
        return isValidAVLHelper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    /**
     * Helper method for AVL validation that checks BST property with bounds
     * and AVL balance property.
     * 
     * @param minVal minimum allowed value for this subtree
     * @param maxVal maximum allowed value for this subtree
     * @return true if subtree is valid AVL tree within bounds
     */
    private boolean isValidAVLHelper(int minVal, int maxVal) {
        // Check BST property
        if (data <= minVal || data >= maxVal) {
            return false;
        }
        
        // Check AVL balance property
        if (!isBalanced()) {
            return false;
        }
        
        // Check height consistency
        if (height != calculateHeight()) {
            return false;
        }
        
        // Recursively check children
        if (left != null && !left.isValidAVLHelper(minVal, data)) {
            return false;
        }
        if (right != null && !right.isValidAVLHelper(data, maxVal)) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Counts the total number of nodes in the subtree rooted at this node.
     * 
     * @return the number of nodes in this subtree
     */
    public int size() {
        int count = 1;  // Count this node
        if (left != null) {
            count += left.size();
        }
        if (right != null) {
            count += right.size();
        }
        return count;
    }
    
    /**
     * Finds the minimum value in the subtree rooted at this node.
     * In a BST, this is always the leftmost node.
     * 
     * @return the minimum value in this subtree
     */
    public int findMin() {
        AVLNode current = this;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }
    
    /**
     * Finds the maximum value in the subtree rooted at this node.
     * In a BST, this is always the rightmost node.
     * 
     * @return the maximum value in this subtree
     */
    public int findMax() {
        AVLNode current = this;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
}