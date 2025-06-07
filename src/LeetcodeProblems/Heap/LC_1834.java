package LeetcodeProblems.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_1834 {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int jobList[][]=new int[n][3];
        for(int i=0;i<n;i++)
        {
            jobList[i]=new int[]{tasks[i][0],tasks[i][1],i};
        }

        Arrays.sort(jobList, (j1, j2)->Integer.compare(j1[0],j2[0]));

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->{
            if(a[1]==b[1])
                return Integer.compare(a[2],b[2]);
            return Integer.compare(a[1],b[1]);
        });

        int currTime=0,i=0,idx=0;
        int []result=new int[n];
        while(i<n || !pq.isEmpty())
        {
            while(i<n && jobList[i][0]<=currTime)
            {
                pq.offer(jobList[i]);
                i++;
            }

            if(!pq.isEmpty())
            {
                int []task=pq.poll();
                currTime+=task[1];
                result[idx++]=task[2];
            }
            else
            {
                currTime=jobList[i][0];
            }
        }
        return result;
    }
}
