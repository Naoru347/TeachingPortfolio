import java.util.*;

/**
 * Graph implementation using adjacency lists.
 * Supports both directed and undirected graphs.
 * 
 * @author [Your Name]
 */
public class Graph {
    private Map<String, GraphVertex> vertices;
    private Map<GraphVertex, List<GraphVertex>> adjacencyList;
    private boolean isDirected;
    private boolean isWeighted;
    
    /**
     * Creates a new empty graph.
     * @param directed true if edges have direction, false for undirected
     */
    public Graph(boolean directed) {
        this.vertices = new HashMap<>();
        this.adjacencyList = new HashMap<>();
        this.isDirected = directed;
        this.isWeighted = false;
    }
    
    /**
     * Creates a new empty graph.
     * @param directed true if edges have direction
     * @param weighted true if edges have weights
     */
    public Graph(boolean directed, boolean weighted) {
        this.vertices = new HashMap<>();
        this.adjacencyList = new HashMap<>();
        this.isDirected = directed;
        this.isWeighted = weighted;
    }
    
    /**
     * Adds a vertex to the graph.
     * @param label the string identifier for the vertex
     * @return true if vertex was added, false if it already exists
     */
    public boolean addVertex(String label) {
        // TODO: Implement addVertex
        // Steps:
        // 1. Check if vertex already exists
        // 2. If not, create new GraphVertex
        // 3. Add to vertices map
        // 4. Initialize empty adjacency list
        // 5. Return appropriate boolean
        
        return false; // Replace with your implementation
    }
    
    /**
     * Adds an unweighted edge to the graph.
     * @param sourceLabel label of source vertex
     * @param destLabel label of destination vertex
     * @return true if edge was added successfully
     */
    public boolean addEdge(String sourceLabel, String destLabel) {
        return addEdge(sourceLabel, destLabel, 1.0);
    }
    
    /**
     * Adds a weighted edge to the graph.
     * @param sourceLabel label of source vertex  
     * @param destLabel label of destination vertex
     * @param weight the weight of the edge
     * @return true if edge was added successfully
     */
    public boolean addEdge(String sourceLabel, String destLabel, double weight) {
        // TODO: Implement addEdge
        // Steps:
        // 1. Ensure both vertices exist (create them if they don't)
        // 2. Get the GraphVertex objects for source and destination
        // 3. Add destination to source's adjacency list
        // 4. If undirected graph, also add source to destination's list
        // 5. Return true if successful
        
        return false; // Replace with your implementation
    }
    
    /**
     * Removes a vertex and all its associated edges.
     * @param label the vertex to remove
     * @return true if vertex existed and was removed
     */
    public boolean removeVertex(String label) {
        // TODO: Implement removeVertex (Optional - can be completed later)
        // This is more complex because you need to remove the vertex
        // from all other vertices' adjacency lists too
        
        return false;
    }
    
    /**
     * Checks if an edge exists between two vertices.
     * @param sourceLabel source vertex label
     * @param destLabel destination vertex label
     * @return true if edge exists
     */
    public boolean hasEdge(String sourceLabel, String destLabel) {
        // TODO: Implement hasEdge
        // Steps:
        // 1. Check if both vertices exist
        // 2. Get source vertex's adjacency list
        // 3. Check if destination vertex is in the list
        
        return false; // Replace with your implementation
    }
    
    /**
     * Gets all neighbors of a vertex.
     * @param vertexLabel the vertex whose neighbors to get
     * @return list of neighboring vertices (empty list if vertex doesn't exist)
     */
    public List<GraphVertex> getNeighbors(String vertexLabel) {
        // TODO: Implement getNeighbors
        // Steps:
        // 1. Check if vertex exists
        // 2. Return its adjacency list, or empty list if vertex doesn't exist
        
        return new ArrayList<>(); // Replace with your implementation
    }
    
    /**
     * Gets all vertex labels in the graph.
     * @return set of all vertex labels
     */
    public Set<String> getAllVertices() {
        return vertices.keySet();
    }
    
    /**
     * Gets the number of vertices in the graph.
     * @return vertex count
     */
    public int getVertexCount() {
        return vertices.size();
    }
    
    /**
     * Gets the number of edges in the graph.
     * @return edge count
     */
    public int getEdgeCount() {
        // TODO: Implement getEdgeCount
        // Hint: Count all entries in all adjacency lists
        // Be careful with undirected graphs (each edge appears twice)
        
        return 0; // Replace with your implementation
    }
    
    /**
     * Checks if the graph is connected (all vertices reachable from each other).
     * @return true if graph is connected
     */
    public boolean isConnected() {
        // TODO: Implement isConnected (Optional - advanced)
        // Hint: Run BFS/DFS from any vertex and see if you reach all vertices
        
        return false;
    }
    
    // Getters for graph properties
    public boolean isDirected() {
        return isDirected;
    }
    
    public boolean isWeighted() {
        return isWeighted;
    }
    
    /**
     * Returns a string representation of the graph.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph (").append(isDirected ? "directed" : "undirected").append("):\n");
        
        for (String vertex : vertices.keySet()) {
            sb.append(vertex).append(": ");
            List<GraphVertex> neighbors = adjacencyList.get(vertices.get(vertex));
            sb.append(neighbors);
            sb.append("\n");
        }
        
        return sb.toString();
    }
}