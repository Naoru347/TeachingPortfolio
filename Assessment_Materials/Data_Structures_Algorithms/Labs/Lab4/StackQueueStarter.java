import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * StackQueueStarter - Lab 4 Starter Code
 * 
 * This file provides ADT interfaces and implementation skeletons for both
 * array-based and linked-based stacks and queues. Students will complete
 * the TODOs to implement LIFO and FIFO behavior.
 * 
 * @author CSC 220 Teaching Team
 * @version Lab 4 - Fall 2025
 */

// =============================================================================
// ADT Interface Definitions
// =============================================================================

/**
 * Stack ADT interface - LIFO (Last In, First Out) behavior
 */
interface Stack<T> {
    /**
     * Adds an item to the top of the stack
     * @param item the item to add
     */
    void push(T item);
    
    /**
     * Removes and returns the top item from the stack
     * @return the top item
     * @throws EmptyStackException if the stack is empty
     */
    T pop();
    
    /**
     * Returns the top item without removing it
     * @return the top item
     * @throws EmptyStackException if the stack is empty
     */
    T peek();
    
    /**
     * Checks if the stack is empty
     * @return true if the stack contains no items
     */
    boolean isEmpty();
    
    /**
     * Returns the number of items in the stack
     * @return the number of items
     */
    int size();
}

/**
 * Queue ADT interface - FIFO (First In, First Out) behavior
 */
interface Queue<T> {
    /**
     * Adds an item to the rear of the queue
     * @param item the item to add
     */
    void enqueue(T item);
    
    /**
     * Removes and returns the front item from the queue
     * @return the front item
     * @throws NoSuchElementException if the queue is empty
     */
    T dequeue();
    
    /**
     * Returns the front item without removing it
     * @return the front item
     * @throws NoSuchElementException if the queue is empty
     */
    T front();
    
    /**
     * Checks if the queue is empty
     * @return true if the queue contains no items
     */
    boolean isEmpty();
    
    /**
     * Returns the number of items in the queue
     * @return the number of items
     */
    int size();
}

// =============================================================================
// Node Class for Linked Implementations
// =============================================================================

/**
 * Simple node class for linked implementations
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

// =============================================================================
// Array-Based Stack Implementation
// =============================================================================

/**
 * Array-based implementation of Stack ADT
 */
public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    
    private T[] data;
    private int size;
    private int capacity;
    
    /**
     * Constructs an empty stack with default capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        capacity = DEFAULT_CAPACITY;
        data = (T[]) new Object[capacity];
        size = 0;
    }
    
    /**
     * Constructs an empty stack with specified capacity
     * @param initialCapacity the initial capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        capacity = initialCapacity;
        data = (T[]) new Object[capacity];
        size = 0;
    }
    
    /**
     * TODO: Adds an item to the top of the stack
     * Time Complexity: O(1) amortized (O(n) when resizing needed)
     * 
     * @param item the item to add
     */
    @Override
    public void push(T item) {
        if (size == capacity) {
            // TODO: Handle array full case - resize or throw exception
            // DECISION: Should you resize automatically or throw exception?
            // HINT: Most implementations resize automatically
            resize();
        }
        
        // TODO: Add item to top of stack
        // TODO: Update size
        
        // DESIGN QUESTION: Where is the "top" of your stack?
        // Option A: top at index 0 (requires shifting)
        // Option B: top at index size-1 (just increment)
        // Which is more efficient?
        
        // HINT: Choose Option B for O(1) performance
        // data[size] = item;
        // size++;
    }
    
    /**
     * TODO: Removes and returns the top item from the stack
     * Time Complexity: O(1)
     * 
     * @return the top item
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        // TODO: Get item from top (remember where your top is!)
        // TODO: Update size
        // TODO: Set array slot to null (prevent memory leaks)
        // TODO: Return the item
        
        // HINT: If top is at size-1:
        // size--;
        // T item = data[size];
        // data[size] = null;  // Important for garbage collection!
        // return item;
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * TODO: Returns the top item without removing it
     * Time Complexity: O(1)
     * 
     * @return the top item
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        // TODO: Return top item without modifying stack
        // HINT: If top is at size-1: return data[size-1];
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * Checks if the stack is empty
     * @return true if the stack contains no items
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the number of items in the stack
     * @return the number of items
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * TODO: Resizes the array when capacity is reached
     * This is a private helper method
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        // TODO: Create new array with larger capacity (typically double)
        // TODO: Copy all existing elements to new array
        // TODO: Update capacity and data reference
        
        // HINT:
        // int newCapacity = capacity * 2;
        // T[] newData = (T[]) new Object[newCapacity];
        // for (int i = 0; i < size; i++) {
        //     newData[i] = data[i];
        // }
        // data = newData;
        // capacity = newCapacity;
    }
    
    /**
     * Returns a string representation of the stack
     * @return string representation with top element first
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack: []";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        
        // Show from top to bottom (reverse order from array)
        for (int i = size - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        
        sb.append("] <-- top");
        return sb.toString();
    }
}

// =============================================================================
// Linked-Based Stack Implementation
// =============================================================================

/**
 * Linked-list based implementation of Stack ADT
 */
