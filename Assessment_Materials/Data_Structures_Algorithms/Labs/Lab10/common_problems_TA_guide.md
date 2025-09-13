# Graph Traversal Visual Guide - Lab 10
*Your reference for understanding BFS, DFS, and pathfinding algorithms*

---

## How to Use This Guide

**Before coding:** Read through the examples to understand how algorithms work
**While coding:** Reference the step-by-step traces to debug your implementation  
**For testing:** Use the small examples to verify your algorithms work correctly
**When stuck:** Compare your algorithm's output with these expected results

---

## 📚 Understanding Graph Representations

### **What does a graph look like?**

**Example: Social Network**
```
    Alice ---- Bob
      |         |
      |         |
    David ---- Carol

People: Alice, Bob, Carol, David  
Friendships: Alice↔Bob, Alice↔David, Bob↔Carol, Carol↔David
```

### **How do we store this in code?**

**Option 1: Adjacency List** (what most students should use)
```java
Map<String, List<String>> friends = new HashMap<>();
friends.put("Alice", Arrays.asList("Bob", "David"));
friends.put("Bob", Arrays.asList("Alice", "Carol"));  
friends.put("Carol", Arrays.asList("Bob", "David"));
friends.put("David", Arrays.asList("Alice", "Carol"));
```

**Option 2: Adjacency Matrix** (for dense graphs)
```java
//           Alice Bob Carol David
//   Alice  [  0   1    0    1  ]
//   Bob    [  1   0    1    0  ]  
//   Carol  [  0   1    0    1  ]
//   David  [  1   0    1    0  ]

// 1 means friendship exists, 0 means no direct friendship
```

**Which should you choose?**
- **Few connections (sparse)** → Use adjacency list (saves memory)
- **Many connections (dense)** → Use adjacency matrix (faster lookups)
- **When in doubt** → Start with adjacency list

---

## 🔄 Breadth-First Search (BFS) - "Explore by Levels"

### **The Big Picture:**
BFS explores your graph **level by level**, like ripples in a pond. It visits all vertices at distance 1, then distance 2, then distance 3, etc.

### **When to use BFS:**
- ✅ Finding shortest paths in unweighted graphs
- ✅ Finding if two vertices are connected  
- ✅ Level-order processing (like organizational hierarchy)

### **The Algorithm (what your code should do):**
1. Start with a **queue** containing just the start vertex
2. Mark the start vertex as **visited**
3. While queue is not empty:
   - Remove front vertex from queue
   - For each unvisited neighbor:
     - Mark neighbor as visited  
     - Add neighbor to back of queue

### **Step-by-Step Example:**

**Graph to search:**
```
        A
       / \
      B   C
     /   / \
    D   E   F
```

**BFS starting from A:**

**Step 0: Initialize**
```
Queue: [A]
Visited: {A}
Order: []
```

**Step 1: Process A**
```
Remove A from front of queue
Add A to our result: Order = [A]
A's neighbors are B and C
Add B and C to visited: Visited = {A, B, C}  
Add B and C to back of queue: Queue = [B, C]
```

**Step 2: Process B**  
```
Remove B from front of queue: Queue = [C]
Add B to result: Order = [A, B]
B's neighbor D is unvisited
Add D to visited: Visited = {A, B, C, D}
Add D to queue: Queue = [C, D]
```

**Step 3: Process C**
```
Remove C from front: Queue = [D]  
Add C to result: Order = [A, B, C]
C's neighbors E and F are unvisited
Add E,F to visited: Visited = {A, B, C, D, E, F}
Add E,F to queue: Queue = [D, E, F]
```

**Step 4: Process D**
```
Remove D from front: Queue = [E, F]
Add D to result: Order = [A, B, C, D]
D has no unvisited neighbors
Queue = [E, F]
```

**Step 5: Process E**
```
Remove E from front: Queue = [F]
Add E to result: Order = [A, B, C, D, E]  
E has no unvisited neighbors
Queue = [F]
```

**Step 6: Process F**
```
Remove F from front: Queue = []
Add F to result: Order = [A, B, C, D, E, F]
F has no unvisited neighbors  
Queue is empty → DONE!
```

**Final BFS Order: A → B → C → D → E → F**

**Key insight:** Notice how we explored level by level:
- Level 0: A
- Level 1: B, C  
- Level 2: D, E, F

---

## 🌊 Depth-First Search (DFS) - "Go Deep First"

### **The Big Picture:**
DFS explores as far as possible along each path before backtracking. Like exploring a maze - go down each corridor completely before trying the next one.

