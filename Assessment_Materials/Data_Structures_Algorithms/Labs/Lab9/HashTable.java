import java.util.ArrayList;
import java.util.List;

/**
 * Hash Table implementation supporting both separate chaining and open addressing.
 * 
 * This class provides O(1) average-case performance for put, get, and remove operations
 * through efficient hash-based storage. Students will implement both collision
 * resolution strategies and analyze their performance characteristics.
 * 
 * Features:
 * - Multiple hash functions
 * - Separate chaining with linked lists
 * - Open addressing with linear probing
 * - Dynamic resizing with rehashing
 * - Load factor analysis and optimization
 * 
 * @param <T> the type of values stored in the hash table
 * @author Student Name
 * @version Lab 9 - Hash Table Implementation
 */
public class HashTable<T> {
    
    // Default constants
    private static final int DEFAULT_CAPACITY = 11;  // Prime number for better distribution
    private static final double DEFAULT_LOAD_FACTOR_THRESHOLD = 0.75;
    private static final int HASH_FUNCTION_POLYNOMIAL = 1;  // Default hash function
    
    // Instance variables for separate chaining
    private HashEntry<T>[] chainingTable;
    private int chainingSize;
    private int chainingCapacity;
    
    // Instance variables for open addressing  
    private HashEntry<T>[] probingTable;
    private int probingSize;
    private int probingCapacity;
    
    // Common settings
    private double loadFactorThreshold;
    private int hashFunction;
    private boolean useChaining;  // true for chaining, false for open addressing
    
    // Statistics tracking
    private int totalCollisions;
    private int resizeCount;
    private long totalProbeDistance;
    
