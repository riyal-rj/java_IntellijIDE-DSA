package DynamicProgramming.subsequenceII;

import java.util.Arrays;
import static java.lang.Math.*;
public class longestBitnoicSubsequence {

	public static void main(String[] args) {
		int []nums1= {1,2,5,3,2};
		int []nums2= {1,11,2,10,4,5,2,1};
		int []nums3= {10,20,30};
		int nums4[]= {10,10,10};
		
		System.out.println("\n ============== Example 1 ===============");
		System.out.println("Length of Bitnoic Subsquence is : "+lengthOfbitonicSubsquence(nums1));
		System.out.println("\n ============== Example 2 ===============");
		System.out.println("Length of Bitnoic Subsquence is : "+lengthOfbitonicSubsquence(nums2));
		System.out.println("\n ============== Example 3 ===============");
		System.out.println("Length of Bitnoic Subsquence is : "+lengthOfbitonicSubsquence(nums3));
		System.out.println("\n ============== Example 4 ===============");
		System.out.println("Length of Bitnoic Subsquence is : "+lengthOfbitonicSubsquence(nums4));
		

	}
	
	
	static int lengthOfbitonicSubsquence(int []nums)
	{
		int []dp1=new int[nums.length];
		int dp2[]=new int[nums.length];
		
		Arrays.fill(dp1,1);
		Arrays.fill(dp2, 1);
		for(int curr_ind=0;curr_ind<nums.length;curr_ind++)
		{
			for(int prev_ind=0;prev_ind<curr_ind;prev_ind++)
			{
				if(nums[curr_ind]>nums[prev_ind]   &&
						1+dp1[prev_ind]>dp1[curr_ind])
					dp1[curr_ind]=1+dp1[prev_ind];				
			}
		}
		int maxi=-(int)9e9;
		for(int curr_ind=nums.length-1;curr_ind>=0;curr_ind--)
		{
			for(int prev_ind=nums.length-1;prev_ind>curr_ind;prev_ind--)
			{
				if(nums[curr_ind]>nums[prev_ind]   &&
						1+dp2[prev_ind]>dp2[curr_ind])
					dp2[curr_ind]=1+dp2[prev_ind];				
			}
			
			maxi=max(maxi,dp1[curr_ind]+dp2[curr_ind]-1);
		}
		
		
		return maxi;
	}

}
