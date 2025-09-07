/**
 * HashFunctions provides various hash function implementations for string keys.
 * This class allows comparison of different hashing strategies and their 
 * distribution properties.
 * 
 * Students will implement multiple hash functions and analyze their 
 * collision rates and distribution uniformity.
 * 
 * @author Student Name
 * @version Lab 9 - Hash Table Implementation
 */
public class HashFunctions {
    
    // Constants for hash function implementations
    private static final double GOLDEN_RATIO = 0.6180339887;
    private static final int POLYNOMIAL_BASE = 31;
    private static final int LARGE_PRIME = 1000000007;
    
    /**
     * Simple division method hash function.
     * Sums ASCII values of characters and uses modulo operation.
     * 
     * @param key the string key to hash
     * @param tableSize the size of the hash table
     * @return hash value in range [0, tableSize-1]
     */
    public static int divisionHash(String key, int tableSize) {
        // TODO: Implement division hash
        // 1. Sum ASCII values of all characters in key
        // 2. Take modulo with tableSize
        // 3. Handle negative results (use Math.abs)
        // 
        // Example approach:
        // int sum = 0;
        // for (char c : key.toCharArray()) {
        //     sum += (int) c;
        // }
        // return Math.abs(sum) % tableSize;
        
        return 0; // Replace with your implementation
    }
    
    /**
     * Multiplication method hash function.
     * Uses the golden ratio for good distribution properties.
     * 
     * @param key the string key to hash
     * @param tableSize the size of the hash table
     * @return hash value in range [0, tableSize-1]
     */
    public static int multiplicationHash(String key, int tableSize) {
        // TODO: Implement multiplication hash
        // 1. Sum ASCII values to get integer representation
        // 2. Multiply by golden ratio constant (0.6180339887...)
        // 3. Extract fractional part
        // 4. Multiply by table size and take floor
        //
        // Formula: floor(tableSize * ((keyValue * A) % 1))
        // where A is the golden ratio and % 1 extracts fractional part
        
        return 0; // Replace with your implementation
    }
    
    /**
     * Polynomial rolling hash function.
     * Uses Horner's method for efficient computation.
     * Provides good distribution for string data.
     * 
     * @param key the string key to hash
     * @param tableSize the size of the hash table
     * @return hash value in range [0, tableSize-1]
     */
    public static int polynomialHash(String key, int tableSize) {
        // TODO: Implement polynomial hash
        // 1. Use Horner's method: hash = (hash * base + char) for each char
        // 2. Use base 31 or 37 (good primes for string hashing)
        // 3. Handle integer overflow appropriately
        // 4. Take modulo with tableSize and ensure positive result
        //
        // Horner's method for string s: s[0]*b^(n-1) + s[1]*b^(n-2) + ... + s[n-1]
        // Computed efficiently as: ((...((s[0]*b + s[1])*b + s[2])*b + ...)*b + s[n-1])
        
        return 0; // Replace with your implementation
    }
    
    /**
     * Java-style hash function.
     * Implements the algorithm used by Java's String.hashCode().
     * Provides reference implementation for comparison.
     * 
     * @param key the string key to hash
     * @param tableSize the size of the hash table
     * @return hash value in range [0, tableSize-1]
     */
    public static int javaStyleHash(String key, int tableSize) {
        // TODO: Implement Java's string hashCode algorithm
        // Java's algorithm: s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        // 1. Use base 31 (as in Java's implementation)
        // 2. Handle integer overflow (let it wrap around)
        // 3. Take absolute value and modulo with tableSize
        //
        // Note: This is essentially polynomial hash with base 31
        
        return 0; // Replace with your implementation
    }
    
