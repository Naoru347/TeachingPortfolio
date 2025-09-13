# TA Guide: Common Hash Table Implementation Problems

## Overview
This guide helps TAs quickly identify and address the most frequent issues students encounter during Lab 9: Hash Table ADT. Hash tables involve several interconnected concepts, so focus on helping students understand the relationships between hash functions, collision resolution, and performance.

---

## Quick Diagnosis Framework

### When a Student Says: "My hash table isn't working"

**First Questions to Ask:**
1. "What specific operation is failing - put, get, or remove?"
2. "Can you trace through the hash calculation for a simple key?"
3. "How are you handling collisions?"

**Quick Visual Check:**
- Have them manually trace a put/get operation with a small example
- Check if they understand the difference between hash value and array index
- Verify they know what collision resolution strategy they're using

---

## Hash Function Issues

### Pattern 1: Negative Hash Values

**Student Symptoms:**
- "I'm getting ArrayIndexOutOfBoundsException"
- "Keys aren't mapping to the right indices"
- "My hash function sometimes returns negative numbers"

**What to Look For:**
```java
// RED FLAG: Not handling negative hash values
public int hash(String key) {
    return key.hashCode() % capacity;  // Can be negative!
}

// CORRECT: Ensure positive result
public int hash(String key) {
    return Math.abs(key.hashCode()) % capacity;
}
```

**Diagnostic Questions:**
- "What happens when hashCode() returns a negative number?"
- "How does the modulo operator work with negative numbers in Java?"

**Guidance Strategy:**
- Don't immediately show the fix
- Have them test with a key that produces negative hashCode()
- Guide them to discover that modulo can be negative
- Ask them how to ensure a positive result

**Common Root Cause:** Students don't realize Java's hashCode() can be negative

---

### Pattern 2: Poor Hash Distribution

**Student Symptoms:**
- "Everything is going to the same bucket"
- "I have tons of collisions even with small data"
- "My chains are really long"

**What to Look For:**
```java
// RED FLAG: Terrible hash function
public int hash(String key) {
    return key.length() % capacity;  // Most strings same length!
}

// RED FLAG: Only using first character
public int hash(String key) {
    return key.charAt(0) % capacity;
}
```

**Diagnostic Approach:**
1. Have them test their hash function with actual data
2. Ask them to manually check where several keys map
3. Point out patterns in their key distribution

**Guidance Strategy:**
- Don't fix their hash function immediately
- Help them recognize poor distribution
- Ask: "What makes two strings hash to the same value with your function?"
- Guide them toward using more characters from the key

**Teaching Moment:** This is perfect for discussing hash function properties

---

## Collision Resolution Issues

### Pattern 3: Chaining Implementation Problems

**Student Symptoms:**
- "I can put items but can't retrieve them"
- "My chains aren't working properly"
- "Items disappear after I add more"

**What to Look For:**
```java
// RED FLAG: Not searching the entire chain
public T get(String key) {
    int index = hash(key);
    ChainNode current = chains[index];
    if (current != null && current.key.equals(key)) {
        return current.value;
    }
    return null;  // Only checked first node!
}

// RED FLAG: Incorrect chain insertion
public void put(String key, T value) {
    int index = hash(key);
    ChainNode newNode = new ChainNode(key, value);
    chains[index] = newNode;  // Lost the rest of the chain!
}
```

**Diagnostic Questions:**
- "What happens if the key isn't in the first node of the chain?"
- "When you add a new node, what happens to the existing chain?"

**Guidance Strategy:**
- Have them trace through a collision scenario manually
- Draw the linked list structure on paper
- Ask them to verify their chain traversal logic
- Focus on the difference between "replace" and "add to chain"

**Common Misconception:** Students think one collision = one comparison

---

### Pattern 4: Linear Probing Confusion

**Student Symptoms:**
- "Linear probing gets stuck in infinite loops"
- "I can't find items I just inserted"
- "The table fills up even when it's not full"

**What to Look For:**
```java
// RED FLAG: Infinite loop potential
public int findSlot(String key) {
    int index = hash(key);
    while (table[index] != null) {
        if (table[index].key.equals(key)) {
            return index;
        }
        index++;  // No wraparound!
    }
    return index;
}

// RED FLAG: Not handling deleted entries
public T get(String key) {
    int index = hash(key);
    while (table[index] != null) {
        if (table[index].key.equals(key)) {
            return table[index].value;
        }
        index = (index + 1) % capacity;
    }
    return null;  // Stops at deleted entry!
}
```

**Diagnostic Questions:**
- "What happens when you reach the end of the array?"
- "How do you handle deleted entries during search?"
- "When should you stop probing?"

**Guidance Strategy:**
- Have them trace through probing with a small array
- Ask what happens when probing reaches the array end
- Guide them through deleted entry scenarios
- Emphasize the difference between null and deleted

**Teaching Moment:** Perfect for discussing probe sequences and table fullness

---

## Load Factor and Resizing Issues

### Pattern 5: Incorrect Load Factor Calculation

**Student Symptoms:**
- "My table never resizes"
- "Resize happens too early/too late"
- "Performance doesn't improve after resize"

**What to Look For:**
```java
// RED FLAG: Wrong load factor calculation
private boolean needsResize() {
    return size > capacity;  // Should be size/capacity > threshold
}

// RED FLAG: Not updating size correctly
public void put(String key, T value) {
    // ... insertion logic ...
    size++;  // Always increment, even for updates!
}
```

**Diagnostic Questions:**
- "What does load factor mean mathematically?"
- "When do you increment the size counter?"
- "What should happen when you update an existing key?"

**Guidance Strategy:**
- Have them calculate load factor manually for a simple example
- Clarify the difference between updates and new insertions
- Ask them when resize should actually occur

