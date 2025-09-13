import java.util.*;

/**
 * Contains static methods for graph traversal algorithms.
 * Implements both BFS and DFS (recursive and iterative versions).
 * 
 * @author [Your Name]
 */
public class GraphTraversals {
    
    /**
     * Performs breadth-first search starting from the given vertex.
     * @param graph the graph to search
     * @param startVertex the vertex to start from
     * @return list of vertices in BFS order
     */
    public static List<String> breadthFirstSearch(Graph graph, String startVertex) {
        // TODO: Implement BFS
        // Remember the algorithm:
        // 1. Use a Queue (LinkedList)
        // 2. Use a Set to track visited vertices
        // 3. Mark vertices as visited WHEN ADDING TO QUEUE, not when processing
        // 4. Process queue until empty
        
        List<String> result = new ArrayList<>();
        
        // Your implementation here
        
        return result;
    }
    
    /**
     * Performs BFS and tracks parent pointers for pathfinding.
     * @param graph the graph to search
     * @param startVertex the vertex to start from
     * @return BFSResult containing parent map and distance map
     */
    public static BFSResult breadthFirstSearchWithPaths(Graph graph, String startVertex) {
        // TODO: Implement BFS with parent tracking
        // This is similar to regular BFS but you also maintain:
        // - parentMap: tracks how you reached each vertex
        // - distanceMap: tracks distance from start vertex
        
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        
        // Your implementation here
        
        return new BFSResult(parentMap, distanceMap, visited);
    }
    
    /**
     * Performs depth-first search using recursion.
     * @param graph the graph to search  
     * @param startVertex the vertex to start from
     * @return list of vertices in DFS order
     */
    public static List<String> depthFirstSearchRecursive(Graph graph, String startVertex) {
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        dfsRecursiveHelper(graph, startVertex, visited, result);
        
        return result;
    }
    
    /**
     * Helper method for recursive DFS.
     * @param graph the graph being searched
     * @param vertex current vertex being processed
     * @param visited set of already visited vertices
     * @param result list collecting the traversal order
     */
    private static void dfsRecursiveHelper(Graph graph, String vertex, 
                                         Set<String> visited, List<String> result) {
        // TODO: Implement recursive DFS helper
        // Algorithm:
        // 1. Mark current vertex as visited
        // 2. Add current vertex to result
        // 3. For each unvisited neighbor, recursively call this method
        
        // Your implementation here
    }
    
    /**
     * Performs depth-first search using iteration and a stack.
     * @param graph the graph to search
     * @param startVertex the vertex to start from  
     * @return list of vertices in DFS order
     */
    public static List<String> depthFirstSearchIterative(Graph graph, String startVertex) {
        // TODO: Implement iterative DFS
        // Use a Stack instead of Queue
        // Important: To match recursive DFS order, add neighbors to stack in REVERSE order
        
        List<String> result = new ArrayList<>();
        
        // Your implementation here
        
        return result;
    }
    
    /**
     * Finds all connected components in the graph.
     * @param graph the graph to analyze
     * @return list of sets, each containing vertices in one component
     */
    public static List<Set<String>> findConnectedComponents(Graph graph) {
        // TODO: Implement connected components finder
        // Algorithm:
        // 1. Keep a global visited set
        // 2. For each unvisited vertex, start a new component
        // 3. Use DFS to find all vertices in that component
        // 4. Add component to results and repeat
        
        List<Set<String>> components = new ArrayList<>();
        
        // Your implementation here
        
        return components;
    }
    
    /**
     * Helper method for finding connected components.
     * Uses DFS to explore one component starting from given vertex.
     */
    private static void dfsForComponent(Graph graph, String vertex, 
                                      Set<String> globalVisited, Set<String> component) {
        // TODO: Implement DFS for component finding
        // Similar to regular DFS but adds vertices to component set
        
        // Your implementation here
    }
}