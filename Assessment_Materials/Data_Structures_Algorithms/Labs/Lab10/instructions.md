# Lab 10: Graph Traversals Implementation

## Overview
**Week:** 13  
**Due Date:** Thursday of Week 13, 11:59 PM  
**Points:** 100 points  
**Estimated Time:** 7-9 hours

This lab focuses on implementing graph data structures and fundamental traversal algorithms. You'll build both adjacency list and adjacency matrix representations, implement Breadth-First Search (BFS) and Depth-First Search (DFS) algorithms, and apply these concepts to solve pathfinding problems. This lab serves as preparation for more advanced graph algorithms in your final project.

---

## Learning Objectives

By the end of this lab, you will be able to:

1. **Graph Representation**
   - Implement adjacency list representation for graphs
   - Implement adjacency matrix representation for graphs
   - Compare memory and performance trade-offs between representations
   - Handle both directed and undirected graphs

2. **Traversal Algorithms**
   - Implement Breadth-First Search (BFS) traversal
   - Implement Depth-First Search (DFS) traversal (both recursive and iterative)
   - Understand when to use each traversal method
   - Analyze time and space complexity of traversals

3. **Pathfinding Applications**
   - Find shortest paths using BFS (unweighted graphs)
   - Detect connectivity and connected components
   - Implement path reconstruction from traversal results
   - Apply graph traversals to real-world problems

4. **Algorithm Analysis**
   - Compare performance of different graph representations
   - Analyze memory usage for sparse vs. dense graphs
   - Benchmark traversal algorithms on various graph types
   - Understand practical applications of graph algorithms

---

## Prerequisites

Before starting this lab, ensure you understand:
- Linked lists and dynamic arrays from earlier labs
- Queue and Stack ADTs (Lab 4)
- Recursion concepts (Lab 5)
- Big-O analysis and algorithm complexity
- Basic understanding of trees (preparation for graph structures)

---

## Background: Graph Theory and Traversals

### Core Concepts

**Graph Terminology**:
- **Vertex (Node)**: Individual data points in the graph
- **Edge**: Connection between two vertices
- **Adjacent**: Two vertices connected by an edge
- **Degree**: Number of edges connected to a vertex
- **Path**: Sequence of vertices connected by edges
- **Cycle**: Path that starts and ends at the same vertex

**Graph Types**:
- **Directed vs. Undirected**: Whether edges have direction
- **Weighted vs. Unweighted**: Whether edges have associated costs
- **Dense vs. Sparse**: Ratio of actual edges to possible edges
- **Connected vs. Disconnected**: Whether all vertices are reachable

### Graph Representations

**Adjacency List**:
- Each vertex maintains a list of its neighbors
- Memory efficient for sparse graphs: O(V + E)
- Fast to iterate through neighbors of a vertex
- Adding edges is O(1), checking edge existence is O(degree)

**Adjacency Matrix**:
- 2D array where matrix[i][j] indicates edge from vertex i to j
- Memory usage: O(V²) regardless of edge count
- Fast edge existence checking: O(1)
- Less efficient for sparse graphs but excellent for dense graphs

### Traversal Algorithms

**Breadth-First Search (BFS)**:
- Explores vertices level by level
- Uses a queue data structure
- Guarantees shortest path in unweighted graphs
- Time complexity: O(V + E), Space complexity: O(V)

**Depth-First Search (DFS)**:
- Explores as far as possible along each branch before backtracking
- Can be implemented recursively or with a stack
- Useful for cycle detection and topological sorting
- Time complexity: O(V + E), Space complexity: O(V)

---

## Part 1: Graph Structure Implementation (90 minutes)

### Step 1.1: Basic Graph Classes (30 minutes)

First, examine and complete the `GraphVertex.java` helper class:
```java
public class GraphVertex {
    private String label;
    private int id;
    private boolean visited;
    
    // Constructor, getters, setters
    // Implement equals() and hashCode() for proper Set operations
}
```