### **When to use DFS:**
- ✅ Finding if a path exists between vertices
- ✅ Detecting cycles in graphs
- ✅ Topological sorting
- ✅ Exploring all possibilities

### **Two Ways to Implement DFS:**

#### **Method 1: Recursive (easier to understand)**
```java
public void dfsRecursive(String vertex, Set<String> visited, List<String> result) {
    visited.add(vertex);      // Mark as visited
    result.add(vertex);       // Add to our traversal order
    
    for (String neighbor : getNeighbors(vertex)) {
        if (!visited.contains(neighbor)) {
            dfsRecursive(neighbor, visited, result);  // Recursively explore
        }
    }
}
```

#### **Method 2: Iterative with Stack (more like BFS)**
```java  
public List<String> dfsIterative(String start) {
    Stack<String> stack = new Stack<>();
    Set<String> visited = new HashSet<>();
    List<String> result = new ArrayList<>();
    
    stack.push(start);
    
    while (!stack.isEmpty()) {
        String current = stack.pop();
        
        if (!visited.contains(current)) {
            visited.add(current);
            result.add(current);
            
            // Add neighbors to stack (in reverse order for consistent results)
            List<String> neighbors = getNeighbors(current);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                stack.push(neighbors.get(i));
            }
        }
    }
    return result;
}
```

### **Step-by-Step Example (Recursive):**

**Same graph:**
```
        A
       / \
      B   C
     /   / \
    D   E   F
```

**DFS starting from A:**

**Step 1: Visit A**
```
Call dfs(A)
Mark A as visited: Visited = {A}
Add A to result: Order = [A]
A has neighbors B and C, explore B first
```

**Step 2: Visit B (from A)**
```
Call dfs(B)
Mark B as visited: Visited = {A, B}  
Add B to result: Order = [A, B]
B has neighbor D, explore D
```

**Step 3: Visit D (from B)**
```  
Call dfs(D)
Mark D as visited: Visited = {A, B, D}
Add D to result: Order = [A, B, D]
D has no unvisited neighbors → return to B
```

**Step 4: Back to B**
```
B has no more unvisited neighbors → return to A  
```

**Step 5: Back to A, explore C**
```
A's next neighbor is C, explore C
Call dfs(C)
Mark C as visited: Visited = {A, B, D, C}
Add C to result: Order = [A, B, D, C]  
C has neighbors E and F, explore E first
```

**Step 6: Visit E (from C)**
```
Call dfs(E)
Mark E as visited: Visited = {A, B, D, C, E}
Add E to result: Order = [A, B, D, C, E]
E has no unvisited neighbors → return to C
```

**Step 7: Back to C, explore F**
```
Call dfs(F)  
Mark F as visited: Visited = {A, B, D, C, E, F}
Add F to result: Order = [A, B, D, C, E, F]
F has no unvisited neighbors → return to C → return to A
```

**Final DFS Order: A → B → D → C → E → F**

**Key insight:** Notice how we went deep first:
- A → B → D (went as deep as possible)
- Then backtracked: D → B → A  
- Then A → C → E (went deep again)
- Then backtracked and tried: E → C → F

---

## 🛤️ Finding Shortest Paths with BFS

### **Why BFS finds shortest paths:**
BFS explores by distance from the start. When it first reaches a vertex, it has found the shortest path to that vertex.

### **Enhanced BFS for Pathfinding:**

**The algorithm:**
1. Run BFS but also track **parent pointers**
2. For each vertex, remember which vertex led you there
3. To reconstruct path: follow parent pointers backward from destination

**Example: Find shortest path from A to F**

**Graph:**
```
    A ---- B ---- E
    |      |      |
    |      |      |
    C ---- D ---- F

Goal: Find shortest path A → F
```

**BFS with parent tracking:**

**Step 1: Start with A**
```
Queue: [A]
Visited: {A}
Parents: {A: null}  // A has no parent (it's the start)
```

**Step 2: Process A**
```
Queue: [B, C]
Visited: {A, B, C}  
Parents: {A: null, B: A, C: A}  // B and C came from A
```

**Step 3: Process B**
```
Queue: [C, E, D]
Visited: {A, B, C, E, D}
Parents: {A: null, B: A, C: A, E: B, D: B}  // E and D came from B
```

**Step 4: Process C**  
```
Queue: [E, D]  // C has no new neighbors
Visited: {A, B, C, E, D}
Parents: {A: null, B: A, C: A, E: B, D: B}
```

