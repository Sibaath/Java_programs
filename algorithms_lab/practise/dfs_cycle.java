package practise;

import java.util.*;

public class dfs_cycle {

    static class Graph {
        private int vertices;
        private List<List<Integer>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList<>(vertices);

            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new LinkedList<>());
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
        }

        public void depthFirstSearch(int startVertex) {
            boolean[] visited = new boolean[vertices];
            int[] startTime = new int[vertices];
            int[] endTime = new int[vertices];
            int[] predecessor = new int[vertices];

            Arrays.fill(predecessor, -1);

            int time = 0;

            Stack<Integer> stack = new Stack<>();
            stack.push(startVertex);

            while (!stack.isEmpty()) {
                int currentVertex = stack.peek();

                if (!visited[currentVertex]) {
                    visited[currentVertex] = true;
                    startTime[currentVertex] = time++;
                    System.out.println("Visited: " + currentVertex +
                            " (Start Time: " + startTime[currentVertex] +
                            ", Predecessor: " + predecessor[currentVertex] + ")");
                }

                boolean allNeighborsVisited = true;
                for (int neighbor : adjacencyList.get(currentVertex)) {
                    if (!visited[neighbor]) {
                        allNeighborsVisited = false;
                        predecessor[neighbor] = currentVertex;
                        stack.push(neighbor);

                        // Classification of edges (Tree Edge)
                        System.out.println("Tree Edge: " + currentVertex + " -> " + neighbor);
                        break;
                    } else {
                        // Classification of edges (Back Edge, Forward Edge, Cross Edge)
                        classifyEdge(currentVertex, neighbor, startTime, endTime, predecessor);
                    }
                }

                if (allNeighborsVisited) {
                    stack.pop();
                    endTime[currentVertex] = time++;
                    System.out.println("End Time: " + endTime[currentVertex] +
                            " near Node " + currentVertex);
                }
            }
        }

        private void classifyEdge(int currentVertex, int neighbor, int[] startTime, int[] endTime, int[] predecessor) {
            if (predecessor[currentVertex] != neighbor) {
                // Back Edge
                if (startTime[currentVertex] > startTime[neighbor] && endTime[currentVertex] <= endTime[neighbor]) {
                    System.out.println("Back Edge: " + currentVertex + " -> " + neighbor);
                }
                // Forward Edge
                else if (startTime[currentVertex] < startTime[neighbor] && endTime[currentVertex] > endTime[neighbor]) {
                    System.out.println("Forward Edge: " + currentVertex + " -> " + neighbor);
                }
                // Cross Edge
                else if (startTime[currentVertex] > startTime[neighbor] && endTime[currentVertex] > endTime[neighbor]) {
                    System.out.println("Cross Edge: " + currentVertex + " -> " + neighbor);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        Graph graph = new Graph(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (source and destination) separated by space:");

        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = scanner.nextInt();

        System.out.println("Depth-First Search starting from vertex " + startVertex + ":");
        graph.depthFirstSearch(startVertex);

        scanner.close();
    }
}