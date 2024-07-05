import java.util.*;

public class LongestPathInDAG {

    // It is a helper function to insert an edge in a directed graph
    static void addEdge(List<List<Integer>> graph, int u, int v) {
        if (u != v) {
            graph.get(u).add(v);
        }
    }

    // It is a helper function that looks for the longest path in a DAG
    public static int findLongestPath(List<List<Integer>> graph, int V, int start) {

        // Checking for empty graph
        if (V == 0) {
            return 0;
        }

        // Validating starting vertex
        if (start < 0 || start >= V) {
            System.out.println("Invalid starting vertex");
            return -1;
        }
        List<Integer> topoOrder = topologicalSort(graph, V);

        // Initializing distances to all vertices as negative infinity when starting off 
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[start] = 0;

        // Arranging the vertices in the topological order
        for (int u : topoOrder) {
            if (dist[u] != Integer.MIN_VALUE) {
                for (int v : graph.get(u)) {
                    if (dist[v] < dist[u] + 1) {
                        dist[v] = dist[u] + 1;
                    }
                }
            }
        }

        // Finding the maximum distance
        int maxDistance = 0;
        for (int i = 0; i < V; i++) {
            if (dist[i] > maxDistance) {
                maxDistance = dist[i];
            }
        }
        return maxDistance;
    }

    // It is helper function to perform topological sort
    static List<Integer> topologicalSort(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        List<Integer> topoOrder = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, topoOrder);
            }
        }
        Collections.reverse(topoOrder);
        return topoOrder;
    }

    // A helper function used for topological sort
    static void topologicalSortUtil(List<List<Integer>> graph, int v, boolean[] visited, List<Integer> topoOrder) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (!visited[node]) {
                visited[node] = true;
                for (int adj : graph.get(node)) {
                    if (!visited[adj]) {
                        stack.push(adj);
                    }
                }
            } else {
                stack.pop();
                if (!topoOrder.contains(node)) {
                    topoOrder.add(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.println("Enter the number of vertices:");
            int V = scanner.nextInt();
            if (V == 0) {
                System.out.println("The graph has no vertices.");
                return;
            }

            // Adjacency list representation of the graph
            List<List<Integer>> graph = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            System.out.println("Enter the number of edges:");
            int E = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Enter the edges (u,v):");
            for (int i = 0; i < E; i++) {
                String edge = scanner.nextLine().trim();
                String[] parts = edge.split(",");
                int u = Integer.parseInt(parts[0].trim());
                int v = Integer.parseInt(parts[1].trim());
                addEdge(graph, u, v);
            }

            System.out.println("Enter the starting vertex:");
            int start = scanner.nextInt();

            // Finding the longest path from starting vertex
            int longestPathLength = findLongestPath(graph, V, start);
            if (longestPathLength != -1) {
                System.out.println("Longest path length from vertex " + start + ": " + longestPathLength);
            }
        }
        catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter integers only");
        }
        catch (NumberFormatException e) {
        System.out.println("Invalid input format. Please enter the edges in the format u,v");
        } 
        catch (Exception e) {
        System.out.println("Unexpected error occurred: " + e.getMessage());
        }
        finally {
        scanner.close();
        }
    }
}
