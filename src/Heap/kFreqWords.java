package Heap;

import java.util.*;

public class kFreqWords {
    public static void main(String[] args) {
        kFreqWords obj=new kFreqWords();
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println(obj.topKFrequent(words1, k1)); // Expected output: ["i", "love"]

        // Example 2
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println(obj.topKFrequent(words2, k2));
    }
    List<String>  topKFrequent(String[]words,int k)
    {
        Map<String ,Integer> mpp=new HashMap<>();
        for(String wrd:words)
            mpp.put(wrd,mpp.getOrDefault(wrd,0)+1);
        PriorityQueue<String> minHeap=new PriorityQueue<>((wrd1,wrd2)->
        {
            int cmp=mpp.get(wrd1)-mpp.get(wrd2);
            if(cmp!=0)
                return cmp;
            else
                return wrd1.compareTo(wrd2);
        });
        for(String wrd: mpp.keySet())
        {
            minHeap.add(wrd);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        List<String> result=new ArrayList<>();
        while (!minHeap.isEmpty())
            result.add(minHeap.poll());

        return result;

    }
}
