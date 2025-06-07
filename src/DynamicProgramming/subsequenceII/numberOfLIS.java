package DynamicProgramming.subsequenceII;

import java.util.Arrays;

public class numberOfLIS {

	public static void main(String[] args) {
		int nums1[]= {1,3,5,4,7};
		System.out.println("\n ******************* Example 1 ******************");
		System.out.println("Number of Longest Increasing Subsequence is "+noOfLIS(nums1));
		
		int []nums2= {2,2,2,2,2};
		System.out.println("\n ******************* Example 2 ******************");
		System.out.println("Number of Longest Increasing Subsequence is "+noOfLIS(nums2));
		
		int nums3[]= {1,5,4,3,2,6,7,10,8,9};
		System.out.println("\n ******************* Example 3 ******************");
		System.out.println("Number of Longest Increasing Subsequence is "+noOfLIS(nums3));
	}
	
	
	static int noOfLIS(int []nums)
	{
		
		int []dp=new int[nums.length];
		Arrays.fill(dp, 1);
		int n=nums.length;
		int []countLIS=new int[nums.length];
		Arrays.fill(countLIS,1);
		int maxi=-(int)9e9;
		int maxInd=0;
		for(int curr_ind=0;curr_ind<nums.length;curr_ind++)
		{
			for(int prev_ind=0;prev_ind<curr_ind;prev_ind++)
			{
				if(nums[curr_ind]>nums[prev_ind]  &&
						1+dp[prev_ind]>dp[curr_ind])
					{
						dp[curr_ind]=1+dp[prev_ind];
						countLIS[curr_ind]=countLIS[prev_ind];
					}
				else if(nums[curr_ind]>nums[prev_ind]  &&
						(dp[prev_ind]+1 == dp[curr_ind]))
					{
						countLIS[curr_ind]=countLIS[curr_ind]+countLIS[prev_ind];
					}				
			}
			if(dp[curr_ind]>maxi)
			{
				maxi=dp[curr_ind];
			}
		}
		int nos=0;
		for(int i=0;i<n;i++)
		{
			if(maxi==dp[i])
				nos+=countLIS[i];
		}
		System.out.println("DP Array is    "+Arrays.toString(dp));
		System.out.println("Count Array is "+Arrays.toString(countLIS));
		return nos;
	}

}
