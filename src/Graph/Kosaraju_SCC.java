package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Kosaraju_SCC {


    private int V;
    private List<List<Integer>> adjL;

    public Kosaraju_SCC(int V) {
        this.V = V;
        adjL=new ArrayList<>();
        for(int i=0;i<V;i++)
            adjL.add(new ArrayList<>());
    }

    public void addEdge(int u,int v)
    {
        adjL.get(u).add(v);
    }

    private void  dfsOriginal(int curr,boolean[] visited, Stack<Integer> st)
    {
        visited[curr]=true;
        for(int neighbour: adjL.get(curr))
        {
            if(!visited[neighbour])
                dfsOriginal(neighbour,visited,st);
        }
        st.push(curr);
    }

    private Kosaraju_SCC getReversedGraph()
    {
        Kosaraju_SCC revGraph=new Kosaraju_SCC(V);
        for(int i=0;i<V;i++)
        {
            for(int neighbor: adjL.get(i))
                revGraph.addEdge(neighbor,i);
        }
        return revGraph;
    }


    private void dfsReversedGraph(int curr,boolean[]visited,List<Integer> scc)
    {
        visited[curr]=true;
        scc.add(curr);
        for(int neighbor:adjL.get(curr))
            if(!visited[neighbor])
                dfsReversedGraph(neighbor,visited,scc);
    }


    public void findSCC()
    {
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[V];


        for(int i=0;i<V;i++)
            if(!visited[i])
                dfsOriginal(i,visited,st);

        Kosaraju_SCC revG=getReversedGraph();

        Arrays.fill(visited,false);

        int noOfscc=0;
        while (!st.isEmpty())
        {
            int v=st.pop();
            if(!visited[v] &&v!=0)
            {
                List<Integer> scc=new ArrayList<>();
                revG.dfsReversedGraph(v,visited,scc);
                System.out.println("SCC: "+scc);
                noOfscc++;
            }
        }
        System.out.println("No of SCCs are: "+noOfscc);

    }

    public static void main(String[] args) {
        int V=8;
        System.out.println("Example 1:  Graph 1 \n");
        Kosaraju_SCC kscc=new Kosaraju_SCC(V);
        kscc.addEdge(0,1);
        kscc.addEdge(2,0);
        kscc.addEdge(1,2);
        kscc.addEdge(2,3);
        kscc.addEdge(3,4);
        kscc.addEdge(4,5);
        kscc.addEdge(5,6);
        kscc.addEdge(6,4);
        kscc.addEdge(6,7);
        kscc.addEdge(4,7);

        kscc.findSCC();

        System.out.println("Example 2:  Graph 2 \n");
        V=7;
        Kosaraju_SCC kscc1=new Kosaraju_SCC(V+1);
        kscc1.addEdge(1,2);
        kscc1.addEdge(2,3);
        kscc1.addEdge(3,4);
        kscc1.addEdge(2,4);
        kscc1.addEdge(4,1);
        kscc1.addEdge(4,5);
        kscc1.addEdge(3,6);
        kscc1.addEdge(5,6);
        kscc1.addEdge(6,7);
        kscc1.addEdge(7,5);

        kscc1.findSCC();
    }
}
