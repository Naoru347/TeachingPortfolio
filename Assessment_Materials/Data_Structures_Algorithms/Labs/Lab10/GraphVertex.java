/**
 * Represents a vertex in a graph.
 * This is a helper class to encapsulate vertex data and state.
 * 
 * @author [Your Name]
 */
public class GraphVertex {
    private String label;
    private int id;
    private boolean visited;  // Useful for some graph algorithms
    
    /**
     * Creates a new graph vertex with the given label.
     * @param label the string identifier for this vertex
     */
    public GraphVertex(String label) {
        this.label = label;
        this.visited = false;
        this.id = -1;  // Can be set later if needed
    }
    
    /**
     * Creates a new graph vertex with label and numeric ID.
     * @param label the string identifier
     * @param id numeric identifier (useful for matrix representation)
     */
    public GraphVertex(String label, int id) {
        this.label = label;
        this.id = id;
        this.visited = false;
    }
    
    // Getters and setters
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isVisited() {
        return visited;
    }
    
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    /**
     * Two vertices are equal if they have the same label.
     * This is important for using vertices in Sets and as Map keys.
     */
    @Override
    public boolean equals(Object obj) {
        // TODO: Implement equals method
        // Hint: Two vertices are equal if their labels are equal
        // Don't forget to check for null and class type!
        return false;
    }
    
    /**
     * Hash code based on label for consistent hashing.
     * Must be implemented whenever equals() is overridden.
     */
    @Override
    public int hashCode() {
        // TODO: Implement hashCode
        // Hint: Use the label's hashCode
        return 0;
    }
    
    @Override
    public String toString() {
        return label;
    }
}