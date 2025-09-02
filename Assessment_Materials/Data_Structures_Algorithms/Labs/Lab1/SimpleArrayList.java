/**
 * A simple implementation of a dynamic array list using a generic array.
 * This implementation automatically resizes when the internal array becomes full.
 * 
 * @param <T> the type of elements stored in this list
 * @author [Your Name Here]
 * @version Lab 1
 */
public class SimpleArrayList<T> implements SimpleList<T> {
    
    /** Default initial capacity of the internal array */
    private static final int DEFAULT_CAPACITY = 10;
    
    /** The internal array that stores the list elements */
    private T[] data;
    
    /** The current number of elements in the list */
    private int size;
    
    /**
     * Constructs a new SimpleArrayList with default initial capacity.
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayList() {
        // TODO: Initialize the data array with DEFAULT_CAPACITY
        // Hint: You'll need to cast Object[] to T[] due to generic array limitations
        // data = (T[]) new Object[DEFAULT_CAPACITY];
        // TODO: Initialize size to 0
    }
    
    /**
     * Constructs a new SimpleArrayList with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayList(int initialCapacity) {
        // TODO: Check if initialCapacity is valid
        // TODO: Initialize the data array with the specified capacity
        // TODO: Initialize size to 0
    }
    
    /**
     * Adds an element to the end of the list.
     * Automatically resizes the internal array if necessary.
     * 
     * @param element the element to add to the list
     */
    @Override
    public void add(T element) {
        // TODO: Check if the array needs to be resized
        // Hint: if (size >= data.length) { resize(); }
        
        // TODO: Add the element to the array at the current size index
        // TODO: Increment the size
    }
    
    /**
     * Returns the element at the specified index.
     * 
     * @param index the index of the element to return (0-based)
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public T get(int index) {
        // TODO: Check if the index is valid
        // Hint: if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(...); }
        
        // TODO: Return the element at the specified index
        return null; // Replace this line
    }
    
    /**
     * Returns the number of elements currently in the list.
     * 
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        // TODO: Return the current size
        return -1; // Replace this line
    }
    
    /**
     * Returns true if the list contains no elements.
     * 
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        // TODO: Return true if size is 0, false otherwise
        return false; // Replace this line
    }
    
    /**
     * Doubles the capacity of the internal array.
     * This is a private helper method called when the array becomes full.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        // TODO: Create a new array with double the current capacity
        // TODO: Copy all existing elements to the new array
        // TODO: Update the data reference to point to the new array
        
        // Hint: You can use System.arraycopy() or a simple loop
        // System.arraycopy(data, 0, newArray, 0, size);
    }
    
    /**
     * Returns a string representation of the list.
     * This method is provided for debugging purposes.
     * 
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}