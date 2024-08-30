package chinesePostman;
import java.util.*;

public class ChinesePostman {
    final static int INF = 99999;

    // Function to find the shortest path using the Floyd-Warshall algorithm
    private void floydWarshall(int[][] graph, int[][] dist) {
        int V = graph.length;
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    // Function to find the pairs of odd degree vertices and return their minimum pairing cost
    private int minimumMatching(int[][] dist, List<Integer> odds) {
        int n = odds.size();
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) Arrays.fill(row, INF);

        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue;
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;
                    dp[mask | (1 << v)][v] = Math.min(dp[mask | (1 << v)][v], dp[mask][u] + dist[odds.get(u)][odds.get(v)]);
                }
            }
        }

        int res = INF;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[(1 << n) - 1][i]);
        }

        return res;
    }

    // Function to calculate the shortest Chinese Postman Route
    public int chinesePostman(int[][] graph) {
        int V = graph.length;

        // Calculate all-pairs shortest paths
        int[][] dist = new int[V][V];
        floydWarshall(graph, dist);

        // Find vertices with odd degree
        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            int degree = 0;
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != INF && graph[i][j] != 0) degree++;
            }
            if (degree % 2 != 0) odds.add(i);
        }

        // If there are no odd-degree vertices, the graph has an Eulerian circuit
        if (odds.size() == 0) return Arrays.stream(dist[0]).sum();

        // Calculate the minimum cost to pair odd-degree vertices
        int minMatchingCost = minimumMatching(dist, odds);

        // The shortest route is the original graph's weight + minMatchingCost
        return Arrays.stream(dist[0]).sum() + minMatchingCost;
    }

    public static void main(String[] args) {
        ChinesePostman cpp = new ChinesePostman();

        int graph[][] = {
            {0, 1, 2, INF},
            {1, 0, 4, 6},
            {2, 4, 0, 3},
            {INF, 6, 3, 0}
        };

        int result = cpp.chinesePostman(graph);
        System.out.println("The length of the shortest Chinese Postman route is: " + result);
    }
}