    /**
     * FNV-1a hash function (Fowler-Noll-Vo).
     * Alternative hash function with good distribution properties.
     * 
     * @param key the string key to hash
     * @param tableSize the size of the hash table
     * @return hash value in range [0, tableSize-1]
     */
    public static int fnvHash(String key, int tableSize) {
        // TODO: Implement FNV-1a hash (optional advanced function)
        // FNV-1a algorithm:
        // 1. Start with FNV offset basis
        // 2. For each byte: hash = (hash XOR byte) * FNV prime
        // 3. Use appropriate constants for 32-bit hash
        //
        // FNV constants:
        // FNV prime = 16777619
        // FNV offset basis = 2166136261
        
        return 0; // Replace with your implementation
    }
    
    // =====================================================
    // HASH FUNCTION ANALYSIS METHODS
    // =====================================================
    
    /**
     * Analyzes the distribution quality of a hash function.
     * 
     * @param keys array of keys to test
     * @param tableSize size of hash table
     * @param hashFunction which hash function to use (1-5)
     * @return HashAnalysisResult containing distribution statistics
     */
    public static HashAnalysisResult analyzeHashFunction(String[] keys, int tableSize, int hashFunction) {
        int[] bucketCounts = new int[tableSize];
        int totalCollisions = 0;
        
        // Count distribution across buckets
        for (String key : keys) {
            int hash = getHashValue(key, tableSize, hashFunction);
            bucketCounts[hash]++;
        }
        
        // Calculate statistics
        int emptyBuckets = 0;
        int maxBucketSize = 0;
        int totalUsedBuckets = 0;
        
        for (int count : bucketCounts) {
            if (count == 0) {
                emptyBuckets++;
            } else {
                totalUsedBuckets++;
                maxBucketSize = Math.max(maxBucketSize, count);
                if (count > 1) {
                    totalCollisions += (count - 1);
                }
            }
        }
        
        // Calculate uniformity measure (lower is better)
        double expectedPerBucket = (double) keys.length / tableSize;
        double uniformityScore = 0.0;
        for (int count : bucketCounts) {
            uniformityScore += Math.pow(count - expectedPerBucket, 2);
        }
        uniformityScore = Math.sqrt(uniformityScore / tableSize);
        
        return new HashAnalysisResult(
            keys.length,
            tableSize,
            totalCollisions,
            emptyBuckets,
            maxBucketSize,
            uniformityScore,
            bucketCounts
        );
    }
    
    /**
     * Helper method to get hash value using specified function.
     * 
     * @param key the key to hash
     * @param tableSize the table size
     * @param functionNumber which hash function to use (1-5)
     * @return the hash value
     */
    private static int getHashValue(String key, int tableSize, int functionNumber) {
        switch (functionNumber) {
            case 1: return divisionHash(key, tableSize);
            case 2: return multiplicationHash(key, tableSize);
            case 3: return polynomialHash(key, tableSize);
            case 4: return javaStyleHash(key, tableSize);
            case 5: return fnvHash(key, tableSize);
            default: throw new IllegalArgumentException("Invalid hash function number: " + functionNumber);
        }
    }
    
    /**
     * Compares multiple hash functions with the same dataset.
     * 
     * @param keys array of keys to test
     * @param tableSize size of hash table
     * @return array of analysis results for each hash function
     */
    public static HashAnalysisResult[] compareHashFunctions(String[] keys, int tableSize) {
        String[] functionNames = {
            "Division Hash",
            "Multiplication Hash", 
            "Polynomial Hash",
            "Java-style Hash",
            "FNV Hash"
        };
        
        HashAnalysisResult[] results = new HashAnalysisResult[5];
        
        System.out.println("Hash Function Comparison");
        System.out.println("========================");
        System.out.printf("Dataset: %d keys, Table size: %d%n%n", keys.length, tableSize);
        
        for (int i = 0; i < 5; i++) {
            results[i] = analyzeHashFunction(keys, tableSize, i + 1);
            results[i].setFunctionName(functionNames[i]);
            
            System.out.printf("%-20s | Collisions: %3d | Empty: %3d | Max bucket: %2d | Uniformity: %.2f%n",
                functionNames[i], 
                results[i].getCollisions(),
                results[i].getEmptyBuckets(),
                results[i].getMaxBucketSize(),
                results[i].getUniformityScore()
            );
        }
        
        return results;
    }
    
