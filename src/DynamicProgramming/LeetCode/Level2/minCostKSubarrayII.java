package DynamicProgramming.LeetCode.Level2;

import static java.lang.Math.*;

public class minCostKSubarrayII {
   ;
    static int minCost(int ind,int k,int dist,int [] nums)
    {
        if(k==1)
        {
            int subArrayStart=(int)9e9;
            for(int i=ind;i< nums.length;i++)
                subArrayStart=min(subArrayStart,nums[ind]);
            return subArrayStart;
        }
        if(ind>=nums.length)
            return (int)9e9;
        int cost=(int)9e9;
        int subArrayStart=nums[ind];
        for(int j=ind;j<min(nums.length,ind+dist+1);j++)
        {
            subArrayStart=min(subArrayStart,nums[j]);

            int nextCost=minCost(j+1,k-1,dist,nums);
            if(nextCost!=(int)9e9)
                cost=min(nextCost+subArrayStart,cost);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[]nums1={1,3,2,6,4,2};
        int nums2[]={10,1,2,2,2,1};
        System.out.println(minCost(0,3,3,nums1));
        System.out.println(minCost(0,4,3,nums2));
    }
}