Review the `GraphEdge.java` class for weighted graphs:
```java
public class GraphEdge {
    private GraphVertex source;
    private GraphVertex destination;
    private double weight;
    
    // Constructor and methods for weighted edge handling
}
```

### Step 1.2: Adjacency List Implementation (60 minutes)

Implement the adjacency list representation in `Graph.java`:

```java
public class Graph {
    private Map<String, GraphVertex> vertices;
    private Map<GraphVertex, List<GraphVertex>> adjacencyList;
    private boolean isDirected;
    private boolean isWeighted;
    
    public void addVertex(String label) {
        // 1. Create new GraphVertex
        // 2. Add to vertices map
        // 3. Initialize empty adjacency list
    }
    
    public void addEdge(String source, String destination, double weight) {
        // 1. Get or create source and destination vertices
        // 2. Add destination to source's adjacency list
        // 3. If undirected, add source to destination's list
        // 4. Handle weighted edges appropriately
    }
    
    public List<GraphVertex> getNeighbors(String vertex) {
        // Return list of adjacent vertices
    }
    
    public boolean hasEdge(String source, String destination) {
        // Check if edge exists between vertices
    }
}
```

---

## Part 2: Adjacency Matrix Implementation (75 minutes)

### Step 2.1: Matrix Structure Setup (25 minutes)

Create `GraphMatrix.java` for matrix-based representation:
```java
public class GraphMatrix {
    private double[][] matrix;
    private Map<String, Integer> vertexIndexMap;
    private List<String> vertexLabels;
    private int capacity;
    private int vertexCount;
    private boolean isDirected;
    
    public GraphMatrix(int initialCapacity, boolean directed) {
        // Initialize matrix and supporting data structures
    }
}
```

### Step 2.2: Matrix Operations (50 minutes)

Implement core matrix operations:

**Adding Vertices**:
```java
public void addVertex(String label) {
    // 1. Check capacity and resize matrix if needed
    // 2. Add vertex to label list and index map
    // 3. Initialize new row/column in matrix
}

private void resizeMatrix() {
    // Double capacity and copy existing data
    // Handle both matrix and supporting structures
}
```

**Adding Edges**:
```java
public void addEdge(String source, String destination, double weight) {
    // 1. Get indices for source and destination
    // 2. Set matrix[sourceIndex][destIndex] = weight
    // 3. If undirected, set matrix[destIndex][sourceIndex] = weight
}
```

**Edge Queries**:
```java
public boolean hasEdge(String source, String destination) {
    // Check matrix value at appropriate indices
}

public List<String> getNeighbors(String vertex) {
    // Scan matrix row to find non-zero entries
}
```

---

## Part 3: Breadth-First Search Implementation (90 minutes)

### Step 3.1: BFS Algorithm Structure (30 minutes)

Create `GraphTraversals.java` with BFS implementation:
```java
public class GraphTraversals {
    
    public static List<String> breadthFirstSearch(Graph graph, String startVertex) {
        // Initialize data structures
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> traversalOrder = new ArrayList<>();
        
        // BFS algorithm implementation
    }
}
```

### Step 3.2: BFS with Path Tracking (60 minutes)

Implement BFS with parent tracking for pathfinding:

```java
public static BFSResult breadthFirstSearchWithPaths(Graph graph, String startVertex) {
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    Map<String, String> parentMap = new HashMap<>();
    Map<String, Integer> distanceMap = new HashMap<>();
    
    // 1. Initialize with start vertex
    queue.offer(startVertex);
    visited.add(startVertex);
    distanceMap.put(startVertex, 0);
    parentMap.put(startVertex, null);
    
    while (!queue.isEmpty()) {
        String current = queue.poll();
        
        // 2. Process all neighbors
        for (GraphVertex neighbor : graph.getNeighbors(current)) {
            String neighborLabel = neighbor.getLabel();
            
            if (!visited.contains(neighborLabel)) {
                // 3. Mark as visited and update tracking info
                visited.add(neighborLabel);
                parentMap.put(neighborLabel, current);
                distanceMap.put(neighborLabel, distanceMap.get(current) + 1);
                queue.offer(neighborLabel);
            }
        }
    }
    
    return new BFSResult(parentMap, distanceMap, visited);
}
```

