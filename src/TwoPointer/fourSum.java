package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null || nums.length<4)
            return result;
        int n=nums.length;

        Arrays.sort(nums);
        for(int i=0;i<n-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<n-2;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                long targ=(long)target-nums[i]-nums[j];
                int left=j+1,right=n-1;
                while(left<right)
                {
                    if((long)nums[left]+nums[right]==targ)
                    {
                        result.add(Arrays.asList(nums[left],nums[right],nums[i],nums[j]));
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1])
                            left++;
                        while(left<right && nums[right]==nums[right+1])
                            right--;
                    }
                    else if((long)nums[left]+nums[right]<targ)
                        left++;
                    else
                        right--;
                }

            }

        }
        return result;
    }
}
