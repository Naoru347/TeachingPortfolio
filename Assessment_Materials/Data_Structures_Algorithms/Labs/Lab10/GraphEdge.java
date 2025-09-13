/**
 * Represents an edge in a graph, connecting two vertices.
 * Supports weighted edges for more advanced applications.
 * 
 * @author [Your Name]
 */
public class GraphEdge {
    private GraphVertex source;
    private GraphVertex destination;
    private double weight;
    
    /**
     * Creates an unweighted edge (weight = 1.0).
     * @param source the starting vertex
     * @param destination the ending vertex
     */
    public GraphEdge(GraphVertex source, GraphVertex destination) {
        this.source = source;
        this.destination = destination;
        this.weight = 1.0;  // Default weight for unweighted graphs
    }
    
    /**
     * Creates a weighted edge.
     * @param source the starting vertex
     * @param destination the ending vertex
     * @param weight the weight/cost of this edge
     */
    public GraphEdge(GraphVertex source, GraphVertex destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    // Getters and setters
    public GraphVertex getSource() {
        return source;
    }
    
    public GraphVertex getDestination() {
        return destination;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        if (weight == 1.0) {
            return source + " -> " + destination;
        } else {
            return source + " -(" + weight + ")-> " + destination;
        }
    }
}