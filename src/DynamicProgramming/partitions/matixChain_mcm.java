package DynamicProgramming.partitions;
import static java.lang.Math.*;

import java.util.Arrays;
public class matixChain_mcm {

	public static void main(String[] args) {
		int[]arr = {40, 20, 30, 10, 30};
		System.out.println("No of operations are : "+mcm(arr,1,arr.length-1));
		int[][]dp=new int[arr.length][arr.length];
		for(int[]d:dp)
			Arrays.fill(d, -1);
		
		System.out.println("No of operations are : "+mcm(arr,1,arr.length-1,dp));
		System.out.println("No of operations are : "+mcm(arr));
	}
	
	static int mcm(int []arr,int start,int end)
	{
		if(start==end)// single matrix --> thus no multiplication operations
			return 0;
		int mini=(int)9e9;
		for(int k=start;k<end;k++)
		{
			int ops=arr[start-1]*arr[k]*arr[end]+
					mcm(arr,start,k)+mcm(arr,k+1,end);
			
			mini=min(mini,ops);
		}
		
		return mini;
	}
	
	static int mcm(int[]arr,int start,int end,int[][]dp)
	{
		if(start==end)// single matrix --> thus no multiplication operations
			return 0;
		if(dp[start][end]!=-1)
			return dp[start][end];
		int mini=(int)9e9;
		for(int k=start;k<end;k++)
		{
			int ops=arr[start-1]*arr[k]*arr[end]+
					mcm(arr,start,k,dp)+mcm(arr,k+1,end,dp);
			
			mini=min(mini,ops);
		}
		
		return dp[start][end]=mini;
	}
	static int mcm(int []arr)
	{
		int [][]dp=new int[arr.length][arr.length];
		
		for(int i=1;i<arr.length;i++)
			dp[i][i]=0;
		
		
		for(int i=arr.length-1;i>=1;i--)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				int mini=(int)9e9;
				for(int k=i;k<j;k++)
				{
					int ops=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
					
					mini=min(mini,ops);
				}
				dp[i][j]=mini;
			}
		}
		
		
		
		
		return dp[1][arr.length-1];
	}

}
