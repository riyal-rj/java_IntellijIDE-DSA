package DynamicProgramming.partitions;
import static java.lang.Math.*;

import java.util.Arrays;
public class mincostToCutStick {

	public static void main(String[] args) {
		
		int []cuts= {5,6,1,4,2};//{1,3,4,5};
		int n=9;
		int c[]=new int[cuts.length+2];
		c[0]=0;
		c[c.length-1]=n;
		for(int i=0;i<cuts.length;i++)
			c[i+1]=cuts[i];
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		
		System.out.println(minCost(c,1,cuts.length));
		
		int [][]dp=new int[c.length+1][c.length+1];
		for(int[]a:dp)
			Arrays.fill(a, -1);
		System.out.println(minCost(dp,c,1,cuts.length));
		
		System.out.println(minCost(c));
	}
	
	static int minCost(int[]cuts,int i,int j)
	{
		
		if(i>j)
			return 0;
		
		int mini=(int)9e9;
		for(int ind=i;ind<=j;ind++)
		{
			int cost=-cuts[i-1]+cuts[j+1]+
					minCost(cuts,i,ind-1)+minCost(cuts,ind+1,j);
			
			mini=min(cost,mini);
		}
		return mini;
	}
	
	
	static int minCost(int[][]dp,int[]cuts,int i,int j)
	{
		if(i>j)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		int mini=(int)9e9;
		for(int ind=i;ind<=j;ind++)
		{
			int cost=-cuts[i-1]+cuts[j+1]+
					minCost(dp,cuts,i,ind-1)+minCost(dp,cuts,ind+1,j);
			
			mini=min(cost,mini);
		}
		return dp[i][j]=mini;
	}

	static int minCost(int []cuts)
	{
		int n=cuts.length;
		int [][]dp=new int[n][n];
		
		for(int i=n-2;i>=1;i--)
		{
			for(int j=1;j<=n-2;j++)
			{
				if(i>j)
					continue;
				int mini=(int)9e9;
				for(int k=i;k<=j;k++)
				{
					int cost=cuts[j+1]-cuts[i-1]+dp[i][k-1]+dp[k+1][j];
					
					mini=min(mini,cost);
				}
				dp[i][j]=mini;
			}
		}
		return dp[1][n-2];
		
		
	}
}
