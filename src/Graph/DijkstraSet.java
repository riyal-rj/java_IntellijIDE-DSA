package Graph;

import java.util.*;

public class DijkstraSet {
    static class Graph {
        int V;
        List<List<int[]>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int w) {
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
    }

    public static int[] dijkstra(Graph graph, int src, int[] parent) {
        int n = graph.V;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        TreeSet<int[]> set=new TreeSet<>((a,b)->a[1]==b[1]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        set.add(new int[]{src, 0});

        while (!set.isEmpty()) {
            int[] current = set.pollFirst();
            int u = current[0], d = current[1];



            for (int[] neighbor : graph.adj.get(u)) {
                int v = neighbor[0], weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    if(dist[v]!=Integer.MAX_VALUE)
                        set.remove(new int[]{v,dist[v]});
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    set.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }

    public static void printPath(int[] parent, int target) {
        List<Integer> path = new ArrayList<>();
        for (int v = target; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        System.out.println("Path: " + path);
    }

    public static void main(String[] args) {
        int n = 5; // Number of vertices
        Graph graph = new Graph(n);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 1, 4);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 7);

        int source = 0;
        int[] parent = new int[n];
        int[] distances = dijkstra(graph, source, parent);

        System.out.println("Shortest distances from source " + source + ": " + Arrays.toString(distances));
        for (int i = 1; i < n; i++) {
            System.out.println("Path to " + i + " with cost " + distances[i] + ":");
            printPath(parent, i);
        }
    }
}
