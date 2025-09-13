import java.util.*;

/**
 * Contains the results of BFS traversal with parent tracking.
 * Used for pathfinding and distance calculations.
 * 
 * @author [Your Name]
 */
public class BFSResult {
    private Map<String, String> parentMap;
    private Map<String, Integer> distanceMap;
    private Set<String> visitedVertices;
    
    /**
     * Creates a new BFS result.
     * @param parentMap map from vertex to its parent in BFS tree
     * @param distanceMap map from vertex to its distance from start
     * @param visitedVertices set of all vertices reached by BFS
     */
    public BFSResult(Map<String, String> parentMap, Map<String, Integer> distanceMap, 
                     Set<String> visitedVertices) {
        this.parentMap = new HashMap<>(parentMap);
        this.distanceMap = new HashMap<>(distanceMap);
        this.visitedVertices = new HashSet<>(visitedVertices);
    }
    
    /**
     * Reconstructs the shortest path from start vertex to destination.
     * @param destination the vertex to find path to
     * @return list representing path from start to destination, or null if unreachable
     */
    public List<String> getShortestPath(String destination) {
        // TODO: Implement path reconstruction
        // Algorithm:
        // 1. Check if destination was reached (is it in visitedVertices?)
        // 2. Follow parent pointers backward from destination
        // 3. Collect vertices in a list
        // 4. Reverse the list to get correct direction
        // 5. Return the path
        
        return null; // Replace with your implementation
    }
    
    /**
     * Gets the distance from start vertex to destination.
     * @param destination the vertex to check distance to
     * @return distance to destination, or -1 if unreachable
     */
    public int getDistance(String destination) {
        // TODO: Implement distance lookup
        // Check if destination is in distanceMap and return its distance
        
        return -1; // Replace with your implementation
    }
    
    /**
     * Checks if a vertex was reached by the BFS.
     * @param vertex the vertex to check
     * @return true if vertex was visited
     */
    public boolean wasReached(String vertex) {
        return visitedVertices.contains(vertex);
    }
    
    /**
     * Gets all vertices that were reached by the BFS.
     * @return set of reached vertices
     */
    public Set<String> getReachedVertices() {
        return new HashSet<>(visitedVertices);
    }
    
    /**
     * Gets the parent of a vertex in the BFS tree.
     * @param vertex the vertex to check
     * @return parent vertex, or null if vertex is start or unreachable
     */
    public String getParent(String vertex) {
        return parentMap.get(vertex);
    }
}