    /**
     * Constructor for hash table with default settings.
     * Uses separate chaining by default.
     */
    public HashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR_THRESHOLD, true);
    }
    
    /**
     * Constructor specifying collision resolution strategy.
     * 
     * @param useChaining true for separate chaining, false for open addressing
     */
    public HashTable(boolean useChaining) {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR_THRESHOLD, useChaining);
    }
    
    /**
     * Constructor with full customization.
     * 
     * @param capacity initial capacity of hash table
     * @param loadFactorThreshold when to trigger resize (0.0 to 1.0)
     * @param useChaining collision resolution strategy
     */
    public HashTable(int capacity, double loadFactorThreshold, boolean useChaining) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        if (loadFactorThreshold <= 0 || loadFactorThreshold > 1.0) {
            throw new IllegalArgumentException("Load factor must be between 0 and 1");
        }
        
        this.loadFactorThreshold = loadFactorThreshold;
        this.useChaining = useChaining;
        this.hashFunction = HASH_FUNCTION_POLYNOMIAL;
        this.totalCollisions = 0;
        this.resizeCount = 0;
        this.totalProbeDistance = 0;
        
        if (useChaining) {
            initializeChaining(capacity);
        } else {
            initializeProbing(capacity);
        }
    }
    
    // =====================================================
    // INITIALIZATION METHODS
    // =====================================================
    
    /**
     * Initializes data structures for separate chaining.
     * 
     * @param capacity initial table capacity
     */
    @SuppressWarnings("unchecked")
    private void initializeChaining(int capacity) {
        this.chainingCapacity = capacity;
        this.chainingSize = 0;
        this.chainingTable = (HashEntry<T>[]) new HashEntry[capacity];
        // Array elements are automatically initialized to null
    }
    
    /**
     * Initializes data structures for open addressing.
     * 
     * @param capacity initial table capacity
     */
    @SuppressWarnings("unchecked")
    private void initializeProbing(int capacity) {
        this.probingCapacity = capacity;
        this.probingSize = 0;
        this.probingTable = (HashEntry<T>[]) new HashEntry[capacity];
        // Array elements are automatically initialized to null
    }
    
    // =====================================================
    // HASH FUNCTION METHODS
    // =====================================================
    
    /**
     * Computes hash index for a given key.
     * 
     * @param key the key to hash
     * @return index in range [0, capacity-1]
     */
    private int hash(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        int capacity = useChaining ? chainingCapacity : probingCapacity;
        
        // TODO: Implement hash function selection
        // Use the hashFunction instance variable to choose which function to use
        // Call appropriate method from HashFunctions class
        // Ensure result is in range [0, capacity-1]
        
        return Math.abs(key.hashCode()) % capacity;  // Placeholder - replace with your implementation
    }
    
    /**
     * Sets which hash function to use (1-5).
     * 
     * @param functionNumber hash function identifier
     */
    public void setHashFunction(int functionNumber) {
        if (functionNumber < 1 || functionNumber > 5) {
            throw new IllegalArgumentException("Hash function must be 1-5");
        }
        this.hashFunction = functionNumber;
    }
    
    // =====================================================
    // SEPARATE CHAINING IMPLEMENTATION
    // =====================================================
    
    /**
     * Inserts or updates a key-value pair using separate chaining.
     * 
     * @param key the key to insert/update
     * @param value the value to associate with the key
     * @return the previous value associated with key, or null if new key
     */
    private T putChaining(String key, T value) {
        // TODO: Implement separate chaining insertion
        // 1. Calculate hash index for the key
        // 2. If no chain exists at index, create new entry
        // 3. If chain exists, search for existing key
        // 4. If key found, update value and return old value
        // 5. If key not found, add new entry to front of chain
        // 6. Update size and check if resize is needed
        // 7. Return null for new insertions
        
        return null; // Replace with your implementation
    }
    
    /**
     * Retrieves value associated with key using separate chaining.
     * 
     * @param key the key to search for
     * @return the value associated with key, or null if not found
     */
    private T getChaining(String key) {
        // TODO: Implement separate chaining retrieval
        // 1. Calculate hash index for the key
        // 2. Get the chain head at that index
        // 3. Search through the chain for the key
        // 4. Return value if found, null otherwise
        
        return null; // Replace with your implementation
    }
    
    /**
     * Removes key-value pair using separate chaining.
     * 
     * @param key the key to remove
     * @return the value that was associated with key, or null if not found
     */
    private T removeChaining(String key) {
        // TODO: Implement separate chaining removal
        // 1. Calculate hash index for the key
        // 2. Get the chain head at that index
        // 3. Search through chain and remove entry if found
        // 4. Update chain head and size
        // 5. Return removed value or null if not found
        
        return null; // Replace with your implementation
    }
    
    // =====================================================
    // OPEN ADDRESSING IMPLEMENTATION
    // =====================================================
    
    /**
     * Finds the appropriate slot for a key using linear probing.
     * 
     * @param key the key to find slot for
     * @param forInsertion true if finding slot for insertion, false for search
     * @return index of slot, or -1 if table is full (insertion only)
     */
    private int findSlot(String key, boolean forInsertion) {
        // TODO: Implement linear probing slot finding
        // 1. Calculate initial hash index
        // 2. Use linear probing to find appropriate slot
        // 3. For insertion: find empty or deleted slot
        // 4. For search: find slot with matching key or stop at empty
        // 5. Handle wraparound (use modulo)
        // 6. Detect when table is full during insertion
        // 7. Track probe distance for statistics
        
        return -1; // Replace with your implementation
    }
    
    /**
     * Inserts or updates a key-value pair using open addressing.
     * 
     * @param key the key to insert/update
     * @param value the value to associate with the key
     * @return the previous value associated with key, or null if new key
     */
    private T putProbing(String key, T value) {
        // TODO: Implement open addressing insertion
        // 1. Find appropriate slot using findSlot
        // 2. If slot has matching key, update value
        // 3. If slot is empty or deleted, create new entry
        // 4. Update size and check if resize is needed
        // 5. Return previous value or null for new keys
        
        return null; // Replace with your implementation
    }
    
    /**
     * Retrieves value associated with key using open addressing.
     * 
     * @param key the key to search for
     * @return the value associated with key, or null if not found
     */
    private T getProbing(String key) {
        // TODO: Implement open addressing retrieval
        // 1. Find slot using findSlot with forInsertion = false
        // 2. If slot found and entry is active, return value
        // 3. Otherwise return null
        
        return null; // Replace with your implementation
    }
    
    /**
     * Removes key-value pair using open addressing with lazy deletion.
     * 
     * @param key the key to remove
     * @return the value that was associated with key, or null if not found
     */
    private T removeProbing(String key) {
        // TODO: Implement open addressing removal with lazy deletion
        // 1. Find slot containing the key
        // 2. If found, mark entry as deleted (don't remove immediately)
        // 3. Update size but keep entry in table
        // 4. Return the value that was removed
        
        return null; // Replace with your implementation
    }
    
    // =====================================================
    // PUBLIC INTERFACE METHODS
    // =====================================================
    
    /**
     * Associates the specified value with the specified key.
     * 
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or null if new key
     */
    public T put(String key, T value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        if (useChaining) {
            return putChaining(key, value);
        } else {
            return putProbing(key, value);
        }
    }
    
    /**
     * Returns the value to which the specified key is mapped.
     * 
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null
     */
    public T get(String key) {
        if (key == null) {
            return null;
        }
        
        if (useChaining) {
            return getChaining(key);
        } else {
            return getProbing(key);
        }
    }
    
    /**
     * Removes the mapping for the specified key.
     * 
     * @param key key whose mapping is to be removed
     * @return the previous value associated with key, or null
     */
    public T remove(String key) {
        if (key == null) {
            return null;
        }
        
        if (useChaining) {
            return removeChaining(key);
        } else {
            return removeProbing(key);
        }
    }
    
    /**
     * Returns true if this hash table contains a mapping for the specified key.
     * 
     * @param key key whose presence is to be tested
     * @return true if this hash table contains a mapping for the specified key
     */
    public boolean containsKey(String key) {
        return get(key) != null;
    }
    
    /**
     * Returns the number of key-value mappings in this hash table.
     * 
     * @return the number of key-value mappings in this hash table
     */
    public int size() {
        return useChaining ? chainingSize : probingSize;
    }
    
    /**
     * Returns true if this hash table contains no key-value mappings.
     * 
     * @return true if this hash table contains no key-value mappings
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Removes all mappings from this hash table.
     */
    public void clear() {
        if (useChaining) {
            chainingSize = 0;
            for (int i = 0; i < chainingCapacity; i++) {
                chainingTable[i] = null;
            }
        } else {
            probingSize = 0;
            for (int i = 0; i < probingCapacity; i++) {
                probingTable[i] = null;
            }
        }
        
        totalCollisions = 0;
        totalProbeDistance = 0;
    }
    
    // =====================================================
    // RESIZING AND REHASHING
    // =====================================================
    
    /**
     * Checks if the hash table needs to be resized.
     * 
     * @return true if current load factor exceeds threshold
     */
    private boolean needsResize() {
        double currentLoadFactor = getCurrentLoadFactor();
        return currentLoadFactor > loadFactorThreshold;
    }
    
    /**
     * Resizes the hash table and rehashes all entries.
     */
    private void resize() {
        // TODO: Implement resizing with rehashing
        // 1. Save reference to old table
        // 2. Create new table with roughly double capacity (use next prime)
        // 3. Rehash all existing entries into new table
        // 4. Update capacity and reset statistics
        // 5. Handle both chaining and probing cases
        
        resizeCount++;
    }
    
    /**
     * Finds the next prime number greater than or equal to n.
     * Used for choosing good table sizes.
     * 
     * @param n the minimum value
     * @return the next prime >= n
     */
    private int nextPrime(int n) {
        if (n <= 2) return 2;
        if (n % 2 == 0) n++;
        
        while (!isPrime(n)) {
            n += 2;
        }
        return n;
    }
    
    /**
     * Checks if a number is prime.
     * 
     * @param n the number to check
     * @return true if n is prime
     */
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    // =====================================================
    // STATISTICS AND ANALYSIS METHODS
    // =====================================================
    
    /**
     * Returns the current load factor.
     * 
     * @return current load factor (size / capacity)
     */
    public double getCurrentLoadFactor() {
        int capacity = useChaining ? chainingCapacity : probingCapacity;
        return (double) size() / capacity;
    }
    
    /**
     * Returns the current capacity of the hash table.
     * 
     * @return current capacity
     */
    public int getCapacity() {
        return useChaining ? chainingCapacity : probingCapacity;
    }
    
    /**
     * Returns statistics about hash table performance.
     * 
     * @return HashTableStats object containing performance metrics
     */
    public HashTableStats getStats() {
        int capacity = getCapacity();
        int size = size();
        double loadFactor = getCurrentLoadFactor();
        
        // Calculate collision statistics
        int emptySlots = 0;
        int maxChainLength = 0;
        double avgChainLength = 0.0;
        
        if (useChaining) {
            int totalChainLength = 0;
            int usedSlots = 0;
            
            for (int i = 0; i < chainingCapacity; i++) {
                if (chainingTable[i] == null) {
                    emptySlots++;
                } else {
                    usedSlots++;
                    int chainLength = chainingTable[i].getChainLength();
                    totalChainLength += chainLength;
                    maxChainLength = Math.max(maxChainLength, chainLength);
                }
            }
            
            avgChainLength = usedSlots > 0 ? (double) totalChainLength / usedSlots : 0.0;
        } else {
            for (int i = 0; i < probingCapacity; i++) {
                if (probingTable[i] == null || probingTable[i].isDeleted()) {
                    emptySlots++;
                }
            }
            avgChainLength = size > 0 ? (double) totalProbeDistance / size : 0.0;
        }
        
        return new HashTableStats(
            size, capacity, loadFactor, totalCollisions,
            emptySlots, maxChainLength, avgChainLength,
            resizeCount, useChaining
        );
    }
    
    /**
     * Returns a list of all keys in the hash table.
     * 
     * @return list of all keys
     */
    public List<String> getAllKeys() {
        List<String> keys = new ArrayList<>();
        
        if (useChaining) {
            for (int i = 0; i < chainingCapacity; i++) {
                HashEntry<T> current = chainingTable[i];
                while (current != null) {
                    if (!current.isDeleted()) {
                        keys.add(current.getKey());
                    }
                    current = current.getNext();
                }
            }
        } else {
            for (int i = 0; i < probingCapacity; i++) {
                if (probingTable[i] != null && !probingTable[i].isDeleted()) {
                    keys.add(probingTable[i].getKey());
                }
            }
        }
        
        return keys;
    }
    
    /**
     * Creates a visual representation of the hash table.
     * Useful for debugging and understanding distribution.
     */
    public void printTable() {
        System.out.println("Hash Table Contents (" + (useChaining ? "Chaining" : "Open Addressing") + "):");
        System.out.println("Size: " + size() + ", Capacity: " + getCapacity() + 
                          ", Load Factor: " + String.format("%.2f", getCurrentLoadFactor()));
        System.out.println();
        
        if (useChaining) {
            for (int i = 0; i < chainingCapacity; i++) {
                System.out.printf("[%2d]: ", i);
                if (chainingTable[i] == null) {
                    System.out.println("empty");
                } else {
                    System.out.println(chainingTable[i].chainToString());
                }
            }
        } else {
            for (int i = 0; i < probingCapacity; i++) {
                System.out.printf("[%2d]: ", i);
                if (probingTable[i] == null) {
                    System.out.println("empty");
                } else {
                    System.out.println(probingTable[i].toString());
                }
            }
        }
    }
    
    /**
     * Returns string representation of hash table.
     * 
     * @return string representation
     */
    @Override
    public String toString() {
        return String.format("HashTable{size=%d, capacity=%d, loadFactor=%.2f, strategy=%s}",
                           size(), getCapacity(), getCurrentLoadFactor(),
                           useChaining ? "Chaining" : "Open Addressing");
    }
    
    // =====================================================
    // HASH TABLE STATISTICS CLASS
    // =====================================================
    
    /**
     * Container class for hash table performance statistics.
     */
    public static class HashTableStats {
        private final int size;
        private final int capacity;
        private final double loadFactor;
        private final int totalCollisions;
        private final int emptySlots;
        private final int maxChainLength;
        private final double avgChainLength;
        private final int resizeCount;
        private final boolean useChaining;
        
        public HashTableStats(int size, int capacity, double loadFactor, int totalCollisions,
                            int emptySlots, int maxChainLength, double avgChainLength,
                            int resizeCount, boolean useChaining) {
            this.size = size;
            this.capacity = capacity;
            this.loadFactor = loadFactor;
            this.totalCollisions = totalCollisions;
            this.emptySlots = emptySlots;
            this.maxChainLength = maxChainLength;
            this.avgChainLength = avgChainLength;
            this.resizeCount = resizeCount;
            this.useChaining = useChaining;
        }
        
        // Getters
        public int getSize() { return size; }
        public int getCapacity() { return capacity; }
        public double getLoadFactor() { return loadFactor; }
        public int getTotalCollisions() { return totalCollisions; }
        public int getEmptySlots() { return emptySlots; }
        public int getMaxChainLength() { return maxChainLength; }
        public double getAvgChainLength() { return avgChainLength; }
        public int getResizeCount() { return resizeCount; }
        public boolean isUsingChaining() { return useChaining; }
        
        @Override
        public String toString() {
            return String.format(
                "Hash Table Statistics:%n" +
                "  Strategy: %s%n" +
                "  Size: %d, Capacity: %d, Load Factor: %.2f%n" +
                "  Total Collisions: %d%n" +
                "  Empty Slots: %d%n" +
                "  Max Chain/Probe Length: %d%n" +
                "  Avg Chain/Probe Length: %.2f%n" +
                "  Resize Count: %d",
                useChaining ? "Separate Chaining" : "Open Addressing",
                size, capacity, loadFactor, totalCollisions,
                emptySlots, maxChainLength, avgChainLength, resizeCount
            );
        }
    }
}