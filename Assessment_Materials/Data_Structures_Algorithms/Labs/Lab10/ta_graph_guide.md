# TA Guide: Lab 10 - Graph Traversals

## Overview for TAs

**Lab Focus:** Graph data structures and traversal algorithms (BFS/DFS)  
**Estimated Student Time:** 7-9 hours  
**Key Challenge Areas:** Algorithm logic, visited set management, path reconstruction  
**Most Common Help Requests:** Infinite loops, incorrect traversal order, pathfinding bugs

---

## Pre-Lab Preparation for TAs

### Review These Concepts:
1. **Graph representations**: Adjacency lists vs. matrices trade-offs
2. **Queue and Stack operations**: Students may struggle with proper usage
3. **Recursion vs. iteration**: DFS implementations and stack overflow issues
4. **Set operations**: Visited tracking and membership testing
5. **Path reconstruction**: Parent pointers and backtracking logic

### Test the Lab Yourself:
- Complete the core implementations (2-3 hours)
- Identify potential stumbling points
- Create small test graphs for demonstrations
- Prepare visual aids (hand-drawn graphs) for office hours

---

## Common Student Misconceptions

### 1. Graph Representation Confusion
**Misconception:** "Adjacency lists are always better than matrices"
**Reality:** Choice depends on graph density and operation frequency
**TA Response:** 
- Show memory usage: List = O(V+E), Matrix = O(V²)
- Demonstrate when matrix is better (dense graphs, frequent edge queries)
- Use concrete examples: social network (sparse) vs. city distances (dense)

### 2. BFS vs. DFS Understanding
**Misconception:** "BFS and DFS visit vertices in the same order"
**Reality:** Traversal order depends on data structure used (queue vs. stack)
**TA Response:**
- Draw small graph on whiteboard and trace both algorithms
- Emphasize: BFS uses queue (FIFO), DFS uses stack/recursion (LIFO)
- Show level-by-level vs. depth-first exploration visually

### 3. Visited Set Timing
**Misconception:** "Mark vertex as visited when processing, not when adding to queue/stack"
**Reality:** This causes duplicate processing and can create infinite loops
**TA Response:**
- Trace through algorithm showing what happens with both approaches
- Point out that vertices should be marked visited when first encountered
- Show how late marking leads to multiple queue/stack entries

---

## Most Common Bugs and Solutions

### 1. Infinite Loops in Traversal

**Symptoms:**
- Program hangs during BFS/DFS
- Stack overflow in recursive DFS
- "Out of memory" errors

**Common Causes:**
```java
// WRONG - marking visited too late
while (!queue.isEmpty()) {
    String current = queue.poll();
    visited.add(current);  // ❌ Too late!
    
    for (neighbor : getNeighbors(current)) {
        if (!visited.contains(neighbor)) {
            queue.offer(neighbor);  // ❌ Can add same vertex multiple times
        }
    }
}
```

**Debugging Steps:**
1. Ask: "When do you mark vertices as visited?"
2. Have them add print statements to see queue/stack contents
3. Test on triangle graph: A-B-C-A to demonstrate cycle issues

**Solution:**
```java
// CORRECT - mark visited when adding to queue
queue.offer(startVertex);
visited.add(startVertex);  // ✅ Mark immediately

while (!queue.isEmpty()) {
    String current = queue.poll();
    
    for (neighbor : getNeighbors(current)) {
        if (!visited.contains(neighbor)) {
            visited.add(neighbor);  // ✅ Mark before adding to queue
            queue.offer(neighbor);
        }
    }
}
```

### 2. Incorrect DFS Order (Iterative)

**Problem:** Student's iterative DFS doesn't match recursive order
**Common Cause:** Not reversing neighbor order when pushing to stack

**Debugging Approach:**
```java
// Show them this example on graph: A connects to [B, C, D]

// Recursive DFS visits: A, B, ..., C, ..., D, ...
// But iterative with stack visits: A, D, ..., C, ..., B, ...

// Solution: Reverse the order when pushing to stack
for (int i = neighbors.size() - 1; i >= 0; i--) {
    stack.push(neighbors.get(i));
}
```

