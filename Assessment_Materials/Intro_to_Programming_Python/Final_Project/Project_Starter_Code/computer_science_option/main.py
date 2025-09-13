class Graph:
    """
    A simple representation of a graph using an adjacency list.
    """
    def __init__(self):
        self.adjacency_list = {}
    
    def add_node(self, node):
        """
        Adds a node to the graph.
        """
        if node not in self.adjacency_list:
            self.adjacency_list[node] = []
    
    def add_edge(self, node1, node2, weight=1):
        """
        Adds a weighted edge between two nodes.
        """
        if node1 in self.adjacency_list and node2 in self.adjacency_list:
            self.adjacency_list[node1].append((node2, weight))
            self.adjacency_list[node2].append((node1, weight))  # For undirected graph

    def display_graph(self):
        """
        Displays the graph's adjacency list.
        """
        for node, edges in self.adjacency_list.items():
            print(f"{node}: {edges}")


def bfs(graph, start_node):
    """
    Performs Breadth-First Search (BFS) on the graph from the start_node.
    Returns the list of nodes visited in order.
    """
    visited = set()
    queue = [start_node]
    order = []
    
    while queue:
        current = queue.pop(0)
        if current not in visited:
            visited.add(current)
            order.append(current)
            for neighbor, _ in graph.adjacency_list.get(current, []):
                if neighbor not in visited:
                    queue.append(neighbor)
    
    return order


def main():
    print("Welcome to the Graph-Based Pathfinding Simulation!")

    # Create a sample graph
    graph = Graph()
    nodes = ["A", "B", "C", "D", "E"]
    for node in nodes:
        graph.add_node(node)
    
    edges = [
        ("A", "B", 2),
        ("A", "C", 4),
        ("B", "C", 1),
        ("B", "D", 7),
        ("C", "E", 3),
        ("D", "E", 1)
    ]
    for node1, node2, weight in edges:
        graph.add_edge(node1, node2, weight)
    
    print("\nGraph Adjacency List:")
    graph.display_graph()

    # Perform BFS
    start_node = input("\nEnter the start node for BFS: ").strip()
    if start_node in graph.adjacency_list:
        print("\nBFS Order of Nodes Visited:")
        print(bfs(graph, start_node))
    else:
        print("Error: Start node not found in the graph.")

if __name__ == "__main__":
    main()
