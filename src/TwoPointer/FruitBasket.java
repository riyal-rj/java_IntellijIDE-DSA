package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
    public static int totalFruits(int []arr)
    {
        int l=0,r=0,maxLen=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(r<arr.length)
        {
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            if(map.size()>2)
            {
                int left_key=arr[l];
                int left_val=map.get(arr[l])-1;
                map.put(left_key,left_val);
                if(map.get(left_key)==0)
                    map.remove(left_key);
                l++;
            }
            if(map.size()<=2)
                maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}
