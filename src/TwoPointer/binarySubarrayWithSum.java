package TwoPointer;

public class binarySubarrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
    }
    int helper(int []nums,int goal)
    {
        if(goal<0)
            return 0;
        int l=0,r=0,sum=0,count=0;
        while(r<nums.length)
        {
            sum+=nums[r];
            while(sum>goal)
            {
                sum-=nums[l];
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        return count;
    }
}
