package DynamicProgramming.subsequences;

import java.util.Arrays;

public class
coinChange2 {
	public static void main(String[] args) {
		int []arr= {1,2,3,4};
		int target=4;
		System.out.println("No of solutions: "+solve(arr,arr.length-1,target));
		//1111
		//13
		//22
		//112
		//4

		String s="sandnakdnkdaj";
		s.length();
		
		
		
		int [][]dp=new int[arr.length][target+1];
		for(int[]d:dp)
			Arrays.fill(d, -1);
		System.out.println("No of solutions: "+solve(arr,dp,arr.length-1,target));
		
		
		System.out.println("No of solutions: "+solve(arr,target));
			
	}
	
	static int solve(int[]arr,int ind,int target)
	{
		if(ind==0)
		{
			return target%arr[0]==0?1:0;
		}
		
		int notPick=solve(arr,ind-1,target);
		int pick=0;
		if(arr[ind]<=target)
			pick=solve(arr,ind,target-arr[ind]);
		
		
		return pick+notPick;
	}
	
	static int solve(int[]arr,int[][]dp,int ind,int target)
	{
		if(ind==0)
		{
			return target%arr[0]==0?1:0;
		}
		if(dp[ind][target]!=-1)
			return dp[ind][target];
		
		int notPick=solve(arr,dp,ind-1,target);
		int pick=0;
		if(arr[ind]<=target)
			pick=solve(arr,dp,ind,target-arr[ind]);
		
		
		return dp[ind][target]=pick+notPick;
	}
	
	
	static int solve(int[]arr,int target)
	{
		int [][]dp=new int[arr.length][target+1];
		
		
		for(int t=0;t<=target;t++)
			if(t%arr[0]==0)
				dp[0][t]=1;
			else
				dp[0][t]=0;
		
		
		for(int ind=1;ind<arr.length;ind++)
		{
			for(int t=0;t<=target;t++)
			{
				int notPick=dp[ind-1][t];
				int pick=0;
				if(arr[ind]<=t)
					pick=dp[ind][t-arr[ind]];
				
				
				dp[ind][t]=pick+notPick;
			}
		}
		return dp[arr.length-1][target];
	}
}
