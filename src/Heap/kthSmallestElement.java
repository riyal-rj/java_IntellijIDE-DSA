package Heap;

import java.util.PriorityQueue;

public class kthSmallestElement {
    public static void main(String[] args) {
        int nums[]={1,10,4,5,90,100,-10,-98};
        kthSmallestElement obj=new kthSmallestElement();
        System.out.println(obj.findKthSmall(2,nums));
    }
    int findKthSmall(int k,int []nums)
    {
        if(k==0)
            return nums[0];

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<nums.length;i++)
        {
            maxHeap.add(nums[i]);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
