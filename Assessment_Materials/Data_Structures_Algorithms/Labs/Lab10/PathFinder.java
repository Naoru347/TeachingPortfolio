import java.util.*;

/**
 * Utility class for pathfinding in graphs.
 * Uses BFS to find shortest paths in unweighted graphs.
 * 
 * @author [Your Name]
 */
public class PathFinder {
    
    /**
     * Finds the shortest path between two vertices using BFS.
     * @param graph the graph to search in
     * @param start the starting vertex
     * @param destination the destination vertex  
     * @return list representing shortest path, or null if no path exists
     */
    public static List<String> findShortestPath(Graph graph, String start, String destination) {
        // TODO: Implement shortest path finder
        // Hint: Use GraphTraversals.breadthFirstSearchWithPaths()
        // Then use BFSResult.getShortestPath()
        
        return null; // Replace with your implementation
    }
    
    /**
     * Gets the length of shortest path between two vertices.
     * @param graph the graph to search in
     * @param start the starting vertex
     * @param destination the destination vertex
     * @return length of shortest path, or -1 if no path exists
     */
    public static int getShortestDistance(Graph graph, String start, String destination) {
        // TODO: Implement shortest distance calculator
        // Similar to findShortestPath but return distance instead
        
        return -1; // Replace with your implementation
    }
    
    /**
     * Checks if there is any path between two vertices.
     * @param graph the graph to check
     * @param start the starting vertex
     * @param destination the destination vertex
     * @return true if path exists
     */
    public static boolean pathExists(Graph graph, String start, String destination) {
        // TODO: Implement path existence checker
        // Hint: You can use BFS and check if destination was reached
        
        return false; // Replace with your implementation
    }
    
    /**
     * Finds all vertices reachable from a given starting vertex.
     * @param graph the graph to search
     * @param start the starting vertex
     * @return set of all reachable vertices (including start)
     */
    public static Set<String> findReachableVertices(Graph graph, String start) {
        // TODO: Implement reachable vertices finder
        // Run BFS and return all visited vertices
        
        return new HashSet<>(); // Replace with your implementation
    }
}