/**
 * HashEntry represents a key-value pair in a hash table.
 * This class supports both separate chaining and open addressing strategies.
 * 
 * For separate chaining: Used as nodes in linked lists
 * For open addressing: Used directly in array slots with deletion marking
 * 
 * @param <T> the type of values stored in the hash table
 * @author Student Name
 * @version Lab 9 - Hash Table Implementation
 */
public class HashEntry<T> {
    
    // Instance variables
    private String key;           // The search key
    private T value;             // The associated value
    private boolean isDeleted;   // Flag for lazy deletion (open addressing)
    private HashEntry<T> next;   // Next node in chain (separate chaining)
    
    /**
     * Constructor for creating a new hash entry.
     * 
     * @param key the search key (must not be null)
     * @param value the associated value
     */
    public HashEntry(String key, T value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        this.key = key;
        this.value = value;
        this.isDeleted = false;
        this.next = null;
    }
    
    /**
     * Constructor for creating a hash entry with chain reference.
     * Used primarily in separate chaining implementation.
     * 
     * @param key the search key
     * @param value the associated value
     * @param next the next entry in the chain
     */
    public HashEntry(String key, T value, HashEntry<T> next) {
        this(key, value);
        this.next = next;
    }
    
    // =====================================================
    // ACCESSOR METHODS
    // =====================================================
    
    /**
     * Returns the key for this entry.
     * 
     * @return the search key
     */
    public String getKey() {
        return key;
    }
    
    /**
     * Returns the value for this entry.
     * 
     * @return the associated value
     */
    public T getValue() {
        return value;
    }
    
    /**
     * Sets the value for this entry.
     * Used when updating an existing key's value.
     * 
     * @param value the new value to associate with this key
     */
    public void setValue(T value) {
        this.value = value;
    }
    
    /**
     * Returns the next entry in the chain.
     * Used in separate chaining implementation.
     * 
     * @return the next HashEntry, or null if this is the last in chain
     */
    public HashEntry<T> getNext() {
        return next;
    }
    
    /**
     * Sets the next entry in the chain.
     * Used in separate chaining implementation.
     * 
     * @param next the next HashEntry in the chain
     */
    public void setNext(HashEntry<T> next) {
        this.next = next;
    }
    
    /**
     * Returns whether this entry has been deleted.
     * Used in open addressing with lazy deletion.
     * 
     * @return true if this entry is marked as deleted, false otherwise
     */
    public boolean isDeleted() {
        return isDeleted;
    }
    
    /**
     * Marks this entry as deleted.
     * Used in open addressing to maintain probe sequences.
     * 
     * @param deleted true to mark as deleted, false to unmark
     */
    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }
    
    // =====================================================
    // UTILITY METHODS
    // =====================================================
    
    /**
     * Checks if this entry is active (not deleted).
     * Convenience method for open addressing.
     * 
     * @return true if entry is not deleted, false otherwise
     */
    public boolean isActive() {
        return !isDeleted;
    }
    
    /**
     * Checks if this entry has the specified key.
     * Handles null keys appropriately.
     * 
     * @param searchKey the key to compare against
     * @return true if keys match, false otherwise
     */
    public boolean hasKey(String searchKey) {
        if (searchKey == null) {
            return false;
        }
        return key.equals(searchKey);
    }
    
    /**
     * Creates a copy of this hash entry.
     * Useful for rehashing operations.
     * 
     * @return a new HashEntry with the same key and value
     */
    public HashEntry<T> copy() {
        HashEntry<T> copy = new HashEntry<>(key, value);
        copy.isDeleted = this.isDeleted;
        // Note: next reference is not copied (used for creating new chains)
        return copy;
    }
    
    /**
     * Returns a string representation of this entry.
     * Useful for debugging and testing.
     * 
     * @return string representation showing key, value, and status
     */
    @Override
    public String toString() {
        String status = isDeleted ? " (DELETED)" : "";
        return String.format("HashEntry{key='%s', value=%s%s}", key, value, status);
    }
    
    /**
     * Returns a detailed string representation including chain information.
     * Useful for debugging chaining implementations.
     * 
     * @return detailed string representation
     */
    public String toDetailedString() {
        String nextInfo = (next != null) ? " -> " + next.key : " -> null";
        String status = isDeleted ? " (DELETED)" : "";
        return String.format("HashEntry{key='%s', value=%s%s}%s", 
                           key, value, status, nextInfo);
    }
    
    /**
     * Compares this entry with another object for equality.
     * Two entries are equal if they have the same key.
     * 
     * @param obj the object to compare with
     * @return true if the objects have the same key, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        HashEntry<?> that = (HashEntry<?>) obj;
        return key.equals(that.key);
    }
    
    /**
     * Returns the hash code for this entry based on its key.
     * 
     * @return hash code value for this entry
     */
    @Override
    public int hashCode() {
        return key.hashCode();
    }
    
    // =====================================================
    // CHAIN MANIPULATION METHODS (for separate chaining)
    // =====================================================
    
    /**
     * Searches for a key in the chain starting from this entry.
     * 
     * @param searchKey the key to search for
     * @return the HashEntry with the matching key, or null if not found
     */
    public HashEntry<T> findInChain(String searchKey) {
        HashEntry<T> current = this;
        while (current != null) {
            if (!current.isDeleted && current.hasKey(searchKey)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    /**
     * Adds a new entry to the beginning of the chain.
     * 
     * @param newEntry the entry to add to the chain
     * @return the new head of the chain
     */
    public HashEntry<T> addToChain(HashEntry<T> newEntry) {
        newEntry.next = this;
        return newEntry;
    }
    
    /**
     * Removes an entry with the specified key from the chain.
     * 
     * @param keyToRemove the key of the entry to remove
     * @return the new head of the chain after removal
     */
    public HashEntry<T> removeFromChain(String keyToRemove) {
        // If this entry should be removed
        if (this.hasKey(keyToRemove) && !this.isDeleted) {
            return this.next;  // Return the rest of the chain
        }
        
        // Search through the rest of the chain
        HashEntry<T> current = this;
        while (current.next != null) {
            if (current.next.hasKey(keyToRemove) && !current.next.isDeleted) {
                current.next = current.next.next;  // Skip the entry to remove
                break;
            }
            current = current.next;
        }
        
        return this;  // Return original head
    }
    
    /**
     * Gets the length of the chain starting from this entry.
     * Only counts active (non-deleted) entries.
     * 
     * @return the number of active entries in the chain
     */
    public int getChainLength() {
        int length = 0;
        HashEntry<T> current = this;
        while (current != null) {
            if (!current.isDeleted) {
                length++;
            }
            current = current.next;
        }
        return length;
    }
    
    /**
     * Gets the total length of the chain including deleted entries.
     * Useful for analyzing chain efficiency.
     * 
     * @return the total number of entries in the chain
     */
    public int getTotalChainLength() {
        int length = 0;
        HashEntry<T> current = this;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    /**
     * Checks if the chain contains any deleted entries.
     * 
     * @return true if any entry in the chain is marked as deleted
     */
    public boolean hasDeletedInChain() {
        HashEntry<T> current = this;
        while (current != null) {
            if (current.isDeleted) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Creates a string representation of the entire chain.
     * Useful for debugging chaining behavior.
     * 
     * @return string showing all entries in the chain
     */
    public String chainToString() {
        StringBuilder sb = new StringBuilder();
        HashEntry<T> current = this;
        sb.append("[");
        
        while (current != null) {
            if (sb.length() > 1) {
                sb.append(" -> ");
            }
            sb.append(current.toString());
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
}