package LeetcodeContest;

import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        int []dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=n-2;i>=0;i--)
        {
            if(nums.get(i)<nums.get(i+1))
                dp[i]=dp[i+1]+1;
        }
        for(int i=0;i<n-k;i++)
            if(dp[i]>=k && dp[i+k]>=k)
                return true;
        return false;

    }
}
