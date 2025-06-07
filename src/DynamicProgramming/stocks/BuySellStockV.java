package DynamicProgramming.stocks;
import static java.lang.Math.*;

import java.util.Arrays;
public class BuySellStockV {

	public static void main(String[] args) {
		int []prices= {1,2,3,0,2};
		//cooldown ---> cannot buy the next day of sell
		System.out.println(f(0,1,prices));
		
		int [][]dp=new int[prices.length][2];
		for(int[]d:dp)
			Arrays.fill(d, -1);
		
		System.out.println(f(0,1,prices,dp));
		
		System.out.println(f(prices));
	}
	static int f(int []prices)
	{
		int [][]dp=new int[prices.length+2][2];
		for(int[]d:dp)
			Arrays.fill(d, 0);
		
		
		for(int ind=prices.length-1;ind>=0;ind--)
		{
			for(int buy=0;buy<=1;buy++)
			{
				if(buy==1)
					dp[ind][buy]= max(-prices[ind]+dp[ind+1][0],0+dp[ind+1][1]);
				else 
					dp[ind][buy]= max(prices[ind]+dp[ind+2][1],0+dp[ind+1][0]);
			}
		}
		return dp[0][1];
	}
	static int f(int ind,int buy,int []prices)
	{
		if(ind>=prices.length)
			return 0;
		
		if(buy==1)
			return max(-prices[ind]+f(ind+1,0,prices),0+f(ind+1,1,prices));
		else
			return max(prices[ind]+f(ind+2,1,prices),0+f(ind+1,0,prices));
	}
	static int f(int ind,int buy,int []prices,int[][]dp)
	{
		if(ind>=prices.length)
			return 0;
		if(dp[ind][buy]!=-1)
			return dp[ind][buy];
		if(buy==1)
			return dp[ind][buy]=max(-prices[ind]+f(ind+1,0,prices,dp),0+f(ind+1,1,prices,dp));
		else
			return dp[ind][buy]=max(prices[ind]+f(ind+2,1,prices,dp),0+f(ind+1,0,prices,dp));
	}
}
