import java.util.*;

/**
 * Unit tests for graph implementation and algorithms.
 * Add your own test methods to verify your implementations work correctly.
 * 
 * @author [Your Name]
 */
public class GraphTest {
    
    /**
     * Test basic graph construction and edge operations.
     */
    public static void testGraphConstruction() {
        System.out.println("=== Testing Graph Construction ===");
        
        Graph graph = new Graph(false); // undirected graph
        
        // Test adding vertices
        System.out.println("Adding vertices A, B, C");
        graph.addVertex("A");
        graph.addVertex("B"); 
        graph.addVertex("C");
        
        System.out.println("Vertex count: " + graph.getVertexCount()); // Should be 3
        
        // Test adding edges
        System.out.println("Adding edges A-B, B-C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        
        System.out.println("Edge A-B exists: " + graph.hasEdge("A", "B")); // Should be true
        System.out.println("Edge B-A exists: " + graph.hasEdge("B", "A")); // Should be true (undirected)
        System.out.println("Edge A-C exists: " + graph.hasEdge("A", "C")); // Should be false
        
        System.out.println("Neighbors of B: " + graph.getNeighbors("B")); // Should show A and C
        
        System.out.println("Graph structure:");
        System.out.println(graph);
    }
    
    /**
     * Test BFS traversal on a known graph.
     */
    public static void testBFS() {
        System.out.println("\n=== Testing BFS ===");
        
        // Create test graph:
        //     A
        //    / \
        //   B   C
        //  /   / \
        // D   E   F
        
        Graph graph = new Graph(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        
        List<String> bfsResult = GraphTraversals.breadthFirstSearch(graph, "A");
        System.out.println("BFS from A: " + bfsResult);
        // Expected: [A, B, C, D, E, F] (or [A, C, B, F, E, D] depending on order)
        
        // TODO: Add assertions to verify the result is correct
        // Hints for verification:
        // - First vertex should be A
        // - Should visit all 6 vertices
        // - Should visit B and C before D, E, F (level-order property)
    }
    
    /**
     * Test DFS traversal (both recursive and iterative).
     */
    public static void testDFS() {
        System.out.println("\n=== Testing DFS ===");
        
        // Use same graph as BFS test
        Graph graph = new Graph(false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        
        List<String> dfsRecursive = GraphTraversals.depthFirstSearchRecursive(graph, "A");
        List<String> dfsIterative = GraphTraversals.depthFirstSearchIterative(graph, "A");
        
        System.out.println("DFS Recursive from A: " + dfsRecursive);
        System.out.println("DFS Iterative from A: " + dfsIterative);
        
        // TODO: Verify that both methods visit all vertices
        // TODO: Check if recursive and iterative give same order
    }
    
    /**
     * Test shortest path finding.
     */
    public static void testShortestPath() {
        System.out.println("\n=== Testing Shortest Path ===");
        
        // Create a graph where shortest path is not obvious:
        //   A --- B --- E
        //   |     |     |  
        //   C --- D --- F
        
        Graph graph = new Graph(false);
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "E");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");
        
        List<String> path = PathFinder.findShortestPath(graph, "A", "F");
        int distance = PathFinder.getShortestDistance(graph, "A", "F");
        
        System.out.println("Shortest path A to F: " + path);
        System.out.println("Distance A to F: " + distance);
        
        // TODO: Verify this is actually the shortest path
        // Expected: [A, B, E, F] or [A, C, D, F] both have length 3
    }
    
    /**
     * Test connected components finding.
     */
    public static void testConnectedComponents() {
        System.out.println("\n=== Testing Connected Components ===");
        
        // Create graph with multiple components:
        // Component 1: A-B-C
        // Component 2: D-E  
        // Component 3: F (isolated)
        
        Graph graph = new Graph(false);
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("D", "E");
        graph.addVertex("F"); // isolated vertex
        
        List<Set<String>> components = GraphTraversals.findConnectedComponents(graph);
        
        System.out.println("Connected components: " + components);
        System.out.println("Number of components: " + components.size()); // Should be 3
        
        // TODO: Verify that we found exactly 3 components with correct vertices
    }
    
    /**
     * Test edge cases and error conditions.
     */
    public static void testEdgeCases() {
        System.out.println("\n=== Testing Edge Cases ===");
        
        Graph graph = new Graph(false);
        
        // Test empty graph
        List<String> emptyBFS = GraphTraversals.breadthFirstSearch(graph, "NonExistent");
        System.out.println("BFS on empty graph: " + emptyBFS); // Should be empty
        
        // Test single vertex
        graph.addVertex("Alone");
        List<String> singleBFS = GraphTraversals.breadthFirstSearch(graph, "Alone");
        System.out.println("BFS on single vertex: " + singleBFS); // Should be [Alone]
        
        // Test path to non-existent vertex
        List<String> noPath = PathFinder.findShortestPath(graph, "Alone", "NotThere");
        System.out.println("Path to non-existent vertex: " + noPath); // Should be null
        
        // TODO: Add more edge case tests as you think of them
    }
    
    /**
     * Runs all tests.
     */
    public static void main(String[] args) {
        System.out.println("Running Graph Tests...\n");
        
        testGraphConstruction();
        testBFS();
        testDFS();
        testShortestPath();
        testConnectedComponents();
        testEdgeCases();
        
        System.out.println("\n=== Tests Complete ===");
        System.out.println("Review the output above to verify your implementations work correctly.");
        System.out.println("Add more specific assertions and tests as you develop your code.");
    }
}