import java.util.*;

public class GraphSample {

    private Map<String, List<Edge>> adjacencyList = new HashMap<>();

    // Inner class to represent an edge
    static class Edge {
        String node;
        int weight;

        Edge(String node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public String toString() {
            return "(" + node + ", " + weight + ")";
        }
    }

    // Add a node to the graph
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Add a weighted, undirected edge between two nodes
    public void addEdge(String node1, String node2, int weight) {
        if (adjacencyList.containsKey(node1) && adjacencyList.containsKey(node2)) {
            adjacencyList.get(node1).add(new Edge(node2, weight));
            adjacencyList.get(node2).add(new Edge(node1, weight)); // For undirected graph
        }
    }

    // Display the graph's adjacency list
    public void displayGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.println(node + ": " + adjacencyList.get(node));
        }
    }

    // Perform Breadth-First Search from a given start node
    public List<String> bfs(String startNode) {
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startNode);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (!visited.contains(current)) {
                visited.add(current);
                order.add(current);
                for (Edge edge : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(edge.node)) {
                        queue.add(edge.node);
                    }
                }
            }
        }

        return order;
    }

    public boolean containsNode(String node) {
        return adjacencyList.containsKey(node);
    }

    // Main method to test the graph
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        System.out.println("Welcome to the Graph-Based Pathfinding Simulation!");

        // Add sample nodes
        String[] nodes = {"A", "B", "C", "D", "E"};
        for (String node : nodes) {
            graph.addNode(node);
        }

        // Add sample edges
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 7);
        graph.addEdge("C", "E", 3);
        graph.addEdge("D", "E", 1);

        System.out.println("\nGraph Adjacency List:");
        graph.displayGraph();

        System.out.print("\nEnter the start node for BFS: ");
        String startNode = scanner.nextLine().trim();

        if (graph.containsNode(startNode)) {
            System.out.println("\nBFS Order of Nodes Visited:");
            System.out.println(graph.bfs(startNode));
        } else {
            System.out.println("Error: Start node not found in the graph.");
        }

        scanner.close();
    }
}