Create `BFSResult.java` to store traversal results:
```java
public class BFSResult {
    private Map<String, String> parentMap;
    private Map<String, Integer> distanceMap;
    private Set<String> visitedVertices;
    
    // Constructor and methods for path reconstruction
    public List<String> getShortestPath(String destination) {
        // Reconstruct path using parent pointers
    }
}
```

---

## Part 4: Depth-First Search Implementation (90 minutes)

### Step 4.1: Recursive DFS (45 minutes)

Implement recursive DFS in `GraphTraversals.java`:

```java
public static List<String> depthFirstSearchRecursive(Graph graph, String startVertex) {
    Set<String> visited = new HashSet<>();
    List<String> traversalOrder = new ArrayList<>();
    
    dfsRecursiveHelper(graph, startVertex, visited, traversalOrder);
    return traversalOrder;
}

private static void dfsRecursiveHelper(Graph graph, String vertex, 
                                     Set<String> visited, List<String> order) {
    // 1. Mark current vertex as visited
    visited.add(vertex);
    order.add(vertex);
    
    // 2. Recursively visit all unvisited neighbors
    for (GraphVertex neighbor : graph.getNeighbors(vertex)) {
        String neighborLabel = neighbor.getLabel();
        if (!visited.contains(neighborLabel)) {
            dfsRecursiveHelper(graph, neighborLabel, visited, order);
        }
    }
}
```

### Step 4.2: Iterative DFS (45 minutes)

Implement iterative DFS using a stack:

```java
public static List<String> depthFirstSearchIterative(Graph graph, String startVertex) {
    Stack<String> stack = new Stack<>();
    Set<String> visited = new HashSet<>();
    List<String> traversalOrder = new ArrayList<>();
    
    stack.push(startVertex);
    
    while (!stack.isEmpty()) {
        String current = stack.pop();
        
        if (!visited.contains(current)) {
            // 1. Mark as visited and add to order
            visited.add(current);
            traversalOrder.add(current);
            
            // 2. Add all unvisited neighbors to stack
            List<GraphVertex> neighbors = graph.getNeighbors(current);
            // Note: Add in reverse order to maintain left-to-right traversal
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                String neighbor = neighbors.get(i).getLabel();
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    }
    
    return traversalOrder;
}
```

---

## Part 5: Pathfinding Applications (105 minutes)

### Step 5.1: Shortest Path Implementation (45 minutes)

Create `PathFinder.java` with pathfinding utilities:

```java
public class PathFinder {
    
    public static List<String> findShortestPath(Graph graph, String start, String end) {
        // Use BFS to find shortest unweighted path
        BFSResult result = GraphTraversals.breadthFirstSearchWithPaths(graph, start);
        return result.getShortestPath(end);
    }
    
    public static int getShortestDistance(Graph graph, String start, String end) {
        // Return length of shortest path, -1 if no path exists
        BFSResult result = GraphTraversals.breadthFirstSearchWithPaths(graph, start);
        return result.getDistance(end);
    }
}
```

### Step 5.2: Connected Components (60 minutes)

Implement connected component analysis:

```java
public static List<Set<String>> findConnectedComponents(Graph graph) {
    List<Set<String>> components = new ArrayList<>();
    Set<String> globalVisited = new HashSet<>();
    
    // 1. Get all vertices in the graph
    Set<String> allVertices = graph.getAllVertices();
    
    for (String vertex : allVertices) {
        if (!globalVisited.contains(vertex)) {
            // 2. Find all vertices in this component using DFS
            Set<String> componentVertices = new HashSet<>();
            dfsForComponent(graph, vertex, globalVisited, componentVertices);
            components.add(componentVertices);
        }
    }
    
    return components;
}

private static void dfsForComponent(Graph graph, String vertex, 
                                  Set<String> globalVisited, Set<String> component) {
    globalVisited.add(vertex);
    component.add(vertex);
    
    for (GraphVertex neighbor : graph.getNeighbors(vertex)) {
        String neighborLabel = neighbor.getLabel();
        if (!globalVisited.contains(neighborLabel)) {
            dfsForComponent(graph, neighborLabel, globalVisited, component);
        }
    }
}
```

