package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Prims{
    static class Edge implements Comparable<Edge>
    {
        private int vertex;
        private int weight;

        public Edge(int vertex,int weight) {
            this.vertex = vertex;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

        static private int V;
        static List<List<Edge>> edgeList;

        Prims(int V)
        {
            this.V=V;
            edgeList=new ArrayList<>();
            for(int i=0;i<V;i++)
                edgeList.add(new ArrayList<>());
        }
        void addEdges(int u,int v,int w)
        {
            edgeList.get(u).add(new Edge(v,w));
            edgeList.get(v).add(new Edge(u,w));
        }

    static  void primsMST()
    {
        boolean [] mstSet=new boolean[V];
        int [] parent=new int[V];
        int [] key=new int[V];

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        key[0]=0;
        Arrays.fill(parent,-1);
        Arrays.fill(key,Integer.MAX_VALUE);
        pq.add(new Edge(0,key[0]));

        while(!pq.isEmpty())
        {
            Edge minEdge=pq.poll();
            int u=minEdge.vertex;
            mstSet[u]=true;

            for (Edge edge:edgeList.get(u))
            {
                int v=edge.vertex;
                int w=edge.weight;
                if(!mstSet[v] && w<key[v])
                {
                    key[v]=w;
                    parent[v]=u;
                    pq.add(new Edge(v,key[v]));
                }
            }
        }
        System.out.println("Edge \tWeight");
        int cost=0;
        for (int i = 1; i < V; i++) {
            cost+=key[i];
            System.out.println(parent[i] + " - " + i + "\t" + key[i]);
        }
        System.out.println("Total Cost is:  "+cost);

    }

    public static void main(String[] args) {
        Prims primsobj=new Prims(9);
        primsobj.addEdges(0,1,4);
        primsobj.addEdges(0,7,8);
        primsobj.addEdges(1,7,11);
        primsobj.addEdges(1,2,8);
        primsobj.addEdges(2,8,2);
        primsobj.addEdges(8,7,7);

        primsobj.addEdges(7,6,1);

        primsobj.addEdges(8,6,6);
        primsobj.addEdges(2,5,4);
        primsobj.addEdges(6,5,2);
        primsobj.addEdges(5,4,10);

        primsobj.addEdges(3,5,14);
        primsobj.addEdges(2,3,7);

        primsobj.addEdges(3,4,9);

        primsMST();




    }

}
