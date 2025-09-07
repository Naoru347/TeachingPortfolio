# Lab 9: Hash Table ADT Implementation

## Overview
**Week:** 12  
**Due Date:** Thursday of Week 12, 11:59 PM  
**Points:** 100 points  
**Estimated Time:** 6-8 hours

This lab focuses on implementing a complete hash table with multiple hash functions and collision resolution strategies. You'll analyze load factor effects on performance and compare different approaches to handling collisions in hash-based data structures.

---

## Learning Objectives

By the end of this lab, you will be able to:

1. **Hash Function Design**
   - Implement multiple hash function algorithms
   - Understand the properties of good hash functions
   - Analyze hash function distribution quality

2. **Collision Resolution Strategies**
   - Implement separate chaining using linked lists
   - Implement open addressing with linear probing
   - Compare performance characteristics of different strategies

3. **Load Factor Analysis**
   - Understand the relationship between load factor and performance
   - Implement dynamic resizing with rehashing
   - Analyze time complexity under different load conditions

4. **Performance Optimization**
   - Benchmark hash table operations under various conditions
   - Optimize hash functions for specific data patterns
   - Design efficient rehashing strategies

---

## Prerequisites

Before starting this lab, ensure you understand:
- Array-based data structures and dynamic resizing
- Linked list operations from earlier labs
- Big-O analysis and performance measurement
- Basic modular arithmetic and hash function concepts

---

## Background: Hash Tables

### Core Concepts
A hash table provides average O(1) access time by:
1. **Hash Function**: Maps keys to array indices
2. **Collision Resolution**: Handles multiple keys mapping to same index
3. **Load Factor**: Ratio of occupied slots to total capacity
4. **Dynamic Resizing**: Maintains performance as table grows

### Hash Function Properties
A good hash function should:
- **Uniformity**: Distribute keys evenly across table
- **Determinism**: Same key always produces same hash
- **Efficiency**: Fast to compute
- **Avalanche Effect**: Small key changes produce large hash changes

### Collision Resolution Methods
1. **Separate Chaining**: Each slot contains a linked list
2. **Open Addressing**: Find alternative slots using probing
3. **Linear Probing**: Check next slot sequentially
4. **Quadratic Probing**: Use quadratic function for spacing

---

## Part 1: Hash Entry and Basic Structure (30 minutes)

### Step 1.1: Examine Hash Entry Structure
Review the provided `HashEntry.java` file. This represents key-value pairs:
- `key`: The search key (String)
- `value`: The associated data (generic type T)
- `isDeleted`: Flag for lazy deletion in open addressing

### Step 1.2: Understand Hash Table Structure
Examine the `HashTable.java` template:
- `table`: Array to store hash entries
- `size`: Number of active key-value pairs
- `capacity`: Current table capacity
- `loadFactorThreshold`: When to trigger resize

---

## Part 2: Hash Function Implementation (60 minutes)

### Step 2.1: Simple Hash Functions (20 minutes)

Implement basic hash functions in `HashFunctions.java`:

**Division Method**:
```java
public static int divisionHash(String key, int tableSize) {
    // Sum ASCII values and use modulo
    // Handle negative results properly
}
```

**Multiplication Method**:
```java
public static int multiplicationHash(String key, int tableSize) {
    // Use golden ratio constant (0.6180339887...)
    // Extract fractional part of key * A
}
```

### Step 2.2: Advanced Hash Functions (40 minutes)

**Polynomial Rolling Hash**:
```java
public static int polynomialHash(String key, int tableSize) {
    // Use base 31 or 37 for string hashing
    // Implement Horner's method for efficiency
}
```

**Java's String hashCode() Adaptation**:
```java
public static int javaStyleHash(String key, int tableSize) {
    // Implement Java's algorithm: s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
    // Handle integer overflow gracefully
}
```

### Step 2.3: Hash Function Testing
Test hash function distribution with provided datasets:
- Measure collision rates
- Analyze distribution uniformity
- Compare performance characteristics

---

## Part 3: Separate Chaining Implementation (90 minutes)

### Step 3.1: Chaining Structure Setup (30 minutes)

Design the chaining structure:
```java
private class ChainNode {
    String key;
    T value;
    ChainNode next;
    
    // Constructor and methods
}

private ChainNode[] chains;  // Array of linked list heads
```

### Step 3.2: Basic Operations (60 minutes)

**Put Operation**:
```java
public void put(String key, T value) {
    // 1. Calculate hash index
    // 2. Search chain for existing key
    // 3. Update if found, add new node if not
    // 4. Check load factor and resize if needed
}
```

**Get Operation**:
```java
public T get(String key) {
    // 1. Calculate hash index
    // 2. Search through chain
    // 3. Return value if found, null otherwise
}
```

