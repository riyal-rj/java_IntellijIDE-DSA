package Graph;

import java.util.ArrayList;

public class DFS_Traversal {
    private static ArrayList<ArrayList<Integer>> adjL;
    private static int V;

    DFS_Traversal(int V) {
        this.V = V;
        adjL=new ArrayList<>(V);
        for(int i=0;i<V;i++)
            adjL.add(new ArrayList<>());//Create an empty list for each vertex.
    }
    public  static  void makeGraph(int u,int v)
    {
        adjL.get(u).add(v);
        adjL.get(v).add(u);
    }
    public  static void dfsTraversal(int src)
    {
        boolean visited[]=new boolean[V];
        dfs(visited,src);
    }
    public  static void dfs(boolean visited[],int src)
    {
        visited[src]=true;
        System.out.println(src+" ");
        for (Integer it:adjL.get(src))
        {
            if(!visited[it]){
                visited[it]=true;
                dfs(visited,it);
            }
        }
    }

    public static void main(String[] args) {
        DFS_Traversal dft=new DFS_Traversal(6);
        makeGraph(0,1);
        makeGraph( 0, 2);
        makeGraph( 1, 3);
        makeGraph( 1, 4);
        makeGraph(2,4);
        makeGraph(3,4);
        makeGraph(3,5);
        makeGraph(4,5);
        dfsTraversal(0);
    }
}