### 3. Path Reconstruction Errors

**Symptoms:**
- Shortest path returns null or wrong path
- Path goes in wrong direction
- Path includes unreachable destination

**Common Issues:**
```java
// WRONG - not checking if destination was reached
public List<String> getShortestPath(String destination) {
    List<String> path = new ArrayList<>();
    String current = destination;
    
    // ❌ What if destination not in parentMap?
    while (current != null) {
        path.add(current);
        current = parentMap.get(current);
    }
    
    Collections.reverse(path);
    return path;  // ❌ Could return path for unreachable vertex
}
```

**Debugging Questions:**
1. "Did BFS actually reach the destination vertex?"
2. "What's in your parent map after BFS runs?"
3. "What should you return if there's no path?"

---

## Step-by-Step Help Strategy

### For Students Stuck on Graph Construction:

1. **Start Simple:** "Let's build a 3-vertex graph first"
2. **Visualize:** Draw the graph on paper/whiteboard
3. **Trace Operations:** Walk through addVertex() and addEdge() calls
4. **Check Data Structures:** Print adjacency list contents
5. **Test Queries:** Verify getNeighbors() and hasEdge() work

### For Traversal Algorithm Issues:

1. **Manual Trace:** Use tiny graph (3-4 vertices) and trace by hand
2. **Print Debugging:** Add prints for queue/stack contents and visited set
3. **Check Initialization:** Verify starting conditions
4. **Verify Loop Conditions:** Ensure proper termination
5. **Test Edge Cases:** Empty graph, single vertex, disconnected components

### For Performance Problems:

1. **Check Graph Size:** "How big is your test graph?"
2. **Analyze Operations:** "Which operations are taking longest?"
3. **Review Representation:** "Is adjacency list/matrix appropriate here?"
4. **Look for Nested Loops:** Identify O(n²) bottlenecks
5. **Memory Usage:** Check if creating unnecessary objects

---

## Office Hours Talking Points

### Opening Questions:
- "What part of the lab are you working on?"
- "Can you show me a small example that's not working?"
- "Have you tested your graph construction methods first?"
- "Let's trace through your algorithm step by step"

### Key Concepts to Reinforce:

**Graph Representation Choice:**
- "Dense graphs (lots of edges) → Matrix often better"
- "Sparse graphs (few edges) → Adjacency list usually better"
- "Frequent edge existence queries → Matrix advantage"
- "Iterating through neighbors → List advantage"

**Algorithm Selection:**
- "Need shortest path? Use BFS for unweighted graphs"
- "Exploring all possibilities? DFS might be better"
- "Want specific traversal order? Consider which data structure gives that"

**Common Optimizations:**
- "Can you avoid recreating data structures?"
- "Are you checking visited status efficiently?"
- "Do you need to store all intermediate results?"

### Debugging Demonstrations:

**BFS Trace Example (use in office hours):**
```
Graph: A-B, A-C, B-D, C-D

Step 1: Queue=[A], Visited={A}
Step 2: Process A, Queue=[B,C], Visited={A,B,C}  
Step 3: Process B, Queue=[C,D], Visited={A,B,C,D}
Step 4: Process C, Queue=[D], Visited={A,B,C,D} (D already visited)
Step 5: Process D, Queue=[], Done

Final order: A, B, C, D
```

---

## Code Review Guidelines

### What to Look For:

**Graph Implementation:**
- ✅ Proper handling of directed vs. undirected edges
- ✅ Consistent vertex labeling (String keys)
- ✅ Appropriate data structure choices
- ❌ Memory leaks from not cleaning up removed vertices
- ❌ Inconsistent edge weight handling

**Traversal Algorithms:**
- ✅ Correct visited set management
- ✅ Proper queue/stack usage
- ✅ Handles disconnected graphs appropriately
- ❌ Marking vertices visited at wrong time
- ❌ Not checking for null/empty inputs
- ❌ Infinite loops on cyclic graphs

**Path Finding:**
- ✅ Correct parent pointer tracking
- ✅ Proper path reconstruction
- ✅ Handles unreachable destinations
- ❌ Wrong path direction (not reversing)
- ❌ Including start vertex in distance calculations incorrectly
- ❌ Not validating input vertices exist

