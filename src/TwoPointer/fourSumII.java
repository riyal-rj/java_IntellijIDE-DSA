package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class fourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int n1:nums1)
        {
            for(int n2:nums2)
            {
                int sum1=n1+n2;
                mpp.put(sum1,mpp.getOrDefault(sum1,0)+1);
            }
        }
        int count=0;
        for(int n3:nums3)
        {
            for(int n4:nums4)
            {
                int sum2=n3+n4;
                if(mpp.containsKey(-sum2))
                    count+=mpp.get(-sum2);
            }
        }
        return count;
    }
}