**Remove Operation**:
```java
public T remove(String key) {
    // 1. Calculate hash index
    // 2. Search and remove from chain
    // 3. Update size and return removed value
}
```

---

## Part 4: Open Addressing Implementation (90 minutes)

### Step 4.1: Linear Probing Setup (30 minutes)

Implement probing logic:
```java
private int findSlot(String key, boolean forInsertion) {
    // 1. Calculate initial hash
    // 2. Use linear probing to find slot
    // 3. Handle wraparound and deleted entries
    // 4. Detect table full condition
}
```

### Step 4.2: Open Addressing Operations (60 minutes)

**Put with Probing**:
```java
public void putWithProbing(String key, T value) {
    // 1. Find appropriate slot using probing
    // 2. Handle updates vs. new insertions
    // 3. Manage deleted entry reuse
    // 4. Trigger resize when load factor exceeded
}
```

**Lazy Deletion**:
```java
public T removeWithProbing(String key) {
    // 1. Find entry using probing
    // 2. Mark as deleted (don't remove immediately)
    // 3. Maintain search probe sequences
}
```

---

## Part 5: Dynamic Resizing and Rehashing (75 minutes)

### Step 5.1: Resize Trigger Logic (15 minutes)

Implement load factor monitoring:
```java
private boolean needsResize() {
    double currentLoadFactor = (double) size / capacity;
    return currentLoadFactor > loadFactorThreshold;
}
```

### Step 5.2: Rehashing Implementation (60 minutes)

**For Separate Chaining**:
```java
private void resizeChaining() {
    // 1. Save reference to old table
    // 2. Create new table with double capacity
    // 3. Rehash all existing entries
    // 4. Update capacity and reset chains
}
```

**For Open Addressing**:
```java
private void resizeProbing() {
    // 1. Save old table and create larger one
    // 2. Clear deleted flags during rehash
    // 3. Reinsert all non-deleted entries
    // 4. Update capacity and reset size
}
```

---

## Part 6: Load Factor Analysis (60 minutes)

### Step 6.1: Performance Measurement (30 minutes)

Implement timing for different load factors:
```java
public void analyzeLoadFactorPerformance() {
    // Test load factors: 0.25, 0.5, 0.75, 0.9, 1.0+
    // Measure average operations per:
    //   - Successful search
    //   - Unsuccessful search  
    //   - Insertion
    //   - Deletion
}
```

### Step 6.2: Collision Analysis (30 minutes)

Track collision statistics:
```java
public CollisionStats getCollisionStats() {
    // Calculate:
    //   - Number of collisions
    //   - Average chain length (chaining)
    //   - Average probe distance (open addressing)
    //   - Maximum chain/probe length
    //   - Distribution uniformity
}
```

---

## Part 7: Integration with Semester Project (45 minutes)

### Step 7.1: Project Enhancement
Consider hash table applications in your semester project:
- **Caching**: Store frequently accessed data
- **Indexing**: Fast lookup for user records
- **Deduplication**: Identify duplicate entries
- **Symbol Tables**: Variable/function name lookup

### Step 7.2: Design Decisions
Document trade-offs for your project:
- **Memory vs. Speed**: Hash table size considerations
- **Collision Strategy**: Chaining vs. probing for your data
- **Hash Function**: Which works best for your key patterns
- **Resizing Policy**: When and how to grow the table

---

## Testing Requirements

### Unit Tests (Required)
Your `HashTableTest.java` should include tests for:

**Hash Function Tests**:
- Distribution uniformity with sample data
- Collision rate comparison between functions
- Edge cases (empty strings, very long strings)
- Consistency (same input produces same output)

**Basic Operations Tests**:
- Put, get, remove functionality
- Key update scenarios
- Null key/value handling
- Case sensitivity handling

**Collision Resolution Tests**:
- Multiple keys hashing to same index
- Chain length verification (chaining)
- Probe sequence verification (open addressing)
- Performance under high collision rates

**Resizing Tests**:
- Automatic resize triggering
- Data preservation during resize
- Performance improvement after resize
- Load factor threshold enforcement

### Performance Analysis Tests (Required)
- Benchmark operations at different load factors
- Compare chaining vs. open addressing performance
- Analyze hash function effectiveness
- Memory usage comparison

---

## Submission Requirements

Submit the following files to GitHub Classroom:

1. **`HashTable.java`** - Complete hash table implementation with both collision strategies
2. **`HashFunctions.java`** - All implemented hash functions with analysis
3. **`HashTableTest.java`** - Comprehensive unit tests
4. **`LoadFactorAnalysis.java`** - Performance analysis implementation
5. **`lab9_report.md`** - Analysis report and project integration discussion
6. **`collision_analysis.txt`** - Data from collision and performance testing
7. **`hash_function_comparison.txt`** - Hash function effectiveness analysis

