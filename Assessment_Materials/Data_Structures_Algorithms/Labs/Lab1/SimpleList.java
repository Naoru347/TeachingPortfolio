/**
 * A simple generic list interface for basic data structure operations.
 * This interface defines the contract for a list data structure that can
 * store elements of any type.
 * 
 * @param <T> the type of elements stored in this list
 * @author CSC 220 Student
 * @version Lab 1
 */
public interface SimpleList<T> {
    
    /**
     * Adds an element to the end of the list.
     * The list should automatically resize if necessary.
     * 
     * @param element the element to add to the list
     */
    void add(T element);
    
    /**
     * Returns the element at the specified index.
     * 
     * @param index the index of the element to return (0-based)
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is negative or >= size()
     */
    T get(int index);
    
    /**
     * Returns the number of elements currently in the list.
     * 
     * @return the number of elements in the list
     */
    int size();
    
    /**
     * Returns true if the list contains no elements.
     * 
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();
}