---

## Part 6: Performance Analysis and Comparison (75 minutes)

### Step 6.1: Representation Performance (45 minutes)

Create `GraphAnalysis.java` to benchmark different representations:

```java
public class GraphAnalysis {
    
    public void compareRepresentations() {
        // Test with different graph sizes and densities
        int[] vertexCounts = {50, 100, 500, 1000};
        double[] densities = {0.1, 0.25, 0.5, 0.75};
        
        for (int vertices : vertexCounts) {
            for (double density : densities) {
                benchmarkRepresentation(vertices, density);
            }
        }
    }
    
    private void benchmarkRepresentation(int vertexCount, double density) {
        // 1. Generate test graphs with specified parameters
        Graph adjListGraph = generateRandomGraph(vertexCount, density, false);
        GraphMatrix adjMatrixGraph = generateRandomGraph(vertexCount, density, true);
        
        // 2. Time various operations
        long listTime = timeTraversal(adjListGraph, "BFS");
        long matrixTime = timeTraversal(adjMatrixGraph, "BFS");
        
        // 3. Measure memory usage
        long listMemory = estimateMemoryUsage(adjListGraph);
        long matrixMemory = estimateMemoryUsage(adjMatrixGraph);
        
        // 4. Record results
        recordResults(vertexCount, density, listTime, matrixTime, 
                     listMemory, matrixMemory);
    }
}
```

### Step 6.2: Traversal Algorithm Comparison (30 minutes)

Compare BFS vs DFS performance:

```java
public void compareTraversalAlgorithms() {
    // Test on various graph types
    Graph[] testGraphs = {
        createLinearGraph(100),      // Chain-like graph
        createCompleteGraph(50),     // Dense graph
        createTreeGraph(100),        // Tree structure
        createRandomGraph(100, 0.3)  // Random sparse graph
    };
    
    for (Graph graph : testGraphs) {
        String startVertex = graph.getRandomVertex();
        
        // Time each traversal method
        long bfsTime = timeTraversal(graph, "BFS", startVertex);
        long dfsRecursiveTime = timeTraversal(graph, "DFS_RECURSIVE", startVertex);
        long dfsIterativeTime = timeTraversal(graph, "DFS_ITERATIVE", startVertex);
        
        // Measure memory usage during traversal
        long bfsMemory = measureTraversalMemory(graph, "BFS", startVertex);
        long dfsMemory = measureTraversalMemory(graph, "DFS", startVertex);
        
        recordTraversalResults(graph.getType(), bfsTime, dfsRecursiveTime, 
                             dfsIterativeTime, bfsMemory, dfsMemory);
    }
}
```

---

## Part 7: Integration with Semester Project (45 minutes)

### Step 7.1: Project Application Analysis
Consider how graph traversals can enhance your semester project:

**Social Network Applications**:
- **Friend recommendations**: BFS to find mutual friends
- **Influence propagation**: DFS to trace information spread
- **Community detection**: Connected components analysis

**Navigation Systems**:
- **Route planning**: BFS for shortest path finding
- **Network topology**: DFS for exploring network structure
- **Connectivity analysis**: Component detection for network reliability

**Data Processing Applications**:
- **Dependency resolution**: DFS for processing order
- **Data flow analysis**: BFS for level-by-level processing
- **Circular dependency detection**: DFS cycle detection

