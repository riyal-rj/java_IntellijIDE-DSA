package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int num:nums)
            mpp.put(num,mpp.getOrDefault(num,0)+1);

        PriorityQueue<Pair> minHeap=new PriorityQueue<>((p1,p2)->Integer.compare(p1.freq, p2.freq));
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet())
        {
            minHeap.add(new Pair(entry.getValue(),entry.getKey()));
            if(minHeap.size()>k)
                minHeap.poll();
        }
        int []result=new int[k];
        int ind=0;
        while(!minHeap.isEmpty())
            result[ind++]=minHeap.poll().num;

        return result;
    }
    class Pair
    {
        int freq;
        int num;
        Pair(int freq,int num)
        {
            this.freq=freq;
            this.num=num;
        }
    }

    public static void main(String[] args) {
        topKFrequent obj=new topKFrequent();
        int []nums={1,1,1,2,2,3};
        System.out.println(Arrays.toString(obj.topKFrequent(nums,2)));
    }
    }