### Grading Quick Checks:

**Functionality (35% weight):**
- Create test graph, run BFS/DFS, verify output order
- Test pathfinding on known shortest path
- Check edge cases: empty graph, single vertex

**Algorithm Correctness (30% weight):**
- BFS should find shortest paths in unweighted graphs
- DFS recursive and iterative should visit same vertices
- Connected components should be correctly identified

**Performance Analysis (20% weight):**
- Are timing results reasonable?
- Do memory usage comparisons make sense?
- Is analysis insightful or just raw data?

---

## Common Help Scenarios

### Scenario 1: "My BFS isn't finding the shortest path"
**Diagnostic Questions:**
- "Can you show me your BFS output for a simple graph?"
- "Are you tracking parent pointers correctly?"
- "How are you reconstructing the path?"

**Common Issues:**
- Using DFS instead of BFS for pathfinding
- Incorrect path reconstruction (not reversing)
- Not checking if destination is reachable

**Solution Approach:**
1. Test BFS traversal order first (before pathfinding)
2. Verify parent map contents after BFS
3. Trace path reconstruction step by step

### Scenario 2: "My program runs forever"
**Diagnostic Questions:**
- "When do you mark vertices as visited?"
- "Can you add print statements to see what's in your queue/stack?"
- "Have you tested on a graph without cycles?"

**Solution Approach:**
1. Test on simple acyclic graph first (tree)
2. Add debugging prints to show queue/stack contents
3. Fix visited marking timing
4. Then test on cyclic graphs

### Scenario 3: "My adjacency matrix is using too much memory"
**Diagnostic Questions:**
- "How many vertices are in your test graph?"
- "What percentage of possible edges actually exist?"
- "Do you need fast edge existence checking?"

**Solution Approach:**
1. Calculate actual memory usage: vertices² * sizeof(double)
2. Compare to adjacency list: (vertices + edges) * sizeof(pointer)
3. Discuss when to use each representation

---

## Quick Reference: Algorithm Complexities

**For TA Reference (don't just give to students):**

| Operation | Adjacency List | Adjacency Matrix |
|-----------|----------------|------------------|
| Add Vertex | O(1) | O(V²) if resize needed |
| Add Edge | O(1) | O(1) |
| Remove Edge | O(degree) | O(1) |
| Check Edge | O(degree) | O(1) |
| BFS/DFS | O(V + E) | O(V²) |
| Space | O(V + E) | O(V²) |

**When to Guide Students Toward Each:**
- **Adjacency List**: Sparse graphs, frequent traversals, memory-constrained
- **Adjacency Matrix**: Dense graphs, frequent edge queries, simple implementation

---

## Emergency Debugging Commands

**For when students are completely stuck:**

1. **Print Graph Structure:**
   ```java
   // Add this temporarily to see graph contents
   System.out.println("Vertices: " + vertices.keySet());
   for (String v : vertices.keySet()) {
       System.out.println(v + " -> " + getNeighbors(v));
   }
   ```

2. **Trace BFS/DFS:**
   ```java
   // Add prints inside traversal loop
   System.out.println("Processing: " + current);
   System.out.println("Queue: " + queue);
   System.out.println("Visited: " + visited);
   ```

3. **Check Path Reconstruction:**
   ```java
   // Print parent map after BFS
   System.out.println("Parent map: " + parentMap);
   System.out.println("Path to " + dest + ": " + getPath(dest));
   ```

---

## When to Escalate to Instructor

**Escalate if student has:**
- Fundamental misunderstanding of graph concepts after multiple explanations
- Code that works but uses completely wrong approach (e.g., brute force instead of BFS)
- Persistent conceptual confusion between trees and graphs
- Advanced questions about weighted shortest paths (Dijkstra's) beyond lab scope

**Don't escalate for:**
- Simple bugs that can be found through debugging
- Performance optimization questions
- Questions about alternative implementations
- Integration with semester project (you can guide this)

---

**Remember:** The goal is to guide students to understanding, not to fix their code for them. Ask leading questions, have them trace through examples, and encourage systematic debugging approaches.