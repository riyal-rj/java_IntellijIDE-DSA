package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3)
            return null;
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++)
        {
            int left=i+1,right= nums.length-1,pivot=nums[i];

            if(i> 0 && nums[i]==nums[i-1])
                continue;
            while(left<right)
            {
                if(nums[left]+nums[right]+pivot==0)
                {
                    result.add(Arrays.asList(nums[left],nums[right],pivot));
                    while(left<right && nums[left]==nums[left+1])
                        left++;
                    while(left<right && nums[right]==nums[right-1])
                        right--;
                    left++;
                    right--;
                } else if (nums[left]+nums[right]+pivot<0) {
                    left++;
                }
                else {
                    right--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[]={-1,0,1,2,-1,-4};
        int nums2[]={0,1,1};
        System.out.println(threeSum(nums2));
    }
}