---

### Pattern 6: Broken Rehashing

**Student Symptoms:**
- "Items disappear after resize"
- "Can't find items after table grows"
- "Resize makes everything worse"

**What to Look For:**
```java
// RED FLAG: Not rehashing during resize
private void resize() {
    capacity *= 2;
    HashEntry[] oldTable = table;
    table = new HashEntry[capacity];
    // Missing: rehash all entries from oldTable!
}

// RED FLAG: Copying instead of rehashing
private void resize() {
    HashEntry[] oldTable = table;
    table = new HashEntry[capacity * 2];
    System.arraycopy(oldTable, 0, table, 0, oldTable.length);
    // Wrong! Hash values change with new capacity
}
```

**Diagnostic Questions:**
- "Why do you need to rehash entries when resizing?"
- "What happens to hash values when capacity changes?"
- "How do you move entries from old table to new table?"

**Guidance Strategy:**
- Have them manually calculate hash values before and after capacity change
- Emphasize that copying isn't enough - must rehash
- Walk through rehashing one entry step by step

**Common Misconception:** Students think they can just copy entries to larger array

---

## Emergency Debugging Protocols

### When Student is Completely Stuck

**1. Simplify to Core Operation (10 minutes)**
- Test with just 3-4 keys in a small table
- Use simple hash function (key.length() % 7)
- Manual trace through put and get operations
- Verify basic array access works

**2. Hash Function Isolation Test**
```java
// Test hash function separately
public static void testHashFunction() {
    String[] keys = {"apple", "banana", "cherry"};
    int capacity = 7;
    for (String key : keys) {
        int hash = Math.abs(key.hashCode()) % capacity;
        System.out.println(key + " -> " + hash);
    }
}
```

**3. Collision Scenario Walkthrough**
- Create scenario where two keys definitely collide
- Trace through put operations manually
- Verify collision resolution step by step

---

## Performance Analysis Help

### When Students Say: "My performance analysis doesn't make sense"

**Common Issues:**
1. **Not measuring what they think**
   ```java
   // WRONG: Including hash calculation in retrieval time
   long start = System.nanoTime();
   int index = hash(key);  // This time shouldn't count
   T value = table[index].value;
   long end = System.nanoTime();
   ```

2. **Too small sample sizes**
   - Single operation timing is too noisy
   - Need to average over many operations
   - Test with different data sizes

3. **Not controlling variables**
   - Mixing different load factors in same test
   - Not accounting for JVM warmup
   - Testing different collision strategies simultaneously

**Diagnostic Questions:**
- "What exactly are you timing?"
- "How many operations are you averaging?"
- "Are you keeping load factor constant during the test?"

**Guidance:**
- Help them isolate what they're measuring
- Suggest running warmup iterations
- Focus on trends rather than absolute numbers

---

## Pedagogical Strategies

### When to Show Code vs. Concept

**Show Code When:**
- Student understands concept but has syntax issues
- They have correct logic but implementation bugs
- Debugging specific edge cases

**Explain Concept When:**
- Student doesn't understand what collision resolution accomplishes
- They're confused about when rehashing is needed
- They don't see connection between load factor and performance

### Effective Hash Table Analogies

**Hash Function as Address System:**
"Think of hash function like a postal code system - it tells you which neighborhood (bucket) to look in"

**Collision Resolution as Problem Solving:**
"When two people have the same address, chaining is like apartment numbers, probing is like checking the next house"

**Load Factor as Crowding:**
"High load factor is like a crowded parking lot - harder to find spaces"

---

## Common Student Questions & Responses

### Q: "Why not just use ArrayList and search linearly?"
**Response:** "Great question! Let's think about time complexity. What happens to search time as your data grows with ArrayList vs. hash table?"

### Q: "Which collision resolution is better?"
**Response:** "That depends on your data patterns. Let's think about trade-offs. What if you have long chains vs. many deletions?"

### Q: "Why does my hash table get slower when it's fuller?"
**Response:** "Excellent observation! Can you think about what happens to collision frequency as load factor increases?"

### Q: "How do I choose a good hash function?"
**Response:** "Let's test yours with real data. What patterns do you see in how your keys are distributed?"

---

## Red Flags: When to Escalate

**Academic Integrity Concerns:**
- Perfect hash function implementation beyond course scope
- Collision resolution code too advanced for student level
- Performance analysis showing unrealistic understanding

**Conceptual Issues Requiring Instructor:**
- Fundamental confusion about arrays and indices after extensive help
- Inability to trace through simple examples after guided practice
- Persistent misunderstanding of modular arithmetic

**Student Welfare Concerns:**
- Extreme frustration with the mathematical aspects
- Feeling overwhelmed by multiple interconnected concepts
- Mentions spending excessive time without progress on basics

---

## Quick Reference: Hash Table Debugging

**For IDE Debugging:**
- Set breakpoint in hash function
- Watch array indices during put/get
- Step through collision resolution logic
- Monitor size and capacity changes

**Manual Testing Commands:**
```java
// Quick hash table test
HashTable<String> table = new HashTable<>();
table.put("test", "value");
System.out.println("Retrieved: " + table.get("test"));
System.out.println("Load factor: " + table.getLoadFactor());
```

---

## Success Indicators

**Student is on track when:**
- Can trace hash calculation from key to index
- Understands why collisions occur
- Can explain their chosen collision resolution strategy
- Recognizes relationship between load factor and performance

**Student needs more help when:**
- Can't explain what their hash function does
- Confused about difference between hash value and array index
- Doesn't understand why items "disappear" after operations
- Focuses on getting code to compile rather than understanding logic

Remember: Hash tables combine several concepts (arrays, linked lists, modular arithmetic, performance analysis). Help students see how these pieces work together rather than treating each as separate problems.