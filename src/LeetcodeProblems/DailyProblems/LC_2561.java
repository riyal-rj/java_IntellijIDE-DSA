package LeetcodeProblems.DailyProblems;

import java.util.*;
import java.util.Map.Entry;

public class LC_2561 {
    public static void main(String[] args) {
        int []basket1={4,2,2,2};
        int []basket2={1,4,1,2};
        System.out.println(new LC_2561().minCost(basket1, basket2));
    }
    public long minCost(int[]basket1,int[]basket2)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int f1:basket1)
            map.put(f1,map.getOrDefault(f1,0)+1);
        for(int f2:basket2)
            map.put(f2,map.getOrDefault(f2,0)-1);

        List<Integer> ll=new ArrayList<>();
        for(Entry<Integer,Integer> entry:map.entrySet())
        {
            int count=entry.getValue();
            if(count == 0)
                continue;

            if(count%2!=0)
                return -1;

            for(int i=0;i<Math.abs(count)/2;i++)
            {
                ll.add(entry.getKey());
            }
        }

        Collections.sort(ll);

        long mini=Math.min(Arrays.stream(basket1).min().getAsInt(), Arrays.stream(basket2).min().getAsInt());

        long cost=0;
        int s=ll.size();
        for(int i=0;i<s/2;i++)
        {
            cost+= Math.min(ll.get(i), mini*2) ;
        }
        return cost;
    }


}
