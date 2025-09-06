import java.util.NoSuchElementException;

/**
 * LinkedListStarter - Lab 3 Starter Code
 * 
 * This file provides skeleton implementations for both singly and doubly
 * linked lists. Students will complete the TODOs to implement core operations.
 * 
 * @author CSC 220 Teaching Team
 * @version Lab 3 - Fall 2025
 */

// =============================================================================
// Node Classes
// =============================================================================

/**
 * Node class for singly linked lists
 */
class Node<T> {
    T data;
    Node<T> next;
    
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}

/**
 * Node class for doubly linked lists
 */
class DoublyNode<T> {
    T data;
    DoublyNode<T> next;
    DoublyNode<T> prev;
    
    public DoublyNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}

// =============================================================================
// Singly Linked List Implementation
// =============================================================================

/**
 * A generic singly linked list implementation
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;
    
    /**
     * Constructs an empty singly linked list
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * Returns the number of elements in the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the list is empty
     * @return true if the list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * TODO: Adds an element to the beginning of the list
     * Time Complexity: O(1)
     * 
     * @param data the element to add
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        // TODO: Connect the new node to the existing list
        // TODO: Update head reference
        // TODO: Update size
        
        // HINT: 
        // 1. Set newNode.next to point to current head
        // 2. Update head to point to newNode
        // 3. Increment size
    }
    
    /**
     * TODO: Adds an element to the end of the list
     * Time Complexity: O(n)
     * 
     * @param data the element to add
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (head == null) {
            // TODO: Handle empty list case
            // HINT: When list is empty, new node becomes the head
        } else {
            // TODO: Traverse to the end and add new node
            // HINT: 
            // 1. Start from head and traverse until current.next == null
            // 2. Set current.next = newNode
        }
        // TODO: Update size
    }
    
    /**
     * TODO: Removes and returns the first element of the list
     * Time Complexity: O(1)
     * 
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        
        // TODO: Store data to return
        // TODO: Update head reference
        // TODO: Update size
        // TODO: Return stored data
        
        // HINT:
        // 1. T data = head.data;
        // 2. head = head.next;
        // 3. size--;
        // 4. return data;
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * TODO: Returns the element at the specified index
     * Time Complexity: O(n)
     * 
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        // TODO: Traverse to the correct position
        // TODO: Return the data
        
        // HINT:
        // 1. Start with current = head
        // 2. Loop index times: current = current.next
        // 3. Return current.data
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * Returns the first element without removing it
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    public T peekFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }
    
    /**
     * Checks if the list contains the specified element
     * @param data the element to search for
     * @return true if the element is found
     */
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Returns a string representation of the list
     * @return string representation in format: [element1, element2, ...]
     */
    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
}

// =============================================================================
// Doubly Linked List Implementation
// =============================================================================

/**
 * A generic doubly linked list implementation
 */
class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;
    
    /**
     * Constructs an empty doubly linked list
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Returns the number of elements in the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Checks if the list is empty
     * @return true if the list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * TODO: Adds an element to the beginning of the list
     * Time Complexity: O(1)
     * 
     * @param data the element to add
     */
    public void addFirst(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);
        
        if (head == null) {
            // TODO: Handle empty list case
            // TODO: Set both head and tail to newNode
            // HINT: When empty, newNode becomes both head and tail
        } else {
            // TODO: Connect new node to existing head
            // TODO: Update previous pointers
            // TODO: Update head reference
            // HINT:
            // 1. newNode.next = head
            // 2. head.prev = newNode
            // 3. head = newNode
        }
        // TODO: Update size
    }
    
    /**
     * TODO: Adds an element to the end of the list
     * Time Complexity: O(1)
     * 
     * @param data the element to add
     */
    public void addLast(T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);
        
        if (tail == null) {
            // TODO: Handle empty list case
            // HINT: Same as addFirst for empty list
        } else {
            // TODO: Connect new node to existing tail
            // TODO: Update next pointers
            // TODO: Update tail reference
            // HINT:
            // 1. newNode.prev = tail
            // 2. tail.next = newNode
            // 3. tail = newNode
        }
        // TODO: Update size
    }
    
    /**
     * TODO: Removes and returns the first element
     * Time Complexity: O(1)
     * 
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        
        // TODO: Store data to return
        
        if (size == 1) {
            // TODO: Handle single element case
            // HINT: Set both head and tail to null
        } else {
            // TODO: Update head and previous pointers
            // HINT:
            // 1. head = head.next
            // 2. head.prev = null
        }
        
        // TODO: Update size
        // TODO: Return stored data
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * TODO: Removes and returns the last element
     * Time Complexity: O(1)
     * 
     * @return the last element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        
        // TODO: Store data to return
        
        if (size == 1) {
            // TODO: Handle single element case
            // HINT: Set both head and tail to null
        } else {
            // TODO: Update tail and previous pointers
            // HINT:
            // 1. tail = tail.prev
            // 2. tail.next = null
        }
        
        // TODO: Update size
        // TODO: Return stored data
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * TODO: Inserts an element at the specified index
     * Time Complexity: O(n)
     * 
     * @param index the index to insert at
     * @param data the element to insert
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void insert(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            DoublyNode<T> newNode = new DoublyNode<>(data);
            
            // TODO: Traverse to insertion point
            // TODO: Create new node and update all pointers
            // TODO: Update size
            
            // HINT:
            // 1. Traverse to find the node at position index
            // 2. Insert newNode between current.prev and current
            // 3. Update all four pointers: prev.next, current.prev, newNode.next, newNode.prev
        }
    }
    
    /**
     * Returns the element at the specified index
     * Time Complexity: O(n)
     * 
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        DoublyNode<T> current;
        
        // Optimization: traverse from head or tail depending on index
        if (index < size / 2) {
            // Traverse from head
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // Traverse from tail
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        return current.data;
    }
    
    /**
     * TODO: Prints the list from head to tail
     */
    public void printForward() {
        System.out.print("Forward: ");
        DoublyNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * TODO: Prints the list from tail to head
     */
    public void printBackward() {
        System.out.print("Backward: ");
        // TODO: Start from tail and traverse using prev pointers
        // HINT: Similar to printForward but start with tail and use prev
    }
    
    /**
     * Returns a string representation of the list
     * @return string representation in format: [element1, element2, ...]
     */
    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        DoublyNode<T> current = head;
        
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
}