### Step 7.2: Implementation Planning
Document your integration strategy:
```java
/**
 * Project Integration Plan for Graph Traversals
 * 
 * Primary Use Case: [Describe how graphs fit your project]
 * Graph Representation Choice: [Adjacency List/Matrix and why]
 * Key Algorithms Needed: [BFS/DFS applications]
 * Expected Performance Requirements: [Graph size, operation frequency]
 * Integration Points: [Which classes will use graph functionality]
 */
```

---

## Testing Requirements

### Unit Tests (Required)
Your `GraphTest.java` should include comprehensive tests:

**Graph Construction Tests**:
```java
@Test
public void testAddVertex() {
    // Test vertex addition, duplicate handling
}

@Test  
public void testAddEdge() {
    // Test edge addition for directed/undirected graphs
    // Test weighted/unweighted edge handling
}

@Test
public void testGraphProperties() {
    // Test vertex count, edge count, connectivity
}
```

**Traversal Algorithm Tests**:
```java
@Test
public void testBFSTraversal() {
    // Test BFS on known graphs with expected order
    // Test disconnected graph handling
}

@Test
public void testDFSTraversal() {
    // Test both recursive and iterative DFS
    // Compare results for consistency
}

@Test
public void testPathfinding() {
    // Test shortest path finding
    // Test unreachable destination handling
}
```

**Performance and Edge Case Tests**:
```java
@Test
public void testLargeGraphs() {
    // Test scalability with large graphs
}

@Test
public void testEdgeCases() {
    // Empty graphs, single vertex, self-loops
    // Cyclic and acyclic graphs
}
```

### Integration Tests (Required)
- Test graph representations with same data for consistency
- Verify BFS shortest paths are actually shortest
- Confirm DFS explores all reachable vertices
- Validate connected component detection accuracy

---

## Submission Requirements

Submit the following files to GitHub Classroom:

1. **`Graph.java`** - Adjacency list implementation with all operations
2. **`GraphMatrix.java`** - Adjacency matrix implementation  
3. **`GraphVertex.java`** and **`GraphEdge.java`** - Helper classes
4. **`GraphTraversals.java`** - Complete BFS and DFS implementations
5. **`PathFinder.java`** - Pathfinding algorithms and utilities
6. **`BFSResult.java`** - Result class for BFS with path tracking
7. **`GraphTest.java`** - Comprehensive unit test suite
8. **`GraphAnalysis.java`** - Performance benchmarking implementation
9. **`lab10_report.md`** - Analysis report and project integration discussion
10. **`traversal_performance.txt`** - Performance comparison data
11. **`pathfinding_results.txt`** - Pathfinding algorithm analysis
12. **`sample_graphs.txt`** - Test graphs used in analysis

### Repository Organization
```
lab10-graph-traversals-[username]/
├── src/
│   ├── Graph.java
│   ├── GraphMatrix.java  
│   ├── GraphVertex.java
│   ├── GraphEdge.java
│   ├── GraphTraversals.java
│   ├── PathFinder.java
│   ├── BFSResult.java
│   ├── GraphTest.java
│   └── GraphAnalysis.java
├── data/
│   ├── traversal_performance.txt
│   ├── pathfinding_results.txt
│   └── sample_graphs.txt
├── lab10_report.md
└── README.md
```

---

## Assessment Rubric