class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;
    
    /**
     * Constructs an empty stack
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }
    
    /**
     * TODO: Adds an item to the top of the stack
     * Time Complexity: O(1)
     * 
     * @param item the item to add
     */
    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        
        // TODO: Link new node to current top
        // TODO: Update top reference
        // TODO: Update size
        
        // HINT: Should you add at head or tail of linked list?
        // Answer: Head! Because we need O(1) access to top element
        
        // newNode.next = top;
        // top = newNode;
        // size++;
    }
    
    /**
     * TODO: Removes and returns the top item from the stack
     * Time Complexity: O(1)
     * 
     * @return the top item
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        // TODO: Get data from top node
        // TODO: Update top to next node
        // TODO: Update size
        // TODO: Return the data
        
        // HINT:
        // T item = top.data;
        // top = top.next;
        // size--;
        // return item;
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * TODO: Returns the top item without removing it
     * Time Complexity: O(1)
     * 
     * @return the top item
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        // TODO: Return top item without modifying stack
        // HINT: return top.data;
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * Checks if the stack is empty
     * @return true if the stack contains no items
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * Returns the number of items in the stack
     * @return the number of items
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Returns a string representation of the stack
     * @return string representation with top element first
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack: []";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("] <-- top");
        return sb.toString();
    }
}

// =============================================================================
// Array-Based Queue Implementation (Circular Buffer)
// =============================================================================

/**
 * Array-based implementation of Queue ADT using circular buffer
 */
class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    
    private T[] data;
    private int front;      // Index of first element
    private int rear;       // Index where next element will be added
    private int size;
    private int capacity;
    
    /**
     * Constructs an empty queue with default capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        capacity = DEFAULT_CAPACITY;
        data = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }
    
    /**
     * TODO: Adds an item to the rear of the queue
     * Time Complexity: O(1) amortized
     * 
     * @param item the item to add
     */
    @Override
    public void enqueue(T item) {
        if (size == capacity) {
            // TODO: Handle full queue - resize or throw exception
            resize();
        }
        
        // TODO: Add item at rear position
        // TODO: Update rear index with wraparound
        // TODO: Update size
        
        // HINT: Circular buffer logic
        // data[rear] = item;
        // rear = (rear + 1) % capacity;  // Wraparound magic!
        // size++;
    }
    
    /**
     * TODO: Removes and returns the front item from the queue
     * Time Complexity: O(1)
     * 
     * @return the front item
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        // TODO: Get item from front position
        // TODO: Set array slot to null (prevent memory leaks)
        // TODO: Update front index with wraparound
        // TODO: Update size
        // TODO: Return the item
        
        // HINT: Circular buffer logic
        // T item = data[front];
        // data[front] = null;  // Important for garbage collection!
        // front = (front + 1) % capacity;  // Wraparound magic!
        // size--;
        // return item;
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * TODO: Returns the front item without removing it
     * Time Complexity: O(1)
     * 
     * @return the front item
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        // TODO: Return front item without modifying queue
        // HINT: return data[front];
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * Checks if the queue is empty
     * @return true if the queue contains no items
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the number of items in the queue
     * @return the number of items
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * TODO: Resizes the array when capacity is reached
     * This is trickier for circular buffers!
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        // TODO: Create new array with larger capacity
        // TODO: Copy elements in correct order (front to rear)
        // TODO: Reset front and rear indices
        // TODO: Update capacity
        
        // HINT: The tricky part is maintaining order when copying
        // int newCapacity = capacity * 2;
        // T[] newData = (T[]) new Object[newCapacity];
        // 
        // // Copy elements in order from front to rear
        // for (int i = 0; i < size; i++) {
        //     newData[i] = data[(front + i) % capacity];
        // }
        // 
        // data = newData;
        // front = 0;
        // rear = size;
        // capacity = newCapacity;
    }
    
    /**
     * Returns a string representation of the queue
     * @return string representation with front element first
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue: []";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        
        // Show from front to rear
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            sb.append(data[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("] front->rear");
        return sb.toString();
    }
}

// =============================================================================
// Linked-Based Queue Implementation
// =============================================================================

/**
 * Linked-list based implementation of Queue ADT
 */
class LinkedQueue<T> implements Queue<T> {
    private Node<T> head;   // Front of queue (dequeue here)
    private Node<T> tail;   // Rear of queue (enqueue here)
    private int size;
    
    /**
     * Constructs an empty queue
     */
    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * TODO: Adds an item to the rear of the queue
     * Time Complexity: O(1)
     * 
     * @param item the item to add
     */
    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        
        if (isEmpty()) {
            // TODO: Handle empty queue case
            // HINT: Both head and tail point to new node
            // head = tail = newNode;
        } else {
            // TODO: Add to tail and update tail pointer
            // HINT: 
            // tail.next = newNode;
            // tail = newNode;
        }
        
