import java.util.*;

/**
 * BinaryTreeStarter - Lab 6 Starter Code
 * 
 * This file provides skeleton implementations for a complete binary tree ADT.
 * Students will complete the TODOs to implement tree construction, traversals,
 * and property verification using recursion.
 * 
 * @author CSC 220
 * @version Lab 6 - Fall 2025
 */

// =============================================================================
// TreeNode Class
// =============================================================================

/**
 * TreeNode represents a single node in a binary tree.
 */
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

// =============================================================================
// Binary Tree ADT Implementation
// =============================================================================

public class BinaryTree<T> {
    private TreeNode<T> root;
    private int size;

    /**
     * Constructs an empty binary tree.
     */
    public BinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * Constructs a binary tree with given root data.
     */
    public BinaryTree(T rootData) {
        root = new TreeNode<>(rootData);
        size = 1;
    }

    // =============================================================================
    // Basic Tree Operations
    // =============================================================================

    /**
     * TODO: Insert data into the tree using level-order insertion.
     * 
     * Examples:
     * insert("A"), insert("B"), insert("C") builds:
     *        A
     *       / \
     *      B   C
     * 
     * Time Complexity: O(n) in worst case
     * Space Complexity: O(w) where w = tree width
     * 
     * @param data element to insert
     */
    public void insert(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);

        if (root == null) {
            // TODO: Handle empty tree case
            // root = newNode; size++;
            return;
        }

        // TODO: Use BFS with a queue
        // Queue<TreeNode<T>> queue = new LinkedList<>();
        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     TreeNode<T> current = queue.poll();
        //     if (current.left == null) {
        //         current.left = newNode;
        //         size++;
        //         return;
        //     } else if (current.right == null) {
        //         current.right = newNode;
        //         size++;
        //         return;
        //     } else {
        //         queue.offer(current.left);
        //         queue.offer(current.right);
        //     }
        // }
    }

    /**
     * TODO: Count number of nodes in the tree using recursion.
     * 
     * @return number of nodes
     */
    public int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(TreeNode<T> node) {
        // TODO: Base case: empty tree
        // if (node == null) return 0;
        // TODO: Recursive case
        // return 1 + sizeHelper(node.left) + sizeHelper(node.right);
        return 0; // Placeholder
    }

    /**
     * TODO: Calculate height of tree using recursion.
     * By convention: empty = 0, single node = 1
     * 
     * @return height of tree
     */
    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(TreeNode<T> node) {
        // TODO: Base case
        // if (node == null) return 0;
        // TODO: Recursive case
        // return Math.max(heightHelper(node.left), heightHelper(node.right)) + 1;
        return 0; // Placeholder
    }

    /**
     * TODO: Check if tree is empty.
     */
    public boolean isEmpty() {
        // return root == null;
        return false; // Placeholder
    }

    /**
     * TODO: Get root data or null if tree is empty.
     */
    public T getRootData() {
        // return (root != null) ? root.data : null;
        return null; // Placeholder
    }

    // =============================================================================
    // Traversals
    // =============================================================================

    /**
     * TODO: Preorder traversal (Root → Left → Right).
     */
    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode<T> node, List<T> result) {
        // TODO: if (node == null) return;
        // result.add(node.data);
        // preorderHelper(node.left, result);
        // preorderHelper(node.right, result);
    }

    /**
     * TODO: Inorder traversal (Left → Root → Right).
     */
    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode<T> node, List<T> result) {
        // TODO: if (node == null) return;
        // inorderHelper(node.left, result);
        // result.add(node.data);
        // inorderHelper(node.right, result);
    }

    /**
     * TODO: Postorder traversal (Left → Right → Root).
     */
    public List<T> postorderTraversal() {
        List<T> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode<T> node, List<T> result) {
        // TODO: if (node == null) return;
        // postorderHelper(node.left, result);
        // postorderHelper(node.right, result);
        // result.add(node.data);
    }

    /**
     * TODO: Level-order traversal (Breadth-first).
     */
    public List<T> levelOrderTraversal() {
        List<T> result = new ArrayList<>();
        if (root == null) return result;

        // TODO: Use a queue
        // Queue<TreeNode<T>> queue = new LinkedList<>();
        // queue.offer(root);
        // while (!queue.isEmpty()) { ... }

        return result; // Placeholder
    }

    // =============================================================================
    // Tree Properties
    // =============================================================================

    /**
     * TODO: Check if tree is complete.
     */
    public boolean isComplete() {
        // TODO: BFS with queue
        // boolean foundNull = false;
        // while (!queue.isEmpty()) { ... }
        return false; // Placeholder
    }

    /**
     * TODO: Check if tree is full (every node has 0 or 2 children).
     */
    public boolean isFull() {
        return isFullHelper(root);
    }

    private boolean isFullHelper(TreeNode<T> node) {
        // TODO: implement recursively
        return false; // Placeholder
    }

    /**
     * TODO: Check if tree is balanced (subtree heights differ by ≤ 1).
     */
    public boolean isBalanced() {
        return isBalancedHelper(root) != -1;
    }

    private int isBalancedHelper(TreeNode<T> node) {
        // TODO: return -1 if unbalanced, else height
        return 0; // Placeholder
    }

    /**
     * TODO: Check if tree is perfect (all leaves same depth, all internals full).
     */
    public boolean isPerfect() {
        // TODO: Use height + recursive check
        return false; // Placeholder
    }

    // =============================================================================
    // Search & Analysis
    // =============================================================================

    /**
     * TODO: Search for a value in the tree.
     */
    public boolean contains(T data) {
        // return containsHelper(root, data);
        return false; // Placeholder
    }

    private boolean containsHelper(TreeNode<T> node, T data) {
        // TODO: implement recursively
        return false; // Placeholder
    }

    /**
     * TODO: Count leaf nodes.
     */
    public int countLeaves() {
        // return countLeavesHelper(root);
        return 0; // Placeholder
    }

    private int countLeavesHelper(TreeNode<T> node) {
        // TODO: if leaf, return 1; else recurse
        return 0; // Placeholder
    }

    /**
     * TODO: Return string with size, height, and leaves.
     */
    public String getStatistics() {
        // return "Size: " + size() + ", Height: " + height() + ", Leaves: " + countLeaves();
        return "TODO"; // Placeholder
    }

    // =============================================================================
    // Utilities for TreeTester
    // =============================================================================

    public static <E> TreeNode<E> createNode(E data) {
        return new TreeNode<>(data);
    }

    public static <E> void connect(TreeNode<E> parent, TreeNode<E> left, TreeNode<E> right) {
        parent.left = left;
        parent.right = right;
    }

    public void setRoot(TreeNode<T> node) {
        this.root = node;
        this.size = sizeHelper(node);
    }

    /**
     * TODO (optional): Print tree sideways for debugging.
     */
    public void printTree() {
        printTreeHelper(root, 0);
    }

    private void printTreeHelper(TreeNode<T> node, int depth) {
        if (node == null) return;
        printTreeHelper(node.right, depth + 1);
        System.out.println(" ".repeat(depth * 4) + node.data);
        printTreeHelper(node.left, depth + 1);
    }
}