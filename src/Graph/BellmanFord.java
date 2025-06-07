package Graph;

import java.util.Arrays;

class BellmanFord {

    // A class to represent a graph edge
    static class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void bellmanFord(int V, Edge[] edges, int src) {
        // Step 1: Initialize distances from src to all other vertices as INFINITE
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 2: Relax all edges V-1 times
        for (int i = 1; i < V; ++i) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
            System.out.println("After "+i+" th Relaxation the distance array: "+Arrays.toString(dist));

        }

        // Step 3: Check for negative-weight cycles
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                break;
            }
        }

        // Print the shortest distances
       printSolution(dist, V);
    }

    static void printSolution(int[] dist, int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices (A, B, C, D, E, F)
        int E = 7; // Number of edges

        // Edge list for the graph
        Edge[] edges = new Edge[E];
        edges[0] = new Edge(0, 1, 5); // A -> B
        edges[1] = new Edge(1, 2, 1); // B -> C
        edges[2] = new Edge(1, 3, 2); // B -> D
        edges[3] = new Edge(2, 4, 1); // C -> E
        edges[4] = new Edge(4, 3, -1); // E->D
        edges[5] = new Edge(3, 5, 2); // D -> F
        edges[6] = new Edge(5, 4, -3); // F -> E

        // Run Bellman-Ford Algorithm from source A (0)
        bellmanFord(V, edges, 0);
    }
}