### Repository Organization
```
lab9-hashtable-[username]/
├── src/
│   ├── HashEntry.java
│   ├── HashTable.java
│   ├── HashFunctions.java
│   ├── HashTableTest.java
│   └── LoadFactorAnalysis.java
├── data/
│   ├── collision_analysis.txt
│   └── hash_function_comparison.txt
├── lab9_report.md
└── README.md
```

---

## Assessment Rubric

| **Category** | **Excellent (90-100%)** | **Good (80-89%)** | **Satisfactory (70-79%)** | **Needs Improvement (0-69%)** | **Weight** |
|--------------|-------------------------|-------------------|---------------------------|------------------------------|------------|
| **Core Functionality** | All hash functions implemented correctly; both collision strategies work flawlessly; handles all edge cases; perfect put/get/remove operations | Most functionality correct with minor issues; collision strategies mostly work; handles most edge cases appropriately | Basic functionality implemented but some bugs in edge cases; collision strategies work for simple cases; some operations may fail | Major functionality missing or incorrect; collision strategies don't work properly; frequent operation failures | **40%** |
| **Hash Function Quality** | Multiple well-implemented hash functions; excellent distribution analysis; optimal performance characteristics; handles all string types | Good hash function implementations; adequate distribution analysis; generally good performance; handles most string types | Basic hash functions implemented; some distribution analysis; acceptable performance; limited string type handling | Poor hash function implementations; little to no distribution analysis; poor performance; fails on many string types | **25%** |
| **Performance Analysis** | Comprehensive load factor analysis; detailed collision statistics; insightful performance comparisons; excellent benchmarking methodology | Good load factor analysis; adequate collision statistics; solid performance comparisons; reasonable benchmarking | Basic load factor analysis; some collision statistics; limited performance comparisons; simple benchmarking | Little to no performance analysis; missing collision statistics; no meaningful comparisons; poor or missing benchmarking | **20%** |
| **Code Quality & Testing** | Clean, well-organized code; comprehensive test suite covering all scenarios; excellent documentation; follows all Java conventions | Mostly clean code; good test coverage with minor gaps; generally well-documented; follows most conventions | Functional code with some organization issues; basic test coverage; adequate documentation; some convention violations | Poorly organized code; minimal testing; poor documentation; many convention violations | **10%** |
| **Professional Submission** | Submitted on time; perfectly organized repository; detailed analysis report; excellent project integration discussion; clean commit history | Submitted on time; well-organized repository; good analysis report; solid project integration; regular commits | Submitted on time; adequately organized; basic analysis report; some project integration; occasional commits | Late submission or poor organization; minimal analysis; little project integration; few or unclear commits | **5%** |

### **Grade Scale:**
- **A (90-100%)**: Exceptional work demonstrating mastery of hash table concepts
- **B (80-89%)**: Good work with solid understanding and implementation
- **C (70-79%)**: Satisfactory work meeting basic requirements
- **D (60-69%)**: Below expectations with significant issues
- **F (0-59%)**: Failing to meet minimum requirements

---

## Getting Help

### Before Asking for Help:
1. Test your hash functions with small datasets first
2. Verify collision resolution with manual examples
3. Use debugging prints to trace key-to-index mappings
4. Connect with the TA during the lab or their student hours for support
5. Make time to meet with your professor for additional support as needed

### Office Hours Topics:
- Hash function distribution analysis
- Debugging collision resolution logic
- Optimizing performance for specific data patterns
- Interpreting load factor analysis results

### Collaboration Policy:
- Discuss hash function algorithms and collision strategies
- Share performance testing approaches and debugging techniques
- **Do NOT share actual hash table implementation code**
- All submitted code must be your own work

---

## Resources

### Required Reading:
- Textbook Chapter 11: Hash Tables and Hash Functions
- Course notes on collision resolution strategies

### Helpful Tools:
- [Hash Table Visualization](https://www.cs.usfca.edu/~galles/visualization/OpenHash.html)
- [Hash Function Analyzer](https://visualgo.net/en/hashtable)
- Java HashMap source code (for reference only)

### Reference Materials:
- Java Collections Framework HashMap documentation
- Hash function research papers (optional advanced reading)
- Performance analysis examples from previous labs

---

**Final Note:** Hash tables are fundamental to many real-world applications, from database indexing to programming language implementations. The collision resolution and load factor concepts you master here are essential for designing efficient systems. Focus on understanding the trade-offs between different approaches and how they affect performance in practice.