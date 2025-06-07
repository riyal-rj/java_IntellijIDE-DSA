package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskal_USize {
    static class Edges implements Comparable<Edges>
    {
        private int source;
        private int weight;
        private int destination;

        public Edges(int source, int weight, int destination) {
            this.source = source;
            this.weight = weight;
            this.destination = destination;
        }

        @Override
        public int compareTo(Edges o) {
            return this.weight-o.weight;
        }
    }
    private  int V;
    private List<Edges> edgeList;
    private int [] parent;
    private int[] size;

    public Kruskal_USize(int V) {
        this.V = V;
        edgeList=new ArrayList<Edges>();
        parent=new int[V];
        size=new int[V];
        for(int i=0;i<V;i++)
            parent[i]=i;
        Arrays.fill(size,1);

    }

    int findParent(int node)
    {
        if(node==parent[node])
            return node;
        else
            return parent[node]=findParent(parent[node]);
    }

    void UnionBySize(int u,int v)
    {
        int rootU=findParent(u);
        int rootV=findParent(v);

        if(rootU==rootV)
            return;
        if(size[rootU]>size[rootV])
        {
            parent[rootV]=rootU;
            size[rootU]+=size[rootV];
        }
        else {
            parent[rootU]=rootV;
            size[rootV]+=size[rootU];
        }
    }
    void addEdge(int src,int wt,int dest)
    {
        edgeList.add(new Edges(src,wt,dest));
    }
    void kruskalMST()
    {
        Collections.sort(edgeList);

        List<Edges> mstSet=new ArrayList<>();
        int minCost=0;

        for(Edges edge:edgeList)
        {
            int u=edge.source;
            int v=edge.destination;
            if(findParent(u)!=findParent(v))
            {
                mstSet.add(edge);
                minCost+=edge.weight;
                UnionBySize(u,v);
            }
        }

        System.out.println("Edges in the MST:  ");
        for(Edges edge:mstSet)
            System.out.println(edge.source+"        "+edge.destination+"  :  "+edge.weight);

        System.out.println("Total cost of the MST:  "+minCost);
    }

    public static void main(String[] args) {
        Kruskal_USize krobj=new Kruskal_USize(4);
        krobj.addEdge(0,10,1);
        krobj.addEdge(0,6,2);
        krobj.addEdge(0,5,3);
        krobj.addEdge(1,15,3);
        krobj.addEdge(2,4,3);

        krobj.kruskalMST();
    }
}
