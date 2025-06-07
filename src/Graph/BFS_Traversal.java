package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal {

   private static ArrayList<ArrayList<Integer>> adjL;
   private static int V;

     BFS_Traversal(int V) {
        this.V = V;
        adjL=new ArrayList<>(V);
        for(int i=0;i<V;i++)
            adjL.add(new ArrayList<>());//Create an empty list for each vertex.
    }

    public  static void bfsOfGraph( int src)
    {

        boolean visited[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        visited[src]=true;
        while (!q.isEmpty())
        {
            int node=q.poll();
            System.out.print(node+" ");
            for(Integer it:adjL.get(node))
            {
                if(!visited[it])
                {
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
    }
    static void makeGraph(int u,int v)
    {
        adjL.get(u).add(v);
        adjL.get(v).add(u);
    }

    public static void main(String[] args) {
        BFS_Traversal bt=new BFS_Traversal(6);
        makeGraph(0,1);
        makeGraph( 0, 2);
        makeGraph( 1, 3);
        makeGraph( 1, 4);
        makeGraph(2,4);
        makeGraph(3,4);
        makeGraph(3,5);
        makeGraph(4,5);
       bfsOfGraph(0);
    }
}