**Step 5: Process E**
```  
Queue: [D]
Visited: {A, B, C, E, D}
Parents: {A: null, B: A, C: A, E: B, D: B}  // E has no new neighbors
```

**Step 6: Process D**
```
Queue: [F]
Visited: {A, B, C, E, D, F}
Parents: {A: null, B: A, C: A, E: B, D: B, F: D}  // F came from D
```

**Step 7: We reached F! Reconstruct the path:**
```
Start at F: path = [F]
F's parent is D: path = [F, D]  
D's parent is B: path = [F, D, B]
B's parent is A: path = [F, D, B, A]
A's parent is null: STOP

Reverse the path: [A, B, D, F]
```

**Final shortest path: A → B → D → F (length 3)**

### **Your code should look like:**
```java
public List<String> findShortestPath(String start, String destination) {
    Map<String, String> parents = new HashMap<>();
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    
    queue.offer(start);
    visited.add(start);
    parents.put(start, null);
    
    while (!queue.isEmpty()) {
        String current = queue.poll();
        
        if (current.equals(destination)) {
            // Found destination! Reconstruct path
            return reconstructPath(parents, destination);
        }
        
        for (String neighbor : getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                parents.put(neighbor, current);  // Remember how we got here
                queue.offer(neighbor);
            }
        }
    }
    
    return null;  // No path found
}

private List<String> reconstructPath(Map<String, String> parents, String destination) {
    List<String> path = new ArrayList<>();
    String current = destination;
    
    while (current != null) {
        path.add(current);
        current = parents.get(current);
    }
    
    Collections.reverse(path);  // Don't forget this!
    return path;
}
```

---

## 🔗 Connected Components - "Finding Groups"

### **What are connected components?**
Groups of vertices that can reach each other, but cannot reach vertices in other groups.

**Example:**
```
Group 1:        Group 2:        Group 3:
   A               E ---- F         I
  / \              |      |         (alone)
 B   C             G ---- H
 |
 D

Three components: {A,B,C,D}, {E,F,G,H}, {I}
```

### **Algorithm: Use DFS to find all components**
```java
public List<Set<String>> findConnectedComponents() {
    List<Set<String>> components = new ArrayList<>();
    Set<String> globalVisited = new HashSet<>();
    
    for (String vertex : getAllVertices()) {
        if (!globalVisited.contains(vertex)) {
            // Found a new component!
            Set<String> component = new HashSet<>();
            dfsForComponent(vertex, globalVisited, component);
            components.add(component);
        }
    }
    
    return components;
}

private void dfsForComponent(String vertex, Set<String> globalVisited, Set<String> component) {
    globalVisited.add(vertex);  // Mark globally so we don't revisit
    component.add(vertex);      // Add to current component
    
    for (String neighbor : getNeighbors(vertex)) {
        if (!globalVisited.contains(neighbor)) {
            dfsForComponent(neighbor, globalVisited, component);
        }
    }
}
```

---

## ⚠️ Common Mistakes and How to Fix Them

### **Mistake 1: Marking vertices visited too late**

**❌ WRONG - causes infinite loops:**
```java
while (!queue.isEmpty()) {
    String current = queue.poll();
    visited.add(current);  // TOO LATE! 
    
    for (String neighbor : getNeighbors(current)) {
        if (!visited.contains(neighbor)) {
            queue.offer(neighbor);  // Same vertex can be added multiple times!
        }
    }
}
```

**✅ CORRECT - mark when adding to queue:**
```java  
queue.offer(start);
visited.add(start);  // Mark start immediately

while (!queue.isEmpty()) {
    String current = queue.poll();
    
    for (String neighbor : getNeighbors(current)) {
        if (!visited.contains(neighbor)) {
            visited.add(neighbor);  // Mark BEFORE adding to queue
            queue.offer(neighbor);
        }
    }
}
```

### **Mistake 2: Using wrong data structure**

**❌ WRONG for BFS:**
```java
Stack<String> queue = new Stack<>();  // This gives you DFS, not BFS!
```

**✅ CORRECT for BFS:**
```java
Queue<String> queue = new LinkedList<>();  // Use Queue interface
```

**✅ CORRECT for DFS:**
```java  
Stack<String> stack = new Stack<>();  // Use Stack for iterative DFS
```

### **Mistake 3: Path reconstruction goes backwards**

**❌ WRONG:**
```java
public List<String> getPath(String destination) {
    List<String> path = new ArrayList<>();
    String current = destination;
    
    while (current != null) {
        path.add(current);
        current = parents.get(current);  
    }
    
    return path;  // This goes destination → start, not start → destination!
}
```

