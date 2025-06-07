package Heap;

import java.util.PriorityQueue;

public class kClosestFromOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((p2, p1)->
                Integer.compare(p1[0]*p1[0]+p1[1]*p1[1],p2[0]*p2[0]+p2[1]*p2[1]));
        for(int []point:points)
        {
            maxHeap.add(point);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        int [][]result=new int[k][2];
        int ind=0;
        while(!maxHeap.isEmpty())
            result[ind++]=maxHeap.poll();

        return result;
    }

    public static void main(String[] args) {
    }
}
