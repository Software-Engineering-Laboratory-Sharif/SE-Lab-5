import java.util.*;

class MaxFlow {
    static final int V = 6; // Number of vertices in graph

    boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[t];
    }

    int fordFulkerson(int[][] graph, int s, int t) {
        int u, v;

        int[][] rGraph = new int[V][V];
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int[] parent = new int[V];
        int max_flow = 0;

        while (bfs(rGraph, s, t, parent)) {
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }

    int[][] readGraph() {
        Scanner scanner = new Scanner(System.in);
        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix of the graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        MaxFlow m = new MaxFlow();
        int[][] graph = m.readGraph();
        System.out.println("Enter the source vertex: ");
        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();
        System.out.println("Enter the sink vertex: ");
        int sink = scanner.nextInt();
        System.out.println("The maximum possible flow is " +
                           m.fordFulkerson(graph, source, sink));
    }
}
