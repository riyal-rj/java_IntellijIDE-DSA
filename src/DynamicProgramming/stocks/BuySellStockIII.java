package DynamicProgramming.stocks;
import static java.lang.Math.*;

import java.util.Arrays;
public class BuySellStockIII {

	public static void main(String[] args) {
		int[]prices= {3,3,5,0,0,3,1,4};
		System.out.println(f(prices,0,2,1));
		
		
		int [][][]dp=new int[prices.length][2][3];
		for(int[][]a:dp)
			for(int []b:a)
				Arrays.fill(b, -1);
		System.out.println(f(prices,0,2,1,dp));
		
		
		System.out.println(f(prices));
		System.out.println(ff(prices));
	}
	static int f(int[]prices,int ind,int transac,int buy,int[][][]dp)
	{
		if(transac==0)
			return 0;
		if(ind==prices.length)
			return 0;
		if(dp[ind][buy][transac]!=-1)
			return dp[ind][buy][transac];
		if(buy==1)
			return dp[ind][buy][transac]=max(-prices[ind]+f(prices,ind+1,transac,0,dp),0+f(prices,ind+1,transac,1,dp));
		else
			return dp[ind][buy][transac]=max(prices[ind]+f(prices,ind+1,transac-1,1,dp),0+f(prices,ind+1,transac,0,dp));
	}

	
	static int f(int[]prices)
	{
		int [][][]dp=new int[prices.length+1][2][3];
		for(int[][]a:dp)
			for(int []b:a)
				Arrays.fill(b, 0);
		int n=prices.length;
		
		for(int ind=0;ind<=n;ind++)
		{
			for(int buy=0;buy<=1;buy++)
				dp[ind][buy][0]=0;
		}
		
		for(int buy=0;buy<=1;buy++)
		{
			for(int tr=0;tr<=2;tr++)
				dp[n][buy][tr]=0;
		}
		
		
		for(int ind=n-1;ind>=0;ind--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				for(int tr=1;tr<=2;tr++)
				{
					if(buy==1)
						dp[ind][buy][tr]=max(-prices[ind]+dp[ind+1][0][tr],
								0+dp[ind+1][1][tr]);
					else
						dp[ind][buy][tr]=max(prices[ind]+dp[ind+1][1][tr-1],
								0+dp[ind+1][0][tr]);
				}
			}
		}
		
		return dp[0][1][2];
	}
	
	static int f(int[]prices,int ind,int transac,int buy)
	{
		if(transac==0)
			return 0;
		if(ind==prices.length)
			return 0;
		
		if(buy==1)
			return max(-prices[ind]+f(prices,ind+1,transac,0),0+f(prices,ind+1,transac,1));
		else
			return max(prices[ind]+f(prices,ind+1,transac-1,1),0+f(prices,ind+1,transac,0));
	}
	
	static int ff(int[]prices)
	{
		int[][]ahead=new int[2][3];
		int curr[][]=new int[2][3];
		int n=prices.length;
		for(int ind=n-1;ind>=0;ind--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				for(int tr=1;tr<=2;tr++)
				{
					if(buy==1)
						curr[buy][tr]=max(-prices[ind]+ahead[0][tr],
								0+ahead[1][tr]);
					else
						curr[buy][tr]=max(prices[ind]+ahead[1][tr-1],
								0+ahead[0][tr]);
				}
				ahead=curr;
			}
		}
		
		return ahead[1][2];
		
	}

}
