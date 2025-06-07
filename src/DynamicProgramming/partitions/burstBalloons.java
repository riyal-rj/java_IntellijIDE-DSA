package DynamicProgramming.partitions;
import static java.lang.Math.*;
import java.util.Arrays;
public class burstBalloons {

	public static void main(String[] args) {
		int[]coins= {3,1,5,8};
		int n=coins.length;
		int []paddCoins=new int[n+2];
		paddCoins[n+1]=1;
		paddCoins[0]=1;
		for(int i=0;i<n;i++)
			paddCoins[i+1]=coins[i];
		System.out.println(Arrays.toString(paddCoins));
		System.out.println("Maximum Cost is: "+f(paddCoins,1,n));
		
		
		int [][]dp=new int [n+1][n+1];
		for(int []d:dp)
			Arrays.fill(d, -1);
		System.out.println("Maximum Cost is : "+f(paddCoins,1,n,dp));
		
		
		System.out.println(f(coins));
	}
	
	static int f(int []coins,int i,int j)
	{
		if(i>j)
			return 0;
		int maxi=-(int)9e9;
		
		for(int k=i;k<=j;k++)
		{
			int cost=coins[i-1]*coins[k]*coins[j+1]+
					f(coins,i,k-1)+f(coins,k+1,j);
			
			maxi=max(maxi,cost);
		}
		
		return maxi;
	}
	
	static int f(int []coins)
	{
		int n=coins.length;
		int []paddCoins=new int[n+2];
		paddCoins[n+1]=1;
		paddCoins[0]=1;
		for(int i=0;i<n;i++)
			paddCoins[i+1]=coins[i];
		int [][]dp=new int [n+2][n+2];
		
		for(int i=n;i>=1;i--) 
		{
			for(int j=1;j<=n;j++)
			{
				if(i>j)
					continue;
				int maxi=-(int)9e9;
				for(int k=i;k<=j;k++)
				{
					int cost=paddCoins[i-1]*paddCoins[k]*paddCoins[j+1]+
							dp[i][k-1]+dp[k+1][j];
					
					maxi=max(maxi,cost);
				}
				dp[i][j]=maxi;
			}
		}
		return dp[1][n];
		
	}
	static int f(int []coins,int i,int j,int [][]dp)
	{
		if(i>j)
			return 0;
		int maxi=-(int)9e9;
		if(dp[i][j]!=-1)
			return dp[i][j];
		for(int k=i;k<=j;k++)
		{
			int cost=coins[i-1]*coins[k]*coins[j+1]+
					f(coins,i,k-1,dp)+f(coins,k+1,j,dp);
			
			maxi=max(maxi,cost);
		}
		
		return dp[i][j]=maxi;
	}

}
