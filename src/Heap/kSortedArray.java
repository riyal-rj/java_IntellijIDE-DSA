package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kSortedArray {
    public static void main(String[] args) {
        int nums1[]={3, 2, 1, 5, 6, 4};
        int nums2[]={13, 8, 10, 7, 15, 14, 12};
        System.out.println(Arrays.toString(kSort(nums1,2)));
        System.out.println(Arrays.toString(kSort(nums2,1)));

    }
    static int []kSort(int []nums,int k)
    {
        if(k<=1)
            return new int[]{0};
        int []result=new int[nums.length];
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int c=0;
        for(int ind=0; ind<nums.length ;ind++)
//            minHeap.add(nums[ind]);
//        for (int ind=k+1;ind<nums.length;ind++)
        {
            minHeap.add(nums[ind]);
            if(minHeap.size()>k)
                result[c++]=minHeap.poll();

        }
        while(!minHeap.isEmpty())
        {
            result[c++]=minHeap.poll();
        }
        return result;
    }
}