| **Category** | **Excellent (90-100%)** | **Good (80-89%)** | **Satisfactory (70-79%)** | **Needs Improvement (0-69%)** | **Weight** |
|--------------|-------------------------|-------------------|---------------------------|------------------------------|------------|
| **Graph Representations** | Both adjacency list and matrix perfectly implemented; handles all graph types; efficient operations; excellent edge case handling | Good implementations with minor issues; handles most graph types; generally efficient operations; adequate edge case handling | Basic implementations working for simple cases; some graph type limitations; acceptable performance; minimal edge case handling | Major issues in implementations; doesn't handle multiple graph types; poor performance; fails on edge cases | **35%** |
| **Traversal Algorithms** | BFS and DFS (both versions) perfectly implemented; correct traversal order; efficient implementation; handles all graph types | Good algorithm implementations; mostly correct traversal; reasonable efficiency; handles common graph types | Basic algorithms working for simple graphs; some correctness issues; acceptable efficiency; limited graph type support | Major algorithmic errors; incorrect traversal results; poor efficiency; fails on common graph types | **30%** |
| **Pathfinding Implementation** | Excellent shortest path finding; perfect path reconstruction; handles unreachable destinations; connected components analysis working | Good pathfinding with minor issues; mostly correct path reconstruction; handles most cases; basic component analysis | Basic pathfinding for simple cases; some path reconstruction issues; limited case handling; minimal component analysis | Major pathfinding errors; incorrect paths; poor case handling; missing component analysis | **20%** |
| **Testing & Analysis** | Comprehensive test suite covering all scenarios; thorough performance analysis; insightful comparisons; excellent documentation | Good test coverage with minor gaps; solid performance analysis; reasonable comparisons; good documentation | Basic testing covering main functionality; limited performance analysis; simple comparisons; adequate documentation | Minimal testing; little to no performance analysis; poor or missing comparisons; inadequate documentation | **10%** |
| **Professional Submission** | Submitted on time; perfectly organized; detailed analysis report; excellent project integration discussion; clean commit history | Submitted on time; well-organized; good analysis report; solid project integration; regular commits | Submitted on time; adequately organized; basic analysis report; some project integration; occasional commits | Late submission or poor organization; minimal analysis; little project integration; few or unclear commits | **5%** |

### **Grade Scale:**
- **A (90-100%)**: Exceptional understanding of graph algorithms and data structures
- **B (80-89%)**: Good grasp of concepts with solid implementation skills
- **C (70-79%)**: Satisfactory understanding meeting basic requirements  
- **D (60-69%)**: Below expectations with significant conceptual gaps
- **F (0-59%)**: Failing to demonstrate minimum competency

---

## Getting Help

### Before Asking for Help:
1. **Test with small graphs first**: Use 3-4 vertex graphs to verify algorithms manually
2. **Trace through algorithms step-by-step**: Follow BFS/DFS by hand to understand expected behavior
3. **Check visited set management**: Ensure vertices are marked visited at the correct time
4. **Verify graph construction**: Print adjacency lists/matrices to confirm correct structure
5. **Test edge cases**: Empty graphs, single vertices, disconnected components

### Office Hours Topics:
- Graph representation trade-offs and selection criteria
- Debugging infinite loops in traversal algorithms
- Path reconstruction logic and parent pointer usage
- Performance optimization for specific graph characteristics
- Integration strategies for semester projects

### Collaboration Policy:
- Discuss graph theory concepts and algorithm approaches
- Share debugging strategies and testing methodologies
- **Do NOT share actual graph implementation code or traversal logic**
- All submitted code must be your own individual work

---

## Resources

### Required Reading:
- Textbook Chapter 13: Graphs and Graph Algorithms
- Course notes on BFS and DFS implementations
- Graph representation comparison materials

### Visualization Tools:
- [Graph Algorithm Visualizer](https://visualgo.net/en/dfsbfs)
- [BFS/DFS Interactive Demo](https://www.cs.usfca.edu/~galles/visualization/BFS.html)
- [Graph Theory Playground](https://graphonline.ru/en/)

### Reference Materials:
- Java Collections Framework for graph implementation
- Algorithm complexity analysis examples
- Real-world graph algorithm applications

### Optional Advanced Reading:
- Dijkstra's algorithm for weighted shortest paths
- A* search algorithm for heuristic pathfinding
- Network analysis and centrality measures

---

**Final Note:** Graph traversals are fundamental algorithms that appear throughout computer science, from web crawling to social network analysis to compiler design. The BFS and DFS implementations you create here will serve as building blocks for more sophisticated algorithms. Focus on understanding not just how these algorithms work, but when and why to use each approach. The pathfinding applications demonstrate the practical power of these seemingly simple traversal techniques.