package Heap;
import static java.lang.Math.*;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class smallestRangeKLists {
    static int []smallestRange(List<List<Integer>> nums)
    {
        PriorityQueue<int []> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int maxi=(int)-9e9;
        for(int i=0;i<nums.size();i++){
            int val=nums.get(i).get(0);
            minHeap.offer(new int[]{val,i,0});//(value,listIndex,eleIndex)
            maxi=max(maxi,val);
        }

        int minRange=0,maxRange=(int)9e9;

        while(minHeap.size()==nums.size())
        {
            int []curr=minHeap.poll();
            //assert curr != null;
            int mini=curr[0],listInd=curr[1],eleInd=curr[2];
            if((maxi-mini <maxRange-minRange )  || (maxi-mini==maxRange-minRange) && mini<minRange )
            {
                minRange=mini;
                maxRange=maxi;
            }

            if(eleInd+1<nums.get(listInd).size())
            {
                int next=nums.get(listInd).get(eleInd+1);
                minHeap.offer(new int[]{next,listInd,eleInd+1});
                maxi=max(next,maxi);
            }
        }
        return new int[]{minRange,maxRange};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums1 = Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)
        );
        System.out.println(Arrays.toString(smallestRange(nums1))); // Output: [20, 24]

        List<List<Integer>> nums2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        System.out.println(Arrays.toString(smallestRange(nums2)));
    }
}
