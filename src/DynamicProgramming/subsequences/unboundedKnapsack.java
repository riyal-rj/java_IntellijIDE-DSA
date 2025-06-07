package DynamicProgramming.subsequences;
import static java.lang.Math.*;

import java.util.Arrays;


public class unboundedKnapsack {
	
	static int []val= {5,11,13};
	static int []wt= {2,4,6};
	static int W=10;
	public static void main(String[] args) {
		
		System.out.println("Maximum Value:  "+solve(2,W));
		
		
		int [][]dp=new int[val.length][W+1];
		for(int[]d:dp)
			Arrays.fill(d, -1);
		
		System.out.println("Maximum Value:  "+solve(2,W,dp));
		
		System.out.println(solve(W));
	}
	static int solve(int ind,int W,int[][]dp)
	{
		if(ind==0)
		{
			return (int)(W/wt[0])*val[0];
		}
		if(dp[ind][W]!=-1)
			return dp[ind][W];
		int notTake=0+solve(ind-1,W,dp);
		int Take=0;
		if(wt[ind]<=W)
			Take=val[ind]+solve(ind,W-wt[ind],dp);
		
		return dp[ind][W]= max(Take,notTake);
		
	}
	static int solve(int ind,int W)
	{
		if(ind==0)
		{
			return (int)(W/wt[0])*val[0];
		}
		
		int notTake=0+solve(ind-1,W);
		int Take=0;
		if(wt[ind]<=W)
			Take=val[ind]+solve(ind,W-wt[ind]);
		
		return max(Take,notTake);
		
	}
	
	static int solve(int W)
	{
		int[][]dp=new int[val.length][W+1];
		
		for(int w=0;w<=W;w++)
			dp[0][w]=(int)(w/wt[0])*val[0];
		
		
		for(int ind=1;ind<val.length;ind++)
		{
			for(int w=0;w<=W;w++)
			{
				int notTake=0+dp[ind-1][w];
				int Take=0;
				if(wt[ind]<=w)
					Take=val[ind]+dp[ind][w-wt[ind]];
				
				dp[ind][w]=max(Take,notTake);
			}
		}
		return dp[val.length-1][W];
	}
	
	

}
