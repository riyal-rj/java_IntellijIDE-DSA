package DynamicProgramming.subsequences;
import static java.lang.Math.*;

import java.util.Arrays;
public class minimumCoins {

	public static void main(String[] args) {
		int []arr= {1,2,3};
		int target=8;
		
		System.out.println(solve(arr, target, arr.length-1));
		
		
		
		int [][]dp=new int [arr.length][target+1];
		for(int []d:dp)
			Arrays.fill(d, -1);
		
		
		System.out.println(solve(arr,dp,target,arr.length-1));
		
		
		
		System.out.println(solve(arr, target));
	}
	
	static int solve(int []arr,int target,int ind)
	{
		if(ind==0)
		{
			if(target%arr[0]==0)
				return target/arr[0];
			else
				return (int)9e9;
		}
		
		
		int notPick=solve(arr,target,ind-1);
		int pick=(int)9e9;
		if(target>=arr[ind])
			pick=1+solve(arr,target-arr[ind],ind);
		
		return min(pick,notPick);
	}
	
	
	static int solve(int []arr,int[][]dp,int target,int ind)
	{
		if(ind==0)
		{
			if(target%arr[0]==0)
				return target/arr[0];
			else
				return (int)9e9;
		}
		
		if(dp[ind][target]!=-1)
			return dp[ind][target];
		int notPick=solve(arr,dp,target,ind-1);
		int pick=(int)9e9;
		if(target>=arr[ind])
			pick=1+solve(arr,dp,target-arr[ind],ind);
		
		return dp[ind][target]=min(pick,notPick);
	}
	
	
	static int solve(int arr[],int target)
	{
		int [][]dp=new int[arr.length][target+1];
		
		
		for(int i=0;i<=target;i++)
			if(i%arr[0]==0)
				dp[0][i]=i/arr[0];
			else
				dp[0][i]=(int)9e9;
		
		
		for(int  ind=1;ind<arr.length;ind++)
		{
			for(int t=0;t<=target;t++)
			{
				int notPick=dp[ind-1][t];
				int pick=(int)9e9;
				if(t>=arr[ind])
					pick=1+dp[ind][t-arr[ind]];
				
				dp[ind][t]=min(pick,notPick);
			}
		}
		
		return dp[arr.length-1][target];
		
	}

}
