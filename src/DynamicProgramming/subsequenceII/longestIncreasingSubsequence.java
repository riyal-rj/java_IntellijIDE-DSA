package DynamicProgramming.subsequenceII;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Arrays;
public class longestIncreasingSubsequence {

	public static void main(String[] args) {
		int []nums= {10,9,2,5,3,7,101,18};
//		System.out.println(f(0,-1,nums));
		
		
		int [][]dp=new int[nums.length][nums.length+1];
		for(int []d:dp)
			Arrays.fill(d, -1);
//		System.out.println(f(0,-1,nums,dp));
//
//		System.out.println(f(nums));
//		System.out.println(ff(nums));
		System.out.println("Length of LIS is "+mostOptimized(nums));
//		System.out.println(lengthOfLIS(nums));
		System.out.println(solveLIS(nums));
	}
	
	static int lengthOfLIS(int[]nums)
	{
		int maxi=-(int)9e9;
		int dp[]=new int[nums.length];
		Arrays.fill(dp, 1);
		for(int ind=0;ind<nums.length;ind++)
		{
			for(int prev=0;prev<ind;prev++ )
			{
				if(nums[prev]<nums[ind])
					dp[ind]=max(1+dp[prev],dp[ind]);
			}
			maxi=max(maxi,dp[ind]);
		}
		return maxi;
	}
	static int solveLIS(int[]nums)
	{
		int []dp=new int[nums.length];
		Arrays.fill(dp,1);
		int maxi=-(int)9e9;
		for(int currInd=0;currInd< nums.length;currInd++)
		{
			for(int prevInd=0;prevInd<currInd;prevInd++)
			{
				if(nums[currInd]>nums[prevInd]  && 1+dp[prevInd]>dp[currInd])
					dp[currInd]=1+dp[prevInd];
			}
			maxi=max(maxi,dp[currInd]);
		}
		return maxi;
	}
	static int mostOptimized(int[]nums)
	{
		int maxi=-(int)9e9; 
		int dp[]=new int[nums.length];
		Arrays.fill(dp, 1);
		
		int []hash=new int[nums.length];
		int last_ind=0;
		for(int ind=0;ind<nums.length;ind++)
		{
			hash[ind]=ind;
			for(int prevind=0;prevind<ind;prevind++ )
			{
				if(nums[prevind]<nums[ind] && 1+dp[prevind]>dp[ind] )
					{
						dp[ind]=1+dp[prevind];
						hash[ind]=prevind;
					}
			}
			System.out.println(nums[ind]+"--->"+ind+"====>"+Arrays.toString(dp));
			if(maxi<dp[ind])
			{
				maxi=dp[ind];
				last_ind=ind;
			}
		}
		//int []nums= {10,9,2,5,3,7,101,18};
		ArrayList<Integer> lsi=new ArrayList<>();
		lsi.add(nums[last_ind]);
		while(hash[last_ind]!=last_ind)
		{
			last_ind=hash[last_ind];
			lsi.add(nums[last_ind]);
		}
		
		System.out.println("Longest Increasing Susequence is : "+lsi.reversed());
		return maxi ;
	}
	static int ff(int[]nums)
	{
		int []ahead=new int[nums.length+1];
		int []curr=new int[nums.length+1];
		for(int ind=nums.length-1;ind>=0;ind--)
		{
			for(int prev=ind-1;prev>=-1;prev--)
			{
				int notPick=0+ahead[prev+1];
				int pick=-(int)9e9;
				if(prev==-1 || nums[ind]>nums[prev])
				 pick=1+ahead[ind+1];
				curr[prev+1]=max(pick,notPick);
			}
			ahead=curr;
			
		}
		return ahead[0];
	}
	static int f(int[]nums)
	{
		int [][]dp=new int[nums.length+1][nums.length+1];
		for(int []d:dp)
			Arrays.fill(d, 0);
		
		for(int ind=nums.length-1;ind>=0;ind--)
		{
			for(int prev=ind-1;prev>=-1;prev--)
			{
				int notPick=0+dp[ind+1][prev+1];
				int pick=-(int)9e9;
				if(prev==-1 || nums[ind]>nums[prev])
				 pick=1+dp[ind+1][ind+1];
				dp[ind][prev+1]=max(pick,notPick);
			}
			
		}
		
		return dp[0][0];
	}
	static int f(int ind,int prev_ind,int[]nums,int[][]dp)
	{
		if(ind==nums.length)
			return 0;
		if(dp[ind][prev_ind+1]!=-1)
			return dp[ind][prev_ind+1];
		int notPick=0+f(ind+1,prev_ind,nums,dp);
		int pick=-(int)9e9;
		if(prev_ind==-1 || nums[ind]>nums[prev_ind])
			pick=1+f(ind+1,ind,nums,dp);
		
		return dp[ind][prev_ind+1]=max(pick,notPick);
	}
	static int f(int ind,int prev_ind,int []nums)
	{
		if(ind==nums.length)
			return 0;
		
		int notPick=0+f(ind+1,prev_ind,nums);
		int pick=-(int)9e9;
		if(prev_ind==-1 || nums[ind]>nums[prev_ind])
			pick=1+f(ind+1,ind,nums);
		
		return max(pick,notPick);
	}

}
