package DynamicProgramming.stocks;
import static java.lang.Math.*;

import java.util.Arrays;
public class BuySellStockII {

	public static void main(String[] args) {
		int[]prices= {7,1,5,3,6,4};
		System.out.println(f(0,1,prices));
		
		
		int[][]dp=new int[prices.length][2];
		for(int []d:dp)
		Arrays.fill(d, -1);
		System.out.println(f(0,1,prices,dp));
		
		System.out.println(f(prices));
		System.out.println(maxProfit(prices));
		
	}
	static int f(int ind,int buy,int[]prices,int[][]dp)
	{
		if(ind==prices.length)
			return 0;
		if(dp[ind][buy]!=-1)
			return dp[ind][buy];
		if(buy==1)
		{
			return dp[ind][buy]=max(-prices[ind]+f(ind+1,0,prices,dp),0+f(ind+1,1,prices,dp));
		}
		else
		{
			return dp[ind][buy]=max(prices[ind]+f(ind+1,1,prices,dp),0+f(ind+1,0,prices,dp));
		}
		
	}
	static int f(int ind,int buy,int[] prices)
	{
		if(ind==prices.length)
			return 0;
		
		int profit=0;
		if(buy==1)
		{
			profit=max(-prices[ind]+f(ind+1,0,prices),0+f(ind+1,1,prices));
		}
		else
		{
			profit=max(prices[ind]+f(ind+1,1,prices),0+f(ind+1,0,prices));
		}
		return profit;
	}
	
	static int f(int[]prices)
	{
		int[][]dp=new int[prices.length+1][2];
		for(int []d:dp)
		Arrays.fill(d, 0);
		
		dp[prices.length][1]=0;
		dp[prices.length][0]=0;
		
		for(int ind=prices.length-1;ind>=0;ind--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				if(buy==1)
				{
					dp[ind][buy]=max(-prices[ind]+dp[ind+1][0],0+dp[ind+1][1]);
				}
				else
				{
					dp[ind][buy]=max(prices[ind]+dp[ind+1][1],0+dp[ind+1][0]);
				}
			}
		}
		return dp[0][1];
		
	}
	public static int maxProfit(int[] prices) {
       
        int[]ahead=new int[2];
        int []curr=new int[2];
		
		ahead[1]=0;
		ahead[0]=0;
		
		for(int ind=prices.length-1;ind>=0;ind--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				if(buy==1)
				{
					curr[buy]=max(-prices[ind]+ahead[0],0+ahead[1]);
				}
				else
				{
					curr[buy]=max(prices[ind]+ahead[1],0+ahead[0]);
				}
			}
            ahead=curr;
		}
		return ahead[1];
		
    }
	

}