**✅ CORRECT:**
```java
public List<String> getPath(String destination) {
    List<String> path = new ArrayList<>();
    String current = destination;
    
    while (current != null) {
        path.add(current);
        current = parents.get(current);
    }
    
    Collections.reverse(path);  // Fix the direction!
    return path;
}
```

---

## 🧪 Test Your Understanding

### **Exercise 1: Trace BFS yourself**
```
Graph:
    1 ---- 2 ---- 5
    |      |      |
    3 ---- 4 ---- 6

Starting from vertex 1, what order should BFS visit the vertices?
Show the queue contents at each step.
```

<details>
<summary>Click for answer</summary>

**BFS from 1:**
- Step 0: Queue=[1], Visited={1}
- Step 1: Process 1, Queue=[2,3], Visited={1,2,3}  
- Step 2: Process 2, Queue=[3,5,4], Visited={1,2,3,5,4}
- Step 3: Process 3, Queue=[5,4], Visited={1,2,3,5,4} (no new neighbors)
- Step 4: Process 5, Queue=[4,6], Visited={1,2,3,5,4,6}  
- Step 5: Process 4, Queue=[6], Visited={1,2,3,5,4,6} (no new neighbors)
- Step 6: Process 6, Queue=[], Done

**Order: 1 → 2 → 3 → 5 → 4 → 6**
</details>

### **Exercise 2: Find the shortest path**
```
Same graph as above.
What is the shortest path from vertex 1 to vertex 6?
What is its length?
```

<details>
<summary>Click for answer</summary>

**Shortest path: 1 → 2 → 5 → 6**
**Length: 3**

Alternative paths exist (like 1→3→4→6) but they are longer.
</details>

### **Exercise 3: Spot the bug**
```java
// This student's BFS doesn't work. Can you spot why?
public List<String> brokenBFS(String start) {
    Stack<String> queue = new Stack<>();  // Bug 1?
    Set<String> visited = new HashSet<>();
    List<String> result = new ArrayList<>();
    
    queue.push(start);
    
    while (!queue.isEmpty()) {
        String current = queue.pop();
        
        if (visited.contains(current)) {
            continue;
        }
        
        visited.add(current);  // Bug 2?
        result.add(current);
        
        for (String neighbor : getNeighbors(current)) {
            queue.push(neighbor);  // Bug 3?
        }
    }
    
    return result;
}
```

<details>
<summary>Click for answer</summary>

**Bug 1:** Using Stack instead of Queue makes this DFS, not BFS!
**Bug 2:** Not checking if already visited before adding to stack causes duplicates
**Bug 3:** Adding all neighbors without checking if visited causes infinite loops

**Fixed version:**
```java
public List<String> fixedBFS(String start) {
    Queue<String> queue = new LinkedList<>();  // Fix 1: Use Queue
    Set<String> visited = new HashSet<>();
    List<String> result = new ArrayList<>();
    
    queue.offer(start);
    visited.add(start);  // Fix 2: Mark start as visited
    
    while (!queue.isEmpty()) {
        String current = queue.poll();
        result.add(current);
        
        for (String neighbor : getNeighbors(current)) {
            if (!visited.contains(neighbor)) {  // Fix 3: Check before adding
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
    }
    
    return result;
}
```
</details>

---

## 🎯 Quick Reference

### **When to use BFS vs DFS:**

**Use BFS when:**
- ✅ You need the shortest path (unweighted graphs)
- ✅ You want to explore nearby vertices first  
- ✅ You're looking for the closest solution
- ✅ Memory usage is not a concern

**Use DFS when:**
- ✅ You want to explore far/deep first
- ✅ You're looking for any solution (not necessarily shortest)
- ✅ You want to detect cycles  
- ✅ Memory is limited (DFS uses less memory)

### **Data structures cheat sheet:**
- **BFS:** Queue (LinkedList in Java)
- **DFS iterative:** Stack  
- **DFS recursive:** System call stack (automatic)
- **Visited tracking:** Set (HashSet in Java)
- **Parent tracking:** Map (HashMap in Java)

### **Time and space complexity:**
- **Both BFS and DFS:** O(V + E) time, O(V) space
- **V** = number of vertices, **E** = number of edges

Remember: These algorithms are building blocks for many advanced graph algorithms. Master these basics, and you'll be ready for shortest path algorithms like Dijkstra's and A*!