        // TODO: Update size
        // size++;
    }
    
    /**
     * TODO: Removes and returns the front item from the queue
     * Time Complexity: O(1)
     * 
     * @return the front item
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        // TODO: Get data from head
        // TODO: Update head pointer
        // TODO: Handle single-element case (update tail too)
        // TODO: Update size
        // TODO: Return data
        
        // HINT:
        // T item = head.data;
        // head = head.next;
        // 
        // if (head == null) {  // Was the last element
        //     tail = null;
        // }
        // 
        // size--;
        // return item;
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * TODO: Returns the front item without removing it
     * Time Complexity: O(1)
     * 
     * @return the front item
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        // TODO: Return front item without modifying queue
        // HINT: return head.data;
        
        return null; // Placeholder - remove this line
    }
    
    /**
     * Checks if the queue is empty
     * @return true if the queue contains no items
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Returns the number of items in the queue
     * @return the number of items
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Returns a string representation of the queue
     * @return string representation with front element first
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue: []";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("] front->rear");
        return sb.toString();
    }
}

// =============================================================================
// Application Examples
// =============================================================================

/**
 * Example applications demonstrating stack and queue usage
 */
class StackQueueApplications {
    
    /**
     * TODO: Balanced parentheses checker using stack
     * @param expression the expression to check
     * @return true if parentheses are balanced
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new ArrayStack<>();
        
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // TODO: Push opening bracket
                // stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // TODO: Check if matches top of stack
                // TODO: Handle unmatched closing bracket
                
                // HINT:
                // if (stack.isEmpty()) return false;
                // char open = stack.pop();
                // if (!matches(open, c)) return false;
            }
            // Ignore other characters
        }
        
        // TODO: Return true if stack is empty (all matched)
        return false; // Placeholder
    }
    
    /**
     * Helper method to check if brackets match
     */
    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
    
    /**
     * Simple text editor with undo functionality
     */
    static class TextEditor {
        private Stack<String> undoStack = new LinkedStack<>();
        private String currentText = "";
        
        public void type(String text) {
            // TODO: Save current state to undo stack
            // TODO: Update current text
            // undoStack.push(currentText);
            // currentText += text;
        }
        
        public void undo() {
            // TODO: Restore previous state from stack
            // TODO: Handle case where no undo available
            // if (!undoStack.isEmpty()) {
            //     currentText = undoStack.pop();
            // }
        }
        
        public String getText() {
            return currentText;
        }
    }
    
    /**
     * Print job scheduler using queue
     */
    static class PrintQueue {
        private Queue<String> jobs = new LinkedQueue<>();
        
        public void submitJob(String jobName) {
            // TODO: Add job to queue
            // jobs.enqueue(jobName);
            System.out.println("Job submitted: " + jobName);
        }
        
        public void processNext() {
            // TODO: Process next job in FIFO order
            // TODO: Handle empty queue case
            // if (!jobs.isEmpty()) {
            //     String job = jobs.dequeue();
            //     System.out.println("Processing job: " + job);
            // } else {
            //     System.out.println("No jobs to process");
            // }
        }
        
        public int getJobCount() {
            return jobs.size();
        }
    }
}

// =============================================================================
// Main Class for Testing
// =============================================================================

/**
 * Main class for basic testing - use StackQueueTester for comprehensive tests
 */
class StackQueueMain {
    public static void main(String[] args) {
        System.out.println("CSC 220 Lab 4 - Stack and Queue Implementation");
        System.out.println("===============================================");
        
        // Quick test of ArrayStack
        System.out.println("\n--- Testing ArrayStack ---");
        Stack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("First");
        arrayStack.push("Second");
        arrayStack.push("Third");
        
        System.out.println("Stack after pushes: " + arrayStack);
        System.out.println("Peek: " + arrayStack.peek());
        System.out.println("Pop: " + arrayStack.pop());
        System.out.println("Stack after pop: " + arrayStack);
        
        // Quick test of LinkedQueue
        System.out.println("\n--- Testing LinkedQueue ---");
        Queue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        
        System.out.println("Queue after enqueues: " + linkedQueue);
        System.out.println("Front: " + linkedQueue.front());
        System.out.println("Dequeue: " + linkedQueue.dequeue());
        System.out.println("Queue after dequeue: " + linkedQueue);
        
        // Test applications
        System.out.println("\n--- Testing Applications ---");
        
        // Balanced parentheses
        System.out.println("isBalanced('()'): " + StackQueueApplications.isBalanced("()"));
        System.out.println("isBalanced('([)]'): " + StackQueueApplications.isBalanced("([)]"));
        
        // Text editor
        StackQueueApplications.TextEditor editor = new StackQueueApplications.TextEditor();
        editor.type("Hello");
        editor.type(" World");
        System.out.println("Editor text: '" + editor.getText() + "'");
        editor.undo();
        System.out.println("After undo: '" + editor.getText() + "'");
        
        // Print queue
        StackQueueApplications.PrintQueue printer = new StackQueueApplications.PrintQueue();
        printer.submitJob("Document1.pdf");
        printer.submitJob("Photo.jpg");
        printer.processNext();
        System.out.println("Jobs remaining: " + printer.getJobCount());
        
        System.out.println("\nBasic tests completed. Run StackQueueTester for comprehensive testing.");
    }
}