    /**
     * Generates test data for hash function analysis.
     * 
     * @param size number of keys to generate
     * @param type type of data ("random", "sequential", "names", "urls")
     * @return array of test keys
     */
    public static String[] generateTestData(int size, String type) {
        String[] keys = new String[size];
        
        switch (type.toLowerCase()) {
            case "random":
                for (int i = 0; i < size; i++) {
                    keys[i] = generateRandomString(8 + (i % 8));
                }
                break;
                
            case "sequential":
                for (int i = 0; i < size; i++) {
                    keys[i] = "key" + String.format("%06d", i);
                }
                break;
                
            case "names":
                String[] firstNames = {"John", "Jane", "Bob", "Alice", "Charlie", "Diana", "Eve", "Frank"};
                String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis"};
                for (int i = 0; i < size; i++) {
                    keys[i] = firstNames[i % firstNames.length] + lastNames[(i * 7) % lastNames.length];
                }
                break;
                
            case "urls":
                String[] domains = {"example.com", "test.org", "demo.net", "sample.edu"};
                String[] paths = {"index", "about", "contact", "products", "services", "blog"};
                for (int i = 0; i < size; i++) {
                    keys[i] = "http://" + domains[i % domains.length] + "/" + paths[(i * 3) % paths.length] + i;
                }
                break;
                
            default:
                throw new IllegalArgumentException("Unknown data type: " + type);
        }
        
        return keys;
    }
    
    /**
     * Generates a random string of specified length.
     * 
     * @param length the length of string to generate
     * @return randomly generated string
     */
    private static String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        
        return sb.toString();
    }
    
    // =====================================================
    // HASH ANALYSIS RESULT CLASS
    // =====================================================
    
    /**
     * Container class for hash function analysis results.
     */
    public static class HashAnalysisResult {
        private final int totalKeys;
        private final int tableSize;
        private final int collisions;
        private final int emptyBuckets;
        private final int maxBucketSize;
        private final double uniformityScore;
        private final int[] bucketCounts;
        private String functionName;
        
        public HashAnalysisResult(int totalKeys, int tableSize, int collisions, 
                                int emptyBuckets, int maxBucketSize, 
                                double uniformityScore, int[] bucketCounts) {
            this.totalKeys = totalKeys;
            this.tableSize = tableSize;
            this.collisions = collisions;
            this.emptyBuckets = emptyBuckets;
            this.maxBucketSize = maxBucketSize;
            this.uniformityScore = uniformityScore;
            this.bucketCounts = bucketCounts.clone();
        }
        
        // Getters
        public int getTotalKeys() { return totalKeys; }
        public int getTableSize() { return tableSize; }
        public int getCollisions() { return collisions; }
        public int getEmptyBuckets() { return emptyBuckets; }
        public int getMaxBucketSize() { return maxBucketSize; }
        public double getUniformityScore() { return uniformityScore; }
        public int[] getBucketCounts() { return bucketCounts.clone(); }
        public String getFunctionName() { return functionName; }
        
        public void setFunctionName(String name) { this.functionName = name; }
        
        public double getLoadFactor() {
            return (double) totalKeys / tableSize;
        }
        
        public double getCollisionRate() {
            return (double) collisions / totalKeys;
        }
        
        @Override
        public String toString() {
            return String.format(
                "Hash Analysis for %s:%n" +
                "  Keys: %d, Table Size: %d, Load Factor: %.2f%n" +
                "  Collisions: %d (%.1f%%), Empty Buckets: %d%n" +
                "  Max Bucket Size: %d, Uniformity Score: %.2f",
                functionName != null ? functionName : "Unknown Function",
                totalKeys, tableSize, getLoadFactor(),
                collisions, getCollisionRate() * 100, emptyBuckets,
                maxBucketSize, uniformityScore
            );
        }
    }
}