package LeetcodeContest;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int prevLen=0;
        int currLen=1;
        int k=0;
        for(int i=1;i<n;i++)
        {
            if(nums.get(i)>nums.get(i-1))
                currLen++;
            else
            {
                prevLen=currLen;
                currLen=1;
            }
            k=Math.max(k,Math.max(currLen/2,Math.min(currLen,prevLen)));
        }
        return k;
    }
}
