/**
 * BSTNode represents a single node in a Binary Search Tree.
 * This class encapsulates the data and references to child nodes.
 * 
 * @author Student Name
 * @version Lab 7 - BST Implementation
 */
public class BSTNode {
    
    // Instance variables
    public int data;           // The value stored in this node
    public BSTNode left;       // Reference to left child (smaller values)
    public BSTNode right;      // Reference to right child (larger values)
    
    /**
     * Constructor for creating a new BST node with the given data.
     * Left and right children are initialized to null.
     * 
     * @param data the integer value to store in this node
     */
    public BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Constructor for creating a new BST node with data and child references.
     * 
     * @param data the integer value to store in this node
     * @param left reference to the left child node
     * @param right reference to the right child node
     */
    public BSTNode(int data, BSTNode left, BSTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
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
    public BSTNode getLeft() {
        return left;
    }
    
    /**
     * Sets the left child of this node.
     * 
     * @param left the new left child node
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }
    
    /**
     * Returns the right child of this node.
     * 
     * @return reference to right child node, or null if no right child
     */
    public BSTNode getRight() {
        return right;
    }
    
    /**
     * Sets the right child of this node.
     * 
     * @param right the new right child node
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }
    
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
     * Returns a string representation of this node.
     * Useful for debugging and testing.
     * 
     * @return string containing the node's data value
     */
    @Override
    public String toString() {
        return "Node(" + data + ")";
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
        BSTNode bstNode = (BSTNode) obj;
        return data == bstNode.data;
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
}