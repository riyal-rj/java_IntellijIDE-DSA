package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoruvkasMST {
    static class Edges
    {
        private int source;
        private int destination;
        private int weight;

        public Edges(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    private int V,E;
    private List<Edges> edgeList;
    private int []parent;
    private int [] rank;

    public BoruvkasMST(int v, int e) {
        V = v;
        E = e;
        this.edgeList = new ArrayList<>();
        parent=new int[V];
        rank=new int[V];
        for(int i=0;i<V;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
    }

    void addEdges(int u,int w,int v)
    {
        edgeList.add(new Edges(u,v,w));
    }
    int findParent(int node)
    {
        if(node==parent[node])
            return node;
        else
            return parent[node]=findParent(parent[node]);
    }
    void unionByRank(int u,int v)
    {
        int rootU=findParent(u);
        int rootV=findParent(v);
        if(rootU==rootV)
            return;
        else if(rank[rootU]>rank[rootV])
            parent[rootV]=rootU;
        else if(rank[rootU]<rank[rootV])
            parent[rootU]=rootV;
        else {
            parent[rootU]=rootV;
            rank[rootV]++;
        }
    }
    void boruvkasMST()
    {
        Edges[] cheapest=new Edges[V];
        int numComponents=V;
        int mstWeight=0;
        while(numComponents>1)
        {
            Arrays.fill(cheapest,null);
            for(Edges edge:edgeList)
            {
                int pSrc=findParent(edge.source);
                int pDest=findParent(edge.destination);

                if(pSrc!=pDest)
                {
                    if(cheapest[pSrc]==null||edge.weight<cheapest[pSrc].weight)
                        cheapest[pSrc]=edge;
                    if(cheapest[pDest]==null||edge.weight<cheapest[pDest].weight)
                        cheapest[pDest]=edge;
                }

            }
            for (Edges cheapEdge:cheapest)
            {
                if(cheapEdge!=null)
                {
                    int u=findParent(cheapEdge.source);
                    int v=findParent(cheapEdge.destination);
                    if (u!=v)
                    {
                        mstWeight+=cheapEdge.weight;
                        System.out.println("Edge: "+cheapEdge.source+" - "+cheapEdge.destination+" : "+cheapEdge.weight);
                        unionByRank(u,v);
                        numComponents--;
                    }
                }
            }
        }
        System.out.println("Total cost of MST: "+mstWeight);
    }

    public static void main(String[] args) {
        BoruvkasMST oj=new BoruvkasMST(4,5);
        oj.addEdges(0,10,1);
        oj.addEdges(0,6,2);
        oj.addEdges(0,5,3);
        oj.addEdges(1,15,3);
        oj.addEdges(2,4,3);
        oj.boruvkasMST();
    }
}
