package Graph;
import java.util.Arrays;

public class FloydWarshall {
    final static int INF = 99999; // Use a large number to represent infinity

    void floydWarshall(int graph[][]) {
        int V = graph.length;
        int dist[][] = new int[V][V];

        // Initialize the solution matrix same as the input graph matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Adding vertices individually to the set of intermediate vertices
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Update dist[i][j] to the minimum distance between i and j
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        int V = dist.length;
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();

        int graph[][] = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        fw.floydWarshall(graph);
    }
}
